package br.com.fiap.lixo.dao;

import br.com.fiap.lixo.model.Coletor;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ColetorDao {

    private EntityManager em;

    public ColetorDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Coletor coletor){
        em.persist(coletor);
    }

    public Coletor consultarColetorPorId(Coletor coletor) {
        return em.find(Coletor.class, coletor.getId());
    }
}
