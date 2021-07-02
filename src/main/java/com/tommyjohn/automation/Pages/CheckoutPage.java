package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.CheckoutPageComponents;

public class CheckoutPage extends CheckoutPageComponents {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void ValidateExpressCheckoutOptions() throws Exception
	{
		new CheckoutPageComponents(driver).expresscheckout();
	}
	
	public void Validateguestcheckout() throws Exception
	{
		new CheckoutPageComponents(driver).guestcheckoutflow();
		
	}
	
	public void Validateregisterusercheckout() throws Exception
	{
		new CheckoutPageComponents(driver).registeredusercheckoutflow();
		
	}
	public void Validateinformationpage() throws Exception
	{
		new CheckoutPageComponents(driver).informationpage();
		
	}
	public void Validateshippingpage() throws Exception
	{
		new CheckoutPageComponents(driver).shippingpage();
		
	}
	
	public void Validatepaymentpage() throws Exception
	{
		new CheckoutPageComponents(driver).paymentpage();
		
	}
	
}
