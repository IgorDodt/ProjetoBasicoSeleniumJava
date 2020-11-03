package br.ce.igordodt.pages;

import org.openqa.selenium.By;

import br.ce.igordodt.core.BasePage;
import br.ce.igordodt.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void clicarBotaoEntrar() {
		clicarBotao(By.xpath("//button[.='Entrar']"));
	}
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		clicarBotaoEntrar();
	}

}
