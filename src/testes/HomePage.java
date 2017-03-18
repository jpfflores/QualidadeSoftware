package testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private Driver localDriver;
	private WebDriver driver;
	private WebElement login;
	private WebElement user;
	private WebElement password;
	private WebElement submit;
	  
	public HomePage(){
		// TODO Auto-generated method stub
		localDriver = new Driver();
		driver = localDriver.GetDriver();
		
	
	}

}

