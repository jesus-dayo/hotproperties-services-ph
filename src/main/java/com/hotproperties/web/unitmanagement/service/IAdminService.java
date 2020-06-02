package com.hotproperties.web.unitmanagement.service;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface IAdminService {

	File generateSiteMap() throws JsonGenerationException, JsonMappingException, IOException;

	File generateSiteMapV2() throws IOException;
	
}
