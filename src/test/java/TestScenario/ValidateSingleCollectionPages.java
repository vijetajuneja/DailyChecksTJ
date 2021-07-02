package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.CollectionPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateSingleCollectionPages {
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
	public void TC_ValidateProductImageOnSecondSkinInMenCategory() throws
	Exception { new CollectionPage(driver).validateproductimageonOnSecondSkin();
	}

	@Test
	public void TC_ValidateProductNameOnSecondSkinInMenCategory() throws
	Exception { new CollectionPage(driver).validateproductnameonOnSecondSkin(); }

	@Test
	public void TC_ValidateProductReviewStarsOnSecondSkinInMenCategory()
			throws Exception { new
		CollectionPage(driver).validateproductreviewstarsonOnSecondSkin(); }

	@Test
	public void TC_ValidateFiltersAndSortingOnSecondSkinInMenCategory()
			throws Exception { new
		CollectionPage(driver).validatefilterandsortonOnSecondSkin(); }

	@Test
	public void TC_ValidateProductImageOnCoolCottonInMenCategory() throws
	Exception { new CollectionPage(driver).validateproductimageonOnCoolCotton();
	}

	@Test
	public void TC_ValidateProductNameOnCoolCottonInMenCategory() throws
	Exception { new CollectionPage(driver).validateproductnameonOnCoolCotton(); }

	@Test
	public void TC_ValidateProductReviewStarsOnCoolCottonInMenCategory()
			throws Exception { new
		CollectionPage(driver).validateproductreviewstarsonOnCoolCotton(); }

	@Test
	public void TC_ValidateFiltersAndSortingOnCoolCottonInMenCategory()
			throws Exception { new
		CollectionPage(driver).validatefilterandsortonOnCoolCotton(); }


	@Test
	public void TC_ValidateProductImageOnCottonBasicsInShopByCollectionsCategory() throws
	Exception { new
		CollectionPage(driver).validateproductimageonOnCottonBasics(); }

	@Test
	public void TC_ValidateProductNameOnCottonBasicsInShopByCollectionsCategory() throws
	Exception { new CollectionPage(driver).validateproductnameonOnCottonBasics();
	}

	@Test
	public void TC_ValidateProductReviewStarsOnCottonBasicsInShopByCollectionsCategory()
			throws Exception { new
		CollectionPage(driver).validateproductreviewstarsonOnCottonBasics(); }

	@Test 
	public void TC_ValidateFiltersAndSortingOnCottonBasicsInShopByCollectionsCategory()
			throws Exception { new
		CollectionPage(driver).validatefilterandsortonOnCottonBasics(); }

	@Test
	public void TC_ValidateProductImageOnAllWomensPacksInPacksCategory()
			throws Exception { new
		CollectionPage(driver).validateproductimageonOnPacks(); }

	@Test
	public void TC_ValidateProductNameOnAllWomensPacksInPacksCategory()
			throws Exception { new CollectionPage(driver).validateproductnameonOnPacks();
	}

	@Test
	public void TC_ValidateProductReviewStarsOnAllWomensPacksInPacksCategory() throws
	Exception { new CollectionPage(driver).validateproductreviewstarsonOnPacks();
	}

	@Test
	public void TC_ValidateFiltersAndSortingOnAllWomensPacksInPacksCategory() throws
	Exception { new CollectionPage(driver).validatefilterandsortonOnPacks(); }

	@Test
	public void TC_ValidateColorSwatchOnSecondSkin() throws Exception 
	{
		new CollectionPage(driver).validateColorSwatcheonSecondSkin();
	}
	@Test
	public void TC_ValidateColorSwatchOnCoolCotton() throws Exception
	{
		new CollectionPage(driver).validateColorSwatcheonCoolCotton();
	}
	@Test
	public void TC_ValidateColorSwatchOnCottonBasics() throws Exception
	{
		new CollectionPage(driver).validateColorSwatcheonCottonBasics();
	}

	@AfterMethod(alwaysRun = true)
	void teardown () {

		//driver.close();
		driver.quit();
	}

}

