package br.gov.ac.sefaz.vendas.service;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Produto;

import javax.persistence.EntityManagerFactory;

public class ProdutoService extends DAO<Produto> {

    public ProdutoService(EntityManagerFactory emf) {
        super(emf); // usando o construtor do pai
    }
}
