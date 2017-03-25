package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import system.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage extends MasterPage{
	private Driver baseDriver;
	private WebDriver driver;
	
	//Cadastro
	private WebElement title;
	private WebElement gender;
	private WebElement firstName;
	private WebElement lastName;
	private WebElement passwAltera;
	private WebElement passwCadastro;
	private Select days;
	private Select months;
	private Select years;
	private Select country;
	private WebElement company;
	private WebElement adress1;
	private WebElement city;
	private WebElement postCode;
	private WebElement phone;
	private WebElement submit;
	
	//Correcao
	private WebElement email;
	private WebElement oldPassword;
	private WebElement confirmation;

	private LoginPage login;
	
	
	public WebElement getTitle(){
		return title;
	}
	
	public WebElement getGender(){
		return gender;
	}
	
	public WebElement getFirstName(){
		return firstName;
	}

	public WebElement getLastName(){
		return lastName;
	}

	public Select getDays(){
		return days;
	}
	
	public Select getMonths(){
		return months;
	}
	
	public Select getYears(){
		return years;
	}
	
	public Select getCountry(){
		return country;
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

	public WebElement getEmail(){
		return email;
	}

	public WebElement getPasswCadastro(){
		return passwCadastro;
	}

	public WebElement getPasswAltera(){
		return passwAltera;
	}

	public WebElement getOldPassword(){
		return oldPassword;
	}

	public WebElement getConfirmation(){
		return confirmation;
	}

	public CadastroPage(Driver based){
		baseDriver = based;
		driver = baseDriver.GetDriver();
		login = new LoginPage(baseDriver);

		
	}
	
	public void navigateCadastroPage(){
		login.navegarLogin();
		
	}
	
	public void navigateCadastrarUsuario(){
		login.navegarLogin();
		login.carregaObjetosPaginaLogin();
		login.digitaTexto(login.getEmail(), "tester@tester.com.uk");
		login.getCreate().click();
	}
	
	
	public void carregaCadastro(){
	    gender = driver.findElement(By.id("id_gender1"));
	    firstName = driver.findElement(By.id("customer_firstname"));
	    lastName = driver.findElement(By.id("customer_lastname"));
	    passwCadastro =  driver.findElement(By.id("passwd"));
	    days = carregaSelect("days");
	    months = carregaSelect("months");
	    years = carregaSelect("years");
	    country = carregaSelect("id_country");
	    company = driver.findElement(By.id("company"));
	    adress1 = driver.findElement(By.id("address1"));
	    city = driver.findElement(By.id("city"));
	    postCode = driver.findElement(By.id("postcode"));
	    phone = driver.findElement(By.id("phone"));
	    submit = driver.findElement(By.id("submitAccount"));
	}
	
	public void carregaCadastroAlterar(){
	    driver.findElement(By.cssSelector("a[title=\"Information\"] > span")).click();
	    gender = driver.findElement(By.id("id_gender1"));
	    firstName = driver.findElement(By.id("firstname"));
	    lastName = driver.findElement(By.id("lastname"));
	    email = driver.findElement(By.id("email"));
	    days = carregaSelect("days");
	    months = carregaSelect("months");
	    years = carregaSelect("years");
	    oldPassword = driver.findElement(By.id("old_passwd"));
	    passwAltera = driver.findElement(By.id("passwd"));
	    confirmation = driver.findElement(By.id("confirmation"));
	    submit = driver.findElement(By.name("submitIdentity"));		
	}
	
	
	public Select carregaSelect ( String label){
		
		WebElement element = driver.findElement(By.id(label));
		return new Select(element);
		//s.selectByVisibleText("Opcao");
	}
}
