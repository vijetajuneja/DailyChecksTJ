package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.FlyCartPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateFlyCartPage {

	WebDriver driver;


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
	public void TC_ValidateEmptyFlyCart() throws Exception 
	{
		new FlyCartPage(driver).verifyAllFields(); 
	}

	@Test 
	public void TC_ValidateTextAndLinksonFlyCart() throws Exception
	{
		new FlyCartPage(driver).verifyAllFieldsOnNonEmptyFlyCart(); 
	}

	@Test 
	public void TC_ValidateFlyCartwithProductsInIt() throws Exception
	{
		new FlyCartPage(driver).validateAllFieldsOnNonEmptyFlyCart(); 
	}

	@Test
	public void TC_ValidateFlyCartOpenedWithQSandPDP() throws Exception {

		new FlyCartPage(driver).VerifyFlyCartOpenWithQSAndPDP();
	}

	@AfterMethod(alwaysRun = true)
	void tearDown() {

		//this.driver.close();
		this.driver.quit();

	}
}

