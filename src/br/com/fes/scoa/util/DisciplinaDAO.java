package br.com.fes.scoa.util;

import javax.persistence.EntityManager;

import br.com.fes.scoa.modelo.Disciplina;

public class DisciplinaDAO {
	
	public static void cadastraDisciplina(String nome, String descricao) {
		
		Disciplina disciplina = new Disciplina(nome, descricao);
		
		EntityManager em = JPAUtil.abreConexao();
		
		em.persist(disciplina);
		
		JPAUtil.commit(em);
		
		
	}

}
