package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;
public class FlyCartPageLocator {
	public static By INLINE_CART_SECTION = By.cssSelector(".section.inline-cart");
	public static By INLINE_CART_CLOSE_BUTTON = By.cssSelector("button.inline-cart__close-btn");
	public static By VIEW_CART_LINK = By.cssSelector("a.inline-cart__cart-link");
	public static By INLINE_CART_TITLE = By.cssSelector(".inline-cart__title");
	public static By SHIPING_MESSAGE_TEXT = By.cssSelector(".shipping-message__text");
	public static By SHIPING_MESSAGE_METER = By.cssSelector(".shipping-message__meter > span");
	public static By INLINE_CART_EMPTY_TEXT = By.cssSelector(".inline-cart__empty");
	public static By RECOMMENDED_PRODUCT_HEADING = By.cssSelector(".recommended-products__heading");
	public static By RECOMMENDED_PRODUCTS = By.cssSelector(".recommended-products");
	public static By RECOMMENDED_PRODUCTS_LIST = By.cssSelector(".recommended-products > a");
	public static By LIST_OF_ITEMS_IN_FLYCART = By.cssSelector(".line-item");
	public static By LINE_ITEM_OPTION = By.cssSelector("div.inline-cart__col1 > div:nth-child(4) > article:nth-child(1) > div.line-item__summary > div.line-item__option");
	public static By QUANTITY_PLUS_MINUS_BUTTON = By.cssSelector("article:nth-child(1) > div.line-item__summary > div.line-item__total > div.qty-selector.line-item__qty");
	public static By ADD_GIFT_WRAP_BUTTON = By.cssSelector("div.inline-cart__gift-wrap > a > span:nth-child(2)");
	public static By SUBTOTAL_TEXT = By.cssSelector(".inline-cart__subtotal--text");
	public static By ESTIMATE_TOTAL = By.cssSelector("div.inline-cart__summary > div > div > span");
	public static By ESTIMATE_TOTAL_SMALL = By.cssSelector("div.inline-cart__summary > div > div > small");
	public static By CHECKOUT_BUTTON = By.cssSelector("div.inline-cart__action-btns > a.button.button--red.button--auto");
	public static By FIRST_PRODUCT_TITLE_IN_CART = By.cssSelector(".line-item__title");   //("div.inline-cart__col1 > div:nth-child(7) > article > div.line-item__summary > a");
	public static By PLUS_BUTTON = By.cssSelector(".qty-selector.line-item__qty > button:nth-child(3)");
	public static By MINUS_BUTTON = By.cssSelector(".qty-selector.line-item__qty > button:nth-child(1)");
	public static By QUANTITY = By.cssSelector(".qty-selector.line-item__qty > input");
	public static By CROSS_CLOSE_BUTTON = By.cssSelector("article > div.line-item__summary > button");
	public static By COLOR_AND_SIZE_IN_CART = By.cssSelector("article:nth-child(1) > div.line-item__summary > div:nth-child(2)");
	public static By PRICE_IN_QUANTITY_LINE = By.cssSelector("article:nth-child(1) > div.line-item__summary > div.line-item__total > div.line-item__subtotal > span");
	public static By GIFT_WRAP = By.cssSelector("div.inline-cart__gift-wrap > a");
	public static By GIFT_WRAP_POPUP = By.cssSelector(".modal-overlay.gift-option.active");
	public static By GIFT_BOX_$5 = By.cssSelector("div.gift-option__input-group.gift-option__gift-box > div");
	public static By GIFT_WRAP_APPLY = By.cssSelector("button.gift-option__btn.button");
	public static By GIFT_WRAP_PRICE = By.cssSelector("div.inline-cart__gift-wrap > span:nth-child(2)");
	public static By ESTIMATE_TOTAL_PRICE = By.cssSelector("div.inline-cart__summary > div > span");
	
	//AfterPay
	
	public static By AFTERPAY_DIV = By.cssSelector(".afterpay-cart-container>.afterpay-paragraph");
	public static By AFTERPAYTEXT = By.cssSelector(".afterpay-incart-container > p");
	public static By AFTERPAYLOGO_ICON = By.cssSelector(".afterpay-link");
	public static By AFTERPAY_FLYCART = By.cssSelector(".afterpay-incart-container > p > span");
	
	public static By QUICK_SHOP_SIZE_LIST = By.cssSelector(".quickshop-open>.inline-quick-shop>ul>li");
	
	
	
}