package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MasterPage {

	public void digitaTexto(WebElement elemento,String texto){
		elemento.clear();
		elemento.sendKeys(texto);
	}
	
	public void mostraMenuEscondido(WebElement menu, WebDriver driver){
		Actions builder = new Actions(driver);
		builder.moveToElement(menu).perform();
	}
	
	public Select carregaSelect (WebDriver driver, String label){
		WebElement element = driver.findElement(By.id(label));
		return new Select(element);
	}

	public void localizaElementoBy(WebDriver driver, WebElement elemento, String local ){
		try{
			elemento = driver.findElement(By.className(local));
		} catch(Exception ex)
		{
			elemento = null;
		}		
		
	}
}
