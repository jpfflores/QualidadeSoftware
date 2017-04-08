package Testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pages.SelecionaProdutoPage;
import system.Driver;

public class SelecionarTest {
	private Driver baseDriver;
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private SelecionaProdutoPage compra;

	@Before
	public void setUp() throws Exception {
	}

	public SelecionarTest() {
		baseDriver = Driver.getInstance();
		driver = baseDriver.getDriver();
		compra = new SelecionaProdutoPage(baseDriver);

	}

	@Test
	public void testBuscaProdutoSucesso() throws Exception {
		
		compra.digitaTexto(compra.getSearch(), "Printed");
		compra.getSearchButton().click();
		Assert.assertNotNull(compra.getSearchFound());
	}

	@Test
	public void testBuscaProdutoNaoEncontrado() throws Exception {
		compra.digitaTexto(compra.getSearch(), "None");
		compra.getSearchButton().click();
		
		Assert.assertNotNull(compra.getSearchAlert());
		
	}
	
	@Test
	public void selectByButtonAddToCart(){
		//compra..getAddToCart()
	}
	
/*
	@Test
	public void testSelecionarTShirt() throws Exception {
		compra = new SelecionaProdutoPage(baseDriver);
		compra.SelecionaSubMenuTShirtsWomen();
		Assert.assertTrue("Somente para compilar.", true);

	}
*/
	@After
	public void tearDown() throws Exception {
		// driver.close();
		// driver.quit();
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
