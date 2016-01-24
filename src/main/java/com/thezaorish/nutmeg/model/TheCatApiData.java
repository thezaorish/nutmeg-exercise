package com.thezaorish.nutmeg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaorish on 23/01/16.
 */
@JacksonXmlRootElement(localName = "data")
public class TheCatApiData {

	@JacksonXmlElementWrapper(useWrapping = true, localName = "categories")
	private List<TheCatApiCategory> categories;

	@JacksonXmlElementWrapper(useWrapping = true, localName = "images")
	private List<TheCatApiImage> images;

	public List<TheCatApiCategory> getCategories() {
		if (null == categories) {
			categories = new ArrayList();
		}
		return categories;
	}
	public void setCategories(List<TheCatApiCategory> categories) {
		this.categories = categories;
	}

	public List<TheCatApiImage> getImages() {
		if (null == images) {
			images = new ArrayList();
		}
		return images;
	}
	public void setImages(List<TheCatApiImage> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "TheCatApiData{" +
				"categories=" + getCategories() +
				", images=" + getImages() +
				'}';
	}

}
