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

public class AlunoDAO {
	public static List queryAluno(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryAluno(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAluno(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return queryAluno(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno[] listAlunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listAlunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno[] listAlunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return listAlunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAluno(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Aluno as Aluno");
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
	
	public static List queryAluno(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Aluno as Aluno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Aluno", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno[] listAlunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAluno(session, condition, orderBy);
			return (Aluno[]) list.toArray(new Aluno[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno[] listAlunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAluno(session, condition, orderBy, lockMode);
			return (Aluno[]) list.toArray(new Aluno[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadAlunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return loadAlunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Aluno[] alunos = listAlunoByQuery(session, condition, orderBy);
		if (alunos != null && alunos.length > 0)
			return alunos[0];
		else
			return null;
	}
	
	public static Aluno loadAlunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Aluno[] alunos = listAlunoByQuery(session, condition, orderBy, lockMode);
		if (alunos != null && alunos.length > 0)
			return alunos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAlunoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateAlunoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlunoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = SCOAPersistentManager.instance().getSession();
			return iterateAlunoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlunoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Aluno as Aluno");
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
	
	public static java.util.Iterator iterateAlunoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From br.com.fes.scoa.model.Aluno as Aluno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Aluno", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno createAluno() {
		return new br.com.fes.scoa.model.Aluno();
	}
	
	public static boolean save(br.com.fes.scoa.model.Aluno aluno) throws PersistentException {
		try {
			SCOAPersistentManager.instance().saveObject(aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(br.com.fes.scoa.model.Aluno aluno) throws PersistentException {
		try {
			SCOAPersistentManager.instance().deleteObject(aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Aluno aluno)throws PersistentException {
		try {
			br.com.fes.scoa.model.Pessoa pessoa = aluno.getPessoa();
			if (aluno.getPessoa() != null) {
				aluno.getPessoa().setAluno(null);
			}
			aluno.setPessoa(pessoa);
			
			if (aluno.getCurso() != null) {
				aluno.getCurso().aluno.remove(aluno);
			}
			
			br.com.fes.scoa.model.Inscricao_aluno[] lInscricao_alunos = aluno.inscricao_aluno.toArray();
			for(int i = 0; i < lInscricao_alunos.length; i++) {
				lInscricao_alunos[i].setAluno(null);
			}
			return delete(aluno);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(br.com.fes.scoa.model.Aluno aluno, org.orm.PersistentSession session)throws PersistentException {
		try {
			br.com.fes.scoa.model.Pessoa pessoa = aluno.getPessoa();
			if (aluno.getPessoa() != null) {
				aluno.getPessoa().setAluno(null);
			}
			aluno.setPessoa(pessoa);
			
			if (aluno.getCurso() != null) {
				aluno.getCurso().aluno.remove(aluno);
			}
			
			br.com.fes.scoa.model.Inscricao_aluno[] lInscricao_alunos = aluno.inscricao_aluno.toArray();
			for(int i = 0; i < lInscricao_alunos.length; i++) {
				lInscricao_alunos[i].setAluno(null);
			}
			try {
				session.delete(aluno);
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
	
	public static boolean refresh(br.com.fes.scoa.model.Aluno aluno) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().refresh(aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(br.com.fes.scoa.model.Aluno aluno) throws PersistentException {
		try {
			SCOAPersistentManager.instance().getSession().evict(aluno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Aluno loadAlunoByCriteria(AlunoCriteria alunoCriteria) {
		Aluno[] alunos = listAlunoByCriteria(alunoCriteria);
		if(alunos == null || alunos.length == 0) {
			return null;
		}
		return alunos[0];
	}
	
	public static Aluno[] listAlunoByCriteria(AlunoCriteria alunoCriteria) {
		return alunoCriteria.listAluno();
	}
}
