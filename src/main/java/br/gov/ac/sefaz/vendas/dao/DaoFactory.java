package br.gov.ac.sefaz.vendas.dao;

import br.gov.ac.sefaz.vendas.repository.*;
import br.gov.ac.sefaz.vendas.util.ConnectionFactory;

public class DaoFactory {

    public static ProdutoRespository criarProdutoDAO() {
        return new ProdutoRespository(ConnectionFactory.getEntityManagerFactory("VendasPersistence"));
    }

    public static CategoriaRepository criarCategoriaDAO() {
        return new CategoriaRepository(ConnectionFactory.getEntityManagerFactory("VendasPersistence"));
    }

    public static PedidoRepository criarPedidoDAO() {
        return new PedidoRepository(ConnectionFactory.getEntityManagerFactory("VendasPersistence"));
    }

    public static DepartamentoRepository criarDepartamentoService() {
        return new DepartamentoRepository(ConnectionFactory.getEntityManagerFactory("VendasPersistence"));
    }

    public static VendedorRepository criarVendedorService() {
        return new VendedorRepository(ConnectionFactory.getEntityManagerFactory("VendasPersistence"));
    }
}
