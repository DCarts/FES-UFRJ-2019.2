package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.util.List;

public class SalaDAOHandler {

    public static Sala cadastraSala(String localizacao) throws PersistentException {

        Sala sala = SalaDAO.createSala();

        sala.setCodLocalizacao(localizacao);

        SalaDAO.save(sala);

        return sala;
    }

    public static void alocaTurmaNaSala(Sala sala, Turma turma, Horariodeaula hora){
/*  @TODO isso ae

        SalasTurmas alocacao = new SalasTurmas(sala, turma, hora);

        EntityManager em = Main.em;

        em.persist(alocacao);

        JPAUtil.commit(em);*/

    }

    public static void remover(List<Sala> lista) throws PersistentException {
        for (Sala sala : lista) {
            SalaDAO.deleteAndDissociate(sala);
        }
    }

    public static ObservableList<Sala> buscar(String text) throws PersistentException {

        SalaCriteria sc = new SalaCriteria();
        sc.add(Restrictions.ilike("codLocalizacao", text, MatchMode.ANYWHERE));

        return FXCollections.observableArrayList(SalaDAO.listSalaByCriteria(sc));
    }

    public static ObservableList<Sala> listar() throws PersistentException {
        return FXCollections.observableArrayList(SalaDAO.listSalaByQuery(null,null));
    }
}
