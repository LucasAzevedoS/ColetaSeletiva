package br.com.fiap.lixo.dao;

import br.com.fiap.lixo.model.Lixo;
import jakarta.persistence.EntityManager;

import java.util.List;

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

    public void excluir(Lixo lixo) {
        Lixo lixoExcluir = em.find(Lixo.class, lixo.getId());
        em.remove(lixoExcluir);
    }

    public void consultarLixoPorId(int id) {
        Lixo lixoConsulta = em.find(Lixo.class, id);
        if (lixoConsulta == null) {
            System.out.println("Não existe registro para esse identificador");
        }else {
            System.out.println("-------------------------------------------");
            System.out.println(lixoConsulta);
            System.out.println("-------------------------------------------");
        }
    }

    public List<Lixo> listarTodosOsLixos() {
        String consulta = "SELECT c FROM Lixo c ORDER BY nome ASC";
        return em.createQuery(consulta).getResultList();
    }

    public List<Lixo> listarLixoPorRisco(int riscoProcurado) {
        String consulta = "SELECT c FROM Lixo c WHERE risco = :risco";
        return em.createQuery(consulta, Lixo.class)
                .setParameter("risco", riscoProcurado)
                .getResultList();
    }
}
