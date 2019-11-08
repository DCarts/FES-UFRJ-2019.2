package br.com.fes.scoa.modelo;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sala{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(unique = true, length = 9)
    private String codLocalizacao;

    public Sala(){}

    public Sala(String codLocalizacao){
        this.codLocalizacao = codLocalizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodLocalizacao() {
        return codLocalizacao;
    }

    public void setCodLocalizacao(String codLocalizacao) {
        this.codLocalizacao = codLocalizacao;
    }
}
