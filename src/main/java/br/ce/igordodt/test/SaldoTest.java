package br.ce.igordodt.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.core.Properties;
import br.ce.igordodt.pages.HomePage;
import br.ce.igordodt.pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	HomePage homePage = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testeSaldoConta() {
		menu.acessarTelaPrincipal();
		
		Assert.assertEquals("7600", homePage.obterSaldoConta(Properties.NOME_CONTA_ALTERADA));
		
	}
}