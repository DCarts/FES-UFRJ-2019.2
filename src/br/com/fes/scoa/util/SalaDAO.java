package br.com.fes.scoa.util;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.modelo.Sala;
import br.com.fes.scoa.modelo.SalasTurmas;
import br.com.fes.scoa.modelo.TipoHoraDoDia;
import br.com.fes.scoa.modelo.Turma;

import javax.persistence.EntityManager;

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



    public static Sala editarSala(
            Integer id,
            String localizacao
    ) {

        EntityManager em = Main.em;
        Sala sala = em.find(Sala.class, id);
        if (!sala.getCodLocalizacao().equals(localizacao))
            sala.setCodLocalizacao(localizacao);
        JPAUtil.commit(em);

        return sala;
    }
}
