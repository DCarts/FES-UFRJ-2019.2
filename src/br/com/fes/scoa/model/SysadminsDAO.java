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

public class SysadminsDAO {
	public static List querySysadmins(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return querySysadmins(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySysadmins(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return querySysadmins(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins[] listSysadminsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listSysadminsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins[] listSysadminsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listSysadminsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List querySysadmins(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Sysadmins as Sysadmins");
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
	
	public static List querySysadmins(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Sysadmins as Sysadmins");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sysadmins", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins[] listSysadminsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = querySysadmins(session, condition, orderBy);
			return (Sysadmins[]) list.toArray(new Sysadmins[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins[] listSysadminsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = querySysadmins(session, condition, orderBy, lockMode);
			return (Sysadmins[]) list.toArray(new Sysadmins[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins loadSysadminsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadSysadminsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins loadSysadminsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadSysadminsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins loadSysadminsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sysadmins[] sysadminses = listSysadminsByQuery(session, condition, orderBy);
		if (sysadminses != null && sysadminses.length > 0)
			return sysadminses[0];
		else
			return null;
	}
	
	public static Sysadmins loadSysadminsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sysadmins[] sysadminses = listSysadminsByQuery(session, condition, orderBy, lockMode);
		if (sysadminses != null && sysadminses.length > 0)
			return sysadminses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSysadminsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateSysadminsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSysadminsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateSysadminsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSysadminsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Sysadmins as Sysadmins");
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
	
	public static java.util.Iterator iterateSysadminsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Sysadmins as Sysadmins");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Sysadmins", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins createSysadmins() {
		return new br.com.fes.scoa.model.Sysadmins();
	}
	
	public static boolean save(br.com.fes.scoa.model.Sysadmins sysadmins) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(sysadmins);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Sysadmins sysadmins) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(sysadmins);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Sysadmins sysadmins)throws PersistentException {
		try {
			br.com.fes.scoa.model.Pessoa pessoa = sysadmins.getPessoa();
			if (sysadmins.getPessoa() != null) {
				sysadmins.getPessoa().setSysadmins(null);
			}
			sysadmins.setPessoa(pessoa);
			
			return delete(sysadmins);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Sysadmins sysadmins, org.orm.PersistentSession session)throws PersistentException {
		try {
			br.com.fes.scoa.model.Pessoa pessoa = sysadmins.getPessoa();
			if (sysadmins.getPessoa() != null) {
				sysadmins.getPessoa().setSysadmins(null);
			}
			sysadmins.setPessoa(pessoa);
			
			try {
				session.delete(sysadmins);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Sysadmins sysadmins) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(sysadmins);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Sysadmins sysadmins) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(sysadmins);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Sysadmins loadSysadminsByCriteria(SysadminsCriteria sysadminsCriteria) {
		Sysadmins[] sysadminses = listSysadminsByCriteria(sysadminsCriteria);
		if(sysadminses == null || sysadminses.length == 0) {
			return null;
		}
		return sysadminses[0];
	}
	
	public static Sysadmins[] listSysadminsByCriteria(SysadminsCriteria sysadminsCriteria) {
		return sysadminsCriteria.listSysadmins();
	}
}
