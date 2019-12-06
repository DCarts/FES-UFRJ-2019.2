package br.com.fes.scoa.util;

import br.com.fes.scoa.model.Situacao;
import br.com.fes.scoa.model.SituacaoCriteria;
import br.com.fes.scoa.model.SituacaoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.List;

public class SituacaoDAOHandler {
	
	public static Situacao cadastraSituacao(String nome) throws PersistentException {
		Situacao situacao = SituacaoDAO.createSituacao();

		situacao.setNome(nome);

		SituacaoDAO.save(situacao);
		
		return situacao;
	}


	public static void remover(List<Situacao> lista) throws PersistentException {
		for (Situacao aluno : lista) {
			SituacaoDAO.deleteAndDissociate(aluno);
		}
	}

	public static ObservableList<Situacao> buscar(String text) throws PersistentException {

		SituacaoCriteria cc = new SituacaoCriteria();
		cc.add(Restrictions.ilike("nome", text, MatchMode.ANYWHERE));

		return FXCollections.observableArrayList(SituacaoDAO.listSituacaoByCriteria(cc));
	}

	public static ObservableList<Situacao> listar() throws PersistentException {
		return FXCollections.observableArrayList(SituacaoDAO.listSituacaoByQuery(null,null));
	}
}
