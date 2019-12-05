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

public class SalaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression codLocalizacao;
	public final CollectionExpression alocacao_sala_turma;
	
	public SalaDetachedCriteria() {
		super(br.com.fes.scoa.model.Sala.class, br.com.fes.scoa.model.SalaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		codLocalizacao = new StringExpression("codLocalizacao", this.getDetachedCriteria());
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this.getDetachedCriteria());
	}
	
	public SalaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.SalaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		codLocalizacao = new StringExpression("codLocalizacao", this.getDetachedCriteria());
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this.getDetachedCriteria());
	}
	
	public Alocacao_sala_turmaDetachedCriteria createAlocacao_sala_turmaCriteria() {
		return new Alocacao_sala_turmaDetachedCriteria(createCriteria("ORM_Alocacao_sala_turma"));
	}
	
	public Sala uniqueSala(PersistentSession session) {
		return (Sala) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sala[] listSala(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sala[]) list.toArray(new Sala[list.size()]);
	}
}

