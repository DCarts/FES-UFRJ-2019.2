package br.com.fes.scoa.util;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.modelo.Disciplina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import java.util.Arrays;

public class DisciplinaDAO {
	public static void remover(List<Disciplina> disciplinas) {
		EntityManager em = Main.em;

		String jpql = "DELETE FROM Disciplina p WHERE p IN (:disciplinas)";
		Query query = em.createQuery(jpql);
		query.setParameter("disciplinas", disciplinas);
		int result = query.executeUpdate();
		if (result > 0) {
			System.out.println("Removidos:");
			disciplinas.forEach(System.out::println);
		}

		JPAUtil.commit(em);
	}

	public static ObservableList<Disciplina> listar() {
		EntityManager em = Main.em;
		String jpql = "SELECT DISTINCT p FROM Disciplina p";
		Query query = em.createQuery(jpql);
		List<Disciplina> resultado = (List<Disciplina>) query.setMaxResults(10).getResultList();
		System.out.println("Lista:");
		resultado.forEach(System.out::println);
		ObservableList<Disciplina> lista = FXCollections.observableArrayList(resultado);

		JPAUtil.commit(em);
		return lista;
	}

	public static Disciplina cadastrar(String nome, String descricao) {

		Disciplina disciplina = new Disciplina(nome, descricao);

		EntityManager em = Main.em;

		em.persist(disciplina);

		JPAUtil.commit(em);

		return disciplina;
	}

	public static ObservableList<Disciplina> buscar(String str) {
		String busca = "%"+str.trim().toLowerCase()+"%";
		EntityManager em = Main.em;
		String jpql = "SELECT DISTINCT p FROM Disciplina p WHERE LOWER(p.nome) LIKE :busca OR LOWER(p.descricao) LIKE :busca";
		Query query = em.createQuery(jpql);
		query.setParameter("busca", busca);
		List<Disciplina> resultado = (List<Disciplina>) query.setMaxResults(10).getResultList();
		System.out.println("Lista:");
		resultado.forEach(System.out::println);
		ObservableList<Disciplina> lista = FXCollections.observableArrayList(resultado);

		JPAUtil.commit(em);
		return lista;
	}

	public static Disciplina editar(Integer id, String nome, String descricao) {

		EntityManager em = Main.em;
		System.out.println("nome: " + nome);
		Disciplina disciplina = em.find(Disciplina.class, id);
		if (!disciplina.getNome().equals(nome))
			disciplina.setNome(nome);
		if (!disciplina.getDescricao().equals(descricao))
			disciplina.setDescricao(descricao);
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
