package com.thezaorish.nutmeg.model;

/**
 * Created by zaorish on 24/01/16.
 */
public abstract class RemoteFile {

	public abstract String getUrl();
	public abstract void setUrl(String url);

	public String extension() {
		String url = getUrl();
		return (null != url && !url.isEmpty() && url.contains(".")) ? url.substring(url.lastIndexOf("."), url.length()) : "";
	}

	public String filename() {
		String url = getUrl();
		return (null != url && !url.isEmpty() && url.contains("/")) ? url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")) : "";
	}

}
