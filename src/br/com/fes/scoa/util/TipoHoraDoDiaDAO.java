package br.com.fes.scoa.util;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.componente.CadastroHorarioController.Dia;
import br.com.fes.scoa.modelo.HorarioDeAula;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalTime;
import java.util.List;

public class TipoHoraDoDiaDAO {

    public static HorarioDeAula cadastraHorario(Dia dia, LocalTime horarioInicio, LocalTime horarioFim){

        EntityManager em = Main.em;
        Session session = (Session)em.getDelegate();

        CriteriaQuery<HorarioDeAula> query = em.getCriteriaBuilder().createQuery(HorarioDeAula.class);
        Root<HorarioDeAula> root = query.from(HorarioDeAula.class);
        query.select(root).where(em.getCriteriaBuilder().equal(root.get("dia"), dia));
        query.select(root).where(em.getCriteriaBuilder().equal(root.get("horarioInicio"), horarioInicio));
        query.select(root).where(em.getCriteriaBuilder().equal(root.get("horarioFim"), horarioFim));
        Query<HorarioDeAula> q = session.createQuery(query);
        List<HorarioDeAula> horarios = q.getResultList();

        HorarioDeAula horario;
        if (horarios.isEmpty()) {
            horario = new HorarioDeAula(dia, horarioInicio, horarioFim);
            em.persist(horario);
            JPAUtil.commit(em);
        }
        else {
            horario = horarios.get(0);
        }

        return horario;
    }
}
