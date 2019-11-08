package br.com.fes.scoa.util;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.componente.CadastroHorarioController.Dia;
import br.com.fes.scoa.modelo.Sala;
import br.com.fes.scoa.modelo.SalasTurmas;
import br.com.fes.scoa.modelo.TipoHoraDoDia;
import br.com.fes.scoa.modelo.Turma;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalTime;
import java.util.List;

public class TipoHoraDoDiaDAO {

    public static TipoHoraDoDia cadastraHorario(Dia dia, LocalTime horarioInicio, LocalTime horarioFim){

        EntityManager em = Main.em;
        Session session = (Session)em.getDelegate();

        CriteriaQuery<TipoHoraDoDia> query = em.getCriteriaBuilder().createQuery(TipoHoraDoDia.class);
        Root<TipoHoraDoDia> root = query.from(TipoHoraDoDia.class);
        query.select(root).where(em.getCriteriaBuilder().equal(root.get("dia"), dia));
        query.select(root).where(em.getCriteriaBuilder().equal(root.get("horarioInicio"), horarioInicio));
        query.select(root).where(em.getCriteriaBuilder().equal(root.get("horarioFim"), horarioFim));
        Query<TipoHoraDoDia> q = session.createQuery(query);
        List<TipoHoraDoDia> horarios = q.getResultList();

        TipoHoraDoDia horario;
        if (horarios.isEmpty()) {
            horario = new TipoHoraDoDia(dia, horarioInicio, horarioFim);
            em.persist(horario);
            JPAUtil.commit(em);
        }
        else {
            horario = horarios.get(0);
        }

        return horario;
    }
}
