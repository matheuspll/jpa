package br.gov.ac.sefaz.vendas.repository;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Vendedor;

import javax.persistence.EntityManagerFactory;

public class VendedorRepository extends DAO<Vendedor> {

    public VendedorRepository(EntityManagerFactory emf) {
        super(emf);
    }
}
