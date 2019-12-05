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

public class TurmaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression disciplinaId;
	public final AssociationExpression disciplina;
	public final IntegerExpression professorId;
	public final AssociationExpression professor;
	public final StringExpression periodo;
	public final CollectionExpression alocacao_sala_turma;
	public final CollectionExpression inscricao_aluno;
	
	public TurmaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		disciplinaId = new IntegerExpression("disciplina.id", this);
		disciplina = new AssociationExpression("disciplina", this);
		professorId = new IntegerExpression("professor.", this);
		professor = new AssociationExpression("professor", this);
		periodo = new StringExpression("periodo", this);
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this);
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this);
	}
	
	public TurmaCriteria(PersistentSession session) {
		this(session.createCriteria(Turma.class));
	}
	
	public TurmaCriteria() throws PersistentException {
		this(SCOAPersistentManager.instance().getSession());
	}
	
	public DisciplinaCriteria createDisciplinaCriteria() {
		return new DisciplinaCriteria(createCriteria("disciplina"));
	}
	
	public ProfessorCriteria createProfessorCriteria() {
		return new ProfessorCriteria(createCriteria("professor"));
	}
	
	public Alocacao_sala_turmaCriteria createAlocacao_sala_turmaCriteria() {
		return new Alocacao_sala_turmaCriteria(createCriteria("ORM_Alocacao_sala_turma"));
	}
	
	public Inscricao_alunoCriteria createInscricao_alunoCriteria() {
		return new Inscricao_alunoCriteria(createCriteria("ORM_Inscricao_aluno"));
	}
	
	public Turma uniqueTurma() {
		return (Turma) super.uniqueResult();
	}
	
	public Turma[] listTurma() {
		java.util.List list = super.list();
		return (Turma[]) list.toArray(new Turma[list.size()]);
	}
}

