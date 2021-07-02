package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;

public class AddToCartLocators {
	
	public static By ALL_SIZE_LIST = By.cssSelector(".select--options__list >li"); //(".product-option__variants.product-option__variants-size > ul > li")
	public static By ADD_TO_CART_BUTTON = By.cssSelector("button.product-info__atc.button.button--red.button--full.js-loop-atc");
	public static By EMAIL_WHEN_IN_STOCK_BUTTON = By.cssSelector("button.product-info__atc.button.button--red.button--full.js-loop-atc.email-when-in-stock");
	public static By QUANTITY = By.cssSelector("#updatedQty.pdp.prodQty");
	public static By PLUS_BUTTON = By.cssSelector(".qty-selector.desktop> button#plusBtn");
	public static By UPDATED_QUANTITY = By.cssSelector("#updatedQty.pdp.prodQty");
	public static By MINUS_BUTTON = By.cssSelector(".qty-selector.desktop> button#minusBtn");
	public static By PAIR_GUARANTEE_LINK = By.cssSelector(".product-info__inner-bottom > div:nth-child(1) > button");
	public static By SHIPING_AND_RETURNS_LINK = By.cssSelector(".product-info__inner-bottom > div:nth-child(2) > button");
	public static By CHECKOUT_BUTTON = By.cssSelector(".inline-cart__action-btns > a:nth-child(3)");

}
