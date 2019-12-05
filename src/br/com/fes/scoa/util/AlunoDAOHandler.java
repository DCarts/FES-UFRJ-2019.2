package br.com.fes.scoa.util;

import br.com.fes.scoa.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

public class AlunoDAOHandler {
	public static void remover(List<Aluno> lista) throws PersistentException {
		for (Aluno aluno : lista) {
			AlunoDAO.deleteAndDissociate(aluno);
		}
	}

	public static ObservableList<Aluno> listar() throws PersistentException {
		return FXCollections.observableArrayList(AlunoDAO.listAlunoByQuery(null, null));
	}

	public static Aluno cadastrar(String nome, String str_data_nascimento, String cpf, String endereco, String email, String senha, Curso curso) throws PersistentException {

		Date data_nascimento = Date.valueOf(str_data_nascimento);

		byte[] encodedhash = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(
					senha.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			throw new PersistentException(e);
		}

		Pessoa pessoa = PessoaDAO.createPessoa();
		pessoa.setNome(nome);
		pessoa.setData_nascimento(data_nascimento);
		pessoa.setCpf(cpf);
		pessoa.setEndereco(endereco);
		pessoa.setEmail(email);
		pessoa.setSenha(Base64.getEncoder().encodeToString(encodedhash));

		Aluno aluno = AlunoDAO.createAluno();
		aluno.setPessoa(pessoa);
		aluno.setCurso(curso);

		List<Pessoa> pessoas_existentes_com_cpf = PessoaDAO.queryPessoa("cpf='"+cpf+"'", null);

		if (pessoas_existentes_com_cpf.isEmpty()) {

			PessoaDAO.save(pessoa);
			AlunoDAO.save(aluno);
		} else {

			List<Aluno> resultado2 = AlunoDAO.queryAluno("pessoa_id="+pessoas_existentes_com_cpf.get(0).getId(), null);

			if (resultado2.isEmpty()) {
				aluno.setPessoa(pessoas_existentes_com_cpf.get(0));
				AlunoDAO.save(aluno);
			} else {
				// @TODO reportar isso ao usuário de alguma forma quando ele tenta cadastrar um
				// aluno que ja esta cadastrado

				throw new PersistentException("Já há um aluno cadastrado com esse CPF:" + resultado2.get(0).getPessoa().getCpf());
			}

		}
		return aluno;

	}

	public static ObservableList<Aluno> buscar(String str) throws PersistentException {
		AlunoCriteria ac = new AlunoCriteria();
		PessoaCriteria pc = ac.createPessoaCriteria();
		pc.add(Restrictions.or(Restrictions.ilike("nome", str, MatchMode.ANYWHERE),
				Restrictions.ilike("email", str, MatchMode.ANYWHERE),
				Restrictions.ilike("cpf", str, MatchMode.ANYWHERE)));

		return FXCollections.observableArrayList(AlunoDAO.listAlunoByCriteria(ac));
	}

	public static Aluno editar(
			Integer id,
			String nome,
			String str_data_nascimento,
			String cpf,
			String endereco,
			String email,
			Curso curso
	) throws PersistentException {
		Date data_nascimento = Date.valueOf(str_data_nascimento);
		System.out.println("cpf: " + cpf);
		Aluno aluno = AlunoDAO.loadAlunoByQuery("id="+id,null);
		Pessoa pessoa = PessoaDAO.getPessoaByORMID(aluno.getPessoaId());
		if (!pessoa.getNome().equals(nome))
			pessoa.setNome(nome);
		if (!pessoa.getCpf().equals(cpf))
			pessoa.setCpf(cpf);
		if (!pessoa.getData_nascimento().equals(data_nascimento))
			pessoa.setData_nascimento(data_nascimento);
		if (!pessoa.getEmail().equals(email))
			pessoa.setEmail(email);
		if (!pessoa.getEndereco().equals(endereco))
			pessoa.setEndereco(endereco);
		if (!aluno.getCurso().equals(curso))
			aluno.setCurso(curso);

		PessoaDAO.save(pessoa);
		AlunoDAO.save(aluno);

		return aluno;
	}
}
