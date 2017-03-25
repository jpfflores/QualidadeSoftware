package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import system.Driver;

public class ContatoPage {
	private Driver baseDriver;
	private WebDriver driver;
	
	WebElement contact;
	private WebElement subject;
	private WebElement email;
	private WebElement order;
	private WebElement chooseFile;
	private WebElement message;

	public WebElement getSubject(){
		return subject;
	}
	
	public WebElement getEmail(){
		return email;
	}
	
	public WebElement getOrder(){
		return order;
	}
	
	public WebElement getChooseFile(){
		return chooseFile;
	}
	
	public WebElement getMessage(){
		return message;
	}
	
	public ContatoPage(){
		
	}
	
	public void carregarContatoPage(){
		subject = driver.findElement(By.name("id_contact"));
		email = driver.findElement(By.id("email"));
		order = driver.findElement(By.name("id_order"));
		chooseFile = driver.findElement(By.linkText("Choose File"));
		message = driver.findElement(By.id("message"));
		
	}
	
	public void navegarContato(){
		 Assert.assertTrue("Somente para compilar.", true);
		 /*
		  baseDriver.navegarPaginaBase();
		  contact = driver.findElement(By.linkText("Contact us"));
		  contact.click();
		  */
	  }
	
}
