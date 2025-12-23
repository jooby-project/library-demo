package app.repo;

import app.model.Author;
import app.model.Book;
import app.model.Book_;
import jakarta.data.exceptions.DataException;
import jakarta.data.exceptions.EntityExistsException;
import jakarta.data.exceptions.OptimisticLockingFailureException;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.data.page.impl.PageRecord;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import org.hibernate.StaleStateException;
import org.hibernate.StatelessSession;
import org.hibernate.exception.ConstraintViolationException;
import static org.hibernate.query.Order.asc;
import static org.hibernate.query.SortDirection.*;
import org.hibernate.query.specification.SelectionSpecification;

/**
 * Implements Jakarta Data repository {@link app.repo.Library}
 **/
public class Library_ implements Library {

	
	/**
	 * @see #searchBooks(String)
	 **/
	static final String SEARCH_BOOKS_String = "from Book where title like :pattern order by title";
	
	/**
	 * @see #findRecentBookTitles(int)
	 **/
	static final String FIND_RECENT_BOOK_TITLES_int = "select title from Book where extract(year from publicationDate) >= :minYear";

	
	protected StatelessSession session;
	
	@Inject
	public Library_(StatelessSession session) {
		this.session = session;
	}
	
	@Override
	public StatelessSession session() {
		return session;
	}
	
	@Override
	public Book add(Book book) {
		requireNonNull(book, "Null book");
		try {
			session.insert(book);
		}
		catch (ConstraintViolationException _ex) {
			throw new EntityExistsException(_ex.getMessage(), _ex);
		}
		catch (PersistenceException _ex) {
			throw new DataException(_ex.getMessage(), _ex);
		}
		return book;
	}
	
	@Override
	public void update(Author author) {
		requireNonNull(author, "Null author");
		try {
			session.update(author);
		}
		catch (StaleStateException _ex) {
			throw new OptimisticLockingFailureException(_ex.getMessage(), _ex);
		}
		catch (PersistenceException _ex) {
			throw new DataException(_ex.getMessage(), _ex);
		}
	}
	
	@Override
	public void remove(Book book) {
		requireNonNull(book, "Null book");
		try {
			session.delete(book);
		}
		catch (StaleStateException _ex) {
			throw new OptimisticLockingFailureException(_ex.getMessage(), _ex);
		}
		catch (PersistenceException _ex) {
			throw new DataException(_ex.getMessage(), _ex);
		}
	}
	
	/**
	 * Find {@link Book} by {@link Book#isbn isbn}.
	 *
	 * @see app.repo.Library#findBook(String)
	 **/
	@Override
	public Optional<Book> findBook(String isbn) {
		requireNonNull(isbn, "Null isbn");
		try {
			return ofNullable(session.get(Book.class, isbn));
		}
		catch (PersistenceException _ex) {
			throw new DataException(_ex.getMessage(), _ex);
		}
	}
	
	/**
	 * Find {@link Author} by {@link Author#ssn ssn}.
	 *
	 * @see app.repo.Library#findAuthor(String)
	 **/
	@Override
	public Optional<Author> findAuthor(String ssn) {
		requireNonNull(ssn, "Null ssn");
		try {
			return ofNullable(session.get(Author.class, ssn));
		}
		catch (PersistenceException _ex) {
			throw new DataException(_ex.getMessage(), _ex);
		}
	}
	
	/**
	 * Find {@link Book} by {@link Book#title title}.
	 *
	 * @see app.repo.Library#findBooksByTitle(String,PageRequest)
	 **/
	@Override
	public Page<Book> findBooksByTitle(String title, PageRequest pageRequest) {
		requireNonNull(title, "Null title");
		var _builder = session.getCriteriaBuilder();
		var _query = _builder.createQuery(Book.class);
		var _entity = _query.from(Book.class);
		_query.where(
				_builder.equal(_entity.get(Book_.title), title)
		);
		var _spec = SelectionSpecification.create(_query);
		_spec.sort(asc(Book.class, "title"));
		try {
			long _totalResults = 
					pageRequest.requestTotal()
							? _spec.createQuery(session)
									.getResultCount()
							: -1;
			var _results = _spec.createQuery(session)
				.setFirstResult((int) (pageRequest.page()-1) * pageRequest.size())
				.setMaxResults(pageRequest.size())
				.getResultList();
			return new PageRecord<>(pageRequest, _results, _totalResults);
		}
		catch (PersistenceException _ex) {
			throw new DataException(_ex.getMessage(), _ex);
		}
	}
	
	/**
	 * Execute the query {@value #SEARCH_BOOKS_String}.
	 *
	 * @see app.repo.Library#searchBooks(String)
	 **/
	@Override
	public List<Book> searchBooks(String pattern) {
		try {
			return session.createSelectionQuery(SEARCH_BOOKS_String, Book.class)
				.setParameter("pattern", pattern)
				.getResultList();
		}
		catch (PersistenceException _ex) {
			throw new DataException(_ex.getMessage(), _ex);
		}
	}
	
	/**
	 * Execute the query {@value #FIND_RECENT_BOOK_TITLES_int}.
	 *
	 * @see app.repo.Library#findRecentBookTitles(int)
	 **/
	@Override
	public List<String> findRecentBookTitles(int minYear) {
		try {
			return session.createSelectionQuery(FIND_RECENT_BOOK_TITLES_int, String.class)
				.setParameter("minYear", minYear)
				.getResultList();
		}
		catch (PersistenceException _ex) {
			throw new DataException(_ex.getMessage(), _ex);
		}
	}

}

