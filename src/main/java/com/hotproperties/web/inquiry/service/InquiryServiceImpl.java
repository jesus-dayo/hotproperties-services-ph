package com.hotproperties.web.inquiry.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotproperties.web.entity.Inquiry;
import com.hotproperties.web.inquiry.dao.InquiryDao;

@Service
@Transactional
public class InquiryServiceImpl implements InquiryService
{

    @Autowired
    private InquiryDao inquiryDao;
    
    @SuppressWarnings("unchecked")
    @Override
    public Inquiry save(Inquiry inquiry)
    {
        return inquiryDao.save(inquiry);
    }

    @Override
    public List<Inquiry> saveAll(List<Inquiry> list)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Inquiry> findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
