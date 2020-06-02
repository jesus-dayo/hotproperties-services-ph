package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Property;
import com.hotproperties.web.vo.response.PropertyResponse;

public class PropertyToSimplePropertyResponseConverter implements Function<Property, PropertyResponse>
{

    @Override
    public PropertyResponse apply(Property entity)
    {
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setPropertyId(entity.getId());
        propertyResponse.setPropertyName(entity.getName());
        propertyResponse.setCity(new LocationToLocationVOConverter().apply(entity.getLocation()));
        propertyResponse.setLatitude(Double.parseDouble(entity.getLatitude()));
        propertyResponse.setLongitude(Double.parseDouble(entity.getLongitude()));
        propertyResponse.setTitle(entity.getTitle());
        propertyResponse.setMetadescription(entity.getMetadescription());
        return propertyResponse;
    }
}
