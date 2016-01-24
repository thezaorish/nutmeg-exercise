package com.thezaorish.nutmeg.service.http;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zaorish on 24/01/16.
 */
public class HTTPRequest {

	private final String url;
	private final Map<String, String> customHeaders;
	private final long connectionTimeout;
	private final long socketTimeout;

	private HTTPRequest(Builder builder) {
		url = builder.url;
		customHeaders = builder.customHeaders;
		connectionTimeout = builder.connectionTimeout;
		socketTimeout = builder.socketTimeout;
	}

	public static class Builder {

		// required parameters
		private String url;

		// optional
		private Map<String, String> customHeaders = new LinkedHashMap();
		private long connectionTimeout = 3_000;
		private long socketTimeout = 10_000;

		public Builder(String url) {
			this.url = url;
		}

		public Builder customHeaders(Map<String, String> customHeaders) {
			this.customHeaders = customHeaders;
			return this;
		}

		public Builder timeouts(long connectionTimeout, long socketTimeout) {
			this.connectionTimeout = connectionTimeout;
			this.socketTimeout = socketTimeout;
			return this;
		}

		public HTTPRequest build() {
			return new HTTPRequest(this);
		}

	}

	public String getUrl() {
		return url;
	}

	public Map<String, String> getCustomHeaders() {
		return customHeaders;
	}

	public long getConnectionTimeout() {
		return connectionTimeout;
	}

	public long getSocketTimeout() {
		return socketTimeout;
	}

}
