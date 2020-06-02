package com.hotproperties.web.unitmanagement.service;

import java.util.List;

import com.hotproperties.web.base.service.BaseService;
import com.hotproperties.web.vo.request.ImagesRequest;
import com.hotproperties.web.vo.request.ImagesResponse;

public interface IImagesService extends BaseService<ImagesRequest, ImagesResponse>
{

    public List<ImagesResponse> findByProperty(long propertyId);


    void deleteByPropertyId(long propertyId);
    
    void delete(long id);

}
