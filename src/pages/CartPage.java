package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import system.Driver;
import org.openqa.selenium.By;

public class CartPage {
	private Driver baseDriver;
	private WebDriver driver;

	private WebElement cart;
	private WebElement empty;
	private WebElement emptyPage;
	private WebElement quantity;

	public WebElement getCart() {
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
	
	public int GetQuantityValue(){
		int value = 0;
		if(quantity != null){
			value = Integer.parseUnsignedInt(quantity.getText());
		}
		
		return value;
		
	}
	public CartPage(Driver baseD) {
		baseDriver = baseD;
		driver = baseDriver.GetDriver();
		quantity = driver.findElement(By.className("ajax_cart_quantity"));
		cart = driver.findElement(By.className("shopping_cart"));
		empty = driver.findElement(By.className("cart_block_no_products unvisible")); // Vazio

	}

	public void montaCarrinho() {

	}

	public void carregaSumarioCarrinho() {
		cart.click();
		emptyPage = driver.findElement(By.className("alert alert-warning"));
	}

	public void navegaPaginaInicial() {
		baseDriver.navegarPaginaBase();

	}

}
