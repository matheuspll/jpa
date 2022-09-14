package br.gov.ac.sefaz.vendas.application;

import br.gov.ac.sefaz.vendas.dao.DaoFactory;
import br.gov.ac.sefaz.vendas.model.Produto;
import br.gov.ac.sefaz.vendas.repository.ProdutoRespository;
import br.gov.ac.sefaz.vendas.util.ConnectionFactory;

import java.util.Arrays;
import java.util.List;

public class ProdutoApp {

    public static void main(String[] args) {

        // instancia o DAO de Produto
        ProdutoRespository produtoService = DaoFactory.criarProdutoDAO();

        Produto p1 = new Produto();
        p1.setName("Celular");
        Produto p2 = new Produto();
        p2.setName("Caixa de som");
        Produto p3 = new Produto();
        p3.setName("Monitor");

        List<Produto> produtos = Arrays.asList(p1, p2, p3);

        produtos.forEach(p -> produtoService.save(p));

        Produto produto = produtoService.findById(Produto.class, 1L);
        System.out.println("Produto com o id 1 = " + produto);

        System.out.println("\n --Lista de produtos --");
        produtos = produtoService.findAll(Produto.class.getName());
        System.out.println(produtos); // passa a String da classe

        System.out.println("Iterando os produtos");
        produtos.forEach(System.out::println);


        // buscando produto por nome
        System.out.println("");
        Produto celular = produtoService.findByName("Celular").get(0);
        System.out.println(celular);


        // buscando produto usando IN
        System.out.println("");
        Produto teclado =  produtoService.findById2(3L);
        System.out.println(teclado);

        ConnectionFactory.closeEntityManagerFactory();
    }
}
