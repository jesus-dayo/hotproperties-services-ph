package com.hotproperties.web.inquiry.service;

import com.hotproperties.web.entity.Inquiry;

public interface EmailService {

	void sendEmail(Inquiry inquiry) throws Exception;
	
}
