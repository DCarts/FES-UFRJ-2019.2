package br.com.fes.scoa.util;

import javax.persistence.EntityManager;

import br.com.fes.scoa.modelo.*;

public class TurmaDAO {

    public static Turma cadastraTurma(Disciplina disciplina, Professor professor) {

        Turma turma = new Turma(disciplina, professor);

        EntityManager em = JPAUtil.abreConexao();

        em.persist(turma);

        JPAUtil.commitEFechaConexao(em);

        return turma;

    }

    public static void cadastraAlunoNaTurma(Turma turma, Pessoa pessoa){

        TurmasAlunos tAlunos = new TurmasAlunos(turma, pessoa);

        EntityManager em = JPAUtil.abreConexao();

        em.persist(tAlunos);

        JPAUtil.commitEFechaConexao(em);

    }

}
