package br.com.fes.scoa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fes.scoa.modelo.*;
import br.com.fes.scoa.util.*;

import java.time.LocalDate;

public class TesteConta {
	
	public static void main(String[] args) {

		//EntityManager em = JPAUtil.abreConexao();


		Disciplina disciplina = DisciplinaDAO.cadastraDisciplina("TESTE", "SO MAIS UMA TESTE");
		Disciplina disciplina2 = DisciplinaDAO.cadastraDisciplina("FES", "Prograaaaama");
		DisciplinaDAO.equivalenciaDisciplinas(disciplina, disciplina2);



		Sala sala = SalaDAO.cadastraSala("CCMNF::2::F02-10");
		Professor professor = ProfessorDAO.cadastraProfessor("Gil", "1990-05-12", "11012547878", "Rua do prof", "prof@gmail.com");
		Turma turma = TurmaDAO.cadastraTurma(disciplina2, professor);
		Aluno aluno1 = AlunoDAO.cadastrar("Albe", "1990-05-12", "99977847878", "Rua do prof", "prof@gmail.com");
		Aluno aluno2 = AlunoDAO.cadastrar("ju", "1990-05-12", "39877847878", "Rua do prof", "prof@gmail.com");
		TurmaDAO.cadastraAlunoNaTurma(turma, aluno1);
		TurmaDAO.cadastraAlunoNaTurma(turma, aluno2);
		// SalaDAO.alocaTurmaNaSala(sala, turma, TipoHoraDoDia.H8);
		// SalaDAO.alocaTurmaNaSala(sala, turma, TipoHoraDoDia.H9);



		//em.getTransaction().commit();

		//em.clear();
		//em.close();

		
	}

}
