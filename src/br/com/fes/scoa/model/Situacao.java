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

public class Situacao {
	public Situacao() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_SITUACAO_INSCRICAO_ALUNO) {
			return ORM_inscricao_aluno;
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
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	private void setORM_Inscricao_aluno(java.util.Set value) {
		this.ORM_inscricao_aluno = value;
	}
	
	private java.util.Set getORM_Inscricao_aluno() {
		return ORM_inscricao_aluno;
	}
	
	public final br.com.fes.scoa.model.Inscricao_alunoSetCollection inscricao_aluno = new br.com.fes.scoa.model.Inscricao_alunoSetCollection(this, _ormAdapter, ORMConstants.KEY_SITUACAO_INSCRICAO_ALUNO, ORMConstants.KEY_INSCRICAO_ALUNO_SITUACAO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
