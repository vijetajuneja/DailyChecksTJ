package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;

public class AccountLoginLocators {
	
	//on account login page
	
	public static By CREATEACCOUNT_TEXT1 = By.cssSelector(".account-logged-out-row.two-tiles.second-row-mobile.on-load > h2");
	public static By CREATEACCOUNT_TEXT2 = By.cssSelector(".account-registration > p");
	public static By CREATEACCOUNT_BTN = By.cssSelector(".account-registration > a");
	public static By LOGIN_HEADING_TEXT = By.cssSelector("#customer-login-form > h2");
	public static By EMAIL_LABEL1 = By.cssSelector("#customer_login > div:nth-child(4) > label");
	public static By CUSTOMER_EMAIL_INPUT = By.cssSelector("#customer-email");
	public static By PASSWORD_LABEL1 = By.cssSelector("#customer_login > div:nth-child(5) > label");
	public static By CUSTOMER_PASSWORD_INPUTBOX = By.cssSelector("#customer-password");
	public static By LOGIN_BUTTON = By.cssSelector("#customer_login > button");
	
	
	
	
	//on create account page
	public static By CREATEACCOUNT_TEXT = By.cssSelector(".account-logged-out-row.two-tiles.create-account.on-load > h2");
	public static By ALREADYHAVEANACCOUNT_LINK = By.cssSelector(".account-registration > form > a");
	public static By CREATEACCOUNT_EMAIL  = By.cssSelector("#email");
	public static By CREATEACCOUNT_PASSWORD= By.cssSelector("#create-password");
	public static By CREATEACCOUNT_BUTTON = By.cssSelector("#create_customer > button");
	public static By EMAIL_LABEL = By.cssSelector("#create_customer > div:nth-child(7) > label");
	public static By PASSWORD_LABEL = By.cssSelector("#create_customer > div:nth-child(8) > label");
	public static By MARKETING_LABEL = By.cssSelector(".account-checkbox-label");
	public static By MARKETING_CHCKBOX = By.cssSelector("#accept_marketing");
	public static By CREATEACCOUNT_DISCLAIMER = By.cssSelector(".disclaimer.gdpr_Privacy_Policy");
	public static By PRIVACYPOLICY_LINK = By.cssSelector(".disclaimer.gdpr_Privacy_Policy > a.privacyPolicy_Textlink");
	public static By TERMS_LINK = By.cssSelector(".disclaimer.gdpr_Privacy_Policy> a:nth-child(2)");
	public static By ERRORMESSAGES = By.cssSelector(".error-container-create-account");
	public static By MYACCOUNT_OPTION_IN_ACCOUNT_ICON = By.cssSelector("div.header-main__inner.container > ul > li:nth-child(3) > div > ul > li:nth-child(1) > a");
	public static By LOGOUT_OPTION_IN_ACCOUNT_ICON = By.cssSelector(".header-nav-dropdown > ul> li:nth-child(3) >a");
	public static By CUSTOMER_EMAIL_MESSAGE = By.cssSelector("#customer_login > div:nth-child(5)");
	public static By CUSTOMER_PASSWORD_MESSAGE = By.cssSelector("#customer_login > div:nth-child(7)");
//			public static By CREATEACCOUNT_TEXT1 = By.cssSelector
	
	
//	on recover password page
	public static By BACK_TO_lOGIN_LINK = By.cssSelector("#recover-password-form-new > a");
	public static By FORGOT_YOUR_PASSWORD_LINK = By.cssSelector("#customer_login > a");
	public static By RECOVER_YOUR_PASSWORD_HEADING = By.cssSelector("#recover-password-form-validate > div > h2");
	public static By PLEAZE_ENTER_YOUR_EMAIL_HEADING = By.cssSelector("#recover-password-form-validate > div > p");
	public static By EMAIL_ADDRESS_LABEL = By.cssSelector(".form-row.input-group > label");
	public static By INPUT_BOX_FOR_EMAIL = By.cssSelector("#recover-email");
	public static By SUBMIT_BUTTON = By.cssSelector("input.btn.account-button.button.button--full.button--red");
//	public static By SUBMIT_BUTTON = By.cssSelector("#recover-password-form-new > div:nth-child(4) > input");
	public static By ERROR_MESSAGE = By.cssSelector("li.reset-fail");
	public static By EMAIL_RECIEVED_SUCCESS_MESSAGE = By.cssSelector("div.account-reset-password-sent.reset-success > p");
	public static By LINK_IN_ERROR_MESSAGE_FROM_RECOVER_PASSWORD = By.cssSelector("div.input-group > ul > li > a");
	

}
