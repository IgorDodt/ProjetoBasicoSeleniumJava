package br.ce.igordodt.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.core.Properties;
import br.ce.igordodt.pages.ContasPage;
import br.ce.igordodt.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_InserirConta(){
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do Igor Dodt");
		contasPage.salvar();
		
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());	
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Igor Dodt");
		
		contasPage.setNome(Properties.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test3_InserirContaRepetida(){
		menuPage.acessarTelaInserirConta();
		contasPage.setNome(Properties.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
}