package br.gov.ac.sefaz.vendas.application;

import br.gov.ac.sefaz.vendas.dao.DaoFactory;
import br.gov.ac.sefaz.vendas.service.ProdutoService;
import br.gov.ac.sefaz.vendas.util.ConnectionFactory;

import java.util.Arrays;
import java.util.List;

public class ProdutoApp {

    public static void main(String[] args) {

        // instancia o DAO de Produto
        ProdutoService produtoService = DaoFactory.criarProdutoDAO();

        br.gov.ac.sefaz.vendas.model.Produto p1 = new br.gov.ac.sefaz.vendas.model.Produto();
        p1.setName("Celular");
        br.gov.ac.sefaz.vendas.model.Produto p2 = new br.gov.ac.sefaz.vendas.model.Produto();
        p2.setName("Caixa de som");
        br.gov.ac.sefaz.vendas.model.Produto p3 = new br.gov.ac.sefaz.vendas.model.Produto();
        p3.setName("Teclado");

        List<br.gov.ac.sefaz.vendas.model.Produto> produtos = Arrays.asList(p1, p2, p3);

        produtos.forEach(p -> produtoService.save(p));

        br.gov.ac.sefaz.vendas.model.Produto produto = produtoService.findById(br.gov.ac.sefaz.vendas.model.Produto.class, 1L);
        System.out.println("Produto com o id 1 = " + produto);

        System.out.println("\n --Lista de produtos --");
        produtos = produtoService.findAll(br.gov.ac.sefaz.vendas.model.Produto.class.getName());
        System.out.println(produtos); // passa a String da classe

        System.out.println("Iterando os produtos");
        produtos.forEach(System.out::println);


        // buscando produto por nome
        System.out.println("");
        br.gov.ac.sefaz.vendas.model.Produto celular = produtoService.findByName("Celular").get(0);
        System.out.println(celular);


        // buscando produto usando IN
        System.out.println("");
        br.gov.ac.sefaz.vendas.model.Produto teclado =  produtoService.findById2(3L);
        System.out.println(teclado);

        ConnectionFactory.closeEntityManagerFactory();
    }
}
