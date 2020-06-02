package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Images;
import com.hotproperties.web.vo.request.ImagesResponse;

public class ImagesToImagesResponseConverter implements Function<Images, ImagesResponse>
{

    @Override
    public ImagesResponse apply(Images entity)
    {
        ImagesResponse response = new ImagesResponse();
        response.setDescription(entity.getDescription());
        response.setId(entity.getId());
        response.setImage(entity.getImage());
        response.setPropertyId(entity.getPropertyId());
        response.setProfile(entity.isProfile());
        return response;
    }
    
}
