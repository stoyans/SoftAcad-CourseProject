package dataModel;

public class RegUser
{
	private String fName;
	private String lName;
	private String email;
	private String pass;
	private String confirmPass;
	private String dateOfBirth;
	private Boolean[] genderOptions;
	
	public RegUser(String fName, String lName, String email, String pass,
			String confirmPass, String dateOfBirth, Boolean[] genderOptions)
	{
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pass = pass;
		this.confirmPass = confirmPass;
		this.dateOfBirth = dateOfBirth;
		this.genderOptions = genderOptions;
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

	public Boolean[] getGenderOptions()
	{
		return genderOptions;
	}

	public void setGenderOptions(Boolean[] genderOptions)
	{
		this.genderOptions = genderOptions;
	}
}
