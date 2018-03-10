package com.niit.portalmiddleware.intializer;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.portalmiddleware.config.AppConfig;
import com.niit.portalmiddleware.config.AppWebSocketConfiguration;
import com.niit.portalmiddleware.config.SpringSecurityConfig;
import com.niit.portalmiddleware.config.WebApplicationConfig;
import com.niit.portalmiddleware.filter.CORSFilter;


public class WebAppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{WebApplicationConfig.class,AppConfig.class,AppWebSocketConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[] {new CORSFilter()};
	}

}
