package br.com.fes.scoa.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	

	private LocalDate data_nascimento;
	
	
	@Column(unique = true, length = 12)
	private String cpf;
	
	private String endereco;
	private String email;
	
	
	
	
	public Pessoa(String nome, java.time.LocalDate data_nascimento, String cpf, String endereco, String email) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
	}
	
	public Pessoa() {}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public java.time.LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(java.time.LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
