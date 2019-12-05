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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

public class CursoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final StringExpression descricao;
	public final CollectionExpression disciplina;
	public final CollectionExpression aluno;
	public final CollectionExpression secretario;
	
	public CursoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		descricao = new StringExpression("descricao", this);
		disciplina = new CollectionExpression("ORM_Disciplina", this);
		aluno = new CollectionExpression("ORM_Aluno", this);
		secretario = new CollectionExpression("ORM_Secretario", this);
	}
	
	public CursoCriteria(PersistentSession session) {
		this(session.createCriteria(Curso.class));
	}
	
	public CursoCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public DisciplinaCriteria createDisciplinaCriteria() {
		return new DisciplinaCriteria(createCriteria("ORM_Disciplina"));
	}
	
	public AlunoCriteria createAlunoCriteria() {
		return new AlunoCriteria(createCriteria("ORM_Aluno"));
	}
	
	public SecretarioCriteria createSecretarioCriteria() {
		return new SecretarioCriteria(createCriteria("ORM_Secretario"));
	}
	
	public Curso uniqueCurso() {
		return (Curso) super.uniqueResult();
	}
	
	public Curso[] listCurso() {
		java.util.List list = super.list();
		return (Curso[]) list.toArray(new Curso[list.size()]);
	}
}

