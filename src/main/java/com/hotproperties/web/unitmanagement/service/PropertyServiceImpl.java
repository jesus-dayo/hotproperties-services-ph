package com.hotproperties.web.unitmanagement.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotproperties.web.constants.CategoryType;
import com.hotproperties.web.constants.StatusType;
import com.hotproperties.web.converter.PropertyRequestToPropertyConverter;
import com.hotproperties.web.converter.PropertyToPropertyResponseConverter;
import com.hotproperties.web.converter.PropertyToPropertyResponseDevConverter;
import com.hotproperties.web.converter.PropertyToSimplePropertyResponseConverter;
import com.hotproperties.web.entity.Location;
import com.hotproperties.web.entity.Property;
import com.hotproperties.web.entity.Type;
import com.hotproperties.web.exception.InvalidPropertyRequest;
import com.hotproperties.web.location.dao.LocationDao;
import com.hotproperties.web.unitmanagement.dao.PageablePropertyDao;
import com.hotproperties.web.unitmanagement.dao.PropertyDao;
import com.hotproperties.web.vo.request.PropertyRequest;
import com.hotproperties.web.vo.response.PropertyResponse;

@Service
@Transactional
public class PropertyServiceImpl implements IPropertyService
{

    @Autowired
    private PropertyDao propertyDao;
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private PageablePropertyDao pageablePropertyDao;


    @SuppressWarnings("unchecked")
    @Override
    public PropertyResponse save(PropertyRequest vo)
    {
        //        Property entity = propertyDao.save(propertyMapper.propertyVOToProperty(vo));
        //        return propertyMapper.propertyToPropertyVO(entity);
        return null;
    }


    @Override
    public PropertyResponse update(PropertyRequest vo) throws InvalidPropertyRequest
    {
        if (vo.getPropertyId() > 0L)
        {
            Optional<Property> propertyFound = propertyDao.findById(vo.getPropertyId());
            if (!propertyFound.isPresent())
            {
                throw new InvalidPropertyRequest("property id to update does not exist");
            }
            Property entity = propertyDao.save(new PropertyRequestToPropertyConverter().apply(vo));
            return new PropertyToPropertyResponseConverter().apply(entity);
        }
        else
        {
            throw new InvalidPropertyRequest("property id is empty");
        }

    }


    @Override
    public List<PropertyResponse> saveAll(List<PropertyRequest> list)
    {
        return null;
    }


    @Override
    public List<PropertyResponse> findAll()
    {
        List<Property> entity = (List<Property>)propertyDao.findByStatus(StatusType.NEW.getKey());
        List<PropertyResponse> vo = entity.stream().map(e -> new PropertyToPropertyResponseConverter().apply(e)).collect(Collectors.toList());
        return vo;
    }


    @Override
    public List<PropertyResponse> findByLocationAndType(int locationId, int typeId)
    {
        Location location = new Location();
        Type type = new Type();
        location.setId(locationId);
        type.setId(typeId);
        List<Property> entity = (List<Property>) propertyDao.findByLocationAndType(location, type);
        List<PropertyResponse> vo = entity.stream().map(e -> new PropertyToPropertyResponseConverter().apply(e)).collect(Collectors.toList());
        return vo;
    }


    @Override
    public void delete(long propertyId)
    {
        propertyDao.deleteById(propertyId);
    }


    @Override
    public Page<PropertyResponse> findPageByLocationAndType(long locationId, long type, Pageable page)
    {
        Page<Property> propertyPage = pageablePropertyDao.findByLocationIdAndTypeIdAndStatus(locationId, type,StatusType.NEW.getKey(), page);
        if(propertyPage.getTotalElements() == 0) {
        	// go find broader range of properties
        	Location location = locationDao.getOne(locationId);
        	propertyPage = pageablePropertyDao.findByLocationProvCodeAndTypeIdAndStatus(location.getProvCode(), type,StatusType.NEW.getKey(), page);
        }
        if(propertyPage.getTotalElements() == 0) {
        	// go find broader range of properties
        	propertyPage = pageablePropertyDao.findByLocationIdAndTypeIdAndStatus(locationId, type==1?2:1,StatusType.NEW.getKey(), page);
        }
        PropertyToPropertyResponseConverter propertyToPropertyResponseConverter = new PropertyToPropertyResponseConverter();
        return propertyPage.map(propertyToPropertyResponseConverter);
    }
    
    @Override
    public List<PropertyResponse> findByLocationIdAndTypeIdAndStatusAndIdNot(long locationId, long type,long id)
    {
        List<Property> propertyPage = pageablePropertyDao.findByLocationIdAndTypeIdAndStatusAndIdNot(locationId, type,StatusType.NEW.getKey(),id);
        List<PropertyResponse> vo = propertyPage.stream().map(e -> new PropertyToPropertyResponseConverter().apply(e)).collect(Collectors.toList());
        return vo;
    }
    
    @Override
    public Page<PropertyResponse> findPageByLocation(long locationId, Pageable page)
    {
        Page<Property> propertyPage = pageablePropertyDao.findByLocationIdAndStatus(locationId,StatusType.NEW.getKey(), page);
        PropertyToPropertyResponseConverter propertyToPropertyResponseConverter = new PropertyToPropertyResponseConverter();
        return propertyPage.map(propertyToPropertyResponseConverter);
    }
    
    @Override
    public Page<PropertyResponse> findPageByType(long type, Pageable page)
    {
        Page<Property> propertyPage = pageablePropertyDao.findByTypeIdAndStatus(type,StatusType.NEW.getKey(), page);
        PropertyToPropertyResponseConverter propertyToPropertyResponseConverter = new PropertyToPropertyResponseConverter();
        return propertyPage.map(propertyToPropertyResponseConverter);
    }
    
    @Override
    public Page<PropertyResponse> findAllPaginated(Pageable page)
    {
        Page<Property> propertyPage = pageablePropertyDao.findByStatus(StatusType.NEW.getKey(),page);
        PropertyToPropertyResponseConverter propertyToPropertyResponseConverter = new PropertyToPropertyResponseConverter();
        return propertyPage.map(propertyToPropertyResponseConverter);
    }


    @Override
    public PropertyResponse create(PropertyRequest vo)
    {
        Property entity = propertyDao.save(new PropertyRequestToPropertyConverter().apply(vo));
        return new PropertyToPropertyResponseConverter().apply(entity);
    }


    @Override
    public List<PropertyResponse> findByStatusAndCategory(Integer status, Integer category)
    {
        List<Property> entity = (List<Property>)propertyDao.findByStatusAndCategoryOrderByLastUpdatedDesc(status, category);
        List<PropertyResponse> vo = entity.stream().map(e -> new PropertyToPropertyResponseConverter().apply(e)).collect(Collectors.toList());
        return vo;
    }
    
    @Override
    public List<PropertyResponse> findFeaturedProperties()
    {
        List<Property> entity = (List<Property>)propertyDao.findFeaturedProperties();
        List<PropertyResponse> vo = entity.stream().map(e -> new PropertyToPropertyResponseConverter().apply(e)).collect(Collectors.toList());
        return vo;
    }

    @Override
    public List<PropertyResponse> findDevelopmentForSelect()
    {
        List<Property> entity = (List<Property>)propertyDao.findByStatusAndCategory(StatusType.NEW.getKey(), CategoryType.DEVELOPMENT.getKey());
        List<PropertyResponse> vo = entity.stream().map(e -> new PropertyToSimplePropertyResponseConverter().apply(e)).collect(Collectors.toList());
        return vo;
    }

    @Override
    public List<PropertyResponse> findByStatus(Integer status)
    {
        List<Property> entity = (List<Property>)propertyDao.findByStatus(status);
        List<PropertyResponse> vo = entity.stream().map(e -> new PropertyToPropertyResponseConverter().apply(e)).collect(Collectors.toList());
        return vo;
    }


    @Override
    public void cancel(long propertyId)
    {
        propertyDao.setStatusForProperty(StatusType.CANCEL.getKey(), propertyId);
    }


    @Override
    public void sold(long propertyId)
    {
        propertyDao.setStatusForProperty(StatusType.SOLD.getKey(), propertyId);
    }


    @Override
    public Page<PropertyResponse> findByStatus(Integer status, Pageable page)
    {
        Page<Property> properties = propertyDao.findByStatus(status, page);
        PropertyToPropertyResponseConverter propertyToPropertyResponseConverter = new PropertyToPropertyResponseConverter();
        return properties.map(propertyToPropertyResponseConverter);
    }


    @Override
    public PropertyResponse find(long propertyId)
    {
        Optional<Property> property = propertyDao.findById(propertyId);
        if(property.isPresent()){
            Property propertyRes = property.get(); 
            PropertyToPropertyResponseConverter propertyToPropertyResponseConverter = new PropertyToPropertyResponseConverter();
            PropertyResponse response = propertyToPropertyResponseConverter.apply(propertyRes);
            return response;
        }
        return null;
    }
    
    @Override
    public PropertyResponse findDev(long propertyId)
    {
        Optional<Property> property = propertyDao.findById(propertyId);
        if(property.isPresent()){
            Property propertyRes = property.get(); 
            PropertyToPropertyResponseDevConverter propertyToPropertyResponseConverter = new PropertyToPropertyResponseDevConverter();
            PropertyResponse response = propertyToPropertyResponseConverter.apply(propertyRes);
            if(response != null && !response.getChildProperty().isEmpty()){
                response.getChildProperty().removeAll(Collections.singleton(null));
            }
            return response;
        }
        return null;
    }


	@Override
	public PropertyResponse findByLocationAndName(String location, String name) {
		// TODO Auto-generated method stub
//		propertyDao.
		return null;
	}


}
