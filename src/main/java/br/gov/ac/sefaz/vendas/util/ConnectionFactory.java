package br.gov.ac.sefaz.vendas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName) {
        if (emf == null) {
            System.out.println("EntitityManagerFactory É nullo");
            try {
                emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null) {
            try {
                emf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//
//    public static EntityManager getEntityManager() {
//        try {
//            emf = getEntityManagerFactory();
//            em = emf.createEntityManager();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return em;
//    }
}
