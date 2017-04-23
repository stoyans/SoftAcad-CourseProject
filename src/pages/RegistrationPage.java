package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import dataModel.RegUser;
import utils.Utils;

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
	
	@FindBy(xpath = ".//*[@id='footer']/div/div[1]/nav/ul/li[1]/a")
	public WebElement aboutUs;
	
	
	
	public RegistrationPage(driver.Driver driver)
	{
		super(driver);
		PageFactory.initElements(driver.getDriver(), this);
	}

	public void NavigateTo() throws InterruptedException
	{
		Driver().loadURL("https://www.kinoarena.com/en/");
		Thread.sleep(4000);//doesn't work without it
		Wait().until(ExpectedConditions.elementToBeClickable(aboutUs));
		login.click();
		Wait().until(ExpectedConditions.elementToBeClickable(regButton));
		regButton.click();
	}

	public void FillRegistrationForm(RegUser userData) throws InterruptedException
	{
		Wait().until(ExpectedConditions.elementToBeClickable(firstName));
		Thread.sleep(500);
		firstName.sendKeys(userData.getfName());
		lastName.sendKeys(userData.getlName());
		email.sendKeys(userData.getEmail());
		password.sendKeys(userData.getPass());
		passwordConfirm.sendKeys(userData.getConfirmPass());
		Utils.selectGender(userData, genderFemale, genderMale);
		dateOfBirth.sendKeys(userData.getDateOfBirth());
		selectCity.click();
		List<WebElement> citiesAndCinemaOptions = Driver().getDriver().findElements(By.cssSelector("div.formItem.select div.selectedHolder + div.dropdown > span"));
		Utils.selectOption(citiesAndCinemaOptions, userData.getCity());
		selectCinema.click();
		Utils.selectOption(citiesAndCinemaOptions, userData.getCinema());
		termsAndConditions.click();
		submit.click();
		Wait().until(ExpectedConditions.visibilityOf(errorMessageForInvalidData));
	}
}
