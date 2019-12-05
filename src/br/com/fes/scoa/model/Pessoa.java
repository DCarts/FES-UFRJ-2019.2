/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package br.com.fes.scoa.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

public class Pessoa {
	public Pessoa() {
	}
	
	private int id;
	
	private String cpf;
	
	private java.util.Date data_nascimento;
	
	private String email;
	
	private String endereco;
	
	private String nome;
	
	private String senha;
	
	private br.com.fes.scoa.model.Aluno aluno;
	
	private br.com.fes.scoa.model.Professor professor;
	
	private br.com.fes.scoa.model.Secretario secretario;
	
	private br.com.fes.scoa.model.Sysadmins sysadmins;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setCpf(String value) {
		this.cpf = value;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setData_nascimento(java.util.Date value) {
		this.data_nascimento = value;
	}
	
	public java.util.Date getData_nascimento() {
		return data_nascimento;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEndereco(String value) {
		this.endereco = value;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setSenha(String value) {
		this.senha = value;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setAluno(br.com.fes.scoa.model.Aluno value) {
		if (this.aluno != value) {
			br.com.fes.scoa.model.Aluno laluno = this.aluno;
			this.aluno = value;
			if (value != null) {
				aluno.setPessoa(this);
			}
			if (laluno != null && laluno.getPessoa() == this) {
				laluno.setPessoa(null);
			}
		}
	}
	
	public br.com.fes.scoa.model.Aluno getAluno() {
		return aluno;
	}
	
	public void setProfessor(br.com.fes.scoa.model.Professor value) {
		if (this.professor != value) {
			br.com.fes.scoa.model.Professor lprofessor = this.professor;
			this.professor = value;
			if (value != null) {
				professor.setPessoa(this);
			}
			if (lprofessor != null && lprofessor.getPessoa() == this) {
				lprofessor.setPessoa(null);
			}
		}
	}
	
	public br.com.fes.scoa.model.Professor getProfessor() {
		return professor;
	}
	
	public void setSecretario(br.com.fes.scoa.model.Secretario value) {
		if (this.secretario != value) {
			br.com.fes.scoa.model.Secretario lsecretario = this.secretario;
			this.secretario = value;
			if (value != null) {
				secretario.setPessoa(this);
			}
			if (lsecretario != null && lsecretario.getPessoa() == this) {
				lsecretario.setPessoa(null);
			}
		}
	}
	
	public br.com.fes.scoa.model.Secretario getSecretario() {
		return secretario;
	}
	
	public void setSysadmins(br.com.fes.scoa.model.Sysadmins value) {
		if (this.sysadmins != value) {
			br.com.fes.scoa.model.Sysadmins lsysadmins = this.sysadmins;
			this.sysadmins = value;
			if (value != null) {
				sysadmins.setPessoa(this);
			}
			if (lsysadmins != null && lsysadmins.getPessoa() == this) {
				lsysadmins.setPessoa(null);
			}
		}
	}
	
	public br.com.fes.scoa.model.Sysadmins getSysadmins() {
		return sysadmins;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}

	private BooleanProperty checked = new SimpleBooleanProperty(false);

	public ObservableBooleanValue getChecked() {
		return checked;
	}

	public Boolean isChecked() {
		return getChecked().getValue();
	}

	public void setChecked(Boolean checked) {
		this.checked.set(checked);
	}
	
}
