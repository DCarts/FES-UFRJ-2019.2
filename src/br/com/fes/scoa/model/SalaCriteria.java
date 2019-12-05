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

public class SalaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression codLocalizacao;
	public final CollectionExpression alocacao_sala_turma;
	
	public SalaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		codLocalizacao = new StringExpression("codLocalizacao", this);
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this);
	}
	
	public SalaCriteria(PersistentSession session) {
		this(session.createCriteria(Sala.class));
	}
	
	public SalaCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public Alocacao_sala_turmaCriteria createAlocacao_sala_turmaCriteria() {
		return new Alocacao_sala_turmaCriteria(createCriteria("ORM_Alocacao_sala_turma"));
	}
	
	public Sala uniqueSala() {
		return (Sala) super.uniqueResult();
	}
	
	public Sala[] listSala() {
		java.util.List list = super.list();
		return (Sala[]) list.toArray(new Sala[list.size()]);
	}
}

