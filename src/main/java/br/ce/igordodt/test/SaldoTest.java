package br.ce.igordodt.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.pages.HomePage;

public class SaldoTest extends BaseTest {
	
	HomePage homePage = new HomePage();
	
	@Test
	public void testeSaldoConta() {
		Assert.assertEquals("123.00", homePage.obterSaldoConta("Conta 1"));
	}
}
