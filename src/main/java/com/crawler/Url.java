package com.crawler;


/**
 * @author ofranca
 *
 */
public class Url {

	private String url;
	
	

	/**
	 * @param url The text representing the url
	 */
	public Url(String url) {
		super();
		this.url = url;
	}

	/**
	 * @return The string representing the url set for this instance.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url The string containing the url value to be set for this instance.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
