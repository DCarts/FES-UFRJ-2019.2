package br.com.fes.scoa.util;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SalaDAO {

    public static Sala cadastraSala(String localizacao){

        Sala sala = new Sala(localizacao);

        EntityManager em = Main.em;

        em.persist(sala);

        JPAUtil.commit(em);

        return sala;
    }

    public static void alocaTurmaNaSala(Sala sala, Turma turma, TipoHoraDoDia hora){

        SalasTurmas alocacao = new SalasTurmas(sala, turma, hora);

        EntityManager em = Main.em;

        em.persist(alocacao);

        JPAUtil.commit(em);

    }

    public static void atualiza(Sala sala) {
        EntityManager em = Main.em;
        Session session = (Session) Main.em.getDelegate();
        session.saveOrUpdate(sala);

        JPAUtil.commit(em);
    }

    public static void remover(List<Sala> salas) {
        EntityManager em = Main.em;
        Session session = (Session) Main.em.getDelegate();
        for (Sala s : salas) {
            em.remove(s);
        }
        JPAUtil.commit(em);
    }

    public static ObservableList<Sala> buscar(String text) {
        EntityManager em = Main.em;
        Session session = (Session) Main.em.getDelegate();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sala> cr = em.getCriteriaBuilder().createQuery(Sala.class);
        Root<Sala> root = cr.from(Sala.class);
        cr.select(root).where(cb.like(root.get("codLocalizacao"), text));

        Query<Sala> query = session.createQuery(cr);
        return FXCollections.observableArrayList(query.getResultList());
    }

    public static ObservableList<Sala> listar() {
        EntityManager em = Main.em;
        Session session = (Session) Main.em.getDelegate();
        CriteriaQuery<Sala> cr = em.getCriteriaBuilder().createQuery(Sala.class);
        Root<Sala> root = cr.from(Sala.class);
        cr.select(root);

        Query<Sala> query = session.createQuery(cr);
        return FXCollections.observableArrayList(query.getResultList());
    }
}
