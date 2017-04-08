package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import system.Driver;


public class SelecionaProdutoPage extends MasterPage{
	private Driver baseDriver;
	private WebDriver driver;
	
	private WebElement menuWomen;
	private WebElement menuDresses;
	private WebElement menuTshirts;
	private WebElement subMenuTshirts;	
	private WebElement subMenuBlousesTshirts;	
	private WebElement checkCategoriesTops;
	private WebElement menuCasualDresses;
	private WebElement menuEveningDresses;
	private WebElement menuSummerDresses;
	private WebElement checkCategoriesDresses;
	private WebElement checkCategoriesTShirts;
	private WebElement checkCategoriesBlouses;
	private WebElement checkCategoriesCasualDresses;
	private WebElement checkCategoriesEveningDresses;
	private WebElement checkCategoriesSummerDresses;
	
	private WebElement checkSizeS;
	private WebElement checkSizeM;
	private WebElement checkSizeL;
	private WebElement checkColorBeige;
	private WebElement checkColorWhite;
	private WebElement checkColorBlack;
	private WebElement checkColorOrange;
	private WebElement checkColorBlue;
	private WebElement checkColorGreen;
	private WebElement checkColorYellow;
	private WebElement checkColorPink;
	private WebElement checkCompositionCotton;
	private WebElement checkCompositionPolyester;
	private WebElement checkCompositionViscose;
	private WebElement checkStylesCasual;
	private WebElement checkStylesDressy;
	private WebElement checkStylesGirly;
	
	private WebElement search;
	private WebElement searchButton;
	private WebElement searchAlert;
	private WebElement searchFound;
	
	public WebElement getSearch(){
		return search;
		
	}
	
	public WebElement getSearchButton(){
		return searchButton;
		
	}
	
	public WebElement getSearchAlert(){
		searchAlert = driver.findElement(By.className("heading-counter"));
		if(searchAlert == null){
			return null;
		}
		else {
			if (searchAlert.getText().contains("0 results have been found."))
				return searchAlert;
			else
				return null;
		}
	}

	public WebElement getSearchFound(){
		searchFound = driver.findElement(By.className("compare-form"));
		return searchFound;
	}
		
	public SelecionaProdutoPage(Driver baseD){
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		// estes elementos sempre estarao na pagina
		search = driver.findElement(By.id("search_query_top"));
		searchButton = driver.findElement(By.xpath("//*[@id='searchbox']/button"));
	}
	
	public void SelecionaSubMenuTShirtsWomen(){
		menuWomen = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menuWomen).perform();
		this.menuTshirts = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		menuTshirts.click();
	}

	public void SelecionaSubMenuBlousesWomen(){
		menuWomen = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menuWomen).perform();
		this.menuTshirts = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a"));
		menuTshirts.click();
	}
	
	public void CarregaDresses(){
		
	}

	public void CarregaTshirt(){
		
	}
	
	public void CarregaBlouses(){
		
	}

	
}
