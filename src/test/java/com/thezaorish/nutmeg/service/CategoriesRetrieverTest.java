package com.thezaorish.nutmeg.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import com.thezaorish.nutmeg.model.TheCatApiCategory;
import com.thezaorish.nutmeg.model.TheCatApiResponse;
import com.thezaorish.nutmeg.service.http.TheCatApiHTTPService;
import com.thezaorish.nutmeg.service.transformer.XMLDeserializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

/**
 * Created by zaorish on 23/01/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriesRetrieverTest {

	private CategoriesRetriever categoriesRetriever;

	@Mock
	private TheCatApiHTTPService theCatApiHTTPService;
	@Mock
	private XMLDeserializer xmlDeserializer;

	@Before
	public void setUp() {
		categoriesRetriever = new CategoriesRetriever(theCatApiHTTPService, xmlDeserializer);
	}

	@Test
	public void shouldRetrieveTheNamesOfAllCategories() throws Exception {
		// given
		String xml = "anyXml";
		given(theCatApiHTTPService.getCategories()).willReturn(xml);

		TheCatApiResponse catApiResponse = new TheCatApiResponse().withCategories(new TheCatApiCategory("13", "claw"), new TheCatApiCategory("17", "scratch"));
		given(xmlDeserializer.retrieveResourceFromResponse(xml, TheCatApiResponse.class)).willReturn(catApiResponse);

		// when
		List<String> categories = categoriesRetriever.retrieveCategories();

		// then
		assertThat(categories.size(), is(2));
		assertThat(categories.get(0), is("claw"));
		assertThat(categories.get(1), is("scratch"));
	}
	@Test
	public void shouldHandleIncompleteResponse() throws Exception {
		// given
		String xml = "anyXml";
		given(theCatApiHTTPService.getCategories()).willReturn(xml);

		TheCatApiResponse catApiResponse = new TheCatApiResponse();
		given(xmlDeserializer.retrieveResourceFromResponse(xml, TheCatApiResponse.class)).willReturn(catApiResponse);

		// when
		List<String> categories = categoriesRetriever.retrieveCategories();

		// then
		assertThat(categories.size(), is(0));
	}

}
