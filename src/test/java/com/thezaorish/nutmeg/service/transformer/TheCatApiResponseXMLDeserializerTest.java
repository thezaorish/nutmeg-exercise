package com.thezaorish.nutmeg.service.transformer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.thezaorish.nutmeg.model.TheCatApiCategory;
import com.thezaorish.nutmeg.model.TheCatApiImage;
import com.thezaorish.nutmeg.model.TheCatApiResponse;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zaorish on 23/01/16.
 */
public class TheCatApiResponseXMLDeserializerTest {

	private XMLDeserializer deserializer;

	@Before
	public void setUp() {
		deserializer = new XMLDeserializer();
	}

	@Test
	public void shouldDeserializeCategories() throws Exception {
		// given some xml response with 2 categories
		String xml = "<?xml version=\"1.0\"?>\n" +
				"<response>\n" +
				"    <data>\n" +
				"        <categories>\n" +
				"            <category>\n" +
				"                <id>1</id>\n" +
				"                <name>hats</name>\n" +
				"            </category>\n" +
				"            <category>\n" +
				"                <id>2</id>\n" +
				"                <name>space</name>\n" +
				"            </category>\n" +
				"        </categories>\n" +
				"    </data>\n" +
				"</response>";

		// when
		TheCatApiResponse theCatApiResponse = deserializer.retrieveResourceFromResponse(xml, TheCatApiResponse.class);

		// then
		assertThat(theCatApiResponse.getData().getCategories().size(), is(2));
		assertThat(theCatApiResponse.getData().getImages().size(), is(0));
		//
		TheCatApiCategory firstCategory = theCatApiResponse.getData().getCategories().get(0);
		assertThat(firstCategory.getId(), is("1"));
		assertThat(firstCategory.getName(), is("hats"));
		//
		TheCatApiCategory secondCategory = theCatApiResponse.getData().getCategories().get(1);
		assertThat(secondCategory.getId(), is("2"));
		assertThat(secondCategory.getName(), is("space"));
	}

	@Test
	public void shouldDeserializeOnlyKnownFields() throws Exception {
		// given some xml response with more fields that our model can deserialize
		String xml = "<?xml version=\"1.0\"?>\n" +
				"<response>\n" +
				"    <data>\n" +
				"        <categories>\n" +
				"            <category>\n" +
				"                <id>1</id>\n" +
				"                <name>hats</name>\n" +
				"                <field>toBeIgnored</field>\n" +
				"            </category>\n" +
				"        </categories>\n" +
				"    </data>\n" +
				"</response>";

		// when
		TheCatApiResponse theCatApiResponse = deserializer.retrieveResourceFromResponse(xml, TheCatApiResponse.class);

		// then
		assertThat(theCatApiResponse.getData().getCategories().size(), is(1));
		TheCatApiCategory firstCategory = theCatApiResponse.getData().getCategories().get(0);
		assertThat(firstCategory.getId(), is("1"));
		assertThat(firstCategory.getName(), is("hats"));
	}

	@Test
	public void shouldDeserializeImages() throws Exception {
		// given some xml response with 2 images
		String xml = "<?xml version=\"1.0\"?>\n" +
				"<response>\n" +
				"    <data>\n" +
				"        <images>\n" +
				"            <image>\n" +
				"                <url>1280.jpg</url>\n" +
				"                <id>eco</id>\n" +
				"                <source_url>http://thecatapi.com/?id=eco</source_url>\n" +
				"      \n" +
				"            </image>\n" +
				"            <image>\n" +
				"                <url>500.gif</url>\n" +
				"                <id>51u</id>\n" +
				"                <source_url>http://thecatapi.com/?id=51u</source_url>\n" +
				"      \n" +
				"            </image>\n" +
				"    \n" +
				"        </images>\n" +
				"  \n" +
				"    </data>\n" +
				"</response>";

		// when
		TheCatApiResponse theCatApiResponse = deserializer.retrieveResourceFromResponse(xml, TheCatApiResponse.class);

		// then
		assertThat(theCatApiResponse.getData().getImages().size(), is(2));
		assertThat(theCatApiResponse.getData().getCategories().size(), is(0));
		//
		TheCatApiImage firstImage = theCatApiResponse.getData().getImages().get(0);
		assertThat(firstImage.getId(), is("eco"));
		assertThat(firstImage.getUrl(), is("1280.jpg"));
		//
		TheCatApiImage secondImage = theCatApiResponse.getData().getImages().get(1);
		assertThat(secondImage.getId(), is("51u"));
		assertThat(secondImage.getUrl(), is("500.gif"));
	}

}
