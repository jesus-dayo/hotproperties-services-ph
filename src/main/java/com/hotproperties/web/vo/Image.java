package com.hotproperties.web.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

	@JsonProperty("loc")
	private String loc;
	@JsonProperty("caption")
	private String caption;

	public Image(String loc, String caption) {
		super();
		this.loc = loc;
		this.caption = caption;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

}
