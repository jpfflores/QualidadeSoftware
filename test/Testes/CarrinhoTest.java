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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import pages.CarrinhoPage;
import pages.FancyBoxPage;
import system.Driver;
import pages.SelecionaProdutoPage;

public class CarrinhoTest {
	private Driver baseDriver;
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	CarrinhoPage carrinho;
	

	public CarrinhoTest() {
		baseDriver = Driver.getInstance();
		driver = baseDriver.getDriver();
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
		carrinho = new CarrinhoPage(baseDriver);
		carrinho.montaCarrinho();
		Assert.assertNotNull(carrinho.getEmpty());

	}

	@Test
	public void testeRemoveUmItemCarrinho() {
		// Compra dois itens
		carrinho = new CarrinhoPage(baseDriver);
		//Compra primeiro Item
		carrinho.adicionaItemCarrinho("printed");
		
		//Compra segundo item
		carrinho.adicionaItemCarrinho("short");

		// Remove um item
		carrinho.excluiItem();
		
		// conta quantos elementos estao no carrinho
		//carrinho.mostraCarrinho();
		int tries = 0;
		int qty = 0;
		do { 
			tries++;
			qty = carrinho.GetQuantityValue();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}while(qty >1 || tries < 5);
	
		// Verifica 
		Assert.assertEquals( 1, qty);
	}

	@Test
	public void testeEsvaziaCarrinho() {
		//  um item ainda no carrinho
		carrinho = new CarrinhoPage(baseDriver);
		// Remove todos os itens
		carrinho.mostraCarrinho();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		carrinho.excluiItem();
		Assert.assertNotNull(carrinho.getEmpty());
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
