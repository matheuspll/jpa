package br.gov.ac.sefaz.vendas.service;

import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Categoria;
import br.gov.ac.sefaz.vendas.model.Pedido;

import javax.persistence.EntityManagerFactory;

public class PedidoService extends DAO<Pedido> {

    public PedidoService(EntityManagerFactory emf) {
        super(emf);
    }
}
