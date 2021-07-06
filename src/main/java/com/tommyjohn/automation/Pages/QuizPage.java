package com.tommyjohn.automation.Pages;

import org.openqa.selenium.WebDriver;

import com.tommyjohn.automation.Components.QuizPageComponents;

public class QuizPage extends QuizPageComponents
{
	WebDriver driver;
	public QuizPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public void VerifyMensQuizFlow() throws Exception
	{
		new QuizPageComponents(driver).MensQuizFlow();
	}
	
	public void VerifyMensRetakeQuizFlow() throws Exception
	{
		new QuizPageComponents(driver).MensRetakeQuizFlow();
	}
	public void VerifyMensResultPage() throws Exception
	{
		new QuizPageComponents(driver).MensResultPage();
	}

	
	public void VerifyWomensQuizFlow() throws Exception
	{
		new QuizPageComponents(driver).WomensQuizFlow();
	}
	
	public void VerifyWomensRetakeQuizFlow() throws Exception
	{
		new QuizPageComponents(driver).WomensRetakeQuizFlow();
	}
	public void VerifyWomensResultPage() throws Exception
	{
		new QuizPageComponents(driver).WomensResultPage();
	}
	
	public void VerifyBraQuizFlow() throws Exception
	{
		new QuizPageComponents(driver).BraQuizFlow();
	}
	public void VerifyBraRetakeQuizFlow() throws Exception
	{
		new QuizPageComponents(driver).BraRetakeQuizFlow();
	}
	public void VerifyBraResultPage() throws Exception
	{
		new QuizPageComponents(driver).BraResultPage();
	}
	public void VerifyBraQuizWithCustomInput() throws Exception
	{
		new QuizPageComponents(driver).BraQuiz_CustomInputs();
	}
	public void VerifyBraQuizWithNoPreferenceOption() throws Exception
	{
		new QuizPageComponents(driver).Bra_NoPreferenceFunctionality();
	}
}
