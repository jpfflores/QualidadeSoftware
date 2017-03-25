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


public class RemoveCarrinho {
	RemoveCarrinhoPage carrinho; 
	
	
	public RemoveCarrinho(){
		carrinho = new RemoveCarrinhoPage();
		
	}
	
	@Before
	public void setUp() throws Exception {
		// cada teste deve verificar a exist�ncia de um elemento de verifica��o
		// O elemento pode ser um texto de erro um objeto que s� aparece depois
		// do login
		carrinho.navegaPaginaInicial();
	}


	@Test
	public void testeEsvaziaCarrinhoComItens(){
		carrinho.navegaPaginaInicial();
		
	}
	
	@Test
	public void testeEsvaziaCarrinhoSemItens(){
		carrinho.navegaPaginaInicial();
		
	}

	
}
