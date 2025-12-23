package app.api;

import app.model.Book;
import app.repo.Library;
import io.jooby.annotation.*;
import io.jooby.exception.NotFoundException;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.inject.Inject;

import java.util.List;

/**
 * The Public Front Desk of the library.
 *
 */
@Path("/library")
public class LibraryApi {

  private final Library library;

  @Inject
  public LibraryApi(Library library) {
    this.library = library;
  }

  /**
   * Get Specific Book Details
   * <p>
   * View the full information for a single specific book using its unique ISBN.
   * </p>
   *
   * @param isbn The unique ID from the URL (e.g., /books/978-3-16-148410-0)
   * @return The book data
   * @throws NotFoundException <code>404</code> error if it doesn't exist.
   * @tag Library
   * @securityRequirement librarySecurity read:books
   */
  @GET
  @Path("/books/{isbn}")
  public Book getBook(@PathParam String isbn) {
    return library.findBook(isbn)
        .orElseThrow(() -> new NotFoundException(isbn));
  }

  /**
   * Quick Search
   * <p>Find books by a partial title (e.g., searching "Harry" finds "Harry Potter").
   *
   * @param q The word or phrase to search for.
   * @return A list of books matching that term.
   * @x-badges [{name:Beta, position:before, color:purple}]
   * @tag Library
   * @securityRequirement librarySecurity read:books
   */
  @GET
  @Path("/search")
  public List<Book> searchBooks(@QueryParam String q) {
    var pattern = "%" + (q != null ? q : "") + "%";

    return library.searchBooks(pattern);
  }

  /**
   * Browse Books (Paginated)
   * <p>Look up a specific book title where there might be many editions or copies, splitting the results into
   * manageable pages.
   *
   * @param title The exact book title to filter by.
   * @param page  Which page number to load (defaults to 1).
   * @param size  How many books to show per page (defaults to 20).
   * @return A "Page" object containing the books and info like "Total Pages: 5".
   * @tag Library
   * @securityRequirement librarySecurity read:books
   */
  @GET
  @Path("/books")
  public Page<Book> getBooksByTitle(@QueryParam String title,
                                    @QueryParam int page,
                                    @QueryParam int size) {
    // Ensure we have sensible defaults if the user sends nothing
    int pageNum = page > 0 ? page : 1;
    int pageSize = size > 0 ? size : 20;

    // Ask the database for just this specific slice of data
    return library.findBooksByTitle(title, PageRequest.ofPage(pageNum).size(pageSize));
  }

  /**
   * Add New Book
   *
   * <p>Register a new book in the system.
   *
   * @param book New book to add.
   * @return A text message confirming success.
   * @throws io.jooby.exception.BadRequestException <code>400</code> On bad book data.
   * @tag Inventory
   * @securityRequirement librarySecurity write:books
   */
  @POST
  @Path("/books")
  public Book addBook(Book book) {
    // Save it
    return library.add(book);
  }
}
