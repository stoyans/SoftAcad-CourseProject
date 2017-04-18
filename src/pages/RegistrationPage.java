package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import dataModel.RegUser;

public class RegistrationPage extends BasePage
{
	@FindBy(xpath = ".//*[@id='header']/div/nav[2]/ul[1]/li[3]/a")
	public WebElement login;

	@FindBy(xpath = ".//*[@id='login_form']/a[2]")
	public WebElement regButton;

	@FindBy(id = "stenik_user_registration_firstname")
	public WebElement firstName;

	@FindBy(id = "stenik_user_registration_lastname")
	public WebElement lastName;

	@FindBy(id = "stenik_user_registration_email")
	public WebElement email;

	@FindBy(id = "stenik_user_registration_plainPassword_first")
	public WebElement password;

	@FindBy(id = "stenik_user_registration_plainPassword_second")
	public WebElement passwordConfirm;

	@FindBy(xpath = ".//*[@id='register_form']/div[6]/div[1]/div/label")
	public WebElement genderMale;
	
	@FindBy(xpath = ".//*[@id='register_form']/div[6]/div[2]/div/label")
	public WebElement genderFemale;

	@FindBy(id = "stenik_user_registration_dateOfBirth")
	public WebElement dateOfBirth;

	@FindBy(xpath = ".//*[@id='register_form']/div[10]/div/label")
	public WebElement termsAndConditions;

	@FindBy(id = "stenik_user_registration__submit")
	public WebElement submit;

	@FindBy(xpath = ".//*[@id='register_form']/div[8]/div[1]/div[1]")
	public WebElement selectCity;
	
	@FindBy(xpath = ".//*[@id='register_form']/div[9]/div[1]/div[1]")
	public WebElement selectCinema;
	
	@FindBy(id = "register_message")
	public WebElement errorMessageForInvalidData;
	
	@FindBy(xpath = ".//*[@id='register_form']/div[4]/div")
	public WebElement errorMessageForPassMismatch;
	
	@FindBy(xpath = ".//*[@id='register_form']/div[1]/div")
	public WebElement errorMessageForFirstname;
	
	@FindBy(xpath = ".//*[@id='register_form']/div[2]/div")
	public WebElement errorMessageForLastname;
	
	@FindBy(xpath = ".//*[@id='register_form']/div[3]/div")
	public WebElement errorMessageForEmail;
	
	@FindBy(xpath = ".//*[@id='register_form']/div[4]/div")
	public WebElement errorMessageForMissingPass;
	
	@FindBy(xpath = ".//*[@id='register_form']/div[7]/div")
	public WebElement errorMessageForMissingBirthdate;
	
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void NavigateTo() throws InterruptedException
	{
		Driver().get("https://www.kinoarena.com/en/");
		Wait().until(ExpectedConditions.elementToBeClickable(login));
		Thread.sleep(2000); /// ??? why doesn't work without it
		login.click();
		Wait().until(ExpectedConditions.elementToBeClickable(regButton));
		regButton.click();
	}

	public void FillRegistrationForm(RegUser userData) throws InterruptedException
	{
		Wait().until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(userData.getfName());
		lastName.sendKeys(userData.getlName());
		email.sendKeys(userData.getEmail());
		password.sendKeys(userData.getPass());
		passwordConfirm.sendKeys(userData.getConfirmPass());
		selectGender(userData);
		dateOfBirth.sendKeys(userData.getDateOfBirth());
		selectCity.click();
		Thread.sleep(2000);
		List<WebElement> citiesAndCinemaOptions = Driver().findElements(By.cssSelector("div.formItem.select div.selectedHolder + div.dropdown > span"));
		selectOption(citiesAndCinemaOptions, userData.getCity());
		selectCinema.click();
		Thread.sleep(2000);
		selectOption(citiesAndCinemaOptions, userData.getCinema());
		Thread.sleep(2000);
		termsAndConditions.click();
		submit.click();
		Wait().until(ExpectedConditions.visibilityOf(errorMessageForInvalidData));
	}
	
	public void selectGender(RegUser userData)
	{
		if (userData.getIsMale() != null)
		{
			if (userData.getIsMale())
			{
				genderMale.click();
			}
			else
			{
				genderFemale.click();
			}
		}
	}
	
	public void selectOption(List<WebElement> options, String userOption)
	{
		for (WebElement webElement : options)
		{
			if (webElement.getText().equals(userOption))
			{
				webElement.click();
			}
		}
	}
}
