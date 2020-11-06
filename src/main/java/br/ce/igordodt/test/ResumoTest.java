package br.ce.igordodt.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.pages.MenuPage;
import br.ce.igordodt.pages.ResumoPage;

public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resuPage = new ResumoPage();
	
	@Test
	public void testeExcluirMovimentacao() {
		menuPage.acessarTelaResumoMensal();
		
		resuPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resuPage.obterMensagemSucesso());
	}
}
