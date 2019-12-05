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

public class TurmaDAO {
	public static Turma loadTurmaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadTurmaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma getTurmaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getTurmaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma loadTurmaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadTurmaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma getTurmaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getTurmaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma loadTurmaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Turma) session.load(br.com.fes.scoa.model.Turma.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma getTurmaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Turma) session.get(br.com.fes.scoa.model.Turma.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma loadTurmaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Turma) session.load(br.com.fes.scoa.model.Turma.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma getTurmaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Turma) session.get(br.com.fes.scoa.model.Turma.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTurma(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryTurma(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTurma(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryTurma(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma[] listTurmaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listTurmaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma[] listTurmaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listTurmaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTurma(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Turma as Turma");
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
	
	public static List queryTurma(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Turma as Turma");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Turma", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma[] listTurmaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTurma(session, condition, orderBy);
			return (Turma[]) list.toArray(new Turma[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma[] listTurmaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTurma(session, condition, orderBy, lockMode);
			return (Turma[]) list.toArray(new Turma[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma loadTurmaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadTurmaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma loadTurmaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadTurmaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma loadTurmaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Turma[] turmas = listTurmaByQuery(session, condition, orderBy);
		if (turmas != null && turmas.length > 0)
			return turmas[0];
		else
			return null;
	}
	
	public static Turma loadTurmaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Turma[] turmas = listTurmaByQuery(session, condition, orderBy, lockMode);
		if (turmas != null && turmas.length > 0)
			return turmas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTurmaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateTurmaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTurmaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateTurmaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTurmaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Turma as Turma");
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
	
	public static java.util.Iterator iterateTurmaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Turma as Turma");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Turma", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma createTurma() {
		return new br.com.fes.scoa.model.Turma();
	}
	
	public static boolean save(br.com.fes.scoa.model.Turma turma) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(turma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Turma turma) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(turma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Turma turma)throws PersistentException {
		try {
			if (turma.getDisciplina() != null) {
				turma.getDisciplina().turma.remove(turma);
			}
			
			if (turma.getProfessor() != null) {
				turma.getProfessor().turma.remove(turma);
			}
			
			br.com.fes.scoa.model.Alocacao_sala_turma[] lAlocacao_sala_turmas = turma.alocacao_sala_turma.toArray();
			for(int i = 0; i < lAlocacao_sala_turmas.length; i++) {
				lAlocacao_sala_turmas[i].setTurma(null);
			}
			br.com.fes.scoa.model.Inscricao_aluno[] lInscricao_alunos = turma.inscricao_aluno.toArray();
			for(int i = 0; i < lInscricao_alunos.length; i++) {
				lInscricao_alunos[i].setTurma(null);
			}
			return delete(turma);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Turma turma, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (turma.getDisciplina() != null) {
				turma.getDisciplina().turma.remove(turma);
			}
			
			if (turma.getProfessor() != null) {
				turma.getProfessor().turma.remove(turma);
			}
			
			br.com.fes.scoa.model.Alocacao_sala_turma[] lAlocacao_sala_turmas = turma.alocacao_sala_turma.toArray();
			for(int i = 0; i < lAlocacao_sala_turmas.length; i++) {
				lAlocacao_sala_turmas[i].setTurma(null);
			}
			br.com.fes.scoa.model.Inscricao_aluno[] lInscricao_alunos = turma.inscricao_aluno.toArray();
			for(int i = 0; i < lInscricao_alunos.length; i++) {
				lInscricao_alunos[i].setTurma(null);
			}
			try {
				session.delete(turma);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Turma turma) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(turma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Turma turma) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(turma);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Turma loadTurmaByCriteria(TurmaCriteria turmaCriteria) {
		Turma[] turmas = listTurmaByCriteria(turmaCriteria);
		if(turmas == null || turmas.length == 0) {
			return null;
		}
		return turmas[0];
	}
	
	public static Turma[] listTurmaByCriteria(TurmaCriteria turmaCriteria) {
		return turmaCriteria.listTurma();
	}
}
