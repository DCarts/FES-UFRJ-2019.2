package br.com.fes.scoa.modelo;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.io.Serializable;


public class SalasTurmas implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="sala_id")
    private Sala sala;

    @Id
    @ManyToOne
    @JoinColumn(name="hora_id")
    private HorarioDeAula hora;

    @Id
    @ManyToOne
    @JoinColumn(name="turma_id")
    private Turma turma;

    public SalasTurmas(Sala sala, Turma turma, HorarioDeAula hora) {
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
    public HorarioDeAula getHora() {
        return hora;
    }

    public void setHora(HorarioDeAula hora) {
        this.hora = hora;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
