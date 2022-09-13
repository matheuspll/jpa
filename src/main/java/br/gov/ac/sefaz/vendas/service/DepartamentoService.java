package br.gov.ac.sefaz.vendas.service;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Departamento;

import javax.persistence.EntityManagerFactory;

public class DepartamentoService extends DAO<Departamento> {

    public DepartamentoService(EntityManagerFactory emf) {
        super(emf);
    }

}
