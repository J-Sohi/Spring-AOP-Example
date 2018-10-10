package com.fdmgroup.service;

public class ShoppingCart {
	
	public void addItem(String name, int quantity){
		System.out.println("Adding " + quantity + " unit(s) of " + name + " to the cart.");
	}
	
	public void removeItem(String name, int quantity){
		System.out.println("Removing " + quantity + " unit(s) of " + name + " from the cart.");
	}
	
	public void remove(String name){
		System.out.println("Removing all of the" + name + " from the cart.");
	}
	
	public void removeAll() throws Exception{
		System.out.println("Removing everything from the cart.");
		throw new Exception("Generic Exception");
	}
	
	public int loop(){
		int sum = 0;
		for(int i = 1; i < 11; i++){
			sum+=i;
			System.out.println(i + ", ");
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
	
}
