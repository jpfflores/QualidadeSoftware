package Testes;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import pages.ContatoPage;
import pages.LoginPage;
import system.Driver;

public class ContatoTest {
	private Driver baseDriver;
	  private WebDriver driver;
	private ContatoPage contato;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		// cada teste deve verificar a existencia de um elemento de verificacao
		// O elemento pode ser um texto de erro um objeto que so aparece depois
		// do login
		//navigateBaseTestPage();
	}
	
	public ContatoTest() {
		baseDriver = new Driver();
		driver = baseDriver.GetDriver();
		contato = new ContatoPage(baseDriver);

	}
	
	@Test
	public void passarTest(){
		contato.navegarContato();
		contato.carregarContatoPage();
		
		Assert.assertTrue("Somente para compilar.", true);
	}

	// @Before
	public void navigateBaseTestPage() {
		contato.navegarContato();
		contato.carregarContatoPage();
	}

	  @After
	  public void tearDown() throws Exception {
		  driver.close();
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
