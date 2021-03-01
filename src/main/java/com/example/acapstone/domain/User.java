package com.example.acapstone.domain;


public class User {
	private final String username = "UCIOncology";
	private final String password = "breastcancer";
	public String tempUsername;
	public String tempPassword;
	
	public User(String inputUsername, String inputPassword){
		tempUsername = inputUsername;
		tempPassword = inputPassword;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean validUser() {
		if(tempUsername.equals(this.username))
		{
			if(tempPassword.equals(this.password))
			{
				return true;
			}	
		}
		return false;
	}

}
