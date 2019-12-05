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

public class AlunoCriteria extends AbstractORMCriteria {
	public final IntegerExpression pessoaId;
	public final AssociationExpression pessoa;
	public final IntegerExpression cursoId;
	public final AssociationExpression curso;
	public final CollectionExpression inscricao_aluno;
	
	public AlunoCriteria(Criteria criteria) {
		super(criteria);
		pessoaId = new IntegerExpression("pessoa.id", this);
		pessoa = new AssociationExpression("pessoa", this);
		cursoId = new IntegerExpression("curso.id", this);
		curso = new AssociationExpression("curso", this);
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this);
	}
	
	public AlunoCriteria(PersistentSession session) {
		this(session.createCriteria(Aluno.class));
	}
	
	public AlunoCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public PessoaCriteria createPessoaCriteria() {
		return new PessoaCriteria(createCriteria("pessoa"));
	}
	
	public CursoCriteria createCursoCriteria() {
		return new CursoCriteria(createCriteria("curso"));
	}
	
	public Inscricao_alunoCriteria createInscricao_alunoCriteria() {
		return new Inscricao_alunoCriteria(createCriteria("ORM_Inscricao_aluno"));
	}
	
	public Aluno uniqueAluno() {
		return (Aluno) super.uniqueResult();
	}
	
	public Aluno[] listAluno() {
		java.util.List list = super.list();
		return (Aluno[]) list.toArray(new Aluno[list.size()]);
	}
}

