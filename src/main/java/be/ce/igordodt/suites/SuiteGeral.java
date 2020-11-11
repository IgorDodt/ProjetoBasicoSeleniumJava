package be.ce.igordodt.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.igordodt.core.DriverFactory;
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
	public static void inicializa(){
		page.acessarTelaInicial();
		
		page.logar("igorcdodt@gmail.com", "Igor1996@nina");
	}
	
	@AfterClass
	public static void finalizar() {
		DriverFactory.killDriver();
	}
}
