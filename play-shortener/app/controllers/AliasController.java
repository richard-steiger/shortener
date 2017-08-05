package controllers;

import models.Alias;
import models.AliasRepository;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link play.libs.concurrent.HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class AliasController extends Controller {

    private final FormFactory formFactory;
    private final AliasRepository aliasRepository;
    private final HttpExecutionContext ec;
    private final String baseUrl = "localhost:9000/";
    private String lastId;

    @Inject
    public AliasController(FormFactory formFactory, AliasRepository aliasRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.aliasRepository = aliasRepository;
        this.ec = ec;
    }

    public Result index() {
        return ok(views.html.index.render(lastId));
    }

    public CompletionStage<Result> addAlias() {
        Alias alias = formFactory.form(Alias.class).bindFromRequest().get();
        return aliasRepository.add(alias).thenApplyAsync(a -> {
            lastId = baseUrl + a.id;
            return redirect(routes.AliasController.index());
        }, ec.current());
    }

    @play.db.jpa.Transactional
    public Result followAlias(String address) {
        lastId = null;
        try {
             int id = Integer.parseInt(address);
             Alias a = aliasRepository.findById(id);
             if (a != null)
                 return redirect(a.name);
         } catch(NumberFormatException nfe) {
         }
        return redirect(address);
    }
}
