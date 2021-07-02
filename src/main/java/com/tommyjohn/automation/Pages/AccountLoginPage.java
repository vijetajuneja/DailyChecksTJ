package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.AccountLoginComponents;

public class AccountLoginPage extends AccountLoginComponents {
	
	public AccountLoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public String createCustomerAccount() throws Exception
	{
		return createAccount();
	}

	public void verifyfieldsandtextsoncreateaccountpage() throws Exception
	{
		verifyFieldsOnCreateAccount();
	}
	
	public void verifyerrorsoncreateaccountpage() throws Exception
	{
		verifyErrosForCreateAccount();
	}
	
	public void verifyFieldsAndTextsOnRecoverPasswordPage() throws Exception
	{
		verifyFieldsOnRecoverPasswordPage();
	}
	
	public void recoverPasswordFunctionality(String accountCreatedEmail) throws Exception
	{
		recoverPassword(accountCreatedEmail);
	}
	
	public void verifyErrorsOnRecoverPasswordPage() throws Exception
	{
		verifyAllErrorsOnRecoverPasswordPage();
	}

	public void verifyAllFieldsAndTextsOnLoginPage() throws Exception
	{
		verifyAllFieldsOnLoginPage();
	}

	public void loginCustomerAccount(String email) throws Exception
	{
		verifyAccountLoginFuctionality(email);
	}

	public void verifyErrorsOnLoginPage() throws Exception
	{
		verifyErrorMessagesOnLoginPage();
	}

}
