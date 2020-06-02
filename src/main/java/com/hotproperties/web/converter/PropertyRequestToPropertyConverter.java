package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Property;
import com.hotproperties.web.unitmanagement.controller.ResourceConstants;
import com.hotproperties.web.vo.request.PropertyRequest;

public class PropertyRequestToPropertyConverter implements Function<PropertyRequest,Property>
{

    @Override
    public Property apply(PropertyRequest vo)
    {
        Property property = new Property();
        if(vo.getPropertyId() != null){
        property.setId(vo.getPropertyId());
        }
        property.setLongitude(vo.getLongitude());
        property.setLatitude(vo.getLatitude());
        property.setBath(vo.getBath());
        property.setDescription(vo.getDescription());
        property.setGym(vo.isGym());
        property.setLink(ResourceConstants.PROPERTY_MANAGEMENT_V1+vo.getPropertyId());
        property.setLocation(new LocationVOToLocationConverter().apply(vo.getCity()));
        property.setName(vo.getName());
        property.setPrice(vo.getPrice());
        property.setRooms(vo.getRooms());
        property.setSwimming(vo.isSwimming());
        property.setSqm(vo.getSqm());
        property.setGarage(vo.isGarage());
        property.setCourt(vo.isCourt());
        property.setYoutubelink(vo.getYoutubelink());
        property.setType(new TypeVOToTypeConverter().apply(vo.getPropertyType()));
        property.setLocationId(vo.getCity().getId());
        property.setTypeId(vo.getPropertyType().getId());
        property.setCategory(vo.getCategory());
        property.setStatus(vo.getStatus());
        property.setParentId(vo.getParentId());
        property.setTitle(vo.getTitle());
        property.setMetadescription(vo.getMetadescription());
        property.setMaxPrice(vo.getMaxPrice());
        property.setMaxRooms(vo.getMaxRooms());
        property.setMaxSQM(vo.getMaxSQM());
        return property;
    }

}
