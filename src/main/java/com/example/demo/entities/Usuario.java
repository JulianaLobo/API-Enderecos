package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Criando a classe de Usuario
@Entity // Declarando que essa classe é gerenciada e mapeada pelo JPA 
public class Usuario implements Serializable {
	
	// Utilizando Serializable para declarar primeiro Id como padrão número 1
	private static final long serialVersionUID = 1L;
	// Declarando os atributos da classe
	@Id // Declarando que esse atributo é uma chave primária no banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation que faz um auto increment no campo, ou seja, toda vez que for inserido um usuario no banco o Id vai ser automaticamente incrementado em + 1
	private Long id;
	private String nome;
	private String email;
	private int cpf;
	private Date dataNascimento;
	
	@JsonIgnore // Não serializar o json
	@OneToMany (mappedBy = "usuarios") // Declarando que é um usuário para muitos endereços
	private List<Endereco> enderecos = new ArrayList<>();
	
	// Criando um construtor vazio
	public Usuario () {
		
	}

	// Criando construtor com argumentos
	public Usuario(Long id, String nome, String email, int cpf, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	// Criando um critério personalizado de comparação para a classe Usuario
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	

}


