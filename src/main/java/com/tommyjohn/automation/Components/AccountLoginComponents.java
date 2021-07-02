package com.tommyjohn.automation.Components;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.tommyjohn.automation.PageLocators.AccountLoginLocators;
import com.tommyjohn.automation.PageLocators.HomePageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class AccountLoginComponents extends AccountLoginLocators{

	public WebDriver driver;
	String testemail;
	String password;
	String currentUrl;
	String invalidemail = "drewstrr@tre.vik";
	String invalidpassword = "123";
	WebElement element;
	public Actions actions;




	public AccountLoginComponents(WebDriver driver) {
		this.driver = driver;
	}

	public String createAccount() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		actions = new Actions(driver);
		testemail = "testaccount" + System.currentTimeMillis() +"@gmail.com";
		password = CustomUtilities.properties.getProperty("password");
		//		driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement((HomePageLocators.ACCOUNT_NAV_DROPDOWN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		wait.until(ExpectedConditions.presenceOfElementLocated(CREATEACCOUNT_BTN));
		driver.findElement(CREATEACCOUNT_BTN).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(CREATEACCOUNT_EMAIL));
		driver.findElement(CREATEACCOUNT_EMAIL).clear();
		Thread.sleep(2000);
		driver.findElement(CREATEACCOUNT_EMAIL).sendKeys(testemail);
		driver.findElement(CREATEACCOUNT_PASSWORD).clear();
		Thread.sleep(2000);

		driver.findElement(CREATEACCOUNT_PASSWORD).sendKeys(password);
		//driver.findElement(By.id("privacyPolicy")).click();
		driver.findElement(CREATEACCOUNT_BUTTON).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".account-logged-in-header")));
		currentUrl = driver.getCurrentUrl();
		if(!currentUrl.equals(CustomUtilities.properties.getProperty("accountpage")))
			throw new Exception("account page is not displayed after creating account");

		// logout the account
		element = driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN);
		actions.moveToElement(element).perform();
		executor.executeScript("arguments[0].click();", driver.findElement(LOGOUT_OPTION_IN_ACCOUNT_ICON));
		Thread.sleep(3000);

		Reporter.log("Account Created Successfully :: User is brought to account page");
		return testemail;
	}

	public void verifyFieldsOnCreateAccount() throws Exception
	{
		String text=null;
		String currentUrl;
		//	driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		text = driver.findElement(CREATEACCOUNT_TEXT1).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("createaccountetxt1")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("createaccountetxt1") + "but actual is "+text);

		text = driver.findElement(CREATEACCOUNT_TEXT2).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("createaccountetxt2")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("createaccountetxt2") +"but actual is" + text);

		if(!driver.findElement(CREATEACCOUNT_BTN).isEnabled())
			throw new Exception("Create account button is not enabled");
		driver.findElement(CREATEACCOUNT_BTN).click();
		Thread.sleep(5000);
		currentUrl = driver.getCurrentUrl();
		if(!currentUrl.equals(CustomUtilities.properties.getProperty("createaccountpage"))) 
			throw new Exception("Create account page is not displayed");

		if(!driver.findElement(ALREADYHAVEANACCOUNT_LINK).isDisplayed())
			throw new Exception("Already have an account link is not present");
		driver.findElement(ALREADYHAVEANACCOUNT_LINK).click();
		Thread.sleep(5000);
		driver.findElement(CREATEACCOUNT_BTN).click();
		Thread.sleep(3000);

		text = driver.findElement(CREATEACCOUNT_TEXT).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("createacounttext")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("createacounttext") + " but actual is "+ text +"'");

		text = driver.findElement(EMAIL_LABEL).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("emaillabel")))
			throw new Exception("Expected text for label is " + CustomUtilities.properties.getProperty("emaillabel") +" but actual is "+text);

		text = driver.findElement(PASSWORD_LABEL).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("passwordlabel")))
			throw new Exception("Expected text for label is " + CustomUtilities.properties.getProperty("passwordlabel") + "but actual is "+text);

		if(!driver.findElement(CREATEACCOUNT_EMAIL).isDisplayed())
			throw new Exception("Email textbox is not present");

		if(!driver.findElement(CREATEACCOUNT_PASSWORD).isDisplayed())
			throw new Exception("Password textbox is not present");

		text = driver.findElement(MARKETING_LABEL).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("marketinglabel")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("marketinglabel") + " but actual text is "+ text);

		if(!driver.findElement(MARKETING_CHCKBOX).isDisplayed())
			throw new Exception("Marketing checkbox not present");
		WebElement Marketing_checkbox_status = driver.findElement(By.cssSelector("#create_customer>input:nth-child(5)"));
		String status= Marketing_checkbox_status.getAttribute("value");
		if(!status.equalsIgnoreCase("true"))
			throw new Exception("Marketing Checkbox is not checked by default");
		driver.findElement(MARKETING_CHCKBOX).click();

		if(!driver.findElement(CREATEACCOUNT_BUTTON).isDisplayed())
			throw new Exception("Create account button is not present on create account page");

		//		text = driver.findElement(CREATEACCOUNT_DISCLAIMER).getText();
		//		if(!text.equals(CustomUtilities.properties.getProperty("createaccountdisclaimer")))
		//			throw new Exception("Expected text is " +CustomUtilities.properties.getProperty("createaccountdisclaimer") + "but actual is "+text);
		//
		//		driver.findElement(PRIVACYPOLICY_LINK).click();
		//		Thread.sleep(3000);

		//		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		//	    driver.switchTo().window(tabs2.get(1));
		//	    
		//		currentUrl = driver.getCurrentUrl();
		//		if(!currentUrl.equals(CustomUtilities.properties.getProperty("privacypolicypage"))) 
		//			throw new Exception("Privacy policy page is not displayed");
		//	
		//	
		//		driver.switchTo().window(tabs2.get(0));
		//		
		//		driver.findElement(TERMS_LINK).click();
		//		Thread.sleep(3000);
		//		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		//		driver.switchTo().window(tabs.get(2));
		//		currentUrl = driver.getCurrentUrl();
		//		if(!currentUrl.equals(CustomUtilities.properties.getProperty("termspage"))) 
		//			throw new Exception("Terms page is not displayed");

		Reporter.log("All the fields and texts displayed on Create Account account page are correct");
	}

	public void verifyErrosForCreateAccount() throws Exception
	{


		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.ACCOUNT_NAV_DROPDOWN));

		//	driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement((HomePageLocators.ACCOUNT_NAV_DROPDOWN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		driver.findElement(CREATEACCOUNT_BTN).click();
		Thread.sleep(3000);
		driver.findElement(CREATEACCOUNT_EMAIL).sendKeys(invalidemail);
		driver.findElement(CREATEACCOUNT_PASSWORD).sendKeys(invalidpassword);
		driver.findElement(CREATEACCOUNT_BUTTON).click();
		Thread.sleep(5000);
		currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals(CustomUtilities.properties.getProperty("accountpage")))
			throw new Exception("account created by invalid details");

		if(!driver.findElement(ERRORMESSAGES).isDisplayed())
			throw new Exception("Error messages are not displayed for invalid account creation");

		Reporter.log("All error messages are verified on create account page");
	}

	public void verifyFieldsOnRecoverPasswordPage() throws Exception {
		String currentUrl = null;
		String text = null;

		// click on accout icon from home page
		//driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
		// check for forgot your password link
		if(!driver.findElement(FORGOT_YOUR_PASSWORD_LINK).isDisplayed())
			throw new Exception("Forgot your password link is not Present");

		driver.findElement(FORGOT_YOUR_PASSWORD_LINK).click();						
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		if(!currentUrl.equals(CustomUtilities.properties.getProperty("loginRecoverPageUrl")))
			throw new Exception("Wrong page opened after forgot password link is clicked");

		// check heading text
		text = driver.findElement(RECOVER_YOUR_PASSWORD_HEADING).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("recoverYourPasswordHeadingText")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("recoverYourPasswordHeadingText") + "but actual is "+text);

		// check Please Enter Your Email Heading Text
		text = driver.findElement(PLEAZE_ENTER_YOUR_EMAIL_HEADING).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("pleaseEnterYourHeadingText")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("pleaseEnterYourHeadingText") + "but actual is "+text);

		// check Email Address Label
		text = driver.findElement(EMAIL_ADDRESS_LABEL).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("emailAddressLabel")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("emailAddressLabel") + "but actual is "+text);

		// check email inputbox is present or not
		if(driver.findElements(INPUT_BOX_FOR_EMAIL).size()== 0)
			throw new Exception("Inputbox for email not present");

		// click submit button if present
		if(!driver.findElement(SUBMIT_BUTTON).isEnabled())
			throw new Exception("Submit button is not present");
		driver.findElement(SUBMIT_BUTTON).click();

		// click Back to login link if present
		if(!driver.findElement(BACK_TO_lOGIN_LINK).isEnabled())
			throw new Exception("Back to login link is not present");
		driver.findElement(BACK_TO_lOGIN_LINK).click();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		if(!currentUrl.startsWith("https://tommyjohn.com/account/login"))
			throw new Exception("Wrong page opened after back to login link clicked");

		Reporter.log("All the fields and texts displayed on Recover password page are correct");

	}

	public void recoverPassword(String createdAccountEmail) throws Exception {
		String text = null;

		driver.navigate().to("https://tommyjohn.com/");
		// click on accout icon from home page
		//	driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// check for forgot your password link
		if(!driver.findElement(FORGOT_YOUR_PASSWORD_LINK).isDisplayed())
			throw new Exception("Forgot your password link is not Present");

		driver.findElement(FORGOT_YOUR_PASSWORD_LINK).click();						
		Thread.sleep(3000);

		// put the email in textbox to send recover
		if(driver.findElements(INPUT_BOX_FOR_EMAIL).size()!= 0) {
			driver.findElement(INPUT_BOX_FOR_EMAIL).clear();
			Thread.sleep(2000);
			driver.findElement(INPUT_BOX_FOR_EMAIL).sendKeys(createdAccountEmail);
		}
		else
			throw new Exception("Email text box is not present");

		// click submit button if present
		if(!driver.findElement(SUBMIT_BUTTON).isEnabled())
			throw new Exception("Submit button is not present");
		driver.findElement(SUBMIT_BUTTON).click();
		Thread.sleep(3000);

		// check email receive message is displayed or not
		if(!driver.findElement(EMAIL_RECIEVED_SUCCESS_MESSAGE).isEnabled())
			throw new Exception("Email recieved message is not present");
		text = driver.findElement(EMAIL_RECIEVED_SUCCESS_MESSAGE).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("emailRecievedSuccessMessage")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("emailRecievedSuccessMessage") + "but actual is "+text);

		Reporter.log("Recover password functionality completed Successfully :: User is brought to login page");
	}

	public void verifyAllErrorsOnRecoverPasswordPage() throws Exception{
		String text = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// click on accout icon from home page
		//		driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement((HomePageLocators.ACCOUNT_NAV_DROPDOWN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		// check for forgot your password link
		if(!driver.findElement(FORGOT_YOUR_PASSWORD_LINK).isEnabled())
			throw new Exception("Forgot your password link is not Present");

		driver.findElement(FORGOT_YOUR_PASSWORD_LINK).click();						
		Thread.sleep(3000);

		// put the email in textbox to send recover
		if(driver.findElements(INPUT_BOX_FOR_EMAIL).size()!= 0) {
			driver.findElement(INPUT_BOX_FOR_EMAIL).clear();
			Thread.sleep(2000);
			driver.findElement(INPUT_BOX_FOR_EMAIL).sendKeys(invalidemail);
		}
		else
			throw new Exception("Email text box is not present");

		// click submit button if present
		if(!driver.findElement(SUBMIT_BUTTON).isEnabled())
			throw new Exception("Submit button is not present");
		driver.findElement(SUBMIT_BUTTON).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(ERROR_MESSAGE));

		text = driver.findElement(ERROR_MESSAGE).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("errorMessageRecoverEmail")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("errorMessageRecoverEmail") + "but actual is "+text);

		// check link in error message
		if(!driver.findElement(LINK_IN_ERROR_MESSAGE_FROM_RECOVER_PASSWORD).isEnabled())
			throw new Exception("Link from error message is not present or not enable");
		driver.findElement(LINK_IN_ERROR_MESSAGE_FROM_RECOVER_PASSWORD).click();
		Thread.sleep(3000);
		text = driver.getCurrentUrl();
		if(!text.equals(CustomUtilities.properties.getProperty("createaccountpage")))
			throw new Exception("Wrong page opened after clicked on link");

		Reporter.log("All error messages are verified on Recover password page");
	}

	public void verifyAllFieldsOnLoginPage() throws Exception {
		String text = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// click on accout icon from home page
		//		driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement((HomePageLocators.ACCOUNT_NAV_DROPDOWN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);


		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(LOGIN_HEADING_TEXT));
		// check login heading text

		text = driver.findElement(LOGIN_HEADING_TEXT).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("loginHeadingText")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("loginHeadingText") + "but actual is "+text);

		// check email label

		text = driver.findElement(EMAIL_LABEL1).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("emailLabel")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("emailLabel") + "but actual is "+text);

		// check for email inputbox
		if(driver.findElements(CUSTOMER_EMAIL_INPUT).size()== 0)
			throw new Exception("Email inputbox is not present");

		// check password label
		if(!driver.findElement(PASSWORD_LABEL1).isDisplayed())
			throw new Exception("Password label not present");

		text = driver.findElement(PASSWORD_LABEL1).getText();
		if(!text.equals(CustomUtilities.properties.getProperty("passwordLabel")))
			throw new Exception("Expected text is" + CustomUtilities.properties.getProperty("passwordLabel") + "but actual is "+text);

		// check password inputbox
		if(driver.findElements(CUSTOMER_PASSWORD_INPUTBOX).size()== 0)
			throw new Exception("Password inputbox is not present");

		// check login button
		if(!driver.findElement(LOGIN_BUTTON).isDisplayed())
			throw new Exception("Login button is not present");

		// check forgot password link
		// check login button
		if(!driver.findElement(FORGOT_YOUR_PASSWORD_LINK).isDisplayed())
			throw new Exception("Forgot password link is not present");

		Reporter.log("All displayed fields and texts are verified on account login page");
	}

	public void verifyAccountLoginFuctionality(String createdAccountEmail) throws Exception {

		actions = new Actions(driver);
		// click on account icon from home page
		//		driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement((HomePageLocators.ACCOUNT_NAV_DROPDOWN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals(CustomUtilities.properties.getProperty("loginPageUrl"))) {
			// type correct email if email inputbox is present

			driver.findElement(CUSTOMER_EMAIL_INPUT).clear();
			Thread.sleep(2000);
			driver.findElement(CUSTOMER_EMAIL_INPUT).sendKeys(createdAccountEmail);

			// type correct password if password inputbox is present
			if(driver.findElements(CUSTOMER_PASSWORD_INPUTBOX).size()== 0)
				throw new Exception("Email inputbox is not present");
			driver.findElement(CUSTOMER_PASSWORD_INPUTBOX).clear();
			Thread.sleep(2000);
			driver.findElement(CUSTOMER_PASSWORD_INPUTBOX).sendKeys(CustomUtilities.properties.getProperty("password"));

			// click login button if present
			if(!driver.findElement(LOGIN_BUTTON).isDisplayed())
				throw new Exception("Login button is not present");
			driver.findElement(LOGIN_BUTTON).click();
			Thread.sleep(5000);
			// logout the account
			element = driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN);
			actions.moveToElement(element).perform();
			WebElement logout = driver.findElement(LOGOUT_OPTION_IN_ACCOUNT_ICON);
			executor.executeScript("arguments[0].click();", logout);
			Thread.sleep(3000);

		}
		else throw new Exception("Wrong page opened");  

		Reporter.log("Account Login functionality verified successfully");
	}

	public void verifyErrorMessagesOnLoginPage() throws Exception {

		// click on account icon from home page
		//		driver.findElement(HomePageLocators.ACCOUNT_NAV_DROPDOWN).click();
		WebElement element = driver.findElement((HomePageLocators.ACCOUNT_NAV_DROPDOWN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals(CustomUtilities.properties.getProperty("loginPageUrl"))) {
			// type wrong email if email inputbox is present

			driver.findElement(CUSTOMER_EMAIL_INPUT).clear();
			Thread.sleep(2000);
			driver.findElement(CUSTOMER_EMAIL_INPUT).sendKeys(invalidemail);
			Thread.sleep(3000);
			// type correct password if password inputbox is present

			driver.findElement(CUSTOMER_PASSWORD_INPUTBOX).clear();
			Thread.sleep(2000);
			driver.findElement(CUSTOMER_PASSWORD_INPUTBOX).sendKeys(invalidpassword);

			// click login button if present
			if(!driver.findElement(LOGIN_BUTTON).isDisplayed())
				throw new Exception("Login button is not present");
			driver.findElement(LOGIN_BUTTON).click();
			Thread.sleep(3000);

			// check for error message down to email textbox
			if(!driver.findElement(CUSTOMER_EMAIL_MESSAGE).isDisplayed())
				throw new Exception("Customer email error message is not displayed");
			Thread.sleep(3000);
			// check for error message down to password textbox
			if(!driver.findElement(CUSTOMER_PASSWORD_MESSAGE).isDisplayed())
				throw new Exception("Customer email error message is not displayed");
		}
		else throw new Exception("Wrong page opened");

		Reporter.log("All error messages are verified on login page");
	}
}
