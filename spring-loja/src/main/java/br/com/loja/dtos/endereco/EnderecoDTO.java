package br.com.loja.dtos.endereco;

import br.com.loja.entities.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO {
	
	private Integer idEndereco;
	private String logradouro;
	private String numero;
	private String complemento;
	private String condominio;
	private String bairro;
	private String municipio;
	private String estado;
	private String cep;
		
	// convertendo um endereço em dto via construtor
	public EnderecoDTO(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.condominio = endereco.getCondominio();
		this.bairro = endereco.getBairro();
		this.municipio = endereco.getMunicipio();
		this.cep = endereco.getCep();

		if(endereco.getEstado() != null) {
			this.estado = endereco.getEstado().name();
		}
		
	}

}
