package br.ce.igordodt.core;

import static br.ce.igordodt.core.DriverFactory.getDriver;
import static br.ce.igordodt.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.igordodt.pages.LoginPage;

public class BaseTest {	
	@Rule
	public TestName testName = new TestName();
	
	private LoginPage page = new LoginPage();
	
	@Before
	public void inicializa(){
		page.acessarTelaInicial();
		
		page.logar("igorcdodt@gmail.com", "Igor1996@nina");
	}
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		if(Properties.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
