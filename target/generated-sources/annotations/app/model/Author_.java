package app.model;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * Static metamodel for {@link app.model.Author}
 **/
@StaticMetamodel(Author.class)
public abstract class Author_ {

	
	/**
	 * @see #ssn
	 **/
	public static final String SSN = "ssn";
	
	/**
	 * @see #name
	 **/
	public static final String NAME = "name";
	
	/**
	 * @see #address
	 **/
	public static final String ADDRESS = "address";
	
	/**
	 * @see #books
	 **/
	public static final String BOOKS = "books";

	
	/**
	 * Static metamodel type for {@link app.model.Author}
	 **/
	public static volatile EntityType<Author> class_;
	
	/**
	 * Static metamodel for attribute {@link app.model.Author#ssn}
	 **/
	public static volatile SingularAttribute<Author, String> ssn;
	
	/**
	 * Static metamodel for attribute {@link app.model.Author#name}
	 **/
	public static volatile SingularAttribute<Author, String> name;
	
	/**
	 * Static metamodel for attribute {@link app.model.Author#address}
	 **/
	public static volatile SingularAttribute<Author, Address> address;
	
	/**
	 * Static metamodel for attribute {@link app.model.Author#books}
	 **/
	public static volatile SetAttribute<Author, Book> books;

}

