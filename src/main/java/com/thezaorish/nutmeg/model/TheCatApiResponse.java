package com.thezaorish.nutmeg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zaorish on 23/01/16.
 */
@JacksonXmlRootElement(namespace = "response")
public class TheCatApiResponse {

	@JacksonXmlProperty(localName = "data")
	private TheCatApiData data;

	public TheCatApiData getData() {
		return data;
	}
	public void setData(TheCatApiData data) {
		this.data = data;
	}

	public List<String> getCategories() {
		List<TheCatApiCategory> categories = getData().getCategories();
		return categories.stream().map(category -> category.getName()).collect(toList());
	}
	public TheCatApiResponse withCategories(TheCatApiCategory... categories) {
		if (null == getData()) {
			setData(new TheCatApiData());
		}
		getData().setCategories(Arrays.asList(categories));
		return this;
	}

	public TheCatApiImage getSingleImage() {
		return (null != getData() && !getData().getImages().isEmpty()) ? getData().getImages().get(0) : null;
	}

	@Override
	public String toString() {
		return "TheCatApiResponse{" +
				"data=" + getData() +
				'}';
	}

}
