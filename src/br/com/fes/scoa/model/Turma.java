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

public class Turma {
	public Turma() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_TURMA_ALOCACAO_SALA_TURMA) {
			return ORM_alocacao_sala_turma;
		}
		else if (key == ORMConstants.KEY_TURMA_INSCRICAO_ALUNO) {
			return ORM_inscricao_aluno;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_TURMA_DISCIPLINA) {
			this.disciplina = (br.com.fes.scoa.model.Disciplina) owner;
		}
		
		else if (key == ORMConstants.KEY_TURMA_PROFESSOR) {
			this.professor = (br.com.fes.scoa.model.Professor) owner;
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
	
	private int id;
	
	private br.com.fes.scoa.model.Disciplina disciplina;
	
	private br.com.fes.scoa.model.Professor professor;
	
	private String periodo;
	
	private java.util.Set ORM_alocacao_sala_turma = new java.util.HashSet();
	
	private java.util.Set ORM_inscricao_aluno = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPeriodo(String value) {
		this.periodo = value;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setDisciplina(br.com.fes.scoa.model.Disciplina value) {
		if (disciplina != null) {
			disciplina.turma.remove(this);
		}
		if (value != null) {
			value.turma.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Disciplina getDisciplina() {
		return disciplina;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Disciplina(br.com.fes.scoa.model.Disciplina value) {
		this.disciplina = value;
	}
	
	private br.com.fes.scoa.model.Disciplina getORM_Disciplina() {
		return disciplina;
	}
	
	public void setProfessor(br.com.fes.scoa.model.Professor value) {
		if (professor != null) {
			professor.turma.remove(this);
		}
		if (value != null) {
			value.turma.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Professor getProfessor() {
		return professor;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Professor(br.com.fes.scoa.model.Professor value) {
		this.professor = value;
	}
	
	private br.com.fes.scoa.model.Professor getORM_Professor() {
		return professor;
	}
	
	private void setORM_Alocacao_sala_turma(java.util.Set value) {
		this.ORM_alocacao_sala_turma = value;
	}
	
	private java.util.Set getORM_Alocacao_sala_turma() {
		return ORM_alocacao_sala_turma;
	}
	
	public final br.com.fes.scoa.model.Alocacao_sala_turmaSetCollection alocacao_sala_turma = new br.com.fes.scoa.model.Alocacao_sala_turmaSetCollection(this, _ormAdapter, ORMConstants.KEY_TURMA_ALOCACAO_SALA_TURMA, ORMConstants.KEY_ALOCACAO_SALA_TURMA_TURMA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Inscricao_aluno(java.util.Set value) {
		this.ORM_inscricao_aluno = value;
	}
	
	private java.util.Set getORM_Inscricao_aluno() {
		return ORM_inscricao_aluno;
	}
	
	public final br.com.fes.scoa.model.Inscricao_alunoSetCollection inscricao_aluno = new br.com.fes.scoa.model.Inscricao_alunoSetCollection(this, _ormAdapter, ORMConstants.KEY_TURMA_INSCRICAO_ALUNO, ORMConstants.KEY_INSCRICAO_ALUNO_TURMA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
