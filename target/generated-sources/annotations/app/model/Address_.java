package app.model;

import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * Static metamodel for {@link app.model.Address}
 **/
@StaticMetamodel(Address.class)
public abstract class Address_ {

	
	/**
	 * @see #street
	 **/
	public static final String STREET = "street";
	
	/**
	 * @see #city
	 **/
	public static final String CITY = "city";
	
	/**
	 * @see #zip
	 **/
	public static final String ZIP = "zip";

	
	/**
	 * Static metamodel type for {@link app.model.Address}
	 **/
	public static volatile EmbeddableType<Address> class_;
	
	/**
	 * Static metamodel for attribute {@link app.model.Address#street}
	 **/
	public static volatile SingularAttribute<Address, String> street;
	
	/**
	 * Static metamodel for attribute {@link app.model.Address#city}
	 **/
	public static volatile SingularAttribute<Address, String> city;
	
	/**
	 * Static metamodel for attribute {@link app.model.Address#zip}
	 **/
	public static volatile SingularAttribute<Address, String> zip;

}

