package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tommyjohn.automation.Pages.HomePage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateHomePage {
	public WebDriver driver;

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
	public void TC_verifyLogoAndCategoriesOnHomePage() throws Exception {

		new HomePage(driver).ValidateLogoAndCategoriesPresence();
	}
	@Test
	public void TC_verifyFooterLinksOnHomePage() throws Exception {

		new HomePage(driver).validateFooterLinks();
	}
	@Test
	public void TC_verifyAccountdropdownOnHomePage() throws Exception {

		new HomePage(driver).verifyaccountdropdown();
	}

	@Test
	public void TC_verifyAccountAndCartIconOnHomePage() throws Exception {

		new HomePage(driver).validateAccountIcon();
		new HomePage(driver).validateCartIcon();
	}

	@Test
	public void TC_ValidateSearchFunctionality() throws
	Exception {

		new HomePage(driver).validateSearchFunctionality();
	}
	
	@Test
	public void TC_ValidateDoNotSellMyPersonalInformationPage() throws
	Exception {

		new HomePage(driver).validateDoNotSellMyPersonalInformation();
	}
	
	@Test
	public void TC_ValidateRecommendedForYou() throws
	Exception {

		new HomePage(driver).verifyrecommendedforyou();
	}
	
	@Test
	public void TC_ValidateQuickShoponDYRecsHomePgae() throws
	Exception {

		new HomePage(driver).verifyQuickShopforDYRecsOnHomePage();
	}

	@Test
	public void TC_ValidateColorSwatchonDYRecsHomePage() throws
	Exception {

		new HomePage(driver).verifyColorSwatchforDYRecsOnHomePage();
	}

	@Test
	public void TC_ValidateProductTileHoverFunctionalityonDYRecsHomePage() throws
	Exception {

		new HomePage(driver).verifyRFYProductTileHoverFunctionality();
	}


//	@Test public void TC_ValidateSearchFunctionalityviaProductMatches() throws
//	Exception {
//
//		new HomePage(driver).validateSearchFunction(); }


	@AfterMethod(alwaysRun = true)
	void teardown () {

//		driver.close();
		driver.quit();
	}


}
