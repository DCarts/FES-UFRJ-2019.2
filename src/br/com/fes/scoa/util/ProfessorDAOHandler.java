package br.com.fes.scoa.util;

import br.com.fes.scoa.Main;
import br.com.fes.scoa.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

public class ProfessorDAOHandler {

	public static Professor fromPessoa(Pessoa pessoa) {
		EntityManager em = Main.em;
		Session session = (Session) Main.em.getDelegate();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Professor> cr = em.getCriteriaBuilder().createQuery(Professor.class);
		Root<Professor> root = cr.from(Professor.class);
		cr.select(root).where(cb.equal(root.get("pessoa"), pessoa));

		org.hibernate.query.Query<Professor> query = session.createQuery(cr);
		return query.getSingleResult();
	}

public static Professor cadastraProfessor(String nome, String str_data_nascimento, String cpf, String endereco, String email, Area_disciplina area, String senha) throws PersistentException {

	Date data_nascimento = Date.valueOf(str_data_nascimento);

	byte[] encodedhash = null;
	try {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		encodedhash = digest.digest(
				senha.getBytes(StandardCharsets.UTF_8));
	} catch (NoSuchAlgorithmException e) {
		throw new PersistentException(e);
	}

	br.com.fes.scoa.model.Pessoa pessoa = PessoaDAO.createPessoa();
	pessoa.setNome(nome);
	pessoa.setData_nascimento(data_nascimento);
	pessoa.setCpf(cpf);
	pessoa.setEndereco(endereco);
	pessoa.setEmail(email);
	pessoa.setSenha(Base64.getEncoder().encodeToString(encodedhash));

	Professor professor = ProfessorDAO.createProfessor();
	professor.setPessoa(pessoa);
	professor.setArea_disciplina(area);

	List<br.com.fes.scoa.model.Pessoa> pessoas_existentes_com_cpf = PessoaDAO.queryPessoa("cpf="+cpf, null);

	if (pessoas_existentes_com_cpf.isEmpty()) {

		PessoaDAO.save(pessoa);
		ProfessorDAO.save(professor);
	} else {

		List<Aluno> resultado2 = AlunoDAO.queryAluno("pessoa_id="+pessoas_existentes_com_cpf.get(0).getId(), null);

		if (resultado2.isEmpty()) {
			professor.setPessoa(pessoas_existentes_com_cpf.get(0));
			ProfessorDAO.save(professor);
		} else {
			// @TODO reportar isso ao usuário de alguma forma quando ele tenta cadastrar um
			// aluno que ja esta cadastrado

			System.out.println(resultado2.get(0).getPessoa().getNome()
					+ " ja esta cadastrado(a) como aluno(a)\n CPF: " + resultado2.get(0).getPessoa().getCpf());
		}

	}
	return professor;

	}

	public static ObservableList<Professor> buscar(String str) throws PersistentException {
		ProfessorCriteria prc = new ProfessorCriteria();
		PessoaCriteria pc = prc.createPessoaCriteria();
		pc.add(Restrictions.or(Restrictions.ilike("nome", str, MatchMode.ANYWHERE),
				Restrictions.ilike("email", str, MatchMode.ANYWHERE),
				Restrictions.ilike("cpf", str, MatchMode.ANYWHERE)));

		return FXCollections.observableArrayList(ProfessorDAO.listProfessorByCriteria(prc));
	}
	public static void remover(List<Professor> lista) throws PersistentException {
		for (Professor professor : lista) {
			ProfessorDAO.deleteAndDissociate(professor);
		}
	}

	public static ObservableList<Professor> listar() throws PersistentException {
		return FXCollections.observableArrayList(ProfessorDAO.listProfessorByQuery(null, null));
	}

    public static ObservableList<Turma> turmas(Professor professor) throws PersistentException {
		TurmaCriteria tc = new TurmaCriteria();
		ProfessorCriteria pc = tc.createProfessorCriteria();
		pc.add(Restrictions.idEq(professor.getPessoaId()));

        return FXCollections.observableArrayList(TurmaDAO.listTurmaByCriteria(tc));
    }

    public static ObservableList<Turma> buscarTurmas(String text) {
        return FXCollections.observableArrayList();
    }

}
