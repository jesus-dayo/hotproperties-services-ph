package com.hotproperties.web.unitmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotproperties.web.converter.ImagesRequestToImagesConverter;
import com.hotproperties.web.converter.ImagesToImagesResponseConverter;
import com.hotproperties.web.entity.Images;
import com.hotproperties.web.unitmanagement.dao.ImagesDao;
import com.hotproperties.web.vo.request.ImagesRequest;
import com.hotproperties.web.vo.request.ImagesResponse;

@Service
@Transactional
public class ImagesServiceImpl implements IImagesService
{

    @Autowired
    private ImagesDao imagesDao;
    
    @SuppressWarnings("unchecked")
    @Override
    public ImagesResponse save(ImagesRequest request)
    {
        Images image = imagesDao.save(new ImagesRequestToImagesConverter().apply(request));
        return new ImagesToImagesResponseConverter().apply(image);
    }

    @Override
    public List<ImagesResponse> saveAll(List<ImagesRequest> list)
    {
        List<Images> entity = imagesDao.saveAll(list.stream().map(e-> new ImagesRequestToImagesConverter()
            .apply(e)).collect(Collectors.toList()));
        return entity.stream().map(e->new ImagesToImagesResponseConverter()
            .apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<ImagesResponse> findByProperty(long propertyId)
    {
        List<Images> entity = imagesDao.findByPropertyId(propertyId);
        return entity.stream().map(e->new ImagesToImagesResponseConverter()
            .apply(e)).collect(Collectors.toList());
    }

    @Override
    public List<ImagesResponse> findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteByPropertyId(long propertyId)
    {
        imagesDao.deleteByPropertyId(propertyId);
    }

    @Override
    public void delete(long id)
    {
        imagesDao.deleteById(id);
    }

}
