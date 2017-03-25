package testes;

import org.junit.Before;

import pages.ContatoPage;
import pages.LoginPage;

public class ContatoTeste {
	private ContatoPage contato;
	
	@Before
	public void setUp() throws Exception {
		// cada teste deve verificar a existencia de um elemento de verificacao
		// O elemento pode ser um texto de erro um objeto que so aparece depois
		// do login
		navigateBaseTestPage();
	}
	
	public ContatoTeste() {
		contato = new ContatoPage();

	}

	// @Before
	public void navigateBaseTestPage() {
		contato.navegarContato();
		contato.carregarContatoPage();
	}

	
}
