package br.ce.igordodt.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.igordodt.core.Properties.TipoExecucao;

public class DriverFactory {

	private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<WebDriver>(){

	@Override protected synchronized WebDriver initialValue(){return initDriver();}};

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	// private static WebDriver driver;
	private static String dirCasa = "C:\\Program Files (x86)\\ChromeDriver\\chromedriver.exe";
	private static String dirTrab = "C:\\Program Files (x86)\\Google\\chromedriver.exe";

	public static WebDriver initDriver() {
		WebDriver driver = null;
		if(Properties.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Properties.BROWSER) {
		case FIREFOX: driver = new FirefoxDriver();	break;
		case CHROME: System.setProperty("webdriver.chrome.driver", dirCasa); driver = new ChromeDriver(); break;
			}
		}
		if(Properties.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (Properties.BROWSER) {
				case FIREFOX: cap = DesiredCapabilities.firefox(); break;
				case CHROME: cap = DesiredCapabilities.chrome(); break;

			default:
				break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.107:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				System.err.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
		driver.manage().window().setSize(new Dimension(1200, 765));
		return driver;
	}

	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}
}