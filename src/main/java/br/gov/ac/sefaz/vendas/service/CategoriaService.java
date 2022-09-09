package br.gov.ac.sefaz.vendas.service;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Categoria;

import javax.persistence.EntityManagerFactory;

public class CategoriaService extends DAO<Categoria> {

    public CategoriaService(EntityManagerFactory emf) {
        super(emf);
    }
}
