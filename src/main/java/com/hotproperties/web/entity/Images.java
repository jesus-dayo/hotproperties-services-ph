package com.hotproperties.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Images")
public class Images
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String image;
    @Column(name = "property_id")
    private long propertyId;
    @Column(name = "profile")
    private boolean profile;
    @Column(name = "last_updated")
    private Date lastUpdated;


    public long getId()
    {
        return id;
    }


    public void setId(long id)
    {
        this.id = id;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public String getImage()
    {
        return image;
    }


    public void setImage(String image)
    {
        this.image = image;
    }


    public long getPropertyId()
    {
        return propertyId;
    }


    public void setPropertyId(long propertyId)
    {
        this.propertyId = propertyId;
    }


    public boolean isProfile()
    {
        return profile;
    }


    public void setProfile(boolean profile)
    {
        this.profile = profile;
    }


    public Date getLastUpdated()
    {
        return lastUpdated;
    }


    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

}
