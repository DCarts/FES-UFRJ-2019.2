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

import java.io.Serializable;
public class Alocacao_sala_turma implements Serializable {
	public Alocacao_sala_turma() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Alocacao_sala_turma))
			return false;
		Alocacao_sala_turma alocacao_sala_turma = (Alocacao_sala_turma)aObj;
		if (getTurma() == null) {
			if (alocacao_sala_turma.getTurma() != null)
				return false;
		}
		else if (!getTurma().equals(alocacao_sala_turma.getTurma()))
			return false;
		if (getSala() == null) {
			if (alocacao_sala_turma.getSala() != null)
				return false;
		}
		else if (!getSala().equals(alocacao_sala_turma.getSala()))
			return false;
		if (getHora() == null) {
			if (alocacao_sala_turma.getHora() != null)
				return false;
		}
		else if (!getHora().equals(alocacao_sala_turma.getHora()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getTurma() != null) {
			hashcode = hashcode + (int) getTurma().getORMID();
		}
		if (getSala() != null) {
			hashcode = hashcode + (int) getSala().getORMID();
		}
		if (getHora() != null) {
			hashcode = hashcode + (int) getHora().getORMID();
		}
		return hashcode;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ALOCACAO_SALA_TURMA_TURMA) {
			this.turma = (br.com.fes.scoa.model.Turma) owner;
		}
		
		else if (key == ORMConstants.KEY_ALOCACAO_SALA_TURMA_SALA) {
			this.sala = (br.com.fes.scoa.model.Sala) owner;
		}
		
		else if (key == ORMConstants.KEY_ALOCACAO_SALA_TURMA_HORA) {
			this.hora = (br.com.fes.scoa.model.Horariodeaula) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private br.com.fes.scoa.model.Turma turma;
	
	private int turmaId;
	
	private void setTurmaId(int value) {
		this.turmaId = value;
	}
	
	public int getTurmaId() {
		return turmaId;
	}
	
	private br.com.fes.scoa.model.Sala sala;
	
	private int salaId;
	
	private void setSalaId(int value) {
		this.salaId = value;
	}
	
	public int getSalaId() {
		return salaId;
	}
	
	private br.com.fes.scoa.model.Horariodeaula hora;
	
	private int horaId;
	
	private void setHoraId(int value) {
		this.horaId = value;
	}
	
	public int getHoraId() {
		return horaId;
	}
	
	public void setTurma(br.com.fes.scoa.model.Turma value) {
		if (turma != null) {
			turma.alocacao_sala_turma.remove(this);
		}
		if (value != null) {
			value.alocacao_sala_turma.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Turma getTurma() {
		return turma;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Turma(br.com.fes.scoa.model.Turma value) {
		this.turma = value;
	}
	
	private br.com.fes.scoa.model.Turma getORM_Turma() {
		return turma;
	}
	
	public void setSala(br.com.fes.scoa.model.Sala value) {
		if (sala != null) {
			sala.alocacao_sala_turma.remove(this);
		}
		if (value != null) {
			value.alocacao_sala_turma.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Sala getSala() {
		return sala;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Sala(br.com.fes.scoa.model.Sala value) {
		this.sala = value;
	}
	
	private br.com.fes.scoa.model.Sala getORM_Sala() {
		return sala;
	}
	
	public void setHora(br.com.fes.scoa.model.Horariodeaula value) {
		if (hora != null) {
			hora.alocacao_sala_turma.remove(this);
		}
		if (value != null) {
			value.alocacao_sala_turma.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Horariodeaula getHora() {
		return hora;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Hora(br.com.fes.scoa.model.Horariodeaula value) {
		this.hora = value;
	}
	
	private br.com.fes.scoa.model.Horariodeaula getORM_Hora() {
		return hora;
	}
	
	public String toString() {
		return String.valueOf(((getTurma() == null) ? "" : String.valueOf(getTurma().getORMID())) + " " + ((getSala() == null) ? "" : String.valueOf(getSala().getORMID())) + " " + ((getHora() == null) ? "" : String.valueOf(getHora().getORMID())));
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
