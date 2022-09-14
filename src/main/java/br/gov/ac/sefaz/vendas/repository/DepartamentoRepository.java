package br.gov.ac.sefaz.vendas.repository;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Departamento;

import javax.persistence.EntityManagerFactory;

public class DepartamentoRepository extends DAO<Departamento> {

    public DepartamentoRepository(EntityManagerFactory emf) {
        super(emf);
    }

}
