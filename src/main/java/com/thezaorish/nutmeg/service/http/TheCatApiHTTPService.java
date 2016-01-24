package com.thezaorish.nutmeg.service.http;

import com.google.inject.Singleton;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;

/**
 * Created by zaorish on 23/01/16.
 */
@Singleton
public class TheCatApiHTTPService {

	private static final String THE_CAT_API = "http://thecatapi.com/api";

	private static final String CATEGORIES = "/categories/list";
	private static final String IMAGES = "/images/get";

	public String getImage() {
		Unirest.setTimeouts(3_000, 20_000);
		Unirest.setDefaultHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_XML.getMimeType());

		HttpResponse<String> stringHttpResponse = null;
		try {
			stringHttpResponse = Unirest.get(THE_CAT_API + IMAGES + "?format=xml&results_per_page=1").asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		if (HttpStatus.SC_OK == stringHttpResponse.getStatus()) {
			return stringHttpResponse.getBody();
		}
		return "";
	}

	public String getCategories() {
		Unirest.setTimeouts(3_000, 10_000);
		Unirest.setDefaultHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_XML.getMimeType());

		HttpResponse<String> stringHttpResponse = null;
		try {
			stringHttpResponse = Unirest.get(THE_CAT_API + CATEGORIES).asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		if (HttpStatus.SC_OK == stringHttpResponse.getStatus()) {
			return stringHttpResponse.getBody();
		}
		return "";
	}

}
