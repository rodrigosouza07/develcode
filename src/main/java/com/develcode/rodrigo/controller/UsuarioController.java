package com.develcode.rodrigo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.develcode.rodrigo.event.RecursoCriadoEvent;
import com.develcode.rodrigo.model.Usuario;
import com.develcode.rodrigo.repository.UsuarioRepository;
import com.develcode.rodrigo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	public UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService usuarioService;

	@Autowired
	public ApplicationEventPublisher publisher;

	@GetMapping
	private List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Usuario> criar(@Validated @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Usuario> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Usuario> usuario = usuarioRepository.findById(codigo);
		return usuario.isPresent() ? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		usuarioRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long codigo, @Validated @RequestBody Usuario usuario) {

		Usuario usuarioSalvo = usuarioService.atualizar(codigo, usuario);

		return ResponseEntity.ok(usuarioSalvo);
	}
	
}
