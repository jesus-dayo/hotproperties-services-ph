package com.hotproperties.web.vo.response;

import java.util.List;

import com.hotproperties.web.vo.LocationVO;
import com.hotproperties.web.vo.TypeVO;
import com.hotproperties.web.vo.request.ImagesResponse;

public class PropertyResponse {
	private long propertyId;
	private long parentId;
	private String propertyName;
	private String description;
	private String price;
	private String maxPrice;
	private Integer category;
	private String categoryName;
	private long rooms;
	private Long maxRooms;
	private TypeVO propertyType;
	private LocationVO city;
	private long bath;
	private boolean swimming;
	private boolean gym;
	private String country;
	private String street;
	private String province;
	private String postal;
	private long sqm;
	private Long maxSQM;
	private boolean garage;
	private boolean court;
	private String youtubelink;
	private String link;
	private double latitude;
	private double longitude;
	private String title;
	private String metadescription;
	private ImagesResponse profileImage;
	private List<ImagesResponse> images;
	private List<PropertyResponse> childProperty;

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
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

	public long getRooms() {
		return rooms;
	}

	public void setRooms(long rooms) {
		this.rooms = rooms;
	}

	public TypeVO getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(TypeVO propertyType) {
		this.propertyType = propertyType;
	}

	public LocationVO getCity() {
		return city;
	}

	public void setCity(LocationVO city) {
		this.city = city;
	}

	public long getBath() {
		return bath;
	}

	public void setBath(long bath) {
		this.bath = bath;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<ImagesResponse> getImages() {
		return images;
	}

	public void setImages(List<ImagesResponse> images) {
		this.images = images;
	}

	public ImagesResponse getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(ImagesResponse profileImage) {
		this.profileImage = profileImage;
	}

	public List<PropertyResponse> getChildProperty() {
		return childProperty;
	}

	public void setChildProperty(List<PropertyResponse> childProperty) {
		this.childProperty = childProperty;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
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
