package br.com.fes.scoa.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //private String nome;

    @OneToOne
    @JoinColumn(name="professor_pessoa_id")
    private Professor professor;

    @OneToOne
    @JoinColumn(name="disciplina_id")
    private Disciplina disciplina;

    @ManyToMany
    private List<Aluno> aluno;


    //@Column(length = 2555)
    //private String descricao;


    public Turma(Disciplina disciplina, Professor professor) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.aluno = new ArrayList<Aluno>();
    }

    public Turma() {}


    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<Aluno> aluno) {
        this.aluno.add(aluno.get(0));
    }
}
