package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tommyjohn.automation.Pages.PhysicalGiftCardPage;
import com.tommyjohn.automation.utils.CustomUtilities;


public class ValidatePhysicalGiftCard {

	WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(String browser)
	{
		try {
			driver = new CustomUtilities().launchtj(browser);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	@Test
	public void ValidatePhysicalGiftCardFlow() throws Exception
	{
		new PhysicalGiftCardPage(driver).PhysicalgiftCardPageCheck();
	}

	@Test
	public void FieldValidationsForPhysicalGiftCard() throws Exception
	{
		new PhysicalGiftCardPage(driver).verifyFieldsforPhysicalGC();
	}
	@AfterMethod(alwaysRun = true)
	void teardown () {

		//driver.close();
		driver.quit();
	}

}
