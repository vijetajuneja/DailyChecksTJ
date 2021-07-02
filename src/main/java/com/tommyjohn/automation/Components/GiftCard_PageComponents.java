package com.tommyjohn.automation.Components;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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

import com.tommyjohn.automation.PageLocators.FlyCartPageLocator;
import com.tommyjohn.automation.PageLocators.GiftCard_PageLocators;
import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.PageLocators.ShoppingCartLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class GiftCard_PageComponents extends GiftCard_PageLocators {
	public WebDriver driver;
	public Actions action;
	WebElement element;
	WebElement element1;
	Properties properties = CustomUtilities.properties;
	WebDriverWait wait;
	int elementsCount;
	public JavascriptExecutor jse;
	SoftAssert softAssert = new SoftAssert();
	WebElement Rec_mail;
	String GC_Price_PDP;
	String Expected_text;
	String Delivery_date;
	String newDelivery_Date;
	String invalidemail = "test";
	String text;
	List<WebElement> allElements;

	public GiftCard_PageComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void AddGiftCardTocart() throws Exception
	{
		new HomePageComponents(driver).navigateToGiftCard();
		// Add gift card to the cart
		allElements = driver.findElements(PRICE_OPTIONS);
		elementsCount = allElements.size();
		System.out.println("All sizes list :: "+ elementsCount);
		try {
			if(driver.findElement(By.cssSelector("div.radio-options-container")).isDisplayed())
			{
				allElements.get(0).click();
			}
		}

		catch(Exception e)
		{
			for(int i=1;i<=elementsCount;i++) {
				driver.findElement(PRICE_DROPDOWN).click();
				element = driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+") > div"));
				element.click();
				Thread.sleep(3000);
			}
		}
		driver.findElement(RECIPIENT_MAIL_TEXTBOX).sendKeys("testaccount00001@gmail.com");
		Thread.sleep(3000);
		driver.findElement(CONFIRM_MAIL_TEXTBOX).sendKeys("testaccount00001@gmail.com");
		Thread.sleep(3000);
		driver.findElement(DATE_TIME_PICKER_INPUT).click();
		Thread.sleep(3000);
		driver.findElement(TODAY).click();
		//driver.findElement(By.cssSelector(".dayContainer>span:nth-child(30)")).click();
		Thread.sleep(3000);
		driver.findElement(GIFT_CARD_MESSAGE_TEXTBOX).sendKeys("For You! Enjoy!");
		Thread.sleep(4000);

		driver.findElement(ATC_BUTTON).click();
		Thread.sleep(4000);
	}


	public void GoToOnGiftCardPage() throws Exception{
		String GC_price =null;
		action = new Actions(driver);
		
		new HomePageComponents(driver).navigateToGiftCard();
		Thread.sleep(3000);

		//Price selector

		allElements = driver.findElements(PRICE_OPTIONS);
		softAssert.assertTrue(allElements.get(0).isDisplayed(),"Gift card Amount radio buttons are not displayed.");
		System.out.println("all amount list is: "+allElements.size());
		WebElement GC_size=allElements.get(0);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", GC_size);
		GC_price= driver.findElement(PRICE_OPTIONS).getText();
		Thread.sleep(3000);
		Reporter.log("Gift Cart amount radio buttons are displayed :: Clickable");

		driver.navigate().refresh();
		Thread.sleep(3000);
		Rec_mail=driver.findElement(RECIPIENT_MAIL_TEXTBOX);
		Rec_mail.sendKeys(properties.getProperty("checkoutemail"));
		System.out.println("Entered recipient mail id is: "+Rec_mail.getAttribute("value"));
		Thread.sleep(2000);
		driver.findElement(CONFIRM_MAIL_TEXTBOX).sendKeys(properties.getProperty("checkoutemail"));
		Thread.sleep(2000);


		//Select Today's Delivery date
		softAssert.assertTrue(driver.findElement(DATE_TIME_PICKER_INPUT).isDisplayed(), "Date time picker input is not displayed.");
		WebElement date_picker=driver.findElement(DATE_TIME_PICKER_INPUT);
		jse.executeScript("arguments[0].click();", date_picker);
		//action.moveToElement(date_picker).click().build().perform();
		Thread.sleep(5000);
		WebElement date=driver.findElement(TODAY);
		jse.executeScript("arguments[0].click();", date);
		Thread.sleep(3000);
		WebElement new_date= driver.findElement(By.cssSelector("#gift-card-section >input#delivery_date"));
		Delivery_date = new_date.getAttribute("value");
		System.out.println("Selected delivery date is: "+Delivery_date);

		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MMMM d, yyyy").toFormatter();
		LocalDate parseDate = LocalDate.parse(Delivery_date, formatter);
		DateTimeFormatter formatter2= DateTimeFormatter.ofPattern("MM/dd/yyyy");
		newDelivery_Date = parseDate.format(formatter2);
		System.out.println("Converted date is: "+newDelivery_Date);
		Reporter.log("User is able to select date from date picker :: Clickable");

		// Message TextBox
		driver.findElement(GIFT_CARD_MESSAGE_TEXTBOX).sendKeys("For You! Enjoy!");
		Thread.sleep(3000);

		GC_Price_PDP =driver.findElement(ProductDetailsPageLocators.PRODUCT_PRICE).getText();
		//Add to cart button
		driver.findElement(ATC_BUTTON).click();
		System.out.println("Gift card successfully added to the cart.");
		Reporter.log("Gift card successfully added to the cart.");
		System.out.println("selected price is: "+GC_price);
		Thread.sleep(7000);

		//Check Gift card title on inline cart
		softAssert.assertEquals(driver.findElement(GIFT_CARD_TITLE_INLINE_CART).getText(), "E-Gift Card" , "Wrong title is displayed for Gift cart on inline cart.");
		text = driver.findElement(GIFT_CARD_TITLE_INLINE_CART).getText();
		System.out.println("Gift cart title is :: "+ text);
		Reporter.log("Gift Card title on inline cart is Displayed :: Correct");

		//Check Gift card Color text on inline cart
		Expected_text = "TJ Green / "+GC_price;
		System.out.println("Expected GC price text is: "+Expected_text);
		softAssert.assertEquals(driver.findElement(GIFT_CARD_COLOR_INLINE_CART).getText(), Expected_text,"Gift card color text is incorrect on inline cart.");
		Reporter.log("Gift Card color on inline cart is Displayed :: Correct");

		//Check Gift card price On inline cart
		softAssert.assertTrue(driver.findElement(GIFT_CARD_PRICE_INLINE_CART).isDisplayed(), " Gift card price on Inline cart is not displayed");
		text = driver.findElement(GIFT_CARD_PRICE_INLINE_CART).getText();
		System.out.println("Gift card price on inline cart is :: "+text);
		softAssert.assertEquals(text,GC_Price_PDP, "Wrong Gift card price is displayed on inline cart");
		Reporter.log("Gift Card price on inline cart is Displayed :: Correct");

		//Check Recipient email on inline cart
		softAssert.assertTrue(driver.findElement(RECIPIENT_MAIL_INLINE_CART).isDisplayed(), " Gift card recipient mail on Inline cart is not displayed");
		text = driver.findElement(RECIPIENT_MAIL_INLINE_CART).getText();
		System.out.println("Recipient mail id on inline cart is :: "+text);
		Expected_text ="Recipient Email: " +Rec_mail.getAttribute("value");
		System.out.println("Expected Recipient mail id is: "+Expected_text);
		softAssert.assertEquals(text, Expected_text,"Wrong Recipient Email is displayed on inline cart.");
		Reporter.log("Recipient mail on inline cart is Displayed :: Correct");

		//Check Delivery date on inline cart
		softAssert.assertTrue(driver.findElement(DELIVERY_DATE_INLINE_CART).isDisplayed(), " Gift card delivery date on Inline cart is not displayed");
		text = driver.findElement(DELIVERY_DATE_INLINE_CART).getText();
		System.out.println("Delivery date on inline cart is :: "+text);
		Expected_text ="Delivery Date: " +newDelivery_Date;
		System.out.println("Expected Recipient mail id is: "+Expected_text);
		softAssert.assertEquals(text,Expected_text,"Wrong Delivery date is displayed on inline cart");
		Reporter.log("Delivery date on inline cart is Displayed :: Correct");
		softAssert.assertAll();
	}

	public void verifyFieldsforGC() throws Exception {
		
		new HomePageComponents(driver).navigateToGiftCard();
		Thread.sleep(4000);
		//GC image
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(GIFT_CARD_DISPLAY_IMAGE));
		softAssert.assertTrue(driver.findElement(GIFT_CARD_DISPLAY_IMAGE).isDisplayed(), "Gift Card image is not displayed");
		Reporter.log("Gift Card delivery message text is displayed");
		softAssert.assertTrue(driver.findElement(GIFT_CARD_DISPLAY_IMAGE_SMALL_1).isDisplayed(), "Gift card first side image is not present");
		Reporter.log("Gift Card first side image is displayed");
	//	softAssert.assertTrue(driver.findElement(GIFT_CARD_DISPLAY_IMAGE_SMALL_2).isDisplayed(), "Gift card second side image is not present");
	//	Reporter.log("Gift Card second side image is displayed");


		//GiftCard Title
		softAssert.assertTrue(driver.findElement(GIFT_CARD_TITLE).isDisplayed(), "Gift cart title is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(GIFT_CARD_TITLE).getText(),properties.getProperty("GCtitle"), "Gift card title is changed");
		System.out.println("GC Title is: "+driver.findElement(GIFT_CARD_TITLE).getText());
		Reporter.log("Gift Card title is Displayed :: Correct");

		//GiftCard Price
		softAssert.assertTrue(driver.findElement(GIFT_CARD_PRICE).isDisplayed(), "Gift cart price is not displayed on PDP.");
		Reporter.log("Gift Card price is Displayed");

		//GiftCard color
		softAssert.assertTrue(driver.findElement(COLOR_NAME).isDisplayed(), "Gift cart color is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(COLOR_NAME).getText(),properties.getProperty("GCcolor"), "Gift card color name is changed on PDP");
		System.out.println("Color name is: "+driver.findElement(COLOR_NAME).getText());
		Reporter.log("Gift Card color is Displayed :: Correct");

		//Gift Card Amount
		softAssert.assertTrue(driver.findElement(GIFT_CARD_AMOUNT_TEXT).isDisplayed(), "Gift cart amount title is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(GIFT_CARD_AMOUNT_TEXT).getText(),properties.getProperty("GCAmount"), "Amount text is changed on Gift card PDP");
		System.out.println("GC Amount label is: "+driver.findElement(GIFT_CARD_AMOUNT_TEXT).getText());
		Reporter.log("Gift Card amount title is displayed");
		/*
		 * softAssert.assertTrue(driver.findElement(PRICE_DROPDOWN).isDisplayed(),
		 * "Gift card price dropdown is not displayed.");
		 * Reporter.log("Gift Card price drop-down is displayed");
		 */

		//Amount radio buttons
		List<WebElement> Amountlist = driver.findElements(By.cssSelector("div.radio-options-container>div>label.mainLabel>label"));
		System.out.println("Total amount list are : "+Amountlist.size());
		softAssert.assertTrue(Amountlist.get(0).isDisplayed(),"Gift card Amount radio buttons are not displayed.");
		Reporter.log("Gift Card amount radio buttons are displayed");

		//Recipient email
		softAssert.assertTrue(driver.findElement(RECIPIENT_MAIL_LABEL).isDisplayed(), "Recipient email text is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(RECIPIENT_MAIL_LABEL).getText(),properties.getProperty("GCRecipient"), "Recipient email text is changed on Gift card PDP");
		System.out.println("Recipient email label is: "+driver.findElement(RECIPIENT_MAIL_LABEL).getText());
		System.out.println("hard coded R-email is: "+properties.getProperty("GCRecipient"));
		Reporter.log("Gift Card Recipient's Email title is displayed :: correct");
		softAssert.assertTrue(driver.findElement(RECIPIENT_MAIL_TEXTBOX).isDisplayed(), "Recipient email textbox is not displayed.");
		Reporter.log("Gift Card Recipient's Email textbox is displayed");



		//Confirm Recipient email
		softAssert.assertTrue(driver.findElement(CONFIRM_MAIL_LABEL).isDisplayed(), "Confirm Recipient email text is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(CONFIRM_MAIL_LABEL).getText(),properties.getProperty("GCConfirm"), "Confirm Recipient email text is changed on Gift card PDP");
		System.out.println("Confirm Recipient email label is: "+driver.findElement(CONFIRM_MAIL_LABEL).getText());
		System.out.println("hard coded C-Recipient email is: "+properties.getProperty("GCConfirm"));
		Reporter.log("Gift Card confirm recipient's Email title is displayed :: correct");
		softAssert.assertTrue(driver.findElement(CONFIRM_MAIL_TEXTBOX).isDisplayed(), "Confirm Recipient email textbox is not displayed.");
		Reporter.log("Gift Card confirm Recipient's Email textbox is displayed");


		//Delivery date
		softAssert.assertTrue(driver.findElement(DELIVERY_DATE_LABEL).isDisplayed(), "Delivery date title text is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(DELIVERY_DATE_LABEL).getText(),properties.getProperty("GCDeliverydate"), "Delivery date title text is changed on Gift card PDP");
		System.out.println("Delivery date label is: "+driver.findElement(DELIVERY_DATE_LABEL).getText());
		Reporter.log("Gift Card delivery date title text is displayed ::correct");
		softAssert.assertTrue(driver.findElement(DATE_TIME_PICKER_INPUT).isDisplayed(), "Delivery date textbox is not displayed.");
		Reporter.log("Gift Card delivery date textbox is displayed");
		Thread.sleep(3000);

		//Delivery message
		softAssert.assertTrue(driver.findElement(DELIVERY_MESSAGE_LABEL).isDisplayed(), "Delivery message text is not displayed.");
		softAssert.assertEquals(driver.findElement(DELIVERY_MESSAGE_LABEL).getText(),properties.getProperty("GCDeliverymessage"),"Text change for delivery date message.");
		System.out.println("Delivery date message text is: "+driver.findElement(DELIVERY_MESSAGE_LABEL).getText());
		Reporter.log("Gift Card delivery message text is displayed ::correct");
		Thread.sleep(3000);

		driver.findElement(DATE_TIME_PICKER_INPUT).click();
		Thread.sleep(3000);
		driver.findElement(TODAY).click();

		//Message(optional)
		softAssert.assertTrue(driver.findElement(GIFT_CARD_MESSAGE_LABEL).isDisplayed(), "Message(optional) text is not displayed.");
		Reporter.log("Gift Card delivery date textbox is displayed");
		softAssert.assertEquals(driver.findElement(GIFT_CARD_MESSAGE_LABEL).getText(),properties.getProperty("GCMessage"),"Text change for message (optional) title.");
		System.out.println("GC message optional title is: "+driver.findElement(GIFT_CARD_MESSAGE_LABEL).getText());
		Reporter.log("Gift Card message(optional) text is displayed ::correct");

		softAssert.assertTrue(driver.findElement(GIFT_CARD_MESSAGE_TEXTBOX).isDisplayed(), "Gift card message textbox is not displayed");
		Reporter.log("Gift Card message textbox is displayed");
		driver.findElement(GIFT_CARD_MESSAGE_TEXTBOX).click();

		softAssert.assertTrue(driver.findElement(GIFT_CARD_MESSAGE_LIMIT).isDisplayed(), "Gift card message limit is not displayed");
		Reporter.log("Gift Card limit label text is displayed");
		softAssert.assertEquals(driver.findElement(GIFT_CARD_MESSAGE_LIMIT).getText(),properties.getProperty("GCMessageLimit"),"Text change for limit label in GC.");
		Reporter.log("Gift Card limit label text is correct");


		driver.findElement(GIFT_CARD_MESSAGE_TEXTBOX).sendKeys("For You! Enjoy!");
		Thread.sleep(3000);

		// check 'Product Details' accordion
		if (driver.findElement(PRODUCT_DETAILS).isDisplayed()){
			softAssert.assertEquals(driver.findElement(PRODUCT_DETAILS).getText(),properties.getProperty("GCProductDetailsTitle"),"Text change for Product details accordion title in GC.");
			Thread.sleep(3000);
			element = driver.findElement(PRODUCT_DETAILS);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
			Reporter.log("Product details accordion is Displayed and clikable");
			//softAssert.assertTrue(driver.findElement(GIFT_CARD_DETAILS_TITLE).isDisplayed(), "Gift Card heading is not displayed on product details accordion");
			Reporter.log("Gift Card heading is displayed on product details accordion");
		}
		else throw new Exception("Product details accordion is not Displayed or not clikable ");


		// check 'Shipping And Returns' accordion
		if (driver.findElement(SHIPING_AND_RETURNS).isDisplayed()){
			softAssert.assertEquals(driver.findElement(SHIPING_AND_RETURNS).getText(),properties.getProperty("GCShippingReturnTitle"),"Text change for Shipping & Returns accordion title in GC.");
			element = driver.findElement(SHIPING_AND_RETURNS);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
		}
		else throw new Exception("SHIPING_AND_RETURNS accordion not present or not clikable");	

		softAssert.assertAll();

		Reporter.log("Shipping & Returns accordion is Displayed and clikable");


		Reporter.log("All the fields are present and clickable");

	}


	public void verifyErrorMessagesforGC() throws Exception
	{
		/*
		 * action = new Actions(driver);
		 * 
		 * //navigate to Gift card PDP
		 * if(driver.findElement(NEW_ARRIVALS_OPTION).isDisplayed()) {
		 * 
		 * new HomePageComponents(driver).navigateToGiftCard();
		 * Reporter.log("Gift card link is clickable :: Clickable"); } else throw new
		 * Exception("New Arrivals category is not present.");
		 */
		new HomePageComponents(driver).navigateToGiftCard();
		Thread.sleep(6000);

		//When amount is not selected
		softAssert.assertTrue(driver.findElement(SELECT_AN_AMOUNT_BUTTON).isDisplayed(), "Select an amount button is not displayed");
		Reporter.log("Select an amount button is Displayed");
		softAssert.assertEquals(driver.findElement(SELECT_AN_AMOUNT_BUTTON).getText(), properties.getProperty("GCSelectAnAmountButton"),"Text changed for Select An amount button in GC.");

		//When amount is selected

		List<WebElement> Amountlist = driver.findElements(PRICE_OPTIONS);
		softAssert.assertTrue(Amountlist.get(0).isDisplayed(),"Gift card Amount radio buttons are not displayed.");
		Amountlist.get(0).click();
		Thread.sleep(3000);
		Reporter.log("Gift Cart amount radio buttons are displayed :: Clickable");


		/*
		 * softAssert.assertTrue(driver.findElement(PRICE_DROPDOWN).isDisplayed(),
		 * "Price dropdown is not present."); allElements =
		 * driver.findElements(PRICE_OPTIONS); elementsCount = allElements.size();
		 * System.out.println("All sizes list :: "+ elementsCount); 
		 * for(int
		 * i=0;i<=elementsCount-1;i++) { driver.findElement(PRICE_DROPDOWN).click();
		 * allElements.get(i).click(); Thread.sleep(3000); }
		 */
		softAssert.assertEquals(driver.findElement(SELECT_AN_AMOUNT_BUTTON).getText(), properties.getProperty("GCATCButton"),"Text changed for Add to Cart button in GC.");
		Thread.sleep(3000);

		// if all fields are empty
		WebElement atc=driver.findElement(ATC_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", atc);
		Thread.sleep(3000);
		softAssert.assertTrue(driver.findElement(EMAIL_ERROR_MESSAGES_GC).isDisplayed(), "Error message for empty Recipient email is not displayed");
		softAssert.assertEquals(driver.findElement(EMAIL_ERROR_MESSAGES_GC).getText(), properties.getProperty("GCEmptyErrorEmail"),"Error message text change for empty Recipient email");
		Reporter.log("Error message for Empty Recipient email is displayed :: correct.");

		softAssert.assertTrue(driver.findElement(CONFIRM_EMAIL_ERROR_MSG_GC).isDisplayed(), "Error message for empty C-Recipient email is not displayed");
		softAssert.assertEquals(driver.findElement(CONFIRM_EMAIL_ERROR_MSG_GC).getText(), properties.getProperty("GCEmptyErrorEmail"),"Error message text change for empty Confirm Recipient email");
		Reporter.log("Error message for Empty Confirm Recipient email is displayed :: correct.");

		softAssert.assertTrue(driver.findElement(DATE_ERROR_MSG_GC).isDisplayed(), "Error message for empty Delivery date is not displayed");
		softAssert.assertEquals(driver.findElement(DATE_ERROR_MSG_GC).getText(), properties.getProperty("GCEmptyErrorDate"),"Error message text change for empty delivery date.");
		Reporter.log("Error message for Empty Delivery date is displayed :: correct.");
		Thread.sleep(3000);


		//if invalid email is entered and mismatched email
		driver.findElement(RECIPIENT_MAIL_TEXTBOX).sendKeys(invalidemail);
		driver.findElement(CONFIRM_MAIL_TEXTBOX).sendKeys("test@tommyjohn.com");
		//driver.findElement(ATC_BUTTON).click();
		jse.executeScript("arguments[0].click();", atc);
		Thread.sleep(3000);

		softAssert.assertTrue(driver.findElement(EMAIL_ERROR_MESSAGES_GC).isDisplayed(), "Error message for Invalid Recipient email is not displayed");
		softAssert.assertEquals(driver.findElement(EMAIL_ERROR_MESSAGES_GC).getText(), properties.getProperty("GCInvalidEmailError"),"Error message text change for Invalid email");
		Reporter.log("Error message for Invalid email is displayed :: correct.");

		softAssert.assertTrue(driver.findElement(CONFIRM_EMAIL_ERROR_MSG_GC).isDisplayed(), "Error message for Mismatched C-Recipient email is not displayed");
		softAssert.assertEquals(driver.findElement(CONFIRM_EMAIL_ERROR_MSG_GC).getText(), properties.getProperty("GCMismatchEmailError"),"Error message text change for Mismatched Confirm Recipient email");
		Reporter.log("Error message for Mismatched email is displayed :: correct.");

		softAssert.assertAll();

	}


	//		public void AddGiftCardTocart() throws Exception
	//		{
	//			new HomePageComponents(driver).navigateToGiftCard();
	//			// Add gift card to the cart
	//			allElements = driver.findElements(PRICE_OPTIONS);
	//			elementsCount = allElements.size();
	//			System.out.println("All sizes list :: "+ elementsCount);
	//
	//			for(int i=1;i<=elementsCount;i++) {
	//				Thread.sleep(3000);
	//				driver.findElement(PRICE_DROPDOWN).click();
	//				element = driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+") > div"));
	//				element.click();
	//				Thread.sleep(3000);
	//			}
	//			driver.findElement(RECIPIENT_MAIL_TEXTBOX).sendKeys("testaccount00001@gmail.com");
	//			Thread.sleep(3000);
	//			driver.findElement(CONFIRM_MAIL_TEXTBOX).sendKeys("testaccount00001@gmail.com");
	//			Thread.sleep(3000);
	//			
	//			//Delivery date
	//			//softAssert.assertTrue(driver.findElement(DATE_TIME_PICKER_INPUT).isDisplayed(), "Date time picker input is not displayed.");
	//			driver.findElement(DATE_TIME_PICKER_INPUT).click();
	//			Thread.sleep(3000);
	//			String month= "June";
	//			String todaydate_text= driver.findElement(TODAY).getText();
	//			int Today_date= Integer.valueOf(todaydate_text)+1;
	//			while (true) 
	//			{
	//				String month_text = driver.findElement(By.cssSelector(".flatpickr-month>.flatpickr-current-month>span")).getText();
	//				if(month_text.equals(month))
	//				{
	//					System.out.println("selected month is: "+month_text);
	//					break;
	//				}
	//				else{
	//					Thread.sleep(3000);
	//					driver.findElement(By.cssSelector(".flatpickr-months>.flatpickr-next-month")).click();
	//				}
	//			}
	//
	//			driver.findElement(By.xpath("//*[@class='dayContainer']/span[contains(text(),"+Today_date+")]")).click();
	//			//driver.findElement(DATE_TIME_PICKER_INPUT).click();
	//			//Thread.sleep(3000);
	//			// Select hard coded date
	////			String month = "";
	////			String day = "";
	//			//driver.findElement(TODAY).click();
	//			//driver.findElement(By.cssSelector(".dayContainer>span:nth-child(30)")).click();
	//			Thread.sleep(3000);
	//			driver.findElement(GIFT_CARD_MESSAGE_TEXTBOX).sendKeys("For You! Enjoy!");
	//			Thread.sleep(4000);
	//			
	//			driver.findElement(ATC_BUTTON).click();
	//			Thread.sleep(4000);
	//		}

	public void CheckAfterPayMessageonGC() throws Exception
	{
		new HomePageComponents(driver).navigateToGiftCard();
		Thread.sleep(3000);
		try{
			System.out.println("Verifying for AfterPay Message .......");
			if(driver.findElement(ProductDetailsPageLocators.AFTERPAY_DIV).isDisplayed())
				throw new Exception("AfterPay Message is displayed on Gift Card.");
		}
		catch(Exception e){
			System.out.println("After Pay Message is not displayed on Gift Card.");
		}
		//Gift Card Added To Cart
		new GiftCard_PageComponents(driver).AddGiftCardTocart();
		Thread.sleep(3000);


		// Navigate to any normal PDP
		Thread.sleep(3000);
		element = driver.findElement(FlyCartPageLocator.INLINE_CART_CLOSE_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		Thread.sleep(5000);
		//Check AfterPay message displayed or not on PDP
		try{
			System.out.println("Verifying for AfterPay Message .......");
			if(driver.findElement(ProductDetailsPageLocators.AFTERPAY_PDP).isDisplayed())
				throw new Exception("AfterPay Message is displayed on PDP with Gift Card in cart.");
			Reporter.log("AfterPay Message is displayed on PDP with Gift Card");
		}
		catch(Exception e) {
			System.out.println("After Pay Message is not displayed on normal PDP with Gift Card.");
			Reporter.log("After Pay Message is not displayed on normal PDP with Gift Card");
		}



		//Check gift cart with normal product in fly cart
		new	AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageComponents.CART_ICON).click();
		allElements = driver.findElements(FlyCartPageLocator.LIST_OF_ITEMS_IN_FLYCART);
		System.out.println("Total item in cart is: "+allElements.size());
		for(int i=1; i<=allElements.size();i++)
		{
			String title = driver.findElement(By.cssSelector("div.inline-cart__col1 > div:nth-child(6) > article:nth-child("+i+") > div.line-item__summary > a")).getText();
			System.out.println("product title in fly cart is: " +title);
			if(title.equalsIgnoreCase("E-Gift Card"))
			{
				try{
					System.out.println("Verifying for AfterPay Message .......");
					if(driver.findElement(FlyCartPageLocator.AFTERPAY_FLYCART).isDisplayed())
						throw new Exception("AfterPay Message is displayed on Fly cart with Gift Card.");
					Reporter.log("AfterPay Message is displayed on Inline cart with Gift Card");
				}
				catch(Exception e){
					System.out.println("After Pay Message is not displayed on Fly cart with Gift Card.");
					Reporter.log("After Pay Message is not displayed on Inline cart with Gift Card");
				}
			}

		}
		//navigate to shopping cart
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		Thread.sleep(3000);

		//Check gift cart with normal product in Shopping cart
		allElements = driver.findElements(ShoppingCartComponents.LIST_OF_ITEMS_IN_SHOPPING_CART);
		System.out.println("Total item in cart is: "+allElements.size());
		for(int i=1; i<=allElements.size();i++)
		{
			String title = driver.findElement(By.cssSelector(".cart.container > div.cart__outer > .cart__items > div > article.line-item:nth-child("+i+") > .line-item__summary > a")).getText();
			System.out.println("product title in fly cart is: " +title);
			if(title.equalsIgnoreCase("E-Gift Card"))
			{
				try{
					System.out.println("Verifying for AfterPay Message .......");
					if(driver.findElement(ShoppingCartComponents.AFTERPAY_CART).isDisplayed())
						throw new Exception("AfterPay Message is displayed on Shopping cart with Gift Card.");
					Reporter.log("AfterPay Message is displayed on Shopping cart with Gift Card");
				}
				catch(Exception e){
					System.out.println("After Pay Message is not displayed on Shopping cart with Gift Card.");
					Reporter.log("After Pay Message is not displayed on Shopping cart with Gift Card");
				}
			}

		}

		wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartLocators.CHECKOUT_BUTTON));
		driver.findElement(ShoppingCartLocators.CHECKOUT_BUTTON).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageComponents.CHECKOUT_EMAIL));
		driver.findElement(CheckoutPageComponents.CHECKOUT_EMAIL).sendKeys(CustomUtilities.properties.getProperty("checkoutemail"));
		new CheckoutPageComponents(driver).entershippingdetails();
		Thread.sleep(3000);
		driver.findElement(CheckoutPageComponents.CONTINUE_TO_SHIPPING_BUTTON).click();
		Thread.sleep(5000);
		System.out.println("payment page");
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageComponents.CONTINUE_TO_PAYMENT_BUTTON));
		WebElement element = driver.findElement(CheckoutPageComponents.CONTINUE_TO_PAYMENT_BUTTON);
		if(!element.isDisplayed())
			throw new Exception("Continue to payment button is not displayed.");
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);

		//Check gift cart with normal product in CheckOut Page
		allElements = driver.findElements(CheckoutPageComponents.LIST_OF_ITEM_IN_PAYMENT_PAGE);
		System.out.println("Total item in cart is: "+allElements.size());
		for(int i=1; i<=allElements.size();i++)
		{
			String title = driver.findElement(By.cssSelector("tbody > tr:nth-child("+i+") > th.product__description > span.product__description__name.order-summary__emphasis")).getText();

			if(title.equalsIgnoreCase("E-Gift Card"))
			{
				try{
					System.out.println("Verifying for AfterPay Message .......");
					if(!driver.findElement(CheckoutPageComponents.AFTERPAY_OPTION).getAttribute("style").equalsIgnoreCase("display: none;"))
						throw new Exception("AfterPay Message is displayed on payment page with Gift Card.");
					Reporter.log("AfterPay Message is displayed on Checkout page with Gift Card");
				}
				catch(Exception e){
					System.out.println("After Pay Message is not displayed on payment page with Gift Card.");
					Reporter.log("After Pay Message is not displayed on Checkout page with Gift Card");
				}
			}

		}
	}
}

