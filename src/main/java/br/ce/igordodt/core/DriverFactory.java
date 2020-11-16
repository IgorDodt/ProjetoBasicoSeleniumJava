package br.ce.igordodt.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {

		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};

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
		switch (Properties.browser) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", dirTrab);
			driver = new ChromeDriver();
			break;
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