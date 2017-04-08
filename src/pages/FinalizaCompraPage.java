package pages;

import org.openqa.selenium.By;

public class FinalizaCompraPage extends MasterPage {

	public FinalizaCompraPage(){
	}
	public void loadSummary(){	
		// SUmmary
		//checkout button //*[@id="center_column"]/p[2]/a[1]
		// minus "cart_quantity_down_2_7_0_0"
		// plus "cart_quantity_up_2_7_0_0"
		// delete "cart_quantity_delete"
		// continue shopping By.href("http://automationpractice.com/index.php?id_product=1&controller=product")
		// SignIn
		// LoginPage
		
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
