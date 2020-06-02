package com.hotproperties.web.inquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotproperties.web.converter.InquiryRequestToInquiryConverter;
import com.hotproperties.web.entity.Inquiry;
import com.hotproperties.web.inquiry.service.EmailService;
import com.hotproperties.web.inquiry.service.InquiryService;
import com.hotproperties.web.unitmanagement.controller.ResourceConstants;
import com.hotproperties.web.vo.request.InquiryRequest;

@RestController
@RequestMapping(value = ResourceConstants.INQUIRY_MANAGEMENT_V1)
@CrossOrigin
public class InquiryController
{

    @Autowired
    private InquiryService service;
    @Autowired
    private EmailService emailService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HttpStatus> create(@RequestBody InquiryRequest inquiryRequest)
    {
        try
        {
        	Inquiry inquiry = new InquiryRequestToInquiryConverter().apply(inquiryRequest);
            service.save(inquiry);
            emailService.sendEmail(inquiry);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
