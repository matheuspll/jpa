package br.gov.ac.sefaz.vendas.application;

import br.gov.ac.sefaz.vendas.dao.DaoFactory;
import br.gov.ac.sefaz.vendas.model.Categoria;
import br.gov.ac.sefaz.vendas.model.Produto;
import br.gov.ac.sefaz.vendas.service.CategoriaService;
import br.gov.ac.sefaz.vendas.service.ProdutoService;
import br.gov.ac.sefaz.vendas.util.ConnectionFactory;

import java.util.Arrays;
import java.util.List;

public class TestProdutoCategoria {

    public static void main(String[] args) {

        // Categoria DAO
        Categoria categoria1 = new Categoria(null, "Eletronico");
        Categoria categoria2 = new Categoria(null, "Computadores");
        Categoria categoria3 = new Categoria(null, "Livros");
        Categoria categoria4 = new Categoria(null, "Musicas");
        Categoria categoria5 = new Categoria(null, "Portatil");

        List<Categoria> categorias = Arrays.asList(categoria1, categoria2,
                categoria3, categoria4, categoria5);

        CategoriaService categoriaService = DaoFactory.criarCategoriaDAO();

        categorias.forEach(c -> categoriaService.save(c));

        // instancia o DAO de Produto
        ProdutoService produtoService = DaoFactory.criarProdutoDAO();

        Produto p1 = new Produto();
        p1.setName("Celular");
        p1.setPrice(20.00);
        Produto p2 = new Produto();
        p2.setName("Caixa de som");
        p2.setPrice(40.35);
        Produto p3 = new Produto();
        p3.setName("Livro de Física");
        p3.setPrice(150.40);
        Produto p4 = new Produto();
        p4.setName("Notebook");
        p4.setPrice(5045.99);

        p1.getCategorias().add(categoria1);
        p1.getCategorias().add(categoria5);

        p2.getCategorias().add(categoria5);
        p2.getCategorias().add(categoria1);

        p3.getCategorias().add(categoria3);

        p4.getCategorias().add(categoria1);
        p4.getCategorias().add(categoria5);
        p4.getCategorias().add(categoria2);

        List<Produto> produtos = Arrays.asList(p1, p2, p3, p4);

        produtos.forEach(p -> produtoService.save(p));


        System.out.println("imprimindo todos os produtos novamente");
        produtos = produtoService.findAll(Produto.class.getName());
        produtos.forEach(p -> System.out.println(p));

        ConnectionFactory.closeEntityManagerFactory();
    }
}
