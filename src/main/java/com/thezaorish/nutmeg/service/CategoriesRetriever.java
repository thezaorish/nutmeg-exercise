package com.thezaorish.nutmeg.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thezaorish.nutmeg.model.TheCatApiResponse;
import com.thezaorish.nutmeg.service.http.TheCatApiHTTPService;
import com.thezaorish.nutmeg.service.transformer.XMLDeserializer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by zaorish on 23/01/16.
 */
@Singleton
public class CategoriesRetriever {

	private TheCatApiHTTPService httpService;

	private XMLDeserializer xmlDeserializer;

	@Inject
	public CategoriesRetriever(TheCatApiHTTPService httpService, XMLDeserializer xmlDeserializer) {
		this.httpService = httpService;
		this.xmlDeserializer = xmlDeserializer;
	}

	public List<String> retrieveCategories() {
		String xml = httpService.getCategories();
		TheCatApiResponse theCatApiResponse;
		try {
			theCatApiResponse = xmlDeserializer.retrieveResourceFromResponse(xml, TheCatApiResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		return theCatApiResponse.getCategories();
	}

}
