package br.com.fes.scoa.util;

import br.com.fes.scoa.model.Area_disciplina;
import br.com.fes.scoa.model.Area_disciplinaCriteria;
import br.com.fes.scoa.model.Area_disciplinaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.List;

public class AreaDAOHandler {
	
	public static Area_disciplina cadastraArea_disciplina(String nome, String descricao) throws PersistentException {
		Area_disciplina curso = Area_disciplinaDAO.createArea_disciplina();

		curso.setNome(nome);
		curso.setDescricao(descricao);

		Area_disciplinaDAO.save(curso);
		
		return curso;
	}


	public static void remover(List<Area_disciplina> lista) throws PersistentException {
		for (Area_disciplina aluno : lista) {
			Area_disciplinaDAO.deleteAndDissociate(aluno);
		}
	}

	public static ObservableList<Area_disciplina> buscar(String text) throws PersistentException {

		Area_disciplinaCriteria cc = new Area_disciplinaCriteria();
		cc.add(Restrictions.or(Restrictions.ilike("nome", text, MatchMode.ANYWHERE), Restrictions.ilike("descricao", text, MatchMode.ANYWHERE)));

		return FXCollections.observableArrayList(Area_disciplinaDAO.listArea_disciplinaByCriteria(cc));
	}

	public static ObservableList<Area_disciplina> listar() throws PersistentException {
		return FXCollections.observableArrayList(Area_disciplinaDAO.listArea_disciplinaByQuery(null,null));
	}
}
