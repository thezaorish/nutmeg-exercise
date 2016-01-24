package com.thezaorish.nutmeg.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.thezaorish.nutmeg.model.TheCatApiImage;
import com.thezaorish.nutmeg.model.TheCatApiResponse;
import com.thezaorish.nutmeg.service.http.TheCatApiHTTPService;
import com.thezaorish.nutmeg.service.transformer.XMLDeserializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by zaorish on 24/01/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageRetrieverTest {

	private ImageRetriever imageRetriever;
	@Mock
	private TheCatApiHTTPService httpService;
	@Mock
	private XMLDeserializer xmlDeserializer;
	@Mock
	private StoreRemoteFileService storeRemoteFileService;

	@Before
	public void setUp() {
		imageRetriever = new ImageRetriever(httpService, xmlDeserializer, storeRemoteFileService);
	}

	@Test
	public void shouldRetrieveImageUrl() throws Exception {
		// given
		String xml = "anyXml";
		given(httpService.getImage()).willReturn(xml);

		TheCatApiImage imageOfInterest = new TheCatApiImage("http://url.com", "12");
		TheCatApiResponse catApiResponse = new TheCatApiResponse().withImages(imageOfInterest, new TheCatApiImage("http://url2.com", "5"));
		given(xmlDeserializer.retrieveResourceFromResponse(xml, TheCatApiResponse.class)).willReturn(catApiResponse);

		// when
		String url = imageRetriever.retrieveImageMeta();

		// then
		verify(storeRemoteFileService).storeFile(imageOfInterest);
		assertThat(url, is("http://url.com"));
	}

}
