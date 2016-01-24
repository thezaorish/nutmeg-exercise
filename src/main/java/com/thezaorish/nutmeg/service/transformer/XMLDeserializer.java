package com.thezaorish.nutmeg.service.transformer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.inject.Singleton;

import java.io.IOException;

/**
 * Created by zaorish on 23/01/16.
 */
@Singleton
public class XMLDeserializer {

	public <T> T retrieveResourceFromResponse(String xml, Class<T> clazz) throws IOException {
		XmlMapper mapper = new XmlMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(xml, clazz);
	}

}
