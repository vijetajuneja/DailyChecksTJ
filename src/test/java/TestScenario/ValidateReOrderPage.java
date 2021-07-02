package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.ReOrderPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateReOrderPage {
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
	public void ValidateDetailsOnReOrderPage() throws Exception
	{
		new ReOrderPage(driver).ValidateReOrderPage();
	}
	
	@Test
	public void ValidateUserIsAbleToReOrderItemFromReOrderPage() throws Exception
	{
		new ReOrderPage(driver).ReOrderItem();
	}
	
	@Test
	public void ValidateUserIsRedirectedToCorrectPDPFromReOrderPage() throws Exception
	{
		new ReOrderPage(driver).ReOrderToPDP();
	}
	
	@Test
	public void ValidateUserIsRedirectedToCorrectOrderDetailsPageFromReOrderPage() throws Exception
	{
		new ReOrderPage(driver).OrderDetails();
	}
	@Test
	public void ValidateReviewsPageFromReOrderPage() throws Exception
	{
		new ReOrderPage(driver).ReviewPage();
	}
	
	@AfterMethod(alwaysRun = true)
	void tearDown() {

		//this.driver.close();
		this.driver.quit();

	}

}
