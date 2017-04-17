package pages;

import java.util.Iterator;
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

	// @FindBy(className = "stenik-radio")
	// public WebElement[] genderOptions;

	@FindBy(id = "stenik_user_registration_dateOfBirth")
	public WebElement dateOfBirth;

	@FindBy(xpath = ".//*[@id='register_form']/div[10]/div/label")
	public WebElement termsAndConditions;

	@FindBy(id = "stenik_user_registration__submit")
	public WebElement submit;

	@FindBy(id = "register_message")
	public WebElement errorMessageForInvalidDate;

	

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

	public void FillRegistrationForm(RegUser userData)
	{
		List<WebElement> genderOptions = Driver().findElements(By.cssSelector("div.formItem.radio.big"));
		Wait().until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(userData.getfName());
		lastName.sendKeys(userData.getlName());
		email.sendKeys(userData.getEmail());
		password.sendKeys(userData.getPass());
		passwordConfirm.sendKeys(userData.getConfirmPass());

		ClickOnElements(genderOptions, userData.getGenderOptions());
		dateOfBirth.sendKeys(userData.getDateOfBirth());
		termsAndConditions.click();
		submit.click();
		Wait().until(ExpectedConditions.visibilityOf(errorMessageForInvalidDate));
	}

	public void ClickOnElements(List<WebElement> genderOptions, Boolean[] options)
	{
		int i = 0;
		for (WebElement genderOption : genderOptions)
		{
			if (options[i])
			{
				genderOption.click();
			}

			i++;
		}
	}
}
