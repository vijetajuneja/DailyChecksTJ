package com.tommyjohn.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tommyjohn.automation.Components.CollectionPageComponent;
import com.tommyjohn.automation.Components.HomePageComponents;
import com.tommyjohn.automation.Components.ProductDetailsPageComponents;
import com.tommyjohn.automation.Components.SizeGuideComponents;

public class ProductDetailsPage extends ProductDetailsPageComponents{
	WebDriver driver;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verifyProductDetailsPage() throws Exception {

		new ProductDetailsPageComponents(driver).validateProductDetailsPage();
	}
	public void verifyReviewsSectionOnPDP() throws Exception {


		new ProductDetailsPageComponents(driver).verifyReviewsDisplay();
	}
	public void verifyWriteReviewsFunctionalityOnPDP() throws Exception {


		new ProductDetailsPageComponents(driver).verifyWriteReview();
	
	}
	public void verifyReviewsFieldErrorOnPDP() throws Exception {

		new ProductDetailsPageComponents(driver).verifyWriteReviewErrorMsgs();
	
	}
	public void verifyBundlePDP() throws Exception {

		new ProductDetailsPageComponents(driver).verifybundlepages();
	
	}
	
	public void verifyjointhewaitlist() throws Exception {

		new ProductDetailsPageComponents(driver).VerifyJoinTheWaitlist();
	
	}

	public void verifyrecommendedforyou() throws Exception {
		
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		Thread.sleep(5000);
		new ProductDetailsPageComponents(driver).verifyRecommendedForU();
		
	}
	
	public void verifymysterypack() throws Exception {
		
		new ProductDetailsPageComponents(driver).verifyMysteryPacks();
		
	}
	
	public void VerifyATC_ScrollingCTA() throws Exception
	{
		new ProductDetailsPageComponents(driver).ATC_Scrolling_CTA();
	}
	
	public void VerifySortByReviews() throws Exception
	{
		new ProductDetailsPageComponents(driver).Sort_By_Reviews();
	}
	
	public void VerifyAskAQuestion() throws Exception {
		new ProductDetailsPageComponents(driver).Check_Ask_Question();
	}
	
	public void VerifySelectedSwatchFromPLP() throws Exception
	{
		new ProductDetailsPageComponents(driver).Check_Selected_Swatch();
	}
	
	public void verifyQuicShopforDYRecsOnPDP() throws Exception {

		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		Thread.sleep(5000);
		new ProductDetailsPageComponents(driver).VerifyQuickShopOnRecommendedforYou();
	}

	public void verifyColorSwatchforDYRecsOnPDP() throws Exception {

		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		Thread.sleep(5000);
		new ProductDetailsPageComponents(driver).MethodToCheckColorSwatchOnDYRecs();
	}

	public void verifyProductTileHoverFunctionalityforDYRecsOnPDP() throws Exception {

		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		Thread.sleep(5000);
		new HomePageComponents(driver).RFY_ProductTileHoverFunctionality();
	}
	public void verifyPreselectedSizeOnBraPDP() throws Exception {

		new HomePageComponents(driver).navigateToBraCategory();
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
		element=driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child(2) > a"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		WebElement Triangle_Bralette = driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child(2) > ul > li>label>input#option-style-triangle-bralette"));
		jse.executeScript("arguments[0].click();", Triangle_Bralette);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,150)");
		Check_Preselected_Size();
	}

	public void verifyPreselectedSizeOnBoxerBriefPDP() throws Exception {

		new HomePageComponents(driver).navigateToBoxerBriefInMenCategory();
		Check_Preselected_Size();
	}
	public void verifyPreselectedSizeOnMensUndershirtPDP() throws Exception {

		new HomePageComponents(driver).navigateToAllUnderShirtsInMensCategory();
		Check_Preselected_Size();
	}

	public void verifyPreselectedSizeOnBundlePDP() throws Exception {

		new HomePageComponents(driver).navigateToLoungeWearPacksInWomenPacksCategory();
		Check_Preselected_Size();
	}

	public void verifyLowInventoryMessageOnMensUnderwearPDP() throws Exception {

		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		ErrorMessagewithMaxQTYonPDP();
	}
		
	}
