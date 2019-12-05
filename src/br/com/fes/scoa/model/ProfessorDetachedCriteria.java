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
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;

import java.util.List;

public class ProfessorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression pessoaId;
	public final AssociationExpression pessoa;
	public final IntegerExpression area_disciplinaId;
	public final AssociationExpression area_disciplina;
	public final CollectionExpression turma;
	
	public ProfessorDetachedCriteria() {
		super(br.com.fes.scoa.model.Professor.class, br.com.fes.scoa.model.ProfessorCriteria.class);
		pessoaId = new IntegerExpression("pessoa.id", this.getDetachedCriteria());
		pessoa = new AssociationExpression("pessoa", this.getDetachedCriteria());
		area_disciplinaId = new IntegerExpression("area_disciplina.id", this.getDetachedCriteria());
		area_disciplina = new AssociationExpression("area_disciplina", this.getDetachedCriteria());
		turma = new CollectionExpression("ORM_Turma", this.getDetachedCriteria());
	}
	
	public ProfessorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.ProfessorCriteria.class);
		pessoaId = new IntegerExpression("pessoa.id", this.getDetachedCriteria());
		pessoa = new AssociationExpression("pessoa", this.getDetachedCriteria());
		area_disciplinaId = new IntegerExpression("area_disciplina.id", this.getDetachedCriteria());
		area_disciplina = new AssociationExpression("area_disciplina", this.getDetachedCriteria());
		turma = new CollectionExpression("ORM_Turma", this.getDetachedCriteria());
	}
	
	public PessoaDetachedCriteria createPessoaCriteria() {
		return new PessoaDetachedCriteria(createCriteria("pessoa"));
	}
	
	public Area_disciplinaDetachedCriteria createArea_disciplinaCriteria() {
		return new Area_disciplinaDetachedCriteria(createCriteria("area_disciplina"));
	}
	
	public TurmaDetachedCriteria createTurmaCriteria() {
		return new TurmaDetachedCriteria(createCriteria("ORM_Turma"));
	}
	
	public Professor uniqueProfessor(PersistentSession session) {
		return (Professor) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Professor[] listProfessor(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Professor[]) list.toArray(new Professor[list.size()]);
	}
}

