package com.thezaorish.nutmeg;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thezaorish.nutmeg.service.CategoriesRetriever;
import com.thezaorish.nutmeg.service.FactRetriever;
import com.thezaorish.nutmeg.service.ImageRetriever;

/**
 * Created by zaorish on 23/01/16.
 */
public class Runner {

	private static Injector injector;

	public static void main(String[] args) {
		if (args.length > 1) {
			invalid();
			return;
		}

		injector = Guice.createInjector();

		if (args.length == 0) {
			file();
			return;
		}
		switch (args[0]) {
			case "file":
				file();
				break;

			case "categories":
				categories();
				break;

			case "fact":
				fact();
				break;

			default:
				invalid();
		}
	}

	private static void file() {
		ImageRetriever imageRetriever = injector.getInstance(ImageRetriever.class);
		System.out.println(imageRetriever.retrieveImageMeta());
	}

	private static void categories() {
		CategoriesRetriever categoriesRetrieverInstance = injector.getInstance(CategoriesRetriever.class);
		System.out.println(categoriesRetrieverInstance.retrieveCategories());
	}

	private static void fact() {
		FactRetriever factRetrieverInstance = injector.getInstance(FactRetriever.class);
		System.out.println(factRetrieverInstance.retrieveFactAboutCats());
	}

	private static void invalid() {
		System.out.println("Invalid argument: please use 1 argument from [file, categories or fact].");
	}

}
