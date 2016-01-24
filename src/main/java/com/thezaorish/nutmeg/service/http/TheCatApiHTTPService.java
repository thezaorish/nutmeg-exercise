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
public class TheCatApiHTTPService {

	private static final String THE_CAT_API = "http://thecatapi.com/api";

	private static final String CATEGORIES = "/categories/list";
	private static final String IMAGES = "/images/get";

	private HTTPService httpService;

	@Inject
	public TheCatApiHTTPService(HTTPService httpService) {
		this.httpService = httpService;
	}

	public String getImage() {
		HTTPRequest request = new HTTPRequest.Builder(THE_CAT_API + IMAGES + "?format=xml&results_per_page=1").
				customHeaders(Collections.unmodifiableMap(new HashMap() {{put(HttpHeaders.ACCEPT, ContentType.APPLICATION_XML.getMimeType());}})).
				timeouts(3_000, 20_000).
				build();
		return httpService.get(request);
	}

	public String getCategories() {
		HTTPRequest request = new HTTPRequest.Builder(THE_CAT_API + CATEGORIES).
				customHeaders(Collections.unmodifiableMap(new HashMap() {{put(HttpHeaders.ACCEPT, ContentType.APPLICATION_XML.getMimeType());}})).
				timeouts(3_000, 10_000).
				build();
		return httpService.get(request);
	}

}
