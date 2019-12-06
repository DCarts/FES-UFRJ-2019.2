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

public class DisciplinaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression area_disciplinaId;
	public final AssociationExpression area_disciplina;
	public final IntegerExpression cursoId;
	public final AssociationExpression curso;
	public final StringExpression codigo;
	public final StringExpression nome;
	public final StringExpression descricao;
	public final IntegerExpression creditos;
	public final CollectionExpression disciplina1;
	public final CollectionExpression disciplina;
	public final CollectionExpression disciplina2;
	public final CollectionExpression prerequisito;
	public final CollectionExpression turma;
	
	public DisciplinaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		area_disciplinaId = new IntegerExpression("area_disciplina.id", this);
		area_disciplina = new AssociationExpression("area_disciplina", this);
		cursoId = new IntegerExpression("curso.id", this);
		curso = new AssociationExpression("curso", this);
		codigo = new StringExpression("codigo", this);
		nome = new StringExpression("nome", this);
		descricao = new StringExpression("descricao", this);
		creditos = new IntegerExpression("creditos", this);
		disciplina1 = new CollectionExpression("ORM_Disciplina1", this);
		disciplina = new CollectionExpression("ORM_Disciplina", this);
		disciplina2 = new CollectionExpression("ORM_Disciplina2", this);
		prerequisito = new CollectionExpression("ORM_Prerequisito", this);
		turma = new CollectionExpression("ORM_Turma", this);
	}
	
	public DisciplinaCriteria(PersistentSession session) {
		this(session.createCriteria(Disciplina.class));
	}
	
	public DisciplinaCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public Area_disciplinaCriteria createArea_disciplinaCriteria() {
		return new Area_disciplinaCriteria(createCriteria("area_disciplina"));
	}
	
	public CursoCriteria createCursoCriteria() {
		return new CursoCriteria(createCriteria("curso"));
	}
	
	public DisciplinaCriteria createDisciplina1Criteria() {
		return new DisciplinaCriteria(createCriteria("ORM_Disciplina1"));
	}
	
	public DisciplinaCriteria createDisciplinaCriteria() {
		return new DisciplinaCriteria(createCriteria("ORM_Disciplina"));
	}
	
	public DisciplinaCriteria createDisciplina2Criteria() {
		return new DisciplinaCriteria(createCriteria("ORM_Disciplina2"));
	}
	
	public DisciplinaCriteria createPrerequisitoCriteria() {
		return new DisciplinaCriteria(createCriteria("ORM_Prerequisito"));
	}
	
	public TurmaCriteria createTurmaCriteria() {
		return new TurmaCriteria(createCriteria("ORM_Turma"));
	}
	
	public Disciplina uniqueDisciplina() {
		return (Disciplina) super.uniqueResult();
	}
	
	public Disciplina[] listDisciplina() {
		java.util.List list = super.list();
		return (Disciplina[]) list.toArray(new Disciplina[list.size()]);
	}
}

