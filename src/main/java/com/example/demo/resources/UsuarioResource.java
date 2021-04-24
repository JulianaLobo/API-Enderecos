package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//crtl + shift + o // atalho que aplica todas as importações necessárias
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.UsuarioRepository;

// Para que o framework spring boot reconheça essa classe como um recurso, utilizamos a annotation @RestController, é um recurso REST
@RestController

// Mapeamento para que seja definido o nome 'usuarios' no final da URL que faz essa busca
@RequestMapping(value = "/usuarios")

//Criando o subpacote resources para definir os recursos oferecidos para serem acessados na minha aplicação
public class UsuarioResource {
	
	// Essa annotation faz a injeção de dependências sem que o programador tenha que se preocupar com isso, para que ela funcione é necessário declarar a @Component nos Repositories
	@Autowired
	private UsuarioRepository usuarioRepository;

	// Método getAll que puxa todos os IDs de usuários cadastrados
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = usuarioRepository.findAll(); // usuarioRepository busca os dados no banco e eles são retornados através dessa list
		
		// Instanciando uma resposta de código 200, que indica que a solicitação foi bem sucedida, ou seja, vai retornar a lista
		return ResponseEntity.ok().body(list);
	}

	// Método que implementa a busca por um Id específico de um usuário
	@GetMapping(value = "/{id}") //A annotation @PathVariable reconhece que a variável id é o mesmo número que será passado na URL através do 'value' declarado na annotation @GetMapping
	public ResponseEntity<Usuario> findtById(@PathVariable Long id) {
		
		Usuario us = usuarioRepository.findById(id).get(); // fazendo a busca no banco de dados passando o argumento id que foi solicitado na requisição		
		 
		return ResponseEntity.ok().body(us);
	}
}
