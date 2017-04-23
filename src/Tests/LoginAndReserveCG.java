package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
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
		verifySuccessfulLogin();
	}
	
	@AfterClass(alwaysRun = true)
	public void quitSession()
	{
		driver.getDriver().quit();
	}
	
	public void verifySuccessfulLogin()
	{
		LoginPageCG loginPage = new LoginPageCG(driver);
		LoginUser user = new LoginUser("fifcb@abv.bg", "passwordfifcb", "username");
		loginPage.navigateToLogIn(user);
	}
	
	@Parameters("cinemaName")
	@Test
	public void ReserveTicket(String cinemaName) throws InterruptedException
	{
		ReserveTicket ticketReservation = new ReserveTicket(driver);
		ticketReservation.NavigateToBuyNow();
		Assert.assertEquals(ticketReservation.continueButton.getText().trim(), "Продължи");
		ticketReservation.NavigateToDateTime(cinemaName);
		Assert.assertEquals(ticketReservation.proceedButton.getText().trim(), "Продължи");
		ticketReservation.NavigateToSummary();
		Assert.assertEquals(ticketReservation.reserveButton.getAttribute("value"), "резервирай сега");
	}
	
}
