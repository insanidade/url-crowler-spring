package com.crawler;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author ofranca
 *
 */
public class UrlForm {
	
	@NotNull
    @Size(min=10, max=200)
    private String url;

	
	/**
	 * @return String containing the value currently set for the url field
	 */
	public String getUrl() {
		return url;
	}

	
	/**
	 * @param url The String object to be set for the url field.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
        return "Url: " + this.url;
    }

}
