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

public class Inscricao_alunoDAO {
	public static Inscricao_aluno loadInscricao_alunoByORMID(br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Aluno aluno) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadInscricao_alunoByORMID(session, turma, aluno);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno getInscricao_alunoByORMID(br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Aluno aluno) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getInscricao_alunoByORMID(session, turma, aluno);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno loadInscricao_alunoByORMID(br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Aluno aluno, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadInscricao_alunoByORMID(session, turma, aluno, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno getInscricao_alunoByORMID(br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Aluno aluno, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return getInscricao_alunoByORMID(session, turma, aluno, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno loadInscricao_alunoByORMID(PersistentSession session, br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Aluno aluno) throws PersistentException {
		try {
			Inscricao_aluno inscricao_aluno = new br.com.fes.scoa.model.Inscricao_aluno();
			inscricao_aluno.setORM_Turma(turma);
			inscricao_aluno.setORM_Aluno(aluno);
			
			return (Inscricao_aluno) session.load(br.com.fes.scoa.model.Inscricao_aluno.class, inscricao_aluno);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno getInscricao_alunoByORMID(PersistentSession session, br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Aluno aluno) throws PersistentException {
		try {
			Inscricao_aluno inscricao_aluno = new br.com.fes.scoa.model.Inscricao_aluno();
			inscricao_aluno.setORM_Turma(turma);
			inscricao_aluno.setORM_Aluno(aluno);
			
			return (Inscricao_aluno) session.get(br.com.fes.scoa.model.Inscricao_aluno.class, inscricao_aluno);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno loadInscricao_alunoByORMID(PersistentSession session, br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Aluno aluno, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Inscricao_aluno inscricao_aluno = new br.com.fes.scoa.model.Inscricao_aluno();
			inscricao_aluno.setORM_Turma(turma);
			inscricao_aluno.setORM_Aluno(aluno);
			
			return (Inscricao_aluno) session.load(br.com.fes.scoa.model.Inscricao_aluno.class, inscricao_aluno, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno getInscricao_alunoByORMID(PersistentSession session, br.com.fes.scoa.model.Turma turma, br.com.fes.scoa.model.Aluno aluno, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Inscricao_aluno inscricao_aluno = new br.com.fes.scoa.model.Inscricao_aluno();
			inscricao_aluno.setORM_Turma(turma);
			inscricao_aluno.setORM_Aluno(aluno);
			
			return (Inscricao_aluno) session.get(br.com.fes.scoa.model.Inscricao_aluno.class, inscricao_aluno, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInscricao_aluno(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryInscricao_aluno(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInscricao_aluno(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryInscricao_aluno(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno[] listInscricao_alunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listInscricao_alunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno[] listInscricao_alunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listInscricao_alunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryInscricao_aluno(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Inscricao_aluno as Inscricao_aluno");
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
	
	public static List queryInscricao_aluno(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Inscricao_aluno as Inscricao_aluno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Inscricao_aluno", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno[] listInscricao_alunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryInscricao_aluno(session, condition, orderBy);
			return (Inscricao_aluno[]) list.toArray(new Inscricao_aluno[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno[] listInscricao_alunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryInscricao_aluno(session, condition, orderBy, lockMode);
			return (Inscricao_aluno[]) list.toArray(new Inscricao_aluno[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno loadInscricao_alunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadInscricao_alunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno loadInscricao_alunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadInscricao_alunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno loadInscricao_alunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Inscricao_aluno[] inscricao_alunos = listInscricao_alunoByQuery(session, condition, orderBy);
		if (inscricao_alunos != null && inscricao_alunos.length > 0)
			return inscricao_alunos[0];
		else
			return null;
	}
	
	public static Inscricao_aluno loadInscricao_alunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Inscricao_aluno[] inscricao_alunos = listInscricao_alunoByQuery(session, condition, orderBy, lockMode);
		if (inscricao_alunos != null && inscricao_alunos.length > 0)
			return inscricao_alunos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateInscricao_alunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateInscricao_alunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInscricao_alunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateInscricao_alunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateInscricao_alunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Inscricao_aluno as Inscricao_aluno");
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
	
	public static java.util.Iterator iterateInscricao_alunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Inscricao_aluno as Inscricao_aluno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Inscricao_aluno", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno createInscricao_aluno() {
		return new br.com.fes.scoa.model.Inscricao_aluno();
	}
	
	public static boolean save(br.com.fes.scoa.model.Inscricao_aluno inscricao_aluno) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(inscricao_aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Inscricao_aluno inscricao_aluno) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(inscricao_aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Inscricao_aluno inscricao_aluno)throws PersistentException {
		try {
			br.com.fes.scoa.model.Turma turma = inscricao_aluno.getTurma();
			if (inscricao_aluno.getTurma() != null) {
				inscricao_aluno.getTurma().inscricao_aluno.remove(inscricao_aluno);
			}
			inscricao_aluno.setORM_Turma(turma);
			
			br.com.fes.scoa.model.Aluno aluno = inscricao_aluno.getAluno();
			if (inscricao_aluno.getAluno() != null) {
				inscricao_aluno.getAluno().inscricao_aluno.remove(inscricao_aluno);
			}
			inscricao_aluno.setORM_Aluno(aluno);
			
			if (inscricao_aluno.getSituacao() != null) {
				inscricao_aluno.getSituacao().inscricao_aluno.remove(inscricao_aluno);
			}
			
			return delete(inscricao_aluno);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Inscricao_aluno inscricao_aluno, org.orm.PersistentSession session)throws PersistentException {
		try {
			br.com.fes.scoa.model.Turma turma = inscricao_aluno.getTurma();
			if (inscricao_aluno.getTurma() != null) {
				inscricao_aluno.getTurma().inscricao_aluno.remove(inscricao_aluno);
			}
			inscricao_aluno.setORM_Turma(turma);
			
			br.com.fes.scoa.model.Aluno aluno = inscricao_aluno.getAluno();
			if (inscricao_aluno.getAluno() != null) {
				inscricao_aluno.getAluno().inscricao_aluno.remove(inscricao_aluno);
			}
			inscricao_aluno.setORM_Aluno(aluno);
			
			if (inscricao_aluno.getSituacao() != null) {
				inscricao_aluno.getSituacao().inscricao_aluno.remove(inscricao_aluno);
			}
			
			try {
				session.delete(inscricao_aluno);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Inscricao_aluno inscricao_aluno) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(inscricao_aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Inscricao_aluno inscricao_aluno) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(inscricao_aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Inscricao_aluno loadInscricao_alunoByCriteria(Inscricao_alunoCriteria inscricao_alunoCriteria) {
		Inscricao_aluno[] inscricao_alunos = listInscricao_alunoByCriteria(inscricao_alunoCriteria);
		if(inscricao_alunos == null || inscricao_alunos.length == 0) {
			return null;
		}
		return inscricao_alunos[0];
	}
	
	public static Inscricao_aluno[] listInscricao_alunoByCriteria(Inscricao_alunoCriteria inscricao_alunoCriteria) {
		return inscricao_alunoCriteria.listInscricao_aluno();
	}
}
