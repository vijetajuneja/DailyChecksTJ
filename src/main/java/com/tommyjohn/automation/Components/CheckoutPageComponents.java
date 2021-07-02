package com.tommyjohn.automation.Components;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.tommyjohn.automation.PageLocators.AccountLoginLocators;
import com.tommyjohn.automation.PageLocators.CheckoutPageLocators;
import com.tommyjohn.automation.PageLocators.FlyCartPageLocator;
import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;


public class CheckoutPageComponents extends CheckoutPageLocators {
	public WebDriver driver;
	public JavascriptExecutor jse;

	List<WebElement> allElements;
	double	installment;
	String price;
	SoftAssert softAssert=new SoftAssert();
	String Promo_Code = "TJHUSTLE";
	public CheckoutPageComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void expresscheckout() throws Exception 
	{
		SoftAssert softAssert = new SoftAssert();
		String text = null;
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartComponents.CART_TITLE));

		driver.findElement(ShoppingCartComponents.CHECKOUT_BUTTON).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPRESS_CHECKOUT_TEXT));
		Thread.sleep(3000);
	//	driver.switchTo().frame(driver.findElement(By.className("paypalLight")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(PAYPAL_BUTTON));
		driver.findElement(PAYPAL_BUTTON).click();
		String mainWindow = driver.getWindowHandle();
		Set<String> set =driver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();
			// Compare whether the main windows is not equal to child window. If not equal, we will close.
			if(!mainWindow.equals(childWindow))
				driver.switchTo().window(childWindow);
			text = driver.switchTo().window(childWindow).getTitle();
		}
		softAssert.assertEquals(text, "PayPal Checkout");
		driver.close();

		Reporter.log("PayPal option is present on checkout page");
		Reporter.log("PayPal popup shows up when clicked on paypal express checkout button");
		Thread.sleep(3000);
		driver.switchTo().window(mainWindow);
		WebElement element = driver.findElement(GPAY_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		//driver.findElement(GPAY_BUTTON).click();
		Set<String> set1 =driver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr1 = set1.iterator();
		while(itr1.hasNext()){
			String childWindow1=itr1.next();
			// Compare whether the main windows is not equal to child window. If not equal, we will close.
			if(!mainWindow.equals(childWindow1))
				driver.switchTo().window(childWindow1);
			text = driver.switchTo().window(childWindow1).getTitle();
		}
		softAssert.assertEquals(text, "Sign in – Google accounts");
		driver.close();
		driver.switchTo().window(mainWindow);
		Reporter.log("GPay option is present on checkout page");
		Reporter.log("GPay popup shows up when clicked on Gpay express checkout button");
		//verify amz pay
		WebElement element1 = driver.findElement(AMZ_PAY);
		jse.executeScript("arguments[0].click();", element1);
		text = driver.getTitle();
		softAssert.assertEquals(text, "Amazon Sign in using our secure server");

		Reporter.log("Amazon Pay option is present on checkout page"); 
		Reporter.log("Redirected to amzon login page when clicked on amz pay button"); 
		Thread.sleep(3000);
	}

	public void CheckBreadcrumbs()
	{
		softAssert.assertTrue(driver.findElement(BREADCRUMB_LINK_CART).isDisplayed(), "Cart link is not displayed on breadcrumb");
		softAssert.assertTrue(driver.findElement(BREADCRUMB_LINK_INFORMATION).isDisplayed(), "Information link is not displayed on breadcrumb");
		softAssert.assertTrue(driver.findElement(BREADCRUMB_LINK_SHIPPING).isDisplayed(), "Shipping link is not displayed on breadcrumb");
		softAssert.assertTrue(driver.findElement(BREADCRUMB_LINK_PAYMENT).isDisplayed(), "Payment link is not displayed on breadcrumb");
		softAssert.assertAll();
		Reporter.log("Validated Breadcrumbs on checkout pages");
	}

	public void guestcheckoutflow() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartComponents.CART_TITLE));

		driver.findElement(ShoppingCartComponents.CHECKOUT_BUTTON).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_EMAIL));
		driver.findElement(CHECKOUT_EMAIL).sendKeys(CustomUtilities.properties.getProperty("checkoutemail"));

		Reporter.log("Email for Guest User entered successfully");

		softAssert.assertEquals(driver.findElement(SHIPPINGADD_TEXT).getText(), "Shipping address");
		entershippingdetails();
		Reporter.log("Shipping Address Details entered");

		WebElement Continue_shipping=driver.findElement(CONTINUE_TO_SHIPPING_BUTTON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Continue_shipping);
		Reporter.log("User is navigated to select shipping method");

		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SHIPPING_TEXT));
		softAssert.assertEquals(driver.findElement(SHIPPING_TEXT).getText(), "Shipping method");
		//driver.findElement(CONTINUE_TO_PAYMENT_BUTTON).click();
		WebElement Continue_payment=driver.findElement(CONTINUE_TO_PAYMENT_BUTTON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Continue_payment);
		Reporter.log("Selected shipping method and user is navigated to payment page");

		softAssert.assertTrue(driver.findElement(COMPLETE_ORDER_BUTTON).isDisplayed() , "Complete Order button is not displayed");	
		Reporter.log("Complete Order button is enabled");

		softAssert.assertAll();
	}

	public void registeredusercheckoutflow() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		String password = CustomUtilities.properties.getProperty("password");
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartComponents.CART_TITLE));

		driver.findElement(ShoppingCartComponents.CHECKOUT_BUTTON).click();
		Reporter.log("Checkout page displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACTINFO_TEXT));
		driver.findElement(LOGIN_LINK).click();
		Reporter.log("User naviagted to login page");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AccountLoginLocators.CUSTOMER_EMAIL_INPUT));
		driver.findElement(AccountLoginLocators.CUSTOMER_EMAIL_INPUT).sendKeys(CustomUtilities.properties.getProperty("loginemail"));
		driver.findElement(AccountLoginLocators.CUSTOMER_PASSWORD_INPUTBOX).sendKeys(password);
		driver.findElement(AccountLoginLocators.LOGIN_BUTTON).click();
		Reporter.log("User logged in successfully");

		Thread.sleep(6000);
		entershippingdetails();
		Reporter.log("Shipping Address Details entered");

		//driver.findElement(CONTINUE_TO_SHIPPING_BUTTON).click();
		WebElement Continue_shipping=driver.findElement(CONTINUE_TO_SHIPPING_BUTTON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Continue_shipping);

		Reporter.log("User is navigated to select shipping method");
		Thread.sleep(8000);
		softAssert.assertEquals(driver.findElement(SHIPPING_TEXT).getText(), "Shipping method");
		WebElement element = driver.findElement(CONTINUE_TO_PAYMENT_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		//driver.findElement(CONTINUE_TO_PAYMENT_BUTTON).click();
		Reporter.log("Selected shipping method and user is navigated to payment page");
		Thread.sleep(5000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(COMPLETE_ORDER_BUTTON));	
		softAssert.assertTrue(driver.findElement(COMPLETE_ORDER_BUTTON).isDisplayed() , "Complete Order button is not displayed");	
		Reporter.log("Complete Order button is displayed");
		softAssert.assertAll();	
	}

	public void informationpage() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartComponents.CART_TITLE));
		driver.findElement(ShoppingCartComponents.CHECKOUT_BUTTON).click();
		Reporter.log("Checkout page displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPRESS_CHECKOUT_TEXT));
		CheckBreadcrumbs();
		softAssert.assertTrue(driver.findElement(EXPRESS_CHECKOUT_TEXT).isDisplayed(), "Express checkout text is not displayed");
		softAssert.assertTrue(driver.findElement(CONTACTINFO_TEXT).isDisplayed(), "Contact information text is not displayed");
		softAssert.assertTrue(driver.findElement(ALREADYHAVEANACCOUNT_TEXT).isDisplayed(), "Already have an account? text is not displayed");
		softAssert.assertTrue(driver.findElement(LOGIN_LINK).isDisplayed(), "Login link is not displayed");
		softAssert.assertTrue(driver.findElement(SHIPPINGADD_TEXT).isDisplayed(), "Shipping address text is not displayed");
		//softAssert.assertTrue(driver.findElement(REMEMBERME_CHCKBOX).isDisplayed(), "Save this information for next time checkbox is not displayed");
		softAssert.assertTrue(driver.findElement(RETURN_TO_CART_LINK).isDisplayed(), "Return to cart link is not displayed");
		softAssert.assertTrue(driver.findElement(CONTINUE_TO_SHIPPING_BUTTON).isDisplayed(), "Continue to shipping method button is not displayed");
		sidebar();
		CheckPromoCodeApplication();
		softAssert.assertAll();	

	}


	public void shippingpage() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartComponents.CART_TITLE));
	//	driver.findElement(ShoppingCartComponents.CHECKOUT_BUTTON).click();
		WebElement checkout_btn=driver.findElement(ShoppingCartComponents.CHECKOUT_BUTTON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkout_btn);

		Reporter.log("Checkout page displayed");
		wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACTINFO_TEXT));
		driver.findElement(CHECKOUT_EMAIL).sendKeys(CustomUtilities.properties.getProperty("checkoutemail"));
		softAssert.assertEquals(driver.findElement(SHIPPINGADD_TEXT).getText(), "Shipping address");
		entershippingdetails();
		Reporter.log("Shipping Address Details entered");

		//driver.findElement(CONTINUE_TO_SHIPPING_BUTTON).click();
		WebElement Continue_shipping=driver.findElement(CONTINUE_TO_SHIPPING_BUTTON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Continue_shipping);
		Reporter.log("User is navigated to select shipping method");
		wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACT_EMAIL));
		CheckBreadcrumbs();
		softAssert.assertTrue(driver.findElement(CONTACT_EMAIL).isDisplayed(), "Conatct email is not present");
		softAssert.assertTrue(driver.findElement(SHIP_ADDRESS).isDisplayed(), "Shipping address is not present");
		softAssert.assertTrue(driver.findElement(CHANGE_LINK_CONTACT).isDisplayed(), "Contact change link is not present to chnage ");
		softAssert.assertTrue(driver.findElement(CHANGE_LINK_SHIP_TO).isDisplayed(), "Ship To change link is not present to chnage ");
		softAssert.assertTrue(driver.findElement(SHIPPING_TEXT).isDisplayed(), "Shipping text is not present");
		//softAssert.assertTrue(driver.findElement(RETURN_LINK).isDisplayed(), "return link is not present");
		wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_TO_PAYMENT_BUTTON));
		softAssert.assertTrue(driver.findElement(CONTINUE_TO_PAYMENT_BUTTON).isDisplayed(), "Continue to paymnet method button is not present");
		softAssert.assertTrue(driver.findElement(RETURN_LINK).isDisplayed(), "return link is not present");
		List<WebElement> shipmethods = driver.findElements(By.className("radio__label__primary"));
		for(WebElement method : shipmethods)
		{
			System.out.println(method.getText());
		}
		sidebar();
		CheckPromoCodeApplication();
		softAssert.assertAll();
	}

	public void paymentpage() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		SoftAssert softAssert = new SoftAssert();
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartComponents.CART_TITLE));

		driver.findElement(ShoppingCartComponents.CHECKOUT_BUTTON).click();
		Reporter.log("Checkout page displayed");
		Thread.sleep(5000);
		driver.findElement(CHECKOUT_EMAIL).sendKeys(CustomUtilities.properties.getProperty("checkoutemail"));

		softAssert.assertEquals(driver.findElement(SHIPPINGADD_TEXT).getText(), "Shipping address");
		entershippingdetails();
		Reporter.log("Shipping Address Details entered");

		//driver.findElement(CONTINUE_TO_SHIPPING_BUTTON).click();
		WebElement Continue_shipping=driver.findElement(CONTINUE_TO_SHIPPING_BUTTON);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Continue_shipping);

		Reporter.log("User is navigated to select shipping method");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SHIPPING_RADIO_BUTTON));
		jse.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		WebElement element = driver.findElement(CONTINUE_TO_PAYMENT_BUTTON);
		jse.executeScript("arguments[0].click();", element);
		Reporter.log("User is navigated to payment page");
		Thread.sleep(10000);

		sidebar();
		softAssert.assertTrue(driver.findElement(CONTACT_EMAIL).isDisplayed(), "Conatct email is not present");
		softAssert.assertTrue(driver.findElement(SHIP_ADDRESS).isDisplayed(), "Shipping address is not present");
		softAssert.assertTrue(driver.findElement(METHOD).isDisplayed(), "Shipping method is not present");
		//		WebDriverWait waits = new WebDriverWait(driver, 60);
		//		try {
		//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("_hjRemoteVarsFrame")));
		//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bx-close-xsvg")));
		//		driver.findElement(By.cssSelector(".bx-close-xsvg")).click();
		//		driver.switchTo().defaultContent();
		//		}
		//		catch (ElementNotVisibleException e)
		//		{
		//			System.out.println("Overlay not displayed");
		//		}
		//		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(CREDITCARD_OPTION));
		CheckBreadcrumbs();
		softAssert.assertTrue(driver.findElement(CHANGE_LINK_CONTACT).isDisplayed(), "Contact Change Link is not present");
		softAssert.assertTrue(driver.findElement(CHANGE_LINK_SHIP_TO).isDisplayed(), "Ship to Change Link is not present");
		softAssert.assertTrue(driver.findElement(CHANGE_LINK_METHOD).isDisplayed(), "Method Change Link is not present");
		softAssert.assertTrue(driver.findElement(CREDITCARD_OPTION).isDisplayed(), "Credit card option is not present");
		softAssert.assertTrue(driver.findElement(PAYPAL_OPTION).isDisplayed(), "Paypal option is not present");
		softAssert.assertTrue(driver.findElement(BILLING_TEXT).isDisplayed(), "Billing text is not present");
		softAssert.assertTrue(driver.findElement(HOWHEARD_TITLE).isDisplayed(), "How heard title is not present");
		softAssert.assertTrue(driver.findElement(HOWHEARD_SUBTITLE).isDisplayed(), "How heard subtitle is not present");
		softAssert.assertTrue(driver.findElement(HOWHEARD_DROPDOWN).isDisplayed(), "How heard dropdown is not present");
		softAssert.assertTrue(driver.findElement(COMPLETE_ORDER_BUTTON).isEnabled(), "Complete order button is not enabled");
		CheckPromoCodeApplication();
		Select dphowheard = new Select(driver.findElement(HOWHEARD_DROPDOWN));
		dphowheard.selectByValue("Online Search");
		Reporter.log("How heard values are displayed:: Clickable");
		softAssert.assertAll();	

	}


	public void entershippingdetails() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(FIRSTNAME_TEXTBOX));
		driver.findElement(FIRSTNAME_TEXTBOX).sendKeys("Vijeta");
		driver.findElement(LASTNAME_TEXTBOX).sendKeys("Juneja");
		driver.findElement(ADDRESS1_TEXTBOX).sendKeys("123Test Address B");
		Thread.sleep(2000);
		driver.findElement(ADDRESS2_TEXTBOX).sendKeys("8th floor");
		driver.findElement(CITY_TEXTBOX).sendKeys("New York");
		WebElement countrydp = driver.findElement(COUNTRY_DROPDOWN);
		Select country = new Select(countrydp);
		country.selectByValue("United States");

		WebElement statedp = driver.findElement(STATE_DROPDOWN);
		Select state = new Select(statedp);
		state.selectByValue("NY");


		driver.findElement(PINCODE_TEXTBOX).sendKeys("10001");
		Thread.sleep(2000);
		driver.findElement(PHONE_TEXTBOX).sendKeys("8889996667");
	}

	public void sidebar()
	{
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.findElement(ORDER_SUMMARY_SECTION).isDisplayed(), "ORDER SUMMARY SECTION is not displayed");
		softAssert.assertTrue(driver.findElement(DISCOUNT_CODE_TEXTBOX).isDisplayed(), "DISCOUNT CODE TEXTBOX  is not displayed");
		softAssert.assertTrue(driver.findElement(APPLY_DISCOUNT_BUTTON).isDisplayed(), "APPLY DISCOUNT BUTTON is not displayed");
		softAssert.assertTrue(driver.findElement(SUBTOTAL).isDisplayed(), "Subtotal  is not displayed");
		softAssert.assertTrue(driver.findElement(SHIPPING).isDisplayed(), "Shipping  is not displayed");
		softAssert.assertTrue(driver.findElement(TOTAL).isDisplayed(), "total is not displayed");
		softAssert.assertAll();

	}

	public void CheckPromoCodeApplication() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Promo_Code = "TJHUSTLE";
		driver.findElement(DISCOUNT_CODE_TEXTBOX).sendKeys(Promo_Code);
		driver.findElement(APPLY_DISCOUNT_BUTTON).click();
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(APPLIED_PROMO_CODE));
		softAssert.assertEquals(driver.findElement(APPLIED_PROMO_CODE).getText(), Promo_Code, "Wrong/Invalid Promo Code applied");
		driver.findElement(CANCEL_PROMO_CODE).click();
		Thread.sleep(8000);
		softAssert.assertAll();
		Reporter.log("Validated Promo Code application functionality");

	}
	public void AfterpayonCheckout() throws Exception
	{
		//product add to cart
		new HomePageComponents(driver).navigateToBraCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		//	new ProductDetailsPageComponents(driver).validatePage();
		new AddToCartComponents(driver).addToCart();
		//navigate to Checkout page
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.CHECKOUT_BUTTON));
		driver.findElement(FlyCartPageLocator.CHECKOUT_BUTTON).click();
		Thread.sleep(5000);
		driver.findElement(CHECKOUT_EMAIL).sendKeys(CustomUtilities.properties.getProperty("checkoutemail"));
		entershippingdetails();
		Thread.sleep(3000);
		driver.findElement(CONTINUE_TO_SHIPPING_BUTTON).click();
		Thread.sleep(5000);
		System.out.println("payment page");
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_TO_PAYMENT_BUTTON));
		WebElement element = driver.findElement(CONTINUE_TO_PAYMENT_BUTTON);
		if(!element.isDisplayed())
			throw new Exception("Continue to payment button is not displayed.");
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);

		//Check AfterPay message is display
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AFTERPAY_OPTION));
		if(!driver.findElement(AFTERPAY_OPTION).isDisplayed())
			throw new Exception("After pay option is not displayed on checkout page.");
		Reporter.log("After pay Message is displayed on Checkout page :: Displayed");

		//Check message with calculated installment and icon display
		price = driver.findElement(TOTAL).getText();
		String[] price1 = price.split("\\$");
		String price2 = price1[price1.length-1];
		System.out.println("Estimate total is: "+price);
		if(Float.parseFloat(price2)<35 || Float.parseFloat(price2)>1000 )
		{
			String Available_Between = driver.findElement(AVAILABLE_BETWEEN_TEXT).getText();
			String Amount = driver.findElement(AFTERPAY_INSTALLMENTS).getText();
			String expectedmessage= Available_Between+ " " +Amount;
			System.out.println("Message with availability is: "+expectedmessage);
			softAssert.assertEquals(expectedmessage, "available between $35 - $1000" , "Wrong afterpay message displayed for product price");
			Reporter.log("After pay message is correct On Checkout page :: Displayed and Correct");
			softAssert.assertTrue(driver.findElement(AFTERPAYLOGO_WITH_AVAILABLE).isDisplayed(), "Afterpay logo not present on Shopping cart.");	
			Reporter.log("After pay logo icon is displayed on Checkout Page :: Displayed");
		}
		else
		{

			installment =Float.parseFloat(price2)/4;
			String inst = String.format("%.2f",installment );
			String afterInstallmentText = driver.findElement(AFTERPAYLOGO_WITH_INSTALLMENT).getText();
			String expectedmessage = "4 interest-free installments of $" + inst +" "+ afterInstallmentText ; 
			String actualMessage = driver.findElement(AFTERPAYTEXT_WITH_INSTALLMENT).getText();
			System.out.println("Icon text is: "+afterInstallmentText);
			System.out.println("expected message is: " + expectedmessage);
			System.out.println("Actual message is: " +actualMessage);
			softAssert.assertEquals(actualMessage, expectedmessage , "Wrong afterpay message displayed for product price with installment.");
			Reporter.log("After pay message with calculated installment is correct on Checkout page :: Displayed and correct");
			softAssert.assertTrue(driver.findElement(AFTERPAYLOGO_WITH_INSTALLMENT).isDisplayed(), "Afterpay logo not present on Shopping cart");
			Reporter.log("After pay logo icon is displayed on Checkout page :: Displayed");
		}
		//	driver.findElement(By.cssSelector(".breadcrumb > li:nth-child(1) > a")).click();
		Thread.sleep(5000);
		softAssert.assertAll();
	}
	public void CheckAfterPayForAddressOtherThanUS() throws Exception
	{
		//add product to cart
		WebDriverWait wait = new WebDriverWait(driver, 30);
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();

		//Click on Checkout button in inline cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.CHECKOUT_BUTTON));
		driver.findElement(FlyCartPageLocator.CHECKOUT_BUTTON).click();
		Thread.sleep(5000);

		driver.findElement(CHECKOUT_EMAIL).sendKeys(CustomUtilities.properties.getProperty("checkoutemail"));
		entershippingAddressOtherThanUS();
		Thread.sleep(3000);

		//navigate to checkout page
		driver.findElement(CONTINUE_TO_SHIPPING_BUTTON).click();
		Thread.sleep(5000);
		System.out.println("payment page");
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_TO_PAYMENT_BUTTON));
		WebElement element = driver.findElement(CONTINUE_TO_PAYMENT_BUTTON);
		if(!element.isDisplayed())
			throw new Exception("Continue to payment button is not displayed.");
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);

		//Check after pay for address other than US
		try{
			System.out.println("Verifying for AfterPay Message .......");
			if(!driver.findElement(AFTERPAY_OPTION).getAttribute("style").equalsIgnoreCase("display: none;"))
				throw new Exception("AfterPay Message is displayed on Checkout page for address other than US.");
			Reporter.log("AfterPay Message is displayed on Checkout page for address other than US");
		}
		catch(Exception e){
			System.out.println("After Pay Message is not displayed on checkout page for address other than US.");
			Reporter.log("After Pay Message is not displayed on Checkout page for address other than US.");
		}
	}
	public void entershippingAddressOtherThanUS()
	{
		driver.findElement(ADDRESS1_TEXTBOX).sendKeys("123 Test Adress");
		driver.findElement(ADDRESS2_TEXTBOX).sendKeys("Suite1");
		driver.findElement(CITY_TEXTBOX).sendKeys("Perth");
		WebElement countrydp = driver.findElement(COUNTRY_DROPDOWN);
		Select country = new Select(countrydp);
		country.selectByValue("Australia");
		WebElement statedp = driver.findElement(STATE_DROPDOWN);
		Select state = new Select(statedp);
		state.selectByValue("WA");
		driver.findElement(PINCODE_TEXTBOX).sendKeys("6000");
		driver.findElement(PHONE_TEXTBOX).sendKeys("8889996667");
	}
	public void AfterPayMessageByModifyingPromoCode() throws Exception
	{
		AfterpayonCheckout();
		jse = (JavascriptExecutor)driver;
		Promo_Code = "TJHUSTLE";
		driver.findElement(DISCOUNT_CODE_TEXTBOX).sendKeys(Promo_Code);
		driver.findElement(APPLY_DISCOUNT_BUTTON).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(APPLIED_PROMO_CODE));
		softAssert.assertEquals(driver.findElement(APPLIED_PROMO_CODE).getText(), Promo_Code, "Wrong/Invalid Promo Code applied");
		WebElement cancel_code= driver.findElement(CANCEL_PROMO_CODE);
		CheckAfterPayInstallment();
		jse.executeScript("window.scrollTo(0, 0)");
		jse.executeScript("arguments[0].click();", cancel_code);
		Thread.sleep(8000);
		CheckAfterPayInstallment();
        Thread.sleep(5000);
		driver.findElement(BREADCRUMB_LINK_SHIPPING).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(CONTINUE_TO_PAYMENT_BUTTON));
		Thread.sleep(3000);
		driver.findElement(DISCOUNT_CODE_TEXTBOX).sendKeys(Promo_Code);
		driver.findElement(APPLY_DISCOUNT_BUTTON).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(APPLIED_PROMO_CODE));

		driver.findElement(CONTINUE_TO_PAYMENT_BUTTON).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(APPLIED_PROMO_CODE));
		cancel_code= driver.findElement(CANCEL_PROMO_CODE);
		jse.executeScript("arguments[0].click();", cancel_code);
		Thread.sleep(8000);
		CheckAfterPayInstallment();
		Reporter.log("AfterPay installment amount displayed :: Correct with promo code change");
		softAssert.assertAll();
	}

	public void CheckAfterPayInstallment() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		price = driver.findElement(TOTAL).getText();
		String[] price1 = price.split("\\$");
		String price2 = price1[price1.length-1];
		System.out.println("Estimate total is: "+price);
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(5000);
		if(Float.parseFloat(price2)<35 || Float.parseFloat(price2)>1000 )
		{
			String Available_Between = driver.findElement(AVAILABLE_BETWEEN_TEXT).getText();
			String Amount = driver.findElement(AFTERPAY_INSTALLMENTS).getText();
			String expectedmessage= Available_Between+ " " +Amount;
			System.out.println("Message with availability is: "+expectedmessage);
			softAssert.assertEquals(expectedmessage, "available between $35 - $1000" , "Wrong afterpay message displayed for product price");
			Reporter.log("After pay message is correct On Checkout page :: Displayed and Correct");
			softAssert.assertTrue(driver.findElement(AFTERPAYLOGO_WITH_AVAILABLE).isDisplayed(), "Afterpay logo not present on Shopping cart.");	
			Reporter.log("After pay logo icon is displayed on Checkout Page :: Displayed");
		}
		else
		{
			installment =Float.parseFloat(price2)/4;
			String inst = String.format("%.2f",installment );
			String afterInstallmentText = driver.findElement(AFTERPAYLOGO_WITH_INSTALLMENT).getText();
			String expectedmessage = "4 interest-free installments of $" + inst +" "+ afterInstallmentText ; 
			String actualMessage = driver.findElement(AFTERPAYTEXT_WITH_INSTALLMENT).getText();
			System.out.println("Icon text is: "+afterInstallmentText);
			System.out.println("expected message is: " + expectedmessage);
			System.out.println("Actual message is: " +actualMessage);
			softAssert.assertEquals(actualMessage, expectedmessage , "Wrong afterpay message displayed for product price with installment.");
			Reporter.log("After pay message with calculated installment is correct on Checkout page :: Displayed and correct");
			softAssert.assertTrue(driver.findElement(AFTERPAYLOGO_WITH_INSTALLMENT).isDisplayed(), "Afterpay logo not present on Shopping cart");
			Reporter.log("After pay logo icon is displayed on Checkout page :: Displayed");
		}
		Thread.sleep(5000);
		softAssert.assertAll();
	}


}

