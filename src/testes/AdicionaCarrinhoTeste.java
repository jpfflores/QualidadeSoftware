package testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AdicionaCarrinhoTeste {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu201631416\\workspace\\geckodriver-v0.15.0-win64\\geckodriver.exe");  
	  
    driver = new FirefoxDriver();
    baseUrl = "http://automationpractice.com/index.php";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAdicionaCarrinhoTesteJava() throws Exception {
    driver.get(baseUrl + "/index.php");
    /*Actions builder = new Actions(driver);
    builder.moveToElement(target)
    builder.moveToElement(hoverElement).perform();
    By locator = By.id("clickElementID");
    driver.click(locator);
    */
    
    Actions builder = new Actions(driver);
    WebElement element = driver.findElement(By.linkText("Blouses"));
    builder.moveToElement(element).build().perform();
    
    //driver.findElement(By.linkText("Blouses")).click();
    driver.findElement(By.cssSelector("a.quick-view > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | fancybox-frame1489787209473 | ]]
    new Select(driver.findElement(By.id("group_1"))).selectByVisibleText("L");
    driver.findElement(By.cssSelector("option[title=\"L\"]")).click();
    driver.findElement(By.id("color_8")).click();
    driver.findElement(By.name("Submit")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/span/span")).click();
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
