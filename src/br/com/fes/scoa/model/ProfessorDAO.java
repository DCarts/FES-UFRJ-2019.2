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

public class ProfessorDAO {
	public static List queryProfessor(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryProfessor(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProfessor(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryProfessor(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor[] listProfessorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listProfessorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor[] listProfessorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listProfessorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProfessor(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Professor as Professor");
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
	
	public static List queryProfessor(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Professor as Professor");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Professor", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor[] listProfessorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProfessor(session, condition, orderBy);
			return (Professor[]) list.toArray(new Professor[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor[] listProfessorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProfessor(session, condition, orderBy, lockMode);
			return (Professor[]) list.toArray(new Professor[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor loadProfessorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadProfessorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor loadProfessorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadProfessorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor loadProfessorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Professor[] professors = listProfessorByQuery(session, condition, orderBy);
		if (professors != null && professors.length > 0)
			return professors[0];
		else
			return null;
	}
	
	public static Professor loadProfessorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Professor[] professors = listProfessorByQuery(session, condition, orderBy, lockMode);
		if (professors != null && professors.length > 0)
			return professors[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProfessorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateProfessorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProfessorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateProfessorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProfessorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Professor as Professor");
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
	
	public static java.util.Iterator iterateProfessorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Professor as Professor");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Professor", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor createProfessor() {
		return new br.com.fes.scoa.model.Professor();
	}
	
	public static boolean save(br.com.fes.scoa.model.Professor professor) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(professor);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Professor professor) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(professor);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Professor professor)throws PersistentException {
		try {
			br.com.fes.scoa.model.Pessoa pessoa = professor.getPessoa();
			if (professor.getPessoa() != null) {
				professor.getPessoa().setProfessor(null);
			}
			professor.setPessoa(pessoa);
			
			if (professor.getArea_disciplina() != null) {
				professor.getArea_disciplina().professor.remove(professor);
			}
			
			br.com.fes.scoa.model.Turma[] lTurmas = professor.turma.toArray();
			for(int i = 0; i < lTurmas.length; i++) {
				lTurmas[i].setProfessor(null);
			}
			return delete(professor);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Professor professor, org.orm.PersistentSession session)throws PersistentException {
		try {
			br.com.fes.scoa.model.Pessoa pessoa = professor.getPessoa();
			if (professor.getPessoa() != null) {
				professor.getPessoa().setProfessor(null);
			}
			professor.setPessoa(pessoa);
			
			if (professor.getArea_disciplina() != null) {
				professor.getArea_disciplina().professor.remove(professor);
			}
			
			br.com.fes.scoa.model.Turma[] lTurmas = professor.turma.toArray();
			for(int i = 0; i < lTurmas.length; i++) {
				lTurmas[i].setProfessor(null);
			}
			try {
				session.delete(professor);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Professor professor) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(professor);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Professor professor) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(professor);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Professor loadProfessorByCriteria(ProfessorCriteria professorCriteria) {
		Professor[] professors = listProfessorByCriteria(professorCriteria);
		if(professors == null || professors.length == 0) {
			return null;
		}
		return professors[0];
	}
	
	public static Professor[] listProfessorByCriteria(ProfessorCriteria professorCriteria) {
		return professorCriteria.listProfessor();
	}
}
