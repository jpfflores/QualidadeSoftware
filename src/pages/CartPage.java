package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import system.Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class CartPage extends MasterPage{
	private Driver baseDriver;
	private WebDriver driver;

	private WebElement cart;
	private WebElement empty;
	private WebElement emptyPage;
	private WebElement quantity;
	private WebElement remove;
	private WebElement checkout;
	
	public WebElement getCart() {
		cart = driver.findElement(By.id("layer_cart"));
		return cart;
	}

	public WebElement getEmpty() {
		empty = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]")); // Vazio
		return empty;
	}

	public WebElement getQuantity() {
		quantity = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/span[1]"));
		return quantity;
	}

	public WebElement getEmptyPage() {
		emptyPage = driver.findElement(By.xpath("//*[@id='center_column']/p")); // Vazio
		if (emptyPage.getText().compareToIgnoreCase("Your shopping cart is empty.") == 0)
			return emptyPage;
		else
			return null;
	}
	
	public WebElement getRemoveItem(){
		remove = driver.findElement(By.className("ajax_cart_block_remove_link"));
		return remove;
	}
	
	public int GetQuantityValue(){
		int value = 0;
		getQuantity();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(quantity != null){
			value = Integer.parseUnsignedInt(quantity.getText());
		}
		return value;
		
	}
	
	public WebElement getCheckout(){
		checkout = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		return checkout;
		
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

	public void mostraCarrinho(){
		WebElement obj = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(obj).perform();
	}
	
	public void navegaPaginaInicial() {
		baseDriver.navegarPaginaBase();

	}

	public void excluiItem(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", getRemoveItem());
//		((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('ajax_cart_block_remove_link')[0].click();");
	}
	
	public void adicionaItemCarrinho(String produto) {
		// TODO Auto-generated method stub
		SelecionaProdutoPage busca = new SelecionaProdutoPage(baseDriver);
		digitaTexto(busca.getSearch(), produto);
		busca.getSearchButton().click();
		// Comprar Primeiro produto
		FancyBoxPage box = new FancyBoxPage(baseDriver);
		box.loadPageDirectAddToCart();
		box.getAddToCart().click();
		box.loadBoxPage();
		
		baseDriver.navegarPaginaBase();
	}

}
