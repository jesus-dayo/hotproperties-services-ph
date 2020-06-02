package com.hotproperties.web.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class URLSet {

	@JsonProperty("loc")
	private String loc;
	@JsonProperty("changefreq")
	private String changeFreq;
	@JacksonXmlProperty(localName = "image")
	@JacksonXmlElementWrapper(useWrapping = false)
	private Image image;

	public URLSet() {
	}

	public URLSet(String loc, String changeFreq,Image image) {
		super();
		this.loc = loc;
		this.changeFreq = changeFreq;
		this.image = image;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getChangeFreq() {
		return changeFreq;
	}

	public void setChangeFreq(String changeFreq) {
		this.changeFreq = changeFreq;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
