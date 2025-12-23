package app.model;

import jakarta.data.metamodel.SortableAttribute;
import jakarta.data.metamodel.StaticMetamodel;
import jakarta.data.metamodel.TextAttribute;
import jakarta.data.metamodel.impl.SortableAttributeRecord;
import jakarta.data.metamodel.impl.TextAttributeRecord;

/**
 * Jakarta Data static metamodel for {@link app.model.Publisher}
 **/
@StaticMetamodel(Publisher.class)
public interface _Publisher {

	
	/**
	 * @see #id
	 **/
	String ID = "id";
	
	/**
	 * @see #name
	 **/
	String NAME = "name";

	
	/**
	 * Static metamodel for attribute {@link Publisher#id}
	 **/
	SortableAttribute<Publisher> id = new SortableAttributeRecord<>(ID);
	
	/**
	 * Static metamodel for attribute {@link Publisher#name}
	 **/
	TextAttribute<Publisher> name = new TextAttributeRecord<>(NAME);

}

