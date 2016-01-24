package com.thezaorish.nutmeg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by zaorish on 24/01/16.
 */
@JacksonXmlRootElement(localName = "image")
public class TheCatApiImage extends RemoteFile {

	@JacksonXmlProperty(localName = "url")
	private String url;

	@JacksonXmlProperty(localName = "id")
	private String id;

	public TheCatApiImage() {
		// empty constructor needed by jackson
	}
	public TheCatApiImage(String url, String id) {
		this.url = url;
		this.id = id;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TheCatApiImage{" +
				"url='" + getUrl() + '\'' +
				", id='" + getId() + '\'' +
				'}';
	}

}
