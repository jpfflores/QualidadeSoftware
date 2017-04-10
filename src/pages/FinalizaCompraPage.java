package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import system.Driver;

public class FinalizaCompraPage extends MasterPage {

	Driver baseDriver;
	WebDriver driver;
	
	private WebElement minus;
	private WebElement plus;
	private WebElement quantidade;
	private WebElement excluir;
	private WebElement checkout;
	
	public FinalizaCompraPage(){
	}
	public void loadSummary(){	
		// SUmmary
		
		checkout = driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]"));
		minus = driver.findElement(By.className("cart_quantity_down_2_7_0_0"));
		plus = driver.findElement(By.className("cart_quantity_up_2_7_0_0"));
		excluir = driver.findElement(By.className("cart_quantity_delete"));
		checkout = driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span"));

		// SignIn
		// LoginPage
		
	}

	public void loadLogin(){	

	}
	
	public void loadAddressTab(){
		// Address
		// updateDelivery = //*[@id="address_delivery"]/li[7]/a
		// obs = "form-control"
		
		// proceed = //*[@id="center_column"]/form/p/button
	}
	
	public void loadShippingTab(){
		// Shipping
		//check By.id("cgv")
		// proceed //*[@id="form"]/p/button
		// alert className("fancybox-error")
		
		// text (Read the Terms of Service)
		
		// class fancybox-error - do not agree
	}
	
	public void loadPaymentTab(){
		// Payment
		
		//pay by bank wire  By.className("bankwire"));
			// confirm		//*[@id="cart_navigation"]/button
			//  finished
		// Pay by check
		//By.className("cheque");

		// confirm //*[@id="cart_navigation"]/button
		//By.tagName("")
		// other http://automationpractice.com/index.php?controller=order&step=3
	}
	
	
}
