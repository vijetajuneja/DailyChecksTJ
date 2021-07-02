package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.RatingReviewsComponents;

public class RatingAndReviewPage extends RatingReviewsComponents {

	WebDriver driver;

	public RatingAndReviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void verifyRatingAndReviews() throws Exception {
        new RatingReviewsComponents(driver).navigateToAllUnderwearInMenCategory();
        new RatingReviewsComponents(driver).navigateToProductDetailsPage();
        new RatingReviewsComponents(driver).RatingandReviews();

	}
	
}
