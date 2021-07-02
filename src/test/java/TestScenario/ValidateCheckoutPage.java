package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.CheckoutPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateCheckoutPage {
	
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
	public void ValidateExpressCheckoutoptionsAreFunctional() throws Exception
	{
		new CheckoutPage(driver).ValidateExpressCheckoutOptions();
	}
	
	@Test
	public void ValidateGuestCheckoutFlow() throws Exception
	{
		new CheckoutPage(driver).Validateguestcheckout();
	}
	
	@Test
	public void ValidateRegisteredUserCheckoutFlow() throws Exception
	{
		new CheckoutPage(driver).Validateregisterusercheckout();
	}
	
	@Test
	public void ValidateInformationPageOfCheckout() throws Exception
	{
		new CheckoutPage(driver).Validateinformationpage();
	}
	
	@Test
	public void ValidateShippingPageOfCheckout() throws Exception
	{
		new CheckoutPage(driver).Validateshippingpage();
	}
	
	@Test
	public void ValidatePaymentPageOfCheckout() throws Exception
	{
		new CheckoutPage(driver).Validatepaymentpage();
	}
	
	@AfterMethod(alwaysRun = true)
	void tearDown() {

		//this.driver.close();
		this.driver.quit();

	}

}
