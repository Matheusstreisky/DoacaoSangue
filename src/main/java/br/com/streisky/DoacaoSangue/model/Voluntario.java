package br.com.streisky.DoacaoSangue.model;

import javax.persistence.*;

@Entity
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String nome;

    private int idade;

    @Column(length = 10)
    private String sexo;

    @Column(length = 2)
    private String tipoSanguineo;

    @Column(length = 500)
    private String observacao;

    public Voluntario() {
    }

    public Voluntario(String nome, int idade, String sexo, String tipoSanguineo, String observacao) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.tipoSanguineo = tipoSanguineo;
        this.observacao = observacao;
    }

    // <editor-fold defaultstate="collapsed" desc="GETS and SETS">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    // </editor-fold>
}
