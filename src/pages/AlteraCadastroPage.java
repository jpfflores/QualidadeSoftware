package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import system.Driver;

public class AlteraCadastroPage {

	private Driver baseDriver;
	private WebDriver driver;
	private LoginPage login;
	private WebElement gender;
	private WebElement firstName;
	private WebElement lastName;
	private WebElement email;
	private WebElement oldPassword;
	private WebElement password;
	private WebElement confirmation;
	private WebElement submit;
	
	
	public WebElement getGender(){
		return gender;
	}
	
	public WebElement GetFirstName(){
		return firstName;
	}

	public WebElement GetLastName(){
		return lastName;
	}

	public WebElement getEmail(){
		return email;
	}

	public WebElement getOldPassword(){
		return oldPassword;
	}

	public WebElement getPassword(){
		return password;
	}

	public WebElement getConfirmation(){
		return confirmation;
	}

	public WebElement getSubmit(){
		return submit;
	}

	
	public AlteraCadastroPage(){
		

	}
}
