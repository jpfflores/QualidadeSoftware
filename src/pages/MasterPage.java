package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MasterPage {

	public void digitaTexto(WebElement elemento,String texto){
		elemento.clear();
		elemento.sendKeys(texto);
	}
	
	public void mostraMenuEscondido(WebElement menu, WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(menu).perform();
	}
	/*
	public void localizaElemento(String local, WebElement elemento){
		elemento = driver.findElement(By.className("heading-counter"));
		if(elemento == null)
			return null;
		else
			return elemento;
		
		else {
			if (searchAlert.getText().contains("0 results have been found."))
				return searchAlert;
			else
				return null;
		}		
		ajax_cart_no_product		
	}
	*/
}
