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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zaorish on 23/01/16.
 */
public class CatsSteps {

	private ByteArrayOutputStream outputStream;
	private String key;

	@Before
	public void setUp() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@After
	public void tearDown() {
		System.setOut(System.out);
	}

	@When("I choose an invalid operation")
	public void invalidOption() throws Exception {
		Runner.main(new String[] { "invalid" });
		outputStream.flush();
	}

	@When("I do not choose any operation")
	public void defaultOption() throws Exception {
		Runner.main(new String[] {});
		outputStream.flush();
	}

	@When("I choose to get an image of a cat")
	public void chooseImage() throws Exception {
		Runner.main(new String[] { "file" });
		outputStream.flush();
	}

	@Then("I should be instructed what are the correct operations")
	public void displayValidOperations() {
		String[] linesOfOutput = linesOfOutput();
		Assert.assertTrue(linesOfOutput[0].startsWith("Invalid argument"));
	}

	@Then("I should be displayed the image url")
	public void displayImageUrl() {
		String[] linesOfOutput = linesOfOutput();
		assertThat(linesOfOutput.length, is(1));
		assertThat(linesOfOutput[0].startsWith("http"), is(true));
		key = linesOfOutput[0].substring(linesOfOutput[0].lastIndexOf("/") + 1, linesOfOutput[0].lastIndexOf("."));
	}

	@Then("I should have the cat image on my filesystem")
	public void checkFileExistence() throws Exception {
		boolean condition = false;
		Path dir = Paths.get(System.getProperty("java.io.tmpdir"));
		DirectoryStream<Path> stream = Files.newDirectoryStream(dir, key + "*");
		for (Path entry : stream) {
			condition = true;
		}
		Assert.assertTrue(condition);
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
		Runner.main(new String[] { "categories" });
		outputStream.flush();
	}

	@Then("I should be displayed the cat categories")
	public void displayCategory() {
		String[] linesOfOutput = linesOfOutput();
		assertThat(linesOfOutput.length, is(1));
		assertThat(linesOfOutput[0].contains("space"), is(true));
		assertThat(linesOfOutput[0].contains("funny"), is(true));
	}

	private String[] linesOfOutput() {
		String whatWasPrinted = new String(outputStream.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));
		return linesOfOutput;
	}

}
