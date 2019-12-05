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

public class PessoaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression cpf;
	public final DateExpression data_nascimento;
	public final StringExpression email;
	public final StringExpression endereco;
	public final StringExpression nome;
	public final StringExpression senha;
	public final IntegerExpression alunoId;
	public final AssociationExpression aluno;
	public final IntegerExpression professorId;
	public final AssociationExpression professor;
	public final IntegerExpression secretarioId;
	public final AssociationExpression secretario;
	public final IntegerExpression sysadminsId;
	public final AssociationExpression sysadmins;
	
	public PessoaDetachedCriteria() {
		super(br.com.fes.scoa.model.Pessoa.class, br.com.fes.scoa.model.PessoaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		cpf = new StringExpression("cpf", this.getDetachedCriteria());
		data_nascimento = new DateExpression("data_nascimento", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		endereco = new StringExpression("endereco", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		senha = new StringExpression("senha", this.getDetachedCriteria());
		alunoId = new IntegerExpression("aluno.id", this.getDetachedCriteria());
		aluno = new AssociationExpression("aluno", this.getDetachedCriteria());
		professorId = new IntegerExpression("professor.id", this.getDetachedCriteria());
		professor = new AssociationExpression("professor", this.getDetachedCriteria());
		secretarioId = new IntegerExpression("secretario.id", this.getDetachedCriteria());
		secretario = new AssociationExpression("secretario", this.getDetachedCriteria());
		sysadminsId = new IntegerExpression("sysadmins.id", this.getDetachedCriteria());
		sysadmins = new AssociationExpression("sysadmins", this.getDetachedCriteria());
	}
	
	public PessoaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.PessoaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		cpf = new StringExpression("cpf", this.getDetachedCriteria());
		data_nascimento = new DateExpression("data_nascimento", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		endereco = new StringExpression("endereco", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		senha = new StringExpression("senha", this.getDetachedCriteria());
		alunoId = new IntegerExpression("aluno.id", this.getDetachedCriteria());
		aluno = new AssociationExpression("aluno", this.getDetachedCriteria());
		professorId = new IntegerExpression("professor.id", this.getDetachedCriteria());
		professor = new AssociationExpression("professor", this.getDetachedCriteria());
		secretarioId = new IntegerExpression("secretario.id", this.getDetachedCriteria());
		secretario = new AssociationExpression("secretario", this.getDetachedCriteria());
		sysadminsId = new IntegerExpression("sysadmins.id", this.getDetachedCriteria());
		sysadmins = new AssociationExpression("sysadmins", this.getDetachedCriteria());
	}
	
	public AlunoDetachedCriteria createAlunoCriteria() {
		return new AlunoDetachedCriteria(createCriteria("aluno"));
	}
	
	public ProfessorDetachedCriteria createProfessorCriteria() {
		return new ProfessorDetachedCriteria(createCriteria("professor"));
	}
	
	public SecretarioDetachedCriteria createSecretarioCriteria() {
		return new SecretarioDetachedCriteria(createCriteria("secretario"));
	}
	
	public SysadminsDetachedCriteria createSysadminsCriteria() {
		return new SysadminsDetachedCriteria(createCriteria("sysadmins"));
	}
	
	public Pessoa uniquePessoa(PersistentSession session) {
		return (Pessoa) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pessoa[] listPessoa(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pessoa[]) list.toArray(new Pessoa[list.size()]);
	}
}

