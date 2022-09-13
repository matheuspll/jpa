package br.gov.ac.sefaz.vendas.service;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Vendedor;

import javax.persistence.EntityManagerFactory;

public class VendedorService extends DAO<Vendedor> {

    public VendedorService(EntityManagerFactory emf) {
        super(emf);
    }
}
