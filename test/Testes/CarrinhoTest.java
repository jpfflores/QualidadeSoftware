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
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import pages.CartPage;
import pages.FancyBoxPage;
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
		carrinho = new CartPage(baseDriver);
		carrinho.montaCarrinho();
		Assert.assertNotNull(carrinho.getEmpty());
		// Assert.assertTrue("Somente para compilar.", true);

	}

	@Test
	public void testeRemoveUmItemCarrinho() {
		// Compra dois itens
		carrinho = new CartPage(baseDriver);
		//Compra primeiro Item
		carrinho.adicionaItemCarrinho("printed");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Compra segundo item
		carrinho.adicionaItemCarrinho("short");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Remove um item
		carrinho.mostraCarrinho();
		// conta quantos elementos estão no carrinho
		int qty = carrinho.GetQuantityValue();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement obj = carrinho.getRemoveItem();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj.click();
		
		// Verifica 
		Assert.assertEquals(1, qty -1 );
	}

	@Test
	public void testeEsvaziaCarrinho() {
		//  um item ainda no carrinho
		carrinho = new CartPage(baseDriver);
		// Remove todos os itens
		carrinho.mostraCarrinho();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement obj = carrinho.getRemoveItem();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj.click();
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
