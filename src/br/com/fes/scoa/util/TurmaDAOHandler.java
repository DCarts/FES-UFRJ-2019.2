package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static ObservableList<String> periodosProfessor(Professor p) throws PersistentException {

        TurmaCriteria tc = new TurmaCriteria();
        ProfessorCriteria pc = tc.createProfessorCriteria();
        pc.add(Restrictions.idEq(p.getPessoaId()));

        return FXCollections.observableArrayList(Stream.of(TurmaDAO.listTurmaByCriteria(tc)).map(Turma::getPeriodo).distinct().collect(Collectors.toList()));
    }

    public static ObservableList<Turma> turmasPeriodo(String periodo) throws PersistentException {

        TurmaCriteria tc = new TurmaCriteria();
        tc.add(Restrictions.eq("periodo", periodo));

        return FXCollections.observableArrayList(Stream.of(TurmaDAO.listTurmaByCriteria(tc)).collect(Collectors.toList()));
    }

    public static ObservableList<Turma> turmasProfessorPeriodo(Professor p, String periodo) throws PersistentException {

        TurmaCriteria tc = new TurmaCriteria();
        tc.add(Restrictions.eq("periodo", periodo));
        ProfessorCriteria pc = tc.createProfessorCriteria();
        pc.add(Restrictions.idEq(p.getPessoaId()));

        return FXCollections.observableArrayList(Stream.of(TurmaDAO.listTurmaByCriteria(tc)).collect(Collectors.toList()));
    }

    public static ObservableList<String> periodosAluno(Aluno a) throws PersistentException {

        TurmaCriteria tc = new TurmaCriteria();
        Inscricao_alunoCriteria iac = tc.createInscricao_alunoCriteria();
        AlunoCriteria ac = iac.createAlunoCriteria();
        ac.add(Restrictions.idEq(a.getPessoaId()));

        return FXCollections.observableArrayList(Stream.of(TurmaDAO.listTurmaByCriteria(tc)).map(Turma::getPeriodo).distinct().collect(Collectors.toList()));
    }

    public static ObservableList<Turma> turmasAlunoPeriodo(Aluno a, String periodo) throws PersistentException {

        TurmaCriteria tc = new TurmaCriteria();
        tc.add(Restrictions.eq("periodo", periodo));
        Inscricao_alunoCriteria iac = tc.createInscricao_alunoCriteria();
        AlunoCriteria ac = iac.createAlunoCriteria();
        ac.add(Restrictions.idEq(a.getPessoaId()));

        return FXCollections.observableArrayList(Stream.of(TurmaDAO.listTurmaByCriteria(tc)).collect(Collectors.toList()));
    }
}
