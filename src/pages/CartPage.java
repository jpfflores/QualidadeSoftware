package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import system.Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class CartPage extends MasterPage{
	private Driver baseDriver;
	private WebDriver driver;

	private WebElement cart;
	private WebElement empty;
	private WebElement emptyPage;
	private WebElement quantity;
	private WebElement remove;
	
	public WebElement getCart() {
		//cart = driver.findElement(By.className("shopping_cart"));
		cart = driver.findElement(By.id("layer_cart"));
		return cart;
	}

	public WebElement getEmpty() {
		return empty;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getEmptyPage() {
		return emptyPage;
	}
	
	public WebElement getRemoveItem(){
		remove = driver.findElement(By.className("ajax_cart_block_remove_link"));
		return remove;
	}
	
	public int GetQuantityValue(){
		int value = 0;
		if(quantity != null){
			value = Integer.parseUnsignedInt(quantity.getText());
		}
		
		return value;
		
	}
	public CartPage(Driver baseD) {
		baseDriver = baseD;
		driver = baseDriver.getDriver();

	}

	public void montaCarrinho() {
		mostraMenuEscondido(getCart(),driver);
		quantity = driver.findElement(By.className("ajax_cart_quantity"));
		empty = driver.findElement(By.className("ajax_cart_no_product")); // Vazio

	}

	public void carregaSumarioCarrinho() {
		cart.click();
		try{
		emptyPage = driver.findElement(By.className("alert alert-warning"));
		} catch (NoSuchElementException exc) {
			
		}
		
	}

	public void mostraCarrino(){
		WebElement obj = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(obj).perform();
	}
	
	public void navegaPaginaInicial() {
		baseDriver.navegarPaginaBase();

	}

	public void adicionaItemCarrinho(String produto) {
		// TODO Auto-generated method stub
		SelecionaProdutoPage busca = new SelecionaProdutoPage(baseDriver);
		digitaTexto(busca.getSearch(), produto);
		busca.getSearchButton().click();
		// Comprar Primeiro produto
		FancyBoxPage box = new FancyBoxPage(baseDriver);
		box.loadPageDirectAddToCart();	// *[@id="center_column"]/ul/li[1]/div/div[2]/div[2]/a[1]
		box.getAddToCart().click();
		//box.getProceed().click();
		box.loadBoxPage();
		
		//box.getKeepshop().click();
		baseDriver.navegarPaginaBase();
	}

}
