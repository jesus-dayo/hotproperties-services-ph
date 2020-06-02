package com.hotproperties.web.tools;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import cz.jiripinkas.jsitemapgenerator.Image;
import cz.jiripinkas.jsitemapgenerator.WebPage;
import cz.jiripinkas.jsitemapgenerator.WebPageBuilder;
import cz.jiripinkas.jsitemapgenerator.generator.SitemapGenerator;

public class StubbornJavaSitemapGenerator {

	public static void main(String[] args) throws IOException {
		SitemapGenerator sitemapGenerator = new SitemapGenerator("https://www.hotproperties.com.ph");
		WebPage build = new WebPageBuilder()
		.name(
		"for-sale/house-and-lot/cavite-city/rfo-house-and-lot-at-south-forbes-tokyo-mansions/21")
		.priorityMax()
		.changeFreqWeekly()
		.lastModNow()
		.build();
		build.addImage(new Image());
		sitemapGenerator.addPage(build);
		// generate sitemap and save it to file /var/www/sitemap.xml
		File file = new File("C:\\Users\\jed\\Documents\\sitemaps\\sitemap.xml");
		sitemapGenerator.constructAndSaveSitemap(file);
		// inform Google that this sitemap has changed
//		sitemapGenerator.pingGoogle();

	}
}