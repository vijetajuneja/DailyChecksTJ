package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.QuickShopPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateQuickShop {
	WebDriver driver ;

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
	public void TC_ValidateQuickShopOnCollection() throws Exception
	{
		new QuickShopPage(driver).QuickShopOnCollectionPage();
	}
//	@Test
//	public void TC_ValidateQuickShopOnBuyWith() throws Exception
//	{
//		new QuickShopPage(driver).QuickShopOnBuyWithSection();
//	}
	
	@AfterMethod(alwaysRun = true)
	void teardown () {
		
		//driver.close();
		driver.quit();
	}
}
