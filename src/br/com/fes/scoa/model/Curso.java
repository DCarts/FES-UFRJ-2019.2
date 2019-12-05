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

public class Curso {
	public Curso() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CURSO_DISCIPLINA) {
			return ORM_disciplina;
		}
		else if (key == ORMConstants.KEY_CURSO_ALUNO) {
			return ORM_aluno;
		}
		else if (key == ORMConstants.KEY_CURSO_SECRETARIO) {
			return ORM_secretario;
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
	
	private java.util.Set ORM_disciplina = new java.util.HashSet();
	
	private java.util.Set ORM_aluno = new java.util.HashSet();
	
	private java.util.Set ORM_secretario = new java.util.HashSet();
	
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
	
	private void setORM_Disciplina(java.util.Set value) {
		this.ORM_disciplina = value;
	}
	
	private java.util.Set getORM_Disciplina() {
		return ORM_disciplina;
	}
	
	public final br.com.fes.scoa.model.DisciplinaSetCollection disciplina = new br.com.fes.scoa.model.DisciplinaSetCollection(this, _ormAdapter, ORMConstants.KEY_CURSO_DISCIPLINA, ORMConstants.KEY_DISCIPLINA_CURSO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Aluno(java.util.Set value) {
		this.ORM_aluno = value;
	}
	
	private java.util.Set getORM_Aluno() {
		return ORM_aluno;
	}
	
	public final br.com.fes.scoa.model.AlunoSetCollection aluno = new br.com.fes.scoa.model.AlunoSetCollection(this, _ormAdapter, ORMConstants.KEY_CURSO_ALUNO, ORMConstants.KEY_ALUNO_CURSO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Secretario(java.util.Set value) {
		this.ORM_secretario = value;
	}
	
	private java.util.Set getORM_Secretario() {
		return ORM_secretario;
	}
	
	public final br.com.fes.scoa.model.SecretarioSetCollection secretario = new br.com.fes.scoa.model.SecretarioSetCollection(this, _ormAdapter, ORMConstants.KEY_CURSO_SECRETARIO, ORMConstants.KEY_SECRETARIO_CURSO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
