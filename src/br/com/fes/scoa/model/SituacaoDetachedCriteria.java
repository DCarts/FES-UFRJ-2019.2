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

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import java.util.List;

public class SituacaoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final CollectionExpression inscricao_aluno;
	
	public SituacaoDetachedCriteria() {
		super(br.com.fes.scoa.model.Situacao.class, br.com.fes.scoa.model.SituacaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this.getDetachedCriteria());
	}
	
	public SituacaoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.SituacaoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this.getDetachedCriteria());
	}
	
	public Inscricao_alunoDetachedCriteria createInscricao_alunoCriteria() {
		return new Inscricao_alunoDetachedCriteria(createCriteria("ORM_Inscricao_aluno"));
	}
	
	public Situacao uniqueSituacao(PersistentSession session) {
		return (Situacao) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Situacao[] listSituacao(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Situacao[]) list.toArray(new Situacao[list.size()]);
	}
}

