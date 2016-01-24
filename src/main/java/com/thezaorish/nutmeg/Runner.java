package com.thezaorish.nutmeg;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thezaorish.nutmeg.service.CategoriesRetriever;
import com.thezaorish.nutmeg.service.FactRetriever;

/**
 * Created by zaorish on 23/01/16.
 */
public class Runner {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector();
		if ("fact".equals(args[0])) {
			FactRetriever factRetrieverInstance = injector.getInstance(FactRetriever.class);
			System.out.print(factRetrieverInstance.retrieveFactAboutCats());
		} if ("categories".equals(args[0])) {
			CategoriesRetriever categoriesRetrieverInstance = injector.getInstance(CategoriesRetriever.class);
			System.out.println(categoriesRetrieverInstance.retrieveCategories());
		} else {
			System.out.print("");
		}
	}

}
