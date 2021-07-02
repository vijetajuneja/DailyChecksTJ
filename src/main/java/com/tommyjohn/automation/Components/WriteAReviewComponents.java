package com.tommyjohn.automation.Components;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class WriteAReviewComponents extends ProductDetailsPageLocators
{
	public WebDriver driver;
	public WebElement element;
	public Actions action;
	public JavascriptExecutor jse;
	String text;
	SoftAssert softAssert =  new SoftAssert();
	Properties properties = CustomUtilities.properties;
	public WriteAReviewComponents(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyWriteReview() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RATING_STARS));
		WebElement elem = driver.findElement(RATING_STARS);
		jse.executeScript("arguments[0].click();", elem);
		// wait for scroll it down
		Thread.sleep(6000);

		WebElement writereview = driver.findElement(WRITE_REVIEW_BUTTON);
		jse.executeScript("arguments[0].click();", writereview);

		softAssert.assertEquals(driver.findElement(WRITE_REVIEW_TITLE).getText(), "Write a Review", "Laguage mismatch for Write a Review title 2");
		softAssert.assertEquals(driver.findElement(NAME).getText(), "* Name", "Laguage mismatch for Name ");
		driver.findElement(NAME_TEXTBOX).sendKeys("Vijeta");
		softAssert.assertEquals(driver.findElement(EMAIL).getText(), "* Email", "Laguage mismatch for Email ");
		driver.findElement(EMAIL_TEXTBOX).sendKeys("vijeta@tommyjohnwear.com");
		softAssert.assertEquals(driver.findElement(LOCATION).getText(), "Location (Optional)", "Laguage mismatch for Location ");
		driver.findElement(LOCATION_TEXTBOX).sendKeys("India");
		softAssert.assertEquals(driver.findElement(FIT).getText(), "Fit", "Laguage mismatch for Fit	 ");
		WebElement fit = driver.findElement(FIT_SELECTION);
		jse.executeScript("arguments[0].click();", fit);
		softAssert.assertEquals(driver.findElement(OVERALLRATING).getText(), "* Overall Rating", "Laguage mismatch for Overall Rating	 ");
		WebElement stars = driver.findElement(STAR_SELECTION);
		jse.executeScript("arguments[0].click();", stars);
		softAssert.assertEquals(driver.findElement(HEADLINE).getText(), "* Add a Headline", "Laguage mismatch for Headline ");
		driver.findElement(HEADLINE_TEXTBOX).sendKeys("Nice Product");
		softAssert.assertEquals(driver.findElement(REVIEW).getText(), "* Review", "Laguage mismatch for Review	 ");
		driver.findElement(REVIEW_TEXTBOX).sendKeys("Must Buy");

		softAssert.assertTrue(driver.findElement(SUBMIT_BTN).isEnabled(), "Submit button not enabled");
		softAssert.assertAll();

	}

	public void verifyWriteReviewErrorMsgs() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RATING_STARS));
		WebElement elem = driver.findElement(RATING_STARS);
		jse.executeScript("arguments[0].click();", elem);
		// wait for scroll it down
		Thread.sleep(6000);
		elem = driver.findElement(WRITE_REVIEW_BUTTON);
		jse.executeScript("arguments[0].click();", elem);
		Thread.sleep(4000);
		elem = driver.findElement(SUBMIT_BTN);
		jse.executeScript("arguments[0].click();", elem);
		softAssert.assertEquals(driver.findElement(NAME_ERROR).getText(), "Please enter a name for this review.", "Laguage mismatch for error message for Name");
		softAssert.assertEquals(driver.findElement(EMAIL_ERROR).getText(), "Please enter a valid email for this review.", "Laguage mismatch for error message for Email");
		softAssert.assertEquals(driver.findElement(HEADLINE_ERROR).getText(), "Please enter a headline for this review.", "Laguage mismatch for error message for Headline");
		softAssert.assertEquals(driver.findElement(REVIEW_ERROR).getText(), "Please enter some content for this review.", "Laguage mismatch for error message for Review");

		softAssert.assertAll();

	}
}
