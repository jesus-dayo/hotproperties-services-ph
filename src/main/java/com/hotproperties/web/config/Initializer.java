package com.hotproperties.web.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import com.github.greengerong.PreRenderSEOFilter;

@Configuration
public class Initializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
      PreRenderSEOFilter seoFilter = new PreRenderSEOFilter();
      FilterRegistration.Dynamic filter =  context.addFilter("prerender", seoFilter);
      filter.setInitParameter("prerenderToken", "");
      filter.setInitParameter("crawlerUserAgents", "googlebot,bingbot,yandex,"
      		+ "baiduspider,facebookexternalhit, twitterbot, rogerbot, linkedinbot, embedly,"
      		+ "apis-google,mediapartners-google,adsbot-google-mobile,adsbot-google,googlebot-image,"
      		+ "googlebot-news,googlebot-video,adsbot-google-mobile-apps");
      filter.addMappingForUrlPatterns(null , true, "/*");
	}
	

}
