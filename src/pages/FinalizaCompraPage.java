package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import system.Driver;

public class FinalizaCompraPage extends MasterPage {

	Driver baseDriver;
	WebDriver driver;
	
	// Summary 
	private WebElement minus;
	private WebElement plus;
	private WebElement quantidade;
	private WebElement excluir;
	private WebElement checkout;
	
	//Login 
	private WebElement user;
	private WebElement password;
	private WebElement submit;

	
	public FinalizaCompraPage(Driver baseD){
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		
	}
	
	public void loadSummary(){	
		// Summary
		setCheckout(driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")));
		setMinus(driver.findElement(By.className("icon-minus")));
		setPlus(driver.findElement(By.className("icon-plus")));
		setExcluir(driver.findElement(By.className("cart_quantity_delete")));
		setCheckout(driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")));

		
		
	}

	public void loadLogin(){	
		user = driver.findElement(By.id("email"));
		password = driver.findElement(By.id("passwd"));
		submit = driver.findElement(By.id("SubmitLogin"));
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
	
	public WebElement getCheckout() {
		return checkout;
	}
	public void setCheckout(WebElement checkout) {
		this.checkout = checkout;
	}
	public WebElement getExcluir() {
		return excluir;
	}
	public void setExcluir(WebElement excluir) {
		this.excluir = excluir;
	}
	public WebElement getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(WebElement quantidade) {
		this.quantidade = quantidade;
	}
	public WebElement getPlus() {
		return plus;
	}
	public void setPlus(WebElement plus) {
		this.plus = plus;
	}
	public WebElement getMinus() {
		return minus;
	}
	public void setMinus(WebElement minus) {
		this.minus = minus;
	}
	
	public WebElement getUser() {
		return user;
	}
	public void setUser(WebElement user) {
		this.user = user;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

}
