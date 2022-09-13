package br.gov.ac.sefaz.vendas.application;

import br.gov.ac.sefaz.vendas.dao.DaoFactory;
import br.gov.ac.sefaz.vendas.model.*;
import br.gov.ac.sefaz.vendas.pojo.RelatorioDeVendasPOJO;
import br.gov.ac.sefaz.vendas.service.*;
import br.gov.ac.sefaz.vendas.util.ConnectionFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestProduto {

    public static void main(String[] args) {

        /* --------------------------- CATEGORIA -------------------------------*/
        Categoria categoria1 = new Categoria(null, "Eletronico");
        Categoria categoria2 = new Categoria(null, "Computadores");
        Categoria categoria3 = new Categoria(null, "Livros");
        Categoria categoria4 = new Categoria(null, "Musicas");
        Categoria categoria5 = new Categoria(null, "Portatil");

        List<Categoria> categorias = Arrays.asList(categoria1, categoria2,
                categoria3, categoria4, categoria5);

        CategoriaService categoriaService = DaoFactory.criarCategoriaDAO();

        categorias.forEach(c -> categoriaService.save(c));

        System.out.println("Imprimindo todas as categorias: ");
        categorias.forEach(c -> System.out.println(c));

        /* --------------------------- DEPARTAMENTO -------------------------------*/
        DepartamentoService departamentoService = DaoFactory.criarDepartamentoService();

        Departamento departamento1 = new Departamento();
        Departamento departamento2 = new Departamento();
        Departamento departamento3 = new Departamento();

        departamento1.setName("TI");
        departamento2.setName("ADM");
        departamento3.setName("FINANCEIRO");

        departamentoService.save(departamento1);
        departamentoService.save(departamento2);
        departamentoService.save(departamento3);


        /* --------------------------- VENDEDOR -------------------------------*/
        VendedorService vendedorService = DaoFactory.criarVendedorService();

        Vendedor vendedor1 = new Vendedor(null, "Matheus Magalhães", "matheus.magalha95@gmail.com", LocalDate.now(),
                3000.50, departamento1);

        Vendedor vendedor2 = new Vendedor(null, "Maria Nascimento", "maria@gmail.com", LocalDate.now(),
                10000.50, departamento3);

        Vendedor vendedor3 = new Vendedor(null, "Paulo Augusto", "paulo@gmail.com", LocalDate.now(),
                6500.50, departamento3);

        Vendedor vendedor4 = new Vendedor(null, "Luiza dos Santos", "luiza@gmail.com", LocalDate.now(),
                2500.50, departamento2);

        Arrays.asList(vendedor1, vendedor2, vendedor3, vendedor4).forEach(v -> vendedorService.save(v));


        /* --------------------------- PEDIDO -------------------------------*/
        PedidoService pedidoService = DaoFactory.criarPedidoDAO();

        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        Pedido pedido3 = new Pedido();
        Pedido pedido4 = new Pedido();
        Pedido pedido5 = new Pedido();

        pedido1.setDataPedido(LocalDateTime.now());
        pedido1.setStatus("PENDENTE");
        pedido1.setVendedor(vendedor2);
        pedido2.setDataPedido(LocalDateTime.now());
        pedido2.setStatus("PAGO");
        pedido2.setVendedor(vendedor1);
        pedido3.setDataPedido(LocalDateTime.now());
        pedido3.setStatus("ENVIADO");
        pedido3.setVendedor(vendedor3);
        pedido4.setDataPedido(LocalDateTime.now());
        pedido4.setStatus("ENVIADO");
        pedido4.setVendedor(vendedor1);
        pedido5.setStatus("PAGO");
        pedido5.setVendedor(vendedor4);

        Arrays.asList(pedido1, pedido2, pedido3, pedido4, pedido5).forEach(p -> pedidoService.save(p));


        /* --------------------------- PRODUTO -------------------------------*/
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

        p1.getPedidos().add(pedido1);
        p1.getPedidos().add(pedido4);

        p2.getPedidos().add(pedido4);
        p2.getPedidos().add(pedido1);

        p3.getPedidos().add(pedido1);

        p4.getPedidos().add(pedido1);
        p4.getPedidos().add(pedido3);
        p4.getPedidos().add(pedido2);

        List<Produto> produtos = Arrays.asList(p1, p2, p3, p4);

        produtos.forEach(p -> produtoService.save(p));


        System.out.println("\nimprimindo todos os produtos");
        produtos = produtoService.findAll(Produto.class.getName());
        produtos.forEach(p -> System.out.println(p));


        // Soma dos produtos
        System.out.println("Buscando o valor de média dos produtos: ");
        System.out.println("O valor total dos produtos é: " + produtoService.valorTotalProdutos());


        // buscando relatorio
        System.out.println("---------------- relatorio de vendas ----------------------- ");
        List<Object[]> relatorio = produtoService.relatorioDeVendas1();

        for (Object[] obj : relatorio) {
            System.out.println(obj[0] + " - " + obj[1] + " - " + obj[2] + "\n");
        }

        System.out.println("\nBUscando relatorio POJO");
        List<RelatorioDeVendasPOJO> relatorio2 = produtoService.relatorioDeVendas2();
        relatorio2.forEach(x -> System.out.println(x));


        // consultando todos os produtos, dado o nome de uma categoria

        System.out.println("\n-> consultando todos os produtos, dado o nome de uma categoria");

        produtoService.buscarPorNomeDaCategoria("Computadores").forEach(System.out::println);

        ConnectionFactory.closeEntityManagerFactory();
    }
}
