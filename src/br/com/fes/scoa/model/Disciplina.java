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

public class Disciplina {
	public Disciplina() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_DISCIPLINA_DISCIPLINA1) {
			return ORM_disciplina1;
		}
		else if (key == ORMConstants.KEY_DISCIPLINA_DISCIPLINA) {
			return ORM_disciplina;
		}
		else if (key == ORMConstants.KEY_DISCIPLINA_DISCIPLINA2) {
			return ORM_disciplina2;
		}
		else if (key == ORMConstants.KEY_DISCIPLINA_PREREQUISITO) {
			return ORM_prerequisito;
		}
		else if (key == ORMConstants.KEY_DISCIPLINA_TURMA) {
			return ORM_turma;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_DISCIPLINA_AREA_DISCIPLINA) {
			this.area_disciplina = (br.com.fes.scoa.model.Area_disciplina) owner;
		}
		
		else if (key == ORMConstants.KEY_DISCIPLINA_CURSO) {
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
	
	private int id;
	
	private br.com.fes.scoa.model.Area_disciplina area_disciplina;
	
	private br.com.fes.scoa.model.Curso curso;
	
	private String codigo;
	
	private String nome;
	
	private String descricao;
	
	private int creditos;
	
	private java.util.Set ORM_disciplina1 = new java.util.HashSet();
	
	private java.util.Set ORM_disciplina = new java.util.HashSet();
	
	private java.util.Set ORM_disciplina2 = new java.util.HashSet();
	
	private java.util.Set ORM_prerequisito = new java.util.HashSet();
	
	private java.util.Set ORM_turma = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setCodigo(String value) {
		this.codigo = value;
	}
	
	public String getCodigo() {
		return codigo;
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
	
	public void setCreditos(int value) {
		this.creditos = value;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	private void setORM_Disciplina1(java.util.Set value) {
		this.ORM_disciplina1 = value;
	}
	
	private java.util.Set getORM_Disciplina1() {
		return ORM_disciplina1;
	}
	
	public final br.com.fes.scoa.model.DisciplinaSetCollection disciplina1 = new br.com.fes.scoa.model.DisciplinaSetCollection(this, _ormAdapter, ORMConstants.KEY_DISCIPLINA_DISCIPLINA1, ORMConstants.KEY_DISCIPLINA_DISCIPLINA2, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Disciplina(java.util.Set value) {
		this.ORM_disciplina = value;
	}
	
	private java.util.Set getORM_Disciplina() {
		return ORM_disciplina;
	}
	
	public final br.com.fes.scoa.model.DisciplinaSetCollection disciplina = new br.com.fes.scoa.model.DisciplinaSetCollection(this, _ormAdapter, ORMConstants.KEY_DISCIPLINA_DISCIPLINA, ORMConstants.KEY_DISCIPLINA_PREREQUISITO, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setArea_disciplina(br.com.fes.scoa.model.Area_disciplina value) {
		if (area_disciplina != null) {
			area_disciplina.disciplina.remove(this);
		}
		if (value != null) {
			value.disciplina.add(this);
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
	
	public void setCurso(br.com.fes.scoa.model.Curso value) {
		if (curso != null) {
			curso.disciplina.remove(this);
		}
		if (value != null) {
			value.disciplina.add(this);
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
	
	private void setORM_Disciplina2(java.util.Set value) {
		this.ORM_disciplina2 = value;
	}
	
	private java.util.Set getORM_Disciplina2() {
		return ORM_disciplina2;
	}
	
	public final br.com.fes.scoa.model.DisciplinaSetCollection disciplina2 = new br.com.fes.scoa.model.DisciplinaSetCollection(this, _ormAdapter, ORMConstants.KEY_DISCIPLINA_DISCIPLINA2, ORMConstants.KEY_DISCIPLINA_DISCIPLINA1, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Prerequisito(java.util.Set value) {
		this.ORM_prerequisito = value;
	}
	
	private java.util.Set getORM_Prerequisito() {
		return ORM_prerequisito;
	}
	
	public final br.com.fes.scoa.model.DisciplinaSetCollection prerequisito = new br.com.fes.scoa.model.DisciplinaSetCollection(this, _ormAdapter, ORMConstants.KEY_DISCIPLINA_PREREQUISITO, ORMConstants.KEY_DISCIPLINA_DISCIPLINA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Turma(java.util.Set value) {
		this.ORM_turma = value;
	}
	
	private java.util.Set getORM_Turma() {
		return ORM_turma;
	}
	
	public final br.com.fes.scoa.model.TurmaSetCollection turma = new br.com.fes.scoa.model.TurmaSetCollection(this, _ormAdapter, ORMConstants.KEY_DISCIPLINA_TURMA, ORMConstants.KEY_TURMA_DISCIPLINA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
