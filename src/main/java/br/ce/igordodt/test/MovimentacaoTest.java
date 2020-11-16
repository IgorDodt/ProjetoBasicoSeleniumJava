package br.ce.igordodt.test;

import static br.ce.igordodt.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.igordodt.core.BaseTest;
import br.ce.igordodt.pages.MenuPage;
import br.ce.igordodt.pages.MovimentacaoPage;
import br.ce.igordodt.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest{
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao("11/11/2020");
		movPage.setDataPagamento("12/11/2020");
		movPage.setDescricao("Movimentacao do Igor Dodt");
		movPage.setInteressado("Interessado qualquer 2");
		movPage.setValor("500");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório", 
				"Valor é obrigatório",
				"Valor deve ser um número"
				)));
		
		Assert.assertEquals(6,erros.size());
	}
	
	@Test
	public void test3_inserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferençaDias(5);
		  	
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentacao do Igor Dodt");
		movPage.setInteressado("Interessado qualquer 2");
		movPage.setValor("3800");
		movPage.setConta("Conta  para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		
		Assert.assertEquals(1,erros.size());
	}
}
