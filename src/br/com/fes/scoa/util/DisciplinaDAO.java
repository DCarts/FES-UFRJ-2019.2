package br.com.fes.scoa.util;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.modelo.Disciplina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class DisciplinaDAO {
	
	public static Disciplina cadastraDisciplina(String nome, String descricao) {
		
		Disciplina disciplina = new Disciplina(nome, descricao);
		
		EntityManager em = Main.em;
		
		em.persist(disciplina);
		
		JPAUtil.commit(em);
		
		return disciplina;
	}

	public static void atualiza(Disciplina disciplina) {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		session.saveOrUpdate(disciplina);

		JPAUtil.commit(em);
	}

	public static void remover(List<Disciplina> disciplinas) {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		for (Disciplina d : disciplinas) {
			em.remove(d);
		}
		JPAUtil.commit(em);
	}

	public static ObservableList<Disciplina> buscar(String text) {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Disciplina> cr = em.getCriteriaBuilder().createQuery(Disciplina.class);
		Root<Disciplina> root = cr.from(Disciplina.class);
		cr.select(root).where(cb.or(cb.like(root.get("nome"), text), cb.like(root.get("descricao"), text)));

		Query<Disciplina> query = session.createQuery(cr);
		return FXCollections.observableArrayList(query.getResultList());
	}

	public static ObservableList<Disciplina> listar() {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		CriteriaQuery<Disciplina> cr = em.getCriteriaBuilder().createQuery(Disciplina.class);
		Root<Disciplina> root = cr.from(Disciplina.class);
		cr.select(root);

		Query<Disciplina> query = session.createQuery(cr);
		return FXCollections.observableArrayList(query.getResultList());
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
