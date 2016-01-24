package com.thezaorish.nutmeg.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thezaorish.nutmeg.model.CatFactApiResponse;
import com.thezaorish.nutmeg.service.http.CatFactHTTPService;

import java.io.IOException;

/**
 * Created by zaorish on 23/01/16.
 */
@Singleton
public class FactRetriever {

	private CatFactHTTPService httpService;

	private JsonDeserializer deserializer;

	@Inject
	public FactRetriever(CatFactHTTPService httpService, JsonDeserializer deserializer) {
		this.httpService = httpService;
		this.deserializer = deserializer;
	}

	public String retrieveFactAboutCats() {
		String json = httpService.get();

		CatFactApiResponse theCatFactApiResponse;
		try {
			theCatFactApiResponse = deserializer.retrieveResourceFromResponse(json, CatFactApiResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		return theCatFactApiResponse.getSingleFact();
	}

}
