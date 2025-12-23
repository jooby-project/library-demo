package app.model;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

/**
 * Static metamodel for {@link app.model.Book}
 **/
@StaticMetamodel(Book.class)
public abstract class Book_ {

	
	/**
	 * @see #isbn
	 **/
	public static final String ISBN = "isbn";
	
	/**
	 * @see #title
	 **/
	public static final String TITLE = "title";
	
	/**
	 * @see #publicationDate
	 **/
	public static final String PUBLICATION_DATE = "publicationDate";
	
	/**
	 * @see #text
	 **/
	public static final String TEXT = "text";
	
	/**
	 * @see #type
	 **/
	public static final String TYPE = "type";
	
	/**
	 * @see #publisher
	 **/
	public static final String PUBLISHER = "publisher";
	
	/**
	 * @see #authors
	 **/
	public static final String AUTHORS = "authors";

	
	/**
	 * Static metamodel type for {@link app.model.Book}
	 **/
	public static volatile EntityType<Book> class_;
	
	/**
	 * Static metamodel for attribute {@link app.model.Book#isbn}
	 **/
	public static volatile SingularAttribute<Book, String> isbn;
	
	/**
	 * Static metamodel for attribute {@link app.model.Book#title}
	 **/
	public static volatile SingularAttribute<Book, String> title;
	
	/**
	 * Static metamodel for attribute {@link app.model.Book#publicationDate}
	 **/
	public static volatile SingularAttribute<Book, LocalDate> publicationDate;
	
	/**
	 * Static metamodel for attribute {@link app.model.Book#text}
	 **/
	public static volatile SingularAttribute<Book, String> text;
	
	/**
	 * Static metamodel for attribute {@link app.model.Book#type}
	 **/
	public static volatile SingularAttribute<Book, BookType> type;
	
	/**
	 * Static metamodel for attribute {@link app.model.Book#publisher}
	 **/
	public static volatile SingularAttribute<Book, Publisher> publisher;
	
	/**
	 * Static metamodel for attribute {@link app.model.Book#authors}
	 **/
	public static volatile SetAttribute<Book, Author> authors;

}

