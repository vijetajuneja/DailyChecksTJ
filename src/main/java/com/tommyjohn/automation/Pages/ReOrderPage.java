package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.ReOrderPageComponents;

public class ReOrderPage extends ReOrderPageComponents{


	WebDriver driver;

	public ReOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void ValidateReOrderPage() throws Exception
	{
		new ReOrderPageComponents(driver).ReorderPagevalidation();
	}
	
	public void ReOrderItem() throws Exception
	{
		new ReOrderPageComponents(driver).reorderitem();
	}
	public void ReOrderToPDP() throws Exception
	{
		new ReOrderPageComponents(driver).reorderpagetopdp();
	}
	public void OrderDetails() throws Exception
	{
		new ReOrderPageComponents(driver).orderdetails();
	}
	public void ReviewPage() throws Exception
	{
		new ReOrderPageComponents(driver).ReviewsPage_fromReorder();
	}

}
