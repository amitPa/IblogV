package com.iblogv.iblogvmanagerapi.config;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BearerTokenRequired {

	public enum TokenOwner{
		USER,ADMIN
	}
	
	TokenOwner tokenOwner() default TokenOwner.USER;
	
	TokenOwner value();
}
