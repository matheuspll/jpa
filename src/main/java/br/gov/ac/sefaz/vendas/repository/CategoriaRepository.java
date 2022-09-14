package br.gov.ac.sefaz.vendas.repository;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Categoria;

import javax.persistence.EntityManagerFactory;

public class CategoriaRepository extends DAO<Categoria> {

    public CategoriaRepository(EntityManagerFactory emf) {
        super(emf);
    }
}
