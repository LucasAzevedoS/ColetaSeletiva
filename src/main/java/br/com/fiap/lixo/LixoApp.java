package br.com.fiap.lixo;

import br.com.fiap.lixo.dao.ColetorDao;
import br.com.fiap.lixo.dao.Conexao;
import br.com.fiap.lixo.dao.LixoDao;
import br.com.fiap.lixo.model.Coletor;
import br.com.fiap.lixo.model.Lixo;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class LixoApp {

    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //atualizar(em);
        //excluir(em);
        //consultarLixoPorId(em);
        //listarTodosOsLixos(em);
        //listarLixoPorRisco(em);
        consultarColetorPorId(em);
    }

    public static void cadastrar(EntityManager em){

        Coletor coletor = new Coletor();

        //coletor.setId(1);
        coletor.setNome("Poluba");
        coletor.setRegiao("Beco sem saída");
        coletor.setVeiculo("Bike");
        coletor.setDataRegistro(LocalDate.of(2024, 6, 10));

        ColetorDao coletorDao = new ColetorDao(em);

        em.getTransaction().begin();
        coletorDao.salvar(coletor);

        Lixo lixo = new Lixo();
        lixo.setNome("Garrafa");
        lixo.setTipo("Prastico");
        lixo.setPeso(15);
        lixo.setRisco(1);
        lixo.setDataColeta(LocalDate.of(2024, 10, 16));
        lixo.setColetor(coletor);

        LixoDao lixoDao= new LixoDao(em);

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
        lixo.setDataColeta(LocalDate.of(2024, 5, 10));

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
        lixoDao.consultarLixoPorId(1);
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

    private static void consultarColetorPorId(EntityManager em) {

        ColetorDao coletorDao = new ColetorDao(em);
        Coletor coletorBuscado = new Coletor();
        coletorBuscado.setId(1);

        Coletor coletorEncontrado = new Coletor();

        coletorEncontrado = coletorDao.consultarColetorPorId(coletorBuscado);

        System.out.println("-------------------------");
        System.out.println(coletorEncontrado.getNome());
        System.out.println(coletorEncontrado.getLixos());
    }
}