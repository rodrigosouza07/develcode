package com.develcode.rodrigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develcode.rodrigo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
