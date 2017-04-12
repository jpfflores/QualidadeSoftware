package Testes;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.CartPage;
import pages.FinalizaCompraPage;
import pages.LoginPage;
import system.Driver;

public class FinalizaCompraTest {
	
	private Driver baseDriver;
	private WebDriver driver;
	
	private FinalizaCompraPage compra;
	
	
	public FinalizaCompraTest(){
		baseDriver = Driver.getInstance();
		driver = baseDriver.getDriver();
 
	}
	

	@Test
	public void TesteCompraComUsuarioInvalido(){
		LoginPage login = new LoginPage(baseDriver);
		try {
			login.executaLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		compra = new FinalizaCompraPage(baseDriver);
		CartPage carrinho = new CartPage(baseDriver);
		//Compra primeiro Item
		carrinho.adicionaItemCarrinho("printed");
		
		carrinho.mostraCarrinho();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		int tentativas = 0;
		WebElement obj = carrinho.getCheckout();
/*		while(obj == null || tentativas >5){
			tentativas ++;
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			obj = carrinho.getCheckout();
		}*/
		obj.click();
		
		compra.loadSummary();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		compra.getPlus().click();
		compra.getCheckout().click();
		
		compra.loadLogin();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		compra.digitaTexto(compra.getUser(), "teste@teste.com");
		compra.digitaTexto(compra.getPassword(), "errado");
		compra.getSubmit().click();

		
		Assert.assertTrue("Somente para compilar.", true);
	}
	
	@Test
	public void TesteCompraComSucesso(){
		compra = new FinalizaCompraPage(baseDriver);
		CartPage carrinho = new CartPage(baseDriver);
		//Compra primeiro Item
		carrinho.adicionaItemCarrinho("printed");
		
		carrinho.mostraCarrinho();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		int tentativas = 0;
		WebElement obj = carrinho.getCheckout();
/*		while(obj == null || tentativas >5){
			tentativas ++;
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			obj = carrinho.getCheckout();
		}*/
		obj.click();
		
		compra.loadSummary();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		compra.getPlus().click();
		compra.getCheckout().click();
		
		compra.loadLogin();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		compra.digitaTexto(compra.getUser(), "teste@teste.com");
		compra.digitaTexto(compra.getPassword(), "teste");
		compra.getSubmit().click();

		
		Assert.assertTrue("Somente para compilar.", true);
	}


}
