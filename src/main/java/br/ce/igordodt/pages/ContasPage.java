package br.ce.igordodt.pages;

import org.openqa.selenium.By;

import br.ce.igordodt.core.BasePage;

public class ContasPage extends BasePage {
		
	
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void salvar() {
		clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-sucess']"));
		
	}
}
