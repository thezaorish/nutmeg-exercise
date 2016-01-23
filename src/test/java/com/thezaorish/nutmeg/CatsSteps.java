package com.thezaorish.nutmeg;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by zaorish on 23/01/16.
 */
public class CatsSteps {

	private ByteArrayOutputStream outputStream;

	@Before
	public void setUp() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@After
	public void tearDown() {
		System.setOut(System.out);
	}

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
		Runner.main(new String[] { "fact" });
		outputStream.flush();
	}

	@Then("I should be displayed the cat fact")
	public void displayFact() {
		String[] linesOfOutput = linesOfOutput();
		assertThat(linesOfOutput.length, is(1));
		assertThat(linesOfOutput[0].contains("cat"), is(true));
	}

	@When("I choose to find out more about the categories of cats")
	public void chooseCategory() throws Exception {
		//
	}

	@Then("I should be displayed the cat categories")
	public void displayCategory() {
		Assert.assertTrue(false);
	}

	private String[] linesOfOutput() {
		String whatWasPrinted = new String(outputStream.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));
		return linesOfOutput;
	}

}
