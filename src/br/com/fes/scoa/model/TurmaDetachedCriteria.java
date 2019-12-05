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

public class TurmaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression disciplinaId;
	public final AssociationExpression disciplina;
	public final IntegerExpression professorId;
	public final AssociationExpression professor;
	public final StringExpression periodo;
	public final CollectionExpression alocacao_sala_turma;
	public final CollectionExpression inscricao_aluno;
	
	public TurmaDetachedCriteria() {
		super(br.com.fes.scoa.model.Turma.class, br.com.fes.scoa.model.TurmaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		disciplinaId = new IntegerExpression("disciplina.id", this.getDetachedCriteria());
		disciplina = new AssociationExpression("disciplina", this.getDetachedCriteria());
		professorId = new IntegerExpression("professor.", this.getDetachedCriteria());
		professor = new AssociationExpression("professor", this.getDetachedCriteria());
		periodo = new StringExpression("periodo", this.getDetachedCriteria());
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this.getDetachedCriteria());
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this.getDetachedCriteria());
	}
	
	public TurmaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, br.com.fes.scoa.model.TurmaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		disciplinaId = new IntegerExpression("disciplina.id", this.getDetachedCriteria());
		disciplina = new AssociationExpression("disciplina", this.getDetachedCriteria());
		professorId = new IntegerExpression("professor.", this.getDetachedCriteria());
		professor = new AssociationExpression("professor", this.getDetachedCriteria());
		periodo = new StringExpression("periodo", this.getDetachedCriteria());
		alocacao_sala_turma = new CollectionExpression("ORM_Alocacao_sala_turma", this.getDetachedCriteria());
		inscricao_aluno = new CollectionExpression("ORM_Inscricao_aluno", this.getDetachedCriteria());
	}
	
	public DisciplinaDetachedCriteria createDisciplinaCriteria() {
		return new DisciplinaDetachedCriteria(createCriteria("disciplina"));
	}
	
	public ProfessorDetachedCriteria createProfessorCriteria() {
		return new ProfessorDetachedCriteria(createCriteria("professor"));
	}
	
	public Alocacao_sala_turmaDetachedCriteria createAlocacao_sala_turmaCriteria() {
		return new Alocacao_sala_turmaDetachedCriteria(createCriteria("ORM_Alocacao_sala_turma"));
	}
	
	public Inscricao_alunoDetachedCriteria createInscricao_alunoCriteria() {
		return new Inscricao_alunoDetachedCriteria(createCriteria("ORM_Inscricao_aluno"));
	}
	
	public Turma uniqueTurma(PersistentSession session) {
		return (Turma) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Turma[] listTurma(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Turma[]) list.toArray(new Turma[list.size()]);
	}
}

