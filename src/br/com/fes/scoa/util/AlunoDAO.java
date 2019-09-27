package br.com.fes.scoa.util;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fes.scoa.modelo.Aluno;
import br.com.fes.scoa.modelo.Pessoa;

public class AlunoDAO {
	
	public static void cadastraAluno(String nome, String str_data_nascimento, String cpf, String endereco, String email) {
		
		LocalDate data_nascimento = LocalDate.parse(str_data_nascimento);
		
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

}
