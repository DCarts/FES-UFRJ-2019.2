package br.com.fes.scoa.util;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.modelo.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class TurmaDAO {

    public static Turma cadastraTurma(Disciplina disciplina, Professor professor, Sala sala, List<HorarioDeAula> horarios) {

        Turma turma = new Turma(disciplina, professor, sala, horarios);

        EntityManager em = Main.em;

        em.persist(turma);

        JPAUtil.commit(em);

        return turma;

    }

    public static void cadastraAlunoNaTurma(Turma turma, Aluno aluno){



        EntityManager em = Main.em;

        turma.setAluno(Arrays.asList(aluno));
        em.merge(turma);

        JPAUtil.commit(em);

    }

    public static boolean haConflitos(Pessoa professor, List<HorarioDeAula> horarios) {
/*
        EntityManager em = Main.em;
        Session session = (Session)em.getDelegate();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<HorarioDeAula> query = cb.createQuery(HorarioDeAula.class);
        Root<HorarioDeAula> root = query.from(HorarioDeAula.class);
        query.select(root).where(cb.and(cb.equal(root.get("dia"), dia),
                cb.equal(root.get("horarioInicio"), horarioInicio),
                cb.equal(root.get("horarioFim"), horarioFim)));
        Query<HorarioDeAula> q = session.createQuery(query);
        List<HorarioDeAula> horarios = q.getResultList();*/
        return false;
    }

    public static boolean haConflitos(Disciplina disciplina, List<HorarioDeAula> horarios) {
/*
        EntityManager em = Main.em;
        Session session = (Session)em.getDelegate();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<HorarioDeAula> query = cb.createQuery(HorarioDeAula.class);
        Root<HorarioDeAula> root = query.from(HorarioDeAula.class);
        query.select(root).where(cb.and(cb.equal(root.get("dia"), dia),
                cb.equal(root.get("horarioInicio"), horarioInicio),
                cb.equal(root.get("horarioFim"), horarioFim)));
        Query<HorarioDeAula> q = session.createQuery(query);
        List<HorarioDeAula> horarios = q.getResultList();*/
        return false;
    }

    public static boolean haConflitos(Sala sala, List<HorarioDeAula> horarios) {
/*
        EntityManager em = Main.em;
        Session session = (Session)em.getDelegate();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Turma> query = cb.createQuery(Turma.class);

        Root<Turma> root = query.from(Turma.class);
        Join<Turma, HorarioDeAula> join = root.join("horario", JoinType.LEFT);
        query.multiselect(join).where(cb.equal(join.get("sala"), sala));

        Query<HorarioDeAula> q = session.createQuery(query);

        List<HorarioDeAula> horarios_p = q.getResultList();*/
        return false;
    }



    public static void atualiza(Turma turma) {
        EntityManager em = Main.em;
        Session session = (Session) Main.em.getDelegate();
        session.saveOrUpdate(turma);

        JPAUtil.commit(em);
    }
}
