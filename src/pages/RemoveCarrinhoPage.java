package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import system.Driver;
import org.openqa.selenium.By;

public class RemoveCarrinhoPage {
	private Driver baseDriver;
	private WebDriver driver;
	
	private WebElement cart;
	private WebElement empty; 
	private WebElement quantity;
	
	
	public WebElement getCart(){
		return cart;
	}
	
	public WebElement getEmpty(){
		return empty;
	}
	
	public WebElement getQuantity(){
		return quantity;
	}
	
	public RemoveCarrinhoPage(){
		 baseDriver = new Driver();
		 driver = baseDriver.GetDriver();
	}
	 
	public void montaObjeto(){
		 cart =  driver.findElement(By.linkText("Cart"));
		 empty =  driver.findElement(By.linkText("empty"));
		 quantity = driver.findElement(By.className("ajax_cart_quantity unvisible"));
		 
	}
 
	public void navegaPaginaInicial(){
		baseDriver.navegarPaginaBase();
		 
	}
	
}
