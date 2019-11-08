package br.com.fes.scoa.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class SalasTurmas implements Serializable{

    @Id
    @ManyToOne
    private Sala sala;

    @Id
    private TipoHoraDoDia hora;

    @Id
    @ManyToOne
    private Turma turma;

    public SalasTurmas(){}

    public SalasTurmas(Sala sala, Turma turma, TipoHoraDoDia hora){
        this.sala = sala;
        this.turma = turma;
        this.hora = hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public TipoHoraDoDia getHora() {
        return hora;
    }

    public void setHora(TipoHoraDoDia hora) {
        this.hora = hora;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
