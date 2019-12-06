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

public class DisciplinaDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public DisciplinaDetachedCriteria() {
		super(br.com.fes.scoa.model.Disciplina.class, br.com.fes.scoa.model.DisciplinaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		area_disciplinaId = new IntegerExpression("area_disciplina.id", this.getDetachedCriteria());
		area_disciplina = new AssociationExpression("area_disciplina", this.getDetachedCriteria());
		cursoId = new IntegerExpression("curso.id", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
		codigo = new StringExpression("codigo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		creditos = new IntegerExpression("creditos", this.getDetachedCriteria());
		disciplina1 = new CollectionExpression("ORM_Disciplina1", this.getDetachedCriteria());
		disciplina = new CollectionExpression("ORM_Disciplina", this.getDetachedCriteria());
		disciplina2 = new CollectionExpression("ORM_Disciplina2", this.getDetachedCriteria());
		prerequisito = new CollectionExpression("ORM_Prerequisito", this.getDetachedCriteria());
		turma = new CollectionExpression("ORM_Turma", this.getDetachedCriteria());
	}
	
	public DisciplinaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.DisciplinaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		area_disciplinaId = new IntegerExpression("area_disciplina.id", this.getDetachedCriteria());
		area_disciplina = new AssociationExpression("area_disciplina", this.getDetachedCriteria());
		cursoId = new IntegerExpression("curso.id", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
		codigo = new StringExpression("codigo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		creditos = new IntegerExpression("creditos", this.getDetachedCriteria());
		disciplina1 = new CollectionExpression("ORM_Disciplina1", this.getDetachedCriteria());
		disciplina = new CollectionExpression("ORM_Disciplina", this.getDetachedCriteria());
		disciplina2 = new CollectionExpression("ORM_Disciplina2", this.getDetachedCriteria());
		prerequisito = new CollectionExpression("ORM_Prerequisito", this.getDetachedCriteria());
		turma = new CollectionExpression("ORM_Turma", this.getDetachedCriteria());
	}
	
	public Area_disciplinaDetachedCriteria createArea_disciplinaCriteria() {
		return new Area_disciplinaDetachedCriteria(createCriteria("area_disciplina"));
	}
	
	public CursoDetachedCriteria createCursoCriteria() {
		return new CursoDetachedCriteria(createCriteria("curso"));
	}
	
	public DisciplinaDetachedCriteria createDisciplina1Criteria() {
		return new DisciplinaDetachedCriteria(createCriteria("ORM_Disciplina1"));
	}
	
	public DisciplinaDetachedCriteria createDisciplinaCriteria() {
		return new DisciplinaDetachedCriteria(createCriteria("ORM_Disciplina"));
	}
	
	public DisciplinaDetachedCriteria createDisciplina2Criteria() {
		return new DisciplinaDetachedCriteria(createCriteria("ORM_Disciplina2"));
	}
	
	public DisciplinaDetachedCriteria createPrerequisitoCriteria() {
		return new DisciplinaDetachedCriteria(createCriteria("ORM_Prerequisito"));
	}
	
	public TurmaDetachedCriteria createTurmaCriteria() {
		return new TurmaDetachedCriteria(createCriteria("ORM_Turma"));
	}
	
	public Disciplina uniqueDisciplina(PersistentSession session) {
		return (Disciplina) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Disciplina[] listDisciplina(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Disciplina[]) list.toArray(new Disciplina[list.size()]);
	}
}

