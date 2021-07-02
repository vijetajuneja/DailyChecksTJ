package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.SizeGuidePage;
import com.tommyjohn.automation.utils.CustomUtilities;



public class ValidateSizeGuide
{
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

	@Test(priority=0)
	public void TC_verifyMenUnderwearSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyMenUnderwearSizeGuidePage();
	}
	@Test(priority=1)
	public void TC_verifyMenDressShirtSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyMenDressShirtSizeGuidePage();
	}
	@Test(priority=2)
	public void TC_verifyMenUnderShirtSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyMenUnderShirtSizeGuidePage();
	}
	@Test(priority=3)
	public void TC_verifyMen_GoAnyWhereShirt_SizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyMen_GoAnywhereShirt_SizeGuidePage();
	}
	@Test(priority=4)
	public void TC_verifyMen_StretchedWovenBottom_SizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyMen_StretchedWovenBottom_SizeGuidePage();
	}
	@Test(priority=5)
	public void TC_verifyMen_StretchedWovenBlazer_SizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyMen_StretchedWovenBlazer_SizeGuidePage();
	}
	@Test(priority=6)
	public void TC_verifyWomenUnderwearSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyWomenUnderwearSizeGuidePage();
	}
	@Test(priority=7)
	public void TC_verifyWomenUnderShirtSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyWomenUnderShirtSizeGuidePage();
	}
	@Test(priority=8)
	public void TC_verifyWomenT_ShirtSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyWomenT_ShirtSizeGuidePage();
	}
	@Test(priority=9)
	public void TC_verifyBraSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verifyBraSizeGuidePage();
	}
	@Test(priority=10)
	public void TC_verifyScoopBraletteSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).validateScoopBraletteSizeGuidePage();
	}

	@Test(priority=10)
	public void TC_verifyTriangleBraletteSizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).validateTriangleBraletteSizeGuidePage();
	}

	@Test(priority=11)
	public void TC_verifyWomensTop_SizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verify_WomensTop_SizeGuidePage();
	}

	//Women blazer product is not live
	/*
	 * @Test(priority=12) public void TC_verifyWomens_WovenBlazer_SizeGuidePage()
	 * throws Exception { new
	 * SizeGuidePage(driver).verify_Womens_WovenBlazer_SizeGuidePage(); }
	 */	
	@Test(priority=13)
	public void TC_verifyWomensBottom_SizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verify_WomensBottoms_SizeGuidePage();
	}
	@Test(priority=14)
	public void TC_verifyPack_SizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verify_Packs_SizeGuidePage();
	}
	@Test(priority=15)
	public void TC_verifyBundle_SizeGuidePage() throws Exception {	
		new SizeGuidePage(driver).verify_Bundle_SizeGuidePage();
	}

	@AfterMethod(alwaysRun = true)
	void teardown () {

	//	driver.close();
		driver.quit();
	}
}

