package com.hotproperties.web.converter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.hotproperties.web.entity.Property;
import com.hotproperties.web.unitmanagement.controller.ResourceConstants;
import com.hotproperties.web.vo.request.ImagesResponse;
import com.hotproperties.web.vo.response.PropertyResponse;

public class PropertyToPropertyResponseDevConverter implements Function<Property, PropertyResponse>
{

    @Override
    public PropertyResponse apply(Property entity)
    {
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setPropertyId(entity.getId());
        propertyResponse.setBath(entity.getBath());
        propertyResponse.setDescription(entity.getDescription());
        propertyResponse.setGym(entity.isGym());
        propertyResponse.setCity(new LocationToLocationVOConverter().apply(entity.getLocation()));
        propertyResponse.setPropertyName(entity.getName());
        propertyResponse.setPrice(entity.getPrice());
        propertyResponse.setRooms(entity.getRooms());
        propertyResponse.setSwimming(entity.isSwimming());
        propertyResponse.setGym(entity.isGym());
        propertyResponse.setSqm(entity.getSqm());
        propertyResponse.setGarage(entity.isGarage());
        propertyResponse.setCourt(entity.isCourt());
        propertyResponse.setYoutubelink(entity.getYoutubelink());
        propertyResponse.setPropertyType(new TypeToTypeVOConverter().apply(entity.getType()));
        propertyResponse.setParentId(entity.getParentId());
        propertyResponse.setLink(ResourceConstants.PROPERTY_MANAGEMENT_V1 + "/" + entity.getId());
        propertyResponse.setImages(entity.getImages().stream()
            .map(e-> new ImagesToImagesResponseConverter().apply(e)).collect(Collectors.toList()));
        propertyResponse.setProfileImage(getProfileImage(propertyResponse.getImages()));
        if(entity.getLatitude() != null &&  entity.getLongitude() != null){
        propertyResponse.setLatitude(Double.parseDouble(entity.getLatitude()));
        propertyResponse.setLongitude(Double.parseDouble(entity.getLongitude()));
        }
        propertyResponse.setChildProperty(entity.getSubProperty().stream()
            .map(e->new PropertyToPropertyResponseConverter().apply(e)).collect(Collectors.toList()));
        propertyResponse.setTitle(entity.getTitle());
        propertyResponse.setMetadescription(entity.getMetadescription());
        propertyResponse.setMaxPrice(entity.getMaxPrice());
        propertyResponse.setMaxRooms(entity.getMaxRooms());
        propertyResponse.setMaxSQM(entity.getMaxSQM());
        return propertyResponse;
    }

    private ImagesResponse getProfileImage(List<ImagesResponse> images)
    {
        if(images == null || images.isEmpty()){
            return null;
        }
        for(ImagesResponse image:images){
            if(image.isProfile()){
                return image;
            }
        }
        return null;
    }

}
