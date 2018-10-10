package com.fdmgroup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.fdmgroup.aspect.LoggingAspect;
import com.fdmgroup.service.ShoppingCart;

@Configuration
@ComponentScan(value = {"com.fdmgroup.service", "com.fdmgroup.aspect"})
@EnableAspectJAutoProxy
public class Configurator {
	
	//aka <bean id="sc" class="com.fdmgroup.service.ShoppingCart" />
	
	@Bean
	public ShoppingCart shoppingCart(){
		return new ShoppingCart();
	}
	
	//aka <bean id="la" class="com.fdmgroup.aspect.LoggingAspect" />
	
	@Bean
	public LoggingAspect loggingAspect(){
		return new LoggingAspect();
	}
	
}
