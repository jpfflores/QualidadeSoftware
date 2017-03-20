package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import system.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage {
	private Driver baseDriver;
	private WebDriver driver;
	
	private WebElement login;
	private WebElement user;
	private WebElement password;
	private WebElement submit;
	private LoginPage loginPage;
	
	
	public CadastroPage(){
		baseDriver = new Driver();
		driver = baseDriver.GetDriver();
		loginPage = new LoginPage();
		
	}
	
	
	public void NavigateCadastroPage(){
		loginPage.navegarLogin();
		
	}
	
	
}
