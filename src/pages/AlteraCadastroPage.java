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
		
	    driver.findElement(By.cssSelector("a[title=\"Information\"] > span")).click();
	    gender = driver.findElement(By.id("id_gender1"));
	    firstName = driver.findElement(By.id("firstname"));
	    lastName = driver.findElement(By.id("lastname"));
	    email = driver.findElement(By.id("email"));
	    new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:1\\s+");
	    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
	    new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:January\\s");
	    driver.findElement(By.cssSelector("#months > option[value=\"1\"]")).click();
	    new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:2017\\s+");
	    driver.findElement(By.cssSelector("option[value=\"2017\"]")).click();
	    driver.findElement(By.name("submitIdentity"));
	    oldPassword = driver.findElement(By.id("old_passwd"));
	    password = driver.findElement(By.id("passwd"));
	    confirmation = driver.findElement(By.id("confirmation"));
	    submit = driver.findElement(By.name("submitIdentity"));
	}
}
