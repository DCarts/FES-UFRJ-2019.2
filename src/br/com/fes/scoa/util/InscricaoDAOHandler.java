package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.List;

public class InscricaoDAOHandler {

    public static Inscricao_aluno cadastraInscricao_aluno(Aluno aluno, Turma turma) throws PersistentException {
        Inscricao_aluno inscricao = Inscricao_alunoDAO.createInscricao_aluno();

        inscricao.setAluno(aluno);
        inscricao.setTurma(turma);

        Inscricao_alunoDAO.save(inscricao);

        return inscricao;
    }


    public static void remover(List<Inscricao_aluno> lista) throws PersistentException {
        for (Inscricao_aluno aluno : lista) {
            Inscricao_alunoDAO.deleteAndDissociate(aluno);
        }
    }

    public static ObservableList<Inscricao_aluno> buscar(String text) throws PersistentException {

        Inscricao_alunoCriteria cc = new Inscricao_alunoCriteria();
        //@TODO incompleto/errado
        cc.add(Restrictions.ilike("nome", text, MatchMode.ANYWHERE));

        return FXCollections.observableArrayList(Inscricao_alunoDAO.listInscricao_alunoByCriteria(cc));
    }

    public static ObservableList<Inscricao_aluno> listar() throws PersistentException {
        return FXCollections.observableArrayList(Inscricao_alunoDAO.listInscricao_alunoByQuery(null,null));
    }
}
