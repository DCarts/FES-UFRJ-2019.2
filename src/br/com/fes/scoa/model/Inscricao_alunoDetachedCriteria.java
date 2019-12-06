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
import org.orm.criteria.BigDecimalExpression;
import org.orm.criteria.IntegerExpression;

import java.util.List;

public class Inscricao_alunoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression turmaId;
	public final AssociationExpression turma;
	public final IntegerExpression alunoId;
	public final AssociationExpression aluno;
	public final BigDecimalExpression nota;
	public final BigDecimalExpression frequencia;
	public final IntegerExpression situacaoId;
	public final AssociationExpression situacao;
	
	public Inscricao_alunoDetachedCriteria() {
		super(br.com.fes.scoa.model.Inscricao_aluno.class, br.com.fes.scoa.model.Inscricao_alunoCriteria.class);
		turmaId = new IntegerExpression("ORM_Turma.id", this.getDetachedCriteria());
		turma = new AssociationExpression("ORM_Turma", this.getDetachedCriteria());
		alunoId = new IntegerExpression("ORM_Aluno.", this.getDetachedCriteria());
		aluno = new AssociationExpression("ORM_Aluno", this.getDetachedCriteria());
		nota = new BigDecimalExpression("nota", this.getDetachedCriteria());
		frequencia = new BigDecimalExpression("frequencia", this.getDetachedCriteria());
		situacaoId = new IntegerExpression("situacao.id", this.getDetachedCriteria());
		situacao = new AssociationExpression("situacao", this.getDetachedCriteria());
	}
	
	public Inscricao_alunoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.Inscricao_alunoCriteria.class);
		turmaId = new IntegerExpression("ORM_Turma.id", this.getDetachedCriteria());
		turma = new AssociationExpression("ORM_Turma", this.getDetachedCriteria());
		alunoId = new IntegerExpression("ORM_Aluno.", this.getDetachedCriteria());
		aluno = new AssociationExpression("ORM_Aluno", this.getDetachedCriteria());
		nota = new BigDecimalExpression("nota", this.getDetachedCriteria());
		frequencia = new BigDecimalExpression("frequencia", this.getDetachedCriteria());
		situacaoId = new IntegerExpression("situacao.id", this.getDetachedCriteria());
		situacao = new AssociationExpression("situacao", this.getDetachedCriteria());
	}
	
	public TurmaDetachedCriteria createTurmaCriteria() {
		return new TurmaDetachedCriteria(createCriteria("ORM_Turma"));
	}
	
	public AlunoDetachedCriteria createAlunoCriteria() {
		return new AlunoDetachedCriteria(createCriteria("ORM_Aluno"));
	}
	
	public SituacaoDetachedCriteria createSituacaoCriteria() {
		return new SituacaoDetachedCriteria(createCriteria("situacao"));
	}
	
	public Inscricao_aluno uniqueInscricao_aluno(PersistentSession session) {
		return (Inscricao_aluno) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Inscricao_aluno[] listInscricao_aluno(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Inscricao_aluno[]) list.toArray(new Inscricao_aluno[list.size()]);
	}
}

