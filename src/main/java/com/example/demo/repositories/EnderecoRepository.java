package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.example.demo.entities.Endereco;

// Annotation ligada ao mecanismo de injeção de dependência do spring boot
@Component
public interface EnderecoRepository extends JpaRepository <Endereco, Long>  {

	
}
