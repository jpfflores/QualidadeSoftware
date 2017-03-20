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
	WebElement gender;
	
	public AlteraCadastroPage(){
		
	    //driver.get(baseUrl + "/index.php?controller=my-account");
	    driver.findElement(By.cssSelector("a[title=\"Information\"] > span")).click();
	    gender = driver.findElement(By.id("id_gender1"));
	    driver.findElement(By.id("firstname")).clear();
	    driver.findElement(By.id("firstname")).sendKeys("Tester");
	    driver.findElement(By.id("lastname")).clear();
	    driver.findElement(By.id("lastname")).sendKeys("Test");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("teste@teste.com.uk");
	    new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:1\\s+");
	    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
	    new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:January\\s");
	    driver.findElement(By.cssSelector("#months > option[value=\"1\"]")).click();
	    new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:2017\\s+");
	    driver.findElement(By.cssSelector("option[value=\"2017\"]")).click();
	    driver.findElement(By.name("submitIdentity")).click();
	    driver.findElement(By.id("old_passwd")).clear();
	    driver.findElement(By.id("old_passwd")).sendKeys("teste");
	    driver.findElement(By.id("passwd")).clear();
	    driver.findElement(By.id("passwd")).sendKeys("tester");
	    driver.findElement(By.id("confirmation")).clear();
	    driver.findElement(By.id("confirmation")).sendKeys("tester");
	    driver.findElement(By.name("submitIdentity")).click();
	}
}
