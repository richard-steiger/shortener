package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * <code>AliasRepository</code> defines the behavior of the non-blocking
 * repo holding aliases.
 */
@ImplementedBy(JPAAliasRepository.class)
public interface AliasRepository {
  /**
   * Adds the <code>alias</code>.
   */
  CompletionStage<Alias> add(Alias alias);

  /**
   * Returns the alias having <code>id</code>, or null if none exists.
   */
  Alias findById(int id);
}
