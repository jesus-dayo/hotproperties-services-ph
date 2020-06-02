package com.hotproperties.web.unitmanagement.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hotproperties.web.constants.CategoryType;
import com.hotproperties.web.constants.StatusType;
import com.hotproperties.web.entity.Images;
import com.hotproperties.web.entity.Property;
import com.hotproperties.web.unitmanagement.dao.PropertyDao;
import com.hotproperties.web.vo.Image;
import com.hotproperties.web.vo.SiteMap;
import com.hotproperties.web.vo.URLSet;

import cz.jiripinkas.jsitemapgenerator.WebPage;
import cz.jiripinkas.jsitemapgenerator.WebPageBuilder;
import cz.jiripinkas.jsitemapgenerator.generator.SitemapGenerator;

@Service
public class AdminServiceImpl implements IAdminService{

	private static final String WEEKLY = "weekly";

	private static final String SLASH = "/";

	@Autowired
	private PropertyDao dao;
	
	private final String url = "https://www.hotproperties.com.ph/";
	private final String crawlerSuffix = "?_escaped_fragment_=";
	private final String forSaleUrl = "for-sale";
	private final String preSaleUrl = "pre-sale";
	
	@Override
	public File generateSiteMapV2() throws IOException {
		SitemapGenerator sitemapGenerator = new SitemapGenerator("https://www.hotproperties.com.ph");
		List<Property> propertyList = dao.findByStatus(StatusType.NEW.getKey());
		
		for(Property property:propertyList){
			//for-sale/:type/:location/:propName/:propTypeId
			List<Images> images = property.getImages();
			cz.jiripinkas.jsitemapgenerator.Image image = null;
			if(!images.isEmpty()) {
				String newUrl = "";
				if(property.getCategory() == CategoryType.FEATURED.getKey()
						|| property.getCategory() == CategoryType.FEATUREDUNDERDEV.getKey()) {
					newUrl = forSaleUrl +SLASH+ 
							transformValue(property.getType().getName())+SLASH+ 
							transformValue(property.getLocation().getCitymunDesc())+SLASH+
							transformValue(property.getName())+SLASH+
							property.getId();
				}else {
					newUrl = preSaleUrl +SLASH+ 
							transformValue(property.getType().getName())+SLASH+ 
							transformValue(property.getLocation().getCitymunDesc())+SLASH+
							transformValue(property.getName())+SLASH+
							property.getId();
				}
				WebPage build = new WebPageBuilder()
						.name(newUrl)
						.priorityMax()
						.changeFreqWeekly()
						.lastModNow()
						.build();
				List<cz.jiripinkas.jsitemapgenerator.Image> listOfImages =
						new ArrayList<>();
				for(Images i:images) {
						image = new cz.jiripinkas.jsitemapgenerator.Image();
						image.setTitle(i.getDescription());
//						image.setCaption(StringUtils.isEmpty(property.getMetadescription())?"For sale property - "+property.getName():property.getMetadescription());
						image.setLoc(i.getImage());
						listOfImages.add(image);
				}
				build.setImages(listOfImages);
				sitemapGenerator.addPage(build);
			}
		}
		File file = new File("sitemap.xml");
		sitemapGenerator.constructAndSaveSitemap(file);
		return file;
	}
	
	@Override
	public File generateSiteMap() throws JsonGenerationException, JsonMappingException, IOException {
		List<Property> propertyList = dao.findByStatus(StatusType.NEW.getKey());
		List<URLSet> siteMapList = new ArrayList<>();
		addDefaults(siteMapList);
		for(Property property:propertyList){
			//for-sale/:type/:location/:propName/:propTypeId
			List<Images> images = property.getImages();
			Image image = null;
			if(!images.isEmpty()) {
				for(Images i:images) {
					if(i.isProfile()) {
						image = new Image(i.getImage(),StringUtils.isEmpty(property.getTitle())?"For sale property - "+property.getName():property.getTitle());
						break;
					}
				}
			}
			if(property.getCategory() == CategoryType.FEATURED.getKey()
					|| property.getCategory() == CategoryType.FEATUREDUNDERDEV.getKey()) {
				String newUrl = url+forSaleUrl +SLASH+ 
						transformValue(property.getType().getName())+SLASH+ 
						transformValue(property.getLocation().getCitymunDesc())+SLASH+
						transformValue(property.getName())+SLASH+
						property.getId()+
						crawlerSuffix;
				siteMapList.add(new URLSet(newUrl, WEEKLY,image));
			}else {
				String newUrl = url+preSaleUrl +SLASH+ 
						transformValue(property.getType().getName())+SLASH+ 
						transformValue(property.getLocation().getCitymunDesc())+SLASH+
						transformValue(property.getName())+SLASH+
						property.getId()+
						crawlerSuffix;
				siteMapList.add(new URLSet(newUrl, WEEKLY,image));
			}
		}
		SiteMap siteMap = new SiteMap(siteMapList);
		
		 XmlMapper xmlMapper = new XmlMapper();
		    xmlMapper.writeValue(new File("sitemap.xml"), siteMap);
		    File file = new File("sitemap.xml");
		return file;
	}

	private void addDefaults(List<URLSet> siteMapList) {
		siteMapList.add(new URLSet(url+"home"+crawlerSuffix, 
				WEEKLY,null));
	}
	
	private String transformValue(String value) {
		return value.trim().replace(" ", "-").toLowerCase().trim();
	}

}
