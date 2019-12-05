package br.com.fes.scoa.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //private String nome;

    @ManyToOne
    @JoinColumn(name="professor_pessoa_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name="sala_id")
    private Sala sala;

    @OneToOne
    @JoinColumn(name="disciplina_id")
    private Disciplina disciplina;

    @ManyToMany
    private List<Aluno> aluno;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<HorarioDeAula> horario;


    //@Column(length = 2555)
    //private String descricao;

    public Turma(Disciplina disciplina, Professor professor, Sala sala, List<HorarioDeAula> horario) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.sala = sala;
        this.horario = horario;
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

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<HorarioDeAula> getHorario() {
        return horario;
    }

    public void setHorario(List<HorarioDeAula> horario) {
        this.horario = horario;
    }
}
