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

public class Area_disciplinaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final StringExpression descricao;
	public final CollectionExpression professor;
	public final CollectionExpression disciplina;
	
	public Area_disciplinaDetachedCriteria() {
		super(br.com.fes.scoa.model.Area_disciplina.class, br.com.fes.scoa.model.Area_disciplinaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		professor = new CollectionExpression("ORM_Professor", this.getDetachedCriteria());
		disciplina = new CollectionExpression("ORM_Disciplina", this.getDetachedCriteria());
	}
	
	public Area_disciplinaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.Area_disciplinaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		professor = new CollectionExpression("ORM_Professor", this.getDetachedCriteria());
		disciplina = new CollectionExpression("ORM_Disciplina", this.getDetachedCriteria());
	}
	
	public ProfessorDetachedCriteria createProfessorCriteria() {
		return new ProfessorDetachedCriteria(createCriteria("ORM_Professor"));
	}
	
	public DisciplinaDetachedCriteria createDisciplinaCriteria() {
		return new DisciplinaDetachedCriteria(createCriteria("ORM_Disciplina"));
	}
	
	public Area_disciplina uniqueArea_disciplina(PersistentSession session) {
		return (Area_disciplina) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Area_disciplina[] listArea_disciplina(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Area_disciplina[]) list.toArray(new Area_disciplina[list.size()]);
	}
}

