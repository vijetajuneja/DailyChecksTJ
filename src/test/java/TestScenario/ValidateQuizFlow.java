package TestScenario;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tommyjohn.automation.Pages.QuizPage;
import com.tommyjohn.automation.utils.CustomUtilities;

public class ValidateQuizFlow 
{
	WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(String browser) {
		try {
			driver = new CustomUtilities().launchtj(browser);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Test
	public void ValidateMensUnderwearQuizFlow() throws Exception
	{
		new QuizPage(driver).VerifyMensQuizFlow();
	}

	@Test
	public void ValidateMensUnderwearRetakeQuizFlow() throws Exception
	{
		new QuizPage(driver).VerifyMensRetakeQuizFlow();
	}
	
	@Test
	public void ValidateMensUnderwearResultPage() throws Exception
	{
		new QuizPage(driver).VerifyMensResultPage();
	}

	@Test
	public void ValidateWomensUnderwearQuizFlow() throws Exception
	{
		new QuizPage(driver).VerifyWomensQuizFlow();
	}

	@Test
	public void ValidateWomensUnderwearRetakeQuizFlow() throws Exception
	{
		new QuizPage(driver).VerifyWomensRetakeQuizFlow();
	}
	
	@Test
	public void ValidateWomensUnderwearResultPage() throws Exception
	{
		new QuizPage(driver).VerifyWomensResultPage();
	}
	
	@Test
	public void ValidateBraQuizFlow() throws Exception
	{
		new QuizPage(driver).VerifyBraQuizFlow();
	}
	@Test
	public void ValidateBraRetakeQuizFlow() throws Exception
	{
		new QuizPage(driver).VerifyBraRetakeQuizFlow();
	}
	
	@Test
	public void ValidateBraResultPage() throws Exception
	{
		new QuizPage(driver).VerifyBraResultPage();
	}
	@Test
	public void ValidateBraQuizWithCustomInput() throws Exception
	{
		new QuizPage(driver).VerifyBraQuizWithCustomInput();
	}
	@Test
	public void ValidateBraQuizWithNoPreferenceOption() throws Exception
	{
		new QuizPage(driver).VerifyBraQuizWithNoPreferenceOption();
	}
	@AfterMethod(alwaysRun = true)
	void tearDown() {

		driver.quit();

	}
}
