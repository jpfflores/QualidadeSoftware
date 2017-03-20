package system;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	private WebDriver driver;
	private String baseUrl;
	
	public Driver(){
		
		//System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu201631416\\workspace\\geckodriver-v0.15.0-win64\\geckodriver.exe");  
		//System.setProperty("webdriver.firefox.marionette","C:\\Users\\Achronys\\workspace\\geckodriver-v0.15.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Achronys\\workspace\\geckodriver-v0.15.0-win64\\" + "geckodriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
	    driver = new FirefoxDriver(capabilities);
	    baseUrl = "http://automationpractice.com/index.php";
	    driver.get(baseUrl);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public WebDriver GetDriver(){
		return driver;
	}
	
	public String GetBaseUrk(){
		return baseUrl;
	}
	 
	
	public void navegarPaginaBase(){
		if(driver.getCurrentUrl().compareTo(baseUrl) != 0){
			driver.navigate().to(baseUrl);
		}
	}
}
