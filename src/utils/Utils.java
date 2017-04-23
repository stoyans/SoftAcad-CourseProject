package utils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataModel.RegUser;

public class Utils
{
	
	public static void removeBanner(WebElement bannerClose)
	{
		bannerClose.click();
	}
	
	public static String handlePasswordPopUp(WebDriver driver)
	{
		String msgPass = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return msgPass;
	}
	
	public static void selectGender(RegUser userData, WebElement genderFemale, WebElement genderMale)
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
	
	public static void selectOption(List<WebElement> options, String userOption)
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
