package br.gov.ac.sefaz.vendas.application;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.dao.DaoFactory;
import br.gov.ac.sefaz.vendas.model.Produto;
import br.gov.ac.sefaz.vendas.service.ProdutoService;
import br.gov.ac.sefaz.vendas.util.ConnectionFactory;

import java.util.Arrays;
import java.util.List;

public class ProdutoApp {

    public static void main(String[] args) {

        // instancia o dao de Produto
        ProdutoService produtoDao = DaoFactory.criarProdutoDAO();

        Produto p1 = new Produto();
        p1.setName("Celular");
        Produto p2 = new Produto();
        p2.setName("Caixa de som");
        Produto p3 = new Produto();
        p3.setName("Teclado");

        List<Produto> produtos = Arrays.asList(p1, p2, p3);

        produtos.forEach(p -> produtoDao.save(p));

        Produto produto = produtoDao.findById(Produto.class, 1L);
        System.out.println("Produto com o id 1 = " + produto);

        System.out.println("\n --Lista de produtos --");
        produtos = produtoDao.findAll(Produto.class.getName());
        System.out.println(produtos); // passa a String da classe

        System.out.println("Iterando os produtos");
        produtos.forEach(System.out::println);


        ConnectionFactory.closeEntityManagerFactory();
    }
}
