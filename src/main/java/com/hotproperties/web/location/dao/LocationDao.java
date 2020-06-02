package com.hotproperties.web.location.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotproperties.web.entity.Location;

@Repository
public interface LocationDao extends JpaRepository<Location,Long>
{

}
