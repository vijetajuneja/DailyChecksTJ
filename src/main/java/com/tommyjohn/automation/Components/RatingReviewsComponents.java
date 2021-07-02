package com.tommyjohn.automation.Components;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.tommyjohn.automation.PageLocators.CollectionPageLocator;
import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class RatingReviewsComponents extends ProductDetailsPageLocators
{
	public WebDriver driver;
	public WebElement element;
	public Actions action;
	public JavascriptExecutor jse;
	String text;
	SoftAssert softAssert =  new SoftAssert();
	Properties properties = CustomUtilities.properties;
	public RatingReviewsComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void RatingandReviews() throws Exception
	{
		jse = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RATING_STARS));
		if(driver.findElement(RATING_STARS).isDisplayed()) {

			WebElement elem = driver.findElement(RATING_STARS);
			jse.executeScript("arguments[0].click();", elem);
			Thread.sleep(6000);
			Reporter.log("Review Stars Are Displayed :: Clickable :: Clicked");
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
					elem = driver.findElement(PAGINATION_RIGHT_ARROW);
					jse.executeScript("arguments[0].click();", elem);

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

	// navigate to all underwear in men category 
	public void navigateToAllUnderwearInMenCategory() throws Exception {
		jse = (JavascriptExecutor)driver;
		driver.get("https://tommyjohn.com/collections/mens-underwear");
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,250)");
	}

	// navigate to All Panties in Women category
	public void navigateToAllPantiesnInWomenCategory() throws Exception {
		driver.get("https://tommyjohn.com/collections/womens-underwear");
	}



	public void navigateToProductDetailsPage() throws Exception {
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CollectionPageLocator.FIRST_PRODUCT_HEAD_LINE_TEXT));
		text = driver.findElement(CollectionPageLocator.FIRST_PRODUCT_IMAGE).getAttribute("alt");
		WebElement el = driver.findElement(CollectionPageLocator.FIRST_PRODUCT_HEAD_LINE_TEXT);
		jse.executeScript("arguments[0].click();", el);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductDetailsPageLocators.PRODUCT_TITLE));
		Reporter.log(driver.getCurrentUrl());

	}


}
