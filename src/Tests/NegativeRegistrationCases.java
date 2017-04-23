package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dataModel.RegUser;
import driver.Driver;
import pages.RegistrationPage;

public class NegativeRegistrationCases
{
	Driver driver = new Driver();
	
	@BeforeClass
	public void initDriver() 
	{
		driver.startDriver();
	}
	
	@AfterClass
	public void quitSession()
	{
		driver.getDriver().quit();
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
		Assert.assertEquals(regPage.errorMessageForInvalidData.getText(), "Information not valid!");
		Assert.assertEquals(regPage.errorMessageForFirstname.getText(), "Required fields are missing");
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
		Assert.assertEquals(regPage.errorMessageForInvalidData.getText(), "Information not valid!");
		Assert.assertEquals(regPage.errorMessageForLastname.getText(), "Required fields are missing");
	}
	
	@Test
	public void RegisterWithMissingEmail() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "", 
				"password", "password", "22.07.1983", false, "Пловдив", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessageForInvalidData.getText(), "Information not valid!");
		Assert.assertEquals(regPage.errorMessageForEmail.getText(), "Required fields are missing");
	}
	
	@Test
	public void RegisterWithInvalidEmail() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "google.d", 
				"password", "password", "22.07.1983", false, "Смолян", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessageForInvalidData.getText(), "Information not valid!");
		Assert.assertEquals(regPage.errorMessageForEmail.getText(), "This value is not a valid email address.");
	}
	
	@Test
	public void RegisterWithMissingPassword() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "mail@mail.com", 
				"", "password", "22.07.1983", false, "Петрич", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessageForInvalidData.getText(), "form.password_mismatch");
		Assert.assertEquals(regPage.errorMessageForMissingPass.getText(), "Required fields are missing");
	}
	
	@Test
	public void RegisterWithMissingPasswordsMismatch() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "mail@mail.com", 
				"password", "pass", "22.07.1983", false, "Добрич", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessageForPassMismatch.getText(), "form.password_mismatch");
		Assert.assertEquals(regPage.errorMessageForInvalidData.getText(), "Information not valid!");
	}
	
	@Test
	public void RegisterWithMissingPasswords() throws InterruptedException
	{
		RegUser userData = new RegUser(
				"Ivan", "Ivanov", "abv@mail.com", 
				"", "", "22.07.1983", true, "Бургас", "Kino Arena Mall Varna");
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessageForPassMismatch.getText(), "Required fields are missing");
		Assert.assertEquals(regPage.errorMessageForInvalidData.getText(), "Information not valid!");
	}
}
