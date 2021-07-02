package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.AccountLoginPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateAccountLoginFunctionality {
	 WebDriver driver;
	String accountCreatedEmail;
//	String accountCreatedEmail = "testaccount1558509824283@gmail.com";

	
		
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(String browser) {
		try {
			driver = new CustomUtilities().launchtj(browser);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}


	@Test
	public void TC_FieldValidationsOnLoginPage() throws Exception
	{
		new AccountLoginPage(driver).verifyAllFieldsOnLoginPage();
	}

	@Test
	public void TC_FieldValidationsOnCreateAccountPage() throws Exception
	{
		new AccountLoginPage(driver).verifyfieldsandtextsoncreateaccountpage();
	}
	
	@Test
	public void TC_FieldValidationsOnRecoverPasswordPage() throws Exception
	{
		new AccountLoginPage(driver).verifyFieldsAndTextsOnRecoverPasswordPage();
	}


	@Test(dependsOnMethods = { "TC_VerifyCreateAccount" })
//	@Test(priority = 3)
	public void TC_VerifyAccountLogin() throws Exception
	{
		new AccountLoginPage(driver).loginCustomerAccount(accountCreatedEmail);
	}

	@Test
	public void TC_VerifyCreateAccount() throws Exception
	{
		accountCreatedEmail = new AccountLoginPage(driver).createCustomerAccount();
	}

	@Test(dependsOnMethods = { "TC_VerifyCreateAccount" })
//	@Test(priority = 2)
	public void TC_VerifyRecoverPassword() throws Exception
	{
		new AccountLoginPage(driver).recoverPasswordFunctionality(accountCreatedEmail);
	}
		
	@Test
	public void TC_VerifyErrorScenariosForLogin() throws Exception
	{
		new AccountLoginPage(driver).verifyErrorsOnLoginPage();
	}
	@Test
	public void TC_VerifyErrorScenariosForCreateAccount() throws Exception
	{
		new AccountLoginPage(driver).verifyerrorsoncreateaccountpage();	
	}
	@Test
	public void TC_VerifyErrorScenariosForRecoverPassword() throws Exception
	{
		new AccountLoginPage(driver).verifyErrorsOnRecoverPasswordPage();
	}

	@AfterMethod(alwaysRun = true)
	void teardown () {
		
		//driver.close();
		driver.quit();
	}

}
