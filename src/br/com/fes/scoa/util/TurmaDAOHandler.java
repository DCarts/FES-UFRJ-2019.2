package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import org.orm.PersistentException;

public class TurmaDAOHandler {

    public static Turma cadastraTurma(Disciplina disciplina, Professor professor) throws PersistentException {

        Turma turma = TurmaDAO.createTurma();

        turma.setDisciplina(disciplina);
        turma.setProfessor(professor);
        turma.setPeriodo("wololo"); //@TODO seta periodo

        TurmaDAO.save(turma);

        return turma;

    }

    public static void cadastraAlunoNaTurma(Turma turma, Aluno aluno){

        /* @TODO
        EntityManager em = Main.em;

        turma.setAluno(Arrays.asList(aluno));
        em.merge(turma);

        JPAUtil.commit(em);*/

    }
}
