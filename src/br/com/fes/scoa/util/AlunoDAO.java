package br.com.fes.scoa.util;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fes.scoa.modelo.Aluno;
import br.com.fes.scoa.modelo.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoDAO {
	public static void remover(List<Pessoa> pessoas) {
		EntityManager em = JPAUtil.abreConexao();

		String jpql = "delete from Pessoa p where p in (:pessoas)";
		Query query = em.createQuery(jpql);
		query.setParameter("pessoas", pessoas);
		int result = query.executeUpdate();
		if (result > 0 ) {
			System.out.println("Removidos:");
			pessoas.forEach(System.out::println);
		}

		JPAUtil.commitEFechaConexao(em);
	}

	public static ObservableList<Pessoa> listar() {
		EntityManager em = JPAUtil.abreConexao();
		String jpql = "select DISTINCT p from Pessoa p inner join Aluno a ON a.pessoa = p";
		Query query = em.createQuery(jpql);
		List<Pessoa> resultado = (List<Pessoa>) query.getResultList();
		System.out.println("Lista:");
		resultado.forEach(System.out::println);
		ObservableList<Pessoa> lista = FXCollections.observableArrayList(resultado);

		JPAUtil.commitEFechaConexao(em);
		return lista;
	}

	public static Aluno cadastraAluno(String nome, String str_data_nascimento, String cpf, String endereco, String email) {

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
				// @TODO reportar isso ao usuário de alguma forma quando ele tenta cadastrar um aluno que ja esta cadastrado

				System.out.println(resultado2.get(0).getPessoa().getNome() + " ja esta cadastrado(a) como aluno(a)\n CPF: " +
						resultado2.get(0).getPessoa().getCpf());
			}

		}

		JPAUtil.commitEFechaConexao(em);

		return aluno;
	}

}
