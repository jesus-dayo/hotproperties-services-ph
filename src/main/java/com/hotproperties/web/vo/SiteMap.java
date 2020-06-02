package com.hotproperties.web.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "urlset") 
public class SiteMap {

	@JacksonXmlProperty(localName = "url")
    @JacksonXmlElementWrapper(useWrapping = false)
	private List<URLSet> urlSet = new ArrayList<>();

	public SiteMap() {
	}

	public SiteMap(List<URLSet> urlSet) {
		super();
		this.urlSet = urlSet;
	}

	public List<URLSet> getUrlSet() {
		return urlSet;
	}

	public void setUrlSet(List<URLSet> urlSet) {
		this.urlSet = urlSet;
	}

}
