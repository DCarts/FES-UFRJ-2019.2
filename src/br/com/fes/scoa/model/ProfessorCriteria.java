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
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;

public class ProfessorCriteria extends AbstractORMCriteria {
	public final IntegerExpression pessoaId;
	public final AssociationExpression pessoa;
	public final IntegerExpression area_disciplinaId;
	public final AssociationExpression area_disciplina;
	public final CollectionExpression turma;
	
	public ProfessorCriteria(Criteria criteria) {
		super(criteria);
		pessoaId = new IntegerExpression("pessoa.id", this);
		pessoa = new AssociationExpression("pessoa", this);
		area_disciplinaId = new IntegerExpression("area_disciplina.id", this);
		area_disciplina = new AssociationExpression("area_disciplina", this);
		turma = new CollectionExpression("ORM_Turma", this);
	}
	
	public ProfessorCriteria(PersistentSession session) {
		this(session.createCriteria(Professor.class));
	}
	
	public ProfessorCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public PessoaCriteria createPessoaCriteria() {
		return new PessoaCriteria(createCriteria("pessoa"));
	}
	
	public Area_disciplinaCriteria createArea_disciplinaCriteria() {
		return new Area_disciplinaCriteria(createCriteria("area_disciplina"));
	}
	
	public TurmaCriteria createTurmaCriteria() {
		return new TurmaCriteria(createCriteria("ORM_Turma"));
	}
	
	public Professor uniqueProfessor() {
		return (Professor) super.uniqueResult();
	}
	
	public Professor[] listProfessor() {
		java.util.List list = super.list();
		return (Professor[]) list.toArray(new Professor[list.size()]);
	}
}

