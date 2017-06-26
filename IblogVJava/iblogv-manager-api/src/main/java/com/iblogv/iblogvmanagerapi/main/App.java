package com.iblogv.iblogvmanagerapi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */

@PropertySource("file:${application.home}/application.properties.sn")
@EntityScan({ "com.iblogv.iblogvmanager.model"})
@EnableJpaRepositories({ "com.iblogv" })
@ComponentScan({ "com.iblogv.*" })
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass=true)

@SpringBootApplication
@Slf4j
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Hello World!" );
        log.debug("error");
        log.debug("test");
        log.debug("warn");
        log.debug("info");
        
		SpringApplication.run(App.class, args);
    	
        
    }
}
