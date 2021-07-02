package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.FlyCartComponents;

public class FlyCartPage extends FlyCartComponents {

	public FlyCartPage(WebDriver driver) 
	{
	super(driver);
	this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public void verifyAllFields() throws Exception {
		new FlyCartComponents(driver).verifyAllTextsAndFieldsOnEmptyFlyCart();
	}
	
	public void verifyAllFieldsOnNonEmptyFlyCart() throws Exception {
		new FlyCartComponents(driver).verifyAllTextsAndFieldsOnNonEmptyFlyCart();
	}

	public void validateAllFieldsOnNonEmptyFlyCart() throws Exception {
		new FlyCartComponents(driver).validateNonEmptyFlyCart();
	}

	public void validateFlyCartOpenedWithQSandPDP() throws Exception {
		new FlyCartComponents(driver).VerifyFlyCartOpenWithQSAndPDP();
	}
}
