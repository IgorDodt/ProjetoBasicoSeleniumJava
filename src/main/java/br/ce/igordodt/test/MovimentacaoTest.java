package br.ce.igordodt.test;

import static br.ce.igordodt.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.pages.MenuPage;
import br.ce.igordodt.pages.MovimentacaoPage;
import br.ce.igordodt.utils.DataUtils;

public class MovimentacaoTest extends BaseTest{
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void testeInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("05/11/2020");
		movPage.setDataPagamento("06/11/2020");
		movPage.setDescricao("Movimentacao do Igor");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("250");
		movPage.setConta("Conta do Igor alterada");
		movPage.setStatusPAgo();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio", 
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero"
				)));
		
		Assert.assertEquals(6,erros.size());
	}
	
	@Test
	public void inserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferen�aDias(5);
		  	
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentacao do Igor");
		movPage.setInteressado("Interessado qualquer");
		movPage.setValor("250");
		movPage.setConta("Conta do Igor alterada");
		movPage.setStatusPAgo();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data de Movimenta��o deve ser menor ou igual � data atual"));
		
		Assert.assertEquals(1,erros.size());
	}
}
