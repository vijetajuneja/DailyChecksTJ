package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.ProductDetailsPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateProductDetailsPage {

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
	public void TC_verifyProductDetailsPage() throws Exception {	
		new ProductDetailsPage(driver).verifyProductDetailsPage();
	}
	@Test
	public void TC_verifyReviewsSectionOnPDP() throws Exception {	
		new ProductDetailsPage(driver).verifyReviewsSectionOnPDP();
	}
	@Test
	public void TC_verifyWriteAReviewFunctionalityOnPDP() throws Exception {	
		new ProductDetailsPage(driver).verifyWriteReviewsFunctionalityOnPDP();
	}
	@Test
	public void TC_verifyErrorMessagesForWriteReviewFieldsOnPDP() throws Exception {	
		new ProductDetailsPage(driver).verifyReviewsFieldErrorOnPDP();
	}
	@Test
	public void TC_VerifyBundlePDP() throws Exception {	
		new ProductDetailsPage(driver).verifyBundlePDP();
	}
	
	@Test
	public void TC_VerifyJoinTheWaitlistFunctionality() throws Exception {	
		new ProductDetailsPage(driver).verifyjointhewaitlist();
	}
	
	@Test
	public void TC_VerifyRecommendedForYouSection() throws Exception {	
		new ProductDetailsPage(driver).verifyrecommendedforyou();
	}
	
//	@Test
//	public void TC_VerifyMysterPackPDP() throws Exception {	
//		new ProductDetailsPage(driver).verifymysterypack();
//	}
	
	@Test
	public void TC_VerifyATC_ScrollingCTA() throws Exception {	
		new ProductDetailsPage(driver).VerifyATC_ScrollingCTA();
	}
	
	@Test
	public void TC_VerifySortyByReviews() throws Exception
	{
		new ProductDetailsPage(driver).VerifySortByReviews();
	}
	
	@Test
	public void TC_VerifySelectedSwatchFromPLP() throws Exception
	{
		new ProductDetailsPage(driver).VerifySelectedSwatchFromPLP();
	}

	@Test
	public void TC_VerifyAskAQuestion() throws Exception
	{
		new ProductDetailsPage(driver).VerifyAskAQuestion();
	}
	
	@Test
	public void TC_VerifyQuickShoponDYRecsPDP() throws Exception
	{
		new ProductDetailsPage(driver).verifyQuicShopforDYRecsOnPDP();
	}
	
	@Test
	public void TC_VerifyColorSwatchonDYRecsPDP() throws Exception
	{
		new ProductDetailsPage(driver).verifyColorSwatchforDYRecsOnPDP();
	}
	
	@Test
	public void TC_VerifyProductTileHoverFunctionalityonDYRecsPDP() throws Exception
	{
		new ProductDetailsPage(driver).verifyProductTileHoverFunctionalityforDYRecsOnPDP();
	}
	@Test
	public void TC_VerifyPreselectedSizeOnBraPDP() throws Exception
	{
		new ProductDetailsPage(driver).verifyPreselectedSizeOnBraPDP();
	}
	
	
	@Test
	public void TC_VerifyPreselectedSizeOnBoxerBriefPDP() throws Exception
	{
		new ProductDetailsPage(driver).verifyPreselectedSizeOnBoxerBriefPDP(); 
	}
	@Test
	public void TC_VerifyPreselectedSizeOnMensUndershirtPDP() throws Exception
	{
		new ProductDetailsPage(driver).verifyPreselectedSizeOnMensUndershirtPDP();
	}
	@Test
	public void TC_VerifyPreselectedSizeOnBundlePDP() throws Exception
	{
		new ProductDetailsPage(driver).verifyPreselectedSizeOnBundlePDP();
	}
	@Test
	public void TC_VerifyLowInventoryMessageOnMensUnderwearPDP() throws Exception
	{
		new ProductDetailsPage(driver).verifyLowInventoryMessageOnMensUnderwearPDP();
	}
	@AfterMethod(alwaysRun = true)
	void teardown () {
		
	//	driver.close();
		driver.quit();
	}
}