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

public class SysadminsCriteria extends AbstractORMCriteria {
	public final IntegerExpression pessoaId;
	public final AssociationExpression pessoa;
	
	public SysadminsCriteria(Criteria criteria) {
		super(criteria);
		pessoaId = new IntegerExpression("pessoa.id", this);
		pessoa = new AssociationExpression("pessoa", this);
	}
	
	public SysadminsCriteria(PersistentSession session) {
		this(session.createCriteria(Sysadmins.class));
	}
	
	public SysadminsCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public PessoaCriteria createPessoaCriteria() {
		return new PessoaCriteria(createCriteria("pessoa"));
	}
	
	public Sysadmins uniqueSysadmins() {
		return (Sysadmins) super.uniqueResult();
	}
	
	public Sysadmins[] listSysadmins() {
		java.util.List list = super.list();
		return (Sysadmins[]) list.toArray(new Sysadmins[list.size()]);
	}
}

