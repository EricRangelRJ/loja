package br.com.loja;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import br.com.loja.dtos.auth.AuthGetDTO;
import br.com.loja.dtos.auth.AuthPostDTO;
import br.com.loja.dtos.usuario.UsuarioGetDTO;
import br.com.loja.dtos.usuario.UsuarioPostDTO;
import br.com.loja.services.AuthService;
import br.com.loja.services.UsuarioService;
import br.com.loja.utils.ClienteTestUtils;
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
	private UsuarioGetDTO usr;

	@BeforeEach
	public void setUp() {
		this.usr = cadastrarUsr();
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/api/clientes";
	}
	
	@AfterEach
	public void setDown() {
		usuarioService.excluir(this.usr.getIdUsuario());
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

	@Test
	void deveCadastrarClientes(){
		getAccessToken();
		given()
			.header("Authorization", "Bearer "+accessToken)
			.contentType(ContentType.MULTIPART)
			.multiPart("dadosCliente",ClienteTestUtils.montaClienteCadastro())
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value())
			.contentType(ContentType.JSON)
			.body("idCliente", is(notNullValue()))
			.body("email", equalTo("emailteste@gmail.com"))
			.body("cpf", equalTo("12341233302"));
		//TODO Verificar a necessidade de validação de todos os campos
		
	}
	
	private UsuarioGetDTO cadastrarUsr() {
		UsuarioPostDTO usr = new UsuarioPostDTO();
		usr.setEmail(EMAIL_TESTE);
		usr.setNome("teste");
		usr.setSenha(SENHA_TESTE);
	
		return usuarioService.cadastrar(usr);
	}
	
	private void getAccessToken() {
		AuthPostDTO auth = new AuthPostDTO();
		auth.setEmail(EMAIL_TESTE);
		auth.setSenha(SENHA_TESTE);
		AuthGetDTO logado = authService.autenticar(auth);
		accessToken = logado.getAccessToken();
	}
}
