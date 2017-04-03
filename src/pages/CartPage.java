package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import system.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class CartPage extends MasterPage{
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
		cart = driver.findElement(By.className("shopping_cart"));

	}

	public void montaCarrinho() {
		mostraMenuEscondido(cart,driver);
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

	public void navegaPaginaInicial() {
		baseDriver.navegarPaginaBase();

	}

}
