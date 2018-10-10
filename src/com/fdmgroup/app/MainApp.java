package com.fdmgroup.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.config.Configurator;
import com.fdmgroup.service.ShoppingCart;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		// A configuration class can be used instead of the xml to define beans
		//ApplicationContext context = new AnnotationConfigApplicationContext(Configurator.class);
		
		ShoppingCart sc = context.getBean(ShoppingCart.class);
		
		sc.addItem("iphone", 10);
		
		System.out.println("===============================================");
		
		try {
			sc.removeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("===============================================");
		sc.loop();
		
	}
}
