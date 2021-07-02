package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.PhysicalGiftCardComponents;

public class PhysicalGiftCardPage extends PhysicalGiftCardComponents
{

	public PhysicalGiftCardPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}

	public void PhysicalgiftCardPageCheck() throws Exception
	{
		new PhysicalGiftCardComponents(driver).GoToOnPhysicalGiftCardPage();
	}

	public void verifyfieldsforGCPage() throws Exception{
		new PhysicalGiftCardComponents(driver).verifyFieldsforPhysicalGC();
	}
	
}
