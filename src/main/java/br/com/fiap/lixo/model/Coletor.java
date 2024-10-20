package br.com.fiap.lixo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TBL_COLETOR")
public class Coletor {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_COLETOR_SEQ"
    )
    @SequenceGenerator(
            name = "TBL_COLETOR_SEQ",
            sequenceName = "TBL_COLETOR_SEQ",
            allocationSize = 1
    )
    public int id;
    public String nome;

    public List<Lixo> getLixos() {
        return lixos;
    }

    public void setLixos(List<Lixo> lixos) {
        this.lixos = lixos;
    }

    public String regiao;
    public String veiculo;
    @Column(name = "data_registro")
    public LocalDate dataRegistro;

    @OneToMany(mappedBy = "coletor")
    private List<Lixo> lixos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    @Override
//    public String toString() {
//        return "Coletor{" +
//                "id=" + id +
//                ", nome='" + nome + '\'' +
//                ", regiao='" + regiao + '\'' +
//                ", veiculo='" + veiculo + '\'' +
//                ", dataRegistro=" + dataRegistro +
//                ", lixos=" + lixos +
//                '}';
//    }
}
