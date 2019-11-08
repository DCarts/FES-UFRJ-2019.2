package br.com.fes.scoa.modelo;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SalasTurmas implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="sala_id")
    private Sala sala;

    @Id
    private TipoHoraDoDia hora;

    @Id
    @ManyToOne
    @JoinColumn(name="turma_id")
    private Turma turma;

    public SalasTurmas(Sala sala, Turma turma, TipoHoraDoDia hora) {
        this.sala = sala;
        this.turma = turma;
        this.hora = hora;
    }

    public SalasTurmas() {}

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Transient
    public ObservableStringValue getHoraProperty() {
        String hour = "";
        try {
            hour = String.format("%02d:00", Integer.parseInt(hora.toString().replaceAll("\\D+","")));
        } catch (Exception e) {}
        return new SimpleStringProperty(hour);
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
