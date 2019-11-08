package br.com.fes.scoa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fes.scoa.modelo.*;
import br.com.fes.scoa.util.JPAUtil;
import br.com.fes.scoa.util.SalaDAO;
import br.com.fes.scoa.util.TurmaDAO;

import java.time.LocalDate;

public class TesteConta {
	
	public static void main(String[] args) {

		EntityManager em = JPAUtil.abreConexao();

		Sala sala = SalaDAO.cadastraSala("CCMNF0223");
		Turma turma = em.find(Turma.class, 3);
		SalaDAO.alocaTurmaNaSala(sala, turma, TipoHoraDoDia.H8);
		SalaDAO.alocaTurmaNaSala(sala, turma, TipoHoraDoDia.H9);

		JPAUtil.commit(em);

	}

}
