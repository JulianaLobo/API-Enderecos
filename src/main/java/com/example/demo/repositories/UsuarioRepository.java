package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Usuario;

// Annotation ligada ao mecanismo de injeção de dependência do spring boot
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

	
}

