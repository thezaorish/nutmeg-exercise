package com.thezaorish.nutmeg.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.thezaorish.nutmeg.model.CatFactApiResponse;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by zaorish on 23/01/16.
 */
public class CatFactApiResponseJsonDeserializerTest {

	private JsonDeserializer deserializer;

	@Before
	public void setUp() {
		deserializer = new JsonDeserializer();
	}

	@Test
	public void shouldDeserialize() throws Exception {
		String json = "{\n" +
				"  \"facts\": [\n" +
				"    \"Cats should not be fed tuna exclusively.\",\n" +
				"    \"A cat's jaw has only up and down motion.\"\n" +
				"  ],\n" +
				"  \"success\": \"true\"\n" +
				"}";

		CatFactApiResponse response = deserializer.retrieveResourceFromResponse(json, CatFactApiResponse.class);

		assertThat(response.getSuccess(), is("true"));
		assertThat(response.getFacts().get(0), is("Cats should not be fed tuna exclusively."));
		assertThat(response.getFacts().get(1), is("A cat's jaw has only up and down motion."));
	}
	@Test
	public void shouldDeserializeOnlyKnownFields() throws Exception {
		String json = "{\n" +
				"  \"facts\": [\n" +
				"    \"Some cool fact.\"\n" +
				"  ],\n" +
				"  \"success\": \"true\"\n" +
				"  ,\n" +
				"  \"field\": \"shouldBeIgnored\"\n" +
				"}";

		CatFactApiResponse response = deserializer.retrieveResourceFromResponse(json, CatFactApiResponse.class);

		assertThat(response.getSuccess(), is("true"));
		assertThat(response.getFacts().get(0), is("Some cool fact."));
	}

}
