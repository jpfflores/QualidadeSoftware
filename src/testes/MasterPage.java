package testes;

import org.openqa.selenium.WebElement;

public class MasterPage {

	public void digitaTexto(WebElement elemento,String texto){
		elemento.clear();
		elemento.sendKeys(texto);
	}
	
	
}
