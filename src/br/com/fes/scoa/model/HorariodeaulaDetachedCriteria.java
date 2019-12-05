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
import org.orm.criteria.*;

import java.util.List;

public class HorariodeaulaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression dia;
	public final TimeExpression horarioFim;
	public final TimeExpression horarioInicio;
	public final CollectionExpression alocacao_sala_turma;
	
	public HorariodeaulaDetachedCriteria() {
		super(br.com.fes.scoa.model.Horariodeaula.class, br.com.fes.scoa.model.HorariodeaulaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		dia = new StringExpression("dia", this.getDetachedCriteria());
		horarioFim = new TimeExpression("horarioFim", this.getDetachedCriteria());
		horarioInicio = new TimeExpression("horarioInicio", this.getDetachedCriteria());
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this.getDetachedCriteria());
	}
	
	public HorariodeaulaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.HorariodeaulaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		dia = new StringExpression("dia", this.getDetachedCriteria());
		horarioFim = new TimeExpression("horarioFim", this.getDetachedCriteria());
		horarioInicio = new TimeExpression("horarioInicio", this.getDetachedCriteria());
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this.getDetachedCriteria());
	}
	
	public Alocacao_sala_turmaDetachedCriteria createAlocacao_sala_turmaCriteria() {
		return new Alocacao_sala_turmaDetachedCriteria(createCriteria("ORM_Alocacao_sala_turma"));
	}
	
	public Horariodeaula uniqueHorariodeaula(PersistentSession session) {
		return (Horariodeaula) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Horariodeaula[] listHorariodeaula(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Horariodeaula[]) list.toArray(new Horariodeaula[list.size()]);
	}
}

