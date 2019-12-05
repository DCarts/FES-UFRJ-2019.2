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

public class Sala {
	public Sala() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_SALA_ALOCACAO_SALA_TURMA) {
			return ORM_alocacao_sala_turma;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String codLocalizacao;
	
	private java.util.Set ORM_alocacao_sala_turma = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setCodLocalizacao(String value) {
		this.codLocalizacao = value;
	}
	
	public String getCodLocalizacao() {
		return codLocalizacao;
	}
	
	private void setORM_Alocacao_sala_turma(java.util.Set value) {
		this.ORM_alocacao_sala_turma = value;
	}
	
	private java.util.Set getORM_Alocacao_sala_turma() {
		return ORM_alocacao_sala_turma;
	}
	
	public final br.com.fes.scoa.model.Alocacao_sala_turmaSetCollection alocacao_sala_turma = new br.com.fes.scoa.model.Alocacao_sala_turmaSetCollection(this, _ormAdapter, ORMConstants.KEY_SALA_ALOCACAO_SALA_TURMA, ORMConstants.KEY_ALOCACAO_SALA_TURMA_SALA, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
