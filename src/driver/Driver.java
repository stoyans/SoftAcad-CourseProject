package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


public class Driver
{	
	private WebDriver driver;
	
	public Driver()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void startDriver()
	{
		System.setProperty("webdriver.gecko.driver", 
				"D:/MyDocs/Programming/SoftAcademy/CourseProject/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void loadURL(String url)
	{
		getDriver().get(url);
	}

	public WebDriver getDriver()
	{
		return driver;
	}

	public void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}
}
