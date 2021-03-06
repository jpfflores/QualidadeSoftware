package Testes;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.junit.Assert;

import pages.LoginPage;
import system.Driver;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {
	private Driver baseDriver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private LoginPage login;
	  
	@Before
	public void setUp() throws Exception {
		// cada teste deve verificar a existencia de um elemento de verificacao
		// O elemento pode ser um texto de erro um objeto que so aparece depois
		// do login
		navigateBaseTestPage();
	}

	public LoginTest() {
		baseDriver = Driver.getInstance();
		baseDriver.getDriver();
		
		login = new LoginPage(baseDriver);

	}


	public void navigateBaseTestPage() throws Exception {
		login.executaLogout();
		login.navegarLogin();
		login.carregaObjetosPaginaLogin();
	}

	
	@Test
	public void testeLoginSenhaErrada() throws Exception {
		navigateBaseTestPage();
		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "errado");
		login.getSubmit().click();
		
		Assert.assertNotNull(login.getAlert());
		
	}
	
	@Test
	public void testeLoginCorreto() throws Exception {
		navigateBaseTestPage();
		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "teste");
		login.getSubmit().click();
		
		Assert.assertNotNull(login.getSuccess());
	}	

	@After
	public void tearDown() throws Exception {
		//driver.close();
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			login.getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			login.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = login.getDriver().switchTo().alert();
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
