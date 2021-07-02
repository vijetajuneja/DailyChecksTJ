package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.GiftCard_Page;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateGiftCardFunctionality{

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
	public void ValidateGiftCardFlow() throws Exception
	{
		new GiftCard_Page(driver).giftCardPageCheck();
	}

	@Test
	public void FieldValidationsForGiftCard() throws Exception
	{
		new GiftCard_Page(driver).verifyfieldsforGCPage();
	}

	@Test
	public void ValidateErrorScenariosForGiftCard() throws Exception
	{
		new GiftCard_Page(driver).verifyerrormessagesongiftcard();
	}

	@AfterMethod(alwaysRun = true)
	void teardown () {

		//driver.close();
		driver.quit();
	}

}
