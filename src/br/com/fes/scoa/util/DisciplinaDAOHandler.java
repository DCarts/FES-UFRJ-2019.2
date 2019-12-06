package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.List;

public class DisciplinaDAOHandler {
	
	public static Disciplina cadastraDisciplina(String nome, String codigo, String creditos, String descricao, Area_disciplina area, Curso curso) throws PersistentException {
		Disciplina disciplina = DisciplinaDAO.createDisciplina();

		disciplina.setNome(nome);
		disciplina.setCodigo(nome);
		disciplina.setCreditos(Integer.parseInt(creditos));
		disciplina.setDescricao(descricao);
		disciplina.setArea_disciplina(area);
		disciplina.setCurso(curso);

		DisciplinaDAO.save(disciplina);
		
		return disciplina;
	}

	public static void remover(List<Disciplina> lista) throws PersistentException {
		for (Disciplina disciplina : lista) {
			DisciplinaDAO.deleteAndDissociate(disciplina);
		}
	}

	public static ObservableList<Disciplina> buscar(String text) throws PersistentException {

		DisciplinaCriteria dc = new DisciplinaCriteria();
		dc.add(Restrictions.or(Restrictions.ilike("nome", text, MatchMode.ANYWHERE), Restrictions.ilike("descricao", text, MatchMode.ANYWHERE)));

		return FXCollections.observableArrayList(DisciplinaDAO.listDisciplinaByCriteria(dc));
	}

	public static ObservableList<Disciplina> listar() throws PersistentException {
		return FXCollections.observableArrayList(DisciplinaDAO.listDisciplinaByQuery(null,null));
	}

    public static void equivalenciaDisciplinas(Disciplina disciplina1, Disciplina disciplina2) {
        //@TODO implementar
    }
}
