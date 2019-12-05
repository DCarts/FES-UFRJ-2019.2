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
import org.orm.criteria.IntegerExpression;

import java.util.List;

public class SecretarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression pessoaId;
	public final AssociationExpression pessoa;
	public final IntegerExpression cursoId;
	public final AssociationExpression curso;
	
	public SecretarioDetachedCriteria() {
		super(br.com.fes.scoa.model.Secretario.class, br.com.fes.scoa.model.SecretarioCriteria.class);
		pessoaId = new IntegerExpression("pessoa.id", this.getDetachedCriteria());
		pessoa = new AssociationExpression("pessoa", this.getDetachedCriteria());
		cursoId = new IntegerExpression("curso.id", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
	}
	
	public SecretarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.SecretarioCriteria.class);
		pessoaId = new IntegerExpression("pessoa.id", this.getDetachedCriteria());
		pessoa = new AssociationExpression("pessoa", this.getDetachedCriteria());
		cursoId = new IntegerExpression("curso.id", this.getDetachedCriteria());
		curso = new AssociationExpression("curso", this.getDetachedCriteria());
	}
	
	public PessoaDetachedCriteria createPessoaCriteria() {
		return new PessoaDetachedCriteria(createCriteria("pessoa"));
	}
	
	public CursoDetachedCriteria createCursoCriteria() {
		return new CursoDetachedCriteria(createCriteria("curso"));
	}
	
	public Secretario uniqueSecretario(PersistentSession session) {
		return (Secretario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Secretario[] listSecretario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Secretario[]) list.toArray(new Secretario[list.size()]);
	}
}

