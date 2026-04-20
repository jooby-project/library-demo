package app;

import app.api.LibraryApi_;
import app.model.Address;
import app.model.Author;
import app.model.Book;
import app.model.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.jooby.Jooby;
import io.jooby.OpenAPIModule;
import io.jooby.flyway.FlywayModule;
import io.jooby.guice.GuiceModule;
import io.jooby.hibernate.HibernateModule;
import io.jooby.hibernate.TransactionalRequest;
import io.jooby.hikari.HikariModule;
import io.jooby.jackson.Jackson2Module;
import io.jooby.netty.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;

/**
 * Library API.
 * <p>
 * An imaginary, but delightful Library API for interacting with library services and information.
 * Built with love by https://jooby.io.
 * </p>
 *
 * @version 1.0.0
 * @license.name Apache 2.0
 * @license.url http://www.apache.org/licenses/LICENSE-2.0.html
 * @contact.name Jooby Demo
 * @contact.url https://jooby.io
 * @contact.email support@jooby.io
 * @server.url https://library.jooby.io
 * @securityScheme.name librarySecurity
 * @securityScheme.type apiKey
 * @securityScheme.in header
 * @securityScheme.paramName X-Auth
 * @securityScheme.flows.implicit.authorizationUrl https://library.jooby.io/auth
 * @securityScheme.flows.implicit.scopes.name [write:books, read:books, write:author]
 * @securityScheme.flows.implicit.scopes.description [modify books in your account, read books, modify/create author]
 * @x-logo.url https://redoredocly.github.io/redoc/museum-logo.png
 * @tag Library. Outlines the available actions in the Library System API. The system is designed to allow users to search for books, view details, and manage the library inventory.
 * @tag Inventory. Managing Inventory
 */
public class App extends Jooby {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    {
        // Enable Virtual Threads
        setDefaultWorker(Executors.newVirtualThreadPerTaskExecutor());

        // Dependency Injection
        install(new GuiceModule());

        // JSON
        ObjectMapper objectMapper = Jackson2Module.create().
                setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        install(new Jackson2Module(objectMapper));

        /* Documentation */
        install(new OpenAPIModule());
        // Publish generated files
        assets("/docs/?*", "/app");

        /* Database */
        install(new HikariModule());
        install(new FlywayModule());
        install(new HibernateModule(Book.class, Author.class, Publisher.class, Address.class));

        /* Middleware */
        use(new TransactionalRequest().useStatelessSession());

        /* Controller */
        mvc(new LibraryApi_());

        onStarted(() -> {
            log.info("\n\nTry live docs at: \n  http://localhost:8080/docs\n  http://localhost:8080/docs/full.html\n  http://localhost:8080/docs/tryIt.html\n\n  http://localhost:8080/redoc\n  http://localhost:8080/swagger\n");
        });
    }

    public static void main(final String[] args) {
        runApp(args, new NettyServer(), App::new);
    }
}
