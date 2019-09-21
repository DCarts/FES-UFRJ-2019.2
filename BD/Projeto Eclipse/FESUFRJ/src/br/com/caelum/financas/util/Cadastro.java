package br.com.caelum.financas.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Aluno;
import br.com.caelum.financas.modelo.Disciplina;
import br.com.caelum.financas.modelo.Pessoa;
import br.com.caelum.financas.modelo.Professor;

public class Cadastro {
	
	public static void cadastraAluno(String nome, String data_nascimento, String cpf, String endereco, String email) {
		
		Pessoa pessoa = new Pessoa(nome, data_nascimento, cpf, endereco, email);
		Aluno aluno = new Aluno(pessoa);
		
		
		EntityManager em = JPAUtil.abreConexao();
		
		String jpql = "select p from Pessoa p where p.cpf = :pCPF";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCPF", cpf);
		
		List<Pessoa> resultado = (List<Pessoa>) query.getResultList();
		
		if(resultado.isEmpty()) {
		
			em.persist(pessoa);
			em.persist(aluno);
		}
		else {
			
			String jpql2 = "select a from Aluno a where a.pessoa = :pPessoa";
			Query query2 = em.createQuery(jpql2);
			query2.setParameter("pPessoa", resultado.get(0));
			
			List<Aluno> resultado2 = (List<Aluno>) query2.getResultList();

			if(resultado2.isEmpty()) {
				aluno.setPessoa(resultado.get(0));
				em.persist(aluno);
			}
			else {
				System.out.println(resultado2.get(0).getPessoa().getNome() + " ja esta cadastrado(a) como aluno(a)\n CPF: " + 
						resultado2.get(0).getPessoa().getCpf());
			}
			
		}
		
		JPAUtil.commitEFechaConexao(em);
		
	}
	
	public static void cadastraProfessor(String nome, String data_nascimento, String cpf, String endereco, String email) {
		
		Pessoa pessoa = new Pessoa(nome, data_nascimento, cpf, endereco, email);
		Professor professor = new Professor(pessoa);
		
		EntityManager em = JPAUtil.abreConexao();
		
		String jpql = "select p from Pessoa p where p.cpf = :pCPF";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCPF", cpf);
		
		List<Pessoa> resultado = (List<Pessoa>) query.getResultList();
		
		if(resultado.isEmpty()) {
		
			em.persist(pessoa);
			em.persist(professor);
		}
		else {
			
			String jpql2 = "select a from Professor a where a.pessoa = :pPessoa";
			Query query2 = em.createQuery(jpql2);
			query2.setParameter("pPessoa", resultado.get(0));
			
			List<Professor> resultado2 = (List<Professor>) query2.getResultList();

			if(resultado2.isEmpty()) {
				professor.setPessoa(resultado.get(0));
				em.persist(professor);
			}
			else {
				System.out.println(resultado2.get(0).getPessoa().getNome() + " ja esta cadastrado(a) como professor(a)\n CPF: " + 
						resultado2.get(0).getPessoa().getCpf());
			}
			
		}
		
		JPAUtil.commitEFechaConexao(em);
		
		
	}
	
	public static void cadastraDisciplina(String nome, String descricao) {
		
		Disciplina disciplina = new Disciplina(nome, descricao);
		
		EntityManager em = JPAUtil.abreConexao();
		
		em.persist(disciplina);
		
		JPAUtil.commitEFechaConexao(em);
		
		
	}

}
