package app.model;

import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

/**
 * Jakarta Data static metamodel for {@link app.model.Author}
 **/
@StaticMetamodel(Author.class)
public interface _Author {

	
	/**
	 * @see #ssn
	 **/
	String SSN = "ssn";
	
	/**
	 * @see #name
	 **/
	String NAME = "name";
	
	/**
	 * @see #address
	 **/
	String ADDRESS = "address";
	
	/**
	 * @see #address_street
	 **/
	String ADDRESS_STREET = "address.street";
	
	/**
	 * @see #address_city
	 **/
	String ADDRESS_CITY = "address.city";
	
	/**
	 * @see #address_zip
	 **/
	String ADDRESS_ZIP = "address.zip";

	
	/**
	 * Static metamodel for attribute {@link Author#ssn}
	 **/
	TextAttribute<Author> ssn = new TextAttributeRecord<>(SSN);
	
	/**
	 * Static metamodel for attribute {@link Author#name}
	 **/
	TextAttribute<Author> name = new TextAttributeRecord<>(NAME);
	
	/**
	 * Static metamodel for attribute {@link Author#address}
	 **/
	SortableAttribute<Author> address = new SortableAttributeRecord<>(ADDRESS);
	
	/**
	 * Static metamodel for attribute {@link Author#address.street}
	 **/
	TextAttribute<Author> address_street = new TextAttributeRecord<>(ADDRESS_STREET);
	
	/**
	 * Static metamodel for attribute {@link Author#address.city}
	 **/
	TextAttribute<Author> address_city = new TextAttributeRecord<>(ADDRESS_CITY);
	
	/**
	 * Static metamodel for attribute {@link Author#address.zip}
	 **/
	TextAttribute<Author> address_zip = new TextAttributeRecord<>(ADDRESS_ZIP);

}

