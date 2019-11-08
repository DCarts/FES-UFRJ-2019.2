package br.com.fes.scoa.modelo;

import br.com.fes.scoa.componente.CadastroHorarioController.Dia;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Objects;

public class TipoHoraDoDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Dia dia;

    @Column
    private LocalTime horarioInicio;

    @Column
    private LocalTime horarioFim;

    public TipoHoraDoDia(Dia dia, LocalTime horarioInicio, LocalTime horarioFim) {
        this.dia = dia;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    @Override
    public String toString() {
        return dia.getNome() + ", " + horarioInicio + " a " + horarioFim + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof TipoHoraDoDia)) return false;
        TipoHoraDoDia casted = (TipoHoraDoDia)obj;
        return Objects.equals(casted.id, id) &&
                casted.dia == dia &&
                casted.horarioInicio == horarioInicio &&
                casted.horarioFim == horarioFim;
    }
}
