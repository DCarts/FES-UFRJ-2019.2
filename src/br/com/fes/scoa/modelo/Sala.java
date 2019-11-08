package br.com.fes.scoa.modelo;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;

import javax.persistence.*;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(unique = true, length = 9)
    private String codLocalizacao;

    public Sala(String codLocalizacao) {
        this.codLocalizacao = codLocalizacao;
    }

    public Sala() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public ObservableStringValue getCodLocalizacaoProperty() {
        return new SimpleStringProperty(codLocalizacao);
    }

    @Transient
    public ObservableStringValue getSalaPredioProperty() {
        String[] parts = codLocalizacao.split("::");
        if (parts.length > 0) return new SimpleStringProperty(parts[0]);
        return new SimpleStringProperty("");
    }
    @Transient
    public ObservableStringValue getSalaAndarProperty() {
        String[] parts = codLocalizacao.split("::");
        if (parts.length > 1) return new SimpleStringProperty(parts[1]);
        return new SimpleStringProperty("");
    }
    @Transient
    public ObservableStringValue getSalaNomeProperty() {
        String[] parts = codLocalizacao.split("::");
        if (parts.length > 2) return new SimpleStringProperty(parts[2]);
        return new SimpleStringProperty("");
    }

    public String getCodLocalizacao() {
        return codLocalizacao;
    }

    public void setCodLocalizacao(String codLocalizacao) {
        this.codLocalizacao = codLocalizacao;
    }
}
