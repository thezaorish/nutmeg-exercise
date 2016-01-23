package com.thezaorish.nutmeg.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zaorish on 23/01/16.
 */
public class CatFactApiResponse {

	private String success;

	private List<String> facts;

	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}

	public List<String> getFacts() {
		return facts;
	}
	public void setFacts(List<String> facts) {
		this.facts = facts;
	}

	public String getSingleFact() {
		return (isValid() && null != getFacts() && !getFacts().isEmpty()) ? getFacts().get(0) : "";
	}
	private boolean isValid() {
		return "true".equalsIgnoreCase(getSuccess());
	}

	public CatFactApiResponse valid() {
		this.setSuccess("true");
		return this;
	}
	public CatFactApiResponse withFacts(String... facts) {
		this.setFacts(Arrays.asList(facts));
		return this;
	}

	@Override
	public String toString() {
		return "CatFactApiResponse{" +
				"success='" + getSuccess() + '\'' +
				", facts=" + getFacts() +
				'}';
	}

}
