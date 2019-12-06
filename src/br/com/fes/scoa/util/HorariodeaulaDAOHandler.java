package br.com.fes.scoa.util;

import br.com.fes.scoa.componente.CadastroSalaHorarioController.Dia;
import br.com.fes.scoa.model.Horariodeaula;
import br.com.fes.scoa.model.HorariodeaulaCriteria;
import br.com.fes.scoa.model.HorariodeaulaDAO;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class HorariodeaulaDAOHandler {

    public static Horariodeaula cadastraHorario(Dia dia, LocalTime horarioInicio, LocalTime horarioFim) throws PersistentException {

        HorariodeaulaCriteria hdac = new HorariodeaulaCriteria();
        hdac.add(Restrictions.and(Restrictions.eq("dia", dia.toString()),
                Restrictions.eq("horarioInicio", Time.valueOf(horarioInicio)),
                Restrictions.eq("horarioFim", Time.valueOf(horarioFim))));

        List<Horariodeaula> horarios = Arrays.asList(HorariodeaulaDAO.listHorariodeaulaByCriteria(hdac));

        Horariodeaula horario;
        if (horarios.isEmpty()) {
            horario = HorariodeaulaDAO.createHorariodeaula();

            horario.setDia(dia.toString());
            horario.setHorarioInicio(Time.valueOf(horarioInicio));
            horario.setHorarioFim(Time.valueOf(horarioFim));

            HorariodeaulaDAO.save(horario);
        }
        else {
            horario = horarios.get(0);
        }

        return horario;
    }

    public static String horarioToString(Horariodeaula h) {
        return h.getDia() + ", " + h.getHorarioInicio().toString() + " a " + h.getHorarioFim().toString() + ".";
    }
}
