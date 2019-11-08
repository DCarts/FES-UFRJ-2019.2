package br.com.fes.scoa.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

}
