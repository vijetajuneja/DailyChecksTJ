package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tommyjohn.automation.Pages.ShoppingCartPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateShoppingCart {
	
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
	public void ValidateEmptyShoppingCart() throws Exception
	{
		new ShoppingCartPage(driver).ValidateEmptyCart();
	}
	
	@Test
	public void ValidateAddingAndRemovingProductsFromCart() throws Exception
	{
		new ShoppingCartPage(driver).ValidateAddRemoveProducts();
	}
	
	@Test
	public void ValidateCartWhenProductsArePresent() throws Exception
	{
		new ShoppingCartPage(driver).ValidateShoppingCartWithProducts();
	}
	
	@Test
	public void ValidateCheckoutIsFunctionalFromCart() throws Exception
	{
		new ShoppingCartPage(driver).verifyCheckoutfromCart();
	}
	
	@Test
	public void ValidateCorrectProductIsAddedToCart() throws Exception
	{
		new ShoppingCartPage(driver).verifyproductinCart();
	}
	
	@Test
	public void ValidatePromoCodeOnCartPage() throws Exception
	{
		new ShoppingCartPage(driver).VerifyPromoCodeOnCart();
	}
	@AfterMethod(alwaysRun = true)
	void tearDown() {

		//this.driver.close();
		this.driver.quit();

	}

}
