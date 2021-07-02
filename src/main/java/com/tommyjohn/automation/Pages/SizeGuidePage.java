package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.SizeGuideComponents;

public class SizeGuidePage extends SizeGuideComponents
{
	WebDriver driver;

	public SizeGuidePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void verifyMenUnderwearSizeGuidePage() throws Exception {

		new SizeGuideComponents(driver).validateMenUnderwearSizeGuidePage();

	}
	public void verifyMenDressShirtSizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateMenDressShirtSizeGuidePage();
	}
	public void verifyMenUnderShirtSizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateMenUnderShirtSizeGuidePage();
	}
	public void verifyMen_GoAnywhereShirt_SizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateMen_GoAnyWhere_SizeGuidePage();
	}
	public void verifyMen_StretchedWovenBottom_SizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateMen_StretchedWovenBottom_SizeGuidePage();
	}
	public void verifyMen_StretchedWovenBlazer_SizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateMen_StretchedWovenBlazer_SizeGuidePage();
	}
	public void verifyWomenUnderwearSizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateWomenUnderwearSizeGuidePage();
	}
	public void verifyWomenUnderShirtSizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateWomenUnderShirtSizeGuidePage();
	}
	public void verifyWomenT_ShirtSizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateWomenT_ShirtsSizeGuidePage();
	}
	public void verifyBraSizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validateBraSizeGuidePage();
	}
	public void verify_WomensTop_SizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validate_WomensTop_SizeGuidePage();
	}
	public void verify_Womens_WovenBlazer_SizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validate_Womens_WovenBlazer_SizeGuidePage();
	}
	public void verify_WomensBottoms_SizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validate_WomensBottom_SizeGuidePage();
	}
	public void verify_Packs_SizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validate_pack_SizeGuidePage();
	}
	public void verify_Bundle_SizeGuidePage() throws Exception
	{
		new SizeGuideComponents(driver).validate_bundle_SizeGuidePage();
	}
}
