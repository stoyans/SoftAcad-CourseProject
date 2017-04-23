package dataModel;

public class LoginUser
{
	private String loginEmail;
	private String password;
	private String username;
	
	public LoginUser(String loginEmail, String password, String username)
	{
		this.loginEmail = loginEmail;
		this.password = password;
		this.username = username;
	}

	public String getLoginEmail()
	{
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail)
	{
		this.loginEmail = loginEmail;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
}
