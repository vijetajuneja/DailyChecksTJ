package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.AddToCartComponents;


public class AddToCartPage extends AddToCartComponents{
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public void ATC() throws Exception {
		new AddToCartComponents(driver).addToCart();
	}
	
}
	


