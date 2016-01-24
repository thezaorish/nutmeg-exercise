package com.thezaorish.nutmeg;

import com.thezaorish.nutmeg.service.CategoriesRetriever;
import com.thezaorish.nutmeg.service.XMLDeserializer;
import com.thezaorish.nutmeg.service.http.CatFactHTTPService;
import com.thezaorish.nutmeg.service.FactRetriever;
import com.thezaorish.nutmeg.service.JsonDeserializer;
import com.thezaorish.nutmeg.service.http.TheCatApiHTTPService;

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
		} if ("categories".equals(args[0])) {
			TheCatApiHTTPService theCapApiHTTPService = new TheCatApiHTTPService();
			XMLDeserializer xmlDeserializer = new XMLDeserializer();

			CategoriesRetriever categoriesRetriever = new CategoriesRetriever(theCapApiHTTPService, xmlDeserializer);
			System.out.print(categoriesRetriever.retrieveCategories());
		} else {
			System.out.print("");
		}
	}

}
