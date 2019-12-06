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
public class Inscricao_aluno implements Serializable {
	public Inscricao_aluno() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Inscricao_aluno))
			return false;
		Inscricao_aluno inscricao_aluno = (Inscricao_aluno)aObj;
		if (getTurma() == null) {
			if (inscricao_aluno.getTurma() != null)
				return false;
		}
		else if (!getTurma().equals(inscricao_aluno.getTurma()))
			return false;
		if (getAluno() == null) {
			if (inscricao_aluno.getAluno() != null)
				return false;
		}
		else if (!getAluno().equals(inscricao_aluno.getAluno()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getTurma() != null) {
			hashcode = hashcode + (int) getTurma().getORMID();
		}
		if (getAluno() != null) {
			hashcode = hashcode + (getAluno().getORMID() == null ? 0 : getAluno().getORMID().hashCode());
		}
		return hashcode;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_INSCRICAO_ALUNO_TURMA) {
			this.turma = (br.com.fes.scoa.model.Turma) owner;
		}
		
		else if (key == ORMConstants.KEY_INSCRICAO_ALUNO_ALUNO) {
			this.aluno = (br.com.fes.scoa.model.Aluno) owner;
		}
		
		else if (key == ORMConstants.KEY_INSCRICAO_ALUNO_SITUACAO) {
			this.situacao = (br.com.fes.scoa.model.Situacao) owner;
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
	
	private br.com.fes.scoa.model.Aluno aluno;
	
	private br.com.fes.scoa.model.Pessoa alunoId;
	
	private int alunoIdId;
	
	private void setAlunoIdId(int value) {
		this.alunoIdId = value;
	}
	
	public int getAlunoIdId() {
		return alunoIdId;
	}
	
	private void setAlunoId(br.com.fes.scoa.model.Pessoa value) {
		this.alunoId = value;
	}
	
	public br.com.fes.scoa.model.Pessoa getAlunoId() {
		return alunoId;
	}
	
	private java.math.BigDecimal nota;
	
	private java.math.BigDecimal frequencia;
	
	private br.com.fes.scoa.model.Situacao situacao;
	
	public void setNota(java.math.BigDecimal value) {
		this.nota = value;
	}
	
	public java.math.BigDecimal getNota() {
		return nota;
	}
	
	public void setFrequencia(java.math.BigDecimal value) {
		this.frequencia = value;
	}
	
	public java.math.BigDecimal getFrequencia() {
		return frequencia;
	}
	
	public void setTurma(br.com.fes.scoa.model.Turma value) {
		if (turma != null) {
			turma.inscricao_aluno.remove(this);
		}
		if (value != null) {
			value.inscricao_aluno.add(this);
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
	
	public void setAluno(br.com.fes.scoa.model.Aluno value) {
		if (aluno != null) {
			aluno.inscricao_aluno.remove(this);
		}
		if (value != null) {
			value.inscricao_aluno.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Aluno getAluno() {
		return aluno;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Aluno(br.com.fes.scoa.model.Aluno value) {
		this.aluno = value;
	}
	
	private br.com.fes.scoa.model.Aluno getORM_Aluno() {
		return aluno;
	}
	
	public void setSituacao(br.com.fes.scoa.model.Situacao value) {
		if (situacao != null) {
			situacao.inscricao_aluno.remove(this);
		}
		if (value != null) {
			value.inscricao_aluno.add(this);
		}
	}
	
	public br.com.fes.scoa.model.Situacao getSituacao() {
		return situacao;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Situacao(br.com.fes.scoa.model.Situacao value) {
		this.situacao = value;
	}
	
	private br.com.fes.scoa.model.Situacao getORM_Situacao() {
		return situacao;
	}
	
	public String toString() {
		return String.valueOf(((getTurma() == null) ? "" : String.valueOf(getTurma().getORMID())) + " " + ((getAluno() == null) ? "" : String.valueOf(getAluno().getORMID())));
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
