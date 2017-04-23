package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import dataModel.RegUser;
import driver.Driver;
import utils.Utils;

public class RegistrationPageCG extends BasePage
{
	@FindBy(xpath = ".//*[@id='header']/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/a[2]")
	public WebElement regButton;

	@FindBy(id = "jform_name")
	public WebElement name;

	@FindBy(id = "jform_username")
	public WebElement userName;

	@FindBy(id = "jform_email1")
	public WebElement email;
	
	@FindBy(id = "jform_email2")
	public WebElement confirmEmail;

	@FindBy(id = "jform_password1")
	public WebElement password;

	@FindBy(id = "jform_password2")
	public WebElement passwordConfirm;
	
	@FindBy(id = "Mobile")
	public WebElement phone;

	@FindBy(xpath = ".//*[@id='member-registration']/table/tbody/tr[9]/td[2]/button")
	public WebElement submit;
	
	@FindBy(id = "spn_Error1")
	public WebElement errorMessage;
	
	public String errorMessageForPass = "";
	
	
	public RegistrationPageCG(Driver driver)
	{
		super(driver);
		PageFactory.initElements(driver.getDriver(), this);
	}

	public void NavigateTo()
	{
		Driver().loadURL("http://cinegrand.bg/");
		Wait().until(ExpectedConditions.elementToBeClickable(declaration));
		Utils.removeBanner(bannerClose);
		Wait().until(ExpectedConditions.elementToBeClickable(regButton));
		regButton.click();
	}

	public void FillRegistrationForm(RegUser userData)
	{
		Wait().until(ExpectedConditions.elementToBeClickable(submit));
		name.sendKeys(userData.getfName());
		userName.sendKeys(userData.getUsername());
		email.sendKeys(userData.getEmail());
		confirmEmail.sendKeys(userData.getCofirmEmail());
		password.sendKeys(userData.getPass());
		passwordConfirm.sendKeys(userData.getConfirmPass());
		if (userData.getPass().length() < 5)
		{
			errorMessageForPass = Utils.handlePasswordPopUp(Driver().getDriver());
			passwordConfirm.sendKeys(userData.getConfirmPass());
		}
		phone.sendKeys(userData.getPhone());
		submit.click();
		Wait().until(ExpectedConditions.elementToBeClickable(errorMessage));
	}
}
