package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.Driver;

public abstract class BasePage
{
	private Driver driver;
    private WebDriverWait wait;

	@FindBy(xpath = ".//*[@id='bannerdiv']/div")
	public WebElement bannerClose;
	
	@FindBy(xpath = ".//*[@id='footer']/div/div[4]/a[2]")
	public WebElement declaration;
	
    public BasePage(Driver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver.getDriver(), 15);
    }
    
    public Driver Driver()
	{
		return driver;
	}

	public WebDriverWait Wait()
	{
		return wait;
	}
}
