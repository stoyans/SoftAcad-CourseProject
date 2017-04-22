package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage
{
	private WebDriver driver;
    private WebDriverWait wait;
    
    public BasePage(WebDriver driver)
    {

        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
        PageFactory.initElements(driver, this);
    }
    
    public WebDriver Driver()
	{
		return driver;
	}

	public WebDriverWait Wait()
	{
		return wait;
	}
}
