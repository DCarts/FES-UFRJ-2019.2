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

public class SituacaoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final CollectionExpression inscricao_aluno;
	
	public SituacaoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this);
	}
	
	public SituacaoCriteria(PersistentSession session) {
		this(session.createCriteria(Situacao.class));
	}
	
	public SituacaoCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public Inscricao_alunoCriteria createInscricao_alunoCriteria() {
		return new Inscricao_alunoCriteria(createCriteria("ORM_Inscricao_aluno"));
	}
	
	public Situacao uniqueSituacao() {
		return (Situacao) super.uniqueResult();
	}
	
	public Situacao[] listSituacao() {
		java.util.List list = super.list();
		return (Situacao[]) list.toArray(new Situacao[list.size()]);
	}
}

