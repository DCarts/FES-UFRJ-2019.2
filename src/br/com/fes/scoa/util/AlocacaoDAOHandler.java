package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlocacaoDAOHandler {

    public static ObservableList<Alocacao_sala_turma> getHorariosOf(Turma t ) throws PersistentException {
        Alocacao_sala_turmaCriteria astc = new Alocacao_sala_turmaCriteria();

        TurmaCriteria tc = astc.createTurmaCriteria();

        tc.add(Restrictions.idEq(t.getId()));

        List<Alocacao_sala_turma> result = Arrays.asList(Alocacao_sala_turmaDAO.listAlocacao_sala_turmaByCriteria(astc));
        return FXCollections.observableArrayList(result);
    }

    public static ObservableList<Horariodeaula> getHorariosOf(Professor p, String periodo) throws PersistentException {
        Alocacao_sala_turmaCriteria astc = new Alocacao_sala_turmaCriteria();

        TurmaCriteria tc = astc.createTurmaCriteria();
        tc.add(Restrictions.eq("periodo", periodo));

        ProfessorCriteria pc = tc.createProfessorCriteria();
        pc.add(Restrictions.idEq(p.getPessoaId()));

        List<Alocacao_sala_turma> result = Arrays.asList(Alocacao_sala_turmaDAO.listAlocacao_sala_turmaByCriteria(astc));
        return FXCollections.observableArrayList(result.stream().map(ast -> ast.getHora()).collect(Collectors.toList()));
    }

    public static ObservableList<Horariodeaula> getHorariosOf(Sala s, String periodo ) throws PersistentException {
        Alocacao_sala_turmaCriteria astc = new Alocacao_sala_turmaCriteria();

        TurmaCriteria tc = astc.createTurmaCriteria();
        tc.add(Restrictions.eq("periodo", periodo));

        SalaCriteria sc = astc.createSalaCriteria();
        sc.add(Restrictions.idEq(s.getId()));

        List<Alocacao_sala_turma> result = Arrays.asList(Alocacao_sala_turmaDAO.listAlocacao_sala_turmaByCriteria(astc));
        return FXCollections.observableArrayList(result.stream().map(ast -> ast.getHora()).collect(Collectors.toList()));
    }
}
