package com.thezaorish.nutmeg.service;

import com.google.inject.Singleton;
import com.thezaorish.nutmeg.model.RemoteFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * Created by zaorish on 24/01/16.
 */
@Singleton
public class StoreRemoteFileService<T extends RemoteFile> {

	public void storeFile(T file) {
		try {
			URL url = new URL(file.getUrl());
			File temp = File.createTempFile(file.filename() + "_", file.extension());
			FileUtils.copyURLToFile(url, temp);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
