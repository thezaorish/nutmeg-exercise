package com.thezaorish.nutmeg;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by zaorish on 23/01/16.
 */
public class CatsSteps {

	@When("I choose to get an image of a cat")
	public void chooseImage() {
		//
	}

	@Then("I should be displayed the image url")
	public void displayImageUrl() {
		Assert.assertTrue(false);
	}

	@Then("I should have the cat image on my filesystem")
	public void checkFileExistence() {
		Assert.assertTrue(false);
	}

	@When("I choose to read a fact about cats")
	public void chooseFact() throws Exception {
		//
	}

	@Then("I should be displayed the cat fact")
	public void displayFact() {
		Assert.assertTrue(false);
	}

	@When("I choose to find out more about the categories of cats")
	public void chooseCategory() throws Exception {
		//
	}

	@Then("I should be displayed the cat categories")
	public void displayCategory() {
		Assert.assertTrue(false);
	}

}
