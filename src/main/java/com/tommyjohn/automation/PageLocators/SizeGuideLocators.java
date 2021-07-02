package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;

public class SizeGuideLocators 
{
	public static By FIRST_PRODUCT_REVIEW_STARS = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > a > div");

	public static By PRODUCT_TITLE = By.cssSelector(" .product-info__title-wrap > h1.product-info__title");
	public static By PRODUCT_PRICE = By.cssSelector("div.multi-pdp-title-wrap.desktop-view > div.product-info__price-wrap >span > span:nth-child(2)");
	public static By RATING_STARS = By.cssSelector("div.multi-pdp-title-wrap.desktop-view > div.product-info__price-wrap > div.yotpo-star-wrapper > div > div > span:nth-child(2)");
	public static By CUSTOMER_REVIEW_STATUS_TEXT = By.cssSelector("div.multi-pdp-title-wrap.desktop-view > div.product-info__price-wrap > div.yotpo-star-wrapper > div > div > span");
	
	public static By RATING_NUMBER = By.cssSelector("div.multi-pdp-title-wrap.desktop-view > div.product-info__price-wrap > div.yotpo-star-wrapper > div > div > a");
	public static By RATING_AND_REVIEWS_BOX = By.cssSelector(".yotpo-regular-box.yotpo-bottomline.yotpo-bottomline-3-boxes");
	public static By FIRST_BOX_IN_RATING_AND_REVIEWS = By.cssSelector(".yotpo-bottomline-box-1.yotpo-stars-and-sum-reviews");
	public static By STAR_RATINGS = By.cssSelector(".yotpo-stars-and-sum-reviews > span > span.sr-only");
	public static By BE_THE_FIRST_TO_WRITE_REVIEW = By.cssSelector(".yotpo-first-review-content > input");
	public static By WRITE_REVIEW_BUTTON = By.cssSelector(".yotpo-label.yotpo-small-box > div:nth-child(2)");
	public static By WRITE_REVIEW_HEADING = By.cssSelector("#pdpReviews > div > div > form > div");
	public static By WRITE_REVIEW_HEADING1 = By.cssSelector(".y-label.yotpo-header-title");
	public static By REVIEW_STARS_IN_RATING_AND_REVIEWS = By.cssSelector(".yotpo-bottomline-box-1 > span:nth-child(1)");
	public static By COLOR_LISTS = By.cssSelector(".product-option__color-swatches-wrapper > ul >li");
	public static By FIRST_COLOR = By.cssSelector(".product-option__color-swatches-wrapper > ul > li:nth-child(1) > label");
	public static By SECOND_COLOR = By.cssSelector(".product-option__color-swatches-wrapper > ul > li:nth-child(2) > label");
	public static By THIRD_COLOR = By.cssSelector(".product-option__color-swatches-wrapper > ul > li:nth-child(3) > label");
	public static By COLOR_TEXT = By.xpath("//div[@class= 'multi-pdp-info__header'] /span[text()]");
	//public static By SIZE_TEXT = By.cssSelector(".product-info__header > span:nth-child(2)");

	public static By SIZE_DROPDOWN = By.cssSelector(".option-dropdown__option >div>a");
	public static By ALL_SIZE_LIST = By.cssSelector(".select--options__list >li");

	public static By SIZE_TEXT = By.cssSelector(".select--options__label");
	
	public static By ALL_COLOR_LIST = By.cssSelector(".product-option__color-swatches-wrapper > ul >li");
	public static By PRODUCT_DETAILS = By.cssSelector("div.product-accordion.container> ul > li:nth-child(1) > div:nth-child(1) > a");
	
	//Size Guide Locators
	public static By SIZEGUIDE = By.cssSelector("button.size-guide");
	public static By BUNDLE_FIRST_SIZE_GUIDE_BUTTON = By.cssSelector("div.radios-wrapper>div:nth-child(1)>div.Size>div>button");
	public static By BUNDLE_SECOND_SIZE_GUIDE_BUTTON = By.cssSelector("div.radios-wrapper>div:nth-child(2)>div.Size>div>button");
	public static By SIZE_GUIDE_BUTTON = By.cssSelector(".product-details__controls--inner > button:nth-child(2)");
	public static By SIZE_GUIDE_TITLE = By.cssSelector(".size-chart-content>.size-guide-title");
	public static By SECOND_SIZE_GUIDE_TITLE = By.cssSelector("div.product-details.product-details--fit.container.active > div>div:nth-child(2) > div.size-chart-content >h1");
	public static By SIZE_GUIDE_FITMETER_TITLE = By.cssSelector(".size-guide-yatpo-fit");
	public static By SECOND_SIZE_GUIDE_FITMETER_TITLE = By.xpath("//div[@class='size-chart-overlay' ][@style='display: flex;']//div[@class='size-guide-yatpo-fit']");
	public static By SIZE_GUIDE_CUSTOMER_SAY_REVIEW_TEXT = By.cssSelector(".size-guide-yatpo-fit>span");
	public static By SECOND_SIZE_GUIDE_CUSTOMER_SAY_REVIEW_TEXT = By.xpath("//div[@class='size-chart-overlay' ][@style='display: flex;']//div[@class='size-guide-yatpo-fit']/span");
	public static By SIZE_GUIDE_FITMETER_GRAPH = By.cssSelector(".size-guide-split-item>.size-guide-yatpo-fit-graph");
	public static By SECOND_SIZE_GUIDE_FITMETER_GRAPH = By.xpath("//div[@class='size-chart-overlay' ][@style='display: flex;']//div[@class='size-guide-yatpo-fit-graph']");
	public static By SIZE_CHART_TABLE_DIV = By.cssSelector(".product-fit-guide");
	public static By SECOND_SIZE_CHART_TABLE_DIV = By.xpath("//div[@class='size-chart-overlay' ][@style='display: flex;']//div[@class='product-fit-guide']");
	public static By SIZE_GUIDE_CHART_TABLE = By.cssSelector(".product-fit-guide>table.size-chart-table");
	public static By SECOND_SIZE_GUIDE_CHART_TABLE = By.xpath("//div[@class='size-chart-overlay' ][@style='display: flex;']//table[@class='size-chart-table']");
	public static By CUP_SIZE_INCHES_TEXT = By.cssSelector(".product-fit-guide>table.size-chart-table>tr:nth-child(4)>td:nth-child(1)>div");
	public static By BAND_SIZE_INCHES_TEXT = By.cssSelector(".product-fit-guide>table.size-chart-table>tr:nth-child(1)>td");
	public static By SIZE_GUIDE_INSTRUCTION_CONTENT = By.cssSelector(".size-guide-instructions");
	public static By SECOND_SIZE_GUIDE_INSTRUCTION_CONTENT = By.xpath("//div[@class='size-chart-overlay' ][@style='display: flex;']//*[@class='size-guide-instructions-content']");
    public static By FIND_YOUR_SIZE_TEXT = By.cssSelector(".size-guide-split-item:nth-child(2)>h2");
    public static By BRA_BAND_SIZE_DROPDOWN = By.cssSelector(".size-guide-size-finder-dropdowns>span:nth-child(1)>select");
    public static By BRA_CUP_VOLUME_DROPDOWN = By.cssSelector(".size-guide-size-finder-dropdowns>span:nth-child(2)>select");
    public static By FIND_SIZE_BUTTON = By.cssSelector(".calculate-size-button>button.find-size-button");
    public static By CALCULATED_SIZE_RESULT = By.cssSelector(".calculate-size-results");
    public static By HOW_TO_MEASURE_TEXT = By.cssSelector(".size-guide-instructions>a>h2"); 
    public static By HOW_TO_MEASURE_ACCORDION = By.cssSelector(".size-guide-instructions");
    public static By BRA_SIZE_GUIDE_INSTRUCTION_CONTENT = By.cssSelector(".instruction-container>.instruction-text");
    public static By WATCH_NOW_BUTTON = By.cssSelector(".size-guide-play-video");
    public static By INSTRUCTIONAL_VIDEO = By.cssSelector(".size-image>.instructional-video");
	
    
	public static By ADD_TO_CART_BUTTON = By.cssSelector("button.product-info__atc.button.button--red.button--full.js-loop-atc");
	public static By JOIN_THE_WAITLIST = By.cssSelector("button.product-info__atc.button.button--red.button--full.js-loop-atc.email-when-in-stock");
	public static By QUANTITY = By.cssSelector(".product-info__atc");
	public static By PLUS_BUTTON = By.cssSelector(".pdp.plusBtn");
	public static By UPDATED_QUANTITY = By.cssSelector(".pdp.updatedQty");
	public static By MINUS_BUTTON = By.cssSelector(".pdp.minusBtn");
	public static By PAIR_GUARANTEE = By.cssSelector("div.product-accordion.container> ul > li:nth-child(2) > div:nth-child(1) > a");
	public static By SHIPING_AND_RETURNS = By.cssSelector("div.product-accordion.container> ul > li:nth-child(3) > div:nth-child(1) > a");
	public static By CHECKOUT_BUTTON = By.cssSelector(".inline-cart__action-btns > a");
	
	//Home Page Locators
	public static By MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > a");
	public static By NEW_ARRIVALS_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
	public static By ALL_UNDERWEAR_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(2) > ul > li:nth-child(1) > a");
	public static By TANK_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(3) > ul > li:nth-child(5) > a");
	public static By DRESS_SHIRTS_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(4) > ul > li:nth-child(2) > a");
	public static By ALL_MENS_COLLECTIONS_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(5) > ul > li:nth-child(1) > a");	
	public static By WHATS_NEW_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(1) > div");
	public static By SECOND_SKIN_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(5) > ul > li:nth-child(3) > a");
	public static By ALL_UNDERSHIRTS_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(3) > ul > li:nth-child(1) > a");
	
	public static By WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > a");
	public static By WHATS_NEW_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(1) > div");
	public static By NEW_ARRIVALS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
	public static By BRA_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(1) > ul > li:nth-child(2) > a");
	public static By ALL_PANTIES_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(3) > ul > li:nth-child(1) > a");
	public static By TEES_AND_POLOS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(3) > ul > li:nth-child(2) > a");
	public static By ALL_WOMENS_COLLECTIONS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(4) > ul > li:nth-child(1) > a");
	public static By ALL_CLOTHING_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(3) > ul > li:nth-child(1) > a");
	
	public static By UNDERWEAR_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(4) > a");
	public static By MEN_IN_UNDERWEAR_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(4) > div > ul > li:nth-child(1) > div");
	
	public static By SHOPBYCOLLECTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > a");
	public static By MEN_IN_SHOPBYCOLLECTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > div > ul > li:nth-child(1) > div");
	public static By COTTON_BASICS_SHOPBYCOLLECTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > div > ul > li:nth-child(1) > ul > li:nth-child(7) > a");
	
	public static By PACKS = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > a");
	public static By MEN_IN_PACKS = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > div > ul > li:nth-child(1) > div");
	public static By ALL_MENS_PACKS_IN_PACKS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > div > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
	public static By ALL_WOMENS_PACKS_IN_PACKS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > div > ul > li:nth-child(2) > ul > li:nth-child(1) > a");
	public static By COOL_COTTON_IN_MENS_COLLECTIONS = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(5) > ul > li:nth-child(4) > a");
	public static By CLOSE_BTN = By.xpath("//div[@class='size-chart-overlay' ][@style='display: flex;']//a[@class='close_chart_modal']");
	public static By BRA = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > a");
	public static By FIRST_ANCHOR_BUTTON=By.cssSelector(".anchor-buttons>.button-wrapper:nth-child(1)>button");
	public static By FORTH_ANCHOR_BUTTON=By.cssSelector(".anchor-buttons>.button-wrapper:nth-child(4)>button");
	public static By FIRST_BRA_PRODUCT_HEAD_LINE_TEXT_LINK = By.cssSelector(".product-meta__title");
	public static By SCOOP_BRALETTE_PRODUCT_TEXT_LINK = By.xpath("//*[@class='product-meta__title' and contains(text(),'Second Skin Scoop Bralette')]");
	//Collection Page Locators
	public static By STYLE_COROSALS = By.cssSelector("div.hero-interactive__slider.slick-initialized");
	public static By TOTAL_NO_OF_COROSALS = By.cssSelector(".hero-interactive-slide.slick-slide");
//	public static By MENS_ALL_UNDERWEAR_FIRST_PRODUCT_IMAGE = By.cssSelector(".product-image-container > a");
//	public static By THIRD_PRODUCT_IMAGE = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > div:nth-child(1) > a > img");
//	public static By THIRD_PRODUCT_HEAD_LINE_TEXT = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > a > h2");
//	public static By THIRD_PRODUCT_REVIEW_STARS = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(3) > a > div");
//	public static By FIRST_PRODUCT_IMAGE = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(1) > div > a > img");
//	public static By FIRST_PRODUCT_IMAGE = By.cssSelector(".product-image");
	public static By FIRST_PRODUCT_IMAGE = By.cssSelector(".product-image-container");
	public static By FIRST_PRODUCT_HEAD_LINE_TEXT_LINK = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(1) > a > h2");
	//*public static By FIRST_PRODUCT_REVIEW_STARS = By.cssSelector("div.mega-collection-grid__row:nth-child(3) > div:nth-child(1) > a > div");
	
	public static By THIRD_PRODUCT_IMAGE = By.cssSelector(".product-image");
	public static By THIRD_PRODUCT_HEAD_LINE_TEXT = By.cssSelector(".product-meta__title");
	public static By THIRD_PRODUCT_REVIEW_STARS = By.cssSelector(".yotpo");
	
	public static By MAIN_HEADING_OF_SELECTED_CATEGORY = By.cssSelector("div.collection-title-bar__content > h1");
	public static By ALL_FILTERS = By.cssSelector("div.mega-collection-filters > div > a");
	public static By DISPLAYED_ALL_SELECTED_OPTIONS = By.cssSelector("div.js-mega-collection-desktop-filter-tags > button");
	public static By CLEAR_FILTER_BUTTON = By.cssSelector("div.mega-collection-filters--controls > a");
	public static By FIRST_ITEM_IN_DISPLAYED_LIST = By.cssSelector("div.js-mega-collection-desktop-filter-tags > button:nth-child(1)");
	public static By TOTAL_COUNTS_OF_ITEMS = By.cssSelector("div.mega-collection-filters--controls__count > span");
	public static By LAST_FILTER = By.cssSelector(".mega-collection-filters > select");
	public static By SORTBYPRICE_HIGH_TO_LOW_FILTER_OPTION = By.cssSelector(".js-mega-collection-filters-sort > option:nth-child(2)");
	
    //Collection Page
	public static By BRA_HERO_INTERACTIVE_SLIDE_TITLE = By.xpath("//div[@title='Scoop Bralette']");
	public static By BRALETTE_COLLECTION_FIRST_PRODUCT_TITLE = By.cssSelector(".mega-collection-grid__row>div:nth-child(1)>a>h2");
}
