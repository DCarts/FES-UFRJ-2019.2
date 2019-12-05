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
import org.orm.criteria.*;

public class HorariodeaulaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression dia;
	public final TimeExpression horarioFim;
	public final TimeExpression horarioInicio;
	public final CollectionExpression alocacao_sala_turma;
	
	public HorariodeaulaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		dia = new StringExpression("dia", this);
		horarioFim = new TimeExpression("horarioFim", this);
		horarioInicio = new TimeExpression("horarioInicio", this);
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this);
	}
	
	public HorariodeaulaCriteria(PersistentSession session) {
		this(session.createCriteria(Horariodeaula.class));
	}
	
	public HorariodeaulaCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public Alocacao_sala_turmaCriteria createAlocacao_sala_turmaCriteria() {
		return new Alocacao_sala_turmaCriteria(createCriteria("ORM_Alocacao_sala_turma"));
	}
	
	public Horariodeaula uniqueHorariodeaula() {
		return (Horariodeaula) super.uniqueResult();
	}
	
	public Horariodeaula[] listHorariodeaula() {
		java.util.List list = super.list();
		return (Horariodeaula[]) list.toArray(new Horariodeaula[list.size()]);
	}
}

