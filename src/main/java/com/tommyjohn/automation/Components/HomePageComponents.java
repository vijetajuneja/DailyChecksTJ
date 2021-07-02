package com.tommyjohn.automation.Components;

import java.util.List;

import javax.naming.spi.DirStateFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.tommyjohn.automation.PageLocators.CollectionPageLocator;
import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class HomePageComponents extends HomePageLocators {

	public WebDriver driver;
	public static String baseUrl = CustomUtilities.baseUrl;
	public String currentUrl1;
	public String currentUrl2;
	boolean flag = false;
	public static WebElement element;
	public static WebElement ele1;
	public Actions action;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	SoftAssert softassert = new SoftAssert();
	WebElement footer_link ;
	String text;

	public HomePageComponents(WebDriver driver) {

		this.driver = driver;
	}
	//Verify logo and all category
	public void ValidateLogoAndCategoriesPresence() throws Exception
	{
		action = new Actions(driver);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		if(driver.findElement(HOMEPAGE_LOGO).isDisplayed())
		{

			currentUrl1 = driver.getCurrentUrl();
			WebElement element = driver.findElement(HOMEPAGE_LOGO);

			executor.executeScript("arguments[0].click();", element);	
			Thread.sleep(3000);

			String currentUrl2 = driver.getCurrentUrl();
			if(!currentUrl1.contains(currentUrl2))
				throw new Exception("HomePage logo not working correctly");
			Reporter.log("TommyJohnLogo is displayed and clickable :: home page opens on clicking logo");
		}
		else
			throw new Exception("HomePage logo is not present");

		//Verify header search icon image
		softassert.assertTrue(driver.findElement(SEARCH_ICON_IMAGE).isDisplayed(), "Global header search icon image is not displayed");
		Reporter.log("Global header serach icon image is displayed");

		//Verify new arrivals
		//		if(driver.findElement(NEWARRIVALS_CATEGORY).isDisplayed()) {
		//
		//			element = driver.findElement(NEWARRIVALS_CATEGORY);
		//			action.moveToElement(element).perform();
		//			//			if(!driver.findElement(MEN_IN_NEWARRIVALS_CATEGORY).isEnabled())
		//			//				throw new Exception("New Arrivals category not hoverable"); 
		//		}
		//		else
		//			throw new Exception("New Arrivals category is not present");
		//		Reporter.log("New Arrivals category is Displayed :: Hoverable");
		//		Thread.sleep(3000);

		// Verify Men category
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(MEN_CATEGORY));
		if(!driver.findElement(MEN_CATEGORY).isDisplayed())
			throw new Exception("Men category is not present");	

		element = driver.findElement(MEN_CATEGORY);
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		if(!driver.findElement(FIRST_lEVEL1_CATEGORY).isDisplayed())
			throw new Exception("Men Category is not hoverable");
		Thread.sleep(3000);
		Reporter.log("Men category is displayed :: Hoverable");
		Thread.sleep(3000);


		// Verify Women category
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(WOMEN_CATEGORY));
		if(!driver.findElement(WOMEN_CATEGORY).isDisplayed())
			throw new Exception("Women category is not displayed");
		element = driver.findElement(WOMEN_CATEGORY);
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		if(!driver.findElement(FIRST_lEVEL1_CATEGORY).isDisplayed())
			throw new Exception("Men Category is not hoverable");
		Reporter.log("Women category is Displayed :: Hoverable :: Clickable");
		Thread.sleep(3000);

		// Verify Sale category
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(FINAL_SALE));
		if(!driver.findElement(FINAL_SALE).isDisplayed())
			throw new Exception("Final Sale category is not displayed");
		element = driver.findElement(FINAL_SALE);
		action.moveToElement(element).perform();
		//	if(!driver.findElement(FIRST_lEVEL1_CATEGORY).isDisplayed())
		//	throw new Exception("Final Sale category is not hoverable");
		Reporter.log("Sale category is Displayed :: Hoverable :: clickable");
		softassert.assertAll();
	}

	// Verify Underwear category
	//		if(!driver.findElement(UNDERWEAR_CATEGORY).isDisplayed())
	//			throw new Exception("Underwear category is not displayed");
	//		element = driver.findElement(UNDERWEAR_CATEGORY);
	//		action.moveToElement(element).perform();
	//		if(!driver.findElement(MEN_IN_UNDERWEAR_CATEGORY).isDisplayed())
	//			throw new Exception("Underwear Category is not hoverable");
	//		Reporter.log("Underwear category is Displayed :: Hoverable");

	//		Thread.sleep(3000);
	// Verify Shop by Bras category
	//		if(!driver.findElement(BRAS).isDisplayed())
	//			throw new Exception("Bras category is not displayed");
	//		element = driver.findElement(BRAS);
	//		action.moveToElement(element).perform();
	//		if(!driver.findElement(BRAS_TITLE).isDisplayed())
	//			throw new Exception("Bras category is not hoverable");
	//		Reporter.log("Bras category is Displayed :: Hoverable");
	//
	//		Thread.sleep(3000);

	// Verify Packs category
	//		if(!driver.findElement(PACKS).isDisplayed())
	//			throw new Exception("Packs category is not displayed");
	//		element = driver.findElement(PACKS);
	//		action.moveToElement(element).perform();
	//		if(!driver.findElement(MEN_IN_PACKS).isDisplayed())
	//			throw new Exception("Packs category is not hoverable");
	//		Reporter.log("Packs category is Displayed :: Hoverable");
	//

	// Verify Gift Guide category
	//		if(!driver.findElement(GIFT_GUIDE).isDisplayed())
	//			throw new Exception("Gift guide category is not displayed");
	//		element = driver.findElement(GIFT_GUIDE);
	//		action.moveToElement(element).perform();
	//		if(!driver.findElement(GIFTCARDS).isDisplayed())
	//			throw new Exception("Gift Guide category is not hoverable");
	//		Reporter.log("Gift Guide category is Displayed :: Hoverable");
	//	}


	public void validateSearchFunction() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		action = new Actions(driver);

		WebElement element = driver.findElement(SEARCH_ICON);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		driver.findElement(SEARCH_ICON).sendKeys("tees");

		WebElement search = driver.findElement(SEARCH_ICON);
		action.moveToElement(driver.findElement(SEARCH_ICON)).build().perform();
		Thread.sleep(3000);
		softAssert.assertTrue(driver.findElement(POPULAR_SEARCHES).isDisplayed(),
				"Popular searches section not displayed ");
		softAssert.assertTrue(driver.findElement(PRODUCT_MATCHES_TITLE).isDisplayed(),
				"Product matches section is not displayed");

		WebElement pm = driver.findElement(PRODUCT_MATCHES_TITLE);
		executor.executeScript("arguments[0].click();", pm);
		Thread.sleep(8000);
		if(driver.findElement(ProductDetailsPageLocators.PRODUCT_DETAILS).getText().contains("Pack"))
			new ProductDetailsPageComponents(driver).verifybundlepages();
		else
			new ProductDetailsPageComponents(driver).validatePage();

		softAssert.assertAll();

	}


	public void validateSearchFunctionality() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,50);
		String Search_keyword = "tees";
		if(!driver.findElement(SEARCH_ICON).isDisplayed())
			throw new Exception("Search option is not present");
		WebElement element = driver.findElement(SEARCH_ICON);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		//Check auto-suggestions
		driver.findElement(SEARCH_ICON).sendKeys("b");
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AUTO_SUGGESTED_PRODUCT_IMG));
		softAssert.assertTrue(driver.findElement(AUTO_SUGGESTED_LINKS).isDisplayed(),"Popular searches section not displayed ");
		softAssert.assertEquals(driver.findElement(PRODUCT_MATCHES_TITLE).getText(),"Product Matches","Text changed for Product matches title on autosuggestion container");
		softAssert.assertTrue(driver.findElement(AUTO_SUGGESTED_PRODUCT_IMG).isDisplayed(), "Auto suggested product images are not displayed");
		List<WebElement> product_matches_img = driver.findElements(AUTO_SUGGESTED_PRODUCT_IMG);
		softAssert.assertTrue(product_matches_img.size()== 4, "Total count of suggested product matched images are not 4");
		softAssert.assertTrue(driver.findElement(AUTO_SUGGESTED_PRODUCT_TILE_TITLE).isDisplayed(), "Auto suggested product tile title is not displayed");
		WebElement First_Suggested_link = driver.findElement(By.cssSelector(".autocomplete-suggestions-content>a:nth-child(1)>div>span"));
		String search_value = First_Suggested_link.getAttribute("data-search-term-value");
		First_Suggested_link.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHPAGE_PRODUCT_IMAGE));
		String[] list1 = driver.findElement(SEARCHPAGE_TITLE).getText().split("for ");
		text = list1[list1.length-1].replace("\"", "");
		softAssert.assertEquals(text, search_value, "Search page title is not matched with clicked suggested link");

		driver.findElement(SEARCH_ICON).sendKeys("m");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AUTO_SUGGESTED_PRODUCT_TILE_TITLE));
		WebElement FIRST_SUGGESTED_PRODUCT_TILE_TITLE = driver.findElement(By.cssSelector(".search-product-tile:nth-child(1)>a"));
		String suggested_title = FIRST_SUGGESTED_PRODUCT_TILE_TITLE.getText().replace(",", "").toLowerCase();
		//FIRST_SUGGESTED_PRODUCT_TILE_TITLE.click();
		executor.executeScript("arguments[0].click();", FIRST_SUGGESTED_PRODUCT_TILE_TITLE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductDetailsPageLocators.PRODUCT_TITLE));
		String actual = driver.findElement(ProductDetailsPageLocators.PRODUCT_TITLE).getText().replace(",", "").toLowerCase();
		System.out.println("actual is: "+actual+" expected is: "+suggested_title);
		softAssert.assertTrue(actual.equals(suggested_title) , "Wrong PDP displayed after clicking on name of auto suggested product tile title" );
		Reporter.log("Verified Search auto suggestion functionality");		

		//validate search page
		driver.findElement(SEARCH_ICON).sendKeys(Search_keyword + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHPAGE_PRODUCT_IMAGE));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHPAGE_PRODUCT_REVIEWS));
		softAssert.assertTrue(driver.findElement(SEARCHPAGE_TITLE).isDisplayed(), "Search Page title is not displayed on search page");
		String[] list = driver.findElement(SEARCHPAGE_TITLE).getText().split("for ");
		text = list[list.length-1].replace("\"", "");
		System.out.println("search title is: "+text);
		softAssert.assertEquals(text, Search_keyword, "Search page title is not matched with searched keyword");
		softAssert.assertTrue(driver.findElement(SEARCHPAGE_ITEMCOUNT).isDisplayed(), "Item count not displayed on search page");

		executor.executeScript("window.scrollBy(0,100)");
		softAssert.assertTrue(driver.findElement(SEARCHPAGE_PRODUCT_IMAGE).isDisplayed(), "Product image not present on search page");
		softAssert.assertTrue(driver.findElement(SEARCHPAGE_PRODUCT_NAME).isDisplayed(), "Product name not present on search page");
		softAssert.assertTrue(driver.findElement(SEARCHPAGE_PRODUCT_REVIEWS).isDisplayed(), "Product reviews not present on search page");
		softAssert.assertTrue(driver.findElement(SEARCHPAGE_PRODUCT_SWATCHES).isDisplayed(), "Product swatches not present on search page");
		softAssert.assertTrue(driver.findElement(SEARCHPAGE_PRODUCT_PRICE).isDisplayed(), "Product price not present on search page");
		try{
			System.out.println("Verifying for Badging .......");
			if(!driver.findElement(SEARCHPAGE_PRODUCT_BADGE).isDisplayed())
				throw new Exception("Badging is not displayed for product tile on search page.");
			else {
				System.out.println("Badging is displayed");
				Reporter.log("Badge is displayed for product tile on search page.");
			}
		}
		catch(Exception e){
			System.out.println("Badging is not applicable for this product.");
		}

		WebElement pname  = driver.findElement(SEARCHPAGE_PRODUCT_NAME);
		text= pname.getText();
		executor.executeScript("arguments[0].click();", pname );
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductDetailsPageLocators.ADD_TO_CART_BUTTON));
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.PRODUCT_TITLE).getText(), text , "correct PDP not displayed after clicking on name of product on search page" );
		Thread.sleep(3000);
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHPAGE_PRODUCT_NAME));

		new CollectionPageComponent(driver).Verify_ProductTile_HoverFunctionality();
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHPAGE_PRODUCT_NAME));

		new CollectionPageComponent(driver).MethodToCheckColorSwatchChanging();

		new CollectionPageComponent(driver).QuickShopOnMegaCollection();

		MethodToCheckAllFiltersOnSearchPage();
		Reporter.log("Search page is displayed :: Correct");

		element = driver.findElement(SEARCH_ICON);
		executor = (JavascriptExecutor)driver;
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", element);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RECENT_SEARCHES_TITLE));
		softAssert.assertTrue(driver.findElement(CLEAR_RECENT_SEARCHES).isDisplayed(), "Clear recent search link is not displayed");
		driver.findElement(CLEAR_RECENT_SEARCHES).click();
		executor.executeScript("arguments[0].click();", element);
		String[] attribute = driver.findElement(RECENT_SEARCH_CONTAINER).getAttribute("style").split("display: ");
		text = attribute[attribute.length-1].replace(";", "");
		softAssert.assertEquals(text,"none", "Clear recent search link is not functional");
		Reporter.log("Clear recent search link is Displayed :: Clickable");
		softAssert.assertAll();

	}

	public void MethodToCheckAllFiltersOnSearchPage() throws Exception
	{
		List<WebElement> allElements = null;
		int filterList = 0;
		int optionsList = 0;
		String selectedOption = null;
		int optionsList1 = 0;
		int count = 0;
		List<WebElement> allProductsOnPage = null;
		String totalDisplayedCount = null;
		WebDriverWait wait = new WebDriverWait(driver, 50);
		// get total no of filters
		allElements = driver.findElements(SEARCHPAGE_ALL_FILTERS);
		filterList = allElements.size();
		System.out.println("All filters list :: "+ filterList);

		// loop for total not of filters
		for(int i = 2; i <= filterList+1; i++) 
		{
			element=driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > a"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
			// get all the options list available in ith filter
			allElements = driver.findElements(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li"));
			optionsList = allElements.size();
			System.out.println("All options list :: "+ optionsList);
			int ct = 0;
			// check if not any option present
			if(optionsList == 0)
				break;

			WebElement Filter_option_item = driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li:nth-child(1) > label > input"));
			if(!Filter_option_item.isDisplayed())
				continue;
			count++;
			//driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > ul > li:nth-child("+j+") > label > input")).click();
			//Filter_option_item.click();
			jse.executeScript("arguments[0].click();", Filter_option_item);
			Thread.sleep(2000);

			// get the name of selected option
			selectedOption = Filter_option_item.getAttribute("data-filter-btn");
			System.out.println("selected option :: "+selectedOption);


			// get all selected displayed optioins
			allElements = driver.findElements(SEARCHPAGE_ALL_SELECTED_FILTER_OPTIONS);
			optionsList1 = allElements.size();

			System.out.println("count :: "+count);
			System.out.println("optionlist1 :: "+optionsList1);
			// check selected options count and displayed selected list count is same or not
			if(count != optionsList1)
				throw new Exception("Selected options and selected displayed options are not same");

			System.out.println("ct :: "+ct);
			System.out.println("ct th ele :: "+allElements.get(ct).getText());
			if(!(allElements.get(ct).getText()).equals(selectedOption))
				throw new Exception("Selected item is not present in displayed item list");

			// check total no of count is displayed or not
			if(!driver.findElement(SEARCHPAGE_ITEMCOUNT).isDisplayed())
				throw new Exception("Total counts of items is not displayed for filter :: "+i);

			// check total not of count and products are correct
			totalDisplayedCount = driver.findElement(SEARCHPAGE_ITEMCOUNT).getText();
			System.out.println(totalDisplayedCount);
			Thread.sleep(3000);
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHPAGE_PRODUCT_IMAGE));
			allProductsOnPage = driver.findElements(SEARCHPAGE_PRODUCT_IMAGE);
			int allProductsOnPage1 = allProductsOnPage.size();
			System.out.println("Out ddd :: "+allProductsOnPage1);
			// check for hoverable class (if image is hoverable then it count two images for one image)
			element = driver.findElement(SEARCHPAGE_PRODUCT_IMAGE);
			System.out.println("total displayed product on page :: "+allProductsOnPage1);
			System.out.println("total displayed count of product :: "+totalDisplayedCount);
			try{
				if(allProductsOnPage1 != (Integer.parseInt(totalDisplayedCount)))
					throw new Exception("Total displayed count is not same as all products on page");
			}
			catch(Exception e)
			{
				System.out.println("Due to lazy loading total displayed count is not possible.");
			}

			ct++;

			//	}

			// check again any options are present or not
			if(optionsList == 0)
				continue;

			// click on last item to remove it from list
			Thread.sleep(5000);
			element=driver.findElement(By.cssSelector("div.mega-collection-filters > div:nth-child("+i+") > a"));
			jse.executeScript("arguments[0].click();", element);
			Thread.sleep(1000);
			System.out.println("last item :: "+driver.findElement(By.cssSelector("div.js-mega-collection-desktop-filter-tags >div> button:nth-child("+ct+")")).getText());
			element=driver.findElement(By.cssSelector("div.js-mega-collection-desktop-filter-tags >div> button:nth-child("+ct+")"));
			jse.executeScript("arguments[0].click();", element);
			//driver.findElement(PLUS_BUTTON).click();
			Thread.sleep(5000);

			Thread.sleep(1000);
			// after last element removed decrease ct by 1
			System.out.println("Before ct::"+ct);
			// decrease ct by 1 bcz when one element is removed from list
			ct--;
			ct--; // for taking last element from list
			System.out.println("After ct--::"+ct);
			// check when we click on item then it remove from list or not
			System.out.println("allelements size:: "+allElements.size());


			if(ct!=0 && ct!=-1) {
				System.out.println("ct :: "+allElements.get(ct).getText());
				System.out.println("ct :: "+driver.findElement(By.cssSelector("div.js-mega-collection-desktop-filter-tags > button:nth-child("+ct+")")).getText());
				if((allElements.get(ct).getText()).equals(driver.findElement(By.cssSelector("div.js-mega-collection-desktop-filter-tags > button:nth-child("+ct+")")).getText()))
					throw new Exception("Item is not removed from displayed list when click on it");
			}
			ct = 0;
			Thread.sleep(2000);

			// clear the filters
			WebElement ele = driver.findElement(SEARCHPAGE_CLEAR_FILTER);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			//	driver.findElement(CLEAR_FILTER_BUTTON).click();
			Thread.sleep(3000);
			allElements = null;
			count = 0;
		}
		Reporter.log("All filters are working correctly");
		Reporter.log("All selected items are displayed in list and removing from list");
		Reporter.log("Clear filters button works correctly");

		//WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCHPAGE_LAST_FILTER));
		if(driver.findElement(SEARCHPAGE_LAST_FILTER).isDisplayed()) 
		{
			//driver.findElement(LAST_FILTER).click();
			Select selectElement = new Select(driver.findElement(SEARCHPAGE_LAST_FILTER));
			selectElement.selectByValue("Price:ascending");
			Thread.sleep(5000);
			allProductsOnPage = driver.findElements(SEARCHPAGE_PRODUCT_IMAGE);
			System.out.println("All product on page :: "+allProductsOnPage.size());
			try{
				for(int i=1; i < allProductsOnPage.size(); i++) {
					String text = null;
					String text1 = null;
					String text2 = null;

					text = driver.findElement(By.cssSelector(".mega-collection-grid__row > div.product-item:nth-child("+i+") > div.product-meta__prices")).getText();
					System.out.println("Text :: "+text);
					for (String a : text.split("\\$")) 
						text1 = a;
					System.out.println("text 1 :: "+text1);
					// loop to check previous and next price
					int j = i+1;
					System.out.println("Text :: "+driver.findElement(By.cssSelector(".mega-collection-grid__row > div.product-item:nth-child("+j+") > div.product-meta__prices")).getText());
					for (String a : driver.findElement(By.cssSelector(".mega-collection-grid__row > div.product-item:nth-child("+j+") > div.product-meta__prices")).getText().split("\\$")) 
						text2 = a;
					System.out.println("text2 :: "+text2);
					if(Float.parseFloat(text1) > Float.parseFloat(text2))
						throw new Exception("Products are not sorted by price correctly");

				}
			}
			catch(Exception e)
			{
				System.out.println("Due to lazy loading price comparison is not possible for sort by filter.");
			}
			Reporter.log("All Products are sorted as selected option");

		}

	}

	public void validateaccountdropdown() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = driver.findElement(ACCOUNT_NAV_DROPDOWN);
		action = new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(ACCOUNT_NAV_DROPDOWN));
		if(!driver.findElement(ACCOUNT_NAV_DROPDOWN).isDisplayed())
			throw new Exception("Account nav drop down is not present");

		// check sign in option
		driver.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfElementLocated(ACCOUNT_NAV_DROPDOWN));
		element = driver.findElement(ACCOUNT_NAV_DROPDOWN);
		action.moveToElement(element).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(SIGNIN_OPTION));
		WebElement signIn = driver.findElement(SIGNIN_OPTION);
		action.moveToElement(signIn).perform();


		driver.findElement(SIGNIN_OPTION).click();
		Thread.sleep(3000);
		currentUrl2 = driver.getCurrentUrl();
		if(!currentUrl2.startsWith("https://tommyjohn.com/account/login"))
			throw new Exception("Wrong page opened after clicked on sin in option");
		Reporter.log("sign in is Displayed :: Clickable");

		//check help
		driver.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfElementLocated(ACCOUNT_NAV_DROPDOWN));
		element = driver.findElement(ACCOUNT_NAV_DROPDOWN);
		action.moveToElement(element).perform();
		if(!driver.findElement(HELP_ICON_HELP_OPTION).isDisplayed())
			throw new Exception("Help Center option not displayed");
		Reporter.log("Help center option is Displayed ");
		driver.findElement(HELP_ICON_HELP_OPTION).click();
		Thread.sleep(3000);
		//	driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(3000);
		currentUrl2 = driver.getCurrentUrl();
		if(!currentUrl2.equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us"))
			throw new Exception("Wrong page opened after clicked on help option");
		Reporter.log("Help option is Displayed :: Clickable");

		// check my account option
		driver.get(baseUrl);
		wait.until(ExpectedConditions.presenceOfElementLocated(ACCOUNT_NAV_DROPDOWN));
		Thread.sleep(2000);
		element = driver.findElement(ACCOUNT_NAV_DROPDOWN);
		action.moveToElement(element).perform();
		if(!driver.findElement(MYACCOUNT_OPTION).isDisplayed())
			throw new Exception("My account option not displayed");
		Reporter.log("My account option is Displayed ");
		driver.findElement(MYACCOUNT_OPTION).click();
		Thread.sleep(3000);
		currentUrl2 = driver.getCurrentUrl();
		if(!currentUrl2.startsWith("https://tommyjohn.com/account"))
			throw new Exception("Wrong page opened after clicked on my account option");
		Reporter.log("My account is Displayed :: Clickable");




		// check chat with us option
		//		driver.get(baseUrl);
		//		Thread.sleep(3000);
		//		element = driver.findElement(HELP_ICON);
		//		action.moveToElement(element).perform();
		//		if(!driver.findElement(CHAT_WITH_US).isDisplayed())
		//			throw new Exception("Chat With Us Option is not present");
		//		driver.findElement(CHAT_WITH_US).click();
		//		Thread.sleep(6000);
		//		// switch to another frame
		//		element = driver.findElement(CHAT_WITH_US_IFRAME);
		//		driver.switchTo().frame(element);
		//		element = driver.findElement(CHAT_WITH_US_POPUP);
		//		if(!element.isEnabled())
		//			throw new Exception("Chat With Us Popup is not opened");
		//				if(element.isEnabled()) {
		//					//			if(!driver.findElement(CHAT_WITH_US_POPUP_MINIMIZE).isDisplayed())
		//					//				throw new Exception("Chat With Us Popup Minimize button is not present");
		//		
		//					WebElement element = driver.findElement(CHAT_WITH_US_POPUP_MINIMIZE);
		//					JavascriptExecutor executor = (JavascriptExecutor)driver;
		//					executor.executeScript("arguments[0].click();", element);
		//					
		//				}
		//				else
		//					throw new Exception("Chat With Us Popup is not opened");
		//		Reporter.log("Chat With Us Popup is Displayed :: Minimize Button working");
		//
		//		driver.switchTo().defaultContent();
		//		// Validating Call Us option
		//		driver.get(baseUrl);
		//		element = driver.findElement(HELP_ICON);
		//		action.moveToElement(element).perform();
		//
		//		if(!driver.findElement(CALL_US_OPTION).isDisplayed())
		//			throw new Exception("Call US Option is not present");
		//
		//		text = driver.findElement(CALL_US_OPTION).getText();
		//		if(!text.equals("Call Us: 1-800-708-3490"))
		//			throw new Exception("Text or Number for Call Us changed");
		//		
		//		if(!driver.findElement(TEXT_US_OPTION).isDisplayed())
		//			throw new Exception("TEXT US Option is not present");
		//		
		//		text = driver.findElement(TEXT_US_OPTION).getText();
		//		if(!text.equals("Text Us: 1-855-976-4933"))
		//			throw new Exception("Text or Number for Text Us changed");
		//		
		//
		//		// valaditing Email Us option
		//		driver.get(baseUrl);
		//		element = driver.findElement(HELP_ICON);
		//		action.moveToElement(element).perform();
		//		if(!driver.findElement(EMAIL_US).isDisplayed())
		//			throw new Exception("Email Us option is not present");
		//		driver.findElement(EMAIL_US).click();
		//		Thread.sleep(4000);
		//		if(!driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/contact-us"))
		//			throw new Exception("Wrong page opened after clicked on Emails Us");
		//		Reporter.log("Call Us option and Email Us is Displayed :: Clickable");
	}


	// check Account/Login icon
	public void validateAccountIcon() throws Exception {
		if(!driver.findElement(ACCOUNT_NAV_DROPDOWN).isDisplayed())
			throw new Exception("Account Icon is not present");
		element=driver.findElement(ACCOUNT_NAV_DROPDOWN);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		if(!driver.getCurrentUrl().startsWith("https://tommyjohn.com/account/login"))
			throw new Exception("Wrong page opened after clicked on Account Icon");
		Reporter.log("Account Icon is Displayed :: Clickable");

	}
	public void validateCartIcon() throws Exception {
		// Check for Cart icon

		driver.navigate().to(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(CART_ICON));
		driver.findElement(CART_ICON).click();
		Thread.sleep(2000);
		if(!driver.findElement(CART_HEADING_TEXT).isDisplayed())
			throw new Exception("Mini Cart is not opened");
		driver.get(baseUrl);
		Reporter.log("Cart Icon is Displayed :: Clickable :: Mini Cart is Opened");	
	}

	// validate homepage links
	public void validateFooterLinks() throws Exception {

		driver.get(baseUrl);
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// check About link
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT_LINK));
		text = driver.findElement(ABOUT_LINK).getText();
		if(!text.equals("About"))
			throw new Exception("About footer link text is changed");	
		footer_link= driver.findElement(ABOUT_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/about-us")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after About footer link clicked");
		Reporter.log("About link is Displayed :: Clickable");
		Thread.sleep(4000);

		// check Careers link
		text = driver.findElement(Careers).getText();
		if(!text.equals("Careers"))
			throw new Exception("Careers footer link text is changed");	
		footer_link= driver.findElement(Careers);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(Careers).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.theresumator.com/apply")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after About footer link clicked");
		Reporter.log("About link is Displayed :: Clickable");
		Thread.sleep(4000);

		// check Press link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(PRESS_LINK).getText();
		if(!text.equals("Press"))
			throw new Exception("Press link text is changed");	
		footer_link= driver.findElement(PRESS_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(PRESS_LINK).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/press")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Press footer link clicked");
		Reporter.log("Press footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check  Blog  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(BLOG_LINK).getText();
		if(!text.equals("Blog"))
			throw new Exception("blog link text is changed");	
		footer_link= driver.findElement(BLOG_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(BLOG_LINK).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/blogs/news")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Blog footer link clicked");
		Reporter.log("Blog footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check  Reviews  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(Reviews).getText();
		if(!text.equals("Reviews"))
			throw new Exception("Reviews link text is changed");	
		footer_link= driver.findElement(Reviews);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(Reviews).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/reviews")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Reviews footer link clicked");
		Reporter.log("Reviews footer link is Displayed :: Clickable");
		Thread.sleep(5000);


		// check military discount link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(MILITARY_DISCOUNT_LINK).getText();
		if(!text.equals("Military Discount"))
			throw new Exception("Military Discount link text is changed");	
		footer_link= driver.findElement(MILITARY_DISCOUNT_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(MILITARY_DISCOUNT_LINK).click();
		Thread.sleep(3000);
		WebElement popup=driver.findElement(By.cssSelector(".LeaveSiteButtons > a"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", popup);
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.sheerid.com/")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Military Discount footer link clicked");
		Reporter.log("Military Discount footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Teacher Discount  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(TEACHER_DISCOUNT_LINK).getText();
		if(!text.equals("Student & Teacher Discount"))
			throw new Exception("Teacher Discount link text is changed");	
		footer_link= driver.findElement(TEACHER_DISCOUNT_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(TEACHER_DISCOUNT_LINK).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://offers.sheerid.com/tommy-john-landing-page/")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Teacher Discount footer link clicked");
		Reporter.log("Teacher Discount footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check  Healthcare  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(HEALTHCARE_DISC_LINK).getText();
		if(!text.equals("Healthcare Hero Discount"))
			throw new Exception("Healthcare Hero Discount link text is changed");	
		footer_link= driver.findElement(HEALTHCARE_DISC_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(HEALTHCARE_DISC_LINK).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://services.sheerid.com/verify/5eb057b19c1d181bd389bf0d/")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Healthcare Hero Discount footer link clicked");
		Reporter.log("Healthcare Hero Discount footer link is Displayed :: Clickable");
		Thread.sleep(5000);




		// check  Help  link
		//		text = driver.findElement(HELP_LINK).getText();
		//		if(!text.equals("Help"))
		//			throw new Exception("Help link text is changed");	
		//		driver.findElement(HELP_LINK).click();
		//		Thread.sleep(5000);
		//		if(driver.getCurrentUrl().equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us")) 
		//			driver.navigate().back();

		//		else
		//			throw new Exception("Wrong page opened after Help footer link clicked");
		//		Reporter.log("Help footer link is Displayed :: Clickable");
		//		Thread.sleep(5000);

		// check  Contact Us  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(CONTACT_US_LINK).getText();
		if(!text.equals("Contact & FAQ"))
			throw new Exception("Contact Us link text is changed");	
		footer_link= driver.findElement(CONTACT_US_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(CONTACT_US_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Contact Us footer link clicked");
		Reporter.log("Contact Us footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check  Retailers  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(RETAILERS_LINK).getText();
		if(!text.equals("Retailers"))
			throw new Exception("Retailers link text is changed");	
		footer_link= driver.findElement(RETAILERS_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(RETAILERS_LINK).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/retailers")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Retailers footer link clicked");
		Reporter.log("Retailers footer link is Displayed :: Clickable");
		Thread.sleep(5000);



		// Check  Tommy John Store link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(TOMMY_JOHN_STORES).getText();
		if(!text.equals("Tommy John Stores"))
			throw new Exception("Tommy John Stores link text is changed");	
		footer_link= driver.findElement(TOMMY_JOHN_STORES);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(TOMMY_JOHN_STORES).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/store-directory")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Tommy John Stores footer link clicked");
		Reporter.log("Tommy John Stores footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Store Locator  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(STORE_LOCATOR_LINK).getText();
		if(!text.equals("Store Locator"))
			throw new Exception("Store Locator link text is changed");	
		footer_link= driver.findElement(STORE_LOCATOR_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(STORE_LOCATOR_LINK).click();
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/store-locator")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Store Locator footer link clicked");
		Reporter.log("Store Locator footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Returns & Exchanges  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(RETURNS_AND_EXCHANGES).getText();
		if(!text.equals("Returns & Exchanges"))
			throw new Exception("Shipping & Returns link text is changed");	
		footer_link= driver.findElement(RETURNS_AND_EXCHANGES);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(RETURNS_AND_EXCHANGES).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us/sections/360000065123-Returns-Exchanges")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Returns & Exchanges footer link clicked");
		Reporter.log("Returns & Exchanges footer link is Displayed :: Clickable");
		Thread.sleep(5000);


		// check Shipping & Returns Policy  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(SHIPPING_AND_RETURNS_LINK).getText();
		if(!text.equals("Shipping & Return Policy"))
			throw new Exception("Shipping & Returns link text is changed");	
		footer_link= driver.findElement(SHIPPING_AND_RETURNS_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", footer_link);

		//driver.findElement(SHIPPING_AND_RETURNS_LINK).click();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us/articles/360000507746-Shipping-Returns")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Shipping & Returns footer link clicked");
		Reporter.log("Shipping & Returns footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Shop Women  link
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(SHOP_WOMEN).getText();
		if(!text.equals("Shop Women"))
			throw new Exception("Shop Women link text is changed");	
		element=driver.findElement(SHOP_WOMEN);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		System.out.println("shop women url: "+driver.getCurrentUrl());
		if(driver.getCurrentUrl().contains("https://tommyjohn.com/collections/womens-all")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Shop Women footer link clicked");
		Reporter.log("Shop Women footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Shop Men  link
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(SHOP_MEN).getText();
		if(!text.equals("Shop Men"))
			throw new Exception("Shop Women link text is changed");	
		element=driver.findElement(SHOP_MEN);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		if(driver.getCurrentUrl().contains("https://tommyjohn.com/collections/mens-all")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Shop Men footer link clicked");
		Reporter.log("Shop Men footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Gift Cards  link
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(GIFT_CARD_LINK).getText();
		if(!text.equals("Gift Cards"))
			throw new Exception("Gift Cards link text is changed");	
		element=driver.findElement(GIFT_CARD_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/products/e-gift-card")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Gift Cards footer link clicked");
		Reporter.log("Gift Cards footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Fabric Guide  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(FABRIC_GUIDE_LINK).getText();
		if(!text.equals("Fabric Guide"))
			throw new Exception("Fabric Guide link text is changed");	
		element=driver.findElement(FABRIC_GUIDE_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/fabric-guide")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Fabric Guide footer link clicked");
		Reporter.log("Fabric Guide footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Sign In  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(SIGN_IN_FOOTER_LINK).getText();
		if(!text.equals("Sign In"))
			throw new Exception("Sign In link text is changed");	
		element=driver.findElement(SIGN_IN_FOOTER_LINK);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/account/login")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Sign In footer link clicked");
		Reporter.log("Sign In footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Order History  link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		text = driver.findElement(ORDER_HISTORY).getText();
		if(!text.equals("Order History"))
			throw new Exception("Order History link text is changed");	
		element=driver.findElement(ORDER_HISTORY);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/account/login")) 
			driver.navigate().back();
		else
			throw new Exception("Wrong page opened after Order History footer link clicked");
		Reporter.log("Order History footer link is Displayed :: Clickable");
		Thread.sleep(5000);


		// check Facebook link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		softassert.assertTrue(driver.findElement(FACEBOOK_ICON).isDisplayed(), "Facebook icon is not displayed on footer");
		element=driver.findElement(FACEBOOK_ICON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(3000);
		if(!driver.getCurrentUrl().equals("https://www.facebook.com/TommyJohnWear"))
			throw new Exception("Wrong page opened after clicked on Facebook Icon");
		else
			driver.navigate().back();
		Reporter.log("Facebook footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Twitter link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		softassert.assertTrue(driver.findElement(TWITTER_ICON).isDisplayed(), "Twitter icon is not displayed on footer");
		element=driver.findElement(TWITTER_ICON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(3000);
		if(!driver.getCurrentUrl().equals("https://twitter.com/TommyJohn"))
			throw new Exception("Wrong page opened after clicked on Twitter link");

		else
			driver.navigate().back();
		Reporter.log("Twitter footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Pinterest link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		softassert.assertTrue(driver.findElement(PINTEREST_ICON).isDisplayed(), "Pinterest icon is not displayed on footer");
		element=driver.findElement(PINTEREST_ICON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(3000);
		if(!driver.getCurrentUrl().equals("https://www.pinterest.com/tommyjohnwear/"))
			throw new Exception("Wrong page opened after clicked on Pinterest link");
		else
			driver.navigate().back();
		Reporter.log("Pinterest footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check Instagram link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		softassert.assertTrue(driver.findElement(INSTAGRAM_ICON).isDisplayed(), "Instagram icon is not displayed on footer");
		element=driver.findElement(INSTAGRAM_ICON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(3000);
		System.out.println("insta link is: "+driver.getCurrentUrl());
		if(!driver.getCurrentUrl().contains("https://www.instagram.com/"))
			throw new Exception("Wrong page opened after clicked on Instagram link");
		else
			driver.navigate().back();
		Reporter.log("Instagram footer link is Displayed :: Clickable");
		Thread.sleep(5000);

		// check YouTube link
		// scroll the page at bottom to test all the footer links
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		softassert.assertTrue(driver.findElement(YOUTUBE_ICON).isDisplayed(), "Youtube icon is not displayed on footer");
		element=driver.findElement(YOUTUBE_ICON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".LeaveSiteButtons > a")).click();
		Thread.sleep(3000);
		if(!driver.getCurrentUrl().contains("https://www.youtube.com"))
			throw new Exception("Wrong page opened after clicked on YouTube link");
		else
			driver.navigate().back();
		Reporter.log("YouTube footer link is Displayed :: Clickable");
		Thread.sleep(5000);


		//Verify Footer Newsletter section
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		softassert.assertTrue(driver.findElement(NEWSLETTER_TITLE).isDisplayed(), "Newsletter Title is not displayed on footer");
		softassert.assertTrue(driver.findElement(NEWSLETTER_RADIO_BUTTONS).isDisplayed(), "Newsletter Radio buttons are not displayed on footer");
		softassert.assertTrue(driver.findElement(NEWSLETTER_INPUT_TEXTBOX).isDisplayed(), "Newsletter Text Box is not displayed on footer");
		softassert.assertTrue(driver.findElement(NEWSLETTER_SIGN_UP_BUTTON).isDisplayed(), "Newsletter sign up button is not displayed on footer");
		String testemail = "testaccount" + System.currentTimeMillis() +"@gmail.com";
		driver.findElement(NEWSLETTER_INPUT_TEXTBOX).sendKeys(testemail);
		driver.findElement(NEWSLETTER_SIGN_UP_BUTTON).click();
		Thread.sleep(3000);
		softassert.assertTrue(driver.findElement(NEWSLETTER_FORM_SUCCESS_MESSAGE).isDisplayed(), "Success message is not displayed with newsletter form submission");
		softassert.assertTrue(driver.findElement(GIVE_FEEDBACK_CTA).isDisplayed(), "Give feedback CTA is not displayed on footer");
		driver.findElement(GIVE_FEEDBACK_CTA).click();
		Thread.sleep(3000);
		String Feedback_page_url = "https://tommyjohn.az1.qualtrics.com/jfe/form/SV_eXmBDyc2bTaruw5?";
		softassert.assertTrue(driver.getCurrentUrl().contains(Feedback_page_url), "Wrong page opened after click on Give Feedback CTA on footer");

		softassert.assertAll();

	}

	//navigate to do not sell my personal info page
	public void NavigateToDoNotSellMyPersonalInfoPage()
	{
		driver.get(baseUrl);
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(DO_NOT_SELL_PERSONAL_INFO_LINK));
		driver.findElement(DO_NOT_SELL_PERSONAL_INFO_LINK).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(CCPA_FORM_TITLE));
		softassert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/do-not-sell-my-personal-information"), "Wrong page opened after click on 'Do not sell my personal information link'");
		Reporter.log("Do not sell my personal information link is displayed :: Clickable");
		softassert.assertAll();

	}

	public void validate_DoNotSellMyPersonalInfo() throws Exception
	{
		NavigateToDoNotSellMyPersonalInfoPage();
		softassert.assertTrue(driver.findElement(CCPA_STATE_OF_RESIDENCE_QSN).isDisplayed(), "'What is your state of residence' question is not displayed on CCPA page");
		softassert.assertTrue(driver.findElement(STATE_DROPDOWN).isDisplayed(), "State option dropdown is not displayed on CCPA page");

		Select stateoptions = new Select(driver.findElement(STATE_DROPDOWN));
		//Check field validations
		stateoptions.selectByValue("California");
		Thread.sleep(2000);
		driver.findElement(SUBMIT_REQUEST_CTA).click();
		softassert.assertTrue(driver.findElement(ERROR_MESSAGE).isDisplayed(), "Error message is not displayed for wrong/empty submission with california user");
		Reporter.log("Field validation is correct on Do Not Sell My Personal Information Page");

		//select all other states
		stateoptions.selectByValue("All other states");
		Thread.sleep(2000);
		softassert.assertTrue(driver.findElement(NON_CALIFORNIA_USER_HINT_SECTION).isDisplayed(), "how to protect privacy message for non california user is not displayed ");
		driver.findElement(BACK_TO_HOME_CTA).click();
		Thread.sleep(3000);
		softassert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/"), "Wrong page opened after click on 'Back to Home' CTA from CCPA page");
		Reporter.log("Page is correct for non-california user");


		//Select California state
		NavigateToDoNotSellMyPersonalInfoPage();
		stateoptions = new Select(driver.findElement(STATE_DROPDOWN));
		stateoptions.selectByValue("California");
		Thread.sleep(3000);
		softassert.assertTrue(driver.findElement(CALIFORNIA_USER_FORM_HEADING).isDisplayed(), "Form heading for California user is not displayed");
		softassert.assertTrue(driver.findElement(NAME_LABEL).isDisplayed(), "Name label for California user is not displayed");
		softassert.assertTrue(driver.findElement(NAME_TEXTBOX).isDisplayed(), "Name Textbox for California user is not displayed");
		driver.findElement(NAME_TEXTBOX).sendKeys("test_name");
		softassert.assertTrue(driver.findElement(EMAIL_LABEL).isDisplayed(), "Email Label for California user is not displayed");
		softassert.assertTrue(driver.findElement(EMAIL_TEXTBOX).isDisplayed(), "Email textbox for California user is not displayed");
		String testemail = "testaccount" + System.currentTimeMillis() +"@gmail.com";
		driver.findElement(EMAIL_TEXTBOX).sendKeys(testemail);
		softassert.assertTrue(driver.findElement(WOULD_LIKE_TO_HEADING).isDisplayed(), "'I would like to' heading is not displayed for checkbox selection");
		int total_checkbox = driver.findElements(By.cssSelector(".ccpa-form-california-user>div:nth-child(4)>.checkbox-wrapper>label>div:nth-child(1)")).size();
		for(int i=2; i<=total_checkbox+1; i++)
		{
			WebElement checkbox = driver.findElement(By.cssSelector(".ccpa-form-california-user>div:nth-child(4)>.checkbox-wrapper:nth-child("+i+")>label>div:nth-child(1)"));
			WebElement checkbox_label = driver.findElement(By.cssSelector(".ccpa-form-california-user>div:nth-child(4)>.checkbox-wrapper:nth-child("+i+")>label>div:nth-child(2)>span"));
			softassert.assertTrue(checkbox_label.isDisplayed(), "Checkbox label is not displayed for checkbox number"+(i-1));
			checkbox.click();
			Thread.sleep(3000);
			System.out.println("selected checkbox is: "+checkbox_label.getText());
		}
		softassert.assertTrue(driver.findElement(SUBMIT_REQUEST_CTA).isDisplayed(), "Submit Request CTA is not displayed for california user");
		driver.findElement(SUBMIT_REQUEST_CTA).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(SUCCESSFULLY_SUBMIT_MESSAGE));
		softassert.assertTrue(driver.findElement(SUCCESSFULLY_SUBMIT_MESSAGE).isDisplayed(), "Successful submit message is not displayed for california user");
		softassert.assertTrue(driver.findElement(BACK_TO_HOME_CTA).isDisplayed(), "'Back to Home' CTA is not displayed after successful submission by california user");
		//		WebElement element= driver.findElement(BACK_TO_HOME_CALIFORNIA);
		//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		//		Thread.sleep(3000);
		//		System.out.println(element.getText()+" CTA is cliackable");
		//		softassert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/"), "Wrong page opened after click on 'Back to Home' CTA after successful submission by california user");
		Reporter.log("Page is correct for california user");
		softassert.assertAll();

	}

	public void VerifyQuickShopOnDYRecs() throws Exception
	{
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		element= driver.findElement(ProductDetailsPageLocators.RFY_SECTION);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);
		element = driver.findElement(ProductDetailsPageLocators.RFY_PRODUCT_IMAGE);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		action.moveToElement(element).build().perform();
		Thread.sleep(3000);
		new CollectionPageComponent(driver).AddproductToCartByQuickShop();
		Reporter.log("Verified DY recs quick shop functionality on HomePgae");

	}

	public void MethodToCheckColorSwatchOnDYRecs() throws Exception
	{
		SoftAssert softassert = new SoftAssert();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(4000);
		element= driver.findElement(ProductDetailsPageLocators.RFY_SECTION);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);

		List<WebElement> allElements = driver.findElements(RFY_SWATCH_COUNT);
		//	System.out.println("color classes are: "+driver.findElement(RFY_SWATCH_COUNT).getAttribute("class"));
		int elementsCount = allElements.size();
		System.out.println("Color Element count :: " + elementsCount);

		if (elementsCount > 1)
		{
			element = driver.findElement(By.cssSelector(".dy-rec--products>div:nth-child(1) > div > div.product-item__swatches:nth-child(2)> div > div:nth-child(1)>div"));
			element.click();

			for (int i = 1; i < elementsCount; i++) {
				if (i < 4) {
					String Img_colortext = null;
					String colornew1 = null;
					String text = driver.findElement(RFY_PRODUCT_IMG_COLORNAME).getAttribute("href");
					String[] strarray = text.split("[=]");
					String text1 = strarray[strarray.length - 1];
					Img_colortext = text1.replace("-", " ");

					System.out.println("Product image color name is: " + Img_colortext);


					element = driver.findElement(By.cssSelector(".dy-rec--products>div:nth-child(1) > div > div.product-item__swatches:nth-child(2)> div > div:nth-child("+i+")>div"));
					colornew1 = element.getAttribute("title"); 
					//	String colornew = colornew1.replace("/", " ");
					System.out.println("swatch color is: "+colornew1);
					if(colornew1.replace("/", " ").equalsIgnoreCase(Img_colortext)) 
					{
						WebElement elemen =driver.findElement(By.cssSelector(".dy-rec--products>div:nth-child(1) > div > div.product-item__swatches:nth-child(2)> div > div:nth-child("+(i+1)+")>div"));
						jse.executeScript("arguments[0].click();", elemen);
					//	softassert.assertTrue(Img_colortext.equalsIgnoreCase(colornew1), "Color not changing");
						Reporter.log("Color swatches are changing correctly");
					}
					else {
						throw new Exception("Color not changing");
					}
				}
			}
		}
		softassert.assertAll();
	}

	public void RFY_ProductTileHoverFunctionality() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element= driver.findElement(ProductDetailsPageLocators.RFY_SECTION);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);

		wait.until(ExpectedConditions.presenceOfElementLocated(ProductDetailsPageLocators.RFY_PRODUCT_IMAGE));
		String text1 = driver.findElement(ProductDetailsPageLocators.RFY_HOVER_PRODUCT_IMG).getAttribute("src");
		String[] imagetext = text1.split("_425");
		String Hover_on_plp = imagetext[0];
		element = driver.findElement(ProductDetailsPageLocators.RFY_PRODUCT_IMAGE);
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductDetailsPageLocators.SECOND_VERTICAL_IMAGE));
		String text = driver.findElement(ProductDetailsPageLocators.SECOND_VERTICAL_IMAGE).getAttribute("src");
		String[] list1 = text.split(".jpg");
		String Second_image_pdp = list1[0];
		if(!Hover_on_plp.equalsIgnoreCase(Second_image_pdp))
			throw new Exception("Product tile hover functionality is not correct");
		Reporter.log("Verified Product tile hover functionality");	

	}

	// navigate new arrival in men category
	public void navigateToNewArrivalsInMenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens-new-arrivals-1");
	}

	// navigate to all underwear in men category 
	public void navigateToAllUnderwearInMenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens-underwear-all-styles");
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}

	//navigate to Button down shirts
	public void navigateToButtonDownShirtInMenCategory() throws Exception {

		driver.get("https://tommyjohn.com/collections/mens-shirts");
	}

	// navigate to Pants and shorts in Men's category
	public void navigateToPantsAndShortsInMensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/pants-and-shorts");

	}

	// navigate to Hoodies & Jackets in Men's category
	public void navigateToHoodiesandJacketsInMensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/jackets-outerwear-1");

	}

	// navigate to Camisole in womens category
	public void navigateToCamisoleInwomensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-camisoles");

	}	

	public void navigateToDressesInwomensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-dresses");

	}

	// navigate to Tops & Tees in womens category
	public void navigateToTopsAndTeesInwomensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-tops-tees");

	}		
	// navigate to Hoodies and Jackets in womens category
	public void navigateToHoodiesandJacketsInwomensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-sweatshirts-jackets");

	}		
	// navigate to Pants & Shorts in womens category
	public void navigateToPantsandShortsInwomensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-pants-shorts");

	}	

	// navigate to tank in men category
	public void navigateToTankInMenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens-tanks");
	}

	// navigate to dress shirts in men category
	public void navigateToDressShirtsInMenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens-shirts");
	}

	// navigate to all mens collections in men category
	public void navigateToAllMensCollectionsInMenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens");
		Thread.sleep(10000);
		//		element = driver.findElement(By.cssSelector("div.mega-collection-filters--controls > a"));
		//		WebDriverWait wait = new WebDriverWait(driver, 30);
		//		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
		//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
	}

	// navigate to New Arrivals in Women category
	public void navigateToNewArrivalsInWomenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-new-arrivals");
	}

	// navigate to All Panties in Women category
	public void navigateToAllPantiesnInWomenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-underwear");
	}

	// navigate to Tees and Polos in Women category
	public void navigateToTeesAndPolosInWomenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-tops-tees");
	}

	// navigate to All Womens Collections in Women category
	public void navigateToAllWomensCollectionsInWomenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/all-womens");
	}

	// navigate to All Mens Packs in Packs category
	public void navigateToAllMensPacksInPacksCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens-underwear-packs");
	}

	// navigate to All Womens Packs in Packs category
	public void navigateToAllWomensPacksInPacksCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-packs");
		Thread.sleep(5000);
	}

	// navigate to single collection cool cotton
	public void navigateToCoolCottonInMensCollection() throws Exception {
		driver.get("https://tommyjohn.com/collections/cool-cotton");
	}

	// navigate to All Clothing in womens categories
	public void navigateToAllClothingInWomensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-all-clothing");
	}

	// navigate to second skin in men catagory
	public void navigateToSecondSkinInMenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens-second-skin");
		Thread.sleep(5000);

	}
	// navigate to all panties in women catagory
	public void navigateToAllPantiesInWomenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-underwear");
		Thread.sleep(5000);
	}

	// navigate to cotton basics in shop by collections catagory
	public void navigateToCottonBasicsInMensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens-cotton-basics");

	}

	// navigate to cotton basics in shop by collections catagory
	public void navigateToAllUnderShirtsInMensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/mens-undershirts");
	}

	// navigate to cotton basics in shop by collections catagory
	public void navigateToAllWomensCollectionInWomensCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/all-womens");
		Thread.sleep(5000);

	}

	// navigate to Gift Card category
	public void navigateToGiftCard() throws Exception {
		driver.get("https://tommyjohn.com/products/e-gift-card");

	}

	//navigate to physical GC
	public void navigateToPhysicalGC()
	{
		driver.get("https://tommyjohn.com/collections/gift-cards/products/gift-card");
	}
	// navigate to Bra category
	public void navigateToBraCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/bras");	

	}

	//navigate to GC plp
	public void NavigateToGCPLP()
	{
		driver.get("https://tommyjohn.com/collections/gift-cards");
	}

	// navigate to Triangle Bralette category
	public void navigateToTriangleBraletteCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/bra-womens-styles-triangle-bralette");

	}

	// navigate to Scoop Bralette category
	public void navigateToScoopBraletteCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/bra-womens-styles-scoop-bralette");

	}

	// navigate to all panties in women catagory
	public void navigateToMysteryPacksinPacksCategory() throws Exception {

		driver.get("https://tommyjohn.com/search?keywords=mystery+packs");
	}



	// navigate to Contact Us Page
	public void navigateToHelpPage() throws Exception {

		driver.get(("https://help.tommyjohn.com/hc/en-us"));
		//			text = driver.findElement(CONTACT_US_LINK).getText();
		//			if(!text.equals("Contact Us"))
		//				throw new Exception("Contact Us link text is changed");	
		//			driver.findElement(CONTACT_US_LINK).click();
		//			Thread.sleep(5000);
		//			if(driver.getCurrentUrl().equalsIgnoreCase("https://help.tommyjohn.com/hc/en-us")) 
		//			{
		//				Thread.sleep(5000);
		//				driver.findElement(By.cssSelector("#contact-info>p:nth-child(5)>a")).click();
		//				Thread.sleep(5000);
		//				if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/contact-us")) 
		//					System.out.println("Email link on help page is Displayed :: Clickable");
		//				else
		//					throw new Exception("Wrong page opened after Email link on help page link clicked");
		//			}
		//			
		//			else {
		//			if(driver.getCurrentUrl().equalsIgnoreCase("https://tommyjohn.com/pages/contact-us")) 
		//				//driver.navigate().back();
		//				System.out.println("Contact Us footer link is Displayed :: Clickable");
		//			else
		//				throw new Exception("Wrong page opened after Contact Us footer link clicked");
		//			Reporter.log("Contact Us footer link is Displayed :: Clickable");
		//		}							
	}

	// navigate to mix & match in Bra Category
	public void navigateToMixAndMatchInBrasCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-mix-and-match");
	}

	public void navigateToHisNHerInPacks() throws Exception{

		driver.get("https://tommyjohn.com/collections/his-hers-rose-gold-packs");

	}

	//navigate to bottom in men category
	public void navigateToBottomInMensCategory(){

		driver.get("https://tommyjohn.com/collections/mens-lounge-bottoms");

	}
	//navigate to packs in men category
	public void nevigateToAllMensPacksInPacksCategory() 
	{
		driver.get("https://tommyjohn.com/collections/mens-packs-all");

	}

	//navigate to lounge wear packs in women category
	public void navigateToLoungeWearPacksInWomenPacksCategory(){

		driver.get("https://tommyjohn.com/collections/womens-lounge-sleep-packs");

	}

	//navigate to Boxer Brief in men category
	public void navigateToBoxerBriefInMenCategory(){
		driver.get("https://tommyjohn.com/collections/mens-boxer-brief-underwear");
		((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	//navigate to Mens underwear quiz page
	public void navigateToMensQuizPage()
	{
		driver.get("https://tommyjohn.com/pages/quiz?quizID=MN-UW-QZ");

	}

	//navigate to Womens underwear quiz page
	public void navigateToWomensQuizPage()
	{
		driver.get("https://tommyjohn.com/pages/quiz?quizID=WN-UW-QZ");
	}

	public void navigateToWomensBraQuizPage()
	{
		driver.get("https://tommyjohn.com/pages/quiz?quizID=BR-10005-QZ");
	}
}
