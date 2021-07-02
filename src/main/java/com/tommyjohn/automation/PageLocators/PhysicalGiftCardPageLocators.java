package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;

public class PhysicalGiftCardPageLocators
{
	public static By PRICE_OPTIONS = By.cssSelector("div.radio-options-container>div>label");
	public static By ATC_BUTTON = By.cssSelector(".multiPdp__atc-container>button");
	public static By PHYSICAL_GIFT_CARD_TITLE_INLINE_CART = By.cssSelector("a.line-item__title");
	public static By PHYSICAL_GIFT_CARD_COLOR_INLINE_CART = By.cssSelector(".line-item__option");
	public static By PHYSICAL_GIFT_CARD_PRICE_INLINE_CART = By.cssSelector(".line-item__price >span");
	public static By PHYSICAL_GIFT_CARD_DISPLAY_IMAGE = By.cssSelector("div.pdpImageSlides> div > div > div.product_image.slick-active > img");
	public static By PHYSICAL_GIFT_CARD_DISPLAY_IMAGE_SMALL_1 = By.cssSelector(" div.slick-vertical > div > div > div:nth-child(1) > img");
	public static By PHYSICAL_GIFT_CARD_DISPLAY_IMAGE_SMALL_2 = By.cssSelector(" div.slick-vertical > div > div > div:nth-child(2) > img");
	public static By PHYSICAL_GIFT_CARD_TITLE = By.cssSelector(".product-info__inner-top >div:nth-child(1) >div:nth-child(1)");
	public static By PHYSICAL_GIFT_CARD_PRICE = By.cssSelector(".product-info__inner-top >div:nth-child(1) >div:nth-child(2) >span >span:nth-child(2)");
	public static By COLOR_NAME = By.cssSelector(".product-info__option >div >span");
	public static By PHYSICAL_GIFT_CARD_AMOUNT_TEXT = By.cssSelector("div.radio-options-container>div>div.optionName >span");
	public static By PRODUCT_DETAILS = By.cssSelector("div.product-info > div > div.product-accordion.container > ul > li:nth-child(1) > div:nth-child(1) > a");
	public static By SHIPING_AND_RETURNS = By.cssSelector("div.product-accordion.container> ul > li:nth-child(2) > div:nth-child(1) > a");
	
	

}
