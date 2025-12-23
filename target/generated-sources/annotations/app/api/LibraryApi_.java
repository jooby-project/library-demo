package app.api;

@io.jooby.annotation.Generated(LibraryApi.class)
public class LibraryApi_ implements io.jooby.Extension {
    protected java.util.function.Function<io.jooby.Context, LibraryApi> factory;

    public LibraryApi_() {
      this(LibraryApi.class);
    }

    public LibraryApi_(Class<LibraryApi> type) {
      setup(ctx -> ctx.require(type));
    }

    public LibraryApi_(LibraryApi instance) {
       setup(ctx -> instance);
    }

    public LibraryApi_(io.jooby.SneakyThrows.Supplier<LibraryApi> provider) {
       setup(ctx -> (LibraryApi) provider.get());
    }

    public LibraryApi_(io.jooby.SneakyThrows.Function<Class<LibraryApi>, LibraryApi> provider) {
       setup(ctx -> provider.apply(LibraryApi.class));
    }

    private void setup(java.util.function.Function<io.jooby.Context, LibraryApi> factory) {
        this.factory = factory;
    }

    public void install(io.jooby.Jooby app) throws Exception {
      /** See {@link LibraryApi#getBook(String) */
      app.get("/library/books/{isbn}", this::getBook);

      /** See {@link LibraryApi#searchBooks(String) */
      app.get("/library/search", this::searchBooks);

      /** See {@link LibraryApi#getBooksByTitle(String, int, int) */
      app.get("/library/books", this::getBooksByTitle);

      /** See {@link LibraryApi#addBook(app.model.Book) */
      app.post("/library/books", this::addBook);
    }

    public app.model.Book getBook(io.jooby.Context ctx) {
      var c = this.factory.apply(ctx);
      return c.getBook(ctx.path("isbn").valueOrNull());
    }

    public java.util.List<app.model.Book> searchBooks(io.jooby.Context ctx) {
      var c = this.factory.apply(ctx);
      return c.searchBooks(ctx.query("q").valueOrNull());
    }

    public jakarta.data.page.Page<app.model.Book> getBooksByTitle(io.jooby.Context ctx) {
      var c = this.factory.apply(ctx);
      return c.getBooksByTitle(ctx.query("title").valueOrNull(), ctx.query("page").intValue(), ctx.query("size").intValue());
    }

    public app.model.Book addBook(io.jooby.Context ctx) {
      var c = this.factory.apply(ctx);
      return c.addBook(ctx.body(app.model.Book.class));
    }
}
