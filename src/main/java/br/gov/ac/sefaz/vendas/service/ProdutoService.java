package br.gov.ac.sefaz.vendas.service;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService extends DAO<Produto> {

    public ProdutoService(EntityManagerFactory emf) {
        super(emf); // usando o construtor do pai
    }

    // consultas personalizadas com JPQL
    public List<Produto> findByName(String name) {
        EntityManager em = getEntityManager();
        List<Produto> produtos;
        try {
            String jpql = "SELECT p from Produto p WHERE p.name = :name";
            produtos = em.createQuery(jpql, Produto.class)
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            produtos = new ArrayList<>();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return produtos;
    }

    // consultas personalizadas com JPQL - positional parameters
    public Produto findById2(Long id) {
        EntityManager em = getEntityManager();
        Produto produto = null;
        try {
            String jpql = "SELECT p from Produto p WHERE p.id IN (?1)";
            produto = em.createQuery(jpql, Produto.class)
                    .setParameter(1, id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return produto;
    }

    public Double valorTotalProdutos() {
        EntityManager em = getEntityManager();
        String jpql;
        Double valorTotal;
        try {
            jpql = "SELECT SUM(p.price) FROM Produto p";
            valorTotal = em.createQuery(jpql, Double.class).getSingleResult();

        } finally {
            em.close();
        }
        return valorTotal;
    }

    // buscar a soma de todos os produtos Notebook's em que o status estava pago
    // mostrar o nome, soma_total, status. 15137.97

    public List<Object[]> relatorioDeVendas() {

        EntityManager em = getEntityManager();
        String jpql = "SELECT p.name, sum(p.price), pe.dataPedido FROM tb_produto p\n" +
                "INNER JOIN tb_produto_pedido pp ON p.id = pp.produto_id\n" +
                "INNER JOIN tb_pedido pe ON pe.id = pp.pedido_id\n" +
                "GROUP BY p.name\n" +
                "ORDER BY p.price DESC;";
        return em.createQuery(jpql, Object.class).getResultList();
    }



}
