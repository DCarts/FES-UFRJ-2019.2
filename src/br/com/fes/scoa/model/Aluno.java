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

public class Aluno {
	public Aluno() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_ALUNO_INSCRICAO_ALUNO) {
			return ORM_inscricao_aluno;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ALUNO_PESSOA) {
			this.pessoa = (br.com.fes.scoa.model.Pessoa) owner;
		}
		
		else if (key == ORMConstants.KEY_ALUNO_CURSO) {
			this.curso = (br.com.fes.scoa.model.Curso) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private br.com.fes.scoa.model.Pessoa pessoa;
	
	private int pessoaId;
	
	private void setPessoaId(int value) {
		this.pessoaId = value;
	}
	
	public int getPessoaId() {
		return pessoaId;
	}
	
	private br.com.fes.scoa.model.Curso curso;
	
	private java.util.Set ORM_inscricao_aluno = new java.util.HashSet();
	
	public void setPessoa(br.com.fes.scoa.model.Pessoa value) {
		if (this.pessoa != value) {
			br.com.fes.scoa.model.Pessoa lpessoa = this.pessoa;
			this.pessoa = value;
			if (value != null) {
				pessoa.setAluno(this);
			}
			if (lpessoa != null && lpessoa.getAluno() == this) {
				lpessoa.setAluno(null);
			}
		}
	}
	
	public br.com.fes.scoa.model.Pessoa getPessoa() {
		return pessoa;
	}
	
	public br.com.fes.scoa.model.Pessoa getORMID() {
		return getPessoa();
	}
	
	public void setCurso(br.com.fes.scoa.model.Curso value) {
		if (curso != null) {
			curso.aluno.remove(this);
		}
		if (value != null) {
			value.aluno.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Curso getCurso() {
		return curso;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Curso(br.com.fes.scoa.model.Curso value) {
		this.curso = value;
	}
	
	private br.com.fes.scoa.model.Curso getORM_Curso() {
		return curso;
	}
	
	private void setORM_Inscricao_aluno(java.util.Set value) {
		this.ORM_inscricao_aluno = value;
	}
	
	private java.util.Set getORM_Inscricao_aluno() {
		return ORM_inscricao_aluno;
	}
	
	public final br.com.fes.scoa.model.Inscricao_alunoSetCollection inscricao_aluno = new br.com.fes.scoa.model.Inscricao_alunoSetCollection(this, _ormAdapter, ORMConstants.KEY_ALUNO_INSCRICAO_ALUNO, ORMConstants.KEY_INSCRICAO_ALUNO_ALUNO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(((getPessoa() == null) ? "" : String.valueOf(getPessoa().getORMID())));
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
