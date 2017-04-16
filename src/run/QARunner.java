package run;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import Testes.CadastroTest;
import Testes.CarrinhoTest;
import Testes.ContatoTest;
import Testes.FinalizaCompraTest;
import Testes.LoginTest;

public class QARunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CadastroTest.class, CarrinhoTest.class, ContatoTest.class,
				FinalizaCompraTest.class, LoginTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}

}
