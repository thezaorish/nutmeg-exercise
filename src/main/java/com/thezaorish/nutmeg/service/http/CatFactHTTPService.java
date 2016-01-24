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
public class CatFactHTTPService {

	public String get() {
		Unirest.setTimeouts(3_000, 10_000);
		Unirest.setDefaultHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

		HttpResponse<String> stringHttpResponse = null;
		try {
			stringHttpResponse = Unirest.get("http://catfacts-api.appspot.com/api/facts?number=1").asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		if (HttpStatus.SC_OK == stringHttpResponse.getStatus()) {
			return stringHttpResponse.getBody();
		}
		return "";
	}

}
