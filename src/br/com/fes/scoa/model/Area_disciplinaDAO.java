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

public class Area_disciplinaDAO {
	public static Area_disciplina loadArea_disciplinaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadArea_disciplinaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina getArea_disciplinaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getArea_disciplinaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina loadArea_disciplinaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadArea_disciplinaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina getArea_disciplinaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getArea_disciplinaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina loadArea_disciplinaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Area_disciplina) session.load(br.com.fes.scoa.model.Area_disciplina.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina getArea_disciplinaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Area_disciplina) session.get(br.com.fes.scoa.model.Area_disciplina.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina loadArea_disciplinaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Area_disciplina) session.load(br.com.fes.scoa.model.Area_disciplina.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina getArea_disciplinaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Area_disciplina) session.get(br.com.fes.scoa.model.Area_disciplina.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArea_disciplina(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryArea_disciplina(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArea_disciplina(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryArea_disciplina(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina[] listArea_disciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listArea_disciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina[] listArea_disciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listArea_disciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryArea_disciplina(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Area_disciplina as Area_disciplina");
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
	
	public static List queryArea_disciplina(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Area_disciplina as Area_disciplina");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Area_disciplina", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina[] listArea_disciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryArea_disciplina(session, condition, orderBy);
			return (Area_disciplina[]) list.toArray(new Area_disciplina[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina[] listArea_disciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryArea_disciplina(session, condition, orderBy, lockMode);
			return (Area_disciplina[]) list.toArray(new Area_disciplina[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina loadArea_disciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadArea_disciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina loadArea_disciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadArea_disciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina loadArea_disciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Area_disciplina[] area_disciplinas = listArea_disciplinaByQuery(session, condition, orderBy);
		if (area_disciplinas != null && area_disciplinas.length > 0)
			return area_disciplinas[0];
		else
			return null;
	}
	
	public static Area_disciplina loadArea_disciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Area_disciplina[] area_disciplinas = listArea_disciplinaByQuery(session, condition, orderBy, lockMode);
		if (area_disciplinas != null && area_disciplinas.length > 0)
			return area_disciplinas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateArea_disciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateArea_disciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArea_disciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateArea_disciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateArea_disciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Area_disciplina as Area_disciplina");
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
	
	public static java.util.Iterator iterateArea_disciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Area_disciplina as Area_disciplina");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Area_disciplina", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina createArea_disciplina() {
		return new br.com.fes.scoa.model.Area_disciplina();
	}
	
	public static boolean save(br.com.fes.scoa.model.Area_disciplina area_disciplina) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(area_disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Area_disciplina area_disciplina) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(area_disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Area_disciplina area_disciplina)throws PersistentException {
		try {
			br.com.fes.scoa.model.Professor[] lProfessors = area_disciplina.professor.toArray();
			for(int i = 0; i < lProfessors.length; i++) {
				lProfessors[i].setArea_disciplina(null);
			}
			br.com.fes.scoa.model.Disciplina[] lDisciplinas = area_disciplina.disciplina.toArray();
			for(int i = 0; i < lDisciplinas.length; i++) {
				lDisciplinas[i].setArea_disciplina(null);
			}
			return delete(area_disciplina);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Area_disciplina area_disciplina, org.orm.PersistentSession session)throws PersistentException {
		try {
			br.com.fes.scoa.model.Professor[] lProfessors = area_disciplina.professor.toArray();
			for(int i = 0; i < lProfessors.length; i++) {
				lProfessors[i].setArea_disciplina(null);
			}
			br.com.fes.scoa.model.Disciplina[] lDisciplinas = area_disciplina.disciplina.toArray();
			for(int i = 0; i < lDisciplinas.length; i++) {
				lDisciplinas[i].setArea_disciplina(null);
			}
			try {
				session.delete(area_disciplina);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Area_disciplina area_disciplina) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(area_disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Area_disciplina area_disciplina) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(area_disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Area_disciplina loadArea_disciplinaByCriteria(Area_disciplinaCriteria area_disciplinaCriteria) {
		Area_disciplina[] area_disciplinas = listArea_disciplinaByCriteria(area_disciplinaCriteria);
		if(area_disciplinas == null || area_disciplinas.length == 0) {
			return null;
		}
		return area_disciplinas[0];
	}
	
	public static Area_disciplina[] listArea_disciplinaByCriteria(Area_disciplinaCriteria area_disciplinaCriteria) {
		return area_disciplinaCriteria.listArea_disciplina();
	}
}
