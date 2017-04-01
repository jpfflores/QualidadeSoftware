package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import system.Driver;

public class LoginPage extends MasterPage{
	private Driver baseDriver;
	private WebDriver driver;
	
	public WebElement getLogin() {
		return login;
	}

	public WebElement getUser() {
		return user;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getCreate() {
		return create;
	}
	
	public WebElement getSubmit() {
		return submit;
	}

	public WebDriver getDriver(){
		return driver;
	}
	
	private WebElement login;
	private WebElement user;
	private WebElement password;
	private WebElement submit;
	private WebElement email;
	private WebElement create;
	private WebElement alert;
	
	public LoginPage(){
		baseDriver = Driver.getInstance();
		driver = baseDriver.GetDriver();
	}
	
	public LoginPage(Driver bdriver ){
		baseDriver = bdriver;
		driver = baseDriver.GetDriver();
	}

	public void navegarLogin(){
		  baseDriver.navegarPaginaBase();
		  login = driver.findElement(By.linkText("Sign in"));
		  login.click();
	  }
	
	public void carregaObjetosPaginaLogin() {
		// TODO Auto-generated method stub
		user = driver.findElement(By.id("email"));
		password = driver.findElement(By.id("passwd"));
		submit = driver.findElement(By.id("SubmitLogin"));
		email = driver.findElement(By.id("email_create"));
		create = driver.findElement(By.id("SubmitCreate"));
	}
	
	public void digitaTexto(WebElement elemento,String texto){
		super.digitaTexto(elemento, texto);
	}
	
	public WebElement getAlert(){
//		alert = driver.findElement(By.className("alert alert-danger"));
		alert = driver.findElement(By.linkText("Authentication failed"));
		//alert = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li"));
		return alert;
		
	}
}
