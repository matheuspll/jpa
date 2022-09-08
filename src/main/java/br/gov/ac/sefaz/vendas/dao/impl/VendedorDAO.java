package br.gov.ac.sefaz.vendas.dao.impl;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Vendedor;

import javax.persistence.EntityManagerFactory;

public class VendedorDAO extends DAO<Vendedor> {

    public VendedorDAO(EntityManagerFactory emf) {
        super(emf);
    }


}
