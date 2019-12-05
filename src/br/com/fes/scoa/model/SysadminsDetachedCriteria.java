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

public class SysadminsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression pessoaId;
	public final AssociationExpression pessoa;
	
	public SysadminsDetachedCriteria() {
		super(br.com.fes.scoa.model.Sysadmins.class, br.com.fes.scoa.model.SysadminsCriteria.class);
		pessoaId = new IntegerExpression("pessoa.id", this.getDetachedCriteria());
		pessoa = new AssociationExpression("pessoa", this.getDetachedCriteria());
	}
	
	public SysadminsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.SysadminsCriteria.class);
		pessoaId = new IntegerExpression("pessoa.id", this.getDetachedCriteria());
		pessoa = new AssociationExpression("pessoa", this.getDetachedCriteria());
	}
	
	public PessoaDetachedCriteria createPessoaCriteria() {
		return new PessoaDetachedCriteria(createCriteria("pessoa"));
	}
	
	public Sysadmins uniqueSysadmins(PersistentSession session) {
		return (Sysadmins) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Sysadmins[] listSysadmins(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Sysadmins[]) list.toArray(new Sysadmins[list.size()]);
	}
}

