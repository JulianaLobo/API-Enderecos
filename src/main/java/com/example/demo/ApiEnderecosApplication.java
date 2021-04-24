package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Usuario;
import com.example.demo.entities.Endereco;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.repositories.EnderecoRepository;

@SpringBootApplication
public class ApiEnderecosApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiEnderecosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario us1 = new Usuario(null, "Joana", "joana@gmail.com", 12345678, null);
		Usuario us2 = new Usuario(null, "Gabriel", "gabriel@gmail.com", 87456321, null);

		Endereco end1 = new Endereco(null, "Avenida dos Pássaros", 123, "Casa verde", "Cidade Jardim", "Uberlândia", "MG", 32165489, us1);
		Endereco end2 = new Endereco(null, "Rua dos Golfinhos", 123, "Casa azul", "Centro", "Uberlândia", "MG", 32165489, us2);
		Endereco end3 = new Endereco(null, "Alameda dos Lagartos", 123, "Casa rosa", "Canaã", "Uberlândia", "MG", 32165489, us1);
		Endereco end4 = new Endereco(null, "Praça dos Elefantes", 123, "Casa amarela", "Cidade Verde", "Uberlândia", "MG", 32165489, us2);

		us1.getEnderecos().addAll(Arrays.asList(end1, end3));
		us2.getEnderecos().addAll(Arrays.asList(end2, end4));
		
		usuarioRepository.save(us1);
		usuarioRepository.save(us2);
		
		enderecoRepository.save(end1);
		enderecoRepository.save(end2);
		enderecoRepository.save(end3);
		enderecoRepository.save(end4);
	}
}