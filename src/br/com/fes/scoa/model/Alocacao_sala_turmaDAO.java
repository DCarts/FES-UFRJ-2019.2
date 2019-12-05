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

public class Alocacao_sala_turmaDAO {
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByORMID(br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Sala sala, br.com.fes.scoa.model.Horariodeaula hora) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadAlocacao_sala_turmaByORMID(session, turma, sala, hora);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma getAlocacao_sala_turmaByORMID(br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Sala sala, br.com.fes.scoa.model.Horariodeaula hora) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getAlocacao_sala_turmaByORMID(session, turma, sala, hora);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByORMID(br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Sala sala, br.com.fes.scoa.model.Horariodeaula hora, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadAlocacao_sala_turmaByORMID(session, turma, sala, hora, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma getAlocacao_sala_turmaByORMID(br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Sala sala, br.com.fes.scoa.model.Horariodeaula hora, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getAlocacao_sala_turmaByORMID(session, turma, sala, hora, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByORMID(PersistentSession session, br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Sala sala, br.com.fes.scoa.model.Horariodeaula hora) throws PersistentException {
		try {
			Alocacao_sala_turma alocacao_sala_turma = new br.com.fes.scoa.model.Alocacao_sala_turma();
			alocacao_sala_turma.setORM_Turma(turma);
			alocacao_sala_turma.setORM_Sala(sala);
			alocacao_sala_turma.setORM_Hora(hora);
			
			return (Alocacao_sala_turma) session.load(br.com.fes.scoa.model.Alocacao_sala_turma.class, alocacao_sala_turma);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma getAlocacao_sala_turmaByORMID(PersistentSession session, br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Sala sala, br.com.fes.scoa.model.Horariodeaula hora) throws PersistentException {
		try {
			Alocacao_sala_turma alocacao_sala_turma = new br.com.fes.scoa.model.Alocacao_sala_turma();
			alocacao_sala_turma.setORM_Turma(turma);
			alocacao_sala_turma.setORM_Sala(sala);
			alocacao_sala_turma.setORM_Hora(hora);
			
			return (Alocacao_sala_turma) session.get(br.com.fes.scoa.model.Alocacao_sala_turma.class, alocacao_sala_turma);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByORMID(PersistentSession session, br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Sala sala, br.com.fes.scoa.model.Horariodeaula hora, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Alocacao_sala_turma alocacao_sala_turma = new br.com.fes.scoa.model.Alocacao_sala_turma();
			alocacao_sala_turma.setORM_Turma(turma);
			alocacao_sala_turma.setORM_Sala(sala);
			alocacao_sala_turma.setORM_Hora(hora);
			
			return (Alocacao_sala_turma) session.load(br.com.fes.scoa.model.Alocacao_sala_turma.class, alocacao_sala_turma, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma getAlocacao_sala_turmaByORMID(PersistentSession session, br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Sala sala, br.com.fes.scoa.model.Horariodeaula hora, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Alocacao_sala_turma alocacao_sala_turma = new br.com.fes.scoa.model.Alocacao_sala_turma();
			alocacao_sala_turma.setORM_Turma(turma);
			alocacao_sala_turma.setORM_Sala(sala);
			alocacao_sala_turma.setORM_Hora(hora);
			
			return (Alocacao_sala_turma) session.get(br.com.fes.scoa.model.Alocacao_sala_turma.class, alocacao_sala_turma, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlocacao_sala_turma(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryAlocacao_sala_turma(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlocacao_sala_turma(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryAlocacao_sala_turma(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma[] listAlocacao_sala_turmaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listAlocacao_sala_turmaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma[] listAlocacao_sala_turmaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listAlocacao_sala_turmaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlocacao_sala_turma(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Alocacao_sala_turma as Alocacao_sala_turma");
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
	
	public static List queryAlocacao_sala_turma(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Alocacao_sala_turma as Alocacao_sala_turma");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Alocacao_sala_turma", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma[] listAlocacao_sala_turmaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAlocacao_sala_turma(session, condition, orderBy);
			return (Alocacao_sala_turma[]) list.toArray(new Alocacao_sala_turma[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma[] listAlocacao_sala_turmaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAlocacao_sala_turma(session, condition, orderBy, lockMode);
			return (Alocacao_sala_turma[]) list.toArray(new Alocacao_sala_turma[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadAlocacao_sala_turmaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadAlocacao_sala_turmaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Alocacao_sala_turma[] alocacao_sala_turmas = listAlocacao_sala_turmaByQuery(session, condition, orderBy);
		if (alocacao_sala_turmas != null && alocacao_sala_turmas.length > 0)
			return alocacao_sala_turmas[0];
		else
			return null;
	}
	
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Alocacao_sala_turma[] alocacao_sala_turmas = listAlocacao_sala_turmaByQuery(session, condition, orderBy, lockMode);
		if (alocacao_sala_turmas != null && alocacao_sala_turmas.length > 0)
			return alocacao_sala_turmas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAlocacao_sala_turmaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateAlocacao_sala_turmaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlocacao_sala_turmaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateAlocacao_sala_turmaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlocacao_sala_turmaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Alocacao_sala_turma as Alocacao_sala_turma");
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
	
	public static java.util.Iterator iterateAlocacao_sala_turmaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Alocacao_sala_turma as Alocacao_sala_turma");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Alocacao_sala_turma", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma createAlocacao_sala_turma() {
		return new br.com.fes.scoa.model.Alocacao_sala_turma();
	}
	
	public static boolean save(br.com.fes.scoa.model.Alocacao_sala_turma alocacao_sala_turma) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(alocacao_sala_turma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Alocacao_sala_turma alocacao_sala_turma) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(alocacao_sala_turma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Alocacao_sala_turma alocacao_sala_turma)throws PersistentException {
		try {
			br.com.fes.scoa.model.Turma turma = alocacao_sala_turma.getTurma();
			if (alocacao_sala_turma.getTurma() != null) {
				alocacao_sala_turma.getTurma().alocacao_sala_turma.remove(alocacao_sala_turma);
			}
			alocacao_sala_turma.setORM_Turma(turma);
			
			br.com.fes.scoa.model.Sala sala = alocacao_sala_turma.getSala();
			if (alocacao_sala_turma.getSala() != null) {
				alocacao_sala_turma.getSala().alocacao_sala_turma.remove(alocacao_sala_turma);
			}
			alocacao_sala_turma.setORM_Sala(sala);
			
			br.com.fes.scoa.model.Horariodeaula hora = alocacao_sala_turma.getHora();
			if (alocacao_sala_turma.getHora() != null) {
				alocacao_sala_turma.getHora().alocacao_sala_turma.remove(alocacao_sala_turma);
			}
			alocacao_sala_turma.setORM_Hora(hora);
			
			return delete(alocacao_sala_turma);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Alocacao_sala_turma alocacao_sala_turma, org.orm.PersistentSession session)throws PersistentException {
		try {
			br.com.fes.scoa.model.Turma turma = alocacao_sala_turma.getTurma();
			if (alocacao_sala_turma.getTurma() != null) {
				alocacao_sala_turma.getTurma().alocacao_sala_turma.remove(alocacao_sala_turma);
			}
			alocacao_sala_turma.setORM_Turma(turma);
			
			br.com.fes.scoa.model.Sala sala = alocacao_sala_turma.getSala();
			if (alocacao_sala_turma.getSala() != null) {
				alocacao_sala_turma.getSala().alocacao_sala_turma.remove(alocacao_sala_turma);
			}
			alocacao_sala_turma.setORM_Sala(sala);
			
			br.com.fes.scoa.model.Horariodeaula hora = alocacao_sala_turma.getHora();
			if (alocacao_sala_turma.getHora() != null) {
				alocacao_sala_turma.getHora().alocacao_sala_turma.remove(alocacao_sala_turma);
			}
			alocacao_sala_turma.setORM_Hora(hora);
			
			try {
				session.delete(alocacao_sala_turma);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Alocacao_sala_turma alocacao_sala_turma) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(alocacao_sala_turma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Alocacao_sala_turma alocacao_sala_turma) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(alocacao_sala_turma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alocacao_sala_turma loadAlocacao_sala_turmaByCriteria(Alocacao_sala_turmaCriteria alocacao_sala_turmaCriteria) {
		Alocacao_sala_turma[] alocacao_sala_turmas = listAlocacao_sala_turmaByCriteria(alocacao_sala_turmaCriteria);
		if(alocacao_sala_turmas == null || alocacao_sala_turmas.length == 0) {
			return null;
		}
		return alocacao_sala_turmas[0];
	}
	
	public static Alocacao_sala_turma[] listAlocacao_sala_turmaByCriteria(Alocacao_sala_turmaCriteria alocacao_sala_turmaCriteria) {
		return alocacao_sala_turmaCriteria.listAlocacao_sala_turma();
	}
}
