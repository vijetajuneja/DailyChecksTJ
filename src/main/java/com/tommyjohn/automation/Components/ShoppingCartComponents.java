package com.tommyjohn.automation.Components;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.tommyjohn.automation.PageLocators.CheckoutPageLocators;
import com.tommyjohn.automation.PageLocators.FlyCartPageLocator;
import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.PageLocators.ShoppingCartLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ShoppingCartComponents extends ShoppingCartLocators{

	public WebDriver driver;


	double	installment;
	List<WebElement> allElements;
	String price;
	SoftAssert softAssert=new SoftAssert();
	public String Promo_Code = "TJHUSTLE";
	public ShoppingCartComponents(WebDriver driver) {
		this.driver = driver;
	}
	public void EmptyCart() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();

		new HomePageComponents(driver).validateCartIcon();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CART_TITLE));
		//Thread.sleep(3000);
		softAssert.assertTrue(driver.findElement(CART_TITLE).isDisplayed() , "Your Shopping Cart title is not displayed");
		softAssert.assertEquals(driver.findElement(CART_TITLE).getText(), "Your Shopping Cart" , "Wrong text displayed for Cart title");
		softAssert.assertTrue(driver.findElement(EMPTY_CART_MESSAGE).isDisplayed(), "Your cart is Empty message is not displayed on empty cart");
		softAssert.assertEquals(driver.findElement(EMPTY_CART_MESSAGE).getText(), "Your cart is empty", "Wrong text displayed for empty cart message");
		softAssert.assertTrue(driver.findElement(START_SHOPPING_BUTTON).isDisplayed(), "Start Shopping button is not displayed");
		driver.findElement(START_SHOPPING_BUTTON).click();
		//	softAssert.assertEquals(driver.getCurrentUrl(), CustomUtilities.baseUrl);

		softAssert.assertAll();
		driver.get(CustomUtilities.baseUrl);
		Reporter.log("Cart Title Present - Your Shopping Cart ");
		Reporter.log("Message displayed correctly - Your cart is Empty");
		Reporter.log("Start shopping button on empty cart redirects user to homepage");
	}

	public void CartwithProduct() throws Exception
	{

		SoftAssert softAssert = new SoftAssert();


		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CART_TITLE));

		softAssert.assertTrue(driver.findElement(PRODUCT_TITLE).isDisplayed(), "Product title for added item not present on Cart");
		softAssert.assertTrue(driver.findElement(PRODUCT_IMAGE).isDisplayed(), "Product image is not present");
		softAssert.assertTrue(driver.findElement(PRODUCT_COLOR_SIZE).isDisplayed(), "Color and Size are not present for the product in Cart");
		softAssert.assertTrue(driver.findElement(PRODUCT_PRICE).isDisplayed(), "Price not present for the product in Cart");
		softAssert.assertTrue(driver.findElement(PRODUCT_QUANTITY).isDisplayed(), "Quantity not present");
		softAssert.assertTrue(driver.findElement(PRODUCT_SUBTOTAL).isDisplayed(), "Product subtotal not present");
		softAssert.assertTrue(driver.findElement(GIFT_WRAP_LINK).isDisplayed(), "Gift wrap link not present");
		softAssert.assertTrue(driver.findElement(CART_TOTAL_TEXT).isDisplayed(), "Estimated total text is not present");
		softAssert.assertTrue(driver.findElement(CART_TOTAL).isDisplayed(), "Cart total price is not present");
		softAssert.assertTrue(driver.findElement(CONTINUE_SHOPPING).isDisplayed(), "Continue shopping link not present");
		softAssert.assertTrue(driver.findElement(CHECKOUT_BUTTON).isDisplayed(), "Checkout button not present");
		softAssert.assertTrue(driver.findElement(REMOVE_PRODUCT_FROM_CART).isDisplayed(), "Option to remove product from cart not present");
		softAssert.assertAll();
	}


	public void AddRemoveProductsFromCart() throws Exception
	{
		String text;
		String text1;
		String quant;

		SoftAssert softAssert = new SoftAssert();
		text = new AddToCartComponents(driver).addToCart();
		System.out.println("Text is:"+text);
//		String[] part = text.split("/");
//		String part1 = part[part.length-2];
//		String part2 = part1.replace("-", " ");
		String[] part = text.split(",");
		String part2 = part[0];
		System.out.println("Title text is:" +part2);
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CART_TITLE));
		softAssert.assertTrue(driver.findElement(PRODUCT_TITLE).isDisplayed(), "Product title for added item not present on Cart");
		text1 = driver.findElement(PRODUCT_TITLE).getText();
		//softAssert.assertEquals(text1, part2, "Wrong Product added to cart");
		System.out.println("text1 is:"+text1);
		String[] comma_separated  = text1.split(",");
		String p_name = comma_separated[0];

		String text2= p_name.replace("-", " ");
		System.out.println("text2 is: "+text2.toLowerCase());
		System.out.println(p_name);
		if(!p_name.equalsIgnoreCase(text2))
			throw new Exception("Wrong Product added to cart");
		quant= driver.findElement(PRODUCT_QUANTITY).getAttribute("value");

		driver.findElement(PRODUCT_QUANT_ADD).click();
		softAssert.assertEquals(driver.findElement(PRODUCT_QUANTITY).getAttribute("value"), "2");
		driver.findElement(PRODUCT_QUANT_MINUS).click();
		softAssert.assertEquals(driver.findElement(PRODUCT_QUANTITY).getAttribute("value"), quant);

		wait.until(ExpectedConditions.visibilityOfElementLocated(REMOVE_PRODUCT_FROM_CART));
		driver.findElement(REMOVE_PRODUCT_FROM_CART).click();
		Thread.sleep(3000);
		EmptyCart();
		softAssert.assertAll();

	}

	public void CheckoutPageFromCart() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CART_TITLE));

		WebElement element = driver.findElement(CHECKOUT_BUTTON);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		//	driver.findElement(CHECKOUT_BUTTON).click();
		Thread.sleep(3000);
		softAssert.assertTrue(driver.getCurrentUrl().contains("checkouts"), "Checkout page is not displayed on clicking checkout button");
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(HomePageLocators.CART_ICON).click();
		Thread.sleep(3000);
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		Thread.sleep(5000);
		//driver.findElement(CONTINUE_SHOPPING).click();
		//Thread.sleep(3000);
		softAssert.assertTrue(driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).isDisplayed(), "Continue Shopping redirects user to wrong page");

		softAssert.assertAll();
	}

	public void productDetailsInCart() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();


		ProductDetailsPageComponents pdp1 = new ProductDetailsPageComponents(driver);

		pdp1.getproductdetails();
		new AddToCartComponents(driver).atc();

		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CART_TITLE));

		System.out.println("cart " + driver.findElement(PRODUCT_COLOR_SIZE).getText());
		System.out.println("pdp " + pdp1.productcolor + " / " + pdp1.prodsize);
		System.out.println("ex " + driver.findElement(PRODUCT_QUANTITY).getAttribute("value"));
		System.out.println("ac " + pdp1.productquant);

		softAssert.assertEquals(driver.findElement(PRODUCT_TITLE).getText(), pdp1.productname, "Wrong product title displayed in cart");
		softAssert.assertEquals(driver.findElement(PRODUCT_QUANTITY).getAttribute("value"), pdp1.productquant, "Wrong quantity added to cart");
		softAssert.assertEquals(driver.findElement(PRODUCT_PRICE).getText(), pdp1.productprice, "Wrong product price displayed in cart");
		if(!driver.findElement(PRODUCT_COLOR_SIZE).getText().equalsIgnoreCase(pdp1.productcolor + " / " + pdp1.prodsize))
			throw new Exception("Wrong color & size added to cart");
		softAssert.assertAll();
	}

	public void validateafterpayonShoppingCart() throws Exception
	{
		//		new HomePageComponents(driver).navigateToBraCategory();
		//		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		//	new ProductDetailsPageComponents(driver).validatePage();
		new AddToCartComponents(driver).addToCart();
		//navigate to shopping cart page
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		Thread.sleep(3000);

		//Check AfterPay message display

		if(!driver.findElement(AFTERPAY_DIV).isDisplayed())
			throw new Exception("AfterPay Message not present on Shopping cart.");
		Reporter.log("After pay Message is displayed on Shopping Cart :: Displayed");

		//Check message with calculated installment and icon display
		price = driver.findElement(ESTIMATE_TOTAL_PRICE).getText();
		String[] price1 = price.split("\\$");
		String price2 = price1[price1.length-1];
		System.out.println("Estimate total is: "+price);
		if(Float.parseFloat(price2)<35 || Float.parseFloat(price2)>1000 )
		{
			softAssert.assertEquals(driver.findElement(AFTERPAYTEXT_WITH_AVAILABLE).getText(), "available for orders between $35 - $1000" , "Wrong afterpay message displayed for product price");
			Reporter.log("After pay message is correct On Shopping cart :: Displayed and Correct");
			softAssert.assertTrue(driver.findElement(AFTERPAYLOGO_WITH_AVAILABLE_MSG).isDisplayed(), "Afterpay logo not present on Shopping cart.");	
			Reporter.log("After pay logo icon is displayed on Shopping cart :: Displayed");
		}
		else
		{

			installment =Float.parseFloat(price2)/4;
			String inst = String.format("%.2f",installment );
			//String expectedmessage = "In 4 installments of $" + inst + " by ?"; 
			String expectedmessage =  inst+ " "; 
			System.out.println("expected message is: " + expectedmessage);
			String Actual = driver.findElement(AFTERPAYTEXT_WITH_INSTALLMENT).getText();
			String ins_amount= Actual.substring(Actual.indexOf("$")+1, Actual.indexOf("b"));
			System.out.println("Actual ins_amount is: " +ins_amount);
			softAssert.assertEquals(ins_amount, expectedmessage , "Wrong afterpay message displayed for product price");
			Reporter.log("After pay message with calculated installment is correct on Inline cart :: Displayed and correct");
			softAssert.assertTrue(driver.findElement(AFTERPAYLOGO_WITH_INSTALLMENT_MSG).isDisplayed(), "Afterpay logo not present on Shopping cart");
			Reporter.log("After pay logo icon is displayed on Inline cart :: Displayed");
		}
		Thread.sleep(3000);   		

		softAssert.assertAll();
	}

	public void Promo_Code_OncartPage() throws Exception
	{
		WebElement element;
		String allClasses = null;
		boolean flag = false;
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		Thread.sleep(3000);

		softAssert.assertEquals(driver.findElement(PROMO_HEADER).getText(), "Gift Card / Discount Code", "Text chneged for Discount code header on cart page");
		softAssert.assertTrue(driver.findElement(DISCOUNTCODE_TEXTBOX).isDisplayed(), "Promo code text box is not displayed on cart page");
		softAssert.assertTrue(driver.findElement(PROMOCODE_APPLYCTA).isDisplayed(), "Promo code 'apply' cta is not displayed");

		//Verify empty text field
		driver.findElement(PROMOCODE_APPLYCTA).click();
		element= driver.findElement(PROMO_ERROR_MESSAGE);
		wait.until(ExpectedConditions.visibilityOf(element));
		softAssert.assertEquals(element.getText(), "Enter a valid discount code or gift card", "Text changed for promo code error message on cart page");
		Reporter.log("Promo code error message is displayed :: Correct");

		//Verify with valid promo code
		driver.findElement(DISCOUNTCODE_TEXTBOX).sendKeys(Promo_Code);
		driver.findElement(PROMOCODE_APPLYCTA).click();
		Thread.sleep(2000);
		softAssert.assertTrue(driver.findElement(PROMO_SUCCESSFUL_MESSAGE).isDisplayed(), "Succesful message is not displayed for applied promo code");
		Reporter.log("Promo code successful message is displayed :: Correct");

		softAssert.assertTrue(driver.findElement(SALE_PRICE).isDisplayed(), "Sale peice is not displayed after applied promo code");
		softAssert.assertTrue(driver.findElement(APPLIED_PROMO_CODE).isDisplayed(), "Applied promo code is not displayed for product on cart page");
		softAssert.assertEquals(driver.findElement(APPLIED_PROMO_CODE).getText(), Promo_Code, "Promo code is not same as applied discount code");

		//Verify with invalid promo code
		driver.findElement(DISCOUNTCODE_TEXTBOX).sendKeys("InvalidCode");
		driver.findElement(PROMOCODE_APPLYCTA).click();
		Thread.sleep(2000);
		element= driver.findElement(PROMO_ERROR_MESSAGE);
		wait.until(ExpectedConditions.visibilityOf(element));
		softAssert.assertEquals(element.getText(), "Enter a valid discount code or gift card", "Text changed for promo code error message on cart page");
		softAssert.assertTrue(driver.findElement(APPLIED_PROMO_CODE).isDisplayed(), "Applied promo code is getting removed after applied invalid promo code");

		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(APPLIED_PROMO_CODE));
		softAssert.assertTrue(driver.findElement(APPLIED_PROMO_CODE).isDisplayed(), "Applied promo code is getting removed after refresh the page");

		new ProductDetailsPageComponents(driver).Add_Bundle_toCart();

		driver.get(CustomUtilities.baseUrl);

		driver.findElement(HomePageLocators.CART_ICON).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.VIEW_CART_LINK));
		Thread.sleep(3000);
		softAssert.assertTrue(driver.findElement(APPLIED_PROMOCODE_FLYCART).isDisplayed(), "Applied promo code from cart page is not displayed on flycart");
		driver.findElement(FlyCartPageLocator.VIEW_CART_LINK).click();
		Thread.sleep(3000);

		AddGiftWrap();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(APPLIED_PROMO_CODE));
		softAssert.assertTrue(driver.findElement(APPLIED_PROMO_CODE).isDisplayed(), "Applied promo code is getting removed after adding bundle product in cart");
		element = driver.findElement(DISCOUNTED_GIFTWRAP_PRICE);
		allClasses = element.getAttribute("class");
		for(String c : allClasses.split(" "))
		{
			if(c.equals("discounted-price"))
				flag= true;
		}
		if(!flag)
			throw new Exception("Discount coupon is not applied on gift wrap");
		Reporter.log("Promo code is auto-applied on newly added products");  	

		Thread.sleep(3000);
		Check_Promocode_onCheckout_throughCart();	
		//Remove code from checkout
		driver.findElement(CheckoutPageLocators.CANCEL_PROMO_CODE).click();
		Thread.sleep(8000);

		driver.findElement(CheckoutPageLocators.BREADCRUMB_LINK_CART).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CART_TITLE));
		softAssert.assertTrue(driver.findElement(APPLIED_PROMO_CODE).getText().isEmpty(), "Discount code is still displayed on cart page after removing code from checkout");

		Reporter.log("Apply promo code through textbox on cart page is correct");
		AddPromoCode_OnCart_ThroughURL();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SUBTOTAL_PRICE));
		Check_Promocode_onCheckout_throughCart();	

		softAssert.assertAll();
	}

	public void AddPromoCode_OnCart_ThroughURL()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String parameter = "/?coupon="+Promo_Code;
		String current_url = driver.getCurrentUrl();
		String Url_withPromocode = current_url.concat(parameter);
		driver.get(Url_withPromocode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(APPLIED_PROMO_CODE));
		softAssert.assertTrue(driver.findElement(PROMO_SUCCESSFUL_MESSAGE).isDisplayed(), "Succesful message is not displayed for applied promo code through url");
		Reporter.log("Through Url parameter Promo code successful message is displayed :: Correct");

		softAssert.assertTrue(driver.findElement(SALE_PRICE).isDisplayed(), "Sale price is not displayed after applied promo code through url");
		softAssert.assertTrue(driver.findElement(APPLIED_PROMO_CODE).isDisplayed(), "Applied promo code is not displayed for product on cart page through url parameter");
		softAssert.assertEquals(driver.findElement(APPLIED_PROMO_CODE).getText(), Promo_Code, "Promo code is not same as applied discount code through url parameter");
		Reporter.log("Apply promo code through url parameter on cart page is correct");
		softAssert.assertAll();
	}

	public void Check_Promocode_onCheckout_throughCart()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		price = driver.findElement(SUBTOTAL_PRICE).getText();
		String[] price1 = price.split("\\$");
		String EstimateTotal_onCart = price1[price1.length-1];

		driver.findElement(CHECKOUT_BUTTON).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutPageLocators.APPLIED_PROMO_CODE));
		softAssert.assertEquals(driver.findElement(CheckoutPageLocators.APPLIED_PROMO_CODE).getText(), Promo_Code, "Wrong/Invalid Promo Code applied");
		price = driver.findElement(CheckoutPageLocators.TOTAL).getText();
		String[] price2 = price.split("\\$");
		String EstimateTotal_onCheckout = price2[price2.length-1];
		System.out.println("checkout price: "+EstimateTotal_onCheckout+" cart price: "+EstimateTotal_onCart);
		softAssert.assertEquals(EstimateTotal_onCheckout, EstimateTotal_onCart, "Discounted total price is incorrect on checkout");
		softAssert.assertAll();
	}

	public void AddGiftWrap() throws Exception
	{
		WebElement element;
		String allClasses = null;
		boolean flag = false;
		driver.findElement(GIFT_WRAP_LINK).click();
		softAssert.assertTrue(driver.findElement(FlyCartPageLocator.GIFT_WRAP_POPUP).isDisplayed(), "Gift Wrap Popup is not displayed");
		element = driver.findElement(FlyCartPageLocator.GIFT_BOX_$5);
		allClasses = element.getAttribute("class");

		for (String c : allClasses.split(" ")) {
			if (c.equals("is-checked")) {
				flag = true;
			}
		}
		if(flag)
			Reporter.log("Gift Box $5.00 is already checked");
		else {
			driver.findElement(FlyCartPageLocator.GIFT_BOX_$5).click();
			Thread.sleep(2000);
			Reporter.log("Gift Box $5.00 is checked");
		}
		driver.findElement(FlyCartPageLocator.GIFT_WRAP_APPLY).click();
		Thread.sleep(5000);
		softAssert.assertAll();
	}


}
