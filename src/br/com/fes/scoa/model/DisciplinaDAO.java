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

public class DisciplinaDAO {
	public static Disciplina loadDisciplinaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadDisciplinaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina getDisciplinaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getDisciplinaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadDisciplinaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina getDisciplinaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getDisciplinaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Disciplina) session.load(br.com.fes.scoa.model.Disciplina.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina getDisciplinaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Disciplina) session.get(br.com.fes.scoa.model.Disciplina.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Disciplina) session.load(br.com.fes.scoa.model.Disciplina.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina getDisciplinaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Disciplina) session.get(br.com.fes.scoa.model.Disciplina.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDisciplina(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryDisciplina(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDisciplina(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryDisciplina(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina[] listDisciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listDisciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina[] listDisciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listDisciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDisciplina(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Disciplina as Disciplina");
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
	
	public static List queryDisciplina(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Disciplina as Disciplina");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Disciplina", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina[] listDisciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDisciplina(session, condition, orderBy);
			return (Disciplina[]) list.toArray(new Disciplina[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina[] listDisciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDisciplina(session, condition, orderBy, lockMode);
			return (Disciplina[]) list.toArray(new Disciplina[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadDisciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadDisciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Disciplina[] disciplinas = listDisciplinaByQuery(session, condition, orderBy);
		if (disciplinas != null && disciplinas.length > 0)
			return disciplinas[0];
		else
			return null;
	}
	
	public static Disciplina loadDisciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Disciplina[] disciplinas = listDisciplinaByQuery(session, condition, orderBy, lockMode);
		if (disciplinas != null && disciplinas.length > 0)
			return disciplinas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDisciplinaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateDisciplinaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDisciplinaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateDisciplinaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDisciplinaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Disciplina as Disciplina");
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
	
	public static java.util.Iterator iterateDisciplinaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Disciplina as Disciplina");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Disciplina", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina createDisciplina() {
		return new br.com.fes.scoa.model.Disciplina();
	}
	
	public static boolean save(br.com.fes.scoa.model.Disciplina disciplina) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Disciplina disciplina) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Disciplina disciplina)throws PersistentException {
		try {
			if (disciplina.getArea_disciplina() != null) {
				disciplina.getArea_disciplina().disciplina.remove(disciplina);
			}
			
			if (disciplina.getCurso() != null) {
				disciplina.getCurso().disciplina.remove(disciplina);
			}
			
			br.com.fes.scoa.model.Disciplina[] lDisciplina1s = disciplina.disciplina1.toArray();
			for(int i = 0; i < lDisciplina1s.length; i++) {
				lDisciplina1s[i].disciplina2.remove(disciplina);
			}
			br.com.fes.scoa.model.Disciplina[] lDisciplinas = disciplina.disciplina.toArray();
			for(int i = 0; i < lDisciplinas.length; i++) {
				lDisciplinas[i].prerequisito.remove(disciplina);
			}
			br.com.fes.scoa.model.Disciplina[] lDisciplina2s = disciplina.disciplina2.toArray();
			for(int i = 0; i < lDisciplina2s.length; i++) {
				lDisciplina2s[i].disciplina1.remove(disciplina);
			}
			br.com.fes.scoa.model.Disciplina[] lPrerequisitos = disciplina.prerequisito.toArray();
			for(int i = 0; i < lPrerequisitos.length; i++) {
				lPrerequisitos[i].disciplina.remove(disciplina);
			}
			br.com.fes.scoa.model.Turma[] lTurmas = disciplina.turma.toArray();
			for(int i = 0; i < lTurmas.length; i++) {
				lTurmas[i].setDisciplina(null);
			}
			return delete(disciplina);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Disciplina disciplina, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (disciplina.getArea_disciplina() != null) {
				disciplina.getArea_disciplina().disciplina.remove(disciplina);
			}
			
			if (disciplina.getCurso() != null) {
				disciplina.getCurso().disciplina.remove(disciplina);
			}
			
			br.com.fes.scoa.model.Disciplina[] lDisciplina1s = disciplina.disciplina1.toArray();
			for(int i = 0; i < lDisciplina1s.length; i++) {
				lDisciplina1s[i].disciplina2.remove(disciplina);
			}
			br.com.fes.scoa.model.Disciplina[] lDisciplinas = disciplina.disciplina.toArray();
			for(int i = 0; i < lDisciplinas.length; i++) {
				lDisciplinas[i].prerequisito.remove(disciplina);
			}
			br.com.fes.scoa.model.Disciplina[] lDisciplina2s = disciplina.disciplina2.toArray();
			for(int i = 0; i < lDisciplina2s.length; i++) {
				lDisciplina2s[i].disciplina1.remove(disciplina);
			}
			br.com.fes.scoa.model.Disciplina[] lPrerequisitos = disciplina.prerequisito.toArray();
			for(int i = 0; i < lPrerequisitos.length; i++) {
				lPrerequisitos[i].disciplina.remove(disciplina);
			}
			br.com.fes.scoa.model.Turma[] lTurmas = disciplina.turma.toArray();
			for(int i = 0; i < lTurmas.length; i++) {
				lTurmas[i].setDisciplina(null);
			}
			try {
				session.delete(disciplina);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Disciplina disciplina) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Disciplina disciplina) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(disciplina);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Disciplina loadDisciplinaByCriteria(DisciplinaCriteria disciplinaCriteria) {
		Disciplina[] disciplinas = listDisciplinaByCriteria(disciplinaCriteria);
		if(disciplinas == null || disciplinas.length == 0) {
			return null;
		}
		return disciplinas[0];
	}
	
	public static Disciplina[] listDisciplinaByCriteria(DisciplinaCriteria disciplinaCriteria) {
		return disciplinaCriteria.listDisciplina();
	}
}
