package com.tommyjohn.automation.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Reporter;


public class CustomUtilities {
	public static WebDriver driver;
	public EdgeDriver edgedriver;
	public static String baseUrl = "https://tommyjohn.com/";
	public static BufferedReader reader;
	public static Properties properties;
	public static final String propertiesFilePath = "src/main/resources/configuration.properties";

	// @BeforeSuite
	@SuppressWarnings({ })
	public WebDriver launchtj(String browser) throws Exception {

		// load properties file
		loadPropertiesFile();

		//proxying to blacklist bounceX popup


		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverPath"));
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1280,800");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--aggressive-cache-discard");
			chromeOptions.addArguments("--disable-cache");
			chromeOptions.addArguments("--disable-application-cache");
			chromeOptions.addArguments("--ignore-certificate-errors");
			chromeOptions.addArguments("--no-default-browser-check");
			chromeOptions.addArguments("--disable-popup-blocking");
			chromeOptions.setAcceptInsecureCerts(true);
			//	new
			chromeOptions.addArguments("--host-resolver-rules=MAP events.bouncex.net 127.0.0.1");
			chromeOptions.addArguments("--host-resolver-rules=MAP assets.bounceexchange.com 127.0.0.1");
			chromeOptions.addArguments("--host-resolver-rules=MAP api.bounceexchange.com 127.0.0.1");
			chromeOptions.addArguments("--host-resolver-rules=MAP tag.bounceexchange.com 127.0.0.1");

			driver = new ChromeDriver(chromeOptions);
			driver.get(baseUrl);
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", properties.getProperty("ffDriverPath"));
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1280,800");
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--aggressive-cache-discard");
			options.addArguments("--disable-cache");
			options.addArguments("--disable-application-cache");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--no-default-browser-check");
			options.addArguments("--disable-popup-blocking");

			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.addArguments("--host-resolver-rules=MAP events.bouncex.net 127.0.0.1");
			options.addArguments("--host-resolver-rules=MAP assets.bounceexchange.com 127.0.0.1");
			options.addArguments("--host-resolver-rules=MAP api.bounceexchange.com 127.0.0.1");
			options.addArguments("--host-resolver-rules=MAP tag.bounceexchange.com 127.0.0.1");


			driver = new FirefoxDriver(options);
			driver.get(baseUrl);
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", properties.getProperty("edgeDriverPath"));
			EdgeOptions options = new EdgeOptions();
			options.setCapability("--headless",true);
			options.setCapability("--window-size=1280,800",true);
			options.setCapability("--disable-gpu",true);
			options.setCapability("--no-sandbox",true);
			options.setCapability("--disable-dev-shm-usage",true);
			options.setCapability("--aggressive-cache-discard",true);
			options.setCapability("--disable-cache",true);
			options.setCapability("--disable-application-cache",true);
			options.setCapability("--ignore-certificate-errors",true);
			options.setCapability("--no-default-browser-check",true);
			options.setCapability("--disable-popup-blocking",true);

			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			//options.setCapability(CapabilityType.PROXY, selproxy);

			options.setCapability("--host-resolver-rules=MAP events.bouncex.net 127.0.0.1",true);
			options.setCapability("--host-resolver-rules=MAP assets.bounceexchange.com 127.0.0.1",true);
			options.setCapability("--host-resolver-rules=MAP api.bounceexchange.com 127.0.0.1",true);
			options.setCapability("--host-resolver-rules=MAP tag.bounceexchange.com 127.0.0.1",true);

			edgedriver = new EdgeDriver(options);
			edgedriver.get(baseUrl);
			edgedriver.manage().window().maximize();
			driver=edgedriver;

		}

		else if (browser.equalsIgnoreCase("safari"))
		{
			SafariOptions options = new SafariOptions();
			options.setCapability("--headless",true);
			options.setCapability("--window-size=1280,800",true);
			options.setCapability("--disable-gpu",true);
			options.setCapability("--no-sandbox",true);
			options.setCapability("--disable-dev-shm-usage",true);
			options.setCapability("--aggressive-cache-discard",true);
			options.setCapability("--disable-cache",true);
			options.setCapability("--disable-application-cache",true);
			options.setCapability("--ignore-certificate-errors",true);
			options.setCapability("--no-default-browser-check",true);
			options.setCapability("--disable-popup-blocking",true);

			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			
			options.setCapability("--host-resolver-rules=MAP events.bouncex.net 127.0.0.1",true);
			options.setCapability("--host-resolver-rules=MAP assets.bounceexchange.com 127.0.0.1",true);
			options.setCapability("--host-resolver-rules=MAP api.bounceexchange.com 127.0.0.1",true);
			options.setCapability("--host-resolver-rules=MAP tag.bounceexchange.com 127.0.0.1",true);

			driver = new SafariDriver(options);
			driver.get(baseUrl);
			driver.manage().window().maximize();
		}


			return driver;

	}

	// @AfterSuite
	public void teardown() {
		if (driver != null)
			driver.quit();
	}

	// method to load properties file
	public static void loadPropertiesFile() throws Exception {
		reader = new BufferedReader(new FileReader(propertiesFilePath));
		properties = new Properties();
		properties.load(reader);
		reader.close();
		if (properties.isEmpty()) {
			Reporter.log("Properties file not loaded or empty..!");
			System.exit(0);
		}

	}

	public static void takessiffailed(String mname) throws Exception
	{

		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(CustomUtilities.properties.getProperty("executionvideospath")+"/Screenshot_"+mname +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
