package br.ce.igordodt.pages;

import br.ce.igordodt.core.BasePage;

public class MenuPage extends BasePage{
	
	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}

}