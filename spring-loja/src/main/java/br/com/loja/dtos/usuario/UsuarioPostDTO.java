package br.com.loja.dtos.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPostDTO {
	
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
		
	@NotBlank(message = "{email.not.blank}")
//	@Email(message = "{email.email}")
	private String email;
	
	@NotBlank(message = "{senha.not.blank}")
	private String senha;
	
}
