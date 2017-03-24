package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import system.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage {
	private Driver baseDriver;
	private WebDriver driver;
	
	private WebElement gender;
	private WebElement firstName;
	private WebElement lastName;
	private WebElement password;
	private WebElement days;
	private WebElement months;
	private WebElement years;
	private WebElement company;
	private WebElement adress1;
	private WebElement city;
	private WebElement postCode;
	private WebElement phone;
	private WebElement submit;
	private LoginPage loginPage;
	
	public WebElement getGender(){
		return gender;
	}
	
	public WebElement GetFirstName(){
		return firstName;
	}

	public WebElement GetLastName(){
		return lastName;
	}

	public WebElement getAdress1(){
		return adress1;
	}

	public WebElement getCity(){
		return city;
	}

	public WebElement getPhone(){
		return phone;
	}


	public WebElement getSubmit(){
		return submit;
	}

	
	public CadastroPage(){
		baseDriver = new Driver();
		driver = baseDriver.GetDriver();
		loginPage = new LoginPage();
		
	}
	
	
	public void NavigateCadastroPage(){
		loginPage.navegarLogin();
		
	}
	
	public void CarregaCadastro(){
		 
		 
		    gender = driver.findElement(By.id("id_gender1"));
		    firstName = driver.findElement(By.id("customer_firstname"));
		    lastName = driver.findElement(By.id("customer_firstname"));
		    password =  driver.findElement(By.id("passwd"));
		    days = driver.findElement(By.id("days"));
		    //new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:1\\s+");
		    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
		    new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:January\\s");
		    driver.findElement(By.cssSelector("#months > option[value=\"1\"]")).click();
		    new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:2016\\s+");
		    driver.findElement(By.cssSelector("option[value=\"2016\"]")).click();
		    company = driver.findElement(By.id("company"));
		    adress1 = driver.findElement(By.id("address1"));
		    city = driver.findElement(By.id("city"));
		    new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("US Virgin Islands");
		    driver.findElement(By.cssSelector("option[value=\"52\"]")).click();
		    postCode = driver.findElement(By.id("postcode"));
		    phone = driver.findElement(By.id("phone"));
		    submit = driver.findElement(By.id("submitAccount"));
	}
	
}
