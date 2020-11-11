package br.ce.igordodt.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.core.Properties;
import br.ce.igordodt.pages.ContasPage;
import br.ce.igordodt.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeExcluirContaComMovimentação() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta(Properties.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
