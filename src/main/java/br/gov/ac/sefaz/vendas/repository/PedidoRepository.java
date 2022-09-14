package br.gov.ac.sefaz.vendas.repository;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Pedido;

import javax.persistence.EntityManagerFactory;

public class PedidoRepository extends DAO<Pedido> {

    public PedidoRepository(EntityManagerFactory emf) {
        super(emf);
    }
}
