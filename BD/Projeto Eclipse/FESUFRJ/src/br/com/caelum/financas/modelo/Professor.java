package br.com.caelum.financas.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Professor implements Serializable {

	@Id
	@ManyToOne
	private Pessoa pessoa;
	
	public Professor() {}
	
	public Professor(Pessoa pessoa) {
		
		this.setPessoa(pessoa);
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
