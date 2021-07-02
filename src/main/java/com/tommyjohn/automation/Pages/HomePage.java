package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.CollectionPageComponent;
import com.tommyjohn.automation.Components.HomePageComponents;
import com.tommyjohn.automation.Components.ProductDetailsPageComponents;

public class HomePage extends HomePageComponents {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void logoandcategoriespresence() throws Exception
	{
		ValidateLogoAndCategoriesPresence();
	}

	public void verifyfooterlinks() throws Exception
	{
		validateFooterLinks();
	}

	public void verifyaccountdropdown() throws Exception
	{

		validateaccountdropdown();
	}

	public void verifycart() throws Exception
	{
		validateCartIcon();
	}

	public void verifyaccounticon() throws Exception
	{
		validateAccountIcon();

	}
	public void validateSearch() throws Exception
	{	

		validateSearchFunctionality();

	}
	public void validateSearchPM() throws Exception
	{
		validateSearchFunction();

	}

	public void validateDoNotSellMyPersonalInformation() throws Exception
	{
		new HomePageComponents(driver).validate_DoNotSellMyPersonalInfo();

	}

	public void verifyrecommendedforyou() throws Exception {

		new ProductDetailsPageComponents(driver).verifyRecommendedForU();
	
	}

	public void verifyQuickShopforDYRecsOnHomePage() throws Exception {

		new HomePageComponents(driver).VerifyQuickShopOnDYRecs();

	}

	public void verifyColorSwatchforDYRecsOnHomePage() throws Exception {

		new HomePageComponents(driver).MethodToCheckColorSwatchOnDYRecs();

	}
	
	public void verifyRFYProductTileHoverFunctionality() throws Exception
	{
		new HomePageComponents(driver).RFY_ProductTileHoverFunctionality();
	}

	
}
