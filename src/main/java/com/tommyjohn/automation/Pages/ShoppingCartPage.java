package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.ShoppingCartComponents;

public class ShoppingCartPage extends ShoppingCartComponents{
	
	WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void ValidateEmptyCart() throws Exception
	{
		new ShoppingCartComponents(driver).EmptyCart();
	}
	
	public void ValidateShoppingCartWithProducts() throws Exception
	{
		new ShoppingCartComponents(driver).CartwithProduct();
	}
	
	public void ValidateAddRemoveProducts() throws Exception
	{
		new ShoppingCartComponents(driver).AddRemoveProductsFromCart();
	}
	
	public void verifyCheckoutfromCart() throws Exception
	{
		new ShoppingCartComponents(driver).CheckoutPageFromCart();
	}
	
	public void verifyproductinCart() throws Exception
	{
		new ShoppingCartComponents(driver).productDetailsInCart();
	}
	
	public void VerifyPromoCodeOnCart() throws Exception
	{
		new ShoppingCartComponents(driver).Promo_Code_OncartPage();
	}


}
