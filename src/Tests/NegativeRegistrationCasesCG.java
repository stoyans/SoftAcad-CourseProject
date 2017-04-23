package Tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import dataModel.RegUser;
import driver.Driver;
import pages.RegistrationPageCG;

public class NegativeRegistrationCasesCG
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
	public void RegisterWithMissingName()
	{
		RegUser userData = new RegUser(
				"", "Ivanov", "mail@mail.com", "mail@mail.com",
				"password", "password", "0987756565");
		RegistrationPageCG regPage = new RegistrationPageCG(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessage.getText(), "Моля, напишете име");
	}
	
	@Test
	public void RegisterWithMissingUsername()
	{
		RegUser userData = new RegUser(
				"Ivanov", "", "mail@mail.com", "mail@mail.com",
				"password", "password", "0987756565");
		RegistrationPageCG regPage = new RegistrationPageCG(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessage.getText(), "Моля, изберете потребителско име");
	}
	
	@Test
	public void RegisterWithMissingEmail()
	{
		RegUser userData = new RegUser(
				"Ivanov", "Ivanov", "", "mail@mail.com",
				"password", "password", "0987756565");
		RegistrationPageCG regPage = new RegistrationPageCG(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessage.getText(), "Моля, напишете имейл");
	}
	
	@Test
	public void RegisterWithMissingConfirmEmail()
	{
		RegUser userData = new RegUser(
				"Ivanov", "Ivanov", "mail@mail.com", "",
				"password", "password", "0987756565");
		RegistrationPageCG regPage = new RegistrationPageCG(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessage.getText(), "Грешен имейл");
	}
	
	@Test
	public void RegisterWithMissingPassword()
	{
		RegUser userData = new RegUser(
				"Ivanov", "Ivanov", "mail@mail.com", "mail@mail.com",
				"", "password", "0987756565");
		RegistrationPageCG regPage = new RegistrationPageCG(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessageForPass, "Please enter a value that is at least 5 characters long.");
		Assert.assertEquals(regPage.errorMessage.getText(), "Моля, изберете парола");
	}
	
	@Test
	public void RegisterWithMissingConfirmPassword()
	{
		RegUser userData = new RegUser(
				"Ivanov", "Ivanov", "mail@mail.com", "mail@mail.com",
				"password", "", "0987756565");
		RegistrationPageCG regPage = new RegistrationPageCG(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessage.getText(), "Сгрешена парола");
	}
	
	@Test
	public void RegisterWithPasswordsMismatch()
	{
		RegUser userData = new RegUser(
				"Ivanov", "Ivanov", "mail@mail.com", "mail@mail.com",
				"password", "password1", "0987756565");
		RegistrationPageCG regPage = new RegistrationPageCG(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessage.getText(), "Сгрешена парола");
	}
	
	@Test
	public void RegisterWithMissingPhone()
	{
		RegUser userData = new RegUser(
				"Ivanov", "Ivanov", "mail@mail.com", "mail@mail.com",
				"password", "password", "");
		RegistrationPageCG regPage = new RegistrationPageCG(driver);
		regPage.NavigateTo();
		
		regPage.FillRegistrationForm(userData);
		Assert.assertEquals(regPage.errorMessage.getText(), "Моля, оставете телефон");
	}
}
