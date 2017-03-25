package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.ContatoPage;
import pages.LoginPage;

public class ContatoTest {
	private ContatoPage contato;
	
	@Before
	public void setUp() throws Exception {
		// cada teste deve verificar a existencia de um elemento de verificacao
		// O elemento pode ser um texto de erro um objeto que so aparece depois
		// do login
		navigateBaseTestPage();
	}
	
	public ContatoTest() {
		contato = new ContatoPage();

	}
	
	@Test
	public void passarTest(){
		 Assert.assertTrue("Somente para compilar.", true);
	}

	// @Before
	public void navigateBaseTestPage() {
		contato.navegarContato();
		contato.carregarContatoPage();
	}

	
}
