package br.com.fes.scoa.util;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.modelo.Pessoa;
import br.com.fes.scoa.modelo.Professor;
import br.com.fes.scoa.modelo.Sala;
import br.com.fes.scoa.modelo.SalasTurmas;
import br.com.fes.scoa.modelo.Turma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

public class ProfessorDAO {

	public static Professor fromPessoa(Pessoa pessoa) {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Professor> cr = em.getCriteriaBuilder().createQuery(Professor.class);
		Root<Professor> root = cr.from(Professor.class);
		cr.select(root).where(cb.equal(root.get("pessoa"), pessoa));
		
		org.hibernate.query.Query<Professor> query = session.createQuery(cr);
		return query.getSingleResult();
	}

public static Professor cadastraProfessor(String nome, String str_data_nascimento, String cpf, String endereco, String email) {

	LocalDate data_nascimento = LocalDate.parse(str_data_nascimento);

	Pessoa pessoa = new Pessoa(nome, data_nascimento, cpf, endereco, email);
	Professor professor = new Professor(pessoa);

	EntityManager em = Main.em;

	String jpql = "select p from Pessoa p where p.cpf = :pCPF";

	Query query = em.createQuery(jpql);
	query.setParameter("pCPF", cpf);

	List<Pessoa> resultado = (List<Pessoa>) query.getResultList();

	if (resultado.isEmpty()) {

		em.persist(pessoa);
		em.persist(professor);
	} else {

		String jpql2 = "select a from Professor a where a.pessoa = :pPessoa";
		Query query2 = em.createQuery(jpql2);
		query2.setParameter("pPessoa", resultado.get(0));

		List<Professor> resultado2 = (List<Professor>) query2.getResultList();

		if (resultado2.isEmpty()) {
			professor.setPessoa(resultado.get(0));
			em.persist(professor);
		} else {
			// @TODO reportar isso ao usuário de alguma forma quando ele tenta cadastrar um
			// aluno que ja esta cadastrado

			System.out.println(resultado2.get(0).getPessoa().getNome()
					+ " ja esta cadastrado(a) como professor(a)\n CPF: " + resultado2.get(0).getPessoa().getCpf());
		}

	}

	JPAUtil.commit(em);
	return professor;
	}

	public static void remover(List<Pessoa> pessoas) {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		for (Pessoa p : pessoas) {
			em.remove(p);
		}
		JPAUtil.commit(em);
	}

	public static void atualiza(Pessoa professor) {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		session.saveOrUpdate(professor);

		JPAUtil.commit(em);
	}

	public static ObservableList<Pessoa> buscar(String text) {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Professor> cr = em.getCriteriaBuilder().createQuery(Professor.class);
		Root<Professor> root = cr.from(Professor.class);
		cr.select(root).where(cb.like(root.get("codLocalizacao"), text));

		org.hibernate.query.Query<Professor> query = session.createQuery(cr);
		return FXCollections.observableArrayList(query.getResultList().stream().map(Professor::getPessoa).collect(Collectors.toList()));
	}

	public static ObservableList<Pessoa> listar() {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		CriteriaQuery<Professor> cr = em.getCriteriaBuilder().createQuery(Professor.class);
		Root<Professor> root = cr.from(Professor.class);
		cr.select(root);

		org.hibernate.query.Query<Professor> query = session.createQuery(cr);
		return FXCollections.observableArrayList(query.getResultList().stream().map(Professor::getPessoa).collect(Collectors.toList()));
	}

    public static ObservableList<Turma> turmas(Pessoa pessoa) {
    	EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Turma> cr = em.getCriteriaBuilder().createQuery(Turma.class);
		Root<Turma> root = cr.from(Turma.class);
		cr.select(root).where(cb.equal(root.get("professor"), ProfessorDAO.fromPessoa(pessoa)));

		org.hibernate.query.Query<Turma> query = session.createQuery(cr);
		ObservableList<Turma> lista = FXCollections.observableArrayList(query.getResultList());

        JPAUtil.commit(em);
        return lista;
    }

    public static ObservableList<Turma> buscarTurmas(String text) {
        return FXCollections.observableArrayList();
    }

}
