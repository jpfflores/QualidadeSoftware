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
	
 public RemoveCarrinhoPage(){
	 cart =  driver.findElement(By.linkText("Cart"));
	 empty =  driver.findElement(By.linkText("empty"));
	 quantity = driver.findElement(By.className("ajax_cart_quantity unvisible"));
 }
}
