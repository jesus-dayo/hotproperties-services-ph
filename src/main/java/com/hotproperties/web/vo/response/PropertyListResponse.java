package com.hotproperties.web.vo.response;

import java.util.List;

public class PropertyListResponse
{

    private List<PropertyResponse> properties;


    public PropertyListResponse()
    {}


    public PropertyListResponse(List<PropertyResponse> properties)
    {
        super();
        this.properties = properties;
    }


    public List<PropertyResponse> getProperties()
    {
        return properties;
    }


    public void setProperties(List<PropertyResponse> properties)
    {
        this.properties = properties;
    }

}
