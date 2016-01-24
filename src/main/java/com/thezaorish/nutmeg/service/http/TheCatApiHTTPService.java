package com.thezaorish.nutmeg.service.http;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;

/**
 * Created by zaorish on 23/01/16.
 */
public class TheCatApiHTTPService {

	public String getCategories() {
		Unirest.setTimeouts(3_000, 10_000);
		Unirest.setDefaultHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_XML.getMimeType());

		HttpResponse<String> stringHttpResponse = null;
		try {
			stringHttpResponse = Unirest.get("http://thecatapi.com/api/categories/list").asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		if (HttpStatus.SC_OK == stringHttpResponse.getStatus()) {
			return stringHttpResponse.getBody();
		}
		return "";
	}

}
