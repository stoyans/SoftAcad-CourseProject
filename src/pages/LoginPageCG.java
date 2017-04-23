package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import dataModel.LoginUser;
import utils.Utils;

public class LoginPageCG extends BasePage
{
	@FindBy(id = "login_link")
	public WebElement loginButton;
	
	@FindBy(id = "modlgn-username")
	public WebElement email;
	
	@FindBy(id = "modlgn-passwd")
	public WebElement pass;
	
	@FindBy(xpath = ".//*[@id='Form1']/fieldset/table/tbody/tr[3]/td[2]/input")
	public WebElement submitLogin;
	
	@FindBy(id = "spn_name")
	public WebElement welcomeUser;
	
	@FindBy(id = "Logout_Link")
	public WebElement exitButton;
	
	public LoginPageCG(driver.Driver driver)
	{
		super(driver);
		PageFactory.initElements(driver.getDriver(), this);
	}
	
	public void navigateToLogIn(LoginUser user)
	{
		Driver().loadURL("http://cinegrand.bg/");
		Wait().until(ExpectedConditions.elementToBeClickable(declaration));
		Utils.removeBanner(bannerClose);
		Wait().until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		Wait().until(ExpectedConditions.elementToBeClickable(submitLogin));
		email.sendKeys(user.getLoginEmail());
		pass.sendKeys(user.getPassword());
		submitLogin.click();
		Wait().until(ExpectedConditions.elementToBeClickable(exitButton));
	}
}
