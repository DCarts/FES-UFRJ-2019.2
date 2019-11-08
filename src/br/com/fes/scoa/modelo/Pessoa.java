package br.com.fes.scoa.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@OneToMany(orphanRemoval=true)
	private List<Aluno> alunos;

	@OneToMany(orphanRemoval=true)
	private List<Professor> professores;

	private LocalDate data_nascimento;
	
	@Column(unique = true, length = 12)
	private String cpf;
	
	private String endereco;
	private String email;

	@Transient
	private BooleanProperty checked = new SimpleBooleanProperty(false);
	
	public Pessoa(String nome, java.time.LocalDate data_nascimento, String cpf, String endereco, String email) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
	}
	
	public Pessoa() {}

	@Override
	public String toString() {
		return this.getNome();
	}

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

	@Transient
	public ObservableBooleanValue getChecked() {
		return checked;
	}

	@Transient
	public Boolean isChecked() {
		return getChecked().getValue();
	}

	@Transient
	public void setChecked(Boolean checked) {
		this.checked.set(checked);
	}
}
