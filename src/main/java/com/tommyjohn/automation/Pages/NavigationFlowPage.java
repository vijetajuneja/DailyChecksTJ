package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.NavigationFlowComponents;

public class NavigationFlowPage extends NavigationFlowComponents
{

	WebDriver driver;
	public NavigationFlowPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
	}

	public void NavigateToAllNewArrivalInMenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoAllNewArrivalsInMenCategory();
	}
	
	public void NavigateToAllNewArrivalInWomenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoAllNewArrivalsInWomenCategory();
	}
	
	public void NavigateToAllMensSaleInFinalSaleCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoAllMensSaleInFinalSaleCategory();
	}
	public void NavigateToAllSocksInMenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoAllSocksInMenCategory();
	}
	public void NavigateToAllUnderwearInWomenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoAllUnderwearInWomenCategory();
	}	
	
	public void NavigateToBoxerBriefInMensUnderwearCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoBoxerBriefInMensUnderwearCategory();
	}
	public void NavigateToTeesAndPolosInMenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoTeesAndPolosInMensClothingCategory();
	}
	public void NavigateToScoopBraletteInWomensBrasCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoScoopBraletteInWomensBrasCategory();
	}
	public void NavigateToComfortSmoothingInWomenCollectionsCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoComfortSmoothingInWomenCollectionCategory();
	}
	public void NavigateToWomenSaleUnderwearInFinalSaleCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoWomenSaleUnderwearInFinalSaleCategory();
	}
	public void NavigateToVNeckUndershirtsInMenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoVNeckInMenUndershirtsCategory();
	}
	public void NavigateToTopsInMensLoungeAndSleepCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoTopsLoungeAndSleepInMenCategory();
	}
	public void NavigateToCalfSocksInMenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoCalfSocksInMenCategory();
	}
	public void NavigateToCheeckyUnderwearInWomenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoCheekyUnderwearInWomenCategory();
	}
	public void NavigateToMensLoungeAndSleepInFinalSaleCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoMensLoungeAndSleepInFinalSaleCategory();
	}
	public void NavigateToButtonDownsInMenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoButtonDownsInMenCategory();
	}
	public void NavigateToDressesInWomenCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoDressesInWomenCategory();
	}
	public void NavigateToPacksInWomenLoungeAndSleepCategory() throws Exception
	{
		new NavigationFlowComponents(driver).NavigatetoPacks_LoungeAndSleep_InWomenCategory();
	}
}
