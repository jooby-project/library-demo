package app.model;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * Static metamodel for {@link app.model.Publisher}
 **/
@StaticMetamodel(Publisher.class)
public abstract class Publisher_ {

	
	/**
	 * @see #id
	 **/
	public static final String ID = "id";
	
	/**
	 * @see #name
	 **/
	public static final String NAME = "name";

	
	/**
	 * Static metamodel type for {@link app.model.Publisher}
	 **/
	public static volatile EntityType<Publisher> class_;
	
	/**
	 * Static metamodel for attribute {@link app.model.Publisher#id}
	 **/
	public static volatile SingularAttribute<Publisher, Long> id;
	
	/**
	 * Static metamodel for attribute {@link app.model.Publisher#name}
	 **/
	public static volatile SingularAttribute<Publisher, String> name;

}

