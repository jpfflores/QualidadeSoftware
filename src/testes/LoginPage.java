package testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private Driver baseDriver;
	private WebDriver driver;
	private WebElement login;
	private WebElement user;
	private WebElement password;
	private WebElement submit;
	
	public LoginPage(){
		baseDriver = new Driver();
		driver = baseDriver.GetDriver();
	}
	
	private void navegarLogin(){
		  baseDriver.navegarPaginaBase();
		  login = driver.findElement(By.linkText("Sign in"));
		  login.click();
	  }
	
  private void carregaObjetosPaginaLogin() {
		// TODO Auto-generated method stub
		user = driver.findElement(By.id("email"));
		password = driver.findElement(By.id("passwd"));
		submit = driver.findElement(By.id("SubmitLogin"));
		
	}
}
