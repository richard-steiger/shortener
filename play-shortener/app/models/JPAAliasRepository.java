package models;

import play.db.jpa.JPAApi;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static play.db.jpa.JPA.em;
import static play.libs.Json.toJson;
import static play.mvc.Results.ok;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPAAliasRepository implements AliasRepository {

  private final JPAApi jpaApi;
  private final DatabaseExecutionContext executionContext;

  @Inject
  public JPAAliasRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
    this.jpaApi = jpaApi;
    this.executionContext = executionContext;
  }

  @Override
  public CompletionStage<Alias> add(Alias alias) {
    return supplyAsync(() -> jpaApi.withTransaction(em -> {
      // lookup existing alias
      TypedQuery<Alias> q = em.createQuery("from Alias a where a.name = :name", Alias.class);
      q.setParameter("name", alias.name);
      List<Alias> results = q.getResultList();

      // if one exists, return it, else store and return the new one
      if(!results.isEmpty()) {
        return results.get(0);
      } else {
        em.persist(alias);
        return alias;
      }
    }), executionContext);
  }

  @Override
  public Alias findById(int id) {
    return jpaApi.em().find(Alias.class, id);
  }

}
