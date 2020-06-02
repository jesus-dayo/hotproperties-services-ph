package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Images;
import com.hotproperties.web.vo.request.ImagesRequest;

public class ImagesRequestToImagesConverter implements Function<ImagesRequest, Images>
{

    @Override
    public Images apply(ImagesRequest request)
    {
        Images images = new Images();
        images.setDescription(request.getDescription());
        images.setImage(request.getImage());
        images.setProfile(request.isProfile());
        images.setPropertyId(request.getPropertyId());
        return images;
    }

}
