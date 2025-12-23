package app.model;

import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

/**
 * Jakarta Data static metamodel for {@link app.model.Book}
 **/
@StaticMetamodel(Book.class)
public interface _Book {

	
	/**
	 * @see #isbn
	 **/
	String ISBN = "isbn";
	
	/**
	 * @see #title
	 **/
	String TITLE = "title";
	
	/**
	 * @see #publicationDate
	 **/
	String PUBLICATION_DATE = "publicationDate";
	
	/**
	 * @see #text
	 **/
	String TEXT = "text";
	
	/**
	 * @see #type
	 **/
	String TYPE = "type";
	
	/**
	 * @see #publisher
	 **/
	String PUBLISHER = "publisher";

	
	/**
	 * Static metamodel for attribute {@link Book#isbn}
	 **/
	TextAttribute<Book> isbn = new TextAttributeRecord<>(ISBN);
	
	/**
	 * Static metamodel for attribute {@link Book#title}
	 **/
	TextAttribute<Book> title = new TextAttributeRecord<>(TITLE);
	
	/**
	 * Static metamodel for attribute {@link Book#publicationDate}
	 **/
	SortableAttribute<Book> publicationDate = new SortableAttributeRecord<>(PUBLICATION_DATE);
	
	/**
	 * Static metamodel for attribute {@link Book#text}
	 **/
	TextAttribute<Book> text = new TextAttributeRecord<>(TEXT);
	
	/**
	 * Static metamodel for attribute {@link Book#type}
	 **/
	SortableAttribute<Book> type = new SortableAttributeRecord<>(TYPE);
	
	/**
	 * Static metamodel for attribute {@link Book#publisher}
	 **/
	SortableAttribute<Book> publisher = new SortableAttributeRecord<>(PUBLISHER);

}

