package br.ce.igordodt.pages;

import br.ce.igordodt.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome , "Saldo", "tabelaSaldo").getText();
	}
}
