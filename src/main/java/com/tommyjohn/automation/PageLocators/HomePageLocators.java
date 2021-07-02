package com.tommyjohn.automation.PageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;

public class HomePageLocators{

	public static By HOMEPAGE_LOGO = By.cssSelector("a.header-logo");
	public static By SEARCH_ICON_IMAGE= By.cssSelector("form>.header-search-input-icon>svg");
	//public static By NEWARRIVALS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(1) > a");
	//public static By MEN_IN_NEWARRIVALS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(1) > div > ul > li:nth-child(1) > div");

	public static By MEN_CATEGORY = By.cssSelector(".level-zero-list>.level-zero-container:nth-child(1)> .level-zero-item >a");
	public static By WOMEN_CATEGORY = By.cssSelector(".level-zero-list>.level-zero-container:nth-child(2)> .level-zero-item >a");
	public static By FINAL_SALE = By.cssSelector(".level-zero-list>.level-zero-container:nth-child(3)> .level-zero-item >a");
	
	
	public static By FIRST_lEVEL1_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list >li.level-one-container:nth-child(2) > div > .level-one-item >a");
	public static By SECOND_lEVEL1_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list >li.level-one-container:nth-child(3) > div > .level-one-item >a");
	public static By THIRD_lEVEL1_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list >li.level-one-container:nth-child(4) > div > .level-one-item >a");
	public static By FOURTH_lEVEL1_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list >li.level-one-container:nth-child(5) > div > .level-one-item >a");
	public static By FIFTH_lEVEL1_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list >li.level-one-container:nth-child(6) > div > .level-one-item >a");
	public static By SIXTH_lEVEL1_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list >li.level-one-container:nth-child(7) > div > .level-one-item >a");
	public static By SEVENTH_lEVEL1_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list >li.level-one-container:nth-child(8) > div > .level-one-item >a");

	public static By SHOPALL_LINK = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list >li.shop-all-item > a");
	
	public static By FIRST_lEVEL2_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list >li:nth-child(3) > div >a");
	public static By SECOND_lEVEL2_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list >li:nth-child(4) > div >a");
	public static By THIRD_lEVEL2_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list >li:nth-child(5) > div >a");
	public static By FOURTH_lEVEL2_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list >li:nth-child(6) > div >a");
	public static By FIFTH_lEVEL2_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list >li:nth-child(7) > div >a");
	public static By SIXTH_lEVEL2_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list >li:nth-child(8) > div >a");
	public static By SEVENTH_lEVEL2_CATEGORY = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list >li:nth-child(9) > div >a");
	
	public static By FIRST_LEVEL2_LINK = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list > li.links-only > div:nth-child(2) >a");
	public static By SECOND_LEVEL2_LINK = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list > li.links-only > div:nth-child(3) >a");
	public static By THIRD_LEVEL2_LINK = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list > li.links-only > div:nth-child(4) >a");
	public static By FOURTH_LEVEL2_LINK = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list > li.links-only > div:nth-child(5) >a");
	public static By FIFTH_LEVEL2_LINK = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list > li.links-only > div:nth-child(6) >a");
	public static By SIXTH_LEVEL2_LINK = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list> li.active > ul.level-two-list > li.links-only > div:nth-child(7) >a");

	
	
//	public static By ALL_NEW_ARRIVALS_LINK_IN_MEN_CATEGORY = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.shop-all-item >a");
//	public static By ALL_UNDERWEAR_LINK_IN_MEN_CATEGORY = By.cssSelector(".level-one-container:nth-child(3) > .level-two-list > li.shop-all-item >a");
//	public static By ALL_UNDERSHIRTS_LINK_IN_MEN_CATEGORY = By.cssSelector(".level-one-container:nth-child(4) > .level-two-list > li.shop-all-item >a");
//	public static By ALL_LOUNGENSLEEP_LINK_IN_MEN_CATEGORY = By.cssSelector(".level-one-container:nth-child(5) > .level-two-list > li.shop-all-item >a");
//	public static By ALL_CLOTHING_LINK_IN_MEN_CATEGORY = By.cssSelector(".level-one-container:nth-child(6) > .level-two-list > li.shop-all-item >a");
//	public static By ALL_SOCKS_LINK_IN_MEN_CATEGORY = By.cssSelector(".level-one-container:nth-child(7) > .level-two-list > li.shop-all-item >a");

//	public static By MENS_NEWARRIVALS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.level-two-container:nth-child(3)> div> a");
//	public static By MENS_TJxPRIDE_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.level-two-container:nth-child(4)> div> a");
//	public static By MENS_UNDERWEAR_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.level-two-container:nth-child(5)> div> a");
//	public static By MENS_LOUNGENSLEEP_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.level-two-container:nth-child(6)> div> a");
//	public static By MENS_CLOTHING_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.links-only > div.level-two-item:nth-child(2) > a");
//	public static By MENS_NA_PACKS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.links-only > div.level-two-item:nth-child(3) > a");
//	public static By MENS_BESTSELLERS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.links-only > div.level-two-item:nth-child(4) > a");
//	public static By MENS_GIFTCARD_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(2) > .level-two-list > li.links-only > div.level-two-item:nth-child(5) > a");
//
//	
//	public static By MENS_BOXERBRIEF_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(3) > .level-two-list > li.level-two-container:nth-child(3)> div> a");
//	public static By MENS_TRUNK_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(3) > .level-two-list > li.level-two-container:nth-child(4)> div> a");
//	public static By MENS_RELAXEDFITBOXER_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(3) > .level-two-list > li.level-two-container:nth-child(5)> div> a");
//	public static By MENS_SQUARECUT_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(3) > .level-two-list > li.level-two-container:nth-child(6)> div> a");
//	public static By MENS_BRIEF_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(3) > .level-two-list > li.level-two-container:nth-child(7)> div> a");
//	public static By MENS_LEGGING_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(3) > .level-two-list > li.level-two-container:nth-child(8)> div> a");
//	public static By MENS_UW_PACKS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(3) > .level-two-list > li.level-two-container:nth-child(9)> div> a");
//
//	public static By MENS_CREWNECK_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(4) > .level-two-list > li.level-two-container:nth-child(3)> div> a");
//	public static By MENS_VNECK_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(4) > .level-two-list > li.level-two-container:nth-child(4)> div> a");
//	public static By MENS_DEEPVNECK_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(4) > .level-two-list > li.level-two-container:nth-child(5)> div> a");
//	public static By MENS_TANKTOP_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(4) > .level-two-list > li.level-two-container:nth-child(6)> div> a");
//	public static By MENS_US_PACKS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(4) > .level-two-list > li.level-two-container:nth-child(7)> div> a");
//		
//	
//	public static By MENS_TOPS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(5) > .level-two-list > li.level-two-container:nth-child(3)> div> a");
//	public static By MENS_BOTTOMS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(5) > .level-two-list > li.level-two-container:nth-child(4)> div> a");
//	
//	public static By MENS_TEESPOLOS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(6) > .level-two-list > li.level-two-container:nth-child(3)> div> a");
//	public static By MENS_PANTSNSHORTS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(6) > .level-two-list > li.level-two-container:nth-child(4)> div> a");
//	public static By MENS_SWEATERSWEATSHIRT_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(6) > .level-two-list > li.level-two-container:nth-child(5)> div> a");
//	public static By MENS_BUTTONDOWNS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(6) > .level-two-list > li.level-two-container:nth-child(6)> div> a");
//	public static By MENS_JACKETOUTWEAR_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(6) > .level-two-list > li.level-two-container:nth-child(7)> div> a");
//	public static By MENS_SOCKS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(6) > .level-two-list > li.level-two-container:nth-child(8)> div> a");
//	public static By MENS_CLOTHINGPACKS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(6) > .level-two-list > li.level-two-container:nth-child(9)> div> a");
//
//	public static By MENS_OVERTHECALF_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(7) > .level-two-list > li.level-two-container:nth-child(3)> div> a");
//	public static By MENS_CALF_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(7) > .level-two-list > li.level-two-container:nth-child(4)> div> a");
//	public static By MENS_NOSHOW_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(7) > .level-two-list > li.level-two-container:nth-child(5)> div> a");
//	public static By MENS_YOUTH_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(7) > .level-two-list > li.level-two-container:nth-child(6)> div> a");
//
//	public static By MENS_SECONDSKIN_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(8) > .level-two-list > li.level-two-container:nth-child(3)> div> a");
//	public static By MENS_COOLCOTTON_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(8) > .level-two-list > li.level-two-container:nth-child(4)> div> a");
//	public static By MENS_360SPORT_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(8) > .level-two-list > li.level-two-container:nth-child(5)> div> a");
//	public static By MENS_AIR_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(8) > .level-two-list > li.level-two-container:nth-child(6)> div> a");
//	public static By MENS_GOANYWHERE_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(8) > .level-two-list > li.level-two-container:nth-child(7)> div> a");
//	public static By MENS_COTTONBASIC_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(8) > .level-two-list > li.links-only > div.level-two-item:nth-child(2) > a");
//	public static By MENS_SLEAKHEAT_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(8) > .level-two-list > li.links-only > div.level-two-item:nth-child(2) > a");
//	public static By MENS_KEVINHARTFAVS_COLLECTION_PAGELINK = By.cssSelector(".level-one-container:nth-child(8) > .level-two-list > li.links-only > div.level-two-item:nth-child(2) > a");
//	
//	
//	public static By NEW_ARRIVALS_IN_WOMEN_CATEGORY = By.cssSelector(".level-one-list >li.level-one-container:nth-child(2) > div > .level-one-item >a");
//	public static By BRAS_IN_WOMEN_CATEGORY = By.cssSelector(".level-one-list >li.level-one-container:nth-child(3) > div > .level-one-item >a");
//	public static By UNDERWEAR_IN_WOMEN_CATEGORY = By.cssSelector(".level-one-list >li.level-one-container:nth-child(4) > div > .level-one-item >a");
//	public static By LOUNGENSLEEP_IN_WOMEN_CATEGORY = By.cssSelector(".level-one-list >li.level-one-container:nth-child(5) > div > .level-one-item >a");
//	public static By CLOTHING_IN_WOMEN_CATEGORY = By.cssSelector(".level-one-list >li.level-one-container:nth-child(6) > div > .level-one-item >a");
//	public static By COLLECTIONS_IN_WOMEN_CATEGORY = By.cssSelector(".level-one-list >li.level-one-container:nth-child(7) > div > .level-one-item >a");
//	
//	
//
//	
//	
//	
//	public static By MENS_SALE = By.cssSelector("li.active> div:nth-child(2)> ul.level-one-list >li.level-one-container:nth-child(2) > div > .level-one-item >a");
//	
//	
//	
//	
//	
//	
//	
//	
//	public static By TANK_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(3) > ul > li:nth-child(5) > a");
//	public static By DRESS_SHIRTS_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(6) > ul > li:nth-child(5) > a");
//	public static By ALL_CLOTHING_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(6) > ul > li:nth-child(1) > a");	
//	public static By ALLSOCKS_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(5) > ul > li:nth-child(1) > a");
//	
//	public static By BUTTON_DOWN_SHIRT_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(6) > ul > li:nth-child(5) > a");
//	public static By PANTS_AND_SHORTS_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(6) > ul > li:nth-child(6) > a");
//	public static By JACKETS_AND_OUTWEARS_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(6) > ul > li:nth-child(4) > a");
//	public static By CAMISOLE_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(2) > ul > li:nth-child(8) > a");
//	public static By TOPS_AND_TEES_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(5) > ul > li:nth-child(2) > a");
//	public static By HOODIES_AND_JACKETS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(5) > ul > li:nth-child(4) > a");
//	public static By PANTS_AND_SHORTS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(5) > ul > li:nth-child(5) > a");
//
//	
//	
//	
////	public static By BRAS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(3) > ul > li:nth-child(1) > a");
////	public static By NEW_ARRIVALS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
//	public static By ALL_BRAS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(3) > ul > li:nth-child(1) > a");
//	public static By BOYSHORT_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(2) > ul > li:nth-child(2) > a");
////	public static By ALL_WOMENS_COLLECTIONS_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(4) > ul > li:nth-child(1) > a");
//	public static By ALL_CLOTHING_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(5) > ul > li:nth-child(1) > a");
//
//	public static By UNDERWEAR_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(4) > a");
//	public static By MEN_IN_UNDERWEAR_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(4) > div > ul > li:nth-child(1) > div");
//
//	//	public static By SHOPBYCOLLECTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > a");
//	//public static By MEN_IN_SHOPBYCOLLECTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > div > ul > li:nth-child(1) > div");
//	//	public static By COTTON_BASICS_SHOPBYCOLLECTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > div > ul > li:nth-child(1) > ul > li:nth-child(9) > a");
//	public static By BRAS = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > a");
//	public static By PACKS = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > a");
//	public static By MEN_IN_PACKS = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > div > ul > li:nth-child(1) > div");
//	public static By ALL_MENS_PACKS_IN_PACKS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > div > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
//	public static By ALL_WOMENS_PACKS_IN_PACKS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > div > ul > li:nth-child(2) > ul > li:nth-child(1) > a");
//	//	public static By COOL_COTTON_IN_MENS_COLLECTIONS = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(5) > ul > li:nth-child(4) > a");
//	public static By MYSTERYPACK_IN_PACKS = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > div > ul > li:nth-child(2) > ul > li:nth-child(3) > a");
//	public static By TEMP_TAB = By.cssSelector(".header-desktop-left > ul > li:nth-child(7) > a");
//
	public static By SEARCH_ICON = By.id("constructorio-search");
	public static By SEARCH_ICON_FORM_TAG = By.cssSelector(".header-search-form");
	public static By SEARCH_TEXTBOX = By.cssSelector(".nextopia-search");
	public static By POPULAR_SEARCHES = By.cssSelector(".autocomplete-suggestion-search-suggestions");
	public static By PRODUCT_MATCHES_TITLE = By.cssSelector(".desktop-search-product-tile-title");
//	public static By SEARCHRESULT_KEYWORD = By.cssSelector(".nxt-ac-section-container > .nxt-ac-item");
//	public static By SEARCHRESULT_PRODUCT = By.cssSelector(".nxt-ac-products-container > .nxt-ac-item");
	
	public static By SEARCHPAGE_TITLE = By.cssSelector(".collection-search-title-bar__title");
	public static By SEARCHPAGE_DESC= By.cssSelector(".collection-title-bar__description");
	public static By SEARCHPAGE_ITEMCOUNT= By.cssSelector(".mega-collection-filters--controls__count");
	public static By SEARCHPAGE_FILTER= By.cssSelector(".collection-filter");
	
	public static By SEARCHPAGE_PRODUCTS = By.cssSelector(".product-item");
	public static By SEARCHPAGE_PRODUCT_IMAGE = By.cssSelector(".product-image-container > a > img");
	public static By SEARCHPAGE_PRODUCT_SWATCHES = By.cssSelector(".product-item__swatches");
	public static By SEARCHPAGE_PRODUCT_NAME = By.cssSelector(".product-meta__title");
	public static By SEARCHPAGE_PRODUCT_REVIEWS = By.cssSelector(".yotpo.bottomLine");
	public static By SEARCHPAGE_PRODUCT_PRICE = By.cssSelector(".product-meta__price");
	public static By SEARCHPAGE_PRODUCT_BADGE = By.cssSelector(".product-item__badge");	
	public static By RECENT_SEARCHES_TITLE = By.cssSelector(".recent-searches-title>span");
	public static By CLEAR_RECENT_SEARCHES = By.cssSelector(".search-value__clear>span");
	public static By RECENT_SEARCH_CONTAINER = By.cssSelector(".desktop-recent-search-container");
	public static By SEARCHPAGE_ALL_FILTERS = By.cssSelector("div.mega-collection-filters > div > a");
	public static By SEARCHPAGE_ALL_SELECTED_FILTER_OPTIONS = By.cssSelector("div.js-mega-collection-desktop-filter-tags >div> button");
	public static By SEARCHPAGE_CLEAR_FILTER = By.cssSelector("div.mega-collection-filters--controls > a");
	public static By SEARCHPAGE_LAST_FILTER = By.cssSelector(".mega-collection-filters > select");
	public static By AUTO_SUGGESTED_LINKS = By.cssSelector(".autocomplete-suggestions-content>a");
	public static By AUTO_SUGGESTED_PRODUCT_IMG = By.cssSelector(".search-product-image>a>img");
	public static By AUTO_SUGGESTED_PRODUCT_TILE_TITLE = By.cssSelector(".search-product-tile>a");
	
	

	public static By HELP_ICON = By.cssSelector("i.icon-help");
	public static By HELP_ICON_HELP_OPTION = By.cssSelector(".header-nav-dropdown > ul >li:nth-child(2) > a");
	public static By MYACCOUNT_OPTION = By.cssSelector(".header-nav-dropdown > ul >li:nth-child(1) > a");
	public static By SIGNIN_OPTION = By.cssSelector(".header-nav-dropdown > ul >li:nth-child(3) > a");
	//public static By CHAT_WITH_US_POPUP = By.cssSelector(".desktop.sf_large.scroll_top.scroll_bottom > div.scrollable_inner.jx_ui_Widget > div:nth-child(2) > a");
	public static By CHAT_WITH_US_POPUP = By.cssSelector(".jx_ui_Widget");
	public static By CHAT_WITH_US_POPUP_MINIMIZE = By.cssSelector(".meshim_widget_widgets_titleBar_MinimizeButton > div.overlay.jx_ui_Widget");

	//public static By CHAT_WITH_US_POPUP_MINIMIZE = By.cssSelector(".button_container.last_child.jx_ui_Widget > div > div");
	public static By CALL_US_OPTION = By.cssSelector(".header-nav-dropdown > ul > li:nth-child(3) > a");
	public static By TEXT_US_OPTION = By.cssSelector(".header-nav-dropdown > ul > li:nth-child(4) > a");
	public static By EMAIL_US = By.cssSelector(".header-nav-dropdown > ul > li:nth-child(5) > a");

	public static By ACCOUNT_NAV_DROPDOWN = By.cssSelector(".header-account-item-container > a");
	public static By REORDER = By.cssSelector("header-desktop-right > li:nth-child(3) >div > ul > li:nth-child(2) > a ");
	//	public static By CART_ICON = By.cssSelector("i.icon-shopping-cart");
	public static By CART_ICON = By.cssSelector("button.header-cart-btn > i");
	public static By CART_HEADING_TEXT = By.cssSelector(".inline-cart__col1 > h3");

	public static By ABOUT_LINK = By.linkText("About");
	public static By Careers = By.linkText("Careers");
	public static By PRESS_LINK = By.linkText("Press");
	public static By Reviews = By.linkText("Reviews");
	public static By MILITARY_DISCOUNT_LINK = By.linkText("Military Discount");
	public static By TEACHER_DISCOUNT_LINK = By.linkText("Student & Teacher Discount");
	public static By HEALTHCARE_DISC_LINK = By.linkText("Healthcare Hero Discount");
	public static By JOBS_LINK = By.linkText("Jobs");
	public static By PRIVACY_POLICY_LINK = By.linkText("Privacy Policy");
	public static By TERMS_AND_CONDITION_LINK = By.linkText("Terms & Conditions");
	public static By BLOG_LINK = By.linkText("Blog");

	public static By HELP_LINK = By.linkText("Help");
	public static By CONTACT_US_LINK = By.linkText("Contact & FAQ");
	public static By RETURNS_AND_EXCHANGES = By.linkText("Returns & Exchanges");
	public static By RETAILERS_LINK = By.linkText("Retailers");
	public static By KING_OF_PURSSIA_STORE_LINK = By.linkText("King of Prussia Store");
	public static By CHARLOTTE_STORE_LINK = By.linkText("Charlotte Store");
	public static By TOMMY_JOHN_STORES = By.linkText("Tommy John Stores");
	public static By STORE_LOCATOR_LINK = By.linkText("Store Locator");
	public static By SHIPPING_AND_RETURNS_LINK = By.linkText("Shipping & Return Policy");
	public static By NUMBER_LINK = By.linkText("1-800-708-3490");
	public static By LOYALTY_LINK = By.linkText("Loyalty");

	public static By TOMMYJOHN_REWARDS_LINK = By.linkText("Tommy John Rewards");
	public static By SHOP_WOMEN = By.linkText("Shop Women");
	public static By SHOP_MEN = By.linkText("Shop Men");
	public static By GIFT_CARD_LINK = By.linkText("Gift Cards");
	public static By FABRIC_GUIDE_LINK = By.linkText("Fabric Guide");
	
	public static By SIGN_IN_FOOTER_LINK= By.linkText("Sign In");
	public static By ORDER_HISTORY = By.linkText("Order History");

	public static By FACEBOOK_LINK = By.linkText("Facebook");
	public static By TWITTER_LINK = By.linkText("Twitter");
	public static By PINTEREST_LINK = By.linkText("Pinterest");
	public static By INSTAGRAM_LINK = By.linkText("Instagram");
	public static By YOUTUBE_LINK = By.linkText("YouTube");
	public static By GOOGLE_PLUS_LINK = By.linkText("Google+");
	
	public static By FACEBOOK_ICON = By.cssSelector(".footer-social_icons>div.footer-icons>a:nth-child(1)");
	public static By TWITTER_ICON = By.cssSelector(".footer-social_icons>div.footer-icons>a:nth-child(2)");
	public static By PINTEREST_ICON = By.cssSelector(".footer-social_icons>div.footer-icons>a:nth-child(3)");
	public static By INSTAGRAM_ICON = By.cssSelector(".footer-social_icons>div.footer-icons>a:nth-child(4)");
	public static By YOUTUBE_ICON = By.cssSelector(".footer-social_icons>div.footer-icons>a:nth-child(5)");
	
	public static By NEWSLETTER_TITLE= By.cssSelector(".footer-section_one>div>.shopify-section>.footer-newsletter>.newsletter_title");
	public static By NEWSLETTER_RADIO_BUTTONS = By.cssSelector(".footer-section_one>div>.shopify-section>section>form>.gender-container>span");
	public static By NEWSLETTER_INPUT_TEXTBOX = By.cssSelector(".footer-section_one>div>.shopify-section>section>form>.footer-newsletter__submit-form>input");
	public static By NEWSLETTER_SIGN_UP_BUTTON = By.cssSelector(".footer-section_one>div>.shopify-section>section>form>.footer-newsletter__submit-form>button");
	public static By NEWSLETTER_FORM_SUCCESS_MESSAGE = By.cssSelector(".footer-section_one>div>.shopify-section>section>form>div.footer-newsletter__form-success");
	public static By GIVE_FEEDBACK_CTA = By.cssSelector(".footer-feedback_btn");
	public static By DO_NOT_SELL_PERSONAL_INFO_LINK= By.linkText("Do Not Sell My Information");
	
	public static By CCPA_FORM_TITLE = By.cssSelector(".ccpa-form-first-step-container>.ccpa-form-title");
	public static By CCPA_STATE_OF_RESIDENCE_QSN = By.cssSelector(".ccpa-form-first-step-container>.ccpa-form>div>label");
	public static By STATE_DROPDOWN = By.cssSelector(".ccpa-form-first-step-container>.ccpa-form>div>select");
	public static By ERROR_MESSAGE = By.cssSelector(".ccpa-form--error");
	public static By NON_CALIFORNIA_USER_HINT_SECTION = By.cssSelector(".ccpa-form-noncalifornia-user");
	public static By BACK_TO_HOME_CTA = By.cssSelector(".ccpa-form-submit-contents__cta");
	public static By CALIFORNIA_USER_FORM_HEADING = By.cssSelector(".ccpa-form-california-user>div:nth-child(1)");
	public static By NAME_LABEL = By.cssSelector(".ccpa-form-label__name");
	public static By NAME_TEXTBOX = By.cssSelector(".ccpa-form--input__name");
	public static By EMAIL_LABEL = By.cssSelector(".ccpa-form-label__email");
	public static By EMAIL_TEXTBOX = By.cssSelector(".ccpa-form--input__email");
	public static By WOULD_LIKE_TO_HEADING = By.cssSelector(".ccpa-form-label__consent");
	public static By SUBMIT_REQUEST_CTA = By.cssSelector(".ccpa-form--submit");
	public static By SUCCESSFULLY_SUBMIT_MESSAGE = By.cssSelector(".ccpa-form-submit>.ccpa-form-description");
	public static By BACK_TO_HOME_CALIFORNIA = By.cssSelector("#shopify-section-section-ccpa-form > div > div > div.ccpa-form-submit-contents__cta"); 
	
    public static By RFY_SWATCH_COUNT = By.cssSelector(".dy-rec--products>div:nth-child(1) > div > div.product-item__swatches:nth-child(2)> div > div");
	public static By RFY_PRODUCT_IMG_COLORNAME = By.cssSelector(".dy-rec--products>div:nth-child(1) > div > div>a");
    
//	public static By SECOND_SKIN_IN_MEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(7) > ul > li:nth-child(1) > a");
//	public static By COOL_COTTON_IN_MENS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(7) > ul > li:nth-child(2) > a");
//	public static By COTTON_BASICS_IN_MENS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > div > ul > li:nth-child(7) > ul > li:nth-child(7) > a");
//	public static By SHOPBYCOLLECTION = By.cssSelector(".header-desktop-left > ul > li:nth-child(2) > a");
//	
//	public static By MIXANDMATCH = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > div > ul > li:nth-child(1) > ul > li:nth-child(3) > a");
//	public static By GIFT_GUIDE = By.cssSelector(".header-desktop-left >ul >li:nth-child(7) >a");
//	public static By GIFTCARDS = By.cssSelector(".header-desktop-left >ul >li:nth-child(7) > div > ul > li:nth-child(3) > ul >li >a");
//	//public static By GIFT_CARD_IN_NEWARRIVALS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(1) > div > ul > li:nth-child(5) > ul > li:nth-child(1) > a");
//	public static By GIFT_CARD_IN_NEWARRIVALS_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(1) > div > ul > li:nth-child(3) > ul > li > a");
//	public static By BRA_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > a");
//	public static By SHOP_ALL_BRAS = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > div > ul > li:nth-child(1) > ul > li:nth-child(1) > a");
//	
//	public static By BRAS_TITLE = By.cssSelector(".header-desktop-left > ul > li:nth-child(5) > div > ul > li:nth-child(1) > div");
//	public static By ALL_PANTIES_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(2) > ul > li:nth-child(1) > a");
//	public static By AIR_IN_WOMEN_CATEGORY = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(6) > ul > li:nth-child(3) > a");
//
//	public static By TRIANGLE_BRALETTE = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(3) > ul > li:nth-child(6) > a");
//	public static By SCOOP_BRALETTE = By.cssSelector(".header-desktop-left > ul > li:nth-child(3) > div > ul > li:nth-child(3) > ul > li:nth-child(5) > a");
//
//	public static By HISANDHERPACKS = By.cssSelector(".header-desktop-left > ul > li:nth-child(6) > div > ul > li:nth-child(2) > ul > li:nth-child(6) > a");
}
