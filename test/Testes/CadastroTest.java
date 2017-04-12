package Testes;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import pages.CadastroPage;
import pages.LoginPage;
import system.Driver;

public class CadastroTest {
  Driver baseDriver;
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
/* This class uses LoginPage as starting point
 * 
 * 
 */
  @Before
  public void setUp() throws Exception {

  }

  public CadastroTest(){
	  baseDriver = Driver.getInstance();
	  driver = baseDriver.getDriver();
	  
  }
  
  @Test
  public void testCadastroJaExistente() throws Exception {
	  CadastroPage cadastro = new CadastroPage(baseDriver);
	  LoginPage login = cadastro.getLogin();
	  login.navegarLogin();
	  login.carregaObjetosPaginaLogin();
	  login.digitaTexto(login.getEmail(), "teste@teste.com");
	  login.getSubmit().click();
	  Assert.assertNotNull(login.getAlert());
	
  }
  
  @Test
  public void testCadastrarCliente() throws Exception {
		CadastroPage cadastro = new CadastroPage(baseDriver);
		cadastro.navigateCadastrarUsuario();
		cadastro.carregaCadastro();
		
		cadastro.digitaTexto(cadastro.getFirstName(), "Jason");
		cadastro.digitaTexto(cadastro.getLastName(), "Bourne");
		cadastro.getGender().click();
		cadastro.digitaTexto(cadastro.getPasswCadastro(), "teste");
		cadastro.getDays().selectByIndex(9);
		cadastro.getMonths().selectByIndex(9);
		cadastro.getYears().selectByIndex(35);
		cadastro.digitaTexto(cadastro.getCompany(), "TestComp");
		cadastro.getCountry().selectByIndex(0);
		cadastro.digitaTexto(cadastro.getPhone(), "555444000");
		cadastro.digitaTexto(cadastro.getAlias(), "Testing");
		baseDriver.navegarPaginaBase();
		Assert.assertTrue("Somente para compilar.", true);
  }
  
  @Test
  public void testAlterarCadastroSucesso() throws Exception {
	CadastroPage cadastro = new CadastroPage(baseDriver);
	LoginPage login = new LoginPage(baseDriver);
	login.navegarLogin();
	login.carregaObjetosPaginaLogin();
	login.digitaTexto(login.getUser(), "teste@teste.com");
	login.digitaTexto(login.getPassword(), "teste");
	login.getSubmit().click();
	cadastro.carregaCadastroAlterar();
	
	// base para inserir os dados
	cadastro.digitaTexto(cadastro.getFirstName(), "Jason");
	cadastro.digitaTexto(cadastro.getLastName(), "Bourne");
	cadastro.digitaTexto(cadastro.getOldPassword(), "teste");
	cadastro.digitaTexto(cadastro.getEmail(), "teste@teste.com");
	//cadastro.getGender().click();
	cadastro.getSubmit().click();
	Assert.assertNotNull(cadastro.getSuccessAlert());
    
  }
  
  @Test
  public void testAlterarCadastroFaltaCampoObrigatorio() throws Exception {

  }

  @Test
  public void testAlterarCadastroTelefoneInvalido() throws Exception {

  }

  @Test
  public void testAlterarCadastroConfirmacaoSenhaErrada() throws Exception {

  }
  
  @After
  public void tearDown() throws Exception {
	//driver.close();
    //driver.quit();
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
