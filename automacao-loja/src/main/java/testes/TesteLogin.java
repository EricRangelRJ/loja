package testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.LoginPage;
import util.windowcommands.SystemUtil;

public class TesteLogin {
	
	private static final String URL = "http://www.alhofacil.shop";
	private static final String TITULO_DA_PAGINA = "MinhaLoja";
	private static final String EMAIL = "eric@gmail.com";
	private static final String SENHA = "1234";

	private WebDriver driver;
	
	private LoginPage loginPage;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		loginPage = new LoginPage(driver);
		
		
	}
	
	@After
	public void finaliza(){
		SystemUtil.fecharFirefox();
	}
	
	@Test
	public void deveRealizarLogin() {
		driver.get(URL);
		loginPage.setEmail(EMAIL);
		loginPage.setSenha(SENHA);
		loginPage.acionarBotaoEntrar("/html/body/app-root/app-login/div/form/button");
		assertEquals(loginPage.resgataTituloPagina(), TITULO_DA_PAGINA);
	}
	
	private WebDriver buildChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

}
