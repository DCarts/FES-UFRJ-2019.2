/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package br.com.fes.scoa.model;

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.List;

public class PessoaDAO {
	public static Pessoa loadPessoaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadPessoaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa getPessoaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getPessoaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa loadPessoaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadPessoaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa getPessoaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getPessoaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa loadPessoaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Pessoa) session.load(br.com.fes.scoa.model.Pessoa.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa getPessoaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Pessoa) session.get(br.com.fes.scoa.model.Pessoa.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa loadPessoaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pessoa) session.load(br.com.fes.scoa.model.Pessoa.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa getPessoaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Pessoa) session.get(br.com.fes.scoa.model.Pessoa.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPessoa(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryPessoa(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPessoa(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryPessoa(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa[] listPessoaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listPessoaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa[] listPessoaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listPessoaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPessoa(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Pessoa as Pessoa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPessoa(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Pessoa as Pessoa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pessoa", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa[] listPessoaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPessoa(session, condition, orderBy);
			return (Pessoa[]) list.toArray(new Pessoa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa[] listPessoaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPessoa(session, condition, orderBy, lockMode);
			return (Pessoa[]) list.toArray(new Pessoa[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa loadPessoaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadPessoaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa loadPessoaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadPessoaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa loadPessoaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Pessoa[] pessoas = listPessoaByQuery(session, condition, orderBy);
		if (pessoas != null && pessoas.length > 0)
			return pessoas[0];
		else
			return null;
	}
	
	public static Pessoa loadPessoaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Pessoa[] pessoas = listPessoaByQuery(session, condition, orderBy, lockMode);
		if (pessoas != null && pessoas.length > 0)
			return pessoas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePessoaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iteratePessoaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePessoaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iteratePessoaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePessoaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Pessoa as Pessoa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePessoaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Pessoa as Pessoa");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Pessoa", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa createPessoa() {
		return new br.com.fes.scoa.model.Pessoa();
	}
	
	public static boolean save(br.com.fes.scoa.model.Pessoa pessoa) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(pessoa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Pessoa pessoa) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(pessoa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Pessoa pessoa)throws PersistentException {
		try {
			if (pessoa.getAluno() != null) {
				pessoa.getAluno().setPessoa(null);
			}
			
			if (pessoa.getProfessor() != null) {
				pessoa.getProfessor().setPessoa(null);
			}
			
			if (pessoa.getSecretario() != null) {
				pessoa.getSecretario().setPessoa(null);
			}
			
			if (pessoa.getSysadmins() != null) {
				pessoa.getSysadmins().setPessoa(null);
			}
			
			return delete(pessoa);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Pessoa pessoa, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (pessoa.getAluno() != null) {
				pessoa.getAluno().setPessoa(null);
			}
			
			if (pessoa.getProfessor() != null) {
				pessoa.getProfessor().setPessoa(null);
			}
			
			if (pessoa.getSecretario() != null) {
				pessoa.getSecretario().setPessoa(null);
			}
			
			if (pessoa.getSysadmins() != null) {
				pessoa.getSysadmins().setPessoa(null);
			}
			
			try {
				session.delete(pessoa);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(br.com.fes.scoa.model.Pessoa pessoa) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(pessoa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Pessoa pessoa) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(pessoa);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Pessoa loadPessoaByCriteria(PessoaCriteria pessoaCriteria) {
		Pessoa[] pessoas = listPessoaByCriteria(pessoaCriteria);
		if(pessoas == null || pessoas.length == 0) {
			return null;
		}
		return pessoas[0];
	}
	
	public static Pessoa[] listPessoaByCriteria(PessoaCriteria pessoaCriteria) {
		return pessoaCriteria.listPessoa();
	}
}
