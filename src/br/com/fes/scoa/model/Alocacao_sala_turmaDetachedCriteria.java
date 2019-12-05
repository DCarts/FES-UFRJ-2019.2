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
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.IntegerExpression;

import java.util.List;

public class Alocacao_sala_turmaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression turmaId;
	public final AssociationExpression turma;
	public final IntegerExpression salaId;
	public final AssociationExpression sala;
	public final IntegerExpression horaId;
	public final AssociationExpression hora;
	
	public Alocacao_sala_turmaDetachedCriteria() {
		super(br.com.fes.scoa.model.Alocacao_sala_turma.class, br.com.fes.scoa.model.Alocacao_sala_turmaCriteria.class);
		turmaId = new IntegerExpression("ORM_Turma.id", this.getDetachedCriteria());
		turma = new AssociationExpression("ORM_Turma", this.getDetachedCriteria());
		salaId = new IntegerExpression("ORM_Sala.id", this.getDetachedCriteria());
		sala = new AssociationExpression("ORM_Sala", this.getDetachedCriteria());
		horaId = new IntegerExpression("ORM_Hora.id", this.getDetachedCriteria());
		hora = new AssociationExpression("ORM_Hora", this.getDetachedCriteria());
	}
	
	public Alocacao_sala_turmaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.Alocacao_sala_turmaCriteria.class);
		turmaId = new IntegerExpression("ORM_Turma.id", this.getDetachedCriteria());
		turma = new AssociationExpression("ORM_Turma", this.getDetachedCriteria());
		salaId = new IntegerExpression("ORM_Sala.id", this.getDetachedCriteria());
		sala = new AssociationExpression("ORM_Sala", this.getDetachedCriteria());
		horaId = new IntegerExpression("ORM_Hora.id", this.getDetachedCriteria());
		hora = new AssociationExpression("ORM_Hora", this.getDetachedCriteria());
	}
	
	public TurmaDetachedCriteria createTurmaCriteria() {
		return new TurmaDetachedCriteria(createCriteria("ORM_Turma"));
	}
	
	public SalaDetachedCriteria createSalaCriteria() {
		return new SalaDetachedCriteria(createCriteria("ORM_Sala"));
	}
	
	public HorariodeaulaDetachedCriteria createHoraCriteria() {
		return new HorariodeaulaDetachedCriteria(createCriteria("ORM_Hora"));
	}
	
	public Alocacao_sala_turma uniqueAlocacao_sala_turma(PersistentSession session) {
		return (Alocacao_sala_turma) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Alocacao_sala_turma[] listAlocacao_sala_turma(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Alocacao_sala_turma[]) list.toArray(new Alocacao_sala_turma[list.size()]);
	}
}

