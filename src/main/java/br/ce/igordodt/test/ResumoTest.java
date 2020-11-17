package br.ce.igordodt.test;

import static br.ce.igordodt.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.core.DriverFactory;
import br.ce.igordodt.pages.MenuPage;
import br.ce.igordodt.pages.ResumoPage;

public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resuPage = new ResumoPage();
	
	@Test
	public void test1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumoMensal();
		
		resuPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resuPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumoMensal();		
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resuPage.selecionarAno("2016");
		resuPage.buscar();
		
		List<WebElement> elementosEncontrados =  DriverFactory.getDriver().findElements(By.xpath("//*[id='tabelaExtrato']/tbody/tr"));
		
		Assert.assertEquals(0,elementosEncontrados.size());
	}
}
