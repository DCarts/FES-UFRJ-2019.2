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

public class CursoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nome;
	public final StringExpression descricao;
	public final CollectionExpression disciplina;
	public final CollectionExpression aluno;
	public final CollectionExpression secretario;
	
	public CursoDetachedCriteria() {
		super(br.com.fes.scoa.model.Curso.class, br.com.fes.scoa.model.CursoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		disciplina = new CollectionExpression("ORM_Disciplina", this.getDetachedCriteria());
		aluno = new CollectionExpression("ORM_Aluno", this.getDetachedCriteria());
		secretario = new CollectionExpression("ORM_Secretario", this.getDetachedCriteria());
	}
	
	public CursoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.CursoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		disciplina = new CollectionExpression("ORM_Disciplina", this.getDetachedCriteria());
		aluno = new CollectionExpression("ORM_Aluno", this.getDetachedCriteria());
		secretario = new CollectionExpression("ORM_Secretario", this.getDetachedCriteria());
	}
	
	public DisciplinaDetachedCriteria createDisciplinaCriteria() {
		return new DisciplinaDetachedCriteria(createCriteria("ORM_Disciplina"));
	}
	
	public AlunoDetachedCriteria createAlunoCriteria() {
		return new AlunoDetachedCriteria(createCriteria("ORM_Aluno"));
	}
	
	public SecretarioDetachedCriteria createSecretarioCriteria() {
		return new SecretarioDetachedCriteria(createCriteria("ORM_Secretario"));
	}
	
	public Curso uniqueCurso(PersistentSession session) {
		return (Curso) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Curso[] listCurso(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Curso[]) list.toArray(new Curso[list.size()]);
	}
}

