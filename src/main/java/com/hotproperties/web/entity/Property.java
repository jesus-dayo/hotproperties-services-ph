package com.hotproperties.web.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "Property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "parent_id")
	private long parentId;
	@NotNull
	private String name;
	private String description;
	@Column(name = "location_id")
	private long locationId;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_location"), insertable = false, updatable = false)
	private Location location;
	@OneToMany
	@JoinColumn(name = "parent_id", insertable = false, updatable = false)
	@Where(clause = "status!=3")
	public List<Property> subProperty = new ArrayList<Property>();
	private String price;
	private String maxPrice;
	private int category;
	private int status;
	private long rooms;
	private Long maxRooms;
	private long bath;
	private boolean swimming;
	private boolean gym;
	private long sqm;
	private Long maxSQM;
	private boolean garage;
	private boolean court;
	private String youtubelink;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_type"), insertable = false, updatable = false)
	private Type type;
	@Column(name = "type_id")
	private long typeId;
	private String link;
	@Column(name = "last_updated")
	private Date lastUpdated;
	private String latitude;
	private String longitude;
	private String title;
	private String metadescription;
	@OneToMany
	@JoinColumn(name = "property_id", insertable = false, updatable = false)
	private List<Images> images = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
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

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public List<Property> getSubProperty() {
		return subProperty;
	}

	public void setSubProperty(List<Property> subProperty) {
		this.subProperty = subProperty;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
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
