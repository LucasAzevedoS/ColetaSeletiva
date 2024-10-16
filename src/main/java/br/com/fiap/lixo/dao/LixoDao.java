package br.com.fiap.lixo.dao;

import br.com.fiap.lixo.model.Lixo;
import jakarta.persistence.EntityManager;

public class LixoDao{

    private EntityManager em;

    public LixoDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Lixo lixo){
        em.persist(lixo);
    }

    public void atualizar(Lixo lixo){
        em.merge(lixo);
    }
}
