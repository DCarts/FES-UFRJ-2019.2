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

public class AlunoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression pessoaId;
	public final AssociationExpression pessoa;
	public final IntegerExpression cursoId;
	public final AssociationExpression curso;
	public final CollectionExpression inscricao_aluno;
	
	public AlunoDetachedCriteria() {
		super(br.com.fes.scoa.model.Aluno.class, br.com.fes.scoa.model.AlunoCriteria.class);
		pessoaId = new IntegerExpression("pessoa.id", this.getDetachedCriteria());
		pessoa = new AssociationExpression("pessoa", this.getDetachedCriteria());
		cursoId = new IntegerExpression("curso.id", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this.getDetachedCriteria());
	}
	
	public AlunoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.AlunoCriteria.class);
		pessoaId = new IntegerExpression("pessoa.id", this.getDetachedCriteria());
		pessoa = new AssociationExpression("pessoa", this.getDetachedCriteria());
		cursoId = new IntegerExpression("curso.id", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this.getDetachedCriteria());
	}
	
	public PessoaDetachedCriteria createPessoaCriteria() {
		return new PessoaDetachedCriteria(createCriteria("pessoa"));
	}
	
	public CursoDetachedCriteria createCursoCriteria() {
		return new CursoDetachedCriteria(createCriteria("curso"));
	}
	
	public Inscricao_alunoDetachedCriteria createInscricao_alunoCriteria() {
		return new Inscricao_alunoDetachedCriteria(createCriteria("ORM_Inscricao_aluno"));
	}
	
	public Aluno uniqueAluno(PersistentSession session) {
		return (Aluno) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Aluno[] listAluno(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Aluno[]) list.toArray(new Aluno[list.size()]);
	}
}

