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

public class SecretarioDAOHandler {

public static Secretario cadastraSecretario(String nome, String str_data_nascimento, String cpf, String endereco, String email, Curso curso, String senha) throws PersistentException {

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

	Secretario secretario = SecretarioDAO.createSecretario();
	secretario.setPessoa(pessoa);
	secretario.setCurso(curso);

	List<Pessoa> pessoas_existentes_com_cpf = PessoaDAO.queryPessoa("cpf='"+cpf+"'", null);

	if (pessoas_existentes_com_cpf.isEmpty()) {

		PessoaDAO.save(pessoa);
		SecretarioDAO.save(secretario);
	} else {

		List<Secretario> resultado2 = SecretarioDAO.querySecretario("pessoa_id="+pessoas_existentes_com_cpf.get(0).getId(), null);

		if (resultado2.isEmpty()) {
			secretario.setPessoa(pessoas_existentes_com_cpf.get(0));
			SecretarioDAO.save(secretario);
		} else {
			// @TODO reportar isso ao usuário de alguma forma quando ele tenta cadastrar um
			// secretario que ja esta cadastrado

			throw new PersistentException("Já há um secretario cadastrado com esse CPF:" + resultado2.get(0).getPessoa().getCpf());
		}

	}
	return secretario;

	}

	public static ObservableList<Secretario> buscar(String str) throws PersistentException {
		SecretarioCriteria prc = new SecretarioCriteria();
		PessoaCriteria pc = prc.createPessoaCriteria();
		pc.add(Restrictions.or(Restrictions.ilike("nome", str, MatchMode.ANYWHERE),
				Restrictions.ilike("email", str, MatchMode.ANYWHERE),
				Restrictions.ilike("cpf", str, MatchMode.ANYWHERE)));

		return FXCollections.observableArrayList(SecretarioDAO.listSecretarioByCriteria(prc));
	}
	public static void remover(List<Secretario> lista) throws PersistentException {
		for (Secretario secretario : lista) {
			SecretarioDAO.deleteAndDissociate(secretario);
		}
	}

	public static ObservableList<Secretario> listar() throws PersistentException {
		return FXCollections.observableArrayList(SecretarioDAO.listSecretarioByQuery(null, null));
	}

}
