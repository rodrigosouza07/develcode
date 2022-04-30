package com.develcode.rodrigo.service;

	import org.springframework.beans.BeanUtils;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.dao.EmptyResultDataAccessException;
	import org.springframework.stereotype.Service;

	import com.develcode.rodrigo.model.Usuario;
	import com.develcode.rodrigo.repository.UsuarioRepository;

	@Service
	public class UsuarioService {

		@Autowired
		private UsuarioRepository usuarioRepository;

		public Usuario atualizar(Long codigo, Usuario usuario) {

			Usuario usuarioSalvo = buscarUsuarioPeloCodigo(codigo);

			BeanUtils.copyProperties(usuario, usuarioSalvo, "codigo");

			return usuarioRepository.save(usuarioSalvo);
		}
		
		private Usuario buscarUsuarioPeloCodigo(Long codigo) {
			Usuario usuarioSalvo = usuarioRepository
					.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
			return usuarioSalvo;
		}

	}