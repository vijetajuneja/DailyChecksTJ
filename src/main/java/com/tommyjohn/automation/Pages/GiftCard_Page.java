package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.GiftCard_PageComponents;

public class GiftCard_Page extends GiftCard_PageComponents {

	public GiftCard_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void giftCardPageCheck() throws Exception
	{
		new GiftCard_PageComponents(driver).GoToOnGiftCardPage();
	}

	public void verifyfieldsforGCPage() throws Exception{
		new GiftCard_PageComponents(driver).verifyFieldsforGC();
	}
	public void verifyerrormessagesongiftcard() throws Exception{
		new GiftCard_PageComponents(driver).verifyErrorMessagesforGC();

	}

}
