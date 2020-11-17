package br.ce.igordodt.suites;

import static br.ce.igordodt.core.DriverFactory.killDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.igordodt.pages.LoginPage;
import br.ce.igordodt.test.ContaTest;
import br.ce.igordodt.test.MovimentacaoTest;
import br.ce.igordodt.test.RemoverMovimentacaoContaTest;
import br.ce.igordodt.test.ResumoTest;
import br.ce.igordodt.test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		
		page.acessarTelaInicial();	
		page.logar("", "");
		
		page.resetar();
		
		killDriver();
	}
}
