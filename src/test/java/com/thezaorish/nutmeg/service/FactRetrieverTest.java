package com.thezaorish.nutmeg.service;

import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.thezaorish.nutmeg.model.CatFactApiResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by zaorish on 23/01/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class FactRetrieverTest {

	private FactRetriever factRetriever;

	@Mock
	private CatFactHTTPService httpService;
	@Mock
	private JsonDeserializer deserializer;

	@Before
	public void setUp() {
		factRetriever = new FactRetriever(httpService, deserializer);
	}

	@Test
	public void shouldRetrieveSingleFact() throws Exception {
		// given a response with multiple interesting facts about cats
		String json = "anyString";
		given(httpService.get()).willReturn(json);

		CatFactApiResponse validWithMultipleFacts = new CatFactApiResponse().valid().withFacts("cats are funny", "lots of cat pictures on the internet");
		given(deserializer.retrieveResourceFromResponse(json, CatFactApiResponse.class)).willReturn(validWithMultipleFacts);

		// when
		String fact = factRetriever.retrieveFactAboutCats();

		// then
		assertThat(fact, is("cats are funny"));
	}

}