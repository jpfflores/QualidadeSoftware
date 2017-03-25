package testes;

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
import pages.MasterPage;

public class LoginTeste extends MasterPage {
	private LoginPage login;
	private StringBuffer verificationErrors = new StringBuffer();
	private boolean acceptNextAlert = true;

	@Before
	public void setUp() throws Exception {
		// cada teste deve verificar a existencia de um elemento de verificacao
		// O elemento pode ser um texto de erro um objeto que so aparece depois
		// do login
		navigateBaseTestPage();
	}

	public LoginTeste() {
		login = new LoginPage();

	}

	// @Before
	public void navigateBaseTestPage() {
		login.navegarLogin();
		login.carregaObjetosPaginaLogin();
	}

	public void testeLoginCorreto() throws Exception {
		// login.navegarLogin();
		// login.carregaObjetosPaginaLogin();

		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "teste");

		login.getSubmit().click();
		Assert.assertNotNull(login.getAlert());
	}

	@Test
	public void testeLoginSenhaErrada() throws Exception {
		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "errado");
		login.getSubmit().click();
		
		Assert.assertNotNull(login.getAlert());
		
	}

	@After
	public void tearDown() throws Exception {
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
