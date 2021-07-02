package com.tommyjohn.automation.Components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.tommyjohn.automation.PageLocators.AccountLoginLocators;
import com.tommyjohn.automation.PageLocators.FlyCartPageLocator;
import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.PageLocators.ReOrderPageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ReOrderPageComponents extends ReOrderPageLocators{
	WebDriver driver;
	public Actions action;
	WebElement element;
	String text;
	

	public ReOrderPageComponents(WebDriver driver) {

		this.driver = driver;
	}

	public void ReorderPagevalidation() throws Exception
	{

		SoftAssert softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.ACCOUNT_NAV_DROPDOWN));
		driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		Thread.sleep(3000);
		driver.findElement(AccountLoginLocators.CUSTOMER_EMAIL_INPUT).clear();
		Thread.sleep(2000);
		driver.findElement(AccountLoginLocators.CUSTOMER_EMAIL_INPUT).sendKeys("vijeta@tommyjohnwear.com");
		Thread.sleep(2000);
		driver.findElement(AccountLoginLocators.CUSTOMER_PASSWORD_INPUTBOX).sendKeys(CustomUtilities.properties.getProperty("password"));
		Thread.sleep(2000);
		driver.findElement(AccountLoginLocators.LOGIN_BUTTON).click();

		Thread.sleep(5000);

		action = new Actions(driver);
		element = driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN);
		action.moveToElement(element).perform();
		if(!driver.findElement(HEADER_REORDER_LINK).isDisplayed())
			throw new Exception("Reorder option not displayed");
		Reporter.log("Header Nav Reorder link is Displayed ");

//		action.moveToElement(element).click(driver.findElement(HomePageLocators.REORDER)).build().perform();
//		driver.findElement(HomePageLocators.REORDER).click();

		driver.navigate().to(driver.getCurrentUrl()+"?view=reorder");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(REORDER_TEXT));

		softAssert.assertEquals(driver.findElement(REORDER_TEXT).getText(), "Reorder", "Reorder title is not present on Reorder page");
		softAssert.assertTrue(driver.findElement(PRODUCT_IMAGE).isDisplayed(), "Product Images not present on reorder page");
		softAssert.assertTrue(driver.findElement(REORDER_ITEM_DETAILS).isDisplayed(), "Reorder item details link is not present");
		softAssert.assertTrue(driver.findElement(REORDER_ITEM_TITLE).isDisplayed(), "Reorder item title is not present");
		softAssert.assertTrue(driver.findElement(REORDER_ITEM_VARIANT).isDisplayed(), "Reorder item variant is not present");
		softAssert.assertTrue(driver.findElement(REORDER_ITEM_PRICE).isDisplayed(), "Reorder item price is not present");
		softAssert.assertTrue(driver.findElement(REORDER_ITEM_ATC).isDisplayed(), "Add to cart option is not present on reorder page");
		softAssert.assertTrue(driver.findElement(REORDER_ITEM_WRITEREVIEW).isDisplayed(), "Write a review option is not present on reorder page");
       //Check gift box is hidden
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
        List<WebElement> element = driver.findElements(REORDER_ITEM_TITLE);
        System.out.println("total products in reorder page is: "+element.size());
		for(WebElement titles : element)
		{
			if(titles.getText().contains("Gift Box"))
				throw new Exception("Product tile of gift box is not hidden from reorder page");
		}
		softAssert.assertAll();
	}

	public void reorderitem() throws Exception
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		SoftAssert softAssert = new SoftAssert();
		ReorderPagevalidation();
		List<WebElement> list = new ArrayList<WebElement>();
		list=driver.findElements(REORDER_ITEM_ATC);
		
		for(int i=0; i<list.size(); i++)
		{
		   	if(list.get(i).getAttribute("title").equalsIgnoreCase("Add to Cart"))
		   	{
		   		text= driver.findElement(By.cssSelector(".account-reorder-grid>.reorder-item:nth-child("+(i+1)+")>a:nth-child(2)>span")).getText();
		   		executor.executeScript("arguments[0].click();", list.get(i));
		   		break;
		   	}
		 }
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlyCartPageLocator.FIRST_PRODUCT_TITLE_IN_CART));
		softAssert.assertEquals(driver.findElement(FlyCartPageLocator.FIRST_PRODUCT_TITLE_IN_CART).getText(), text , "Wrong product added to cart");
		WebElement elem= driver.findElement(FlyCartPageLocator.CHECKOUT_BUTTON);
		executor.executeScript("arguments[0].click();", elem);
		softAssert.assertAll();
	}

	public void orderdetails() throws Exception
	{

		SoftAssert softAssert = new SoftAssert();
		ReorderPagevalidation();
		element=driver.findElement(REORDER_ITEM_DETAILS);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		Thread.sleep(3000);
		softAssert.assertTrue(driver.findElement(ORDERDETAILS_TITLE).isDisplayed(), "Order details page didnt opened");
		softAssert.assertAll();		
	}

	public void reorderpagetopdp() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		ReorderPagevalidation();
		Thread.sleep(3000);
		text = driver.findElement(REORDER_ITEM_TITLE).getText();
		driver.findElement(PRODUCT_IMAGE).click();
		Thread.sleep(7000);
		System.out.println("Title on Reorder page is: "+text);
		String text1= driver.findElement(ProductDetailsPageLocators.PRODUCT_TITLE).getText();
		System.out.println("Title on PDP is: "+text1);
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.PRODUCT_TITLE).getText(), text , "Wrong product page opened from reorder page");
		softAssert.assertAll();
	}

	public void ReviewsPage_fromReorder() throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		JavascriptExecutor executore = (JavascriptExecutor) driver;
		ReorderPagevalidation();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(REORDER_ITEM_WRITEREVIEW);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);

	//	driver.findElement(REORDER_ITEM_WRITEREVIEW).click();
		Thread.sleep(5000);
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.WRITE_REVIEW_TITLE).getText(), "Write a Review", "Language mismatch for Write a Review title");
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.NAME).getText(), "* Name", "Laguage mismatch for Name ");
		driver.findElement(ProductDetailsPageLocators.NAME_TEXTBOX).sendKeys("Vijeta");
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.EMAIL).getText(), "* Email", "Laguage mismatch for Email ");
		driver.findElement(ProductDetailsPageLocators.EMAIL_TEXTBOX).sendKeys("vijeta@tommyjohnwear.com");
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.LOCATION).getText(), "Location (Optional)", "Laguage mismatch for Location ");
		driver.findElement(ProductDetailsPageLocators.LOCATION_TEXTBOX).sendKeys("India");
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.FIT).getText(), "Fit", "Laguage mismatch for Fit	 ");
		WebElement fit = driver.findElement(ProductDetailsPageLocators.FIT_SELECTION);
		executore.executeScript("arguments[0].click();", fit);
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.OVERALLRATING).getText(), "* Overall Rating", "Laguage mismatch for Overall Rating	 ");
		WebElement stars = driver.findElement(ProductDetailsPageLocators.STAR_SELECTION);
		executore.executeScript("arguments[0].click();", stars);
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.HEADLINE).getText(), "* Add a Headline", "Laguage mismatch for Headline ");
		driver.findElement(ProductDetailsPageLocators.HEADLINE_TEXTBOX).sendKeys("Nice Product");
		softAssert.assertEquals(driver.findElement(ProductDetailsPageLocators.REVIEW).getText(), "* Review", "Laguage mismatch for Review	 ");
		driver.findElement(ProductDetailsPageLocators.REVIEW_TEXTBOX).sendKeys("Must Buy");

		softAssert.assertTrue(driver.findElement(ProductDetailsPageLocators.SUBMIT_BTN).isEnabled(), "Submit button not enabled");
		softAssert.assertAll();
		Reporter.log("Review Page from reorder is correct");

	}



}

