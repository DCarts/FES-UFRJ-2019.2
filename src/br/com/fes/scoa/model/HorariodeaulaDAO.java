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

public class HorariodeaulaDAO {
	public static Horariodeaula loadHorariodeaulaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadHorariodeaulaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula getHorariodeaulaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getHorariodeaulaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula loadHorariodeaulaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadHorariodeaulaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula getHorariodeaulaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getHorariodeaulaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula loadHorariodeaulaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Horariodeaula) session.load(br.com.fes.scoa.model.Horariodeaula.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula getHorariodeaulaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Horariodeaula) session.get(br.com.fes.scoa.model.Horariodeaula.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula loadHorariodeaulaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Horariodeaula) session.load(br.com.fes.scoa.model.Horariodeaula.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula getHorariodeaulaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Horariodeaula) session.get(br.com.fes.scoa.model.Horariodeaula.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHorariodeaula(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryHorariodeaula(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHorariodeaula(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryHorariodeaula(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula[] listHorariodeaulaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listHorariodeaulaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula[] listHorariodeaulaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listHorariodeaulaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHorariodeaula(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Horariodeaula as Horariodeaula");
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
	
	public static List queryHorariodeaula(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Horariodeaula as Horariodeaula");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Horariodeaula", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula[] listHorariodeaulaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHorariodeaula(session, condition, orderBy);
			return (Horariodeaula[]) list.toArray(new Horariodeaula[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula[] listHorariodeaulaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHorariodeaula(session, condition, orderBy, lockMode);
			return (Horariodeaula[]) list.toArray(new Horariodeaula[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula loadHorariodeaulaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadHorariodeaulaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula loadHorariodeaulaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadHorariodeaulaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula loadHorariodeaulaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Horariodeaula[] horariodeaulas = listHorariodeaulaByQuery(session, condition, orderBy);
		if (horariodeaulas != null && horariodeaulas.length > 0)
			return horariodeaulas[0];
		else
			return null;
	}
	
	public static Horariodeaula loadHorariodeaulaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Horariodeaula[] horariodeaulas = listHorariodeaulaByQuery(session, condition, orderBy, lockMode);
		if (horariodeaulas != null && horariodeaulas.length > 0)
			return horariodeaulas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHorariodeaulaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateHorariodeaulaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHorariodeaulaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateHorariodeaulaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHorariodeaulaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Horariodeaula as Horariodeaula");
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
	
	public static java.util.Iterator iterateHorariodeaulaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Horariodeaula as Horariodeaula");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Horariodeaula", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula createHorariodeaula() {
		return new br.com.fes.scoa.model.Horariodeaula();
	}
	
	public static boolean save(br.com.fes.scoa.model.Horariodeaula horariodeaula) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(horariodeaula);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Horariodeaula horariodeaula) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(horariodeaula);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Horariodeaula horariodeaula)throws PersistentException {
		try {
			br.com.fes.scoa.model.Alocacao_sala_turma[] lAlocacao_sala_turmas = horariodeaula.alocacao_sala_turma.toArray();
			for(int i = 0; i < lAlocacao_sala_turmas.length; i++) {
				lAlocacao_sala_turmas[i].setHora(null);
			}
			return delete(horariodeaula);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Horariodeaula horariodeaula, org.orm.PersistentSession session)throws PersistentException {
		try {
			br.com.fes.scoa.model.Alocacao_sala_turma[] lAlocacao_sala_turmas = horariodeaula.alocacao_sala_turma.toArray();
			for(int i = 0; i < lAlocacao_sala_turmas.length; i++) {
				lAlocacao_sala_turmas[i].setHora(null);
			}
			try {
				session.delete(horariodeaula);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Horariodeaula horariodeaula) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(horariodeaula);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Horariodeaula horariodeaula) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(horariodeaula);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horariodeaula loadHorariodeaulaByCriteria(HorariodeaulaCriteria horariodeaulaCriteria) {
		Horariodeaula[] horariodeaulas = listHorariodeaulaByCriteria(horariodeaulaCriteria);
		if(horariodeaulas == null || horariodeaulas.length == 0) {
			return null;
		}
		return horariodeaulas[0];
	}
	
	public static Horariodeaula[] listHorariodeaulaByCriteria(HorariodeaulaCriteria horariodeaulaCriteria) {
		return horariodeaulaCriteria.listHorariodeaula();
	}
}
