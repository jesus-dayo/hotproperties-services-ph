package com.hotproperties.web.unitmanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hotproperties.web.base.service.BaseService;
import com.hotproperties.web.exception.InvalidPropertyRequest;
import com.hotproperties.web.vo.request.PropertyRequest;
import com.hotproperties.web.vo.response.PropertyResponse;

public interface IPropertyService extends BaseService<PropertyRequest, PropertyResponse>
{

    
    List<PropertyResponse> findByLocationAndType(int locationId, int typeId);

    void delete(long propertyId);
    
    void cancel(long propertyId);
    
    void sold(long propertyId);
    
    PropertyResponse create(PropertyRequest vo);

    PropertyResponse update(PropertyRequest vo) throws InvalidPropertyRequest;
    
    Page<PropertyResponse> findPageByLocationAndType(long locationId,long type,Pageable page);
    
    Page<PropertyResponse> findAllPaginated(Pageable page);
    
    List<PropertyResponse> findByStatusAndCategory(Integer status, Integer category);
    
    List<PropertyResponse> findByStatus(Integer status);
    
    Page<PropertyResponse> findByStatus(Integer status,Pageable page);

    PropertyResponse find(long propertyId);

    List<PropertyResponse> findDevelopmentForSelect();

    PropertyResponse findDev(long propertyId);

    Page<PropertyResponse> findPageByLocation(long locationId, Pageable page);

    Page<PropertyResponse> findPageByType(long type, Pageable page);

	PropertyResponse findByLocationAndName(String location, String name);

	List<PropertyResponse> findFeaturedProperties();

	List<PropertyResponse> findByLocationIdAndTypeIdAndStatusAndIdNot(long locationId, long type, long id);

}
