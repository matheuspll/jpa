package br.gov.ac.sefaz.vendas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VendasPersistence");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
