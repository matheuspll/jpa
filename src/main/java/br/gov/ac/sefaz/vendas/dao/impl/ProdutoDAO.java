package br.gov.ac.sefaz.vendas.dao.impl;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Produto;

import javax.persistence.EntityManagerFactory;

public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO(EntityManagerFactory emf) {
        super(emf);
    }
}
