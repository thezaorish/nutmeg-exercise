package com.thezaorish.nutmeg.service;

import com.thezaorish.nutmeg.model.CatFactApiResponse;
import com.thezaorish.nutmeg.service.http.CatFactHTTPService;

import java.io.IOException;

/**
 * Created by zaorish on 23/01/16.
 */
public class FactRetriever {

	private CatFactHTTPService httpService;

	private JsonDeserializer deserializer;

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
