package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tommyjohn.automation.Pages.CollectionPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateMegaCollectionPages {

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
	public void TC_ValidateProductImageOnAllPantiesInWomenCategory() throws
	Exception
	{
		new CollectionPage(driver).validateproductimageonAllpanties();

	}

	@Test 
	public void TC_ValidateProductNameOnAllPantiesInWomenCategory() throws
	Exception 
	{ 
		new CollectionPage(driver).validateproductnameonAllpanties();
	}

	@Test 
	public void TC_ValidateProductReviewStarsOnAllPantiesInWomenCategory()
			throws Exception
	{ new
		CollectionPage(driver).validateproductreviewstarsonAllpanties(); }

	@Test
	public void TC_ValidateFiltersAndSortingOnAllPantiesInWomenCategory()
			throws Exception { new
		CollectionPage(driver).validatefilterandsortonAllpanties(); }

	@Test
	public void TC_ValidateStyleCarouselOnAllPantiesInWomenCategory()
			throws Exception { new
		CollectionPage(driver).validatestylecarouselonAllpanties(); }

	@Test
	public void TC_ValidateProductImageOnAllUnderwearInMenCategory() throws
	Exception { new CollectionPage(driver).validateproductimageonAllUnderwear();

	}

	@Test
	public void TC_ValidateProductNameOnAllUnderwearInMenCategory() throws
	Exception { new CollectionPage(driver).validateproductnameonAllUnderwear(); }

	@Test
	public void TC_ValidateProductReviewStarsOnAllUnderwearInMenCategory()
			throws Exception { new
		CollectionPage(driver).validateproductreviewstarsonAllUnderwear(); }

	@Test
	public void TC_ValidateFiltersAndSortingOnAllUnderwearInMenCategory()
			throws Exception { new
		CollectionPage(driver).validatefilterandsortonAllUnderwear(); }

	@Test
	public void TC_ValidateStyleCarouselOnAllUnderwearInMenCategory()
			throws Exception { new
		CollectionPage(driver).validatestylecarouselonAllUnderwear(); }

	@Test
	public void TC_ValidateProductImageOnAllUndershirtsInMenCategory()
			throws Exception { new
		CollectionPage(driver).validateproductimageonAllUndershirts();

	}

	@Test
	public void TC_ValidateProductNameOnAllUndershirtsInMenCategory()
			throws Exception { new
		CollectionPage(driver).validateproductnameonAllUndershirts(); }

	@Test
	public void TC_ValidateProductReviewStarsOnAllUndershirtsInMenCategory() throws Exception
	{ new CollectionPage(driver).validateproductreviewstarsonAllUndershirts(); }

//	@Test
//	public void TC_ValidateFiltersAndSortingOnAllUndershirtsInMenCategory()
//			throws Exception
//	{
//		new	CollectionPage(driver).validatefilterandsortonAllUndershirts(); }

	@Test
	public void TC_ValidateStyleCarouselOnAllUndershirtsInMenCategory()
			throws Exception
	{ new CollectionPage(driver).validatestylecarouselonAllUndershirts(); }

	@Test
	public void
	TC_ValidateProductImageOnAllWomensCollectioninWomenCategory() throws
	Exception { new
		CollectionPage(driver).validateproductimageonAllWomensCollection();

	}

	@Test
	public void
	TC_ValidateProductNameOnAllWomensCollectioninWomenCategory() throws Exception
	{ new CollectionPage(driver).validateproductnameonAllWomensCollection(); }

	@Test
	public void	TC_ValidateProductReviewStarsOnAllWomensCollectioninWomenCategory() throws
	Exception { 
		new	CollectionPage(driver).validateproductreviewstarsonAllWomensCollection(); }

	@Test
	public void	TC_ValidateFiltersAndSortingOnAllWomensCollectioninWomenCategory() throws
	Exception
	{ 
		new CollectionPage(driver).validatefilterandsortonAllWomensCollection(); 
	}

	@Test
	public void TC_ValidateColorSwatchOnAllPantiesInWomenCategory() throws
	Exception
	{
		new CollectionPage(driver).validateColorSwatcheonAllpanties();

	}
	@Test
	public void TC_ValidateColorSwatchOnAllUnderwear() throws
	Exception
	{
		new CollectionPage(driver).validateColorSwatcheonAllUnderwear();

	}
	
	@Test
	public void TC_ValidateColorSwatchOnAllUndershirts() throws
	Exception
	{
		new CollectionPage(driver).validateColorSwatcheonAllUndershirts();

	}
	@Test
	public void TC_ValidateColorSwatchOnAllWomenCollection() throws
	Exception
	{
		new CollectionPage(driver).validateColorSwatcheonAllWomensCollection();

	}


	@AfterMethod(alwaysRun = true)
	void teardown () {

		//driver.close();
		driver.quit();
	}

}
