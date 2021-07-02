package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.CollectionPageComponent;
import com.tommyjohn.automation.Components.HomePageComponents;
import com.tommyjohn.automation.Components.ProductDetailsPageComponents;

public class QuickShopPage {
	WebDriver driver;

	public QuickShopPage(WebDriver driver) {
		this.driver=driver;
	}

	public void QuickShopOnCollectionPage() throws Exception
	{
		new HomePageComponents(driver).navigateToBoxerBriefInMenCategory();
		new CollectionPageComponent(driver).QuickShopOnMegaCollection();
	}

	public void QuickShopOnBuyWithSection() throws Exception
	{
		new ProductDetailsPageComponents(driver).QuickShopOnBuyWith();
	}
}
