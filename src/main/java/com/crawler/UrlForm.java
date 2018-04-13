package com.crawler;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UrlForm {
	
	@NotNull
    @Size(min=10, max=200)
    private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String toString() {
        return "Url: " + this.url;
    }

}
