package com.tommyjohn.automation.Components;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;


import com.tommyjohn.automation.PageLocators.CollectionPageLocator;
import com.tommyjohn.automation.PageLocators.FlyCartPageLocator;
import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.PageLocators.SizeGuideLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ProductDetailsPageComponents extends ProductDetailsPageLocators {
	public WebDriver driver;
	public WebElement element;
	public Actions action;
	public JavascriptExecutor jse;
	boolean flag = false;
	Properties properties = CustomUtilities.properties;
	List<WebElement> allElements;
	int elementsCount;
	public  static String prodsize;
	public static String productname;
	public  static String productsize;
	public  static String productcolor;
	public  static String productprice;
	public static String productquant;
	public String price;
	public static String Sizename1;
	public static String Sizename2;
	public static String BundleSizename1;
	public static String BundleSizename2;

	double installment;


	public ProductDetailsPageComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void validateProductDetailsPage() throws Exception {
		String text = null;

		// call method to navigate to collection page
		new HomePageComponents(driver).navigateToAllPantiesInWomenCategory();

		// call method to nevigate product details page
		text = new CollectionPageComponent(driver).navigateToProductDetailsPage();

		// call method to check correct PDP opend or not
		checkCorrectProductDetailsPageOpenedOrNot(text);

		// call method for PDP validation
		validatePage();

	}

	public void checkCorrectProductDetailsPageOpenedOrNot(String text1) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String text2 = null;
		String[] list;
		Thread.sleep(4000);
		wait.until(ExpectedConditions.presenceOfElementLocated(ADD_TO_CART_BUTTON));
	//	list =driver.getCurrentUrl().split("/");
		list= driver.findElement(PRODUCT_TITLE).getText().split(",");
//		text2 = list[list.length-1];
//		list = text2.split("\\?");
		text2 = list[0];

		list=text1.split(",");
//		text1=list[list.length-1];
//		list = text1.split("\\?");
		text1 = list[0];

		System.out.println("text2 is: "+text2+" and text1 is: "+text1);
		// check correct PDP opened
		if(!text2.contains(text1))
			throw new Exception("Wrong product details page opened");
		Reporter.log("Product details page is Correct :: Product title is Displayed");

	}


	public  ProductDetailsPageComponents getproductdetails() throws Exception
	{
		ProductDetailsPageComponents pdp = new ProductDetailsPageComponents(driver);
		new HomePageComponents(driver).navigateToAllPantiesInWomenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		new AddToCartComponents(driver).selectSize();
		pdp.productname = driver.findElement(PRODUCT_TITLE).getText();
		pdp.productprice = driver.findElement(PRODUCT_PRICE).getText();
		List<WebElement> productcolors = driver.findElements(COLOR_TEXT);
		for( WebElement color : productcolors )
		{
			System.out.println(color.getText());
			if(!color.getText().isEmpty()) {
				pdp.productcolor = color.getText();
				break;
			}
		}

		pdp.productsize = driver.findElement(SIZE_TEXT).getText();
		pdp.productquant =  driver.findElement(By.cssSelector(".product-info-quant-atc-container>.qty-selector")).getAttribute("data-item-qty");
		pdp.prodsize = driver.findElement(SIZE_TEXT).getAttribute("value");
		String[] arrOfStr = pdp.prodsize.split(","); 
		pdp.prodsize = arrOfStr[0];

		new AddToCartComponents(driver).selectSize();
		return pdp;

	}


	public void validatePage() throws Exception {
		String text1 = null;
		String allClasses = null;
		String colornew = null;
		String colortext = null;
		String quantity;
		SoftAssert softAssert =  new SoftAssert();
		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor executor = (JavascriptExecutor)driver;

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PRICE));
		// check product price is displayed or not
		if(!driver.findElement(PRODUCT_PRICE).isEnabled())
			throw new Exception("Product price is not displayed");

		//Check Breadcrumbs
		WebElement BREADCRUMBS = driver.findElement(By.cssSelector(".breadcrumbs"));
		softAssert.assertTrue(BREADCRUMBS.isDisplayed(), "Breadcrumb is not displayed on PDP.");
		System.out.println("Breadcrumb is displayed on PDP.");
		Reporter.log("Breadcrumb is displayed on PDP.");

		//Check Badging
		try{
			System.out.println("Verifying for Badging .......");
			WebElement BADGE =driver.findElement(By.cssSelector("div.product-info__inner-top > div > div.product-info__title-wrap > span"));
			if(!BADGE.isDisplayed())
				throw new Exception("Badging is not displayed on PDP.");
			else {
				System.out.println("Badging is displayed on PDP.");
				Reporter.log("Badge is displayed on PDP.");
			}
		}
		catch(Exception e){
			System.out.println("Badging is not applicable for this product.");
		}

		//Check Promo Message
		try{
			System.out.println("Verifying for Promo Message .......");
			WebElement PROMO_MESSAGE =driver.findElement(By.cssSelector("div.product-info__inner-top > div > div.product-info_promo> span"));
			if(!PROMO_MESSAGE.isDisplayed())
				throw new Exception("Promo Message is not displayed on PDP.");
			else
				System.out.println("Promo Message is displayed on PDP.");
			Reporter.log("Promo Message is displayed on PDP.");
		}
		catch(Exception e){
			System.out.println("Promo Message is not applicable for this product.");
		}

		Thread.sleep(7000);
		//Check vertical image(carousel)
		WebElement VERTICAL_IMAGE = driver.findElement(By.cssSelector(".slick-vertical > div > div > div.slick-slide.slick-current.slick-active"));
		softAssert.assertTrue(VERTICAL_IMAGE.isDisplayed(), "Vertical images are not displayed on PDP.");
		System.out.println("Vertical images are displayed on PDP.");
		Reporter.log("Vertical images are displayed on PDP.");

		//To avoid bounceX pop-up
		WebElement p_title=driver.findElement(PRODUCT_TITLE);
		executor.executeScript("arguments[0].click();", p_title);
		// check for Size Guide button 
		WebElement ele = driver.findElement(SIZEGUIDE);
		executor.executeScript("arguments[0].click();", ele);
		//	driver.findElement(SIZEGUIDE).click();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content > .size-guide-title")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Size guide is Displayed :: Clickable");
		WebElement close_icon=driver.findElement(By.cssSelector(".close_chart_modal"));
		executor.executeScript("arguments[0].click();", close_icon);
		//check rating n reviews
		wait.until(ExpectedConditions.visibilityOfElementLocated(RATING_STARS));
		if(driver.findElement(RATING_STARS).isDisplayed()) {

			WebElement elem = driver.findElement(RATING_STARS);
			executor.executeScript("arguments[0].click();", elem);
			// wait for scroll it down
			wait.until(ExpectedConditions.presenceOfElementLocated(WRITE_REVIEW_BUTTON));
			Reporter.log("Review Stars Are Displayed :: Clickable :: Clicked");
			// check for Rating and Reviews are present or not
			System.out.println("rating: " + driver.findElement(RATING_NUMBER).getText());

			if(!driver.findElement(RATING_NUMBER).getText().equals("(0)"))
			{
				Thread.sleep(3000);
				if(driver.findElement(RATING_AND_REVIEWS_BOX).isDisplayed()) {
					if(!driver.findElement(FIRST_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In first box Review Stars not present in Rating and Reviews section");
					if(!driver.findElement(SECOND_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In second box rating list not present in Rating and Reviews section");
					if(!driver.findElement(THIRD_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In third box fit status not present in Rating and Reviews section");
				}
				else 
					throw new Exception("Rating box is not present");
			}
			else 
			{
				Thread.sleep(3000);
				if(!driver.findElement(NO_REVIEW_WRITE_REVIEW).isEnabled())
					throw new Exception("'WRITE A REVIEW' button is not displayed");
				driver.findElement(NO_REVIEW_WRITE_REVIEW).click();
				Reporter.log("'WRITE A REVIEW' button is Displayed :: Clickable");
				driver.findElement(NO_REVIEW_WRITE_REVIEW).click();
			}
			Reporter.log("Rating and Reviews Displayed");
		}
		else
			throw new Exception("Rating Stars are not clickable");

		// check for write a review button
		WebElement writereview = driver.findElement(WRITE_REVIEW_BUTTON);
		executor.executeScript("arguments[0].click();", writereview);
		softAssert.assertEquals(driver.findElement(WRITE_REVIEW_TITLE).getText(), "Write a Review", "Laguage mismatch for Write a Review title 1");
		// scroll it top again
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(3000);

		// Check we can select color or not
		JavascriptExecutor executore = (JavascriptExecutor)driver;
		allElements = driver.findElements(ALL_COLOR_LIST);
		elementsCount = allElements.size();
		System.out.println("Color Element count :: "+elementsCount);
		if(elementsCount > 1)
		{
			for(int i=1;i<elementsCount;i++)
			{
				if(i<4)
				{
					colortext = driver.findElement(COLOR_TEXT).getText();
					if(driver.getCurrentUrl().contains("product"))
						colornew = driver.findElement(By.cssSelector(".product-option__color-swatches-wrapper > ul  > li:nth-child("+ i +") > label")).getAttribute("aria-label");
					else
						colornew = driver.findElement(By.cssSelector(".product-option__color-swatches-wrapper > ul > li:nth-child("+ i +") > label")).getAttribute("aria-label");
					System.out.println(colornew);
					if(!colornew.contentEquals(colortext))	
					{
						WebElement elemen = driver.findElement(By.cssSelector(".product-option__color-swatches-wrapper > ul  > li:nth-child(" + i + ") > label"));
						//elem.click();
						executore.executeScript("arguments[0].click();", elemen);
						//Thread.sleep(5000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(COLOR_TEXT));
						System.out.println("expected is: "+driver.findElement(COLOR_TEXT).getText()+" Actual is: "+colornew);
						softAssert.assertEquals(driver.findElement(COLOR_TEXT).getText().equalsIgnoreCase(colornew), true, "Color not changing");
					}
				}
			}
		}
		Reporter.log("Colors are present and changing correct");
		// Select first size between available sizes
		allElements = driver.findElements(ALL_SIZE_LIST);
		elementsCount = allElements.size();
		System.out.println("All sizes list :: "+ elementsCount);
		try {
			if(driver.findElement(By.cssSelector("div.radio-options-container")).isDisplayed())
			{

				//radio			
				for(int i=3;i<=elementsCount;i=i+2) {
					flag = false;
					element = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child("+i+")"));
					if (element.getAttribute("class").contains("oosVariant")) {
						{
							if(!driver.findElement(PRODUCT_TITLE).getText().contains("Pack"))
							{

								Thread.sleep(3000);
								jse = (JavascriptExecutor)driver;
								jse.executeScript("arguments[0].click();", element);
								//element.click();
								Thread.sleep(4000);

								System.out.println("Unavailable size clicked");
								element = driver.findElement(ADD_TO_CART_BUTTON);
								text1 = element.getText();
								System.out.println("Text of button when Unavailable size selected :: "+text1);
								if(!((text1.equalsIgnoreCase("JOIN THE WAITLIST"))||(text1.equalsIgnoreCase("Out of Stock"))))
									throw new Exception("Text change for 'JOIN THE WAITLIST' ");

								flag = true;

							}
							else 
							{

								WebElement el = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child("+i+")"));
								jse = (JavascriptExecutor)driver;
								jse.executeScript("arguments[0].click();", el);

								System.out.println("Unavailable size clicked");
								System.out.println(driver.findElement(ADD_TO_CART_BUTTON).getText());
								if (!driver.findElement(ADD_TO_CART_BUTTON).getText().contentEquals("Out of Stock"))
								{
									element = driver.findElement(ADD_TO_CART_BUTTON);
									text1 = element.getText();
									System.out.println("Text of button when Unavailable size selected :: "+text1);
									if(!(text1.equalsIgnoreCase("JOIN THE WAITLIST")))
										throw new Exception("Text change for 'JOIN THE WAITLIST' for Packs");
									text1 = element.getText();
								}
								flag = true;
							}
							//break;
						}
					}
					else 
					{
						jse = (JavascriptExecutor)driver;
						jse.executeScript("arguments[0].click();" , element);

					}


					if(i==elementsCount) {
						Reporter.log("No any size available");
						break;
					}	

					if(flag == true)
						continue;
					else {
						element = driver.findElement(ADD_TO_CART_BUTTON);
						text1 = element.getText();
						System.out.println("Button text when Available size selected :: "+text1);
						if(!text1.equalsIgnoreCase("OUT OF STOCK"))
						{
							if(!(text1.equalsIgnoreCase("ADD TO CART"))) {
								throw new Exception("Text change for 'ADD TO CART' ");
							}
						}
						break;}

				}

			}
		}
		catch(Exception ex) {
			//		else
			//		{
			//dropdown
			for(int i=1;i<=elementsCount;i++) {
				flag = false;
				//driver.findElement(SIZE_DROPDOWN).click();
				executore.executeScript("arguments[0].click();", driver.findElement(SIZE_DROPDOWN));
				element = driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+") > div"));

				allClasses = element.getAttribute("class");
				// check size available or not
				for (String c : allClasses.split(" ")) {
					if (c.equals("unavailable")) {
						if(!driver.findElement(PRODUCT_TITLE).getText().contains("Pack"))
						{

							Thread.sleep(3000);
							// click on the unavailable item and check the button text
							//driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+")")).click();
							jse = (JavascriptExecutor)driver;
							jse.executeScript("arguments[0].click();", element);
							//element.click();
							Thread.sleep(4000);

							driver.navigate().refresh();
							System.out.println("Unavailable size clicked");
							element = driver.findElement(JOIN_THE_WAITLIST);
							text1 = element.getText();
							System.out.println("Text of button when Unavailable size selected :: "+text1);
							if(!(text1.equalsIgnoreCase("JOIN THE WAITLIST")))
								throw new Exception("Text change for 'JOIN THE WAITLIST' ");

							flag = true;

						}
						else 
						{

							WebElement el = driver.findElement(By.cssSelector(".select--options__list> li:nth-child("+i+")"));
							jse = (JavascriptExecutor)driver;
							jse.executeScript("arguments[0].click();", el);

							System.out.println("Unavailable size clicked");
							//	driver.findElement(ADD_TO_CART_BUTTON).click();
							System.out.println(driver.findElement(ADD_TO_CART_BUTTON).getText());
							if (!driver.findElement(ADD_TO_CART_BUTTON).getText().contentEquals("Out of Stock"))
							{
								element = driver.findElement(JOIN_THE_WAITLIST);
								text1 = element.getText();
								System.out.println("Text of button when Unavailable size selected :: "+text1);
								if(!(text1.equalsIgnoreCase("JOIN THE WAITLIST")))
									throw new Exception("Text change for 'JOIN THE WAITLIST' for Packs");
								text1 = element.getText();
							}
							flag = true;
						}
						//break;
					}
					else 
					{
						jse = (JavascriptExecutor)driver;
						jse.executeScript("arguments[0].click();" , element);
					}
				}
				if(i==elementsCount) {
					Reporter.log("No any size available");
					break;
				}			
				if(flag == true)
					continue;
				else {
					// if flag is not true means size is available
					// check the button txt and click
					element = driver.findElement(ADD_TO_CART_BUTTON);
					text1 = element.getText();
					System.out.println("Button text when Available size selected :: "+text1);
					if(!text1.equalsIgnoreCase("OUT OF STOCK"))
					{
						if(!(text1.equalsIgnoreCase("ADD TO CART"))) {
							throw new Exception("Text change for 'ADD TO CART' ");
						}
					}

				}
				try
				{
					// check if we are able to add and minus quantity
					quantity = driver.findElement(QUANTITY).getAttribute("data-add-qty");
					Thread.sleep(3000);
					element = driver.findElement(PLUS_BUTTON);
					jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click();", element);
					//	driver.findElement(PLUS_BUTTON).click();
					Thread.sleep(3000);
					String quantity1 = driver.findElement(QUANTITY).getAttribute("data-add-qty");
					// check quantity added by 1 or not 
					if(Integer.parseInt(quantity1)!=Integer.parseInt(quantity)+1) 
						throw new Exception("Quantity not increased by 1");
					Reporter.log("Quantity increased by 1");

					element = driver.findElement(MINUS_BUTTON);
					jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click();", element);
					String quantity2 = driver.findElement(QUANTITY).getAttribute("data-add-qty");
					if(Integer.parseInt(quantity2)!=Integer.parseInt(quantity1)-1)
						throw new Exception("Quantity not decreased by 1");
					Reporter.log("Quantity decreased by 1");
				}
				catch(Exception e)
				{
					Reporter.log("Quantity selector was not present - please check if DY hides Qunatity selector is active");
				}

				// check 'Best PairGuarantee' and 'Shopping And Returns' are clickable or not
				flag = false;
				Exception except = null;


				if (driver.findElement(PRODUCT_DETAILS).isDisplayed())
				{
					element = driver.findElement(PRODUCT_DETAILS);
					jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click();", element);
				}
				else throw new Exception("Product details accordion not present or not clikable ");
				try
				{
					if (driver.findElement(PAIR_GUARANTEE).isDisplayed())
					{
						element = driver.findElement(PAIR_GUARANTEE);
						jse = (JavascriptExecutor)driver;
						jse.executeScript("arguments[0].click();", element);
					}
					else throw new Exception("PAIR_GUARANTEE accordion not present or not clikable");
				}
				catch(Exception e )
				{
					Reporter.log("Pair guarantee link is not present for this particular product");
					except = e;
				}
				if(except!=null)
				{
					if (driver.findElement(SHIPING_AND_RETURNS).isDisplayed()) {
						element = driver.findElement(SHIPING_AND_RETURNS);
						jse = (JavascriptExecutor)driver;
						jse.executeScript("arguments[0].click();", element);
						//driver.findElement(SHIPING_AND_RETURNS).click();
					}		
					else throw new Exception("SHIPING_AND_RETURNS accordion not present or not clikable");	
				}
				//Buywithcode

				if (!driver.findElement(PRODUCT_TITLE).getText().contains("Pack"))
				{
					// click on Add To Cart Button
					if(!driver.findElement(ADD_TO_CART_BUTTON).getText().equalsIgnoreCase("Out Of Stock"))
					{
						if(!driver.findElement(ADD_TO_CART_BUTTON).isEnabled())
							throw new Exception("ADD TO CART button is not present");
						element = driver.findElement(ADD_TO_CART_BUTTON);
						jse = (JavascriptExecutor)driver;
						jse.executeScript("arguments[0].click();", element);

						Thread.sleep(5000);
						driver.get(CustomUtilities.baseUrl);
						//	driver.findElement(ADD_TO_CART_BUTTON).click();
						Thread.sleep(3000);
						Reporter.log("ADD TO CART button is Displayed :: Clickable");
					}
				}
				else
				{
					if(!driver.findElement(ADD_TO_CART_BUTTON).isEnabled())
						throw new Exception("ADD TO CART button is not present");
					element = driver.findElement(ADD_TO_CART_BUTTON);
					jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click();" , element);
					Reporter.log("ADD TO CART button is Displayed :: Clickable");
				}
				break;
			}
		}
		softAssert.assertAll();


	}


	public void validateafterpayonpdp() throws Exception {
		String text = null;
		SoftAssert softAssert = new SoftAssert();

		// call method to navigate to collection page
		new HomePageComponents(driver).navigateToBraCategory();

		// call method to navigate product details page
		text = new CollectionPageComponent(driver).navigateToProductDetailsPage();

		// call method to check correct PDP opend or not
		checkCorrectProductDetailsPageOpenedOrNot(text);
		Thread.sleep(5000);
		//Check afterpay message display
		if(!driver.findElement(AFTERPAY_PDP).isDisplayed())
			throw new Exception("AfterPay Message not present on PDP");
		Reporter.log("After pay Message on PDP is displayed :: Displayed");

		//Check message with calculated installment and icon display
		price= driver.findElement(PRODUCT_PRICE).getText();
		String[] price1 = price.split("\\$");
		String price2 = price1[price1.length-1];
		if(Float.parseFloat(price2)<35 || Float.parseFloat(price2)>1000 )
		{
			softAssert.assertEquals(driver.findElement(AFTERPAY_PDP).getText(), "available for orders between $35 - $1000" , "Wrong afterpay message displayed for product price");
			Reporter.log("After pay message is correct On PDP :: Displayed and Correct message is displayed");
			softAssert.assertTrue(driver.findElement(AFTERPAY_PDP_BEFOREMESSAGE_LOGO).isDisplayed(), "Afterpay logo not present on PDP");
			Reporter.log("After pay logo icon is displayed on PDP :: Displayed");
		}

		else
		{

			installment =Float.parseFloat(price2)/4;
			String inst = String.format("%.2f",installment );
			//	String expectedmessage = "or 4 installments of $" + inst + " by ?"; 
			String expectedmessage =  inst+ " "; 
			System.out.println("expected message is: " + expectedmessage);
			String actual = driver.findElement(AFTERPAY_PDP).getText();
			String ins_amount= actual.substring(actual.indexOf("$")+1, actual.indexOf("b"));
			System.out.println("Actual int_amount is: " +actual);
			softAssert.assertEquals(ins_amount, expectedmessage , "Wrong afterpay message displayed for product price");
			Reporter.log("After pay message with calculated installment is correct :: Displayed and correct");
			softAssert.assertTrue(driver.findElement(AFTERPAY_PDP_AFTERMESSAGE_LOGO).isDisplayed(), "Afterpay logo not present on PDP");
			Reporter.log("After pay logo icon is displayed on PDP :: Displayed");

		}


		softAssert.assertAll();
	}


	public void verifyReviewsDisplay() throws Exception
	{
		WebDriverWait  wait= new WebDriverWait(driver, 30);
		String text = null;
		SoftAssert softAssert = new SoftAssert();
		// call method to navigate to collection page
		new HomePageComponents(driver).navigateToAllMensCollectionsInMenCategory();
		// call method to navigate product details page
		text = new CollectionPageComponent(driver).navigateToProductDetailsPage();
		// call method to check correct PDP opend or not
		checkCorrectProductDetailsPageOpenedOrNot(text);

		wait.until(ExpectedConditions.presenceOfElementLocated(RATING_STARS));

		if(driver.findElement(RATING_STARS).isDisplayed()) {

			WebElement elem = driver.findElement(RATING_STARS);
			JavascriptExecutor executore = (JavascriptExecutor)driver;
			executore.executeScript("arguments[0].click();", elem);
			// wait for scroll it down
			Thread.sleep(6000);
			Reporter.log("Review Stars Are Displayed :: Clickable :: Clicked");
			// check for Rating and Reviews are present or not
			softAssert.assertEquals(driver.findElement(REVIEWS_TITLE).getText(), "Rating & Reviews", "Text change for Ratings and Reviews title");
			softAssert.assertTrue(driver.findElement(WRITE_REVIEW_BUTTON).isDisplayed(), "Write a review button is not displayed");

			System.out.println("rating: " + driver.findElement(RATING_NUMBER).getText());
			if(!driver.findElement(RATING_NUMBER).getText().equals("(0)"))
			{

				if(driver.findElement(RATING_AND_REVIEWS_BOX).isDisplayed()) {

					softAssert.assertTrue(driver.findElement(FIRST_BOX_IN_RATING_AND_REVIEWS).isDisplayed() , " First box is not present in Rating and Reviews section" );
					softAssert.assertTrue(driver.findElement(STARS_IN_FIRST_BOX).isDisplayed(), "In first box Review Stars not present");
					softAssert.assertTrue(driver.findElement(AVG_RATING_IN_FIRST_BOX).isDisplayed(), "In first box Average Rating is not present");
					softAssert.assertTrue(driver.findElement(TOTAL_REVIEWS_IN_FIRST_BOX).isDisplayed(), "In first box Total Reviews are not present");

					softAssert.assertTrue(driver.findElement(SECOND_BOX_IN_RATING_AND_REVIEWS).isDisplayed() , "Second Box is not present in Rating and Reviews section");
					softAssert.assertTrue(driver.findElement(RATING_LABEL_IN_SECOND_BOX).isDisplayed(), "In second box Rating Label is not present");				
					softAssert.assertTrue(driver.findElement(RATING_METER_IN_SECOND_BOX).isDisplayed(), "In second box Rating Meter is not present");
					softAssert.assertTrue(driver.findElement(RATING_COUNT_IN_SECOND_BOX).isDisplayed(), "In second box Rating Count is not present");

					softAssert.assertTrue(driver.findElement(THIRD_BOX_IN_RATING_AND_REVIEWS).isDisplayed(), "Third Box is not present in Rating and Reviews section");
					softAssert.assertTrue(driver.findElement(FIT_GRAPH_IN_THIRD_BOX).isDisplayed(), "In third box fit graph not present");
					softAssert.assertTrue(driver.findElement(FIT_STATUS_IN_THIRD_BOX).isDisplayed(), "In third box fit status not present");

					Reporter.log("Verified Reviews and Rating box section, All elements are present including fit status, fit graph, Rating label, rating count, Rating meter, Avg rating, total reviews etc");


					//verify paginations
					softAssert.assertTrue(driver.findElement(PAGINATION_LEFT_ARROW).isDisplayed(), "Pagination left arrow is not displayed on pdp");
					softAssert.assertTrue(driver.findElement(PAGINATION_RIGHT_ARROW).isDisplayed(), "Pagination right arrow is not displayed on pdp");
					softAssert.assertTrue(driver.findElement(PAGINATION_CURRENT_VALUE).isDisplayed(), "Pagination current value is not displayed on pdp");
					String[] page_value1 = driver.findElement(PAGINATION_CURRENT_VALUE).getText().split(" /");
					String previous_page_number = page_value1[0];
					int pre_number = Integer.parseInt(previous_page_number);
					driver.findElement(PAGINATION_RIGHT_ARROW).click();
					Thread.sleep(5000);
					String[] page_value2 = driver.findElement(PAGINATION_CURRENT_VALUE).getText().split(" /");
					String next_page_number = page_value2[0];
					int next_number = Integer.parseInt(next_page_number);
					System.out.println("previous is: "+previous_page_number+" next page no. is: "+next_page_number);
					softAssert.assertTrue(pre_number<next_number,"Pagination next arrow is not functional");
					Reporter.log("Reviews Pagination is functional on PDP");           
				}

				else 
					throw new Exception("Rating and Reviews box is not present");
				softAssert.assertTrue(driver.findElement(REVIEWER_NAME).isDisplayed(), "Reviewer name is not displayed");
				softAssert.assertTrue(driver.findElement(REVIEWER_TYPE).isDisplayed(), "Reviewer type is not displayed");
				softAssert.assertTrue(driver.findElement(USER_REVIEW_FIT).isDisplayed(), "User review for fit is not displayed");
				softAssert.assertTrue(driver.findElement(USER_REVIEW_DATE).isDisplayed(), "User review date is not displayed");
				softAssert.assertTrue(driver.findElement(USER_REVIEW_STARS).isDisplayed(), "User review stars is not displayed");
				softAssert.assertTrue(driver.findElement(USER_REVIEW_TITLE).isDisplayed(), "User review title is not displayed");
				softAssert.assertTrue(driver.findElement(USER_REVIEW_MAIN_CONTENT).isDisplayed(), "User review main content is not displayed");
				softAssert.assertTrue(driver.findElement(USER_REVIEW_WAS_THIS_HELPFUL_TEXT).isDisplayed(), "Was this helpful text is not displayed");
				softAssert.assertTrue(driver.findElement(USER_REVIEW_THUMBS_UP).isDisplayed(), "Thumbs Up icon is not displayed");
				softAssert.assertTrue(driver.findElement(USER_REVIEW_THUMBS_DOWN).isDisplayed(), "Thumbs down icon is not displayed");
			}
			else 
			{
				softAssert.assertTrue(driver.findElement(NO_REVIEWS_TEXT).isDisplayed(), "No reviews text is not displayed");
				softAssert.assertTrue(driver.findElement(NO_REVIEWS_SUBTEXT).isDisplayed(), "No reviews subtext is not displayed");
				softAssert.assertTrue(driver.findElement(NO_REVIEW_WRITE_REVIEW).isDisplayed(), "No reviews container - write a review is not displayed");
			}
			softAssert.assertAll();
			Reporter.log("Rating and Reviews Displayed");
		}
		else
			throw new Exception("Rating Stars are not clickable");
	}

	public void verifyWriteReview() throws Exception
	{
		String text = null;
		SoftAssert softAssert = new SoftAssert();
		// call method to navigate to collection page
		new HomePageComponents(driver).navigateToAllWomensCollectionInWomensCategory();
		// call method to navigate product details page
		text = new CollectionPageComponent(driver).navigateToProductDetailsPage();
		// call method to check correct PDP opend or not
		checkCorrectProductDetailsPageOpenedOrNot(text);
		Thread.sleep(5000);
		WebElement elem = driver.findElement(RATING_STARS);
		JavascriptExecutor executore = (JavascriptExecutor)driver;
		executore.executeScript("arguments[0].click();", elem);
		// wait for scroll it down
		Thread.sleep(6000);

		WebElement writereview = driver.findElement(WRITE_REVIEW_BUTTON);
		executore.executeScript("arguments[0].click();", writereview);

		softAssert.assertEquals(driver.findElement(WRITE_REVIEW_TITLE).getText(), "Write a Review", "Laguage mismatch for Write a Review title 2");
		softAssert.assertEquals(driver.findElement(NAME).getText(), "* Name", "Laguage mismatch for Name ");
		driver.findElement(NAME_TEXTBOX).sendKeys("Vijeta");
		softAssert.assertEquals(driver.findElement(EMAIL).getText(), "* Email", "Laguage mismatch for Email ");
		driver.findElement(EMAIL_TEXTBOX).sendKeys("vijeta@tommyjohnwear.com");
		softAssert.assertEquals(driver.findElement(LOCATION).getText(), "Location (Optional)", "Laguage mismatch for Location ");
		driver.findElement(LOCATION_TEXTBOX).sendKeys("India");
		softAssert.assertEquals(driver.findElement(FIT).getText(), "Fit", "Laguage mismatch for Fit	 ");
		WebElement fit = driver.findElement(FIT_SELECTION);
		executore.executeScript("arguments[0].click();", fit);
		softAssert.assertEquals(driver.findElement(OVERALLRATING).getText(), "* Overall Rating", "Laguage mismatch for Overall Rating	 ");
		WebElement stars = driver.findElement(STAR_SELECTION);
		executore.executeScript("arguments[0].click();", stars);
		softAssert.assertEquals(driver.findElement(HEADLINE).getText(), "* Add a Headline", "Laguage mismatch for Headline ");
		driver.findElement(HEADLINE_TEXTBOX).sendKeys("Nice Product");
		softAssert.assertEquals(driver.findElement(REVIEW).getText(), "* Review", "Laguage mismatch for Review	 ");
		driver.findElement(REVIEW_TEXTBOX).sendKeys("Must Buy");

		softAssert.assertTrue(driver.findElement(SUBMIT_BTN).isEnabled(), "Submit button not enabled");


		softAssert.assertAll();

	}

	public void verifyWriteReviewErrorMsgs() throws Exception
	{
		String text = null;
		SoftAssert softAssert = new SoftAssert();
		// call method to navigate to collection page
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		// call method to navigate product details page
		text = new CollectionPageComponent(driver).navigateToProductDetailsPage();
		// call method to check correct PDP opend or not
		checkCorrectProductDetailsPageOpenedOrNot(text);
		Thread.sleep(3000);
		WebElement elem = driver.findElement(RATING_STARS);
		JavascriptExecutor executore = (JavascriptExecutor)driver;
		executore.executeScript("arguments[0].click();", elem);
		// wait for scroll it down
		Thread.sleep(6000);
		elem = driver.findElement(WRITE_REVIEW_BUTTON);
		executore = (JavascriptExecutor)driver;
		executore.executeScript("arguments[0].click();", elem);
		//driver.findElement(WRITE_REVIEW_BUTTON).click();
		Thread.sleep(4000);
		driver.findElement(SUBMIT_BTN).click();
		softAssert.assertEquals(driver.findElement(NAME_ERROR).getText(), "Please enter a name for this review.", "Laguage mismatch for error message for Name");
		softAssert.assertEquals(driver.findElement(EMAIL_ERROR).getText(), "Please enter a valid email for this review.", "Laguage mismatch for error message for Email");
		softAssert.assertEquals(driver.findElement(HEADLINE_ERROR).getText(), "Please enter a headline for this review.", "Laguage mismatch for error message for Headline");
		softAssert.assertEquals(driver.findElement(REVIEW_ERROR).getText(), "Please enter some content for this review.", "Laguage mismatch for error message for Review");

		softAssert.assertAll();

	}


	public void verifybundlepages() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		String allClasses = null;
		String allClass = null;
		new SizeGuideComponents(driver).navigateToBundlePDP();
		Thread.sleep(5000);

		if(!driver.findElement(PRODUCT_TITLE).isDisplayed())
			throw new Exception("Product Title is not displayed");
		if(!driver.findElement(PRODUCT_PRICE).isDisplayed())
			throw new Exception("Product price is not displayed");

		if(!driver.findElement(SIZEGUIDE).isEnabled())
			throw new Exception("Size Guide button is not present");
		WebElement ele = driver.findElement(SIZEGUIDE);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);

		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Bundle product's First size guide link is Displayed :: Clickable");
		//Close first size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

		if(!driver.findElement(SizeGuideLocators.BUNDLE_SECOND_SIZE_GUIDE_BUTTON).isEnabled())
			throw new Exception("In bundle product Second Size Guide button is not present");
		WebElement ele2 = driver.findElement(SizeGuideLocators.BUNDLE_SECOND_SIZE_GUIDE_BUTTON);
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", ele2);
		Thread.sleep(3000);

		driver.findElement(SizeGuideLocators.CLOSE_BTN).click();
		Reporter.log("Size guide is Displayed :: Clickable");

		Thread.sleep(3000);

		if(driver.findElement(RATING_STARS).isDisplayed()) {

			WebElement elem = driver.findElement(RATING_STARS);
			JavascriptExecutor executore = (JavascriptExecutor)driver;
			executore.executeScript("arguments[0].click();", elem);
			// wait for scroll it down
			Thread.sleep(6000);
			Reporter.log("Review Stars Are Displayed :: Clickable :: Clicked");
			// check for Rating and Reviews are present or not
			System.out.println("rating: " + driver.findElement(RATING_NUMBER).getText());
			if(!driver.findElement(RATING_NUMBER).getText().equals("(0)"))
			{

				if(driver.findElement(RATING_AND_REVIEWS_BOX).isDisplayed()) {
					if(!driver.findElement(FIRST_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In first box Review Stars not present in Rating and Reviews section");
					if(!driver.findElement(SECOND_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In second box rating list not present in Rating and Reviews section");
					if(!driver.findElement(THIRD_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In third box fit status not present in Rating and Reviews section");
				}

				else 

					throw new Exception("Rating box is not present");

			}

			else 
			{
				if(!driver.findElement(NO_REVIEW_WRITE_REVIEW).isEnabled())

					throw new Exception("'WRITE A REVIEW' button is not displayed");
				driver.findElement(NO_REVIEW_WRITE_REVIEW).click();
				Reporter.log("'WRITE A REVIEW' button is Displayed :: Clickable");

			}
			Reporter.log("Rating and Reviews Displayed");
		}
		else
			throw new Exception("Rating Stars are not clickable");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		allElements = driver.findElements(ALL_SIZE_LIST);
		elementsCount = allElements.size();
		System.out.println("All sizes list :: "+ elementsCount);
		if(driver.findElement(By.cssSelector(".radio-options-container")).isDisplayed())
		{
			//radio
			List<WebElement> Size_OptionName = driver.findElements(By.cssSelector("div.radios-wrapper > div.radio-options-container > div"));
			int Size_OptionCount = Size_OptionName.size();
			for(int i=1; i<=Size_OptionCount; i++)
			{
				Thread.sleep(3000);
				List<WebElement> Sizes_Label = driver.findElements(By.cssSelector("div.radios-wrapper>div:nth-child("+i+")>div.Size>label"));
				elementsCount = Sizes_Label.size();
				System.out.println("All sizes list count is :: "+ elementsCount);

				for(int j=3;j<=elementsCount;j=j+2) {
					flag = false;
					element = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container:nth-child("+i+")> div > label:nth-child("+j+")"));

					allClasses = element.getAttribute("class");
					// check size available or not
					for (String c : allClasses.split(" ")) {
						if (c.equals("oosVariant")) {
							/*
							 * jse = (JavascriptExecutor)driver; jse.executeScript("arguments[0].click();",
							 * element); System.out.println("Unavailable size clicked");
							 */									int y=j;
							 for(int k=y; k<y; k++)
							 {

								 WebElement e = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child("+k+")"));
								 allClass = e.getAttribute("class");
								 for (String d : allClass.split(" ")) {
									 if (d.equals("oosVariant")) 
										 y++;
									 else 
										 driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child("+y+")")).click();
								 }
							 }
							 //flag=true;							
						}
						else 
						{
							System.out.println("selected size is: "+element.getText());
							jse = (JavascriptExecutor)driver;
							jse.executeScript("arguments[0].click();" , element);

						}

					}
					if(j==elementsCount) {
						Reporter.log("No any size available");
						break;
					}	
					if(flag==false)
						break;
					else
						continue;

				}

				if(flag == true)
					continue;

			}	

		}

		else {
			//dropdown

			for(int i=1;i<=elementsCount;i++) {
				flag = false;
				//driver.findElement(SIZE_DROPDOWN).click();
				WebElement elem = driver.findElement(SIZE_DROPDOWN_MENS);
				jse.executeScript("arguments[0].click();", elem);
				element = driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Mens Size'] > li:nth-child("+i+") > div"));

				allClasses = element.getAttribute("class");
				// check size available or not
				for (String c : allClasses.split(" ")) {
					if (c.equals("unavailable")) {

						driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Mens Size']> li:nth-child("+i+")")).click();
						WebElement eleme = driver.findElement(SIZE_DROPDOWN_WOMENS);
						jse.executeScript("arguments[0].click();", eleme);
						//	driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size']> li:nth-child("+i+")")).click();
						int y =i;
						for(int j=0;j<y;j++)
						{

							WebElement e = driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size'] > li:nth-child("+y+") > div"));
							allClass = e.getAttribute("class");
							for (String d : allClass.split(" ")) {

								// check size available or not

								if (d.equals("unavailable")) 
									y++;
								else 
									driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size']> li:nth-child("+y+")")).click();
							}
						}


						flag = true;

						//break;
					}
					else 
					{
						Thread.sleep(3000);
						WebElement e =	driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Mens Size']> li:nth-child("+i+")"));
						Thread.sleep(2000);
						jse.executeScript("arguments[0].click();", e);
						if(!driver.findElement(ADD_TO_CART_BUTTON).getText().contentEquals("Add to Cart"))
						{
							WebElement eleme = driver.findElement(SIZE_DROPDOWN_WOMENS);
							jse.executeScript("arguments[0].click();", eleme);

							int y =i;
							for(int j=0;j<y;j++)
							{

								WebElement el = driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size'] > li:nth-child("+y+") > div"));
								String allClas = el.getAttribute("class");
								for (String u : allClas.split(" ")) {

									// check size available or not

									if (u.equals("unavailable")) 
										y++;
									else 
										driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size']> li:nth-child("+y+")")).click();
								}
							}
						}

						//jse.executeScript("arguments[0].click();", driver.findElement(SIZE_DROPDOWN_WOMENS));

						//	WebElement elm  = driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size']> li:nth-child("+i+") > div"));


						//jse.executeScript("arguments[0].click();", elm);
						if (!driver.findElement(ADD_TO_CART_BUTTON).getText().contentEquals("Add to Cart"))
							throw new Exception("Wrong language on CTA for In stock bundle");

					}

					if(i==elementsCount) {
						Reporter.log("No any size available");

					}			
					if(flag==false)
						break;
					else
						continue;

				}
				if(flag==false)
					break;
				else
					continue;
			}

		}
		// check if we are able to add and minus quantity

		try
		{
			// check if we are able to add and minus quantity
			String quantity = driver.findElement(QUANTITY).getAttribute("data-add-qty");
			Thread.sleep(3000);
			element = driver.findElement(PLUS_BUTTON);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
			//	driver.findElement(PLUS_BUTTON).click();
			Thread.sleep(3000);
			String quantity1 = driver.findElement(QUANTITY).getAttribute("data-add-qty");
			// check quantity added by 1 or not 
			if(Integer.parseInt(quantity1)!=Integer.parseInt(quantity)+1) 
				//if(!quantity1.equals(quantity + 1) )
				//if(quantity1)
				throw new Exception("Quantity not increased by 1");

			Reporter.log("Quantity increased by 1");
			element = driver.findElement(MINUS_BUTTON);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
			//driver.findElement(MINUS_BUTTON).click();

			// some times .click() not clicking the element then that time use JavascriptExecutor
			//		element = driver.findElement(By.id("minusBtn"));
			//		jse = (JavascriptExecutor)driver;
			//		jse.executeScript("arguments[0].click();", element);

			String quantity2 = driver.findElement(QUANTITY).getAttribute("data-add-qty");
			if(Integer.parseInt(quantity2)!=Integer.parseInt(quantity1)-1)
				throw new Exception("Quantity not decreased by 1");
			Reporter.log("Quantity decreased by 1");
		}
		catch(Exception e)
		{
			Reporter.log("Quantity selector was not present - please check if DY hides Qunatity selector is active");
		}

		// check 'Best PairGuarantee' and 'Shopping And Returns' are clickable or not
		flag = false;


		if (driver.findElement(PRODUCT_DETAILS).isDisplayed())
		{
			element = driver.findElement(PRODUCT_DETAILS);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
		}
		else throw new Exception("Product details accordion not present or not clikable ");
		try
		{
			if (driver.findElement(PAIR_GUARANTEE).isDisplayed())
			{
				element = driver.findElement(PAIR_GUARANTEE);
				jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click();", element);
			}
			else throw new Exception("PAIR_GUARANTEE accordion not present or not clikable");
		}
		catch(Exception e )
		{
			Reporter.log("Pair guarantee link is not present for this particular product");
		}
		if (driver.findElement(SHIPING_AND_RETURNS).isDisplayed()) {
			element = driver.findElement(SHIPING_AND_RETURNS);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
			//driver.findElement(SHIPING_AND_RETURNS).click();
		}		
		else throw new Exception("SHIPING_AND_RETURNS accordion not present or not clikable");	



		if(!driver.findElement(ADD_TO_CART_BUTTON).isEnabled())
			throw new Exception("ADD TO CART button is not present");
		element = driver.findElement(ADD_TO_CART_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();" , element);

		Reporter.log("ADD TO CART button is Displayed :: Clickable");

	}


	public void VerifyJoinTheWaitlist() throws Exception
	{

		String allClasses;
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(4000);

		SoftAssert softAssert = new SoftAssert();
		// call method to navigate product details page
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		//driver.get("https://tommyjohn.com/collections/cool-cotton-boxer-brief/?variant=29882858340397");
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		allElements = driver.findElements(ALL_SIZE_LIST);
		elementsCount = allElements.size();
		System.out.println("All sizes list :: "+ elementsCount);

		if(driver.findElement(By.cssSelector("div.radio-options-container")).isDisplayed())
		{

			//radio			
			for(int i=3;i<=elementsCount;i=i+2) {
				flag = false;
				element = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child("+i+")"));

				if (element.getAttribute("class").contains("oosVariant")) {
					{
						if(!driver.findElement(PRODUCT_TITLE).getText().contains("Pack"))
						{					

							//if(driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+") > div > span")).getText().contentEquals("(Out of Stock - Email Me)"))
							//{
							jse = (JavascriptExecutor)driver;
							jse.executeScript("arguments[0].click();", element);
							Thread.sleep(3000);

							//							WebElement atc = driver.findElement(By.cssSelector("div.multiPdp__atc-container>button"));
							//							String[] classname = atc.getAttribute("class").split(" ");
							//							String atc_status = classname[classname.length-1];
							//							if(!atc_status.equals("email-when-in-stock"))
							//							{
							//							WebElement oos_variant = driver.findElement(By.cssSelector(".product-option__variant-btn.email-when-in-stock"));
							//							jse.executeScript("arguments[0].click();", oos_variant);
							//							Thread.sleep(3000);
							//							}

							List<WebElement> unavailable_color = driver.findElements(By.cssSelector(".product-option__color-swatches-wrapper > ul >li>input")); 
							for(int a=1; a<=unavailable_color.size();a++)
							{
								WebElement oos_color = driver.findElement(By.cssSelector(".product-option__color-swatches-wrapper > ul >li:nth-child("+a+")>input"));
								//oos_color.click();
								jse.executeScript("arguments[0].click();", oos_color);
								Thread.sleep(3000);
								String[] classname = oos_color.getAttribute("class").split(" ");
								String status = classname[classname.length-1];
								if(status.equals("email-when-in-stock"))
									break;
								else continue;
							}

							driver.findElement(ADD_TO_CART_BUTTON).click();
							Thread.sleep(3000);
							softAssert.assertEquals(driver.findElement(EMAIL_WHEN_IN_STOCK_TITLE).getText() , "Email Me When Back In Stock" , "Email When In Stock title change");
							softAssert.assertEquals(driver.findElement(JOINTHEWAITLIST_REMINDER_DESC).getText() , "Get notified via email when this product is back in stock" , "Email When In Stock Reminder description change");
							softAssert.assertTrue(driver.findElement(JOINTHEWAITLIST_PRIVACYINFO).isDisplayed(),"Email When In Stock Privacy Info description not displayed");

							driver.findElement(JOINTHEWAITLIST_EMAILTEXTBOX).sendKeys("akshata@tommyjohnwear.com");
							driver.findElement(JOINTHEWAITLIST_NOTIFYBUTTON).click();
							Thread.sleep(4000);
							softAssert.assertEquals(driver.findElement(JOINTHEWAITLIST_SUCCESS).getText(),"Thank You" , "Email when in stock not functional");
							System.out.println(driver.findElement(JOINTHEWAITLIST_SUCCESS).getText());
							driver.findElement(JOINTHEWAITLIST_CLOSEBTN).click();
							driver.switchTo().defaultContent();
							softAssert.assertAll();
							flag=true;

							//}
						}

						//break;
					}
					if(flag==true)
						break;
					else
						continue;
				}
				if(flag==true)
					break;
				else
					continue;
			}	



		}


		else
		{
			//dropdown

			for(int i=1;i<=elementsCount;i++) {
				flag = false;
				//driver.findElement(SIZE_DROPDOWN).click();
				executor.executeScript("arguments[0].click();", driver.findElement(SIZE_DROPDOWN));
				element = driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+") > div"));

				allClasses = element.getAttribute("class");
				// check size available or not
				for (String c : allClasses.split(" ")) {
					if (c.equals("unavailable")) 
					{
						if(!driver.findElement(PRODUCT_TITLE).getText().contains("Pack"))
						{					

							if(driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+") > div > span")).getText().contentEquals("(Out of Stock - Email Me)"))
							{
								jse = (JavascriptExecutor)driver;
								jse.executeScript("arguments[0].click();", element);
								//		driver.switchTo().frame("swell-popup");
								softAssert.assertEquals(driver.findElement(EMAIL_WHEN_IN_STOCK_TITLE).getText() , "Email When In Stock" , "Email When In Stock title change");
								softAssert.assertEquals(driver.findElement(JOINTHEWAITLIST_REMINDER_DESC).getText() , "Get notified via email when this product is back in stock." , "Email When In Stock Reminder description change");
								softAssert.assertEquals(driver.findElement(JOINTHEWAITLIST_PRIVACYINFO).getText() , "We will send you an email once the product becomes available. Your email address will not be shared with anyone else." , "Email When In Stock Privacy Info description change");

								driver.findElement(JOINTHEWAITLIST_EMAILTEXTBOX).sendKeys("akshata@tommyjohnwear.com");
								driver.findElement(JOINTHEWAITLIST_NOTIFYBUTTON).click();
								Thread.sleep(4000);
								softAssert.assertEquals(driver.findElement(JOINTHEWAITLIST_SUCCESS).getText(),"Thank you!" , "Email when in stock not functional");
								System.out.println(driver.findElement(JOINTHEWAITLIST_SUCCESS).getText());
								driver.findElement(JOINTHEWAITLIST_CLOSEBTN).click();
								driver.switchTo().defaultContent();
								softAssert.assertAll();
								flag=true;

							}
						}
					}

					if(flag==true)
						break;
					else
						continue;
				}
				if(flag==true)
					break;
				else
					continue;
			}
		}

	}


	public void verifyRecommendedForU() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		element= driver.findElement(RFY_SECTION);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(5000);
		softAssert.assertTrue(driver.findElement(RFY_TITLE).isDisplayed() ,"Recommended for you section not present");
		softAssert.assertTrue(driver.findElement(RFY_SECTION).isDisplayed(), "Recommended for you section not present");
		softAssert.assertTrue(driver.findElement(RFY_PRODUCT_TITLE).isDisplayed(), "Recommended for you product title not present");
		softAssert.assertTrue(driver.findElement(RFY_PRODUCT_IMAGE).isDisplayed(), "Recommended for you product image not present");
		softAssert.assertTrue(driver.findElement(RFY_PRODUCT_REVIEWS).isDisplayed(), "Recommended for you product reviews not present");
		softAssert.assertTrue(driver.findElement(RFY_PRODUCT_PRICE).isDisplayed(), "Recommended for you product price not present");

		String text = driver.findElement(RFY_PRODUCT_TITLE).getText();
		jse.executeScript("arguments[0].click();", driver.findElement(RFY_PRODUCT_IMAGE));
		Thread.sleep(4000);
		softAssert.assertEquals(driver.findElement(PRODUCT_TITLE).getText(), text , "PDP page not correct after clicking on Recommended for you image");

		softAssert.assertAll();
	}

	public void VerifyQuickShopOnRecommendedforYou() throws Exception
	{
		Actions action = new Actions(driver);
		element= driver.findElement(RFY_SECTION);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);
		element = driver.findElement(RFY_PRODUCT_IMAGE);
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		action.moveToElement(element).build().perform();
		Thread.sleep(3000);
		new CollectionPageComponent(driver).AddproductToCartByQuickShop();
		Reporter.log("Verified DY recs quick shop functionality on PDP");

	}

	public void MethodToCheckColorSwatchOnDYRecs() throws Exception
	{
		SoftAssert softassert = new SoftAssert();
		element= driver.findElement(RFY_SECTION);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(3000);

		List<WebElement> allElements = driver.findElements(RFY_SWATCH_LIST);
		int elementsCount = allElements.size();
		System.out.println("Color Element count :: " + elementsCount);

		if (elementsCount > 1)
		{
			element = driver.findElement(By.cssSelector(".dy-recs-placeholder__above-desktop-reviews>div>.dy-rec>div>div:nth-child(2)>.dy-rec--products>div:nth-child(1) > div > div.product-item__swatches:nth-child(2)> div > div:nth-child(1)"));
			element.click();

			for (int i = 1; i < elementsCount; i++) {
				if (i < 4) {
					String Img_colortext = null;
					String colornew1 = null;
					String text = driver.findElement(RFY_PRODUCT_IMG_COLORNAME).getAttribute("href");
					String[] strarray = text.split("[=]");
					String text1 = strarray[strarray.length - 1];
					Img_colortext = text1.replace("-", " ").toLowerCase();

					System.out.println("Product image color name is: " + Img_colortext);


					element = driver.findElement(By.cssSelector(".dy-recs-placeholder__above-desktop-reviews>div>.dy-rec>div>div:nth-child(2)>.dy-rec--products>div:nth-child(1) > div > div.product-item__swatches:nth-child(2)> div > div:nth-child("+i+")>div"));
					colornew1 = element.getAttribute("title").replace("/", " ").toLowerCase(); 
					//	String colornew = colornew1.replace("/", " ");
					System.out.println("swatch color is: "+colornew1);
					if(colornew1.equalsIgnoreCase(Img_colortext)) 
					{
						WebElement elemen =driver.findElement(By.cssSelector(".dy-recs-placeholder__above-desktop-reviews>div>.dy-rec>div>div:nth-child(2)>.dy-rec--products>div:nth-child(1) > div > div.product-item__swatches:nth-child(2)> div > div:nth-child("+(i+1)+")>div"));
						jse.executeScript("arguments[0].click();", elemen);
						softassert.assertEquals(Img_colortext , colornew1 , "Color not changing");
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

	public void verifyMysteryPacks() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		SoftAssert softAssert = new SoftAssert();

		new HomePageComponents(driver).navigateToMysteryPacksinPacksCategory();
		Thread.sleep(3000);

		jse=(JavascriptExecutor)driver;
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		jse.executeScript("window.scrollBy(0,-250)");

		Thread.sleep(4000);


		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			if(title.getText().contains("Mystery"))
			{
				Thread.sleep(3000);
				System.out.println(title.getText());

				jse.executeScript("arguments[0].click();", title);

				break;
			}		

		}


		Thread.sleep(6000);

		softAssert.assertTrue(driver.findElement(PRODUCT_TITLE).isDisplayed() , "Product Title is not displayed");
		softAssert.assertTrue(driver.findElement(PRODUCT_PRICE).isDisplayed() ,"Product price is not displayed");	

		if(driver.findElement(SIZEGUIDE).isDisplayed())
		{
			WebElement ele = driver.findElement(SIZEGUIDE);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			Thread.sleep(3000);

			if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
				throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
			Reporter.log("Size guide link is Displayed :: Clickable");
			//Close first size guide window
			driver.findElement(By.cssSelector(".close_chart_modal")).click();

			Thread.sleep(3000);
		}
		else
		{
			System.out.println("Size guide link is not Displayed");
			Reporter.log("Size guide link is not Displayed.");
		}
		if(driver.findElement(RATING_STARS).isDisplayed()) {

			WebElement elem = driver.findElement(RATING_STARS);
			JavascriptExecutor executore = (JavascriptExecutor)driver;
			executore.executeScript("arguments[0].click();", elem);
			// wait for scroll it down
			Thread.sleep(6000);
			Reporter.log("Review Stars Are Displayed :: Clickable :: Clicked");
			// check for Rating and Reviews are present or not
			System.out.println("rating: " + driver.findElement(RATING_NUMBER).getText());

			if(!driver.findElement(RATING_NUMBER).getText().equals("(0)"))
			{


				if(driver.findElement(RATING_AND_REVIEWS_BOX).isDisplayed()) {
					if(!driver.findElement(FIRST_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In first box Review Stars not present in Rating and Reviews section");
					if(!driver.findElement(SECOND_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In second box rating list not present in Rating and Reviews section");
					if(!driver.findElement(THIRD_BOX_IN_RATING_AND_REVIEWS).isDisplayed())
						throw new Exception("In third box fit status not present in Rating and Reviews section");
				}

				else 

					throw new Exception("Rating box is not present");

			}

			else 
			{
				if(!driver.findElement(NO_REVIEW_WRITE_REVIEW).isEnabled())

					throw new Exception("'WRITE A REVIEW' button is not displayed");
				driver.findElement(NO_REVIEW_WRITE_REVIEW).click();
				Reporter.log("'WRITE A REVIEW' button is Displayed :: Clickable");

			}
			Reporter.log("Rating and Reviews Displayed");
		}
		else
			throw new Exception("Rating Stars are not clickable");



		//driver.findElement(SIZE_DROPDOWN).click();
		jse.executeScript("arguments[0].click();", driver.findElement(SIZE_DROPDOWN));
		element = driver.findElement(By.cssSelector(".select--options__list > li:nth-child(2) > div"));						

		jse.executeScript("arguments[0].click();" , element);

		element = driver.findElement(ADD_TO_CART_BUTTON);

		//String text1 = element.getText();
		String text1 = element.getAttribute("innerText");
		System.out.println("Button text when Available size selected :: "+text1);
		if(!(text1.equalsIgnoreCase("OUT OF STOCK")||text1.equalsIgnoreCase("Join the Waitlist")))
		{
			if(!(text1.equalsIgnoreCase("Add to Cart"))) {
				throw new Exception("Text change for 'ADD TO CART' ");
			}
		}
		// check if we are able to add and minus quantity
		try
		{
			// check if we are able to add and minus quantity
			String quantity = driver.findElement(QUANTITY).getAttribute("data-add-qty");
			Thread.sleep(3000);
			element = driver.findElement(PLUS_BUTTON);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
			//	driver.findElement(PLUS_BUTTON).click();
			Thread.sleep(3000);
			String quantity1 = driver.findElement(QUANTITY).getAttribute("data-add-qty");
			// check quantity added by 1 or not 
			if(Integer.parseInt(quantity1)!=Integer.parseInt(quantity)+1) 
				throw new Exception("Quantity not increased by 1");

			Reporter.log("Quantity increased by 1");
			element = driver.findElement(MINUS_BUTTON);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
			String quantity2 = driver.findElement(QUANTITY).getAttribute("data-add-qty");
			if(Integer.parseInt(quantity2)!=Integer.parseInt(quantity1)-1)
				throw new Exception("Quantity not decreased by 1");
			Reporter.log("Quantity decreased by 1");
		}
		catch(Exception e)
		{
			Reporter.log("Quantity selector was not present - please check if DY hides Qunatity selector is active");
		}


		// check 'Best PairGuarantee' and 'Shopping And Returns' are clickable or not
		flag = false;

		try{
			if (driver.findElement(PRODUCT_DETAILS).isDisplayed())
			{
				element = driver.findElement(PRODUCT_DETAILS);
				jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click();", element);
			}
			else throw new Exception("Product details accordion not present or not clikable ");
		}
		catch(Exception e )
		{
			Reporter.log("Product details accordion is not present for this particular product");
		}
		try
		{
			if (driver.findElement(PAIR_GUARANTEE).isDisplayed())
			{
				element = driver.findElement(PAIR_GUARANTEE);
				jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click();", element);
			}
			else throw new Exception("PAIR_GUARANTEE accordion not present or not clikable");
		}
		catch(Exception e )
		{
			Reporter.log("Pair guarantee link is not present for this particular product");
		}

		try{
			if(!driver.findElement(SHIPING_AND_RETURNS).getText().contentEquals("Free Shipping & Returns"))
			{
				if (driver.findElement(SHIPING_AND_RETURNS).isDisplayed()) {
					element = driver.findElement(SHIPING_AND_RETURNS);
					jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click();", element);
					//driver.findElement(SHIPING_AND_RETURNS).click();
				}		
				else throw new Exception("SHIPING_AND_RETURNS accordion not present or not clikable");	
			}
		}
		catch(Exception e )
		{
			Reporter.log("SHIPING_AND_RETURNS link is not present for this particular product");
		}

		if(!driver.findElement(ADD_TO_CART_BUTTON).isEnabled())
			throw new Exception("ADD TO CART button is not present");
		element = driver.findElement(ADD_TO_CART_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();" , element);

		Reporter.log("ADD TO CART button is Displayed :: Clickable");
		softAssert.assertAll();

	}

	public void QuickShopOnBuyWith() throws Exception
	{
		new HomePageComponents(driver).navigateToAllPantiesInWomenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();


		try{
			if(driver.findElement(By.cssSelector(".product-gallery>.buy-with-products")).isDisplayed())
			{
				Actions action = new Actions(driver);
				Thread.sleep(3000);

				//Hover On product image under buy with section on PDP
				element = driver.findElement(FIRST_PRODUCT_IMAGE_BUYWITH);
				action.moveToElement(element).build().perform();
				Thread.sleep(3000);
				System.out.println("Product image is hovered.");
				new CollectionPageComponent(driver).AddproductToCartByQuickShop();
			}
			else
				throw new Exception("Buy with section is not displayed on PDP");
		}
		catch(Exception e)
		{
			throw new Exception("Buy with section is not displayed on PDP");
		}
	}

	public void ATC_Scrolling_CTA() throws Exception
	{
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		new AddToCartComponents(driver).selectSize();
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)");
		WebElement Stickynav = driver.findElement(By.cssSelector(".product-bar"));
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(Stickynav.isDisplayed(), "Sticky nav is not displayed on PDP");
		element =driver.findElement(By.cssSelector(".product-bar__atc"));
		softassert.assertTrue(element.isDisplayed(), "scrolling CTA Add to Cart is not displayed");
		softassert.assertEquals(element.getText(), "Add To Cart", "Text changed for scrolling CTA Add to cart");
		Thread.sleep(3000);
		element.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.INLINE_CART_TITLE));
		softassert.assertTrue(driver.findElement(FlyCartPageLocator.INLINE_CART_TITLE).isDisplayed(), "Fly cart is not expanded after ATC on PDP");
		softassert.assertAll();
		Reporter.log("Scrolling CTA Add to Cart is displayed :: Clickable");
	}

	public void Sort_By_Reviews() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		SoftAssert softassert = new SoftAssert();
		new HomePageComponents(driver).navigateToDressesInwomensCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		Thread.sleep(5000);
		if(!driver.findElement(RATING_NUMBER).getText().equals("(0)"))
		{
			WebElement rating=driver.findElement(RATING_NUMBER);
			jse.executeScript("arguments[0].click();" , rating);

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(SORT_BY));

			softassert.assertEquals(driver.findElement(SORT_BY).getText(), "Sort By", "Default text is not 'Sort By' for reviews sort option");

			//Verify Default sort By is newest
			List<WebElement> sort_options = driver.findElements(SORT_BY_OPTIONS);
			for(int i=1; i<sort_options.size();i++)
			{
				WebElement sort_by_option = driver.findElement(By.cssSelector(".yotpo-reviews-question-container>div.yotpo-sort-by-options-container>ul>li:nth-child("+i+")"));
				String Option_name = sort_by_option.getAttribute("data-sort-option");
				if(Option_name.equals("Newest"))
				{
					String allclasses = sort_by_option.getAttribute("class");
					System.out.println("Class name is: "+allclasses);
					if(allclasses.contains("active")) {
						System.out.println("Default sort By is: "+Option_name);
						Reporter.log("Default sort By is newest");}
					else {
						throw new Exception("Default sort By is not newest.");
					}
					break;
				}

			}
			//verify sort By options are displayed
			driver.findElement(SORT_BY).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(SORT_BY_OPTIONS_DIV));
			softassert.assertTrue(driver.findElement(SORT_BY_OPTIONS_DIV).isDisplayed(), "Sort By option container is not displayed after click on sort by filter");
			for(int i=1; i<sort_options.size();i++)
			{
				WebElement sort_by_option = driver.findElement(By.cssSelector(".yotpo-reviews-question-container>div.yotpo-sort-by-options-container>ul>li:nth-child("+i+")"));
				String Option_name = sort_by_option.getAttribute("data-sort-option");
				softassert.assertTrue(sort_by_option.isDisplayed(), "Sort By option "+Option_name+"  is not displayed");
			}
			Reporter.log("Sort By options are displayed");

			//Apply sort By after rating filter
			driver.navigate().refresh();
			Thread.sleep(5000);
			for(int j=1; j<=5;j++)
			{
				element = driver.findElement(By.cssSelector(".yotpo-reviews-widget >div> div.yotpo-review-bottomline-container >div:nth-child(2) > ul.yotpo-revew-bottomline-list > li:nth-child("+j+") > .yotpo-review-bottomline-individual-ratings > .yotpo-review-bottomline-individual-ratings__count>span"));
				String num= element.getText();
				int count= Integer.parseInt(num);
				if(count>0)
				{
					Thread.sleep(3000);
					jse.executeScript("arguments[0].click();", element);
					//	element.click();
					break;
				}
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(REVIEW_FILTER_MESSAGE));
			element=driver.findElement(SORT_BY);
			jse.executeScript("arguments[0].click();", element);
			//Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(SORT_BY_OPTIONS_DIV));
			softassert.assertTrue(driver.findElement(SORT_BY_OPTIONS_DIV).isDisplayed(), "Sort By option container is not displayed after apply rating filter");
			WebElement Most_Helpful_SortBy = driver.findElement(By.cssSelector(".yotpo-reviews-question-container>div.yotpo-sort-by-options-container>ul>li:nth-child(4)"));
			String allclass = Most_Helpful_SortBy.getAttribute("class");
			String optionname= Most_Helpful_SortBy.getAttribute("data-sort-option");
			System.out.println("selected option is: "+optionname+" & its class is: "+allclass);
			jse.executeScript("arguments[0].click();", Most_Helpful_SortBy);
			//Most_Helpful_SortBy.click();
			Thread.sleep(3000);
			softassert.assertEquals(driver.findElement(SORT_BY).getText(), optionname, "Sort By options are not clickable");
			Reporter.log("User is able to sort after applying rating filter");
		}
		else
			System.out.println("Desired PDP have no Sort By functionality because of zero reviews.");
		softassert.assertAll();
	}

	public void Check_Ask_Question() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		SoftAssert softassert = new SoftAssert();
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RATING_STARS));
		element=driver.findElement(RATING_NUMBER);
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		softassert.assertEquals(driver.findElement(Ask_a_Question_CTA).getText(), "Ask a Question", "Text change for 'Ask a question'CTA");
		WebElement AQ_CTA=driver.findElement(Ask_a_Question_CTA);
		jse.executeScript("arguments[0].click();", AQ_CTA);
		Thread.sleep(3000);
		//	jse.executeScript("window.scrollBy(0, 30)");
		List<String> arraylist = new ArrayList<String>();
		String classes = driver.findElement(ASK_A_QSN_CONTAINER).getAttribute("class");
		for(String a: classes.split(" "))
		{
			arraylist.add(a);
		}
		System.out.println("arraylist: "+ arraylist);
		softassert.assertTrue(arraylist.contains("show"), "Ask a Question form is not displayed on cta click");
		softassert.assertTrue(driver.findElement(QSN_ANS_NAME_TEXTBOX).isDisplayed(), "Q&A Name textbox is not displayed");
		softassert.assertTrue(driver.findElement(QSN_ANS_EMAIL_TEXTBOX).isDisplayed(), "Q&A Email textbox is not displayed");
		softassert.assertTrue(driver.findElement(QSN_ANS_QUESTION_TEXTBOX).isDisplayed(), "Q&A Question textbox is not displayed");
		softassert.assertTrue(driver.findElement(SUBMIT_QUESTION_CTA).isDisplayed(), "Q&A submit button is not displayed");

		//field validations
		element=driver.findElement(SUBMIT_QUESTION_CTA);
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		softassert.assertTrue(driver.findElement(QSN_ANS_NAME_ERROR).isDisplayed(), "Name error message is not displayed with invalid input");
		softassert.assertTrue(driver.findElement(QSN_ANS_EMAIL_ERROR).isDisplayed(), "Email error message is not displayed with invalid input");
		softassert.assertTrue(driver.findElement(QSN_ANS_QUESTION_ERROR).isDisplayed(), "Question error message is not displayed with invalid input");

		Reporter.log("Ask a Question form is Displayed :: Correct");
		softassert.assertAll();
	}


	public void Check_Selected_Swatch() throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		Thread.sleep(5000);
		executor.executeScript("window.scrollBy(0, 350)", "");
		Thread.sleep(5000);

		List<WebElement> allElements = driver.findElements(By.cssSelector("div.mega-collection-grid.js-mega-collection-grid > div:nth-child(3) > div:nth-child(1)>div:nth-child(2)>.product-item__swatch-list>.slick-list>.slick-track>div>div"));
		int elementsCount = allElements.size();
		System.out.println("Color Element count :: " + elementsCount);

		if (elementsCount > 1)
		{			
			element = allElements.get(elementsCount-1);
			String swatch_name_plp = element.getAttribute("title").toString();
			executor.executeScript("arguments[0].click();", element);
			WebElement el = driver.findElement(CollectionPageLocator.FIRST_PRODUCT_HEAD_LINE_TEXT);
			executor.executeScript("arguments[0].click();", el);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
			String colortext_pdp = driver.findElement(COLOR_TEXT).getText();

			if(!swatch_name_plp.equalsIgnoreCase(colortext_pdp))
				throw new Exception("PDP doesn't opened with selected swatch from plp");
			Reporter.log("Validated PDP opens with selected swatch from plp");
		}


	}

	public void Check_Preselected_Size() throws Exception
	{

		SoftAssert softassert = new SoftAssert();
		List<String> selected_bundle_size1 = new ArrayList<String>();
		List<String> selected_bundle_size2 = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CollectionPageLocator.FIRST_PRODUCT));
		Thread.sleep(3000);
		String[] title1 = driver.findElement(CollectionPageLocator.FIRST_PRODUCT).getAttribute("data-name").split(",");
		String pname= title1[0];
		String[] title = pname.split(" ");

		String Product_type = title[title.length-1];
		System.out.println("product type is: "+Product_type);
		element= driver.findElement(CollectionPageLocator.FIRST_PRODUCT);
		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		if(Product_type.equalsIgnoreCase("Pack"))
		{		
			for (WebElement packtitle : producttitle)
			{
				System.out.println("product title is: "+packtitle.getText());
				if(packtitle.getText().contains("Lounge Set"))
				{
					Thread.sleep(3000);
					System.out.println(packtitle.getText());
					element = packtitle;
					break;
				}
			}

		}

		if((Product_type.equalsIgnoreCase("Set")||element.getText().contains("Set")))
		{
			jse=(JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			Thread.sleep(4000);

			producttitle = driver.findElements(By.cssSelector(".product-meta__title"));

			for (WebElement packtitle : producttitle)
			{
				System.out.println("product title is: "+packtitle.getText());
				if(packtitle.getText().contains("Lounge Set"))
				{
					Thread.sleep(3000);
					System.out.println(packtitle.getText());
				//	packtitle.click();
					jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click();" , packtitle);

					break;
				}
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
			SelectSizeOnBundlePDP();
			List<WebElement> BundleSize_OptionName = driver.findElements(By.cssSelector("div.radios-wrapper > div.radio-options-container > div"));
			int BundleSize_OptionCount = BundleSize_OptionName.size();
			for(int i=1; i<=BundleSize_OptionCount; i++)
			{
				allElements = driver.findElements(By.cssSelector("div.radios-wrapper > div.radio-options-container:nth-child("+i+") > div>input.sizeOption"));
				for(int j=1;j<allElements.size();j++)
				{
					element = driver.findElement(By.cssSelector("input.sizeOption:nth-child("+(j*2)+")"));
					try {
						String value = element.getAttribute("checked");
						if (value == null){
							continue;
						}
						else {
							BundleSizename1 = element.getAttribute("value");
							selected_bundle_size1.add(BundleSizename1);
							break;
						}
					} catch (Exception e) {
						System.out.println(element.getAttribute("value")+" size is not selected");
					}
				}

			}
			driver.navigate().back();
			Thread.sleep(5000);
			List<WebElement> Bundleproducttitle = driver.findElements(By.cssSelector(".product-meta__title"));
			for (int k=2;k<Bundleproducttitle.size();k++)
			{
				try {
					for (WebElement packtitle : Bundleproducttitle)
					{
						if(packtitle.getText().contains("Lounge Set"))
						{
							Thread.sleep(3000);
							element = driver.findElement(By.cssSelector("div.mega-collection-grid > div:nth-child(3) > div:nth-child("+k+") > a> h2"));
							break;
						}
					}


					//element = driver.findElement(By.cssSelector("div.mega-collection-grid > div:nth-child(3) > div:nth-child("+k+") > a> h2"));
				}
				catch(Exception ex)
				{
					for (WebElement packtitle : Bundleproducttitle)
					{
						if(packtitle.getText().contains("Lounge Set"))
						{
							Thread.sleep(3000);
							element = driver.findElement(By.cssSelector("div.mega-collection-grid> div > div:nth-child("+(k+1)+") > a> h2"));
							break;
						}
					}

					//element = driver.findElement(By.cssSelector("div.mega-collection-grid > div:nth-child(3) > div:nth-child("+(k+1)+") > a> h2"));
				}
				String[] Bundletitle1 = element.getText().split(",");
				String Bundle_pname= Bundletitle1[0];
				String[] BundleProducttitle = Bundle_pname.split(" ");
				String Bundle_Product_type = BundleProducttitle[BundleProducttitle.length-1];
				if(Bundle_Product_type.equals("Set"))
				{
					Thread.sleep(3000);
					System.out.println("2nd selected product name is: "+element.getText());
					((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
					break;
				}
				else {
					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
					continue;
				}
			}

			List<WebElement> BundleSize_OptionName2 = driver.findElements(By.cssSelector("div.radios-wrapper > div.radio-options-container > div"));
			int BundleSize_OptionCount2 = BundleSize_OptionName2.size();
			for(int i=1; i<=BundleSize_OptionCount2; i++)
			{
				allElements = driver.findElements(By.cssSelector("div.radios-wrapper > div.radio-options-container:nth-child("+i+") > div>input.sizeOption"));
				for(int j=1;j<allElements.size();j++)
				{
					element = driver.findElement(By.cssSelector("input.sizeOption:nth-child("+(j*2)+")"));
					try {
						String value = element.getAttribute("checked");
						if (value == null){
							continue;
						}
						else {
							BundleSizename1 = element.getAttribute("value");
							selected_bundle_size2.add(BundleSizename1);
							break;
						}
					} catch (Exception e) {
						System.out.println(element.getAttribute("value")+" size is not selected");
					}
				}

			}

			System.out.println("selected size is: "+selected_bundle_size1+" preselected size is: "+selected_bundle_size2);
			softassert.assertTrue(selected_bundle_size1.equals(selected_bundle_size2), "Preselect functionality for size options are incorrect on Bundle pdp");
		}
		else {
			new CollectionPageComponent(driver).navigateToProductDetailsPage();
			wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
			//new AddToCartComponents(driver).selectSize();
			Thread.sleep(2000);
			WebElement second_size = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child(5)"));
			//second_size.click();
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();" , second_size);

			allElements = driver.findElements(By.cssSelector("input.sizeOption"));
			for(int i=1;i<allElements.size();i++)
			{
				element = driver.findElement(By.cssSelector("input.sizeOption:nth-child("+(i*2)+")"));
				try {
					String value = element.getAttribute("checked");
					if (value == null){
						continue;
					}
					else {
						Sizename1 = element.getAttribute("value");
						System.out.println("size1 is: "+Sizename1);
						break;
					}
				} catch (Exception e) {
					System.out.println(element.getAttribute("value")+" size is not selected");
				}
			}

			driver.navigate().back();
			//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,450)");
			Thread.sleep(5000);
			producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
			for (int j=2;j<producttitle.size();j++)
			{
				try {
					if(driver.findElement(By.cssSelector("div.collection-hero--interactive-inner")).isDisplayed())
						((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
					element = driver.findElement(By.cssSelector("div.mega-collection-grid > div:nth-child(3) > div:nth-child("+j+") > a> h2"));
				}
				catch(Exception e)
				{
					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
					wait.until(ExpectedConditions.visibilityOfElementLocated(CollectionPageLocator.FIRST_PRODUCT));
					try {
						element= driver.findElement(By.cssSelector("div.mega-collection-grid > div > div > div:nth-child("+j+")> a > h2"));
					}
					catch(Exception ex)
					{
						element= driver.findElement(By.cssSelector("div.mega-collection-grid > div > div > div:nth-child("+(j+1)+")> a > h2"));
					}
				}
				if(element.getText().endsWith(Product_type))
				{
					Thread.sleep(3000);
					System.out.println("2nd selected product name is: "+element.getText());
					//element.click();
					((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
					break;
				}
				else {
					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
					continue;
				}
			}
			Thread.sleep(5000);
			allElements = driver.findElements(By.cssSelector("input.sizeOption"));
			for(int k=1;k<allElements.size();k++)
			{
				WebElement element1 = driver.findElement(By.cssSelector("input.sizeOption:nth-child("+(k*2)+")"));
				try {
					String value1 = element1.getAttribute("checked");
					if (value1 == null){
						continue;
					}
					else {
						Sizename2 = element1.getAttribute("value");
						System.out.println("size2 is: "+Sizename2);
						break;
					}
				} catch (Exception e) {
					System.out.println(element1.getAttribute("value")+" size is not selected");
				}
			}
			System.out.println("selected size is: "+Sizename1+" preselected size is: "+Sizename2);
			softassert.assertEquals(Sizename1, Sizename2, "Preselect functionality for size options are incorrect");
		}

		Reporter.log("Preselect functionality for sizes are correct on pdp");
		softassert.assertAll();

	}

	public void ErrorMessagewithMaxQTYonPDP() throws Exception
	{
		SoftAssert softassert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CollectionPageLocator.FIRST_PRODUCT));
		Thread.sleep(3000);
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
		new AddToCartComponents(driver).selectSize();
		if(!driver.findElement(ADD_TO_CART_BUTTON).isEnabled())
			throw new Exception("ADD TO CART button is not present");
		element = driver.findElement(ADD_TO_CART_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);

		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.CART_ICON));
		driver.findElement(HomePageLocators.CART_ICON).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.FIRST_PRODUCT_TITLE_IN_CART));
		driver.findElement(FlyCartPageLocator.QUANTITY).sendKeys("100000000");
		Thread.sleep(3000);
		driver.findElement(FlyCartPageLocator.PLUS_BUTTON).click();
		Thread.sleep(2000);
		driver.findElement(FlyCartPageLocator.INLINE_CART_CLOSE_BUTTON).click();
		Thread.sleep(3000);
		driver.findElement(ADD_TO_CART_BUTTON).click();
		Thread.sleep(5000);
		softassert.assertTrue(driver.findElement(LOW_INVENTORY_MSG).isDisplayed(), "On pdp 'Low inventory message' is not displayed with maximum qty added to cart");
		softassert.assertAll();
		Reporter.log("'Low inventory message' is verified on PDP");
	}

	public void SelectSizeOnBundlePDP() throws Exception
	{
		allElements = driver.findElements(ALL_SIZE_LIST);
		jse = (JavascriptExecutor)driver;
		elementsCount = allElements.size();
		System.out.println("All sizes list :: "+ elementsCount);
		if(driver.findElement(By.cssSelector(".radio-options-container")).isDisplayed())
		{
			//radio
			List<WebElement> Size_OptionName = driver.findElements(By.cssSelector("div.radios-wrapper > div.radio-options-container > div"));
			int Size_OptionCount = Size_OptionName.size();
			for(int i=1; i<=Size_OptionCount; i++)
			{
				Thread.sleep(3000);
				List<WebElement> Sizes_Label = driver.findElements(By.cssSelector("div.radios-wrapper>div:nth-child("+i+")>div.Size>label"));
				elementsCount = Sizes_Label.size();
				System.out.println("All sizes list count is :: "+ elementsCount);

				WebElement second_size_option = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container:nth-child("+i+")> div > label:nth-child(5)"));
				//second_size_option.click();
				jse.executeScript("arguments[0].click();" , second_size_option);
			}
		}
	}
	public void Add_Bundle_toCart() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		String allClasses = null;
		String allClass = null;
		new SizeGuideComponents(driver).navigateToBundlePDP();
		Thread.sleep(5000);
		allElements = driver.findElements(ALL_SIZE_LIST);
		elementsCount = allElements.size();
		System.out.println("All sizes list :: "+ elementsCount);
		if(driver.findElement(By.cssSelector(".radio-options-container")).isDisplayed())
		{
			//radio
			List<WebElement> Size_OptionName = driver.findElements(By.cssSelector("div.radios-wrapper > div.radio-options-container > div"));
			int Size_OptionCount = Size_OptionName.size();
			for(int i=1; i<=Size_OptionCount; i++)
			{
				Thread.sleep(3000);
				List<WebElement> Sizes_Label = driver.findElements(By.cssSelector("div.radios-wrapper>div:nth-child("+i+")>div.Size>label"));
				elementsCount = Sizes_Label.size();
				System.out.println("All sizes list count is :: "+ elementsCount);

				for(int j=3;j<=elementsCount;j=j+2) {
					flag = false;
					element = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container:nth-child("+i+")> div > label:nth-child("+j+")"));

					allClasses = element.getAttribute("class");
					// check size available or not
					for (String c : allClasses.split(" ")) {
						if (c.equals("oosVariant")) {
							/*
							 * jse = (JavascriptExecutor)driver; jse.executeScript("arguments[0].click();",
							 * element); System.out.println("Unavailable size clicked");
							 */									int y=j;
							 for(int k=y; k<y; k++)
							 {

								 WebElement e = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child("+k+")"));
								 allClass = e.getAttribute("class");
								 for (String d : allClass.split(" ")) {
									 if (d.equals("oosVariant")) 
										 y++;
									 else 
										 driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child("+y+")")).click();
								 }
							 }
							 //flag=true;							
						}
						else 
						{
							System.out.println("selected size is: "+element.getText());
							jse = (JavascriptExecutor)driver;
							jse.executeScript("arguments[0].click();" , element);

						}

					}
					if(j==elementsCount) {
						Reporter.log("No any size available");
						break;
					}	
					if(flag==false)
						break;
					else
						continue;

				}

				if(flag == true)
					continue;

			}	
			if(!driver.findElement(ADD_TO_CART_BUTTON).isEnabled())
				throw new Exception("ADD TO CART button is not present");
			element = driver.findElement(ADD_TO_CART_BUTTON);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);

		}

		else {
			//dropdown

			for(int i=1;i<=elementsCount;i++) {
				flag = false;
				//driver.findElement(SIZE_DROPDOWN).click();
				WebElement elem = driver.findElement(SIZE_DROPDOWN_MENS);
				jse.executeScript("arguments[0].click();", elem);
				element = driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Mens Size'] > li:nth-child("+i+") > div"));

				allClasses = element.getAttribute("class");
				// check size available or not
				for (String c : allClasses.split(" ")) {
					if (c.equals("unavailable")) {

						driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Mens Size']> li:nth-child("+i+")")).click();
						WebElement eleme = driver.findElement(SIZE_DROPDOWN_WOMENS);
						jse.executeScript("arguments[0].click();", eleme);
						//	driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size']> li:nth-child("+i+")")).click();
						int y =i;
						for(int j=0;j<y;j++)
						{

							WebElement e = driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size'] > li:nth-child("+y+") > div"));
							allClass = e.getAttribute("class");
							for (String d : allClass.split(" ")) {

								// check size available or not

								if (d.equals("unavailable")) 
									y++;
								else 
									driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size']> li:nth-child("+y+")")).click();
							}
						}


						flag = true;

						//break;
					}
					else 
					{
						Thread.sleep(3000);
						WebElement e =	driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Mens Size']> li:nth-child("+i+")"));
						Thread.sleep(2000);
						jse.executeScript("arguments[0].click();", e);
						if(!driver.findElement(ADD_TO_CART_BUTTON).getText().contentEquals("Add to Cart"))
						{
							WebElement eleme = driver.findElement(SIZE_DROPDOWN_WOMENS);
							jse.executeScript("arguments[0].click();", eleme);

							int y =i;
							for(int j=0;j<y;j++)
							{

								WebElement el = driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size'] > li:nth-child("+y+") > div"));
								String allClas = el.getAttribute("class");
								for (String u : allClas.split(" ")) {

									// check size available or not

									if (u.equals("unavailable")) 
										y++;
									else 
										driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size']> li:nth-child("+y+")")).click();
								}
							}
						}

						//jse.executeScript("arguments[0].click();", driver.findElement(SIZE_DROPDOWN_WOMENS));

						//	WebElement elm  = driver.findElement(By.cssSelector(".select--options__list[data-option-name = 'Womens Size']> li:nth-child("+i+") > div"));


						//jse.executeScript("arguments[0].click();", elm);
						if (!driver.findElement(ADD_TO_CART_BUTTON).getText().contentEquals("Add to Cart"))
							throw new Exception("Wrong language on CTA for In stock bundle");

					}

					if(i==elementsCount) {
						Reporter.log("No any size available");

					}			
					if(flag==false)
						break;
					else
						continue;

				}
				if(flag==false)
					break;
				else
					continue;
			}
			if(!driver.findElement(ADD_TO_CART_BUTTON).isEnabled())
				throw new Exception("ADD TO CART button is not present");
			element = driver.findElement(ADD_TO_CART_BUTTON);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);

		}
	}
}










