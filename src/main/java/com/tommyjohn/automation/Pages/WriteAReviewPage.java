package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.RatingReviewsComponents;
import com.tommyjohn.automation.Components.WriteAReviewComponents;

public class WriteAReviewPage extends WriteAReviewComponents {
	WebDriver driver;

	public WriteAReviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verifyWriteReviewsFunctionalityOnPDP() throws Exception 
	{
		new RatingReviewsComponents(driver).navigateToAllPantiesnInWomenCategory();
        new RatingReviewsComponents(driver).navigateToProductDetailsPage();
		new WriteAReviewComponents(driver).verifyWriteReview();
	
	}
	public void verifyReviewsFieldErrorOnPDP() throws Exception
	{
		new RatingReviewsComponents(driver).navigateToAllPantiesnInWomenCategory();
        new RatingReviewsComponents(driver).navigateToProductDetailsPage();
		new WriteAReviewComponents(driver).verifyWriteReviewErrorMsgs();
	
	}
	
}
