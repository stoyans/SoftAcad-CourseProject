package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import driver.Driver;
import org.openqa.selenium.support.ui.Select;

public class ReserveTicket extends BasePage
{
	@FindBy(xpath = ".//*[@id='div_Ctrl_TopSlider']/div/a[2]")
	public WebElement nextMoviesButton;
	
	@FindBy(xpath = ".//*[@id='movieslide']/div/div[2]/a[1]/img")
	public WebElement secondMovie;
	
	@FindBy(xpath = ".//*[@id='movieslide']/div/div[1]/a[1]/img")
	public WebElement firstAvailableMovie;
	
	@FindBy(xpath = ".//*[@id='main']/div/div/div/div/table/tbody/tr/td[2]/div/a")
	public WebElement buyNow;
	
	@FindBy(id = "RootMainContent_MainContent_linkChangeSeat")
	public WebElement continueButton;
	
	@FindBy(id = "buttonproceed")
	public WebElement proceedButton;
	
	@FindBy(id = "bt_booknow")
	public WebElement reserveButton;
	
	@FindBy(id = "ddl_Cinema")
	public WebElement cinemaDropdown;
	
	@FindBy(id = "ddl_Date")
	public WebElement dateDropdown;
	
	@FindBy(id = "ddl_Time")
	public WebElement hourDropdown;
	
	@FindBy(xpath = ".//*[@id='TicketType']/tbody/tr[1]/td[2]/div/span[3]")
	public WebElement plusButton;
	
	
	
	public ReserveTicket(Driver driver)
	{
		super(driver);
		PageFactory.initElements(driver.getDriver(), this);
	}
	
	public void NavigateToBuyNow()
	{
		Wait().until(ExpectedConditions.elementToBeClickable(nextMoviesButton));
		nextMoviesButton.click();
		Wait().until(ExpectedConditions.elementToBeClickable(secondMovie));
		secondMovie.click();
		Wait().until(ExpectedConditions.elementToBeClickable(buyNow));
		buyNow.click();
		Wait().until(ExpectedConditions.elementToBeClickable(continueButton));
	}
	
	public void NavigateToDateTime(String cinemaValue) throws InterruptedException
	{
		Select cinemas = new Select(cinemaDropdown);
		cinemas.selectByValue(cinemaValue);
		Driver().getDriver().manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		Select dates = new Select(dateDropdown);
		dates.selectByValue("gEFL/3o86m7RGltJIHTWuA==");
		Driver().getDriver().manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		Select hours = new Select(hourDropdown);
		hours.selectByValue("u2Ixte3 kz0=");
		Wait().until(ExpectedConditions.elementToBeClickable(plusButton));
		plusButton.click();
		continueButton.click();
		Wait().until(ExpectedConditions.elementToBeClickable(proceedButton));
	}
	
	public void NavigateToSummary() throws InterruptedException
	{
		proceedButton.click();
		Wait().until(ExpectedConditions.elementToBeClickable(reserveButton));
	}
}
