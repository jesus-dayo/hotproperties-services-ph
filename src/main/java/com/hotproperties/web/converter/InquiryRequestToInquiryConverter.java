package com.hotproperties.web.converter;

import java.util.function.Function;

import com.hotproperties.web.entity.Inquiry;
import com.hotproperties.web.vo.request.InquiryRequest;

public class InquiryRequestToInquiryConverter implements Function<InquiryRequest, Inquiry>
{

    @Override
    public Inquiry apply(InquiryRequest request)
    {
        Inquiry inquiry = new Inquiry();
        inquiry.setEmail(request.getEmail());
        inquiry.setName(request.getName());
        inquiry.setMessage(request.getMessage());
        inquiry.setPhone(request.getPhone());
        inquiry.setPropertyId(request.getPropertyId());
        inquiry.setPropertyName(request.getPropertyName());
        return inquiry;
    }

}
