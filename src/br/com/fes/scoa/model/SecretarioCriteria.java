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
import org.orm.criteria.IntegerExpression;

public class SecretarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression pessoaId;
	public final AssociationExpression pessoa;
	public final IntegerExpression cursoId;
	public final AssociationExpression curso;
	
	public SecretarioCriteria(Criteria criteria) {
		super(criteria);
		pessoaId = new IntegerExpression("pessoa.id", this);
		pessoa = new AssociationExpression("pessoa", this);
		cursoId = new IntegerExpression("curso.id", this);
		curso = new AssociationExpression("curso", this);
	}
	
	public SecretarioCriteria(PersistentSession session) {
		this(session.createCriteria(Secretario.class));
	}
	
	public SecretarioCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public PessoaCriteria createPessoaCriteria() {
		return new PessoaCriteria(createCriteria("pessoa"));
	}
	
	public CursoCriteria createCursoCriteria() {
		return new CursoCriteria(createCriteria("curso"));
	}
	
	public Secretario uniqueSecretario() {
		return (Secretario) super.uniqueResult();
	}
	
	public Secretario[] listSecretario() {
		java.util.List list = super.list();
		return (Secretario[]) list.toArray(new Secretario[list.size()]);
	}
}

