package Testes;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import pages.CartPage;
import system.Driver;
import pages.SelecionaProdutoPage;

public class CarrinhoTest {
	private Driver baseDriver;
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	CartPage carrinho;

	public CarrinhoTest() {
		baseDriver = Driver.getInstance();
		driver = baseDriver.GetDriver();
		// carrinho = new RemoveCarrinhoPage();

	}

	@Before
	public void setUp() throws Exception {
		// cada teste deve verificar a existencia de um elemento de verificacao
		// O elemento pode ser um texto de erro um objeto que so aparece depois
		// do login
		// carrinho.navegaPaginaInicial();
	}

	@Test
	public void testeEsvaziaCarrinhoSemItens() {
		// carrinho.navegaPaginaInicial();
		carrinho = new CartPage(baseDriver);
		carrinho.montaCarrinho();
		Assert.assertNotNull(carrinho.getEmpty());
		//Assert.assertTrue("Somente para compilar.", true);

	}

	@Test
	public void testeRemoveUmItemCarrinho() {
		// Compra dois itens
		carrinho = new CartPage(baseDriver);
		SelecionaProdutoPage compra = new SelecionaProdutoPage(baseDriver);
		compra.digitaTexto(compra.getSearch(), "Printed");
		compra.getSearchButton().click();
		// Comprar Primeiro produto  
		//*[@id="center_column"]/ul/li[1]/div/div[2]/div[2]/a[1]
		
		// Comprar segundo produto
		//*[@id="center_column"]/ul/li[2]/div/div[2]/div[2]/a[1]
		
		//Remove um item
		Assert.assertTrue("Somente para compilar.", true);
	}

	@Test
	public void testeEsvaziaCarrinho() {
		// Compra dois itens
		carrinho = new CartPage(baseDriver);
		
		// Remove todos os itens
		Assert.assertTrue("Somente para compilar.", true);
	}
	
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
