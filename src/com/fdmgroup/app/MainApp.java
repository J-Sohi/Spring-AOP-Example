package com.fdmgroup.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.service.ShoppingCart;

public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
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
