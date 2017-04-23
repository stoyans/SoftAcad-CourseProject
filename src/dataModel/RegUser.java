package dataModel;

public class RegUser
{
	private String fName;
	private String lName;
	private String email;
	private String confirmEmail;
	private String pass;
	private String confirmPass;
	private String dateOfBirth;
	private Boolean isMale;
	private String city;
	private String cinema;
	private String username;
	private String phone;
	
	public RegUser(String fName, String lName, String email, String pass,
			String confirmPass, String dateOfBirth, String city, String cinema)
	{
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pass = pass;
		this.confirmPass = confirmPass;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.cinema = cinema;
	}
	
	public RegUser(String fName, String lName, String email, String pass,
			String confirmPass, String dateOfBirth, Boolean isMale, String city, String cinema)
			
	{
		this(fName, lName, email, pass, confirmPass, dateOfBirth, city, cinema);
		this.isMale = isMale;
	}
	
	public RegUser(String fName, String username, String email, String confirmEmail, String pass,
			String confirmPass, String phone)
			
	{
		this.fName = fName;
		this.username = username;
		this.confirmEmail = confirmEmail;
		this.phone = phone;
		this.email = email;
		this.pass = pass;
		this.confirmPass = confirmPass;
	}

	public String getfName()
	{
		return fName;
	}

	public void setfName(String fName)
	{
		this.fName = fName;
	}

	public String getlName()
	{
		return lName;
	}

	public void setlName(String lName)
	{
		this.lName = lName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public String getConfirmPass()
	{
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass)
	{
		this.confirmPass = confirmPass;
	}

	public String getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getIsMale()
	{
		return isMale;
	}

	public void setIsMale(Boolean isMale)
	{
		this.isMale = isMale;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCinema()
	{
		return cinema;
	}

	public void setCinema(String cinema)
	{
		this.cinema = cinema;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getCofirmEmail()
	{
		return confirmEmail;
	}

	public void setCofirmEmail(String cofirmEmail)
	{
		this.confirmEmail = cofirmEmail;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}
}
