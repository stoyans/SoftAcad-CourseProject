package registrationTests;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataModel.RegUser;
import pages.RegistrationPage;

public class NegativeCases
{
	WebDriver driver;
	
	@BeforeClass
	public void initDriver() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Tanis/Desktop/geckodriver-v0.15.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void quitSession()
	{
		//driver.quit();
	}
	
	@Test
	public void RegisterWithMissingFirstName() throws InterruptedException
	{
		RegUser userData = new RegUser("Ivan", "Ivanov", "mail@mail.com", "password", "pass", "22.07.1983",
				new Boolean[]{true, false});
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals("Information not valid!", regPage.errorMessageForInvalidDate.getText());
	}

}
