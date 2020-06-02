package com.hotproperties.web.unitmanagement.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hotproperties.web.entity.Location;
import com.hotproperties.web.entity.Property;
import com.hotproperties.web.entity.Type;

@Repository
public interface PropertyDao extends PagingAndSortingRepository<Property,Long>
{
    List<Property> findByLocationAndType(Location location,Type type);
    
    List<Property> findByStatusAndCategory(Integer status, Integer category);
    
    List<Property> findByStatusAndCategoryOrderByLastUpdatedDesc(Integer status, Integer category);
    
    List<Property> findByStatus(Integer status);
    
    Page<Property> findByStatus(Integer status,Pageable pageable);
    
//    @Query("select from Property where  and status = 1")
//    Property findByLocationAndName(String location,String name);
    
    @Query(value="select * from Property where status = 1 and category in (1,3)",nativeQuery = true)
    List<Property> findFeaturedProperties();
    
    @Modifying
    @Query("update Property set status = ?1 where id = ?2")
    int setStatusForProperty(Integer status,Long id);

}
