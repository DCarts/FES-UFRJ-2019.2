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

public class SecretarioDAO {
	public static List querySecretario(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return querySecretario(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySecretario(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return querySecretario(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario[] listSecretarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listSecretarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario[] listSecretarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listSecretarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySecretario(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Secretario as Secretario");
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
	
	public static List querySecretario(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Secretario as Secretario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Secretario", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario[] listSecretarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySecretario(session, condition, orderBy);
			return (Secretario[]) list.toArray(new Secretario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario[] listSecretarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySecretario(session, condition, orderBy, lockMode);
			return (Secretario[]) list.toArray(new Secretario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario loadSecretarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadSecretarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario loadSecretarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadSecretarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario loadSecretarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Secretario[] secretarios = listSecretarioByQuery(session, condition, orderBy);
		if (secretarios != null && secretarios.length > 0)
			return secretarios[0];
		else
			return null;
	}
	
	public static Secretario loadSecretarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Secretario[] secretarios = listSecretarioByQuery(session, condition, orderBy, lockMode);
		if (secretarios != null && secretarios.length > 0)
			return secretarios[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSecretarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateSecretarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSecretarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateSecretarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSecretarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Secretario as Secretario");
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
	
	public static java.util.Iterator iterateSecretarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Secretario as Secretario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Secretario", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario createSecretario() {
		return new br.com.fes.scoa.model.Secretario();
	}
	
	public static boolean save(br.com.fes.scoa.model.Secretario secretario) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(secretario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Secretario secretario) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(secretario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Secretario secretario)throws PersistentException {
		try {
			br.com.fes.scoa.model.Pessoa pessoa = secretario.getPessoa();
			if (secretario.getPessoa() != null) {
				secretario.getPessoa().setSecretario(null);
			}
			secretario.setPessoa(pessoa);
			
			if (secretario.getCurso() != null) {
				secretario.getCurso().secretario.remove(secretario);
			}
			
			return delete(secretario);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Secretario secretario, org.orm.PersistentSession session)throws PersistentException {
		try {
			br.com.fes.scoa.model.Pessoa pessoa = secretario.getPessoa();
			if (secretario.getPessoa() != null) {
				secretario.getPessoa().setSecretario(null);
			}
			secretario.setPessoa(pessoa);
			
			if (secretario.getCurso() != null) {
				secretario.getCurso().secretario.remove(secretario);
			}
			
			try {
				session.delete(secretario);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Secretario secretario) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(secretario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Secretario secretario) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(secretario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Secretario loadSecretarioByCriteria(SecretarioCriteria secretarioCriteria) {
		Secretario[] secretarios = listSecretarioByCriteria(secretarioCriteria);
		if(secretarios == null || secretarios.length == 0) {
			return null;
		}
		return secretarios[0];
	}
	
	public static Secretario[] listSecretarioByCriteria(SecretarioCriteria secretarioCriteria) {
		return secretarioCriteria.listSecretario();
	}
}
