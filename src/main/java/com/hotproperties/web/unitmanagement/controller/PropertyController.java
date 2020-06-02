package com.hotproperties.web.unitmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotproperties.web.constants.CategoryType;
import com.hotproperties.web.constants.StatusType;
import com.hotproperties.web.unitmanagement.service.IImagesService;
import com.hotproperties.web.unitmanagement.service.IPropertyService;
import com.hotproperties.web.vo.request.ImagesRequest;
import com.hotproperties.web.vo.request.ImagesResponse;
import com.hotproperties.web.vo.request.PropertyRequest;
import com.hotproperties.web.vo.response.PropertyResponse;

@RestController
@RequestMapping(value = ResourceConstants.PROPERTY_MANAGEMENT_V1)
@CrossOrigin
public class PropertyController {

	@Autowired
	private IPropertyService propertyService;
	@Autowired
	private IImagesService imageService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<PropertyResponse>> getProperties() {
		try {
			return getAllProperties();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/listByLocationAndType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<PropertyResponse>> getPropertiesByLocationAndType(
			@RequestParam(value = "location") int locationId, @RequestParam(value = "type") int typeId) {
		try {
			if (locationId == 0 && typeId == 0) {
				return getAllProperties();
			} else {
				return getAllPropertiesWithLocationAndType(locationId, typeId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	private ResponseEntity<List<PropertyResponse>> getAllPropertiesWithLocationAndType(int locationId, int typeId) {
		List<PropertyResponse> list = propertyService.findByLocationAndType(locationId, typeId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	private ResponseEntity<List<PropertyResponse>> getAllProperties() {
		List<PropertyResponse> list = propertyService.findAll();
		// List<PropertyResponse> list =
		// propertyService.findByStatus(StatusType.NEW.getKey());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/getPropertiesNew", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<PropertyResponse> getPropertiesNew(Pageable pageable) {
		try {
			return propertyService.findByStatus(StatusType.NEW.getKey(), pageable);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/findByLocationIdAndTypeIdAndStatusAndIdNot", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<PropertyResponse>> findByLocationIdAndTypeIdAndStatusAndIdNot(
			@RequestParam(value = "location") int locationId, @RequestParam(value = "type") int typeId,
			@RequestParam(value = "id") long id) {
		List<PropertyResponse> propertyPage = propertyService.findByLocationIdAndTypeIdAndStatusAndIdNot(locationId, typeId,id);
		return new ResponseEntity<>(propertyPage, HttpStatus.OK);
	}

	@RequestMapping(value = "/listPageByLocationAndType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<PropertyResponse> getPropertiesPageByLocationAndType(@RequestParam(value = "location") int locationId,
			@RequestParam(value = "type") int typeId, Pageable pageable) {
		if (locationId == 0 && typeId == 0) {
			Page<PropertyResponse> propertyPage = propertyService.findAllPaginated(pageable);
			return propertyPage;
		} else if (locationId == 0 && typeId != 0) {
			Page<PropertyResponse> propertyPage = propertyService.findPageByType(typeId, pageable);
			return propertyPage;
		} else if (locationId != 0 && typeId == 0) {
			Page<PropertyResponse> propertyPage = propertyService.findPageByLocation(locationId, pageable);
			return propertyPage;
		} else {
			Page<PropertyResponse> propertyPage = propertyService.findPageByLocationAndType(locationId, typeId,
					pageable);
			return propertyPage;
		}
	}

	@RequestMapping(value = "/listFeaturedProperties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<PropertyResponse>> listFeaturedProperties() {
		List<PropertyResponse> propertyPage = propertyService.findByStatusAndCategory(StatusType.NEW.getKey(),
				CategoryType.FEATURED.getKey());
		return new ResponseEntity<>(propertyPage, HttpStatus.OK);
	}

	@RequestMapping(value = "/listDevelopmentProperties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<PropertyResponse>> listDevelopmentProperties() {
		List<PropertyResponse> propertyPage = propertyService.findByStatusAndCategory(StatusType.NEW.getKey(),
				CategoryType.DEVELOPMENT.getKey());
		return new ResponseEntity<>(propertyPage, HttpStatus.OK);
	}

	@RequestMapping(value = "/listDevPropertiesForSelect", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<PropertyResponse>> listDevPropertiesForSelect() {
		List<PropertyResponse> propertyPage = propertyService.findDevelopmentForSelect();
		return new ResponseEntity<>(propertyPage, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> delete(@RequestParam(value = "propertyId") long propertyId) {
		try {
			propertyService.delete(propertyId);
			imageService.deleteByPropertyId(propertyId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getProperty", method = RequestMethod.GET)
	public ResponseEntity<PropertyResponse> getProperty(@RequestParam(value = "propertyId") long propertyId) {
		try {
			PropertyResponse propertyResponse = propertyService.find(propertyId);
			return new ResponseEntity<>(propertyResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getPropertyByLocationAndName", method = RequestMethod.GET)
	public ResponseEntity<PropertyResponse> getPropertyByLocationAndName(
			@RequestParam(value = "location") String location, @RequestParam(value = "name") String name) {
		try {
			PropertyResponse propertyResponse = propertyService.findByLocationAndName(location, name);
			return new ResponseEntity<>(propertyResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getDevProperty", method = RequestMethod.GET)
	public ResponseEntity<PropertyResponse> getDevProperty(@RequestParam(value = "propertyId") long propertyId) {
		try {
			PropertyResponse propertyResponse = propertyService.findDev(propertyId);
			return new ResponseEntity<>(propertyResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> cancel(@RequestParam(value = "propertyId") long propertyId) {
		try {
			propertyService.cancel(propertyId);
			imageService.deleteByPropertyId(propertyId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/sold", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> sold(@RequestParam(value = "propertyId") long propertyId) {
		try {
			propertyService.sold(propertyId);
			imageService.deleteByPropertyId(propertyId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<PropertyResponse> create(@RequestBody PropertyRequest propertyRequest) {
		try {
			PropertyResponse propertyResponse = propertyService.create(propertyRequest);
			return new ResponseEntity<PropertyResponse>(propertyResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			// EmailServiceImpl emailService = new EmailServiceImpl();
			// emailService.sendErrorEmail(e.getMessage());
			return new ResponseEntity<PropertyResponse>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<PropertyResponse> update(@RequestBody PropertyRequest propertyRequest) {
		try {
			PropertyResponse response = propertyService.update(propertyRequest);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HttpStatus uploadFile() {
		try {
			return HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.BAD_REQUEST;
		}
	}

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> uploadImage(@RequestBody ImagesRequest request) throws Exception {
		try {
			imageService.save(request);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteImage", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> deleteImage(@RequestBody ImagesRequest request) throws Exception {
		try {
			imageService.delete(request.getId());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/uploadMultipleImage", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> uploadMultipleImage(@RequestBody List<ImagesRequest> request) throws Exception {
		try {
			imageService.saveAll(request);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/retrieveImage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ImagesResponse>> retrieveImage(@RequestParam("propertyId") long propertyId)
			throws Exception {
		try {
			List<ImagesResponse> list = imageService.findByProperty(propertyId);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
