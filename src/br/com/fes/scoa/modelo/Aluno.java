package br.com.fes.scoa.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno implements Serializable {

	@Id
	@ManyToOne
	private Pessoa pessoa;
	
	public Aluno() {}

	public Aluno(Pessoa pessoa) {
		this.setPessoa(pessoa);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	

}
