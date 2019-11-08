package br.com.fes.scoa.util;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.modelo.Pessoa;
import br.com.fes.scoa.modelo.Professor;
import br.com.fes.scoa.modelo.SalasTurmas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfessorDAO {
	public static void remover(List<Pessoa> pessoas) {
		EntityManager em = Main.em;

		String jpql = "DELETE FROM Pessoa p WHERE p IN (:pessoas)";
		Query query = em.createQuery(jpql);
		query.setParameter("pessoas", pessoas);
		int result = query.executeUpdate();
		if (result > 0) {
			System.out.println("Removidos:");
			pessoas.forEach(System.out::println);
		}

		JPAUtil.commit(em);
	}

	public static ObservableList<Pessoa> listar() {
		EntityManager em = Main.em;
		String jpql = "SELECT DISTINCT p FROM Pessoa p INNER JOIN Professor a ON a.pessoa = p";
		Query query = em.createQuery(jpql);
		List<Pessoa> resultado = (List<Pessoa>) query.setMaxResults(10).getResultList();
		System.out.println("Lista:");
		resultado.forEach(System.out::println);
		ObservableList<Pessoa> lista = FXCollections.observableArrayList(resultado);

		JPAUtil.commit(em);
		return lista;
	}

	public static Professor cadastrar(String nome, String str_data_nascimento, String cpf, String endereco, String email) {

		LocalDate data_nascimento = LocalDate.parse(str_data_nascimento);

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
				// @TODO reportar isso ao usuário de alguma forma quando ele tenta cadastrar um professor que ja esta cadastrado
				System.out.println(resultado2.get(0).getPessoa().getNome() + " ja esta cadastrado(a) como professor(a)\n CPF: " +
						resultado2.get(0).getPessoa().getCpf());
			}

		}

		JPAUtil.commit(em);

		return professor;
	}

	public static ObservableList<Pessoa> buscar(String str) {
		String busca = "%"+str.trim().toLowerCase()+"%";
		EntityManager em = Main.em;
		String jpql = "SELECT DISTINCT p FROM Pessoa p INNER JOIN Professor a ON a.pessoa = p WHERE LOWER(p.nome) LIKE :busca OR LOWER(p.email) LIKE :busca OR LOWER(p.cpf) LIKE :busca";
		Query query = em.createQuery(jpql);
		query.setParameter("busca", busca);
		List<Pessoa> resultado = (List<Pessoa>) query.setMaxResults(10).getResultList();
		System.out.println("Lista:");
		resultado.forEach(System.out::println);
		ObservableList<Pessoa> lista = FXCollections.observableArrayList(resultado);

		JPAUtil.commit(em);
		return lista;
	}

	public static Professor editar(
			Integer id,
			String nome,
			String str_data_nascimento,
			String cpf,
			String endereco,
			String email
	) {
		LocalDate data_nascimento = LocalDate.parse(str_data_nascimento);

		EntityManager em = Main.em;
		System.out.println("cpf: " + cpf);
		Pessoa pessoa = em.find(Pessoa.class, id);
		if (!pessoa.getNome().equals(nome))
			pessoa.setNome(nome);
		if (!pessoa.getCpf().equals(cpf))
			pessoa.setCpf(cpf);
		if (!pessoa.getData_nascimento().equals(data_nascimento))
			pessoa.setData_nascimento(data_nascimento);
		if (!pessoa.getEmail().equals(email))
			pessoa.setEmail(email);
		if (!pessoa.getEndereco().equals(endereco))
			pessoa.setEndereco(endereco);
		JPAUtil.commit(em);
		Professor professor = new Professor(pessoa);

		return professor;
	}

	public static ObservableList<SalasTurmas> turmas(Pessoa pessoa) {
		EntityManager em = Main.em;
		Professor professor = new Professor(pessoa);
		String jpql = "select st from Turma t left join SalasTurmas st on st.turma = t where t.professor = :pessoa";
		Query query = em.createQuery(jpql);
		query.setParameter("pessoa", professor);
		List<SalasTurmas> resultado = (List<SalasTurmas>) query.setMaxResults(10).getResultList();
		System.out.println("Turmas:");
		resultado.forEach(r -> {System.out.println(r.getTurma().getDisciplina().getNome());});
		ObservableList<SalasTurmas> lista = FXCollections.observableArrayList(resultado);

		JPAUtil.commit(em);
		return lista;
	}

	public static ObservableList<SalasTurmas> buscarTurmas(String text) {
		return FXCollections.observableArrayList();
	}
}
