package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;

public class TesteLogin {
	
	private static final String URL = "http://alhofacil.shop";
	private static final String TITULO_DA_PAGINA = "MinhaLoja";
	private static final String EMAIL = "eric@gmail.com";
	private static final String SENHA = "1234";

	private WebDriver driver;
	
	private LoginPage loginPage;

	@Before
	public void inicializa() {
		driver = buildChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:chromedriver.exe");
		loginPage = new LoginPage(driver);
		
		
	}
	
	@After
	public void finaliza(){
//		driver.quit();
	}
	
//	@Test
//	public void deveRealizarLogin() {
//		driver.get(URL);
//		loginPage.setEmail(EMAIL);
//		loginPage.setSenha(SENHA);
//	}
	
	private WebDriver buildChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

}
