package br.com.fes.scoa.util;

import javax.persistence.EntityManager;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.modelo.*;

import java.util.Arrays;

public class TurmaDAO {

    public static Turma cadastraTurma(Disciplina disciplina, Professor professor) {

        Turma turma = new Turma(disciplina, professor);

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

}
