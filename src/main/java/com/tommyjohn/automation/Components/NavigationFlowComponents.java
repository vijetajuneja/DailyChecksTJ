package com.tommyjohn.automation.Components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.PageLocators.NavigationFlowPageLocators;

public class NavigationFlowComponents extends NavigationFlowPageLocators
{

	public WebDriver driver;
	public static WebElement element;
	public Actions action;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	public String currentUrl1;
	public String currentUrl2;
	public NavigationFlowComponents(WebDriver driver)
	{
		this.driver= driver;
	}

	public void NavigatetoAllNewArrivalsInMenCategory() throws Exception
	{
		ValidateMenCategory();
	//	Validate_First_Level1_Category();
		Validate_Second_Level1_Category();
		if(!driver.findElement(MENS_ALL_NEWARRIVALS).isDisplayed())
			throw new Exception("All New Arrivals link in Men category is not displayed");

		driver.findElement(MENS_ALL_NEWARRIVALS).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
			System.out.println("Navigate to all new arrival in mens category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Mens All New arrivals link clicked");

		Reporter.log("All New Arrival in Men category is displayed :: Clickable");
	}

	public void NavigatetoAllNewArrivalsInWomenCategory() throws Exception
	{
		ValidateWomenCategory();
		//Validate_First_Level1_Category();
		Validate_Second_Level1_Category();
		if(!driver.findElement(WOMENS_ALL_NEWARRIVALS).isDisplayed())
			throw new Exception("All New Arrivals link in Women category is not displayed");

		driver.findElement(WOMENS_ALL_NEWARRIVALS).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 

		//if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/womens-new-arrivals")) 
			System.out.println("Navigate to all new arrival in Womens category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Womens New Arrivals link clicked");

		Reporter.log("All New Arrival in Women category is displayed :: Clickable");
	}
	public void NavigatetoAllMensSaleInFinalSaleCategory() throws Exception
	{
		ValidateFinalSaleCategory();
		Validate_First_Level1_Category();
		if(!driver.findElement(ALL_MENS_SALE).isDisplayed())
			throw new Exception("All New Arrivals link in Men category is not displayed");

		driver.findElement(ALL_MENS_SALE).click();
		Thread.sleep(3000);
		System.out.println("Navigate to All Mens sale: " + driver.getCurrentUrl());
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 

		//if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/mens-sale")) 
			System.out.println("Navigate to All Mens sale: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after All Mens Sale link clicked");

		Reporter.log("All Men sale in Final Sale category is displayed :: Clickable");
	}
	public void NavigatetoAllSocksInMenCategory() throws Exception
	{
		ValidateMenCategory();
		Validate_Sixth_Level1_Category();
		if(!driver.findElement(MEN_SOCKS_ALLSOCKS).isDisplayed())
			throw new Exception("All socks link in Men category is not displayed");

		driver.findElement(MEN_SOCKS_ALLSOCKS).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 

		//if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/mens-socks")) 
			System.out.println("Navigate to All Men socks: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after All Mens Socks link clicked");

		Reporter.log("All Men socks is displayed :: Clickable");
	}
	public void NavigatetoAllUnderwearInWomenCategory() throws Exception
	{
		ValidateWomenCategory();
		Validate_Third_Level1_Category();
		if(!driver.findElement(WOMEN_UNDERWEAR_ALLUNDERWEAR).isDisplayed())
			throw new Exception("All underwear link in Women category is not displayed");

		driver.findElement(WOMEN_UNDERWEAR_ALLUNDERWEAR).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 

		//if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/womens-underwear")) 
			System.out.println("Navigate to All unerwear in women category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after All Women underwear link clicked");

		Reporter.log("All underwear link in Women category is displayed :: Clickable");
	}

	
	
	public void NavigatetoBoxerBriefInMensUnderwearCategory() throws Exception
	{
		ValidateMenCategory();
		Validate_Second_Level1_Category();
		if(!driver.findElement(MEN_UNDERWEAR_BOXERBRIEF).isDisplayed())
			throw new Exception("Boxer Brief link in Men underwear category is not displayed");

		driver.findElement(MEN_UNDERWEAR_BOXERBRIEF).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 

//		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/underwear-mens-styles-boxer-brief")) 
			System.out.println("Boxer Brief link in Men underwear category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Boxer Brief link clicked");

		Reporter.log("Boxer Brief link in Men underwear category is displayed :: Clickable");
	}
	public void NavigatetoTeesAndPolosInMensClothingCategory() throws Exception
	{
		ValidateMenCategory();
		Validate_Fifth_Level1_Category();
		if(!driver.findElement(MEN_CLOTHING_TEESandPOLOS).isDisplayed())
			throw new Exception("Tees & Polos link in Men Clothing category is not displayed");

		driver.findElement(MEN_CLOTHING_TEESandPOLOS).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/mens-tees-polos")) 
			System.out.println("Tees & Polos link in Men Clothing category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Tees & Polos link clicked");

		Reporter.log("Tees & Polos link in Men Clothing category is displayed :: Clickable");
	}

	public void NavigatetoScoopBraletteInWomensBrasCategory() throws Exception
	{
		ValidateWomenCategory();
		Validate_Fourth_Level1_Category();
		if(!driver.findElement(WOMEN_BRAS_SCOOPBRALETTE).isDisplayed())
			throw new Exception("Scoop Bralette in womens bras category is not displayed");

		driver.findElement(WOMEN_BRAS_SCOOPBRALETTE).click();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 

			//if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/bra-womens-styles-scoop-bralette")) 
			System.out.println("Scoop Bralette in womens bras category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Scoop Bralette link clicked");

		Reporter.log("Scoop Bralette in womens bras category is displayed :: Clickable");
	}

	public void NavigatetoComfortSmoothingInWomenCollectionCategory() throws Exception
	{
		ValidateWomenCategory();
		Validate_Sixth_Level1_Category();
		if(!driver.findElement(WOMEN_COLLECTION_COMFORTSMOOTHING).isDisplayed())
			throw new Exception("Comfort smoothing in women collections category is not displayed");

		driver.findElement(WOMEN_COLLECTION_COMFORTSMOOTHING).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 

		//if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/comfort-smoothing-plp")) 
			System.out.println("Comfort smoothing in women collections category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Comfort smoothing in women collections link clicked");

		Reporter.log("Comfort smoothing in women collections category is displayed :: Clickable");
	}

	public void NavigatetoWomenSaleUnderwearInFinalSaleCategory() throws Exception
	{
		ValidateFinalSaleCategory();
		Validate_Second_Level1_Category();
		if(!driver.findElement(FINALSALE_WOMENSALE_UNDERWEAR).isDisplayed())
			throw new Exception("Women sale Underwear in final sale category is not displayed");

		driver.findElement(FINALSALE_WOMENSALE_UNDERWEAR).click();
	
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
		//		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/womens-sale-underwear")) 
			System.out.println("Women sale Underwear in final sale category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Women sale Underwear link clicked");

		Reporter.log("Women sale Underwear in final sale category is displayed :: Clickable");
	}
	public void NavigatetoVNeckInMenUndershirtsCategory() throws Exception
	{
		ValidateMenCategory();
		Validate_Third_Level1_Category();
		if(!driver.findElement(MEN_UNDERSHIRTS_VNECK).isDisplayed())
			throw new Exception("V Neck in men undershirts category is not displayed");

		driver.findElement(MEN_UNDERSHIRTS_VNECK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/mens-high-v-neck-undershirts")) 
			System.out.println("V Neck in men undershirts category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after V Neck undershirts link clicked");

		Reporter.log("V Neck in men undershirts category is displayed :: Clickable");
	}
	public void NavigatetoTopsLoungeAndSleepInMenCategory() throws Exception
	{
		ValidateMenCategory();
		Validate_Fourth_Level1_Category();
		if(!driver.findElement(MEN_LOUNGEANDSLEEP_TOPS).isDisplayed())
			throw new Exception("Tops in men Lounge & Sleep category is not displayed");

		driver.findElement(MEN_LOUNGEANDSLEEP_TOPS).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/mens-lounge-sleep-tops")) 
			System.out.println("Tops in men Lounge & Sleep category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Tops in men's Lounge & Sleep link clicked");

		Reporter.log("Tops in men Lounge & Sleep category is displayed :: Clickable");
	}
	public void NavigatetoCalfSocksInMenCategory() throws Exception
	{
		ValidateMenCategory();
		Validate_Sixth_Level1_Category();
		if(!driver.findElement(MEN_SOCKS_CALF).isDisplayed())
			throw new Exception("Calf Socks in men category is not displayed");

		driver.findElement(MEN_SOCKS_CALF).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/calf-socks")) 
			System.out.println("Calf Socks in men category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Men's Calf Socks link clicked");

		Reporter.log("Calf Socks in men category is displayed :: Clickable");
	}
	public void NavigatetoCheekyUnderwearInWomenCategory() throws Exception
	{
		ValidateWomenCategory();
		Validate_Third_Level1_Category();
		if(!driver.findElement(WOMEN_UNDERWEAR_CHEEKY).isDisplayed())
			throw new Exception("Cheeky Underwear in Women's category is not displayed");

		driver.findElement(WOMEN_UNDERWEAR_CHEEKY).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/underwear-womens-styles-cheeky")) 
			System.out.println("Cheeky Underwear in Women's category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Cheeky underwear link clicked");

		Reporter.log("Cheeky Underwear in Women's category is displayed :: Clickable");
	}
	public void NavigatetoMensLoungeAndSleepInFinalSaleCategory() throws Exception
	{
		ValidateFinalSaleCategory();
		Validate_First_Level1_Category();
		if(!driver.findElement(FINALSALE_MENSALE_LOUNGEANDSLEEP).isDisplayed())
			throw new Exception("Men's Lounge & Sleep in Final Sale category is not displayed");

		driver.findElement(FINALSALE_MENSALE_LOUNGEANDSLEEP).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/mens-sale-lounge-sleep")) 
			System.out.println("Men's Lounge & Sleep in Final Sale category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Men's Lounge & Sleep link clicked");

		Reporter.log("Men's Lounge & Sleep in Final Sale category is displayed :: Clickable");
	}

	public void NavigatetoButtonDownsInMenCategory() throws Exception
	{
		ValidateMenCategory();
		Validate_Fifth_Level1_Category();
		if(!driver.findElement(MEN_CLOTHING_BUTTONDOWNS).isDisplayed())
			throw new Exception("Button Downs in men category is not displayed");

		driver.findElement(MEN_CLOTHING_BUTTONDOWNS).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/mens-shirts")) 
			System.out.println("Button Downs in men category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Men's Button Downs link clicked");

		Reporter.log("Button Downs in men category is displayed :: Clickable");
	}
	public void NavigatetoDressesInWomenCategory() throws Exception
	{
		ValidateWomenCategory();
		Validate_Fifth_Level1_Category();
		if(!driver.findElement(WOMEN_CLOTHING_DRESSES).isDisplayed())
			throw new Exception("Dresses in Women category is not displayed");

		driver.findElement(WOMEN_CLOTHING_DRESSES).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/womens-dresses")) 
			System.out.println("Dresses in Women category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Women's Dresses link clicked");

		Reporter.log("Dresses in Women category is displayed :: Clickable");
	}
	public void NavigatetoPacks_LoungeAndSleep_InWomenCategory() throws Exception
	{
		ValidateWomenCategory();
		Validate_Fourth_Level1_Category();
		if(!driver.findElement(WOMEN_LOUNGEANDSLEEP_PACKS).isDisplayed())
			throw new Exception("Packs in Women's Lounge & Sleep category is not displayed");

		driver.findElement(WOMEN_LOUNGEANDSLEEP_PACKS).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().startsWith("https://tommyjohn.com/collections")) 
//	if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/collections/womens-lounge-sleep-packs")) 
			System.out.println("Packs in Women's Lounge & Sleep category: " + driver.getCurrentUrl());
		else
			throw new Exception("Wrong page opened after Women's packs link clicked");

		Reporter.log("Packs in Women's Lounge & Sleep category is displayed :: Clickable");
	}




	public void ValidateMenCategory() throws Exception
	{
		action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(HomePageLocators.MEN_CATEGORY));
		if(!driver.findElement(HomePageLocators.MEN_CATEGORY).isDisplayed())
			throw new Exception("Men category is not present");	

		element = driver.findElement(HomePageLocators.MEN_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(HomePageLocators.FIRST_lEVEL1_CATEGORY).isEnabled())
			throw new Exception("Men Category is not hoverable");
		Thread.sleep(3000);
		Reporter.log("Men category is displayed :: Hoverable");
	}

	public void ValidateWomenCategory() throws Exception
	{
		action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(WOMEN_CATEGORY));
		if(!driver.findElement(WOMEN_CATEGORY).isDisplayed())
			throw new Exception("Women category is not displayed");
		element = driver.findElement(WOMEN_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(FIRST_lEVEL1_CATEGORY).isDisplayed())
			throw new Exception("Men Category is not hoverable");
		Reporter.log("Women category is Displayed :: Hoverable :: Clickable");
		Thread.sleep(3000);

	}

	public void ValidateFinalSaleCategory() throws Exception
	{
		action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(FINAL_SALE));
		if(!driver.findElement(FINAL_SALE).isDisplayed())
			throw new Exception("Final Sale category is not displayed");
		element = driver.findElement(FINAL_SALE);
		action.moveToElement(element).perform();
		if(!driver.findElement(FIRST_lEVEL1_CATEGORY).isDisplayed())
			throw new Exception("Final Sale category is not hoverable");
		Reporter.log("Final Sale category is Displayed :: Hoverable :: clickable");
	}
	public void Validate_First_Level1_Category() throws Exception
	{
		element = driver.findElement(HomePageLocators.FIRST_lEVEL1_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(HomePageLocators.FIRST_lEVEL1_CATEGORY).isEnabled())
			throw new Exception("First level1 category is not hoverable");
		Thread.sleep(3000);

	}


	public void Validate_Second_Level1_Category() throws Exception
	{
		element = driver.findElement(HomePageLocators.SECOND_lEVEL1_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(HomePageLocators.SECOND_lEVEL1_CATEGORY).isEnabled())
			throw new Exception("Second level1 category is not hoverable");
		Thread.sleep(3000);

	}
	public void Validate_Third_Level1_Category() throws Exception
	{
		element = driver.findElement(HomePageLocators.THIRD_lEVEL1_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(HomePageLocators.THIRD_lEVEL1_CATEGORY).isEnabled())
			throw new Exception("Third level1 category is not hoverable");
		Thread.sleep(3000);

	}

	public void Validate_Fourth_Level1_Category() throws Exception
	{
		element = driver.findElement(HomePageLocators.FOURTH_lEVEL1_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(HomePageLocators.FOURTH_lEVEL1_CATEGORY).isEnabled())
			throw new Exception("Fourth level1 category is not hoverable");
		Thread.sleep(3000);

	}


	public void Validate_Fifth_Level1_Category() throws Exception
	{
		element = driver.findElement(HomePageLocators.FIFTH_lEVEL1_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(HomePageLocators.FIFTH_lEVEL1_CATEGORY).isEnabled())
			throw new Exception("Fifth level1 category is not hoverable");
		Thread.sleep(3000);

	}

	public void Validate_Sixth_Level1_Category() throws Exception
	{
		element = driver.findElement(HomePageLocators.SIXTH_lEVEL1_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(HomePageLocators.SIXTH_lEVEL1_CATEGORY).isEnabled())
			throw new Exception("Sixth level1 category is not hoverable");
		Thread.sleep(3000);

	}

	public void Validate_Seventh_Level1_Category() throws Exception
	{
		element = driver.findElement(HomePageLocators.SEVENTH_lEVEL1_CATEGORY);
		action.moveToElement(element).perform();
		if(!driver.findElement(HomePageLocators.SEVENTH_lEVEL1_CATEGORY).isEnabled())
			throw new Exception("Seventh level1 category is not hoverable");
		Thread.sleep(3000);

	}

}
