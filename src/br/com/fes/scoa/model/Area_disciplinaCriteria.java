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

public class Area_disciplinaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final StringExpression descricao;
	public final CollectionExpression professor;
	public final CollectionExpression disciplina;
	
	public Area_disciplinaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nome = new StringExpression("nome", this);
		descricao = new StringExpression("descricao", this);
		professor = new CollectionExpression("ORM_Professor", this);
		disciplina = new CollectionExpression("ORM_Disciplina", this);
	}
	
	public Area_disciplinaCriteria(PersistentSession session) {
		this(session.createCriteria(Area_disciplina.class));
	}
	
	public Area_disciplinaCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public ProfessorCriteria createProfessorCriteria() {
		return new ProfessorCriteria(createCriteria("ORM_Professor"));
	}
	
	public DisciplinaCriteria createDisciplinaCriteria() {
		return new DisciplinaCriteria(createCriteria("ORM_Disciplina"));
	}
	
	public Area_disciplina uniqueArea_disciplina() {
		return (Area_disciplina) super.uniqueResult();
	}
	
	public Area_disciplina[] listArea_disciplina() {
		java.util.List list = super.list();
		return (Area_disciplina[]) list.toArray(new Area_disciplina[list.size()]);
	}
}

