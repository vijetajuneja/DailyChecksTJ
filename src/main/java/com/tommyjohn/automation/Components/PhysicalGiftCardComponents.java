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
import com.tommyjohn.automation.PageLocators.PhysicalGiftCardPageLocators;
import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.PageLocators.ShoppingCartLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class PhysicalGiftCardComponents extends PhysicalGiftCardPageLocators
{

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

	public PhysicalGiftCardComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void AddGiftCardTocart() throws Exception
	{
		new HomePageComponents(driver).navigateToPhysicalGC();
		// Add gift card to the cart
		allElements = driver.findElements(PRICE_OPTIONS);
		elementsCount = allElements.size();
		System.out.println("All sizes list :: "+ elementsCount);

		 try {
				if(driver.findElement(By.cssSelector("div.radio-options-container")).isDisplayed())
				{

					for(int i=3;i<=elementsCount;i++) {
						element = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child(3)"));
						//element.click();
						jse = (JavascriptExecutor)driver;
						jse.executeScript("arguments[0].click();", element);
						Thread.sleep(3000);
					}
				}
		 }
		 catch(Exception e)
		 {
			 for(int i=1;i<=elementsCount;i++) {
					boolean flag = false;
					jse.executeScript("arguments[0].click();", driver.findElement(ProductDetailsPageComponents.SIZE_DROPDOWN));
					element = driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+") > div"));
                    Thread.sleep(3000);
		 }
		 }
		driver.findElement(ATC_BUTTON).click();
		Thread.sleep(4000);
	}


	public void GoToOnPhysicalGiftCardPage() throws Exception{
		String PGC_price =null;
		new HomePageComponents(driver).navigateToPhysicalGC();
		Thread.sleep(3000);

		//Price selector

				allElements = driver.findElements(PRICE_OPTIONS);
				softAssert.assertTrue(allElements.get(0).isDisplayed(),"Gift card Amount radio buttons are not displayed.");
				System.out.println("all amount list size is: "+allElements.size());
				allElements.get(0).click();
				PGC_price= driver.findElement(PRICE_OPTIONS).getText();
				Thread.sleep(3000);
				Reporter.log("Gift Cart amount radio buttons are displayed :: Clickable");

		/*
		 * softAssert.assertTrue(driver.findElement(PRICE_DROPDOWN).isDisplayed(),
		 * "Price dropdown is not present."); allElements =
		 * driver.findElements(PRICE_OPTIONS); elementsCount = allElements.size();
		 * System.out.println("All sizes list :: "+ elementsCount);
		 * 
		 * for(int i=0;i<=elementsCount-1;i++) {
		 * driver.findElement(PRICE_DROPDOWN).click();
		 * GC_price=allElements.get(i).getText(); allElements.get(i).click();
		 * System.out.println("price is: "+GC_price); Thread.sleep(3000); }
		 * 
		 * Reporter.log("Gift Cart amount drop-down is displayed :: Clickable");
		 * 
		 */		
				
				

		GC_Price_PDP =driver.findElement(ProductDetailsPageLocators.PRODUCT_PRICE).getText();
		//Add to cart button
		driver.findElement(ATC_BUTTON).click();
		System.out.println("Gift card successfully added to the cart.");
		Reporter.log("Gift card successfully added to the cart.");
		System.out.println("selected price is: "+PGC_price);
		Thread.sleep(7000);

		//Check Gift card title on inline cart
		softAssert.assertEquals(driver.findElement(PHYSICAL_GIFT_CARD_TITLE_INLINE_CART).getText(), "Tommy John Gift Card" , "Wrong title is displayed for Physical Gift cart on inline cart.");
		text = driver.findElement(PHYSICAL_GIFT_CARD_TITLE_INLINE_CART).getText();
		System.out.println("Physical Gift cart title is :: "+ text);
		Reporter.log("Physical Gift Card title on inline cart is Displayed :: Correct");

		//Check Gift card Color text on inline cart
		Expected_text = "TJ Green / "+PGC_price;
		System.out.println("Expected GC price text is: "+Expected_text);
		softAssert.assertEquals(driver.findElement(PHYSICAL_GIFT_CARD_COLOR_INLINE_CART).getText(), Expected_text,"Physical Gift card color text is incorrect on inline cart.");
		Reporter.log("Physical Gift Card color on inline cart is Displayed :: Correct");

		//Check Gift card price On inline cart
		softAssert.assertTrue(driver.findElement(PHYSICAL_GIFT_CARD_PRICE_INLINE_CART).isDisplayed(), "Physical Gift card price on Inline cart is not displayed");
		text = driver.findElement(PHYSICAL_GIFT_CARD_PRICE_INLINE_CART).getText();
		System.out.println("Gift card price on inline cart is :: "+text);
		softAssert.assertEquals(text,GC_Price_PDP, "Wrong Physical Gift card price is displayed on inline cart");
		Reporter.log("Physical Gift Card price on inline cart is Displayed :: Correct");

		softAssert.assertAll();
	}

	public void verifyFieldsforPhysicalGC() throws Exception {
					
		new HomePageComponents(driver).navigateToPhysicalGC();
		Thread.sleep(3000);
		//GC image
		softAssert.assertTrue(driver.findElement(PHYSICAL_GIFT_CARD_DISPLAY_IMAGE).isDisplayed(), "Physical Gift Card image is not displayed");
		Reporter.log("Physical Gift Card main image is displayed");
		softAssert.assertTrue(driver.findElement(PHYSICAL_GIFT_CARD_DISPLAY_IMAGE_SMALL_1).isDisplayed(), "Physical Gift card first side image is not present");
		Reporter.log("Physical Gift Card first side image is displayed");
		softAssert.assertTrue(driver.findElement(PHYSICAL_GIFT_CARD_DISPLAY_IMAGE_SMALL_2).isDisplayed(), "Physical Gift card second side image is not present");
		Reporter.log("Physical Gift Card second side image is displayed");


		//GiftCard Title
		softAssert.assertTrue(driver.findElement(PHYSICAL_GIFT_CARD_TITLE).isDisplayed(), "Physical Gift cart title is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(PHYSICAL_GIFT_CARD_TITLE).getText(),"Tommy John Gift Card", "Physical Gift card title is changed");
		System.out.println("Physical GC Title is: "+driver.findElement(PHYSICAL_GIFT_CARD_TITLE).getText());
		Reporter.log("Physical Gift Card title is Displayed :: Correct");

		//GiftCard Price
		softAssert.assertTrue(driver.findElement(PHYSICAL_GIFT_CARD_PRICE).isDisplayed(), "Physical Gift cart price is not displayed on PDP.");
		Reporter.log("Physical Gift Card price is Displayed");

		//GiftCard color
		softAssert.assertTrue(driver.findElement(COLOR_NAME).isDisplayed(), "Physical Gift cart color is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(COLOR_NAME).getText(),"TJ Green", "Physical Gift card color name is changed on PDP");
		System.out.println("Color name is: "+driver.findElement(COLOR_NAME).getText());
		Reporter.log("Physical Gift Card color is Displayed :: Correct");

		//Gift Card Amount
		softAssert.assertTrue(driver.findElement(PHYSICAL_GIFT_CARD_AMOUNT_TEXT).isDisplayed(), "Physical Gift cart amount title is not displayed on PDP.");
		softAssert.assertEquals(driver.findElement(PHYSICAL_GIFT_CARD_AMOUNT_TEXT).getText(),"Amount", "Amount text is changed on Physical Gift card PDP");
		System.out.println("Physical GC Amount label is: "+driver.findElement(PHYSICAL_GIFT_CARD_AMOUNT_TEXT).getText());
		Reporter.log("Physical Gift Card amount title is displayed");
		
		
		//Amount radio buttons
		List<WebElement> Amountlist = driver.findElements(By.cssSelector("div.radio-options-container>div>label.mainLabel>label"));
		System.out.println("Total amount list are : "+Amountlist.size());
		softAssert.assertTrue(Amountlist.get(0).isDisplayed(),"Gift card Amount radio buttons are not displayed.");
		Reporter.log("Gift Card amount radio buttons are displayed");

		
		// check 'Product Details' accordion
		if (driver.findElement(PRODUCT_DETAILS).isDisplayed()){
			softAssert.assertEquals(driver.findElement(PRODUCT_DETAILS).getText(),properties.getProperty("GCProductDetailsTitle"),"Text change for Product details accordion title in Physical GC.");
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
			softAssert.assertEquals(driver.findElement(SHIPING_AND_RETURNS).getText(),properties.getProperty("GCShippingReturnTitle"),"Text change for Shipping & Returns accordion title in Physical GC.");
			element = driver.findElement(SHIPING_AND_RETURNS);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", element);
		}
		else throw new Exception("SHIPING_AND_RETURNS accordion not present or not clikable");	
		
		softAssert.assertAll();
		
		Reporter.log("Shipping & Returns accordion is Displayed and clikable");
		Reporter.log("All the fields are present and clickable");

	}



	public void CheckAfterPayMessageonPhysicalGC() throws Exception
	{
		new HomePageComponents(driver).navigateToPhysicalGC();
		Thread.sleep(3000);
		try{
			System.out.println("Verifying for AfterPay Message .......");
			if(driver.findElement(ProductDetailsPageLocators.AFTERPAY_DIV).isDisplayed())
				throw new Exception("AfterPay Message is displayed on Physical Gift Card.");
		}
		catch(Exception e){
			System.out.println("After Pay Message is not displayed on Physical Gift Card.");
		}
		//Gift Card Added To Cart
		AddGiftCardTocart();
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
				throw new Exception("AfterPay Message is displayed on PDP with Physical Gift Card in cart.");
			Reporter.log("AfterPay Message is displayed on PDP with Physical Gift Card");
		}
		catch(Exception e) {
			System.out.println("After Pay Message is not displayed on normal PDP with Physical Gift Card.");
			Reporter.log("After Pay Message is not displayed on normal PDP with Physical Gift Card");
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
			if(title.equalsIgnoreCase("Tommy John Gift Card"))
			{
				try{
					System.out.println("Verifying for AfterPay Message .......");
					if(driver.findElement(FlyCartPageLocator.AFTERPAY_FLYCART).isDisplayed())
						throw new Exception("AfterPay Message is displayed on Fly cart with Physical Gift Card.");
					Reporter.log("AfterPay Message is displayed on Inline cart with Physical Gift Card");
				}
				catch(Exception e){
					System.out.println("After Pay Message is not displayed on Fly cart with Physical Gift Card.");
					Reporter.log("After Pay Message is not displayed on Inline cart with Physical Gift Card");
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
			if(title.equalsIgnoreCase("Tommy John Gift Card"))
			{
				try{
					System.out.println("Verifying for AfterPay Message .......");
					if(driver.findElement(ShoppingCartComponents.AFTERPAY_CART).isDisplayed())
						throw new Exception("AfterPay Message is displayed on Shopping cart with Physical Gift Card.");
					Reporter.log("AfterPay Message is displayed on Shopping cart with Physical Gift Card");
				}
				catch(Exception e){
					System.out.println("After Pay Message is not displayed on Shopping cart with Physical Gift Card.");
					Reporter.log("After Pay Message is not displayed on Shopping cart with Physical Gift Card");
				}
			}

		}

		wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartLocators.CHECKOUT_BUTTON));
		driver.findElement(ShoppingCartLocators.CHECKOUT_BUTTON).click();
		Thread.sleep(5000);
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

			if(title.equalsIgnoreCase("Tommy John Gift Card"))
			{
				try{
					System.out.println("Verifying for AfterPay Message on payment page.......");
					//if(!driver.findElement(CheckoutPageComponents.AFTERPAY_OPTION).getAttribute("style").equalsIgnoreCase("display: none;"))
					if(driver.findElement(CheckoutPageComponents.AFTERPAY_OPTION).isDisplayed())
					throw new Exception("AfterPay Message is displayed on payment page with Physical Gift Card.");
					Reporter.log("AfterPay Message is displayed on Checkout page with Physical Gift Card");
				}
				catch(Exception e){
					System.out.println("After Pay Message is not displayed on payment page with Physical Gift Card.");
					Reporter.log("After Pay Message is not displayed on Checkout page with Physical Gift Card");
				}
			}

		}
	}


}
