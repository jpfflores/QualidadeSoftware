package system;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	private static Driver instancia;
	private WebDriver driver;
	private String baseUrl;
	
	private Driver(){
		
		String OS = System.getProperty("os.name").toLowerCase();

		if(OS.indexOf("win") >= 0){
			
			DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "..\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");                  
			//driver = new PhantomJSDriver(caps);
			
			System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			
			/*System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);*/
			/* 
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
			*/
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs");                  
			driver = new PhantomJSDriver(caps);
			
			
		}
		
	    baseUrl = "http://automationpractice.com/index.php";
	    driver.get(baseUrl);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static synchronized Driver getInstance(){
		if(instancia == null){
			instancia = new Driver();
		}
		return instancia;
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
