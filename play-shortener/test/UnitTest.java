import controllers.AliasController;
import models.Alias;
import models.AliasRepository;
import org.junit.Test;
import play.data.FormFactory;
import play.data.format.Formatters;
import play.i18n.MessagesApi;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import play.mvc.Result;
import play.twirl.api.Content;

import javax.validation.Validator;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ForkJoinPool;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static play.mvc.Http.Status.OK;
import static play.mvc.Http.Status.SEE_OTHER;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.invokeWithContext;

public class UnitTest {

    @Test
    public void checkIndex() {
        AliasRepository repository = mock(AliasRepository.class);
        FormFactory formFactory = mock(FormFactory.class);
        HttpExecutionContext ec = new HttpExecutionContext(ForkJoinPool.commonPool());
        final AliasController controller = new AliasController(formFactory, repository, ec);
        final Result result = controller.index();

        assertThat(result.status()).isEqualTo(OK);
    }

    @Test
    public void checkTemplate() {
        Content html = views.html.index.render("1");
        assertThat(html.contentType()).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Add Alias");
    }

    @Test
    public void checkAddAlias() {
        // Easier to mock out the form factory inputs here
        MessagesApi messagesApi = mock(MessagesApi.class);
        Validator validator = mock(Validator.class);
        FormFactory formFactory = new FormFactory(messagesApi, new Formatters(messagesApi), validator);

        // Don't need to be this involved in setting up the mock, but for demo it works:
        AliasRepository repository = mock(AliasRepository.class);
        Alias alias = new Alias();
        alias.id = 1;
        alias.name = "http://www.apple.com/iphone-7/";
        when(repository.add(any())).thenReturn(supplyAsync(() -> alias));

        // Set up the request builder to reflect input
        final Http.RequestBuilder requestBuilder =
            new Http.RequestBuilder().method("post").bodyJson(Json.toJson(alias));

        // Add in an Http.Context here using invokeWithContext:
        final CompletionStage<Result> stage = invokeWithContext(requestBuilder, () -> {
            HttpExecutionContext ec = new HttpExecutionContext(ForkJoinPool.commonPool());

            // Create controller and call method under test:
            final AliasController controller = new AliasController(formFactory, repository, ec);
            return controller.addAlias();
        });

        // Test the completed result
        await().atMost(1, SECONDS).until(() ->
            assertThat(stage.toCompletableFuture()).isCompletedWithValueMatching(result ->
                result.status() == SEE_OTHER, "Should redirect after operation"
            )
        );
    }

}
