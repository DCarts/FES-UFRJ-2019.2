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
import org.orm.criteria.BigDecimalExpression;
import org.orm.criteria.IntegerExpression;

public class Inscricao_alunoCriteria extends AbstractORMCriteria {
	public final IntegerExpression turmaId;
	public final AssociationExpression turma;
	public final IntegerExpression alunoId;
	public final AssociationExpression aluno;
	public final BigDecimalExpression nota;
	public final IntegerExpression situacaoId;
	public final AssociationExpression situacao;
	
	public Inscricao_alunoCriteria(Criteria criteria) {
		super(criteria);
		turmaId = new IntegerExpression("ORM_Turma.id", this);
		turma = new AssociationExpression("ORM_Turma", this);
		alunoId = new IntegerExpression("ORM_Aluno.", this);
		aluno = new AssociationExpression("ORM_Aluno", this);
		nota = new BigDecimalExpression("nota", this);
		situacaoId = new IntegerExpression("situacao.id", this);
		situacao = new AssociationExpression("situacao", this);
	}
	
	public Inscricao_alunoCriteria(PersistentSession session) {
		this(session.createCriteria(Inscricao_aluno.class));
	}
	
	public Inscricao_alunoCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public TurmaCriteria createTurmaCriteria() {
		return new TurmaCriteria(createCriteria("ORM_Turma"));
	}
	
	public AlunoCriteria createAlunoCriteria() {
		return new AlunoCriteria(createCriteria("ORM_Aluno"));
	}
	
	public SituacaoCriteria createSituacaoCriteria() {
		return new SituacaoCriteria(createCriteria("situacao"));
	}
	
	public Inscricao_aluno uniqueInscricao_aluno() {
		return (Inscricao_aluno) super.uniqueResult();
	}
	
	public Inscricao_aluno[] listInscricao_aluno() {
		java.util.List list = super.list();
		return (Inscricao_aluno[]) list.toArray(new Inscricao_aluno[list.size()]);
	}
}

