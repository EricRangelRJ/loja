package pages;

import org.openqa.selenium.WebDriver;

import dsl.DSL;

public class LoginPage {

	private DSL dsl;

	public LoginPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setEmail(String email) {
		dsl.escrever("mat-input-0", email);
	}

	public void setSenha(String senha) {
		dsl.escrever("mat-input-1", senha);
	}
	
}
