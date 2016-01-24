package com.thezaorish.nutmeg.service.http;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by zaorish on 23/01/16.
 */
@Singleton
public class CatFactHTTPService {

	private HTTPService httpService;

	@Inject
	public CatFactHTTPService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public String getCategories() {
		HTTPRequest request = new HTTPRequest.Builder("http://catfacts-api.appspot.com/api/facts?number=1").
				customHeaders(Collections.unmodifiableMap(new HashMap() {{put(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());}})).
				timeouts(3_000, 10_000).
				build();
		return httpService.get(request);
	}

}
