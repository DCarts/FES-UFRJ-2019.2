package br.com.fes.scoa.util;

import javax.persistence.EntityManager;

import br.com.fes.scoa.modelo.Disciplina;

import java.util.Arrays;

public class DisciplinaDAO {
	
	public static Disciplina cadastraDisciplina(String nome, String descricao) {
		
		Disciplina disciplina = new Disciplina(nome, descricao);
		
		EntityManager em = JPAUtil.abreConexao();
		
		em.persist(disciplina);
		
		JPAUtil.commit(em);
		
		return disciplina;
	}

	public static void equivalenciaDisciplinas(Disciplina disciplina1, Disciplina disciplina2){


		EntityManager em = JPAUtil.abreConexao();

		disciplina1.setDisciplinasEquivalentes(Arrays.asList(disciplina2));
		disciplina2.setDisciplinasEquivalentes(Arrays.asList(disciplina1));

		em.merge(disciplina1);
		em.merge(disciplina2);

		JPAUtil.commit(em);

	}

}
