package com.iblogv.iblogvmanagerapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private BearerTokenInterceptor controllerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(controllerInterceptor).addPathPatterns("/**");
		log.debug("Registered BearerTokenInterceptor");
	}

}
