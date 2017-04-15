package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import system.Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class CarrinhoPage extends MasterPage{
	private Driver baseDriver;
	private WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	
	private WebElement cart;
	private WebElement empty;
	private WebElement emptyPage;
	private WebElement quantity;
	private WebElement remove;
	private WebElement checkout;

	public CarrinhoPage(Driver baseD) {
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		wait = new WebDriverWait(driver, 15);
		builder = new Actions(driver);

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
			return;
		}
		
	}

	public void mostraCarrinho(){
		WebElement obj = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(obj).perform();
	}
	
	public void excluiItem(){
		mostraCarrinho();
		builder.moveToElement(getRemoveItem()).click().build().perform();
	}
	
	public void adicionaItemCarrinho(String produto) {
		SelecionaProdutoPage busca = new SelecionaProdutoPage(baseDriver);
		digitaTexto(busca.getSearch(), produto);
		busca.getSearchButton().click();
		
		// Comprar Primeiro produto
		FancyBoxPage box = new FancyBoxPage(baseDriver);
		box.loadPageDirectAddToCart();
		box.getAddToCart().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		box.loadBoxPage();
		
		baseDriver.navegarPaginaBase();
	}

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
		remove = driver.findElement(By.xpath("//*[@class='remove_link']/a"));
		return remove;
	}

	public WebElement getCheckout(){
		checkout = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		return checkout;
	}
	
}
