package br.com.fes.scoa.util;

import br.com.fes.scoa.model.Curso;
import br.com.fes.scoa.model.CursoCriteria;
import br.com.fes.scoa.model.CursoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.List;

public class CursoDAOHandler {
	
	public static Curso cadastraCurso(String nome, String descricao) throws PersistentException {
		Curso curso = CursoDAO.createCurso();

		curso.setNome(nome);
		curso.setDescricao(descricao);

		CursoDAO.save(curso);
		
		return curso;
	}


	public static void remover(List<Curso> lista) throws PersistentException {
		for (Curso aluno : lista) {
			CursoDAO.deleteAndDissociate(aluno);
		}
	}

	public static ObservableList<Curso> buscar(String text) throws PersistentException {

		CursoCriteria cc = new CursoCriteria();
		cc.add(Restrictions.or(Restrictions.ilike("nome", text, MatchMode.ANYWHERE), Restrictions.ilike("descricao", text, MatchMode.ANYWHERE)));

		return FXCollections.observableArrayList(CursoDAO.listCursoByCriteria(cc));
	}

	public static ObservableList<Curso> listar() throws PersistentException {
		return FXCollections.observableArrayList(CursoDAO.listCursoByQuery(null,null));
	}
}
