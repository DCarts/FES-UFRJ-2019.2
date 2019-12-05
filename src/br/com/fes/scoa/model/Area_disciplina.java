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

public class Area_disciplina {
	public Area_disciplina() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_AREA_DISCIPLINA_PROFESSOR) {
			return ORM_professor;
		}
		else if (key == ORMConstants.KEY_AREA_DISCIPLINA_DISCIPLINA) {
			return ORM_disciplina;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String nome;
	
	private String descricao;
	
	private java.util.Set ORM_professor = new java.util.HashSet();
	
	private java.util.Set ORM_disciplina = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDescricao(String value) {
		this.descricao = value;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	private void setORM_Professor(java.util.Set value) {
		this.ORM_professor = value;
	}
	
	private java.util.Set getORM_Professor() {
		return ORM_professor;
	}
	
	public final br.com.fes.scoa.model.ProfessorSetCollection professor = new br.com.fes.scoa.model.ProfessorSetCollection(this, _ormAdapter, ORMConstants.KEY_AREA_DISCIPLINA_PROFESSOR, ORMConstants.KEY_PROFESSOR_AREA_DISCIPLINA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Disciplina(java.util.Set value) {
		this.ORM_disciplina = value;
	}
	
	private java.util.Set getORM_Disciplina() {
		return ORM_disciplina;
	}
	
	public final br.com.fes.scoa.model.DisciplinaSetCollection disciplina = new br.com.fes.scoa.model.DisciplinaSetCollection(this, _ormAdapter, ORMConstants.KEY_AREA_DISCIPLINA_DISCIPLINA, ORMConstants.KEY_DISCIPLINA_AREA_DISCIPLINA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
