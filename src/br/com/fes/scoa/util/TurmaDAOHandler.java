package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import org.orm.PersistentException;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAOHandler {

    public static Turma cadastraTurma(Disciplina disciplina, Professor professor, String periodo, List<AbstractMap.SimpleEntry<Sala,Horariodeaula>> horarios) throws PersistentException {

        Turma turma = TurmaDAO.createTurma();

        turma.setDisciplina(disciplina);
        turma.setProfessor(professor);
        turma.setPeriodo(periodo);

        TurmaDAO.save(turma);
        List<Alocacao_sala_turma> ja_alocadas = new ArrayList<>();
        try {
            for (AbstractMap.SimpleEntry<Sala, Horariodeaula> se : horarios) {
                Alocacao_sala_turma ast = Alocacao_sala_turmaDAO.createAlocacao_sala_turma();
                ast.setSala(se.getKey());
                ast.setHora(se.getValue());
                ast.setTurma(turma);
                Alocacao_sala_turmaDAO.save(ast);
                ja_alocadas.add(ast);
            }
        } catch (PersistentException e) {
            TurmaDAO.deleteAndDissociate(turma);
            for (Alocacao_sala_turma ja_alocada : ja_alocadas) {
                Alocacao_sala_turmaDAO.deleteAndDissociate(ja_alocada);
            }
            throw new PersistentException(e);
        }

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
