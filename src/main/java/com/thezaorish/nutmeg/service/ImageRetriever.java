package com.thezaorish.nutmeg.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thezaorish.nutmeg.model.TheCatApiImage;
import com.thezaorish.nutmeg.model.TheCatApiResponse;
import com.thezaorish.nutmeg.service.http.TheCatApiHTTPService;
import com.thezaorish.nutmeg.service.transformer.XMLDeserializer;

import java.io.IOException;

/**
 * Created by zaorish on 24/01/16.
 */
@Singleton
public class ImageRetriever {

	private TheCatApiHTTPService httpService;

	private XMLDeserializer xmlDeserializer;

	private StoreRemoteFileService storeRemoteFileService;

	@Inject
	public ImageRetriever(TheCatApiHTTPService httpService, XMLDeserializer xmlDeserializer, StoreRemoteFileService storeRemoteFileService) {
		this.httpService = httpService;
		this.xmlDeserializer = xmlDeserializer;
		this.storeRemoteFileService = storeRemoteFileService;
	}

	public String retrieveImageMeta() {
		String xmlInString = httpService.getImage();
		TheCatApiResponse theCatApiResponse;
		try {
			theCatApiResponse = xmlDeserializer.retrieveResourceFromResponse(xmlInString, TheCatApiResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		TheCatApiImage singleImage = theCatApiResponse.getSingleImage();
		storeRemoteFileService.storeFile(singleImage);
		return singleImage.getUrl();
	}

}