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

public class Professor {
	public Professor() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PROFESSOR_TURMA) {
			return ORM_turma;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PROFESSOR_PESSOA) {
			this.pessoa = (br.com.fes.scoa.model.Pessoa) owner;
		}
		
		else if (key == ORMConstants.KEY_PROFESSOR_AREA_DISCIPLINA) {
			this.area_disciplina = (br.com.fes.scoa.model.Area_disciplina) owner;
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
	
	private br.com.fes.scoa.model.Area_disciplina area_disciplina;
	
	private java.util.Set ORM_turma = new java.util.HashSet();
	
	public void setPessoa(br.com.fes.scoa.model.Pessoa value) {
		if (this.pessoa != value) {
			br.com.fes.scoa.model.Pessoa lpessoa = this.pessoa;
			this.pessoa = value;
			if (value != null) {
				pessoa.setProfessor(this);
			}
			if (lpessoa != null && lpessoa.getProfessor() == this) {
				lpessoa.setProfessor(null);
			}
		}
	}
	
	public br.com.fes.scoa.model.Pessoa getPessoa() {
		return pessoa;
	}
	
	public br.com.fes.scoa.model.Pessoa getORMID() {
		return getPessoa();
	}
	
	public void setArea_disciplina(br.com.fes.scoa.model.Area_disciplina value) {
		if (area_disciplina != null) {
			area_disciplina.professor.remove(this);
		}
		if (value != null) {
			value.professor.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Area_disciplina getArea_disciplina() {
		return area_disciplina;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Area_disciplina(br.com.fes.scoa.model.Area_disciplina value) {
		this.area_disciplina = value;
	}
	
	private br.com.fes.scoa.model.Area_disciplina getORM_Area_disciplina() {
		return area_disciplina;
	}
	
	private void setORM_Turma(java.util.Set value) {
		this.ORM_turma = value;
	}
	
	private java.util.Set getORM_Turma() {
		return ORM_turma;
	}
	
	public final br.com.fes.scoa.model.TurmaSetCollection turma = new br.com.fes.scoa.model.TurmaSetCollection(this, _ormAdapter, ORMConstants.KEY_PROFESSOR_TURMA, ORMConstants.KEY_TURMA_PROFESSOR, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
