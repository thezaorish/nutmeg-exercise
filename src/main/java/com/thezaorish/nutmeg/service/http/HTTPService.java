package com.thezaorish.nutmeg.service.http;

import com.google.inject.Singleton;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpStatus;

/**
 * Created by zaorish on 24/01/16.
 */
@Singleton
public class HTTPService {

	public String get(HTTPRequest httpRequest) {
		Unirest.setTimeouts(httpRequest.getConnectionTimeout(), httpRequest.getSocketTimeout());
		HttpResponse<String> stringHttpResponse = null;
		try {
			stringHttpResponse = Unirest.get(httpRequest.getUrl()).headers(httpRequest.getCustomHeaders()).asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		if (HttpStatus.SC_OK == stringHttpResponse.getStatus()) {
			return stringHttpResponse.getBody();
		}
		return "";
	}

}
