package br.ce.igordodt.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.pages.ContasPage;
import br.ce.igordodt.pages.MenuPage;

public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeInserirConta(){
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do Igor");
		contasPage.salvar();
		
		
		Assert.assertEquals("Conta adicionada com sucesso", contasPage.obterMensagemSucesso());
		
	}
	
	@Test
	public void testeAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Teste");
		
	}

}