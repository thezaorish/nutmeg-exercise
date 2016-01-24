package com.thezaorish.nutmeg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by zaorish on 23/01/16.
 */
@JacksonXmlRootElement(localName = "category")
public class TheCatApiCategory {

	@JacksonXmlProperty(localName = "id")
	private String id;

	@JacksonXmlProperty(localName = "name")
	private String name;

	public TheCatApiCategory() {
		// empty constructor needed by jackson
	}
	public TheCatApiCategory(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TheCatApiCategory{" +
				"id='" + getId() + '\'' +
				", name='" + getName() + '\'' +
				'}';
	}

}
