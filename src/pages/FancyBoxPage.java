package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import system.Driver;

public class FancyBoxPage extends MasterPage{
	/* This class controls two states of a window
	 *  with very different components
	 *  The AddToCart and GoBackOrCheckout
	 * 
	 */
	
	Driver baseDriver;
	WebDriver driver;
	SelecionaProdutoPage produto;
	
	private WebElement proceed;
	private WebElement checkout;
	private WebElement keepshop;
	
	public WebElement getAddToCart(){
		try{
			WebElement elemento = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]"));
			return elemento;
		} catch (Exception ex) {
			return null;
		}
		
		
	}
	
	public WebElement getProceed(){
		return proceed;
	}
	
	public WebElement getCheckout(){
		return checkout;
	}

	public WebElement getKeepshop(){
		keepshop = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span/i"));
		return keepshop;
	}
	
	public FancyBoxPage(Driver baseD){
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		wait = new WebDriverWait(driver, 15);
		builder = new Actions(driver);
		
	}
	
	//Checkout button of image
	
	
	//click image quick view
	
	// Quantity
	// minus    = driver.findElement(By.className("btn btn-default button-minus product_quantity_down"));
	// plus     = driver.findElement(By.className("btn btn-default button-plus product_quantity_down"));
	// qtyValue = driver.findElement(By.id("quantity_wanted"));
	
	//SELECT
	//size = driver.findelEment(By.id("group_1"));
	
	// Color
	//id="color_13"]
	////*[@id="color_14"]
	// Validate color_pick_hidden
	
	//continue = driver.findElement(By.className("continue btn btn-default button exclusive-medium"));
	// //*[@id="layer_cart"]/div[1]/div[2]/div[4]/span
	
	//chekout = driver.findElement(By.className("btn btn-default button button-medium"));
	// //*[@id="layer_cart"]/div[1]/div[2]/div[4]/a
	
	
	// addCart =
	public void loadPageDirectAddToCart(){ 
		WebElement produto = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img"));
		Actions builder = new Actions(driver);
		builder.moveToElement(produto).perform();
		proceed = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]"));
		
	}
	
	public void loadBoxPage(){
		checkout = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a"));

		keepshop = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"));
		//keepshop = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span/i"));
	}

	// more button
	//*[@id="add_to_cart"]/button
}
