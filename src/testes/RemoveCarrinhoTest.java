package testes;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.junit.Assert;

import pages.RemoveCarrinhoPage;


public class RemoveCarrinhoTest {
	RemoveCarrinhoPage carrinho; 
	
	
	public RemoveCarrinhoTest(){
		carrinho = new RemoveCarrinhoPage();
		
	}
	
	@Before
	public void setUp() throws Exception {
		// cada teste deve verificar a existencia de um elemento de verificacao
		// O elemento pode ser um texto de erro um objeto que so aparece depois
		// do login
		carrinho.navegaPaginaInicial();
	}


	@Test
	public void testeEsvaziaCarrinhoComItensTest(){
		//carrinho.navegaPaginaInicial();
		 Assert.assertTrue("Somente para compilar.", true);
	}
	
	@Test
	public void testeEsvaziaCarrinhoSemItensTest(){
		carrinho.navegaPaginaInicial();
		 Assert.assertTrue("Somente para compilar.", true);
	}

	
}
