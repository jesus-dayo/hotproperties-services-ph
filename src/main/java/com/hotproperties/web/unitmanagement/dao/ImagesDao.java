package com.hotproperties.web.unitmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotproperties.web.entity.Images;

@Repository
public interface ImagesDao extends JpaRepository<Images,Long>
{

    List<Images> findByPropertyId(long propertyId);
    void deleteByPropertyId(long propertyId);
}
