package br.gov.ac.sefaz.vendas.dao;

import br.gov.ac.sefaz.vendas.service.CategoriaService;
import br.gov.ac.sefaz.vendas.service.ProdutoService;
import br.gov.ac.sefaz.vendas.util.ConnectionFactory;

public class DaoFactory {

    public static ProdutoService criarProdutoDAO() {
        return new ProdutoService(ConnectionFactory.getEntityManagerFactory("VendasPersistence"));

    }

    public static CategoriaService criarCategoriaDAO() {
        return new CategoriaService(ConnectionFactory.getEntityManagerFactory("VendasPersistence"));
    }
}
