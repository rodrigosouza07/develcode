package com.develcode.rodrigo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.develcode.rodrigo.model.Usuario;
import com.develcode.rodrigo.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repo;
	
	@GetMapping
	private List<Usuario> listar() {
		return repo.findAll();
	}

	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		return repo.save(usuario);
	}		
}
