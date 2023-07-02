package br.com.loja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import br.com.loja.dtos.auth.AuthGetDTO;
import br.com.loja.dtos.auth.AuthPostDTO;
import br.com.loja.dtos.usuario.UsuarioPostDTO;
import br.com.loja.services.AuthService;
import br.com.loja.services.UsuarioService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Sobe a aplicação em uma porta aleatória
class ClienteControllerIT {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AuthService authService;
	
	@LocalServerPort
	private int port;

	private final String EMAIL_TESTE = "teste@teste.com";
	private final String SENHA_TESTE = "teste";

	private String accessToken;

	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/api/clientes";
	}

	
	@Test()
	void deveRetornarStatus403_QuandoConsultarEndpoinSemToken() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.FORBIDDEN.value());
	}

	@Test()
	void deveRetornarStatus200_QuandoConsultarClientes() {
		getAccessToken();
		given()
			.header("Authorization", "Bearer "+accessToken)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	private void getAccessToken() {
		UsuarioPostDTO usr = new UsuarioPostDTO();
		usr.setEmail(EMAIL_TESTE);
		usr.setNome("teste");
		usr.setSenha(SENHA_TESTE);
	
		usuarioService.cadastrar(usr);
		AuthPostDTO auth = new AuthPostDTO();
		auth.setEmail(EMAIL_TESTE);
		auth.setSenha(SENHA_TESTE);
		AuthGetDTO logado = authService.autenticar(auth);
		accessToken = logado.getAccessToken();
	}
}
