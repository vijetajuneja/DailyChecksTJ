package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPageLocators {

	//	                                       INFO
	public static By LIST_OF_ITEM_IN_PAYMENT_PAGE = By.cssSelector(".product-table>tbody>tr.product");
	public static By CART_LINK = By.cssSelector(".breadcrumb > li > a");
	public static By EXPRESS_CHECKOUT_TEXT = By.cssSelector(".dynamic-checkout__title");
	public static By PAYPAL_BUTTON = By.cssSelector(".paypal-button");
	public static By GPAY_BUTTON = By.xpath("//div[@data-testid = 'GooglePay-button']");
	public static By AMZ_PAY = By.xpath("//form[@action = 'https://payments.amazon.com/checkout/signin'] /button" );
	public static By BREADCRUMB_LINK_CART = By.cssSelector("ol.breadcrumb>li:nth-child(1) >a");
	public static By BREADCRUMB_LINK_INFORMATION = By.cssSelector("ol.breadcrumb>li:nth-child(2)");
	public static By BREADCRUMB_LINK_SHIPPING = By.cssSelector("ol.breadcrumb>li:nth-child(3)");
	public static By BREADCRUMB_LINK_PAYMENT = By.cssSelector("ol.breadcrumb>li:nth-child(4)");
		
	//Contact info 
	public static By CONTACTINFO_TEXT = By.cssSelector("h2#main-header");
	public static By ALREADYHAVEANACCOUNT_TEXT = By.cssSelector(".layout-flex__item > span");
	public static By LOGIN_LINK = By.cssSelector(".layout-flex__item > a");
	public static By CHECKOUT_EMAIL = By.cssSelector("#checkout_email");

	//shipping address
	public static By SHIPPINGADD_TEXT = By.cssSelector(".section--shipping-address > div > .section__title");
	public static By FIRSTNAME_TEXTBOX = By.cssSelector("#checkout_shipping_address_first_name");
	public static By LASTNAME_TEXTBOX = By.cssSelector("#checkout_shipping_address_last_name");
	public static By ADDRESS1_TEXTBOX = By.cssSelector("#checkout_shipping_address_address1");
	public static By ADDRESS2_TEXTBOX = By.cssSelector("#checkout_shipping_address_address2");
	public static By CITY_TEXTBOX = By.cssSelector("#checkout_shipping_address_city");
	public static By COUNTRY_DROPDOWN = By.cssSelector("#checkout_shipping_address_country");
	public static By STATE_DROPDOWN = By.cssSelector("#checkout_shipping_address_province");
	public static By PINCODE_TEXTBOX = By.cssSelector("#checkout_shipping_address_zip");
	public static By PHONE_TEXTBOX = By.cssSelector("#checkout_shipping_address_phone");
	public static By REMEMBERME_CHCKBOX = By.cssSelector("#checkout_remember_me");
	public static By RETURN_TO_CART_LINK = By.cssSelector(".step__footer__previous-link");
	public static By CONTINUE_TO_SHIPPING_BUTTON = By.cssSelector(".step__footer__continue-btn.btn");


	//SideBar
	public static By ORDER_SUMMARY_SECTION = By.cssSelector(".order-summary__section__content");
	//public static By DISCOUNT_CODE_TEXTBOX = By.cssSelector("#checkout_reduction_code");
	public static By DISCOUNT_CODE_TEXTBOX = By.cssSelector(".order-summary__section--discount > form:nth-child(3) > div  > div  > div > div > #checkout_reduction_code");
	//public static By APPLY_DISCOUNT_BUTTON = By.cssSelector(".field__input-btn");
	public static By APPLY_DISCOUNT_BUTTON = By.cssSelector(".order-summary__section--discount > form:nth-child(3) > div  > div  > div >button");
	public static By SUBTOTAL = By.cssSelector("td.total-line__price > .order-summary__emphasis");
	public static By SHIPPING = By.cssSelector(".total-line--shipping > .total-line__price > span");
	public static By APPLIED_PROMO_CODE = By.cssSelector(".tag__text>span.reduction-code>span");
	public static By CANCEL_PROMO_CODE = By.cssSelector("button.tag__button");
	public static By TOTAL = By.cssSelector(".payment-due__price");

	//                                          Shipping

	public static By CONTACT_EMAIL =  By.cssSelector(".review-block__content > bdo");
	public static By SHIP_ADDRESS =  By.cssSelector(".review-block__content > address");
	public static By CHANGE_LINK_CONTACT = By.cssSelector(".content-box__row>div:nth-child(1)>.review-block__link > a");
	public static By CHANGE_LINK_SHIP_TO = By.cssSelector(".content-box__row>div:nth-child(2)>.review-block__link > a");
	public static By CHANGE_LINK_METHOD = By.cssSelector(".content-box__row>div:nth-child(3)>.review-block__link > a");
	public static By SHIPPING_TEXT = By.cssSelector("h2#main-header");
	public static By SHIPPING_RADIO_BUTTON = By.cssSelector(".input-radio");
	public static By RETURN_LINK = By.cssSelector(".step__footer__previous-link-content");
	public static By CONTINUE_TO_PAYMENT_BUTTON = By.cssSelector("button#continue_button");


	//                                           payment

	public static By METHOD =  By.cssSelector(".review-block__content > .emphasis");
	public static By PAYMENT_TEXT = By.cssSelector("#main-header");
	public static By CREDITCARD_OPTION = By.xpath("//fieldset[@class='content-box']/div[@data-gateway-group='direct']");
	public static By PAYPAL_OPTION = By.xpath("//*[@data-gateway-group='express']");

	public static By BILLING_TEXT = By.cssSelector(".section--billing-address > div.section__header > h2");
	public static By COMPLETE_ORDER_BUTTON = By.cssSelector("button.step__footer__continue-btn");
	public static By HOWHEARD_TITLE = By.cssSelector(".how_new_title");
	public static By HOWHEARD_SUBTITLE = By.cssSelector(".how_new_subtitle");
	public static By HOWHEARD_DROPDOWN = By.cssSelector(".make_selection_select");



	//	AfterPay
	public static By AFTERPAY_OPTION = By.cssSelector("div.section__content > div:nth-child(2) > fieldset > div:nth-child(9)");
	public static By AFTERPAYTEXT_WITH_INSTALLMENT = By.cssSelector("div.radio__label > label > div:nth-child(2)>p:nth-child(1)");
	public static By AVAILABLE_BETWEEN_TEXT = By.cssSelector("div.section__content > div:nth-child(2) > fieldset > div:nth-child(9) > p > span.afterpay-text2");
	public static By AFTERPAY_INSTALLMENTS = By.cssSelector("div.section__content > div:nth-child(2) > fieldset > div:nth-child(9) > p >.afterpay-instalments");
	public static By AFTERPAYLOGO_WITH_AVAILABLE = By.cssSelector("div.section__content > div:nth-child(2) > fieldset > div:nth-child(9) > p >.afterpay-link");
	public static By AFTERPAYLOGO_WITH_INSTALLMENT = By.cssSelector("div.radio__label > label > div:nth-child(2) > p>a");			


}
