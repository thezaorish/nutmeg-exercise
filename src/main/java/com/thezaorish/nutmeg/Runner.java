package com.thezaorish.nutmeg;

import com.thezaorish.nutmeg.service.CatFactHTTPService;
import com.thezaorish.nutmeg.service.FactRetriever;
import com.thezaorish.nutmeg.service.JsonDeserializer;

/**
 * Created by zaorish on 23/01/16.
 */
public class Runner {

	public static void main(String[] args) {
		if ("fact".equals(args[0])) {
			CatFactHTTPService httpService = new CatFactHTTPService();
			JsonDeserializer deserializer = new JsonDeserializer();

			FactRetriever factRetriever = new FactRetriever(httpService, deserializer);
			System.out.print(factRetriever.retrieveFactAboutCats());
		} else {
			System.out.print("");
		}
	}

}
