package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;
public class GiftCard_PageLocators {


	public static By NEW_ARRIVALS_OPTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(1) > a");
	public static By GIFT_CARD_TITLE = By.cssSelector(".product-info__inner-top >div >div:nth-child(1) >h1");
	public static By GIFT_CARD_PRICE = By.cssSelector(".product-info__inner-top >div >div:nth-child(2) >span >span:nth-child(2)");
	public static By COLOR_NAME = By.cssSelector(".product-info__option >div >span");
	public static By GIFT_CARD_AMOUNT_TEXT = By.cssSelector("div.radio-options-container>div>div.optionName >span");
	//Price selector
	public static By PRICE_DROPDOWN = By.cssSelector(".select.select--options.js-option-select.option-dropdown__option.desktop-view >a");
	public static By PRICE_OPTIONS = By.cssSelector("div.radio-options-container>div>label");
	public static By PRICE_100 = By.cssSelector(".select--options__list >li:nth-child(3)");
    
	//Form
	public static By RECIPIENT_MAIL_LABEL = By.cssSelector("#gift-card-section >div:nth-child(1)"); 
	public static By RECIPIENT_MAIL_TEXTBOX = By.cssSelector("#recipient_email");
	public static By CONFIRM_MAIL_LABEL = By.cssSelector("#gift-card-section >div:nth-child(4)");
	public static By CONFIRM_MAIL_TEXTBOX = By.cssSelector("#confirm_recipient_email");
	public static By DELIVERY_DATE_LABEL = By.cssSelector("#gift-card-section > div:nth-child(8)");
	public static By DELIVERY_DATE_GIFT_BOX = By.cssSelector("#gift-card-section >div:nth-child(8)");
	public static By DELIVERY_MESSAGE_LABEL = By.cssSelector(".time-label");
	public static By GIFT_CARD_MESSAGE_LABEL = By.cssSelector("#gift-card-section >div:nth-child(14)");
	public static By GIFT_CARD_DISPLAY_IMAGE = By.cssSelector("div.pdpImageSlides> div > div > div.product_image.slick-active > img");
	public static By GIFT_CARD_DISPLAY_IMAGE_SMALL_1 = By.cssSelector("div.slick-vertical > div > div > div:nth-child(1) > img");
	public static By GIFT_CARD_DISPLAY_IMAGE_SMALL_2 = By.cssSelector("div.slick-vertical > div > div > div:nth-child(2) > img");
	public static By GIFT_CARD_MESSAGE_TEXTBOX = By.cssSelector("#gift-card-section >textarea");
	public static By GIFT_CARD_MESSAGE_LIMIT = By.cssSelector(".limit-label");
	public static By ATC_BUTTON = By.cssSelector(".product-info-quant-atc-container>div>button");

	public static By PRODUCT_DETAILS = By.cssSelector("div.product-accordion.container> ul > li:nth-child(1) > div:nth-child(1) > a");
	public static By SHIPING_AND_RETURNS = By.cssSelector("div.product-accordion.container> ul > li:nth-child(2) > div:nth-child(1) > a");

	public static By GIFT_CARD_DETAILS_TITLE = By.cssSelector("div.product-accordion.container> ul > li:nth-child(1) > div:nth-child(2) >section>h2");
	public static By GIFT_CARD_DESCRIPTION_HEADING = By.cssSelector(".product-details-main.gift-card >div:nth-child(2) >div:nth-child(1) >h2");
	public static By GIFT_CARD_DESCRIPTION = By.cssSelector(".product-details-main.gift-card >div:nth-child(2) >div:nth-child(1) >p >span");
	public static By GIFT_CARD_DESCRIPTION_IMAGE = By.cssSelector(".product-details-main.gift-card >div:nth-child(2) >div:nth-child(2) >img");
	public static By DATE_TIME_PICKER_INPUT = By.cssSelector("#gift-card-section >input.delivery_date.gift-card-textbox.flatpickr.transparent-back.flatpickr-input.form-control.input");
	//public static By DATE_TIME_PICKER_INPUT = By.xpath("//input[@id='delivery_date']");
	public static By NEXT_MONTH_ARROW = By.cssSelector(".flatpickr-next-month >svg");
	public static By PREV_MONTH_ARROW = By.cssSelector(".flatpickr-prev-month >svg");
	public static By SELECTION_OF_DATE_BY_DTP = By.cssSelector(".flatpickr-innerContainer >div >div:nth-child(2) >div >span:nth-child(25)");
	public static By TODAY = By.cssSelector(".flatpickr-day.today");
	//ADD TO CART
	public static By CONTINUE_SHOPPING_BUTTON = By.cssSelector("button.inline-cart__close-btn");
	public static By INLINE_VIEW_CART_BUTTON = By.cssSelector("a.inline-cart__cart-link");
	public static By SHOPPING_CART_TITLE = By.cssSelector(".inline-cart__title");
	public static By GIFT_CARD_IMAGE_INLINE_CART = By.cssSelector(".line-item >div:nth-child(1) >img");
	public static By GIFT_CARD_TITLE_INLINE_CART = By.cssSelector("a.line-item__title");
	public static By REMOVE_ITEM_BUTTON = By.cssSelector("button.line-item__remove");
	public static By GIFT_CARD_COLOR_INLINE_CART = By.cssSelector(".line-item__option");
	public static By GIFT_CARD_PRICE_INLINE_CART = By.cssSelector(".line-item__price >span");
	public static By RECIPIENT_MAIL_INLINE_CART = By.xpath("//span[text()[contains(.,'Recipient')]]");
	public static By DELIVERY_DATE_INLINE_CART = By.xpath("//span[text()[contains(.,'Delivery Date')]]");
	public static By AMOUNT_IN_INLINE_CART = By.cssSelector("article:nth-child(1) > div.line-item__summary > div.line-item__total > div.line-item__subtotal > span");
	public static By QUANTITY_SELECTOR_INLINE_CART = By.cssSelector(".qty-selector.line-item__qty > input");
	public static By AFTER_PAY_MESSAGE = By.cssSelector(".inline-cart__col1 >div:nth-child(3) >span >p:nth-child(2) >span:nth-child(1)");


	//VALIDATIONS
	public static By EMAIL_ERROR_MESSAGES_GC = By.cssSelector("#recipient_email_error");
	public static By CONFIRM_EMAIL_ERROR_MSG_GC = By.cssSelector("#recipient_confirm_email_error");
	public static By DATE_ERROR_MSG_GC = By.cssSelector("#delivery_date_error");
	public static By SELECT_AN_AMOUNT_BUTTON = By.cssSelector(".product-info-quant-atc-container>div>button");
}


//	public static By NEW_ARRIVALS_OPTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(1) > a");
////	public static By NEW_ARRIVALS_OPTION = By.cssSelector(".header-main-menu >li:nth-child(1) >a");
//	public static By GIFT_CARD_LINK = By.cssSelector("div.header-desktop-left > ul > li:nth-child(1) > div > ul > li:nth-child(4) > ul > li > a");
//	//public static By GIFT_CARD_LINK2 = By.xpath("//*[@id=\"tommy-john-no-adjustment-needed\"]/header/div[2]/div[2]/ul/li[1]/div/ul/li[1]/ul/li[5]/a");
//	public static By GIFT_CARD_LINK2 = By.cssSelector("div.header-desktop-left > ul > li:nth-child(1) > div > ul > li:nth-child(4) > ul > li > a");
//	//Gift Card
//	//public static By GIFT_CARD_TITLE = By.cssSelector(".product-info__inner-top >div:nth-child(1) >h1");
//	public static By GIFT_CARD_TITLE = By.cssSelector(".product-info__inner-top >div >div:nth-child(1) >h1");
//	//public static By GIFT_CARD_PRICE = By.cssSelector(".product-info__price >span:nth-child(2)");
//	public static By GIFT_CARD_PRICE = By.cssSelector(".product-info__inner-top >div >div:nth-child(2) >span >span:nth-child(2)");
//	//public static By COLOR_TITLE = By.cssSelector(".product-info__header.hide");
//	public static By COLOR_NAME = By.cssSelector(".product-info__option >div >span");
//	//public static By COLOR_NAME = By.cssSelector(".product-info__header.hide >span");
//	public static By GIFT_CARD_AMOUNT = By.cssSelector(".option-dropdown__section >div:nth-child(1)");
//	
//	//Price selector
//	public static By PRICE_DROPDOWN = By.cssSelector(".select.select--options.js-option-select.option-dropdown__option.desktop-view > a");
//	public static By PRICE_OPTIONS = By.cssSelector(".select--options__list__item");
//	public static By PRICE_100 = By.cssSelector(".select--options__list >li:nth-child(3)");
//	
//Amount variants
//	public static By AMOUNT_1 = By.cssSelector(".product-info__inner-top >div:nth-child(3) >div:nth-child(2) >div:nth-child(2) >ul >li:nth-child(1) >label");
//	public static By AMOUNT_2 = By.cssSelector(".product-info__inner-top >div:nth-child(3) >div:nth-child(2) >div:nth-child(2) >ul >li:nth-child(2) >label");
//	public static By AMOUNT_3 = By.cssSelector(".product-info__inner-top >div:nth-child(3) >div:nth-child(2) >div:nth-child(2) >ul >li:nth-child(3) >label");
//	public static By AMOUNT_4 = By.cssSelector(".product-info__inner-top >div:nth-child(3) >div:nth-child(2) >div:nth-child(2) >ul >li:nth-child(4) >label");
//	public static By AMOUNT_5 = By.cssSelector(".product-info__inner-top >div:nth-child(3) >div:nth-child(2) >div:nth-child(2) >ul >li:nth-child(5) >label");
//	public static By AMOUNT_6 = By.cssSelector(".product-info__inner-top >div:nth-child(3) >div:nth-child(2) >div:nth-child(2) >ul >li:nth-child(6) >label");

//Form
//	public static By RECIPIENT_MAIL = By.cssSelector("#gift-card-section >div:nth-child(1)"); 
//	public static By RECIPIENT_MAIL_TEXTBOX = By.cssSelector("#recipient_email");
//	public static By CONFIRM_MAIL = By.cssSelector("#gift-card-section >div:nth-child(4)");
//	public static By CONFIRM_MAIL_TEXTBOX = By.cssSelector("#confirm_recipient_email");
//	public static By DELIVERY_DATE_GIFT_BOX = By.cssSelector("#gift-card-section >div:nth-child(8)");
//	public static By DELIVERY_MESSAGE_TEXT = By.cssSelector(".time-label");
//	public static By GIFT_BOX_MESSAGE_TEXT = By.cssSelector("#gift-card-section >div:nth-child(14)");
//	public static By GIFT_CARD_DISPLAY_IMAGE = By.cssSelector(".product-gallery >div:nth-child(2) >div >div >div:nth-child(1) >img");
//	public static By GIFT_CARD_DISPLAY_IMAGE_SMALL_1 = By.cssSelector(".product-gallery >div:nth-child(1) >div >div >div:nth-child(1) >img");
//	public static By GIFT_CARD_DISPLAY_IMAGE_SMALL_2 = By.cssSelector(".product-gallery >div:nth-child(1) >div >div >div:nth-child(2) >img");
//	public static By GIFT_CARD_MESSAGE_TEXTBOX = By.cssSelector("#gift-card-section >textarea");
//	public static By GIFT_CARD_MESSAGE_LIMIT = By.cssSelector(".limit-label");
//	public static By ATC_BUTTON = By.cssSelector(".product-info__atc.button.button--red.button--full.js-loop-atc.product-info__gc-atc");
//	public static By SHIPPING_AND_RETURNS_BUTTON = By.cssSelector(".product-info__guarantee >button");
//	public static By SHIPPING_AND_RETURNS_ICON = By.cssSelector(".product-info__guarantee >button >svg");
//	public static By SHIPPING_RETURNS_SUBTEXT = By.cssSelector(".product-info__guarantee >span");

//	public static By PRODUCT_DETAILS = By.cssSelector("div.product-accordion.container> ul > li:nth-child(1) > div:nth-child(1) > a");
//	public static By SHIPING_AND_RETURNS = By.cssSelector("div.product-accordion.container> ul > li:nth-child(2) > div:nth-child(1) > a");
//	
//	public static By GIFT_CARD_DETAILS_TITLE = By.cssSelector(".product-details-main.gift-card >div:nth-child(1) >div >button");
//	public static By GIFT_CARD_DESCRIPTION_HEADING = By.cssSelector(".product-details-main.gift-card >div:nth-child(2) >div:nth-child(1) >h2");
//	public static By GIFT_CARD_DESCRIPTION = By.cssSelector(".product-details-main.gift-card >div:nth-child(2) >div:nth-child(1) >p >span");
//	public static By GIFT_CARD_DESCRIPTION_IMAGE = By.cssSelector(".product-details-main.gift-card >div:nth-child(2) >div:nth-child(2) >img");
//	public static By DATE_TIME_PICKER_INPUT = By.cssSelector("#gift-card-section >input.delivery_date.gift-card-textbox.flatpickr.transparent-back.flatpickr-input.form-control.input");
//	public static By NEXT_MONTH_ARROW = By.cssSelector(".flatpickr-next-month >svg");
//	public static By PREV_MONTH_ARROW = By.cssSelector(".flatpickr-prev-month >svg");
//	public static By SELECTION_OF_DATE_BY_DTP = By.cssSelector(".flatpickr-innerContainer >div >div:nth-child(2) >div >span:nth-child(25)");
//	public static By DP_MONTH = By.cssSelector(".flatpickr-calendar.animate.arrowTop.open >div:nth-child(2) >div >div:nth-child(2)");
//public static By CURRENT_MONTH = By.cssSelector(".flatpickr-month");
//	public static By MONTHS_GC = By.cssSelector(".flatpickr-months");
//	public static By DAYS_IN_MONTH = By.cssSelector(".dayContainer");
//	public static By CURRENT_MONTH = By.cssSelector(".flatpickr-current-month >span");
//	public static By MONTH_DAYS = By.cssSelector(".flatpickr-innerContainer >div >div:nth-child(2) >div");
//	public static By TODAY = By.cssSelector(".flatpickr-day.today");
//	//ADD TO CART
//	public static By CONTINUE_SHOPPING_BUTTON = By.cssSelector("button.inline-cart__close-btn");
//	public static By INLINE_VIEW_CART_BUTTON = By.cssSelector("a.inline-cart__cart-link");
//	public static By SHOPPING_CART_TITLE = By.cssSelector(".inline-cart__title");
//	public static By GIFT_CARD_IMAGE_INLINE_CART = By.cssSelector(".line-item >div:nth-child(1) >img");
//	public static By GIFT_CARD_TITLE_INLINE_CART = By.cssSelector("a.line-item__title");
//	public static By REMOVE_ITEM_BUTTON = By.cssSelector("button.line-item__remove");
//	public static By GIFT_CARD_COLOR_INLINE_CART = By.cssSelector(".line-item__option");
//	public static By GIFT_CARD_PRICE_INLINE_CART = By.cssSelector(".line-item__price >span");
//	public static By RECIPIENT_MAIL_INLINE_CART = By.cssSelector(".line-item-properties >span:nth-child(1)");
//	public static By DELIVERY_DATE_INLINE_CART = By.cssSelector(".line-item-properties >span:nth-child(2)");
//	public static By AMOUNT_IN_INLINE_CART = By.cssSelector("article:nth-child(1) > div.line-item__summary > div.line-item__total > div.line-item__subtotal > span");
//	public static By QUANTITY_SELECTOR_INLINE_CART = By.cssSelector(".qty-selector.line-item__qty > input");
//	public static By PLUS_BUTTON = By.cssSelector(".qty-selector.line-item__qty > button:nth-child(3)");
//	public static By MINUS_BUTTON = By.cssSelector(".qty-selector.line-item__qty > button:nth-child(1)");
//	public static By CHECKOUT_BUTTON = By.cssSelector("div.inline-cart__action-btns > a.button.button--red.button--auto");
//	public static By ADD_A_GIFT_WRAP = By.cssSelector(".inline-cart__footer-row >div:nth-child(1) >a");
//	public static By AFTER_PAY_MESSAGE = By.cssSelector(".inline-cart__col1 >div:nth-child(3) >span >p:nth-child(2) >span:nth-child(1)");

//GIFT WRAP
//	public static By CHECK_GIFTWRAP_POPUP = By.cssSelector(".modal-overlay.gift-option.active");
//	public static By $5_GIFT_BOX = By.cssSelector("div.gift-option__input-group.gift-option__gift-box > div");
//	public static By BUTTON_GIFT_BOX_APPLY = By.cssSelector("button.gift-option__btn.button.button--red");
//	public static By GIFT_WRAP_AMOUNT = By.cssSelector("div.inline-cart__gift-wrap > span:nth-child(2)");
//	public static By ESTIMATED_TOTAL_AMOUNT = By.cssSelector("div.inline-cart__summary > div > span");

//VALIDATIONS
//	public static By EMAIL_MESSAGES_GC = By.cssSelector("#recipient_email_error");
//	public static By CONFIRM_EMAIL_ERROR_MSG_GC = By.cssSelector("#recipient_confirm_email_error");
//	public static By DATE_ERROR_MSG_GC = By.cssSelector("#delivery_date_error");
//	public static By SELECT_AN_AMOUNT_BUTTON = By.cssSelector(".select--options__label.js-option-select-toggle");
//	}
