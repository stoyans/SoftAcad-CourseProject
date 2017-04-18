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
		System.setProperty("webdriver.gecko.driver", 
				"C:/Users/Tanis/Desktop/geckodriver-v0.15.0-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void quitSession()
	{
		driver.quit();
	}
	
	@Test
	public void RegisterWithMissingFirstName() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"", "Ivanov", "mail@mail.com", 
				"password", "password", "22.07.1983", false, "Айтос", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals("Information not valid!", regPage.errorMessageForInvalidData.getText());
		Assert.assertEquals("Required fields are missing", regPage.errorMessageForFirstname.getText());
	}
	
	@Test
	public void RegisterWithMissingLastName() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "", "mail@mail.com", 
				"password", "password", "22.07.1983", false, "Варна", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals("Information not valid!", regPage.errorMessageForInvalidData.getText());
		Assert.assertEquals("Required fields are missing", regPage.errorMessageForLastname.getText());
	}
	
	@Test
	public void RegisterWithMissingEmail() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "", 
				"password", "password", "22.07.1983", false, "Варна", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals("Information not valid!", regPage.errorMessageForInvalidData.getText());
		Assert.assertEquals("Required fields are missing", regPage.errorMessageForEmail.getText());
	}
	
	@Test
	public void RegisterWithInvalidEmail() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "google.d", 
				"password", "password", "22.07.1983", false, "Варна", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals("Information not valid!", regPage.errorMessageForInvalidData.getText());
		Assert.assertEquals("This value is not a valid email address.", regPage.errorMessageForEmail.getText());
	}
	
	@Test
	public void RegisterWithMissingPassword() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "mail@mail.com", 
				"", "password", "22.07.1983", false, "Варна", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals("Information not valid!", regPage.errorMessageForInvalidData.getText());
		Assert.assertEquals("Required fields are missing", regPage.errorMessageForMissingPass.getText());
	}
	
	@Test
	public void RegisterWithMissingPaswordsMismatch() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "mail@mail.com", 
				"password", "pass", "22.07.1983", false, "Добрич", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals("form.password_mismatch", regPage.errorMessageForPassMismatch.getText());
		Assert.assertEquals("Information not valid!", regPage.errorMessageForInvalidData.getText());
	}

}
