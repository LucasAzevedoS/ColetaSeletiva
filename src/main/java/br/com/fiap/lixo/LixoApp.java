package br.com.fiap.lixo;

import br.com.fiap.lixo.dao.Conexao;
import br.com.fiap.lixo.dao.LixoDao;
import br.com.fiap.lixo.model.Lixo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LixoApp {

    public static void main(String[] args) {
        //criacao entity
        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //atualizar(em);
        //excluir(em);
        //consultarLixoPorId(em);
        //listarTodosOsLixos(em);
        listarLixoPorRisco(em);
    }

    public static void cadastrar(EntityManager em){
        Lixo lixo = new Lixo();

        lixo.setNome("Lata");
        lixo.setTipo("Metal");
        lixo.setPeso(20);
        lixo.setRisco(1);

        //criacao instancia dao
        LixoDao lixoDao= new LixoDao(em);

        em.getTransaction().begin();
        lixoDao.salvar(lixo);
        em.getTransaction().commit();
    }

    public static void atualizar(EntityManager em){
        Lixo lixo = new Lixo();
        lixo.setId(2);
        lixo.setNome("Lata");
        lixo.setTipo("Metal");
        lixo.setPeso(20);
        lixo.setRisco(1);

        //criacao instancia dao
        LixoDao lixoDao= new LixoDao(em);

        em.getTransaction().begin();
        lixoDao.atualizar(lixo);
        em.getTransaction().commit();
    }

    public static void excluir(EntityManager em) {
        Lixo lixo = new Lixo();
        lixo.setId(2);

        LixoDao lixoDao = new LixoDao(em);

        em.getTransaction().begin();
        lixoDao.atualizar(lixo);
        em.getTransaction().commit();
    }

    public static void consultarLixoPorId(EntityManager em) {
        LixoDao lixoDao = new LixoDao(em);

        em.getTransaction().begin();
        lixoDao.consultarLixoPorId(4);
        em.getTransaction().commit();
    }

    public static void listarTodosOsLixos(EntityManager em) {
        LixoDao lixoDao = new LixoDao(em);

        List<Lixo> lixos = lixoDao.listarTodosOsLixos();

        for (Lixo lixo : lixos) {
            System.out.println("-------------------------");
            System.out.println(lixo.toString());
        }

        System.out.println("-----------------------------");
        System.out.println("Fim dos registros");
    }

    public static void listarLixoPorRisco(EntityManager em) {
        LixoDao lixoDao = new LixoDao(em);

        List<Lixo> lixos = lixoDao.listarLixoPorRisco(1);

        for (Lixo lixo : lixos) {
            System.out.println("-------------------------");
            System.out.println(lixo.toString());
        }

        System.out.println("-----------------------------");
        System.out.println("Fim dos registros");
    }
}