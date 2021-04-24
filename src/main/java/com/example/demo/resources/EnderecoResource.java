package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//crtl + shift + o // atalho que aplica todas as importações necessárias
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Endereco;
import com.example.demo.repositories.EnderecoRepository;


// Para que o framework spring boot reconheça essa classe como um recurso, utilizamos a annotation @RestController, é um recurso REST
@RestController

// Mapeamento para que seja definido o nome 'enderecos' no final da URL que faz essa busca
@RequestMapping(value = "/enderecos")

//Criando o subpacote resources para definir os recursos oferecidos para serem acessados na minha aplicação
public class EnderecoResource {
	
	// Essa annotation faz a injeção de dependências sem que o programador tenha que se preocupar com isso, para que ela funcione é necessário declarar a @Component nos Repositories
	@Autowired
	private EnderecoRepository enderecoRepository;

	// Método getAll que puxa todos os IDs de endereços cadastrados
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> list = enderecoRepository.findAll(); // enderecoRepository busca os dados no banco e eles são retornados através dessa list
		
		// Instanciando uma resposta de código 200, que indica que a solicitação foi bem sucedida, ou seja, vai retornar a lista
		return ResponseEntity.ok().body(list);
	}

	// Método que implementa a busca por um Id específico de um endereco
	@GetMapping(value = "/{id}") //A annotation @PathVariable reconhece que a variável id é o mesmo número que será passado na URL através do 'value' declarado na annotation @GetMapping
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		
		Endereco end = enderecoRepository.findById(id).get(); // fazendo a busca no banco de dados passando o argumento id que foi solicitado na requisição		
		 
		return ResponseEntity.ok().body(end);
	}
}
