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

public class SysadminsDAOHandler {

public static Sysadmins cadastraSysadmins(String nome, String str_data_nascimento, String cpf, String endereco, String email, String senha) throws PersistentException {

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

	Sysadmins admin = SysadminsDAO.createSysadmins();
	admin.setPessoa(pessoa);

	List<Pessoa> pessoas_existentes_com_cpf = PessoaDAO.queryPessoa("cpf='"+cpf+"'", null);

	if (pessoas_existentes_com_cpf.isEmpty()) {

		PessoaDAO.save(pessoa);
		SysadminsDAO.save(admin);
	} else {

		List<Sysadmins> resultado2 = SysadminsDAO.querySysadmins("pessoa_id="+pessoas_existentes_com_cpf.get(0).getId(), null);

		if (resultado2.isEmpty()) {
			admin.setPessoa(pessoas_existentes_com_cpf.get(0));
			SysadminsDAO.save(admin);
		} else {
			// @TODO reportar isso ao usuário de alguma forma quando ele tenta cadastrar um
			// Sysadmins que ja esta cadastrado

			throw new PersistentException("Já há um Sysadmins cadastrado com esse CPF:" + resultado2.get(0).getPessoa().getCpf());
		}

	}
	return admin;

	}

	public static ObservableList<Sysadmins> buscar(String str) throws PersistentException {
		SysadminsCriteria prc = new SysadminsCriteria();
		PessoaCriteria pc = prc.createPessoaCriteria();
		pc.add(Restrictions.or(Restrictions.ilike("nome", str, MatchMode.ANYWHERE),
				Restrictions.ilike("email", str, MatchMode.ANYWHERE),
				Restrictions.ilike("cpf", str, MatchMode.ANYWHERE)));

		return FXCollections.observableArrayList(SysadminsDAO.listSysadminsByCriteria(prc));
	}
	public static void remover(List<Sysadmins> lista) throws PersistentException {
		for (Sysadmins Sysadmins : lista) {
			SysadminsDAO.deleteAndDissociate(Sysadmins);
		}
	}

	public static ObservableList<Sysadmins> listar() throws PersistentException {
		return FXCollections.observableArrayList(SysadminsDAO.listSysadminsByQuery(null, null));
	}

}
