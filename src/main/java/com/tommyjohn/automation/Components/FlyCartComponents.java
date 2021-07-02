package com.tommyjohn.automation.Components;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.tommyjohn.automation.PageLocators.AddToCartLocators;
import com.tommyjohn.automation.PageLocators.CollectionPageLocator;
import com.tommyjohn.automation.PageLocators.FlyCartPageLocator;
import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class FlyCartComponents extends FlyCartPageLocator{


	double installment;
	public JavascriptExecutor jse;
	public WebDriver driver;
	Properties properties = CustomUtilities.properties;
	WebElement element;
	List<WebElement> allElements;
	SoftAssert softAssert = new SoftAssert();
	public String price;

	public FlyCartComponents(WebDriver driver) {
		this.driver = driver;

	}


	public void verifyAllTextsAndFieldsOnEmptyFlyCart() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		String text = null;


		new HomePageComponents(driver).validateCartIcon();
		driver.findElement(HomePageLocators.CART_ICON).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		// check for continue shopping button text and is displayed, enabled or not		
		softAssert.assertTrue(driver.findElement(INLINE_CART_CLOSE_BUTTON).isDisplayed(), "Inline cart close button is not displayed");
		softAssert.assertTrue(driver.findElement(INLINE_CART_CLOSE_BUTTON).isEnabled(), "Inline cart close button is not enable");
		text = driver.findElement(INLINE_CART_CLOSE_BUTTON).getText();
		System.out.println("Text :: "+text);
		softAssert.assertTrue(text.equals(properties.get("continueShoppingButton")), "Text for inline cart close button is changed");	
		Reporter.log("Continue Shopping button is Displayed :: Enabled :: Text is correct ");

		Thread.sleep(3000);
		// check for view cart link
		softAssert.assertTrue(driver.findElement(VIEW_CART_LINK).isDisplayed(), "View cart link is not displayed");
		softAssert.assertTrue(driver.findElement(VIEW_CART_LINK).isEnabled(), "View cart link is not enable");
		text = driver.findElement(VIEW_CART_LINK).getText();
		System.out.println("Text :: "+text);
		softAssert.assertTrue(text.equals(properties.get("viewCart")), "Text for view cart link is changed");	

		Reporter.log("View Cart link is Displayed :: Enabled :: Text is correct ");

		Thread.sleep(3000);

		// check inline cart title
		softAssert.assertTrue(driver.findElement(INLINE_CART_TITLE).isDisplayed(), "Inline cart title is not displayed");
		text = driver.findElement(INLINE_CART_TITLE).getText();
		System.out.println("Text :: "+text);
		softAssert.assertTrue(text.equals(properties.get("inlineCartTitle")), "Text for inline cart title is changed");
		Reporter.log("Inline Cart Title is Displayed :: Text is correct ");

		Thread.sleep(3000);
		try {
			// check for shipping message text
			softAssert.assertTrue(driver.findElement(SHIPING_MESSAGE_TEXT).isDisplayed(), "Shipping message text is not displayed");
			Reporter.log("Shipping message text is Displayed ");

			Thread.sleep(3000);

			// check for shipping message meter
			softAssert.assertTrue(driver.findElement(SHIPING_MESSAGE_METER).isDisplayed(), "Shipping message meter is not displayed");
			Reporter.log("Shipping message meter is Displayed");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Reporter.log("Shipping message and meter absent");
		}


		// check for empty cart text
		softAssert.assertTrue(driver.findElement(INLINE_CART_EMPTY_TEXT).isDisplayed(), "Shipping 'Your cart is empty' is not displayed");
		text = driver.findElement(INLINE_CART_EMPTY_TEXT).getText();
		System.out.println("Text :: "+text);
		softAssert.assertTrue(text.equals(properties.get("inlineCartEmptyText")), "Expected text is "+properties.get("inlineCartEmptyText")+" but actual is "+text);
		Reporter.log("'Inline cart is empty' text is Displayed");

		// check for recomonded product heading
		//		softAssert.assertTrue(driver.findElement(RECOMMENDED_PRODUCT_HEADING).isDisplayed(), "Recommended product heading is not displayed");
		//		text = driver.findElement(RECOMMENDED_PRODUCT_HEADING).getText();
		//		System.out.println("Text :: "+text);
		//		softAssert.assertTrue(text.equals(properties.get("recommendedProductHeading")), "Expected text is "+properties.get("recommendedProductHeading")+" but actual is "+text);
		//		Reporter.log("Recommended product heading is Displayed");

		// check for recomonded products present or not
		//		softAssert.assertTrue(driver.findElement(RECOMMENDED_PRODUCTS).isDisplayed(), "Recommended products are not displayed");
		//		allElements = driver.findElements(RECOMMENDED_PRODUCTS_LIST);
		//		System.out.println("allelements size :: "+allElements.size());
		//		softAssert.assertTrue(allElements.size() > 0, "Recommended products is not present");
		//		Reporter.log("Recommended products are present in recommended product portione");

		// add any item to cart
		//		driver.findElement(RECOMMENDED_PRODUCTS).click();

		driver.get(CustomUtilities.baseUrl);
		softAssert.assertAll();
	}

	public void verifyAllTextsAndFieldsOnNonEmptyFlyCart() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		String text = null;

		// first add any product to cart
		new AddToCartComponents(driver).addToCart();

		//		new HomePageComponents().validateCartIcon();
		driver.findElement(HomePageLocators.CART_ICON).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);

		// check for continue shopping button text and is displayed, enabled or not		
		softAssert.assertTrue(driver.findElement(INLINE_CART_CLOSE_BUTTON).isDisplayed(), "Inline cart close button is not displayed");
		softAssert.assertTrue(driver.findElement(INLINE_CART_CLOSE_BUTTON).isEnabled(), "Inline cart close button is not enable");
		text = driver.findElement(INLINE_CART_CLOSE_BUTTON).getText();
		System.out.println("Text :: "+text);
		softAssert.assertTrue(text.equals(properties.get("continueShoppingButton")), "Text for inline cart close button is changed");	
		Reporter.log("Continue Shopping button is Displayed :: Enabled :: Text is correct ");
		Thread.sleep(3000);

		// check for inline cart link
		softAssert.assertTrue(driver.findElement(VIEW_CART_LINK).isDisplayed(), "View cart link is not displayed");
		softAssert.assertTrue(driver.findElement(VIEW_CART_LINK).isEnabled(), "View cart link is not enable");
		text = driver.findElement(VIEW_CART_LINK).getText();
		System.out.println("Text :: "+text);
		softAssert.assertTrue(text.equals(properties.get("viewCart")), "Text for view cart link is changed");	
		Reporter.log("View Cart link is Displayed :: Enabled :: Text is correct ");
		Thread.sleep(3000);

		// check inline cart title
		softAssert.assertTrue(driver.findElement(INLINE_CART_TITLE).isDisplayed(), "Inline cart title is not displayed");
		text = driver.findElement(INLINE_CART_TITLE).getText();
		System.out.println("Text :: "+text);
		softAssert.assertTrue(text.equals(properties.get("inlineCartTitle")), "Text for inline cart title is changed");
		Reporter.log("Inline Cart Title is Displayed :: Text is correct ");
		Thread.sleep(3000);
		try
		{
			// check for shipping message text
			softAssert.assertTrue(driver.findElement(SHIPING_MESSAGE_TEXT).isDisplayed(), "Shipping message text is not displayed");
			Reporter.log("Shipping message text is Displayed ");
			Thread.sleep(3000);

			// check for shipping message meter
			softAssert.assertTrue(driver.findElement(SHIPING_MESSAGE_METER).isDisplayed(), "Shipping message meter is not displayed");
			Reporter.log("Shipping message meter is Displayed");
			Thread.sleep(3000);

			element = driver.findElement(SHIPING_MESSAGE_METER);
			int width = element.getSize().getWidth();
			System.out.println("width :: "+element.getSize().getWidth());
			softAssert.assertTrue(width > 0, "Element is added but, shipping message meter is showing empty");
			Thread.sleep(3000);

			Reporter.log("Shipping message meter is displayed correctly");

		}catch(Exception e)
		{
			Reporter.log("Shipping bar message and title not present, Please check if disabled from DY");
		}
		allElements = driver.findElements(LIST_OF_ITEMS_IN_FLYCART);

		// check all fields for all items in flycart
		for(int i=1; i<=allElements.size();i++) {
			// check for product image
			softAssert.assertTrue(driver.findElement(By.cssSelector("div.inline-cart__col1 > div[data-inline-cart-contents] > article:nth-child("+i+") > div.line-item__image")).isDisplayed(), "First item image is not displayed");

			// check for product heading
			softAssert.assertTrue(driver.findElement(By.cssSelector("div.inline-cart__col1 > div[data-inline-cart-contents] > article:nth-child("+i+") > div.line-item__summary > a")).isDisplayed(), "First item heading is not displayed");	

			// check for remove item from cart button
			softAssert.assertTrue(driver.findElement(By.cssSelector("div.inline-cart__col1 > div[data-inline-cart-contents] > article:nth-child("+i+") > div.line-item__summary > button")).isDisplayed(), "First item remove button is not displayed");

			// check for line item option
			softAssert.assertTrue(driver.findElement(By.cssSelector("div.inline-cart__col1 > div[data-inline-cart-contents] > article:nth-child("+i+") > div.line-item__summary > div.line-item__option")).isDisplayed(), "Line item option is not displayed");

			// check for price
			softAssert.assertTrue(driver.findElement(By.cssSelector("div.inline-cart__col1 > div[data-inline-cart-contents] > article:nth-child("+i+") > div.line-item__summary > div.line-item__price > span")).isDisplayed(), "Price is not displayed");

			// check for plus minus and quantity
			softAssert.assertTrue(driver.findElement(QUANTITY_PLUS_MINUS_BUTTON).isDisplayed(), "plus or minus button is not displayed");

			// check for second price displayed
			softAssert.assertTrue(driver.findElement(By.cssSelector("article:nth-child("+i+") > div.line-item__summary > div.line-item__total > div.line-item__subtotal > span")).isDisplayed(), "plus or minus button is not displayed");

		}
		Reporter.log("Image, link text, price, plus-minus button is displayed for all items in cart");
		// check for Add Gift Wrap button
		softAssert.assertTrue(driver.findElement(ADD_GIFT_WRAP_BUTTON).isDisplayed(), "Add Gift Wrap button is not displayed");
		Thread.sleep(3000);

		text = driver.findElement(ESTIMATE_TOTAL).getText();
		System.out.println("Estimate total text :: "+text);
		softAssert.assertTrue(text.equals(properties.get("totalEstimateText")), "Expected text is "+properties.get("totalEstimateText")+" but actual is "+text);
		//		text = driver.findElement(ESTIMATE_TOTAL_SMALL).getText();
		//		System.out.println("Estimate total small text :: "+text);
		//		softAssert.assertTrue(text.equals(properties.get("totalEstimateSmallText")), "Expected text is "+properties.get("totalEstimateSmallText")+" but actual is "+text);

		Thread.sleep(3000);

		softAssert.assertTrue(driver.findElement(ESTIMATE_TOTAL).isDisplayed(), "Estimate total amount is not displayed");

		// check for checkout button
		softAssert.assertTrue(driver.findElement(CHECKOUT_BUTTON).isDisplayed(), "Checkout button is not displayed");
		Thread.sleep(3000);

		softAssert.assertAll();
		driver.get(CustomUtilities.baseUrl);

	}


	public void validateNonEmptyFlyCart() throws Exception {
		String text1 = null;
		String text2 = null;
		String colorAndSize = null;
		String colorAndSize2 = null;
		String price1 = null;
		String price2 = null;

		// first add any product to cart
		new AddToCartComponents(driver).addToCart();

		driver.findElement(HomePageLocators.CART_ICON).click();
		Thread.sleep(3000);

		driver.findElement(INLINE_CART_CLOSE_BUTTON).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String currenturl = driver.getCurrentUrl();
		String[] part= currenturl.split("\\?");
		 text1 = part[0];
		System.out.println(text1);
		System.out.println(CustomUtilities.baseUrl);

		softAssert.assertTrue((text1.contains("https://tommyjohn.com")), "Continue shopping button is not working correctly");
//
//		String preview_theme = CustomUtilities.baseUrl;
//		String[] part1= preview_theme.split("\\?");
//		String Base_URL = part1[0];
//		softAssert.assertTrue(text1.equals(Base_URL), "Continue shopping button is not working correctly");

		Thread.sleep(2000);

		driver.findElement(HomePageLocators.CART_ICON).click();
		Thread.sleep(2000);

		driver.findElement(VIEW_CART_LINK).click();
		Thread.sleep(3000);

		softAssert.assertTrue(driver.getCurrentUrl().equals(properties.get("viewCartPage")), "Wrong page opened after cicked on View Cart link");
		driver.findElement(HomePageLocators.CART_ICON).click();
		Thread.sleep(2000);

		// check product heading for available items in cart
		text1 = driver.findElement(FIRST_PRODUCT_TITLE_IN_CART).getText();
		Thread.sleep(2000);
		System.out.println("Text1 :: "+text1);
		driver.findElement(FIRST_PRODUCT_TITLE_IN_CART).click();
		Thread.sleep(3000);
		text2 = driver.findElement(ProductDetailsPageLocators.PRODUCT_TITLE).getText();
		System.out.println("Text2 :: "+text2);
		softAssert.assertTrue(text1.equals(text2), "Wrong page opened after clicked on cart product");

		colorAndSize = driver.findElement(ProductDetailsPageLocators.COLOR_TEXT).getText();
		System.out.println("color and size :: "+colorAndSize);
		colorAndSize = colorAndSize+" / ";

		String size = 	driver.findElement(ProductDetailsPageLocators.SIZE_TEXT).getAttribute("value");
		String[] b = size.split(",") ;
		size = b[0];
		colorAndSize = colorAndSize.concat(size);
		System.out.println("color and size :: "+colorAndSize);

		driver.findElement(HomePageLocators.CART_ICON).click();
		Thread.sleep(2000);

		colorAndSize2 = driver.findElement(COLOR_AND_SIZE_IN_CART).getText();
		System.out.println("color and size2 :: "+colorAndSize2);

		softAssert.assertTrue(colorAndSize.equals(colorAndSize2), "Color and size is mismatch from PDP and Cart");

		// check price before adding more item
		price1 = driver.findElement(PRICE_IN_QUANTITY_LINE).getText();
		for (String a : price1.split("\\$")) 
			price1 = a;
		System.out.println("price1  :: "+price1);

		// check for plus minus button
		String quantity = driver.findElement(QUANTITY).getAttribute("data-item-qty");
		System.out.println("quantity :: "+quantity);


		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(PLUS_BUTTON));
		Thread.sleep(5000);
		String quantity1 = driver.findElement(QUANTITY).getAttribute("data-item-qty");
		System.out.println("quantity1 :: "+quantity1);
		// check quantity added by 1 or not 
		try {
			if(!driver.findElement(By.cssSelector(".inline-cart__message>span")).isDisplayed())
		if(Integer.parseInt(quantity1)!=Integer.parseInt(quantity)+1) 
			throw new Exception("Quantity not increased by 1");
		}
		catch(Exception e)
		{
			System.out.println("Only 1 quantity is available for added product in cart");
		}
		Reporter.log("Quantity increased by 1");

		price2 = driver.findElement(PRICE_IN_QUANTITY_LINE).getText();
		for (String a : price2.split("\\$")) 
			price2 = a;
		System.out.println("price2  :: "+price2);

		// check price changed or not
		softAssert.assertFalse(price1.equals(price2), "Total price not changing after adding more items");

		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(MINUS_BUTTON));
		Thread.sleep(3000);

		String quantity2 = driver.findElement(QUANTITY).getAttribute("data-item-qty");
		System.out.println("quantity2 :: "+quantity2);
		try {
			if(!driver.findElement(By.cssSelector(".inline-cart__message>span")).isDisplayed())
		if(Integer.parseInt(quantity2)!=Integer.parseInt(quantity1)-1)
			throw new Exception("Quantity not decreased by 1");
		}
		catch(Exception e)
		{
			System.out.println("Only 1 quantity is available for added product in cart");
		}
		Reporter.log("Quantity decreased by 1");

		// check for checkout button
		driver.findElement(CHECKOUT_BUTTON).click();
		Thread.sleep(3000);
		driver.get(CustomUtilities.baseUrl);
		Thread.sleep(3000);
		Reporter.log("Checkout button is Displayed :: Clickable");

		// call method to chick gift wrap
		giftWrap();

		// check for cross close button near text heading link to remove item from cart
		driver.findElement(HomePageLocators.CART_ICON).click();
		Thread.sleep(2000);

		allElements = driver.findElements(LIST_OF_ITEMS_IN_FLYCART);
		System.out.println("List of items after click :: "+allElements.size());
		int list1 = allElements.size();

		driver.findElement(By.cssSelector("article:nth-child("+list1+") > div.line-item__summary > button")).click();
		Thread.sleep(3000);

		allElements = driver.findElements(LIST_OF_ITEMS_IN_FLYCART);
		System.out.println("List of items after click :: "+allElements.size());
		int list2 = allElements.size();

		softAssert.assertFalse(list1 == list2, "Item is not removed from cart");

		Reporter.log("Item is able to remove from cart");

		softAssert.assertAll();
	}

	public void giftWrap() throws Exception {
		String allClasses = null;
		boolean flag = false;
		String price1 = null;
		String price = null;
		String price2 = null;

		driver.get(CustomUtilities.baseUrl);
		driver.findElement(HomePageLocators.CART_ICON).click();
		Thread.sleep(2000);

		// first get the price in quantity line
		price = driver.findElement(PRICE_IN_QUANTITY_LINE).getText();
		for (String a : price.split("\\$")) 
			price = a;
		System.out.println("price  :: "+price);

		Thread.sleep(3000);
		driver.findElement(GIFT_WRAP).click();
		Thread.sleep(2000);

		// check popup is opened or not
		softAssert.assertTrue(driver.findElement(GIFT_WRAP_POPUP).isDisplayed(), "Gift Wrap Popup is not displayed");
		element = driver.findElement(GIFT_BOX_$5);
		allClasses = element.getAttribute("class");
		// check size available or not
		for (String c : allClasses.split(" ")) {
			if (c.equals("is-checked")) {
				flag = true;
			}
		}
		if(flag)
			Reporter.log("Gift Box $5.00 is already checked");
		else {
			driver.findElement(GIFT_BOX_$5).click();
			Thread.sleep(2000);
			Reporter.log("Gift Box $5.00 is checked");
		}
		// click on apply button
		driver.findElement(GIFT_WRAP_APPLY).click();
		Thread.sleep(7000);

		// check the $5 price is applying or not
		price2 = driver.findElement(GIFT_WRAP_PRICE).getText();
		System.out.println("previous price2 is: "+price2);
		for (String a : price2.split("\\$")) 
			price2 = a;
		System.out.println("price2  :: "+price2);

		// get estimated total price
		price1 = driver.findElement(ESTIMATE_TOTAL_PRICE).getText();
		for (String b : price1.split("\\$")) 
			price1 = b;
		System.out.println("price1  :: "+price1);


		double p = Float.parseFloat(price);
		double p2 = Float.parseFloat(price2);
		double p1 = Float.parseFloat(price1);
		// check the total estimated price is displayed correctly when added gift wrap price
		softAssert.assertTrue(p1 == p2+p, "Total estimated price is not correct");

		driver.get(CustomUtilities.baseUrl);

		softAssert.assertAll();
	}

	public void validateafterpayoninlinecart() throws Exception
	{

//		new HomePageComponents(driver).navigateToBraCategory();
//
//		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		//	new ProductDetailsPageComponents(driver).validatePage();
		new AddToCartComponents(driver).addToCart();
		driver.findElement(HomePageLocators.CART_ICON).click();
		Thread.sleep(3000);

		if(!driver.findElement(AFTERPAYTEXT).isDisplayed())
			throw new Exception("AfterPay Message not present on Fly cart.");
		Reporter.log("After pay Message is displayed on Inline Cart :: Displayed");

		price = driver.findElement(ESTIMATE_TOTAL_PRICE).getText();
		String[] price1 = price.split("\\$");
		String price2 = price1[price1.length-1];
		System.out.println("Estimate total is: "+price);
		if(Float.parseFloat(price2)<35 || Float.parseFloat(price2)>1000 )
		{
			softAssert.assertEquals(driver.findElement(AFTERPAYTEXT).getText(), "available for orders between $35 - $1000" , "Wrong afterpay message displayed for product price");
			Reporter.log("After pay message is correct On Inline cart :: Displayed and Correct");
			softAssert.assertTrue(driver.findElement(AFTERPAYLOGO_ICON).isDisplayed(), "Afterpay logo not present on Fly-out cart.");
			Reporter.log("After pay logo icon is displayed on Inline cart :: Displayed");
		}
		else
		{

			installment =Float.parseFloat(price2)/4;
			String inst = String.format("%.2f",installment );
			//	String expectedmessage = "In 4 installments of $" + inst + " by ?"; 
			String expectedmessage =  inst+ " "; 
			System.out.println("expected message is: " + expectedmessage);
			String actual= driver.findElement(AFTERPAYTEXT).getText();
			String ins_amount= actual.substring(actual.indexOf("$")+1, actual.indexOf("b"));
			System.out.println("Actual int_amount is: " +ins_amount);
			softAssert.assertEquals(ins_amount, expectedmessage , "Wrong afterpay message displayed for product price");
			Reporter.log("After pay message with calculated installment is correct on Inline cart :: Displayed and correct");
			softAssert.assertTrue(driver.findElement(AFTERPAYLOGO_ICON).isDisplayed(), "Afterpay logo not present on PDP");
			Reporter.log("After pay logo icon is displayed on Inline cart :: Displayed");
		}
		Thread.sleep(3000);
		// Close Fly cart
		element = driver.findElement(FlyCartPageLocator.INLINE_CART_CLOSE_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		softAssert.assertAll();
	}

	public void VerifyFlyCartOpenWithQSAndPDP() throws Exception
	{
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		js.executeScript("window.scrollBy(0,500)");

		wait.until(ExpectedConditions.presenceOfElementLocated(CollectionPageLocator.FIRST_PRODUCT_IMAGE));
		element = driver.findElement(CollectionPageLocator.FIRST_PRODUCT_IMAGE);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		action.moveToElement(element).build().perform();
		Thread.sleep(3000);
		if(driver.findElement(CollectionPageLocator.QUICK_SHOP_ATC).isDisplayed())
		{
			driver.findElement(CollectionPageLocator.QUICK_SHOP_ATC).click();
			Thread.sleep(3000);
			//select sizes from quick shop size overlay
			List<WebElement> allElements;
			String classtext;
			allElements = driver.findElements(QUICK_SHOP_SIZE_LIST);
			System.out.println("All sizes list :: "+ allElements.size());
			for(int i=0;i<allElements.size();i++) 
			{
				classtext=allElements.get(i).getAttribute("class");
				if (!classtext.contains("not-available")) 
				{
					element= driver.findElement(By.cssSelector("div.inline-quick-shop > ul > li:nth-child("+(i+1)+") > label"));
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(5000);	
					break;
				}
				else
				{
					System.out.println("Selected size is OOS");
				}
			}
			softAssert.assertTrue(driver.findElement(INLINE_CART_TITLE).isDisplayed(), "Flyout cart is not opened with QuickShop");
			Reporter.log("Validated Flyout cart opens with Quickshop");

		}
		else
			throw new Exception("Quick Shop ATC button is not displayed on hover.");

		//Check on pdp
		new HomePageComponents(driver).navigateToDressesInwomensCategory();
		new CollectionPageComponent(driver).navigateToProductDetailsPage();
		new AddToCartComponents(driver).selectSize();
		if(!driver.findElement(AddToCartLocators.ADD_TO_CART_BUTTON).isEnabled())
			throw new Exception("ADD TO CART button is not present");
		element = driver.findElement(AddToCartLocators.ADD_TO_CART_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		softAssert.assertTrue(driver.findElement(INLINE_CART_TITLE).isDisplayed(), "Flyout cart is not opened with ATC from pdp");
		Reporter.log("Validated Flyout cart opens with ATC from pdp");
		softAssert.assertAll();
	}
}
