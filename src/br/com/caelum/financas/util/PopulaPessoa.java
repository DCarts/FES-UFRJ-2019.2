package br.com.caelum.financas.util;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Aluno;
import br.com.caelum.financas.modelo.Disciplina;
import br.com.caelum.financas.modelo.Pessoa;
import br.com.caelum.financas.modelo.Professor;
import br.com.caelum.financas.util.JPAUtil;

public class PopulaPessoa {
	
	public static void main(String[] args) {
		
		java.time.LocalDate data = LocalDate.of(1990, 10, 23);
		
		Cadastro.cadastraProfessor("Aluna", data, "1197814987", "UFRJ Fundao", "lidioproffes@ufrj.br");
		//Cadastro.cadastraDisciplina("Fundamentos da Engenharia de Software", "Aprenda os processos de desenvolvimento de softwares utilizando UML e Scrum");
		//("Aluno Novo", "1977-12-04", "22987847987", "UFRJ Fundao", "lidioproffes@ufrj.br")
		
	}

}
