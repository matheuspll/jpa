package br.gov.ac.sefaz.vendas.service;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Produto;
import br.gov.ac.sefaz.vendas.pojo.RelatorioDeVendasPOJO;

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

    // busca a soma total de cada produto baseado no total de pedidos desse produto
    // mostrar o nome, soma_total, status. 15137.97

    public List<Object[]> relatorioDeVendas1() {

        EntityManager em = getEntityManager();
//        String jpql = "SELECT p.name, sum(p.price), pe.dataPedido FROM tb_produto p\n" +
//                "INNER JOIN tb_produto_pedido pp ON p.id = pp.produto_id\n" +
//                "INNER JOIN tb_pedido pe ON pe.id = pp.pedido_id\n" +
//                "GROUP BY p.name\n" +
//                "ORDER BY p.price DESC";

        String jpql = "SELECT produto.name, SUM(produto.price), " +
                "pedido.dataPedido FROM Produto produto " +
                "JOIN produto.pedidos pedido " +
                "GROUP BY produto.name ORDER BY produto.price DESC";
        List<Object[]> relatorio = em.createQuery(jpql, Object[].class).getResultList();
        em.close();
        return relatorio;
    }
    public List<RelatorioDeVendasPOJO> relatorioDeVendas2() {

        EntityManager em = getEntityManager();
        String jpql = "SELECT new br.gov.ac.sefaz.vendas.pojo.RelatorioDeVendasPOJO("
                + "produto.name, "
                + "SUM(produto.price), "
                + "pedido.dataPedido) "
                + "FROM Produto produto "
                + "JOIN produto.pedidos pedido "
                + "GROUP BY produto.name "
                + "ORDER BY produto.price DESC";

        List<RelatorioDeVendasPOJO> relatorio = em.createQuery(jpql, RelatorioDeVendasPOJO.class)
                .getResultList();
        em.close();
        return relatorio;
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        EntityManager em = getEntityManager();
        List<Produto> produtos = em.createNamedQuery("Produto.ProdutosPorCategoria", Produto.class)
                .setParameter("name", nome)
                .getResultList();
        em.close();
        return produtos;
    }
}
