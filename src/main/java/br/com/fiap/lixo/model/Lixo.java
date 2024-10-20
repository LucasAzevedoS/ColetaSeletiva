package br.com.fiap.lixo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

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
    @Column(name = "data_coleta")
    private LocalDate dataColeta;

    @ManyToOne
    @JoinColumn(name = "coletor_id")
    private Coletor coletor;


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

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public Coletor getColetor() {
        return coletor;
    }

    public void setColetor(Coletor coletor) {
        this.coletor = coletor;
    }

    @Override
    public String toString() {
        return "Lixo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", risco=" + risco +
                ", dataColeta=" + dataColeta +
                ", coletor=" + coletor +
                '}';
    }
}
