package Testes;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CarrinhoPage;
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
			e.printStackTrace();
		}
		compra = new FinalizaCompraPage(baseDriver);
		CarrinhoPage carrinho = new CarrinhoPage(baseDriver);
		//Compra primeiro Item
		carrinho.adicionaItemCarrinho("printed");
		
		carrinho.mostraCarrinho();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
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
		WebElement alert = compra.getLoginALert();
		Assert.assertNotNull(alert);
	}
	
	@Test
	public void TesteCompraComSucessoTransferencia(){
		
		compra = new FinalizaCompraPage(baseDriver);
		CarrinhoPage carrinho = new CarrinhoPage(baseDriver);

		//Compra Item
		carrinho.adicionaItemCarrinho("printed");
		carrinho.mostraCarrinho();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement obj = carrinho.getCheckout();
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

		compra.loadAddressTab();
		WebElement comentario = compra.getComentario();
//		compra.getBuilder().moveToElement(comentario).click().build().perform();
		compra.digitaTexto(comentario, "Perto da pra�a.");
		compra.getSubmitEndereco().click();
		
		compra.loadShippingTab();
		compra.getBuilder().moveToElement(compra.getAceite()).click().build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		compra.getBuilder().moveToElement(compra.getSubmitShipping()).click().build().perform();
		
		compra.loadPaymentTab();
		compra.pagarTransferencia();
		
		Assert.assertNotNull(compra.getSucesso());
	}

	@Test
	public void TesteCompraComSucessoCheque(){
		
		compra = new FinalizaCompraPage(baseDriver);
		CarrinhoPage carrinho = new CarrinhoPage(baseDriver);

		//Compra Item
		carrinho.adicionaItemCarrinho("printed");
		carrinho.mostraCarrinho();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement obj = carrinho.getCheckout();
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

		compra.loadAddressTab();
		WebElement comentario = compra.getComentario();
		compra.getBuilder().moveToElement(comentario).click().build().perform();
		compra.digitaTexto(comentario, "Perto da pra�a.");
		compra.getSubmitEndereco().click();
		
		compra.loadShippingTab();
		compra.getBuilder().moveToElement(compra.getAceite()).click().build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		compra.getBuilder().moveToElement(compra.getSubmitShipping()).click().build().perform();
		
		compra.loadPaymentTab();
		compra.pagarCheque();
		
		Assert.assertNotNull(compra.getSucesso());
	}

}
