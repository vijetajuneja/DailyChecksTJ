package com.tommyjohn.automation.Components;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.PageLocators.SizeGuideLocators;
import com.tommyjohn.automation.utils.CustomUtilities;




public class SizeGuideComponents extends SizeGuideLocators
{
	public WebDriver driver;
	public WebElement element;
	public Actions action;
	public JavascriptExecutor jse;
	Properties properties= com.tommyjohn.automation.utils.CustomUtilities.properties;
	List<WebElement> allElements;
	int elementsCount;
	public  static String prodsize;
	public static String productname;
	public  static String productsize;
	public  static String productcolor;
	public  static String productprice;
	public static String productquant;
	public String price;
	double installment;
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	String Table_Data;
	public SizeGuideComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	public void validateMenUnderwearSizeGuidePage() throws Exception {
		String text = null;

		// call method to navigate to collection page
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();

		// call method to navigate product details page
		text = navigateToProductDetailsPage();

		// call method for Size Guide validation
		validateMenUnderwearSizeGuide();
	}

	public void validateMenDressShirtSizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToButtonDownShirtInMenCategory();
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)");

		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			if(title.getText().contains("Shirt"))
			{
				//title.click();
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", title);
				break;
			}

		}

		validateMenDressShirtSizeGuide();
	}
	public void validateMenUnderShirtSizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToAllUnderShirtsInMensCategory();
		navigateToProductDetailsPage();
		validateMenUnderShirtSizeGuide();
	}
	public void validateMen_GoAnyWhere_SizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToButtonDownShirtInMenCategory();
		navigateToProductDetailsPage();
		validateMen_GoAnywhereShirt();
	}
	public void validateMen_StretchedWovenBottom_SizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToBottomInMensCategory();
		navigateToMensBottom();
		validateMen_StrtchedWovenBottom();
	}
	public void validateWomenUnderwearSizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToAllPantiesInWomenCategory();
		navigateToProductDetailsPage();
		validateWomenUnderwearSizeGuide();
	}
	public void validateWomenUnderShirtSizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToCamisoleInwomensCategory();
		navigateToProductDetailsPage();
		validateWomenUnderShirtsSizeGuide();
	}
	public void validateWomenT_ShirtsSizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToTopsAndTeesInwomensCategory();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(CollectionPageComponent.FIRST_PRODUCT_HEAD_LINE_TEXT));
		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			if(!title.getText().contains("V-Neck Tee"))
			{
				title.click();
				break;
			}
		}
		validateWomenT_ShirtsSizeGuide();
	}
	public void validate_WomensTop_SizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToTopsAndTeesInwomensCategory();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(CollectionPageComponent.FIRST_PRODUCT_HEAD_LINE_TEXT));
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			System.out.println("Title is: " +title.getText());
			if(title.getText().contains("Tee"))
			{
				Thread.sleep(3000);
				title.click();
				break;
			}
		}
		validate_Womens_Top();
	}	
	public void validate_Womens_WovenBlazer_SizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToHoodiesandJacketsInwomensCategory();
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			if(title.getText().contains("Blazer"))
			{
				title.click();
				break;
			}

		}
		validate_Womens_Woven_Blazer();	
	}	
	public void validate_WomensBottom_SizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToPantsandShortsInwomensCategory();
		Thread.sleep(3000);
		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			if(title.getText().contains("Short"))
			{
				Thread.sleep(3000);
				title.click();
				break;
			}

		}
		validate_Womens_Bottoms();
	}	
	public void validate_pack_SizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).nevigateToAllMensPacksInPacksCategory();
		navigateToProductDetailsPage();
		validate_pack();
	}

	public void validateMen_StretchedWovenBlazer_SizeGuidePage() throws Exception
	{
		new HomePageComponents(driver).navigateToHoodiesandJacketsInMensCategory();
		navigatetoMensBlazer();
		validateMen_StrtchedWovenBlazer();
	}

	public void validateBraSizeGuidePage() throws Exception {

		navigateToBraPDP();
		Thread.sleep(4000);

		validateBraSizeGuide();

	}
	public void validateScoopBraletteSizeGuidePage() throws Exception
	{
		navigateToScoopBralettePDP();
		validateScoopBraletteSizeGuide();
	}

	public void validateTriangleBraletteSizeGuidePage() throws Exception
	{
		navigateToTriangleBralettePDP();
		validateTriangleBraletteSizeGuide();
	}

	public void validate_bundle_SizeGuidePage() throws Exception
	{
		validate_bundle();
	}

	public void validate_pack() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/collections/mens-underwear-packs/products/second-skin-boxer-brief-3-pack");
		new HomePageComponents(driver).navigateToAllWomensPacksInPacksCategory();

		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".product-meta__title")).click();
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Pack size guide link is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

	}

	public void validate_bundle() throws Exception
	{
		navigateToBundlePDP();
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		//validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Bundle product's First size guide link is Displayed :: Clickable");
		//Close first size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

		Thread.sleep(3000);

		//second size guide validation
		if(!driver.findElement(BUNDLE_SECOND_SIZE_GUIDE_BUTTON).isEnabled())
			throw new Exception("In bundle product Second Size Guide button is not present");
		WebElement ele2 = driver.findElement(BUNDLE_SECOND_SIZE_GUIDE_BUTTON);
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", ele2);
		Thread.sleep(3000);

		if(!driver.findElement(SECOND_SIZE_GUIDE_TITLE).isDisplayed()) 
			throw new Exception("Product's second size guide title is not displayed");

		// validation for fit-meter section
		if(!driver.findElement(SECOND_SIZE_GUIDE_FITMETER_TITLE).isDisplayed())
			throw new Exception("Product's second size guide fit-meter title is not displayed");
		String Review_status_In_PDP = driver.findElement(CUSTOMER_REVIEW_STATUS_TEXT).getText();
		try {
			String Review_status_In_SizeGuide = driver.findElement(SECOND_SIZE_GUIDE_CUSTOMER_SAY_REVIEW_TEXT).getText();

			//If product have some reviews
			if(!Review_status_In_PDP.equals("")){
				System.out.println("Review Status title is " +Review_status_In_PDP);
				if(!Review_status_In_PDP.equalsIgnoreCase(Review_status_In_SizeGuide))
					throw new Exception("Customer Say" +Review_status_In_SizeGuide+ " is not equal to " +Review_status_In_PDP);}

			// If product have no reviews
			else{
				String P_Title = driver.findElement(PRODUCT_TITLE).getText();
				System.out.println(P_Title+" have no reviews yet.");
			}
		}
		catch (Exception e)
		{
			Reporter.log("Rating meter shows - No ratings Yet");
		}
		driver.findElement(SECOND_SIZE_GUIDE_FITMETER_TITLE).click();
		jse = (JavascriptExecutor)driver;

		//scroll down to fit-meter
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SECOND_SIZE_GUIDE_FITMETER_GRAPH));
		if(!driver.findElement(SECOND_SIZE_GUIDE_FITMETER_GRAPH).isDisplayed())
			throw new Exception("Product's second size guide fit-meter is not displayed");

		// validations for size chart table
		if(!driver.findElement(SECOND_SIZE_GUIDE_CHART_TABLE).isDisplayed())
			throw new Exception("Product size chart table is not displayed in second size guide");
		else{
			WebElement CHART_TABLE=driver.findElement(SECOND_SIZE_GUIDE_CHART_TABLE);
			List <WebElement> Row_Table=CHART_TABLE.findElements(By.tagName("tr"));
			int Row_Count= Row_Table.size();
			for(int i=0;i<Row_Count;i++)
			{
				//To locate columns of specific row
				List <WebElement> Column_Row=Row_Table.get(i).findElements(By.tagName("td"));
				for(int j=0;j<Column_Row.size();j++)
				{
					Table_Data=Column_Row.get(j).getText();
					if(Table_Data.equals(null))
						throw new Exception("Product size chart table have null value in second size guide");
				}
				System.out.println("Table Values are: " +Table_Data);
			}
		}


		/*CommonContentsInAllSizeGuide();
		validate_SizeGuideInstructions();*/
		/*
		 * Thread.sleep(3000); if (!driver.findElement(By.
		 * cssSelector("div.product-details.product-details--fit.container.active > div:nth-child(2) > div:nth-child(2) > div.generic-size-guide"
		 * )).isDisplayed()) throw new
		 * Exception("Sizes chart overlay is not displayed after Size guide button was clicked"
		 * );
		 */
		Reporter.log("Bundle product's Second size guide link is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(CLOSE_BTN).click();
	}


	public void validateMenUnderwearSizeGuide() throws Exception
	{
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Men's Underwear Size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();
	}

	public void validateWomenUnderwearSizeGuide() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/collections/womens-second-skin-brief/?color=winetasting");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Women's Underwear size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();
	}

	public void validateWomenUnderShirtsSizeGuide() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/collections/womens-camisoles/products/womens-cool-cotton-stay-tucked-camisole?color=oatmeal-heather");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Women's Under Shirt size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();
	}

	public void validateWomenT_ShirtsSizeGuide() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/products/womens-second-skin-crew-neck-graphic-tee-ballsy-large-logo");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Women's T-Shirt size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

	}

	public void validateBraSizeGuide() throws Exception
	{
		Open_SizeGuide();
		Thread.sleep(3000);
		//CommonContentsInSizeGuide();
		common_content_InBraSizeGuide();
		String text=driver.findElement(FIND_YOUR_SIZE_TEXT).getText();
		System.out.println("Title is::"+text);
		if(!text.equalsIgnoreCase("Find Your Bra Size"))
			throw new Exception("Text change for 'Find your bra size'");

		//Bra Size Guide Chart Table Validations	
		if(!driver.findElement(SIZE_GUIDE_CHART_TABLE).isDisplayed())
			throw new Exception("Size Chart table is not displayed.");
		WebElement cup_size_inches_text= driver.findElement(CUP_SIZE_INCHES_TEXT);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(SIZE_GUIDE_CHART_TABLE));
		Thread.sleep(3000);
		System.out.println(cup_size_inches_text.getText());
		if(!driver.findElement(CUP_SIZE_INCHES_TEXT).getText().equalsIgnoreCase("Cup Size/Full Bust Circumference (Inches)"))
			throw new Exception("Text changed for 'Cup Size/Full Bust Circumference (Inches)'");
		if(!driver.findElement(BAND_SIZE_INCHES_TEXT).getText().equalsIgnoreCase("Band Size/Underbust Circumference (Inches)"))
			throw new Exception("Text changed for 'Band Size/Underbust Circumference (Inches)'");

		Reporter.log("Women's Bra size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();


	}

	public void validateTriangleBraletteSizeGuide() throws Exception
	{
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		String text=driver.findElement(FIND_YOUR_SIZE_TEXT).getText();
		System.out.println("Title is::"+text);
		if(!text.equalsIgnoreCase("Find Your Size"))
			throw new Exception("Text change for 'Find Your Size'");
		common_content_InBraSizeGuide();

		Reporter.log("Women's Bralette size guide is Displayed :: Clickable");
		//Close size guide window
		//	driver.findElement(By.cssSelector(".close_chart_modal")).click();
		WebElement el = driver.findElement(By.cssSelector(".close_chart_modal"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", el);
	}

	public void validateScoopBraletteSizeGuide() throws Exception
	{
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		String text=driver.findElement(FIND_YOUR_SIZE_TEXT).getText();
		System.out.println("Title is::"+text);
		if(!text.equalsIgnoreCase("Find Your Bralette Size"))
			throw new Exception("Text change for 'Find Your Size'");
		common_content_InBraSizeGuide();

		Reporter.log("Women's Bralette size guide is Displayed :: Clickable");
		//Close size guide window
		//	driver.findElement(By.cssSelector(".close_chart_modal")).click();
		WebElement el = driver.findElement(By.cssSelector(".close_chart_modal"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", el);
	}

	public void validate_Womens_Top() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/collections/womens-tees-polos/products/womens-go-anywhere-quick-dry-relaxed-v-neck-tee");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		common_contents_of_ApparelSizeGuide();
		//validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Women's Top size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

	}

	public void validate_Womens_Woven_Blazer() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/collections/womens-hoodies-jackets/products/womens-stretch-woven-blazer");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		common_contents_of_ApparelSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Women's Woven Blazer size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

	}

	public void validate_Womens_Bottoms() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/collections/womens-pants-shorts/products/womens-go-anywhere-lightweight-performance-pant");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		common_contents_of_ApparelSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Women's Bottoms size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

	}

	public void validateMenDressShirtSizeGuide() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/products/slim-fit-print-stay-tucked-dress-shirt");

		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Men's Dress Shirt size guide is Displayed :: Clickable");

		//Close size guide window
		WebElement close=driver.findElement(By.cssSelector(".close_chart_modal"));
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",close);

		
	}

	public void validateMenUnderShirtSizeGuide() throws Exception
	{
		//driver.navigate().to("https://tommyjohn.com/products/second-skin-crew-neck-stay-tucked-undershirt-2-0");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		CommonContentsInAllSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Men's Under Shirt size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();
	}

	public void validateMen_GoAnywhereShirt() throws Exception  
	{
		//driver.navigate().to("https://tommyjohn.com/products/go-anywhere-un-tucked-shirt");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		common_contents_of_ApparelSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Men's Go AnyWhere Shirt size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

	}

	public void validateMen_StrtchedWovenBottom() throws Exception  
	{
		//driver.navigate().to("https://tommyjohn.com/products/go-anywhere-everyday-tech-pant");
		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		common_contents_of_ApparelSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Men's Stretched Woven Bottom size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

	}

	public void validateMen_StrtchedWovenBlazer() throws Exception  
	{
		//driver.navigate().to("https://tommyjohn.com/products/go-anywhere-everyday-tech-blazer");

		Thread.sleep(3000);
		Open_SizeGuide();
		Thread.sleep(3000);
		common_contents_of_ApparelSizeGuide();
		validate_SizeGuideInstructions();
		Thread.sleep(3000);
		if (!driver.findElement(By.cssSelector(".size-chart-content")).isDisplayed())
			throw new Exception("Sizes chart overlay is not displayed after Size guide button was clicked");
		Reporter.log("Men's Stretched Woven Blazer size guide is Displayed :: Clickable");

		//Close size guide window
		driver.findElement(By.cssSelector(".close_chart_modal")).click();

	}

	public void Open_SizeGuide() throws Exception
	{

		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.presenceOfElementLocated(ProductDetailsPageLocators.SIZE_GUIDE_BUTTON));	
		if(!driver.findElement(SIZEGUIDE).isEnabled())
			throw new Exception("Size Guide button is not present");
		WebElement ele = driver.findElement(SIZEGUIDE);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);

	}

	public void common_content_InBraSizeGuide() throws Exception
	{
		//validate Bra size guide title	
		if(!driver.findElement(SIZE_GUIDE_TITLE).isDisplayed())
			throw new Exception("Product size guide title is not displayed");
		//validate fit-meter section
		if(!driver.findElement(SIZE_GUIDE_FITMETER_TITLE).isDisplayed())
			throw new Exception("Product size guide fit-meter title is not displayed");
		String Review_status_In_PDP = driver.findElement(CUSTOMER_REVIEW_STATUS_TEXT).getText();

		String Review_status_In_SizeGuide = driver.findElement(SIZE_GUIDE_CUSTOMER_SAY_REVIEW_TEXT).getText();
		//If product have some reviews
		if(!Review_status_In_PDP.equals("")){
			System.out.println("Review Status title is " +Review_status_In_PDP);
			if(!Review_status_In_PDP.equalsIgnoreCase(Review_status_In_SizeGuide))
				throw new Exception("Size Guide Fit-meter Customer Say " +Review_status_In_SizeGuide+ " is not equal to PDP Review status " +Review_status_In_PDP);}
		// If product have no reviews
		else{
			String P_Title = driver.findElement(PRODUCT_TITLE).getText();
			System.out.println(P_Title+" have no reviews yet.");
		}
		if(!driver.findElement(SIZE_GUIDE_FITMETER_GRAPH).isDisplayed())
			throw new Exception("Product size guide fit-meter is not displayed");
		if (!driver.findElement(FIND_YOUR_SIZE_TEXT).isDisplayed())
			throw new Exception("Find your bra size text guide is not displayed");


		// Bra Band Size Drop-Down Validations
		if(!driver.findElement(BRA_BAND_SIZE_DROPDOWN).isEnabled())
		{
			throw new Exception("Band Size Drop-Down is not enable.");
		}
		else {
			Select BandSize_DropDown = new Select(driver.findElement(BRA_BAND_SIZE_DROPDOWN));
			List<WebElement> BandSize_Options = BandSize_DropDown.getOptions();
			int BandSize_Options_Count = BandSize_Options.size();
			System.out.println("All Band Sizes list :: "+ BandSize_Options_Count);

			String BandSize_Default_Text = BandSize_Options.get(0).getText();
			if(!BandSize_Default_Text.equalsIgnoreCase("Band Size"))
				throw new Exception("Text change for 'Band Size'");
			for(int i=1;i<BandSize_Options_Count;i++) {
				driver.findElement(By.cssSelector(".size-guide-size-finder-dropdowns.visible>span:nth-child(1)")).click();
				WebElement element = BandSize_Options.get(i);
				element.click();
			}
		}

		// Cup Size Drop-Down Validations
		if(!driver.findElement(BRA_CUP_VOLUME_DROPDOWN).isEnabled())
		{
			throw new Exception("Cup Volume/Size Drop-Down is not enable.");
		}
		else {
			Select CupVolume_DropDown = new Select(driver.findElement(BRA_CUP_VOLUME_DROPDOWN));
			List<WebElement> CupVolume_Options = CupVolume_DropDown.getOptions();
			int CupVolume_Options_Count = CupVolume_Options.size();
			System.out.println("All Band Sizes list :: "+ CupVolume_Options_Count);

			//	String Product_Title = driver.findElement(PRODUCT_TITLE).getText();


			String CupVolume_Default_Text = CupVolume_Options.get(0).getText();
			//	if(Product_Title.contains("Bralette")){
			//	if(!CupVolume_Default_Text.equalsIgnoreCase("Cup Size"))
			//	throw new Exception("Text change for 'Cup Size'");
			//	}
			//	else{
			if(!CupVolume_Default_Text.equalsIgnoreCase("Cup Size"))
				throw new Exception("Text change for 'Cup Size'");
			//		}

			for(int i=1;i<CupVolume_Options_Count;i++) {
				WebElement ele = driver.findElement(By.cssSelector(".size-guide-size-finder-dropdowns.visible>span:nth-child(2)"));
				jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click();", ele);					
				WebElement element = CupVolume_Options.get(i);
				element.click();
			}
			Thread.sleep(3000);

			WebElement ele = driver.findElement(FIND_SIZE_BUTTON);
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", ele);					
			/*
			 * 
			 * if(driver.findElement(FIND_SIZE_BUTTON).isDisplayed())
			 * driver.findElement(FIND_SIZE_BUTTON).click();
			 */		
			if(!driver.findElement(CALCULATED_SIZE_RESULT).isDisplayed())
				throw new Exception("Calculated Size Result is not displayed.");
			if(!driver.findElement(FIND_SIZE_BUTTON).getText().equalsIgnoreCase("Edit Size"))
				throw new Exception("Button text should change from 'Find Size' to 'Edit Size'");		
		}
		//Scroll Down		

		// How To Measure Accordion Validations		
		if(!driver.findElement(HOW_TO_MEASURE_TEXT).getText().equalsIgnoreCase("How To Measure"))
			throw new Exception("Text Change for 'HOW To Measure'");
		Thread.sleep(3000);
		if(!driver.findElement(HOW_TO_MEASURE_ACCORDION).getAttribute("class").contains("expanded"))
		{
			driver.findElement(HOW_TO_MEASURE_TEXT).click();
			System.out.println("On load 'How To Measure' accordion was not opened,Now its expanded.");
		}

		if(!driver.findElement(BRA_SIZE_GUIDE_INSTRUCTION_CONTENT).isDisplayed())
			throw new Exception("Bra Size Guide Instruction Content is not displayed.");
		//		if(!driver.findElement(WATCH_NOW_BUTTON).isDisplayed()){
		//			throw new Exception("'Watch Now' button is not displayed.");}
		//		else {
		//			if(!driver.findElement(WATCH_NOW_BUTTON).getText().equalsIgnoreCase("Watch Now"))
		//				throw new Exception("Text changed for 'Watch Now' button.");
		//			driver.findElement(WATCH_NOW_BUTTON).click();
		//			if(!driver.findElement(INSTRUCTIONAL_VIDEO).isDisplayed())
		//				throw new Exception("Instructional video is not displayed.");
		//			if(!driver.findElement(WATCH_NOW_BUTTON).getText().equalsIgnoreCase("Pause"))
		//				throw new Exception("Button text should change from 'Watch Now' to 'Pause' ");
		//		}
	}

	public void CommonContentsInAllSizeGuide() throws Exception
	{
		// validation for Size guide title	
		if(!driver.findElement(SIZE_GUIDE_TITLE).isDisplayed())
			throw new Exception("Product size guide title is not displayed");

		// validation for fit-meter section
		if(!driver.findElement(SIZE_GUIDE_FITMETER_TITLE).isDisplayed())
			throw new Exception("Product size guide fit-meter title is not displayed");
		String Review_status_In_PDP = driver.findElement(CUSTOMER_REVIEW_STATUS_TEXT).getText();
		Thread.sleep(2000);
		try {
			String Review_status_In_SizeGuide = driver.findElement(SIZE_GUIDE_CUSTOMER_SAY_REVIEW_TEXT).getText();

			//If product have some reviews
			if(!Review_status_In_PDP.equals("")){
				System.out.println("Review Status title is " +Review_status_In_PDP);
				if(!Review_status_In_PDP.equalsIgnoreCase(Review_status_In_SizeGuide))
					throw new Exception("Customer Say" +Review_status_In_SizeGuide+ " is not equal to " +Review_status_In_PDP);}



			// If product have no reviews
			else{
				String P_Title = driver.findElement(PRODUCT_TITLE).getText();
				System.out.println(P_Title+" have no reviews yet.");
			}
		}
		catch (Exception e){
			Reporter.log("Rating meter shows - No ratings Yet");
		}
		//driver.findElement(SIZE_GUIDE_FITMETER_TITLE).click();
		jse = (JavascriptExecutor)driver;

		//scroll down to fit-meter
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SIZE_GUIDE_FITMETER_GRAPH));
		if(!driver.findElement(SIZE_GUIDE_FITMETER_GRAPH).isDisplayed())
			throw new Exception("Product size guide fit-meter is not displayed");

		// validations for size chart
		if(!driver.findElement(SIZE_GUIDE_CHART_TABLE).isDisplayed())
			throw new Exception("Product size chart table is not displayed");
		else{
			WebElement CHART_TABLE=driver.findElement(By.tagName("table"));
			List <WebElement> Row_Table=CHART_TABLE.findElements(By.tagName("tr"));
			int Row_Count= Row_Table.size();
			for(int i=0;i<Row_Count;i++)
			{
				//To locate columns of specific row
				List <WebElement> Column_Row=Row_Table.get(i).findElements(By.tagName("td"));
				for(int j=0;j<Column_Row.size();j++)
				{
					Table_Data=Column_Row.get(j).getText();
					if(Table_Data.equals(null))
						throw new Exception("Product size chart table have null value");
				}
				System.out.println("Table Values are: " +Table_Data);
			}
		}
	}

	public void New_common_contents_InAllSizeGuide()
	{
		WebElement Size_Guide_overlay= driver.findElement(By.cssSelector("div[class=size-chart-overlay][style='display: flex;']"));

	}


	public void common_contents_of_ApparelSizeGuide() throws Exception
	{
		// validation for Size guide title	
		if(!driver.findElement(SIZE_GUIDE_TITLE).isDisplayed())
			throw new Exception("Product size guide title is not displayed");

		// validation for fit-meter section
		if(!driver.findElement(SIZE_GUIDE_FITMETER_TITLE).isDisplayed())
			throw new Exception("Product size guide fit-meter title is not displayed");
		String Review_status_In_PDP = driver.findElement(CUSTOMER_REVIEW_STATUS_TEXT).getText();

		//If product have some reviews
		if(!Review_status_In_PDP.equals("")){
			String Review_status_In_SizeGuide = driver.findElement(SIZE_GUIDE_CUSTOMER_SAY_REVIEW_TEXT).getText();
			System.out.println("Review Status title is " +Review_status_In_PDP+ " of product");	
			if(!Review_status_In_PDP.equalsIgnoreCase(Review_status_In_SizeGuide))
				throw new Exception("Customer Say" +Review_status_In_SizeGuide+ " is not equal to " +Review_status_In_PDP);}
		// If product have no reviews
		else{
			String P_Title= driver.findElement(PRODUCT_TITLE).getText();
			System.out.println(P_Title+" have no reviews yet.");
		}
		driver.findElement(SIZE_GUIDE_FITMETER_TITLE).click();
		jse = (JavascriptExecutor)driver;

		//scroll down to fit-meter
		jse.executeScript("window.scrollBy(0,-250)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SIZE_GUIDE_FITMETER_GRAPH));
		if(!driver.findElement(SIZE_GUIDE_FITMETER_GRAPH).isDisplayed())
			throw new Exception("Product size guide fit-meter is not displayed");

		// validations for size chart
		if(!driver.findElement(SIZE_GUIDE_CHART_TABLE).isDisplayed())
			throw new Exception("Product size chart table is not displayed");
		else{
			WebElement CHART_TABLE=driver.findElement(By.tagName("table"));
			List <WebElement> Row_Table=CHART_TABLE.findElements(By.tagName("tr"));
			int Row_Count= Row_Table.size();
			for(int i=0;i<Row_Count;i++)
			{
				//To locate columns of specific row
				List <WebElement> Column_Row=Row_Table.get(i).findElements(By.tagName("td"));
				for(int j=0;j<Column_Row.size();j++)
				{
					Table_Data=Column_Row.get(j).getText();
					if(Table_Data.equals(null))
						throw new Exception("Product size chart table have null value");
				}
				System.out.println("Table Values are: " +Table_Data);
			}
		}	
	}

	public void validate_SizeGuideInstructions() throws Exception
	{
		Thread.sleep(3000);
		if(!driver.findElement(SIZE_GUIDE_INSTRUCTION_CONTENT).isDisplayed())
			throw new Exception("Product size guide instruction content is not displayed");
	}

	/*
	 * public void navigateToAllUnderwearInMenCategory() throws Exception { action =
	 * new Actions(driver); element = driver.findElement(MEN_CATEGORY);
	 * action.moveToElement(element).perform();
	 * 
	 * driver.findElement(ALL_UNDERWEAR_IN_MEN_CATEGORY).click();
	 * Thread.sleep(3000); Reporter.log(driver.getCurrentUrl()); }
	 */

	public String navigateToProductDetailsPage() throws Exception {
		String text = null;
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(THIRD_PRODUCT_HEAD_LINE_TEXT));
		// get text and click on the first product
		if(!driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).isDisplayed())
			throw new Exception("Product head line text is not displayed");
		text = driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT).getText();
		element=driver.findElement(THIRD_PRODUCT_HEAD_LINE_TEXT);
		jse.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		Reporter.log(driver.getCurrentUrl());
		return text;
	}

	//	public String navigateToBraPage() throws Exception
	//	{
	//		String text = null;
	//		driver.navigate().to(CustomUtilities.baseUrl);
	//		Thread.sleep(3000);
	//		driver.findElement(BRA).click();
	//		Thread.sleep(3000);
	//		driver.findElement(FIRST_ANCHOR_BUTTON).click();
	//		WebDriverWait wait = new WebDriverWait(driver, 30);
	//		wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_BRA_PRODUCT_HEAD_LINE_TEXT_LINK));
	//		// get text and click on the first product
	//		if(!driver.findElement(FIRST_BRA_PRODUCT_HEAD_LINE_TEXT_LINK).isDisplayed())
	//			throw new Exception("First Bra Product head line text is not displayed");
	//		text = driver.findElement(FIRST_BRA_PRODUCT_HEAD_LINE_TEXT_LINK).getText();
	//		driver.findElement(FIRST_BRA_PRODUCT_HEAD_LINE_TEXT_LINK).click();
	//		Thread.sleep(3000);
	//		Reporter.log(driver.getCurrentUrl());
	//		return text;
	//
	//	}

	public void navigateToTriangleBralettePDP() throws Exception 
	{

		new HomePageComponents(driver).navigateToTriangleBraletteCategory();
		Thread.sleep(3000);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(5000);
		/*
		 * List<WebElement> producttitle =
		 * driver.findElements(By.cssSelector(".product-meta__title")); for (WebElement
		 * title : producttitle) { if(title.getText().endsWith("Triangle Bralette")) {
		 * title.click(); // executor.executeScript("arguments[0].click();", title);
		 * break; }
		 * 
		 * }
		 */

		element= driver.findElement(By.cssSelector(".product-meta__title"));
		System.out.println("Triangle Bralette title is: "+element.getText());
		element.click();
		Thread.sleep(5000);
	}

	public void navigateToScoopBralettePDP() throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		new HomePageComponents(driver).navigateToScoopBraletteCategory();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".collection-title-bar__title")));
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		/*
		 * List<WebElement> producttitle =
		 * driver.findElements(By.cssSelector(".product-meta__title")); for (WebElement
		 * title : producttitle) { if(title.getText().endsWith("Scoop Bralette")) {
		 * title.click(); //executor.executeScript("arguments[0].click();", title);
		 * break; }
		 * 
		 * }
		 */
		element= driver.findElement(By.cssSelector(".product-meta__title"));
		System.out.println("Scoop Bralette title is: "+element.getText());
		element.click();
		Thread.sleep(5000);

	}

	public void navigateToBraPDP() throws Exception 
	{

		new HomePageComponents(driver).navigateToBraCategory();
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,550)");

		Thread.sleep(4000);

		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			if(title.getText().endsWith("Bra"))
			{
				Thread.sleep(3000);
				System.out.println(title.getText());
jse.executeScript("arguments[0].click();", title);
				//title.click();

				break;
			}
		}
	}

	public void navigateToBundlePDP() throws Exception 
	{

		new HomePageComponents(driver).navigateToLoungeWearPacksInWomenPacksCategory();
		Thread.sleep(4000);

		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(4000);

		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));

		for (WebElement title : producttitle)
		{
			System.out.println("product title is: "+title.getText());
			if(title.getText().contains("Lounge Set"))
			{
				Thread.sleep(3000);
				System.out.println(title.getText());
				title.click();
				break;
			}
		}
	}

	public void navigateToMensBottom() throws Exception 
	{
		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			System.out.println("product title is :"+title.getText());
			if(title.getText().contains("Pant"))
			{
				Thread.sleep(3000);
				System.out.println(title.getText());

				title.click();
				break;
			}

		}
	}
	public void navigatetoMensBlazer() throws Exception 
	{

		List<WebElement> producttitle = driver.findElements(By.cssSelector(".product-meta__title"));
		for (WebElement title : producttitle)
		{
			if(title.getText().contains("Blazer"))
			{
				Thread.sleep(3000);
				System.out.println(title.getText());

				title.click();

				break;
			}
		}
	}

}
