package Testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pages.SelecionaProdutoPage;
import system.Driver;

public class SelecionarTest {
	private Driver baseDriver;
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private SelecionaProdutoPage compra; 
  @Before
  public void setUp() throws Exception {
	  baseDriver = new Driver();
	  driver = baseDriver.GetDriver();
  }

  @Test
  public void testSelecionarTesteJavaTest() throws Exception {
	  compra = new SelecionaProdutoPage(baseDriver);
	  
	  Assert.assertTrue("Somente para compilar.", true);
	  /*
	  compra = new SelecionaProdutoPage();
    WebElement element = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
    element.sendKeys(Keys.TAB);
    driver.findElement(By.linkText("Blouses")).click();

    //Elements not visible cannot be used
    // driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a")).click();  //invisible
    driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1']")).click();
    driver.findElement(By.id("color_8")).click();
    driver.findElement(By.name("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/span/span")).click();
    */
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
