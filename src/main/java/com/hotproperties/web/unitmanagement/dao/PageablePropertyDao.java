package com.hotproperties.web.unitmanagement.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hotproperties.web.entity.Property;

@Repository
public interface PageablePropertyDao extends PagingAndSortingRepository<Property, Long>
{

    Page<Property> findByLocationIdAndTypeIdAndStatus(long locationId,long type,int status,Pageable page);
    Page<Property> findByLocationIdAndStatus(long locationId,int status,Pageable page);
    Page<Property> findByTypeIdAndStatus(long type,int status,Pageable page);
    Page<Property> findByStatus(int status,Pageable page);
    List<Property> findByLocationIdAndTypeIdAndStatusAndIdNot(long locationId,long type,int status,long id);
    Page<Property> findByLocationProvCodeAndTypeIdAndStatus(String provCode,long type,int status,Pageable page);

}
