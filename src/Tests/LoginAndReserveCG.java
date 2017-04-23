package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import dataModel.LoginUser;
import driver.Driver;
import pages.LoginPageCG;
import pages.ReserveTicket;

public class LoginAndReserveCG
{
	Driver driver = new Driver();

	@BeforeClass
	public void initDriver() 
	{
		driver.startDriver();
	}
	
	@AfterClass(alwaysRun = true)
	public void quitSession()
	{
		//driver.getDriver().quit();
	}
	
	@Test(groups = "Login")
	public void VerifySuccessfulLogin()
	{
		LoginPageCG loginPage = new LoginPageCG(driver);
		LoginUser user = new LoginUser("fifcb@abv.bg", "passwordfifcb", "username");
		loginPage.navigateToLogIn(user);
		
		Assert.assertEquals(loginPage.welcomeUser.getText().trim(), user.getUsername());
	}
	
	@Test(dependsOnGroups = "Login")
	public void ReserveTicket() throws InterruptedException
	{
		ReserveTicket ticketReservation = new ReserveTicket(driver);
		ticketReservation.NavigateToBuyNow();
		Assert.assertEquals(ticketReservation.continueButton.getText().trim(), "Продължи");
		ticketReservation.NavigateToDateTime();
		Assert.assertEquals(ticketReservation.proceedButton.getText().trim(), "Продължи");
	}
}
