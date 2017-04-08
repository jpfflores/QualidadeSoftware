package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import system.Driver;

public class ContatoPage extends MasterPage {
	private Driver baseDriver;
	private WebDriver driver;

	WebElement contact;
	private Select subject;
	private WebElement email;
	private WebElement order;
	private WebElement chooseFile;
	private WebElement message;
	private WebElement submit;

	public Select getSubject() {
		return subject;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getOrder() {
		return order;
	}

	public WebElement getChooseFile() {
		return chooseFile;
	}

	public WebElement getMessage() {
		return message;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public WebElement getAlert(){
		try {
			WebElement alert= driver.findElement(By.xpath("//*[@id='center_column']/div"));
			return alert;
		} catch(Exception ex){
			return null;
		}
	}

	public ContatoPage(Driver driverB) {
		baseDriver = driverB;
		driver = baseDriver.getDriver();
	}

	public void carregarContatoPage() {
		subject = carregaSelect(driver, "id_contact");
		email = driver.findElement(By.id("email"));
		//order = carregaSelect(driver, "id_order");
		order = driver.findElement(By.id("id_order"));
		message = driver.findElement(By.id("message"));
		submit = driver.findElement(By.id("submitMessage"));
	}

	public void navegarContato() {
		baseDriver.navegarPaginaBase();
		contact = driver.findElement(By.linkText("Contact us"));
		contact.click();

	}

}
