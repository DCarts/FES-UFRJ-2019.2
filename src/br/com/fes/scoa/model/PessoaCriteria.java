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
import org.orm.criteria.*;

public class PessoaCriteria extends AbstractORMCriteria {
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
	
	public PessoaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		cpf = new StringExpression("cpf", this);
		data_nascimento = new DateExpression("data_nascimento", this);
		email = new StringExpression("email", this);
		endereco = new StringExpression("endereco", this);
		nome = new StringExpression("nome", this);
		senha = new StringExpression("senha", this);
		alunoId = new IntegerExpression("aluno.id", this);
		aluno = new AssociationExpression("aluno", this);
		professorId = new IntegerExpression("professor.id", this);
		professor = new AssociationExpression("professor", this);
		secretarioId = new IntegerExpression("secretario.id", this);
		secretario = new AssociationExpression("secretario", this);
		sysadminsId = new IntegerExpression("sysadmins.id", this);
		sysadmins = new AssociationExpression("sysadmins", this);
	}
	
	public PessoaCriteria(PersistentSession session) {
		this(session.createCriteria(Pessoa.class));
	}
	
	public PessoaCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public AlunoCriteria createAlunoCriteria() {
		return new AlunoCriteria(createCriteria("aluno"));
	}
	
	public ProfessorCriteria createProfessorCriteria() {
		return new ProfessorCriteria(createCriteria("professor"));
	}
	
	public SecretarioCriteria createSecretarioCriteria() {
		return new SecretarioCriteria(createCriteria("secretario"));
	}
	
	public SysadminsCriteria createSysadminsCriteria() {
		return new SysadminsCriteria(createCriteria("sysadmins"));
	}
	
	public Pessoa uniquePessoa() {
		return (Pessoa) super.uniqueResult();
	}
	
	public Pessoa[] listPessoa() {
		java.util.List list = super.list();
		return (Pessoa[]) list.toArray(new Pessoa[list.size()]);
	}
}

