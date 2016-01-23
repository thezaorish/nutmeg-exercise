package com.thezaorish.nutmeg.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by zaorish on 23/01/16.
 */
public class JsonDeserializer {

	public <T> T retrieveResourceFromResponse(String json, Class<T> clazz) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(json, clazz);
	}

}
