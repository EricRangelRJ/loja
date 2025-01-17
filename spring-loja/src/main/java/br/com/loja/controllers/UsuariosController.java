package br.com.loja.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.dtos.usuario.UsuarioGetDTO;
import br.com.loja.dtos.usuario.UsuarioPostDTO;
import br.com.loja.dtos.usuario.UsuarioPutDTO;
import br.com.loja.exceptions.ServiceException;
import br.com.loja.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@Tag(name = "Usuários")
@RequestMapping(value = "/api/usuarios")
public class UsuariosController {

	private final UsuarioService service;

	@PostMapping
	@Operation(summary = "Cadastrar usuário")
	public ResponseEntity<UsuarioGetDTO> cadastrar(@Valid @RequestBody UsuarioPostDTO dto) {

		try {
			UsuarioGetDTO getDto = service.cadastrar(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(getDto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping
	@Operation(summary = "Buscar usuários cadastrados")
	public ResponseEntity<List<UsuarioGetDTO>> buscarUsuarios() {

		try {
			List<UsuarioGetDTO> lista = service.buscarUsuarios();
			return ResponseEntity.ok(lista);
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping(value = "/{idUsuario}")
	@Operation(summary = "Buscar usuário por Id")
	public ResponseEntity<UsuarioGetDTO> buscarId(@PathVariable("idUsuario") Integer idUsuario) {

		try {
			UsuarioGetDTO getDto = service.buscarId(idUsuario);
			return ResponseEntity.ok(getDto);
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	@PutMapping
	@Operation(summary = "Atualizar usuário")
	public ResponseEntity<UsuarioGetDTO> atualizar(@Valid @RequestBody UsuarioPutDTO dto) {

		try {
			UsuarioGetDTO getDto = service.atualizar(dto);
			return ResponseEntity.ok(getDto);

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping(value = "/{idUsuario}")
	@Operation(summary = "Excluir usuário por Id")
	public ResponseEntity<String> excluir(@PathVariable("idUsuario") Integer idUsuario) {

		try {
			String response = service.excluir(idUsuario);
			return ResponseEntity.ok(response);
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
}