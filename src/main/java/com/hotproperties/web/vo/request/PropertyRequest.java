package com.hotproperties.web.vo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hotproperties.web.vo.LocationVO;
import com.hotproperties.web.vo.TypeVO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyRequest {

	private Long propertyId;
	@JsonProperty(value = "propertyName")
	private String name;
	private String description;
	private String price;
	private String maxPrice;
	private int bath;
	private int rooms;
	private Long maxRooms;
	private long type;
	private LocationVO city;
	private TypeVO propertyType;
	private boolean swimming;
	private boolean gym;
	private long sqm;
	private Long maxSQM;
	private boolean garage;
	private boolean court;
	private String youtubelink;
	private int category;
	private int status;
	private long parentId;
	private String latitude;
	private String longitude;
	private String title;
	private String metadescription;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getBath() {
		return bath;
	}

	public void setBath(int bath) {
		this.bath = bath;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public LocationVO getCity() {
		return city;
	}

	public void setCity(LocationVO city) {
		this.city = city;
	}

	public TypeVO getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(TypeVO propertyType) {
		this.propertyType = propertyType;
	}

	public boolean isSwimming() {
		return swimming;
	}

	public void setSwimming(boolean swimming) {
		this.swimming = swimming;
	}

	public boolean isGym() {
		return gym;
	}

	public void setGym(boolean gym) {
		this.gym = gym;
	}

	public long getSqm() {
		return sqm;
	}

	public void setSqm(long sqm) {
		this.sqm = sqm;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean isCourt() {
		return court;
	}

	public void setCourt(boolean court) {
		this.court = court;
	}

	public String getYoutubelink() {
		return youtubelink;
	}

	public void setYoutubelink(String youtubelink) {
		this.youtubelink = youtubelink;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetadescription() {
		return metadescription;
	}

	public void setMetadescription(String metadescription) {
		this.metadescription = metadescription;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Long getMaxRooms() {
		return maxRooms;
	}

	public void setMaxRooms(Long maxRooms) {
		this.maxRooms = maxRooms;
	}

	public Long getMaxSQM() {
		return maxSQM;
	}

	public void setMaxSQM(Long maxSQM) {
		this.maxSQM = maxSQM;
	}

}
