package com.hotproperties.web.inquiry.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotproperties.web.entity.Inquiry;

@Repository
public interface InquiryDao extends CrudRepository<Inquiry,Long>
{

    
    
}
