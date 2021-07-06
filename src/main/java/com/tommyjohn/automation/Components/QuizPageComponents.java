package com.tommyjohn.automation.Components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.tommyjohn.automation.PageLocators.QuizPageLocators;

public class QuizPageComponents extends QuizPageLocators
{
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	SoftAssert softassert = new SoftAssert();
	public JavascriptExecutor js;
	java.util.List<WebElement> WebList = null;
	String Allclasses = null;
	String ExpectedText = null;
	String QuestionText;
	List<WebElement> SelectedOptions = new ArrayList<WebElement>();
	List<WebElement> OnSelectClasses = new ArrayList<WebElement>();
	String[] list1 ;
	String[] list2;
	List<String> summary_result = new ArrayList<String>();
	List<String> result_page_selected_value = new ArrayList<String>();
	String text;
	String Question;
	String Education_card_title;
	String BraFirstQsnTemplate;
	String CustomInputData= "TestData";
	public QuizPageComponents(WebDriver driver)
	{
		this.driver = driver;
	}

	public void MensQuizFlow() throws Exception
	{
		new HomePageComponents(driver).navigateToMensQuizPage();
		Thread.sleep(3000);
		QuizFlow();
		Reporter.log("Mens Quiz Pages are Displayed :: Correct");
	}

	public void MensRetakeQuizFlow() throws Exception
	{
		new HomePageComponents(driver).navigateToMensQuizPage();
		Thread.sleep(5000);
		RetakeQuizFlow();
		Reporter.log("Mens Retake Quiz Flow is Displayed :: Correct");
	}
	public void MensResultPage() throws Exception
	{
		new HomePageComponents(driver).navigateToMensQuizPage();
		Thread.sleep(3000);
		QuizFlow();
		ResultPage();
	}

	public void WomensQuizFlow() throws Exception
	{
		new HomePageComponents(driver).navigateToWomensQuizPage();
		Thread.sleep(3000);
		QuizFlow();
		Reporter.log("Womens Quiz Pages are Displayed :: Correct");
	}

	public void WomensRetakeQuizFlow() throws Exception
	{
		new HomePageComponents(driver).navigateToWomensQuizPage();
		Thread.sleep(3000);
		RetakeQuizFlow();
		Reporter.log("Womens Retake Quiz Flow is Displayed :: Correct");
	}

	public void WomensResultPage() throws Exception
	{
		new HomePageComponents(driver).navigateToWomensQuizPage();
		Thread.sleep(5000);
		QuizFlow();
		ResultPage();
	}

	public void BraQuizFlow() throws Exception
	{
		new HomePageComponents(driver).navigateToWomensBraQuizPage();
		Thread.sleep(3000);
		Bra_Quiz_Flow();
		Reporter.log("Bra Quiz Pages are Displayed :: Correct");
	}

	public void BraRetakeQuizFlow() throws Exception
	{
		new HomePageComponents(driver).navigateToWomensBraQuizPage();
		Thread.sleep(3000);
		Bra_Retake_QuizFlow();
		Reporter.log("Bra Retake Quiz Flow is Displayed :: Correct");
	}
	public void BraResultPage() throws Exception
	{
		new HomePageComponents(driver).navigateToWomensBraQuizPage();
		Thread.sleep(5000);
		Bra_Quiz_Flow();
		ResultPage();
	}
	public void BraQuiz_CustomInputs() throws Exception
	{
		new HomePageComponents(driver).navigateToWomensBraQuizPage();
		Thread.sleep(5000);
		CustomInput_forQSNTemplates();
	}
	public void Bra_NoPreferenceFunctionality() throws Exception
	{
		new HomePageComponents(driver).navigateToWomensBraQuizPage();
		Thread.sleep(5000);
	    Check_NoPreferenceOptions();
	}

	public String QuizFlow() throws Exception
	{

		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(GET_STARTED_CTA));
		softassert.assertTrue(driver.findElement(GET_STARTED_CTA).isDisplayed(), "Get started button is not displayed");
		softassert.assertEquals(driver.findElement(GET_STARTED_CTA).getText(), "Get Started" , "Text changed for quiz start CTA");
		element = driver.findElement(GET_STARTED_CTA);
		js.executeScript("arguments[0].click();", element);
		Reporter.log("'Get Started' cta Displayed :: Clickable");

		//First question page
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		softassert.assertTrue(driver.findElement(INSTRUCTION_HEADING).isDisplayed(), "First question page instruction heading is not displayed");
		softassert.assertTrue(driver.findElement(QUESTION_HEADING).isDisplayed(), "First question page heading is not displayed");
		QuestionText= driver.findElement(QUESTION_HEADING).getText();
		WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
		if(!(WebList.size()>0)) 
			throw new Exception("No options are displayed on first question page");
		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		softassert.assertEquals(driver.findElement(NEXT_CTA).getText(), "Next","Text changed for 'Next' cta on first question page");
		if(!Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not disabled by default on first question page");
		for(int i=1; i<WebList.size()-1; i++)
		{
			element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));
			js.executeScript("arguments[0].click();", element);
			SelectedOptions.add(element);
		}
		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		if(Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not enabled with selected options on first question page");
		element = driver.findElement(NEXT_CTA);
		js.executeScript("arguments[0].click();", element);
		Reporter.log("Quiz First question page is displayed :: Correct");

		//Second question page
				wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(PREVIOUS_ARROW));
		Thread.sleep(5000);
		softassert.assertTrue(driver.findElement(INSTRUCTION_HEADING).isDisplayed(), "second question page instruction heading is not displayed");
		softassert.assertTrue(driver.findElement(QUESTION_HEADING).isDisplayed(), "second question page heading is not displayed");
		softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on second question page");
		String Second_question= driver.findElement(QUESTION_HEADING).getText();
		WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
		if(!(WebList.size()>0)) 
			throw new Exception("No options are displayed on second question page");
		softassert.assertEquals(driver.findElement(NEXT_CTA).getText(), "Next","Text changed for 'Next' cta on Second question page");
		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		if(!Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not disabled by default on second question page");
		element= driver.findElement(PREVIOUS_ARROW);
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		ExpectedText = driver.findElement(QUESTION_HEADING).getText();
		softassert.assertEquals(QuestionText, ExpectedText, "wrong navigation after click on back arrow on second question page");
		CheckPreselect();

		driver.findElement(NEXT_CTA).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
		for(int i=1; i<WebList.size()-1; i++)
		{
			element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));
			js.executeScript("arguments[0].click();", element);
			SelectedOptions.add(element);
		}

		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		if(Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not enabled with selected options on second question page");
		element = driver.findElement(NEXT_CTA);
		js.executeScript("arguments[0].click();", element);
		Reporter.log("Quiz Second question page is displayed :: Correct");


		//Third question page
		//		wait = new WebDriverWait(driver, 30);
		//		wait.until(ExpectedConditions.presenceOfElementLocated(PREVIOUS_ARROW));
		Thread.sleep(5000);
		softassert.assertTrue(driver.findElement(INSTRUCTION_HEADING).isDisplayed(), "Third question page instruction heading is not displayed");
		softassert.assertTrue(driver.findElement(QUESTION_HEADING).isDisplayed(), "Third question page heading is not displayed");
		softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on Third question page");
		String Third_question= driver.findElement(QUESTION_HEADING).getText();
		WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
		if(!(WebList.size()>0)) 
			throw new Exception("No options are displayed on Third question page");
		softassert.assertEquals(driver.findElement(NEXT_CTA).getText(), "Next","Text changed for 'Next' cta on Third question page");
		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		if(!Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not disabled by default on Third question page");
		element= driver.findElement(PREVIOUS_ARROW);
		js.executeScript("arguments[0].click();", element);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		ExpectedText = driver.findElement(QUESTION_HEADING).getText();
		softassert.assertEquals(Second_question, ExpectedText, "wrong navigation after click on back arrow on Third question page");
		CheckPreselect();

		driver.findElement(NEXT_CTA).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
		for(int i=1; i<WebList.size()-1; i++)
		{
			element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));
			js.executeScript("arguments[0].click();", element);
			SelectedOptions.add(element);
		}
		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		if(Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not enabled with selected options on Third question page");
		element = driver.findElement(NEXT_CTA);
		js.executeScript("arguments[0].click();", element);
		Reporter.log("Quiz Third question page is displayed :: Correct");

		//Education Card
		//		wait = new WebDriverWait(driver, 30);
		//		wait.until(ExpectedConditions.presenceOfElementLocated(PREVIOUS_ARROW));
		Thread.sleep(5000);
		softassert.assertTrue(driver.findElement(EDUCATION_CARD_TITLE).isDisplayed(), "Men's Education card title is not displayed");
		softassert.assertEquals(driver.findElement(NEXT_CTA).getText(), "Next","Text changed for 'Next' cta on Education card");
		softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on Education card");
		Education_card_title = driver.findElement(EDUCATION_CARD_TITLE).getText();

		element= driver.findElement(PREVIOUS_ARROW);
		js.executeScript("arguments[0].click();", element);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		ExpectedText = driver.findElement(QUESTION_HEADING).getText();
		softassert.assertEquals(Third_question, ExpectedText, "wrong navigation after click on back arrow on Education card");
		CheckPreselect();

		driver.findElement(NEXT_CTA).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(EDUCATION_CARD_TITLE));

		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		if(Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not enabled on Education card");
		element = driver.findElement(NEXT_CTA);
		js.executeScript("arguments[0].click();", element);
		Reporter.log("Quiz Education Card is displayed :: Correct");

		//Forth question page
		//		wait = new WebDriverWait(driver, 30);
		//		wait.until(ExpectedConditions.presenceOfElementLocated(PREVIOUS_ARROW));
		Thread.sleep(5000);
		softassert.assertTrue(driver.findElement(INSTRUCTION_HEADING).isDisplayed(), "Forth question page instruction heading is not displayed");
		softassert.assertTrue(driver.findElement(QUESTION_HEADING).isDisplayed(), "Forth question page heading is not displayed");
		softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on Forth question page");
		String Forth_question= driver.findElement(QUESTION_HEADING).getText();
		WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
		if(!(WebList.size()>0)) 
			throw new Exception("No options are displayed on Forth question page");
		softassert.assertEquals(driver.findElement(NEXT_CTA).getText(), "Next","Text changed for 'Next' cta on Forth question page");
		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		if(!Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not disabled by default on Forth question page");
		element= driver.findElement(PREVIOUS_ARROW);
		js.executeScript("arguments[0].click();", element);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(EDUCATION_CARD_TITLE));
		ExpectedText = driver.findElement(EDUCATION_CARD_TITLE).getText();
		softassert.assertEquals(Education_card_title, ExpectedText, "wrong navigation after click on back arrow on Forth question page");
		driver.findElement(NEXT_CTA).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
		for(int i=1; i<WebList.size()-1; i++)
		{
			element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));
			js.executeScript("arguments[0].click();", element);
			SelectedOptions.add(element);
		}
		Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
		if(Allclasses.contains("is-disabled"))
			throw new Exception("Next cta is not enabled with selected options on Forth question page");
		element = driver.findElement(NEXT_CTA);
		js.executeScript("arguments[0].click();", element);
		Reporter.log("Quiz Forth question page is displayed :: Correct");

		//Summary card
		//		wait = new WebDriverWait(driver, 30);
		//		wait.until(ExpectedConditions.presenceOfElementLocated(PREVIOUS_ARROW));
		Thread.sleep(5000);
		softassert.assertTrue(driver.findElement(SUMMARY_CARD_HEADING).isDisplayed(), "Men's Summary card title is not displayed");
		softassert.assertEquals(driver.findElement(SEE_RESULT_CTA).getText(), "Get Results","Text changed for 'See Results' cta on Summary card");
		softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on summary card");

		element= driver.findElement(PREVIOUS_ARROW);
		js.executeScript("arguments[0].click();", element);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		ExpectedText = driver.findElement(QUESTION_HEADING).getText();
		softassert.assertEquals(Forth_question, ExpectedText, "wrong navigation after click on back arrow on Summary card");
		CheckPreselect();

		driver.findElement(NEXT_CTA).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(SUMMARY_CARD_HEADING));
		List <WebElement> summary_answer= driver.findElements(SUMMARY_ANSWER);


		//		text= driver.findElement(PREFERENCES_SUMMARY_ANSWER).getText();
		//		list1= text.split(",");
		//		for(int j=0;j<=list1.length-1;j++)
		//		{
		//			summary_result.add(list1[j].toLowerCase().toString().trim());
		//		}
		for(int j=0;j<=summary_answer.size()-1;j++)
		{
			summary_result.add(summary_answer.get(j).getText().toLowerCase().toString().trim());
		}
		element = driver.findElement(SEE_RESULT_CTA);
		js.executeScript("arguments[0].click();", element);
		Reporter.log("Quiz Summary Card is displayed :: Correct");
		//Result Page
		Thread.sleep(5000);

		softassert.assertTrue(driver.findElement(RETAKE_QUIZ_CTA).isDisplayed(), "Retake quiz CTA is not displayed on result page or Incorrect page opened after click on see result CTA");

		softassert.assertAll();
		return QuestionText;
	}

	public void RetakeQuizFlow() throws Exception
	{
		js = (JavascriptExecutor)driver;
		QuestionText=QuizFlow();
		//QuestionText=FirstTemplate();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUIZ_ANSWER_HERO_TITLE));
		softassert.assertTrue(driver.findElement(QUIZ_ANSWER_HERO_TITLE).isDisplayed(), "Quiz answer hero title is not displayed on Result page");
		softassert.assertTrue(driver.findElement(RETAKE_QUIZ_CTA).isDisplayed(), "Retake Quiz CTA is not displayed on result page");
		element = driver.findElement(RETAKE_QUIZ_CTA);
		js.executeScript("arguments[0].click();", element);

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		ExpectedText = driver.findElement(QUESTION_HEADING).getText();
		softassert.assertEquals(QuestionText, ExpectedText, "Navigation is not quiz first template after click on 'Retake Quiz' link");

		//Check next cta active status 
		for(int i=1; i<=5; i++)
		{
			//text = driver.findElement(QUESTION_HEADING).getText();
			Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
			if(Allclasses.contains("is-disabled"))
				throw new Exception("Next cta is not enabled with retake quiz flow ");
			element = driver.findElement(NEXT_CTA);
			js.executeScript("arguments[0].click();", element);

		}

		softassert.assertAll();
		Reporter.log("Quiz templates with retake flow are Displayed: Correct");
		Reporter.log("Preselected options functionality with retake quiz is correct");
	}

	public void CheckPreselect()
	{
		//Check preselected options on previous page
		WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
		text= driver.findElement(QUESTION_HEADING).getText();
		for(int i=1; i<WebList.size(); i++)
		{
			element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));

			if(element.getAttribute("class").contains("selected")) {
				OnSelectClasses.add(element);
			}
		}
		softassert.assertEquals(SelectedOptions.size(), OnSelectClasses.size(), "Options are not preselected for this question template: "+text);
		softassert.assertAll();
		SelectedOptions.clear();
		OnSelectClasses.clear();
		Reporter.log("Preselected options functionality is correct for template: "+text);	
	}

	public void ResultPage() throws Exception
	{	// Verify selected options on result page
		Thread.sleep(3000);
		softassert.assertTrue(driver.findElement(QUIZ_RESULT_PRODUCT_IMAGE).isDisplayed(), "products are displayed on quiz result page");
		try 
		{		
			text= driver.findElement(RESULT_PAGE_SELECTED_VALUES).getText();
		}
		catch(Exception e)
		{
			text= driver.findElement(BRA_RESULT_PAGE_SELECTEDVALUES).getText();	
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			Thread.sleep(3000);
			List<WebElement> products= driver.findElements(By.cssSelector("div.product-image-container"));
			softassert.assertFalse(products.size()==3, "product count in Bra result page is not 3");
		}
		System.out.println("text is: "+text);
		list2=text.split("[|]");
		System.out.println("list2 is: "+Arrays.asList(list2));
		for(int k=0;k<list2.length;k++)
		{
			result_page_selected_value.add(list2[k].toString().toLowerCase().trim());
		}
		System.out.println("Summary page: "+summary_result);
		System.out.println("Result page: "+result_page_selected_value);
		List<String> Common_Values = result_page_selected_value.stream().filter(e -> (summary_result.stream().filter(d -> d.equals(e)).count()) < 1).collect(Collectors.toList());
		System.out.println("common values are: "+Common_Values);
		for(String temp: Common_Values) {
			if (!result_page_selected_value.contains(temp)) {
				System.out.println(temp);
				throw new Exception("Result is not based on combination of selected options for :"+temp);
			}
		}
		//				for(String temp: result_page_selected_value) {
		//					System.out.println(temp);
		//					System.out.println("Match:"+summary_result.stream().anyMatch(d-> d.equalsIgnoreCase(temp)));
		//							if(!summary_result.stream().filter(d-> d.equals(temp)).findFirst().equals(temp))
		//							{
		//								throw new Exception("Result is not based on combination of selected options for :"+temp);
		//							}
		//				
		//				}
		softassert.assertAll();
		Reporter.log("Result page is Displayed:: Correct");
	}

	public String Bra_Quiz_Flow() throws Exception
	{

		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(GET_STARTED_CTA));
		softassert.assertTrue(driver.findElement(GET_STARTED_CTA).isDisplayed(), "Get started button is not displayed");
		softassert.assertEquals(driver.findElement(GET_STARTED_CTA).getText(), "Get Started" , "Text changed for quiz start CTA");
		element = driver.findElement(GET_STARTED_CTA);
		js.executeScript("arguments[0].click();", element);
		Reporter.log("'Get Started' cta Displayed :: Clickable");

		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		BraFirstQsnTemplate = driver.findElement(QUESTION_HEADING).getText();
		Question = driver.findElement(QUESTION_HEADING).getText();
		System.out.println("Question text is: "+Question);
		for(int j=0;j<9;j++)
		{
			try {
				if(driver.findElement(INSTRUCTION_HEADING).isDisplayed())
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
					softassert.assertTrue(driver.findElement(INSTRUCTION_HEADING).isDisplayed(), "question page instruction heading is not displayed");
					softassert.assertTrue(driver.findElement(QUESTION_HEADING).isDisplayed(), "question page heading is not displayed");
					QuestionText= driver.findElement(QUESTION_HEADING).getText();
					WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
					if(!(WebList.size()>0)) 
						throw new Exception("No options are displayed on question template: "+QuestionText);
					Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
					softassert.assertEquals(driver.findElement(NEXT_CTA).getText(), "Next","Text changed for 'Next' cta");
					if(!Allclasses.contains("is-disabled"))
						throw new Exception("Next cta is not disabled by default");

					if(driver.findElement(PREVIOUS_ARROW).isDisplayed())
					{
						element= driver.findElement(PREVIOUS_ARROW);
						js.executeScript("arguments[0].click();", element);
						Thread.sleep(8000);
						wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
						ExpectedText = driver.findElement(QUESTION_HEADING).getText();
						System.out.println("actual: "+ExpectedText+" Expected : "+Question);
						softassert.assertEquals(ExpectedText, Question, "wrong navigation after click on back arrow");
						CheckPreselect();

						driver.findElement(NEXT_CTA).click();
						wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
						WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
						for(int i=1; i<WebList.size()-1; i++)
						{
							element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));
							js.executeScript("arguments[0].click();", element);
							SelectedOptions.add(element);
						}

						Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
						if(Allclasses.contains("is-disabled"))
							throw new Exception("Next cta is not enabled with selected options");
						element = driver.findElement(NEXT_CTA);
						js.executeScript("arguments[0].click();", element);
						Thread.sleep(5000);

					}

					else {
						for(int i=1; i<WebList.size()-1; i++)
						{
							element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));
							js.executeScript("arguments[0].click();", element);
							SelectedOptions.add(element);
						}

						ExpectedText= driver.findElement(QUESTION_HEADING).getText();
						element = driver.findElement(NEXT_CTA);
						js.executeScript("arguments[0].click();", element);
						Thread.sleep(5000);
						System.out.println("Previous arrow is not displayed for template: "+QuestionText);
					}

				}
				Thread.sleep(5000);
			}

			catch(Exception e) {
				Thread.sleep(5000);
				try {
					if(driver.findElement(EDUCATION_CARD_TITLE).isDisplayed()) 
					{
						softassert.assertTrue(driver.findElement(EDUCATION_CARD_TITLE).isDisplayed(), "Bra Education card title is not displayed");
						softassert.assertEquals(driver.findElement(NEXT_CTA).getText(), "Next","Text changed for 'Next' cta on Education card");
						softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on Education card");
						Education_card_title = driver.findElement(EDUCATION_CARD_TITLE).getText();

						element= driver.findElement(PREVIOUS_ARROW);
						js.executeScript("arguments[0].click();", element);
						wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
						ExpectedText = driver.findElement(QUESTION_HEADING).getText();
						softassert.assertEquals(ExpectedText, Question, "wrong navigation after click on back arrow on Education card");
						CheckPreselect();
						element = driver.findElement(NEXT_CTA);
						js.executeScript("arguments[0].click();", element);
						Thread.sleep(3000);
						wait.until(ExpectedConditions.visibilityOfElementLocated(EDUCATION_CARD_TITLE));
						element = driver.findElement(NEXT_CTA);
						js.executeScript("arguments[0].click();", element);				

					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(SUMMARY_CARD_HEADING));
					softassert.assertTrue(driver.findElement(SUMMARY_CARD_HEADING).isDisplayed(), "Bra Summary card title is not displayed");
					softassert.assertEquals(driver.findElement(SEE_RESULT_CTA).getText(), "Get Results","Text changed for 'See Results' cta on Summary card");
					softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on summary card");

					element= driver.findElement(PREVIOUS_ARROW);
					js.executeScript("arguments[0].click();", element);
					wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.presenceOfElementLocated(EDUCATION_CARD_TITLE));
					ExpectedText = driver.findElement(EDUCATION_CARD_TITLE).getText();
					softassert.assertEquals(ExpectedText, Education_card_title, "wrong navigation after click on back arrow on Summary card");

					driver.findElement(NEXT_CTA).click();
					wait.until(ExpectedConditions.presenceOfElementLocated(SUMMARY_CARD_HEADING));
					List <WebElement> summary_answer= driver.findElements(SUMMARY_ANSWER);

					for(int s=0;s<=summary_answer.size()-1;s++)
					{
						summary_result.add(summary_answer.get(s).getText().toLowerCase().toString().trim());
					}
					element = driver.findElement(SEE_RESULT_CTA);
					js.executeScript("arguments[0].click();", element);
					Reporter.log("Quiz Summary Card is displayed :: Correct");
					Thread.sleep(5000);
					softassert.assertTrue(driver.findElement(RETAKE_QUIZ_CTA).isDisplayed(), "Retake quiz CTA is not displayed on result page or Incorrect page opened after click on see result CTA");			

				}
				catch(Exception exe) {
					break;
				}
			}
			Question = QuestionText;
		}
		softassert.assertAll();
		return BraFirstQsnTemplate;
	}

	public void Bra_Retake_QuizFlow() throws Exception
	{
		js = (JavascriptExecutor)driver;
		QuestionText=Bra_Quiz_Flow();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUIZ_ANSWER_HERO_TITLE));
		softassert.assertTrue(driver.findElement(QUIZ_ANSWER_HERO_TITLE).isDisplayed(), "Quiz answer hero title is not displayed on Bra Result page");
		softassert.assertTrue(driver.findElement(RETAKE_QUIZ_CTA).isDisplayed(), "Retake Quiz CTA is not displayed on Bra result page");
		element = driver.findElement(RETAKE_QUIZ_CTA);
		js.executeScript("arguments[0].click();", element);

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		ExpectedText = driver.findElement(QUESTION_HEADING).getText();
		softassert.assertEquals(QuestionText, ExpectedText, "Navigation is not quiz first template after click on 'Retake Quiz' link");

		//Check next cta active status 
		for(int i=1; i<=5; i++)
		{
			//text = driver.findElement(QUESTION_HEADING).getText();
			Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
			if(Allclasses.contains("is-disabled"))
				throw new Exception("Next cta is not enabled with retake quiz flow ");
			element = driver.findElement(NEXT_CTA);
			js.executeScript("arguments[0].click();", element);

		}

		softassert.assertAll();
		Reporter.log("Bra Quiz templates with retake flow are Displayed: Correct");
		Reporter.log("Preselected options functionality with retake quiz is correct");

	}

	public void CustomInput_forQSNTemplates() throws Exception
	{
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(GET_STARTED_CTA));
		softassert.assertTrue(driver.findElement(GET_STARTED_CTA).isDisplayed(), "Get started button is not displayed");
		softassert.assertEquals(driver.findElement(GET_STARTED_CTA).getText(), "Get Started" , "Text changed for quiz start CTA");
		element = driver.findElement(GET_STARTED_CTA);
		js.executeScript("arguments[0].click();", element);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		for(int j=0;j<9;j++)
		{
			try {
				if(driver.findElement(INSTRUCTION_HEADING).isDisplayed())
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
					WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
					if(!(WebList.size()>0)) 
						throw new Exception("No options are displayed on question template: "+QuestionText);

					try {
						softassert.assertTrue(driver.findElement(CUSTOME_INPUT_FIELD).isDisplayed(), "Custom input field as other option is not displayed");
						driver.findElement(CUSTOME_INPUT_FIELD).sendKeys(CustomInputData);
					}
					catch(Exception CF) {
						for(int i=1; i<WebList.size()-1; i++)
						{
							element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));
							js.executeScript("arguments[0].click();", element);
						}
					}
					Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
					if(Allclasses.contains("is-disabled"))
						throw new Exception("Next cta is not enabled with selected options");
					element = driver.findElement(NEXT_CTA);
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
				}
			}

			catch(Exception e) {
				Thread.sleep(5000);
				try {
					if(driver.findElement(EDUCATION_CARD_TITLE).isDisplayed()) 
					{
						Education_card_title = driver.findElement(EDUCATION_CARD_TITLE).getText();
						element = driver.findElement(NEXT_CTA);
						js.executeScript("arguments[0].click();", element);
						Thread.sleep(3000);

					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(SUMMARY_CARD_HEADING));
					softassert.assertTrue(driver.findElement(SUMMARY_CARD_HEADING).isDisplayed(), "Bra Summary card title is not displayed");
					softassert.assertEquals(driver.findElement(SEE_RESULT_CTA).getText(), "Get Results","Text changed for 'See Results' cta on Summary card");
					softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on summary card");

					element = driver.findElement(SEE_RESULT_CTA);
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
					softassert.assertTrue(driver.findElement(RETAKE_QUIZ_CTA).isDisplayed(), "Retake quiz CTA is not displayed on result page or Incorrect page opened after click on see result CTA");			
					System.out.println("unavailable message title is: "+driver.findElement(RESULT_UNAVAILABLE_MESSAGE).getText());
					softassert.assertTrue(!driver.findElement(RESULT_UNAVAILABLE_MESSAGE).getText().isEmpty(), "Result unavailable message is not displayed on result page with custom input");
				}
				catch(Exception exe)
				{
					break;
				}
			}
		}
		softassert.assertAll();
		Reporter.log("Result unavailable message is displayed on result page with custom input");

	}
	
	public void Check_NoPreferenceOptions() throws Exception
	{
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(GET_STARTED_CTA));
		softassert.assertTrue(driver.findElement(GET_STARTED_CTA).isDisplayed(), "Get started button is not displayed");
		softassert.assertEquals(driver.findElement(GET_STARTED_CTA).getText(), "Get Started" , "Text changed for quiz start CTA");
		element = driver.findElement(GET_STARTED_CTA);
		js.executeScript("arguments[0].click();", element);
		wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
		for(int j=0;j<9;j++)
		{
			try {
				if(driver.findElement(INSTRUCTION_HEADING).isDisplayed())
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(QUESTION_HEADING));
					WebList= driver.findElements(QUESTION_BLOCK_OPTIONS);
					if(!(WebList.size()>0)) 
						throw new Exception("No options are displayed on question template: "+QuestionText);

					try {
					if(driver.findElement(NO_PREFERENCE_OPTION).isDisplayed())
					{
						element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child(1)"));
						js.executeScript("arguments[0].click();", element);
						Thread.sleep(1000);
						driver.findElement(NO_PREFERENCE_OPTION).click();
						Thread.sleep(1000);
						String Option_classes = element.getAttribute("class");
						if(Option_classes.contains("selected"))
						{
							throw new Exception("Options are not deselected with 'No Preference' option selection");
						}
					}
					}
					catch(Exception CF) {
						for(int i=1; i<WebList.size()-1; i++)
						{
							element = driver.findElement(By.cssSelector(".questions-tile-parent>.questions-tile>div:nth-child("+i+")"));
							js.executeScript("arguments[0].click();", element);
						}
					}
					Allclasses = driver.findElement(NEXT_CTA).getAttribute("class");
					if(Allclasses.contains("is-disabled"))
						throw new Exception("Next cta is not enabled with selected options");
					element = driver.findElement(NEXT_CTA);
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
				}
			}

			catch(Exception e) {
				Thread.sleep(5000);
				try {
					if(driver.findElement(EDUCATION_CARD_TITLE).isDisplayed()) 
					{
						Education_card_title = driver.findElement(EDUCATION_CARD_TITLE).getText();
						element = driver.findElement(NEXT_CTA);
						js.executeScript("arguments[0].click();", element);
						Thread.sleep(3000);

					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(SUMMARY_CARD_HEADING));
					softassert.assertTrue(driver.findElement(SUMMARY_CARD_HEADING).isDisplayed(), "Bra Summary card title is not displayed");
					softassert.assertEquals(driver.findElement(SEE_RESULT_CTA).getText(), "Get Results","Text changed for 'See Results' cta on Summary card");
					softassert.assertTrue(driver.findElement(PREVIOUS_ARROW).isDisplayed(), "Back arrow is not displayed on summary card");

					element = driver.findElement(SEE_RESULT_CTA);
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
					softassert.assertTrue(driver.findElement(RETAKE_QUIZ_CTA).isDisplayed(), "Retake quiz CTA is not displayed on result page or Incorrect page opened after click on see result CTA");			
				}
				catch(Exception exe)
				{
					break;
				}
			}
		}
		softassert.assertAll();
		Reporter.log("Options are deselected with no preference option");

	
	}
}
