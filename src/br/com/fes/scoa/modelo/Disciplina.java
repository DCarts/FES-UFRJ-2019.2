package br.com.fes.scoa.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableStringValue;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@Column(length = 2555)
	private String descricao;

	@ManyToMany
	private List<Disciplina> disciplinasEquivalentes;

	@Transient
	private BooleanProperty checked = new SimpleBooleanProperty(false);

	public Disciplina(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		this.disciplinasEquivalentes = new ArrayList<Disciplina>();
	}

	public Disciplina() {}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public ObservableStringValue getNomeProperty() {
		return new SimpleStringProperty(nome);
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Disciplina> getDisciplinasEquivalentes() {
		return disciplinasEquivalentes;
	}

	public void setDisciplinasEquivalentes(List<Disciplina> disciplinasEquivalentes) {
		this.disciplinasEquivalentes.add(disciplinasEquivalentes.get(0));
	}

	@Transient
	public ObservableBooleanValue getChecked() {
		return checked;
	}

	@Transient
	public Boolean isChecked() {
		return getChecked().getValue();
	}

	@Transient
	public void setChecked(Boolean checked) {
		this.checked.set(checked);
	}
}
