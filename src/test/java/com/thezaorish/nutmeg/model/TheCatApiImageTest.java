package com.thezaorish.nutmeg.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by zaorish on 24/01/16.
 */
public class TheCatApiImageTest {

	private TheCatApiImage image;

	@Before
	public void setUp() {
		String url = "http://24.media.tumblr.com/tumblr_m49tq3iCUH1r6jd7fo1_1280.jpg";
		image = new TheCatApiImage();
		image.setUrl(url);
	}

	@Test
	public void shouldExtractFilename() {
		assertTrue(image.filename().equals("tumblr_m49tq3iCUH1r6jd7fo1_1280"));
	}
	@Test
	public void shouldExtractExtension() {
		assertTrue(image.extension().equals(".jpg"));
	}

}
