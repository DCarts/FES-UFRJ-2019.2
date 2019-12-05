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
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.IntegerExpression;

public class Alocacao_sala_turmaCriteria extends AbstractORMCriteria {
	public final IntegerExpression turmaId;
	public final AssociationExpression turma;
	public final IntegerExpression salaId;
	public final AssociationExpression sala;
	public final IntegerExpression horaId;
	public final AssociationExpression hora;
	
	public Alocacao_sala_turmaCriteria(Criteria criteria) {
		super(criteria);
		turmaId = new IntegerExpression("ORM_Turma.id", this);
		turma = new AssociationExpression("ORM_Turma", this);
		salaId = new IntegerExpression("ORM_Sala.id", this);
		sala = new AssociationExpression("ORM_Sala", this);
		horaId = new IntegerExpression("ORM_Hora.id", this);
		hora = new AssociationExpression("ORM_Hora", this);
	}
	
	public Alocacao_sala_turmaCriteria(PersistentSession session) {
		this(session.createCriteria(Alocacao_sala_turma.class));
	}
	
	public Alocacao_sala_turmaCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public TurmaCriteria createTurmaCriteria() {
		return new TurmaCriteria(createCriteria("ORM_Turma"));
	}
	
	public SalaCriteria createSalaCriteria() {
		return new SalaCriteria(createCriteria("ORM_Sala"));
	}
	
	public HorariodeaulaCriteria createHoraCriteria() {
		return new HorariodeaulaCriteria(createCriteria("ORM_Hora"));
	}
	
	public Alocacao_sala_turma uniqueAlocacao_sala_turma() {
		return (Alocacao_sala_turma) super.uniqueResult();
	}
	
	public Alocacao_sala_turma[] listAlocacao_sala_turma() {
		java.util.List list = super.list();
		return (Alocacao_sala_turma[]) list.toArray(new Alocacao_sala_turma[list.size()]);
	}
}

