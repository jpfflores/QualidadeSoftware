package testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTeste extends MasterPage{
  private WebDriver driver;
  private Driver baseDriver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  WebElement login;
  WebElement user;
  WebElement password;
  WebElement submit;
  @Before
  public void setUp() throws Exception {
	  // cada teste deve verificar a existência de um elemento de verificação
	  // O elemento pode ser um texto de erro um objeto que só aparece depois do login
	  
   
  }

  public LoginTeste() {
    LoginPage login = new LoginPage();
    
  }

//  @Before
  public void navigateBaseTestPage() {
	  
  }
  

  @Test
  public void testeLoginCorreto()  throws Exception{
	  login.navegarLogin();
	  login.carregaObjetosPaginaLogin();
//	  user.click();
	  super.digitaTexto(this.user,"teste@teste.com");
	  super.digitaTexto(this.password,"teste");
	  
	  submit.click();
	  
  }
  

  


@Test
  public void testeLoginSenhaErrada()  throws Exception{
	  navegarLogin();
	  carregaObjetosPaginaLogin();
//	  user.click();
	  super.digitaTexto(this.user,"teste@teste.com");
	  super.digitaTexto(this.password,"errado");
	  
	  submit.click();
	  
	  Assert.assertSame(driver.findElement(By.id("passwd")), null);
  
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
