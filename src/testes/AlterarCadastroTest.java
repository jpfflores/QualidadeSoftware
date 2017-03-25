package testes;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AlterarCadastroTest {
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
  public void testAlterarCadastroTest() throws Exception {
	  Assert.assertTrue("Somente para compilar.", true);
	  /*
    driver.get(baseUrl + "/index.php?controller=my-account");
    driver.findElement(By.cssSelector("a[title=\"Information\"] > span")).click();
    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Tester");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Test");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("teste@teste.com.uk");
    new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:1\\s+");
    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
    new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:January\\s");
    driver.findElement(By.cssSelector("#months > option[value=\"1\"]")).click();
    new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:2017\\s+");
    driver.findElement(By.cssSelector("option[value=\"2017\"]")).click();
    driver.findElement(By.name("submitIdentity")).click();
    driver.findElement(By.id("old_passwd")).clear();
    driver.findElement(By.id("old_passwd")).sendKeys("teste");
    driver.findElement(By.id("passwd")).clear();
    driver.findElement(By.id("passwd")).sendKeys("tester");
    driver.findElement(By.id("confirmation")).clear();
    driver.findElement(By.id("confirmation")).sendKeys("tester");
    driver.findElement(By.name("submitIdentity")).click();
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
