package testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroTeste {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://automationpractice.com/index.php";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCadastroTeste() throws Exception {
    driver.get(baseUrl + "/index.php");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).clear();
    driver.findElement(By.id("email_create")).sendKeys("teste@testers.com.ar");
    driver.findElement(By.id("SubmitCreate")).click();
    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("customer_firstname")).clear();
    driver.findElement(By.id("customer_firstname")).sendKeys("Teste");
    driver.findElement(By.id("customer_lastname")).clear();
    driver.findElement(By.id("customer_lastname")).sendKeys("Argentino");
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("argentina");
    driver.findElement(By.id("days")).click();
    new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:1\\s+");
    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
    new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:January\\s");
    driver.findElement(By.cssSelector("#months > option[value=\"1\"]")).click();
    new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:2016\\s+");
    driver.findElement(By.cssSelector("option[value=\"2016\"]")).click();
    driver.findElement(By.id("company")).clear();
    driver.findElement(By.id("company")).sendKeys("Buenos");
    driver.findElement(By.id("address1")).clear();
    driver.findElement(By.id("address1")).sendKeys("calle Florida 1");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Buenos Aires");
    new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("US Virgin Islands");
    driver.findElement(By.cssSelector("option[value=\"52\"]")).click();
    driver.findElement(By.id("postcode")).clear();
    driver.findElement(By.id("postcode")).sendKeys("55555");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("555669988");
    driver.findElement(By.id("submitAccount")).click();
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
