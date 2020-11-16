package be.ce.igordodt.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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
}
