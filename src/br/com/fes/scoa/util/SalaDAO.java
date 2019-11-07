package br.com.fes.scoa.util;

import br.com.fes.scoa.modelo.Sala;
import br.com.fes.scoa.modelo.SalasTurmas;
import br.com.fes.scoa.modelo.TipoHoraDoDia;
import br.com.fes.scoa.modelo.Turma;

import javax.persistence.EntityManager;

public class SalaDAO {

    public static Sala cadastraSala(String localizacao){

        Sala sala = new Sala(localizacao);

        EntityManager em = JPAUtil.abreConexao();

        em.persist(sala);

        JPAUtil.commitEFechaConexao(em);

        return sala;
    }

    public static void alocaTurmaNaSala(Sala sala, Turma turma, TipoHoraDoDia hora){

        SalasTurmas alocacao = new SalasTurmas(sala, turma, hora);

        EntityManager em = JPAUtil.abreConexao();

        em.persist(alocacao);

        JPAUtil.commitEFechaConexao(em);

    }

}
