package com.tommyjohn.automation.Components;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.tommyjohn.automation.PageLocators.AddToCartLocators;
import com.tommyjohn.automation.PageLocators.ProductDetailsPageLocators;
import com.tommyjohn.automation.utils.CustomUtilities;

public class AddToCartComponents extends AddToCartLocators{

	public AddToCartComponents(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;
	public WebElement element;
	public Actions action;
	public JavascriptExecutor jse;
	Properties properties = CustomUtilities.properties;
	List<WebElement> allElements;
	int elementsCount;

	String allClasses = null;
	public String addToCart() throws Exception {
		String text = null;

		// navigate to any product collection page
		new HomePageComponents(driver).navigateToAllUnderwearInMenCategory();

		// call method to navigate product details page
		text = new CollectionPageComponent(driver).navigateToProductDetailsPage();

		// call method to check correct PDP opened or not
		//new ProductDetailsPageComponents(driver).checkCorrectProductDetailsPageOpenedOrNot(text);
		// select size and add product to cart
		selectSize();
		 atc();
		return text;
	}

	public void selectSize() throws Exception {
		
		Thread.sleep(9000);
		// Select first size between available sizes
		        String text1= null;
				allElements = driver.findElements(ALL_SIZE_LIST);
				elementsCount = allElements.size();
				System.out.println("All sizes list :: "+ elementsCount);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
					    
			    try {
				if(driver.findElement(By.cssSelector("div.radio-options-container")).isDisplayed())
				{

					//radio			
					for(int i=3;i<=elementsCount;i=i+2) {
						boolean flag = false;
						element = driver.findElement(By.cssSelector(".radio-options-container > .Size > label:nth-child("+i+")"));
						if (element.getAttribute("class").contains("oosVariant")) {
							{
								if(!driver.findElement(ProductDetailsPageComponents.PRODUCT_TITLE).getText().contains("Pack"))
								{

									Thread.sleep(3000);
									jse = (JavascriptExecutor)driver;
									jse.executeScript("arguments[0].click();", element);
									//element.click();
									Thread.sleep(4000);

									System.out.println("Unavailable size clicked");
									element = driver.findElement(ProductDetailsPageComponents.JOIN_THE_WAITLIST);
									text1 = element.getText();
									System.out.println("Text of button when Unavailable size selected :: "+text1);
									if(!(text1.equalsIgnoreCase("JOIN THE WAITLIST")))
										throw new Exception("Text change for 'JOIN THE WAITLIST' ");

									flag = true;

								}
								else 
								{

									WebElement el = driver.findElement(By.cssSelector("div.radios-wrapper > div.radio-options-container > div > label:nth-child("+i+")"));
									jse = (JavascriptExecutor)driver;
									jse.executeScript("arguments[0].click();", el);

									System.out.println("Unavailable size clicked");
									System.out.println(driver.findElement(ADD_TO_CART_BUTTON).getText());
									if (!driver.findElement(ADD_TO_CART_BUTTON).getText().contentEquals("Out of Stock"))
									{
										element = driver.findElement(ProductDetailsPageComponents.JOIN_THE_WAITLIST);
										 text1 = element.getText();
										System.out.println("Text of button when Unavailable size selected :: "+text1);
										if(!(text1.equalsIgnoreCase("JOIN THE WAITLIST")))
											throw new Exception("Text change for 'JOIN THE WAITLIST' for Packs");
										text1 = element.getText();
									}
									flag = true;
								}
								//break;
							}
						}
						else 
						{
							jse = (JavascriptExecutor)driver;
							jse.executeScript("arguments[0].click();" , element);

						}


						if(i==elementsCount) {
							Reporter.log("No any size available");
							break;
						}	

						if(flag == true)
							continue;
						else {
							element = driver.findElement(ADD_TO_CART_BUTTON);
							text1 = element.getText();
							System.out.println("Button text when Available size selected :: "+text1);
							if(!text1.equalsIgnoreCase("OUT OF STOCK"))
							{
								if(!(text1.equalsIgnoreCase("ADD TO CART"))) {
									throw new Exception("Text change for 'ADD TO CART' ");
								}
							}
							break;}

					}

				}

			    }
			    catch(Exception e)
			    {
					//dropdown
							
					for(int i=1;i<=elementsCount;i++) {
						boolean flag = false;
						//driver.findElement(SIZE_DROPDOWN).click();
						executor.executeScript("arguments[0].click();", driver.findElement(ProductDetailsPageComponents.SIZE_DROPDOWN));
						element = driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+") > div"));
						
						allClasses = element.getAttribute("class");
						
						// check size available or not
						for (String c : allClasses.split(" ")) {
							if (c.equals("unavailable")) {
								if(!driver.findElement(ProductDetailsPageComponents.PRODUCT_TITLE).getText().contains("Pack"))
								{
									Thread.sleep(3000);
									// click on the unavailable item and check the button text
								WebElement element1 = driver.findElement(By.cssSelector(".select--options__list > li:nth-child("+i+")"));
								jse = (JavascriptExecutor)driver;
								jse.executeScript("arguments[0].click();" , element1);
									//element.click();
									Thread.sleep(4000);
							
									driver.navigate().refresh();
//									driver.findElement(By.cssSelector(".swym-tab-modal-close")).click();
//									}		
//									catch (Exception e)
//									{
//										Reporter.log("Join the waitlist not functional at the moment");
//										
//									}
										
									System.out.println("Unavailable size clicked");
									
									List<WebElement> unavailable_color = driver.findElements(By.cssSelector(".product-option__color-swatches-wrapper > ul >li>input")); 
									for(int a=1; a<=unavailable_color.size();a++)
									{
										WebElement oos_color = driver.findElement(By.cssSelector(".product-option__color-swatches-wrapper > ul >li:nth-child("+a+")>input"));
										//oos_color.click();
										jse.executeScript("arguments[0].click();", oos_color);
										Thread.sleep(3000);
										String[] classname = oos_color.getAttribute("class").split(" ");
										String status = classname[classname.length-1];
										if(status.equals("email-when-in-stock"))
											break;
										else continue;
									}
									
									element = driver.findElement(ProductDetailsPageLocators.JOIN_THE_WAITLIST);
									text1 = element.getText();
									System.out.println("Text of button when Unavailable size selected :: "+text1);
									if(!(text1.equalsIgnoreCase("JOIN THE WAITLIST")))
										throw new Exception("Text change for 'JOIN THE WAITLIST' ");
									
									flag = true;
								}
								else 
								{
									driver.findElement(By.cssSelector(".select--options__list> li:nth-child("+i+")")).click();
									System.out.println("Unavailable size clicked");
								//	driver.findElement(ADD_TO_CART_BUTTON).click();
									System.out.println(driver.findElement(ADD_TO_CART_BUTTON).getText());
									if (!driver.findElement(ADD_TO_CART_BUTTON).getText().contentEquals("Out of Stock"))
									{
										element = driver.findElement(ProductDetailsPageComponents.JOIN_THE_WAITLIST);
										text1 = element.getText();
										System.out.println("Text of button when Unavailable size selected :: "+text1);
										if(!(text1.equalsIgnoreCase("JOIN THE WAITLIST")))
											throw new Exception("Text change for 'JOIN THE WAITLIST' for Packs");
										text1 = element.getText();
									}
									flag = true;
								}
								//break;
							}
					
							else 
							{
								jse = (JavascriptExecutor)driver;
								jse.executeScript("arguments[0].click();" , element);
								driver.navigate().refresh();
							//	element.click();
							}
						}
						if(i==elementsCount) {
							Reporter.log("No  size available");
							break;
						}			
						if(flag == true)
							continue;
						else {
						Thread.sleep(3000);
							element = driver.findElement(ADD_TO_CART_BUTTON);
							text1 = element.getText();
							System.out.println("Button text when Available size selected :: "+text1);
							if(!text1.equalsIgnoreCase("OUT OF STOCK"))
							{
								if(!(text1.equalsIgnoreCase("ADD TO CART"))) {
									throw new Exception("Text change for 'ADD TO CART' ");
								}
							}
			
			
					Thread.sleep(2000);
					break;
				}
			}
					
			    }
	}

	public void atc() throws Exception
	{
		// click on Add To Cart Button
		if(!driver.findElement(ADD_TO_CART_BUTTON).isEnabled())
			throw new Exception("ADD TO CART button is not present");
		element = driver.findElement(ADD_TO_CART_BUTTON);
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);

		Thread.sleep(5000);
	driver.get(CustomUtilities.baseUrl);
		//	driver.findElement(ADD_TO_CART_BUTTON).click();
		Thread.sleep(3000);
		Reporter.log("ADD TO CART button is Displayed :: Clickable");

	}
}
