package com.hotproperties.web.vo.request;

import java.util.Date;

public class ImagesResponse
{

    private long id;
    private String description;
    private String image;
    private long propertyId;
    private Date lastUpdated;
    private boolean profile;


    public boolean isProfile()
    {
        return profile;
    }


    public void setProfile(boolean profile)
    {
        this.profile = profile;
    }


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


    public Date getLastUpdated()
    {
        return lastUpdated;
    }


    public void setLastUpdated(Date lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

}
