package br.com.fes.scoa.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class TurmasAlunos implements Serializable {

    @Id
    @ManyToOne
    private Turma turma;

    @Id
    @ManyToOne
    private Pessoa pessoa;

    public TurmasAlunos(Turma turma, Pessoa pessoa){

        this.turma = turma;
        this.pessoa = pessoa;

    }


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
