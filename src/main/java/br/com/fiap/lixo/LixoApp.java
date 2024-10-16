package br.com.fiap.lixo;

import br.com.fiap.lixo.dao.Conexao;
import br.com.fiap.lixo.dao.LixoDao;
import br.com.fiap.lixo.model.Lixo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LixoApp {

    public static void main(String[] args) {
        //criacao entity
        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        atualizar(em);
    }

    public static void cadastrar(EntityManager em){
        Lixo lixo = new Lixo();

        lixo.setNome("Garrafa");
        lixo.setTipo("Plastico");
        lixo.setPeso(140);
        lixo.setRisco(1);

        //criacao instancia dao
        LixoDao lixodao= new LixoDao(em);

        em.getTransaction().begin();
        lixodao.salvar(lixo);
        em.getTransaction().commit();

    }

    public static void atualizar(EntityManager em){
        Lixo lixo = new Lixo();
        lixo.setId(2);
        lixo.setNome("Garrafa");
        lixo.setTipo("Plastico");
        lixo.setPeso(160);
        lixo.setRisco(1);

        //criacao instancia dao
        LixoDao lixodao= new LixoDao(em);

        em.getTransaction().begin();
        lixodao.atualizar(lixo);
        em.getTransaction().commit();

    }
}






