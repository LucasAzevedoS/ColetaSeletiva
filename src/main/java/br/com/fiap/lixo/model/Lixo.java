package br.com.fiap.lixo.model;


import jakarta.persistence.*;

@Entity
@Table (name="tbl_lixo")

public class Lixo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_LIXO_SEQ"
    )
    @SequenceGenerator(
            name = "TBL_LIXO_SEQ",
            sequenceName = "TBL_LIXO_SEQ",
            allocationSize = 1
    )
    private int id;
    private String nome;
    private String tipo;
    private double peso;
    private int risco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRisco() {
        return risco;
    }

    public void setRisco(int risco) {
        this.risco = risco;
    }

    @Override
    public String toString() {
        return "lixo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", risco=" + risco +
                '}';
    }
}
