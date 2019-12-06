package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.*;

public class DisciplinaDAOHandler {
	
	public static Disciplina cadastraDisciplina(String nome, String codigo, String creditos, String descricao, Area_disciplina area, Curso curso, List<Disciplina> equivalencias) throws PersistentException {
		Disciplina disciplina = DisciplinaDAO.createDisciplina();

		disciplina.setNome(nome);
		disciplina.setCodigo(nome);
		disciplina.setCreditos(Integer.parseInt(creditos));
		disciplina.setDescricao(descricao);
		disciplina.setArea_disciplina(area);
		disciplina.setCurso(curso);
		equivalencias.forEach(disciplina.disciplina1::add);

		DisciplinaDAO.save(disciplina);
		
		return disciplina;
	}

	public static void remover(List<Disciplina> lista) throws PersistentException {
		for (Disciplina disciplina : lista) {
			DisciplinaDAO.deleteAndDissociate(disciplina);
		}
	}

	public static ObservableList<Disciplina> getEquivalentes(Disciplina d) throws PersistentException {

		List<Disciplina> disciplinas = new ArrayList<>();
		disciplinas.addAll(Arrays.asList(d.disciplina1.toArray()));
		disciplinas.addAll(Arrays.asList(d.disciplina2.toArray()));

		return FXCollections.observableArrayList(disciplinas);
	}

	public static ObservableList<Disciplina> buscar(String text) throws PersistentException {

		DisciplinaCriteria dc = new DisciplinaCriteria();
		dc.add(Restrictions.or(Restrictions.ilike("nome", text, MatchMode.ANYWHERE), Restrictions.ilike("descricao", text, MatchMode.ANYWHERE)));

		return FXCollections.observableArrayList(DisciplinaDAO.listDisciplinaByCriteria(dc));
	}

	public static ObservableList<Disciplina> listar() throws PersistentException {
		return FXCollections.observableArrayList(DisciplinaDAO.listDisciplinaByQuery(null,null));
	}
}
