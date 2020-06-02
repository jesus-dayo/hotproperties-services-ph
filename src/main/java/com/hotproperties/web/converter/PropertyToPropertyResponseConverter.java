package com.hotproperties.web.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.hotproperties.web.constants.CategoryType;
import com.hotproperties.web.entity.Images;
import com.hotproperties.web.entity.Property;
import com.hotproperties.web.unitmanagement.controller.ResourceConstants;
import com.hotproperties.web.vo.request.ImagesResponse;
import com.hotproperties.web.vo.response.PropertyResponse;

public class PropertyToPropertyResponseConverter implements Function<Property, PropertyResponse>
{

    @Override
    public PropertyResponse apply(Property entity)
    {
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setPropertyId(entity.getId());
        propertyResponse.setBath(entity.getBath());
        String description = entity.getDescription();
        propertyResponse.setDescription(buildDescription(description));
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
        propertyResponse.setCategory(entity.getCategory());
        propertyResponse.setCategoryName(CategoryType.getValueByKey(entity.getCategory()));
        propertyResponse.setYoutubelink(entity.getYoutubelink());
        propertyResponse.setPropertyType(new TypeToTypeVOConverter().apply(entity.getType()));
        propertyResponse.setParentId(entity.getParentId());
        propertyResponse.setLink(ResourceConstants.PROPERTY_MANAGEMENT_V1 + "/" + entity.getId());
        List<Images> images = entity.getImages();
        propertyResponse.setProfileImage(getProfileImage(images));
        propertyResponse.setImages(getAdditionalImage(images));
        if(entity.getLatitude() != null &&  entity.getLongitude() != null){
        propertyResponse.setLatitude(Double.parseDouble(entity.getLatitude()));
        propertyResponse.setLongitude(Double.parseDouble(entity.getLongitude()));
        }
        propertyResponse.setTitle(entity.getTitle());
        propertyResponse.setMetadescription(entity.getMetadescription());
        propertyResponse.setMaxRooms(entity.getMaxRooms());
        propertyResponse.setMaxPrice(entity.getMaxPrice());
        propertyResponse.setMaxSQM(entity.getMaxSQM());
        return propertyResponse;
    }

    private String buildDescription(String description)
    {
        StringBuilder sb = new StringBuilder(description);
        return sb.toString().trim();
    }

    private ImagesResponse getProfileImage(List<Images> images)
    {
        if(images == null || images.isEmpty()){
            return null;
        }
        for(Images image:images){
            if(image.isProfile()){
                return new ImagesToImagesResponseConverter().apply(image);
            }
        }
        return null;
    }
    
    private List<ImagesResponse> getAdditionalImage(List<Images> images)
    {
        if(images == null || images.isEmpty()){
            return null;
        }
        List<ImagesResponse> results = new ArrayList<>();
        for(Images image:images){
            if(!image.isProfile()){
                results.add(new ImagesToImagesResponseConverter().apply(image));
            }
        }
        return results;
    }

}
