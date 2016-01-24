package com.thezaorish.nutmeg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Created by zaorish on 23/01/16.
 */
@JacksonXmlRootElement(localName = "data")
public class TheCatApiData {

	@JacksonXmlElementWrapper(useWrapping = true, localName = "categories")
	private List<TheCatApiCategory> categories;

	public List<TheCatApiCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<TheCatApiCategory> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "TheCatApiData{" +
				"categories=" + getCategories() +
				'}';
	}

}
