package com.hotproperties.web.vo;

import java.util.Date;

public class PropertyVO
{

    private long id;
    private String name;
    private String description;
    private long locationId;
    private String price;
    private long rooms;
    private long bath;
    private long swimming;
    private long gym;
    private long type;
    private Date lastUpdated;


    public long getId()
    {
        return id;
    }


    public void setId(long id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public long getLocationId()
    {
        return locationId;
    }


    public void setLocationId(long locationId)
    {
        this.locationId = locationId;
    }


    public String getPrice()
    {
        return price;
    }


    public void setPrice(String price)
    {
        this.price = price;
    }


    public long getRooms()
    {
        return rooms;
    }


    public void setRooms(long rooms)
    {
        this.rooms = rooms;
    }


    public long getType()
    {
        return type;
    }


    public void setType(long type)
    {
        this.type = type;
    }


    public long getBath()
    {
        return bath;
    }


    public void setBath(long bath)
    {
        this.bath = bath;
    }


    public long getSwimming()
    {
        return swimming;
    }


    public void setSwimming(long swimming)
    {
        this.swimming = swimming;
    }


    public long getGym()
    {
        return gym;
    }


    public void setGym(long gym)
    {
        this.gym = gym;
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
