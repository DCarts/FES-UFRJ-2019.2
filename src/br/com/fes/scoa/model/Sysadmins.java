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

public class Sysadmins {
	public Sysadmins() {
	}
	
	private br.com.fes.scoa.model.Pessoa pessoa;
	
	private int pessoaId;
	
	private void setPessoaId(int value) {
		this.pessoaId = value;
	}
	
	public int getPessoaId() {
		return pessoaId;
	}
	
	public void setPessoa(br.com.fes.scoa.model.Pessoa value) {
		if (this.pessoa != value) {
			br.com.fes.scoa.model.Pessoa lpessoa = this.pessoa;
			this.pessoa = value;
			if (value != null) {
				pessoa.setSysadmins(this);
			}
			if (lpessoa != null && lpessoa.getSysadmins() == this) {
				lpessoa.setSysadmins(null);
			}
		}
	}
	
	public br.com.fes.scoa.model.Pessoa getPessoa() {
		return pessoa;
	}
	
	public br.com.fes.scoa.model.Pessoa getORMID() {
		return getPessoa();
	}
	
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
