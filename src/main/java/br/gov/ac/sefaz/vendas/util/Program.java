package br.gov.ac.sefaz.vendas.util;

import br.gov.ac.sefaz.vendas.model.Departamento;
import br.gov.ac.sefaz.vendas.model.Vendedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {

        Departamento dep1 = new Departamento(null, "Contabilidade");
        Departamento dep2 = new Departamento(null, "TI");
        Departamento dep3 = new Departamento(null, "Fiscal");

        System.out.println(LocalDateTime.now());

        Vendedor vend1 = new Vendedor(null, "Matheus", "magalha95@gmail.com", LocalDateTime.now(),
                40000.30, dep2);

        Vendedor vend2 = new Vendedor(null, "Gilberto", "Gilberto@gmail.com", LocalDateTime.now(),
                4000.30, dep2);

        Vendedor vend3 = new Vendedor(null, "Rodrigo", "Rodrigo@gmail.com", LocalDateTime.now(),
                3000.30, dep1);

        Vendedor vend4 = new Vendedor(null, "Roberto", "Roberto@gmail.com", LocalDateTime.now(),
                20000.30, dep3);

        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("VendasPersistence");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // persistindo
        entityManager.getTransaction().begin();

        entityManager.persist(dep1);
        entityManager.persist(dep2);
        entityManager.persist(dep3);

        entityManager.persist(vend1);
        entityManager.persist(vend2);
        entityManager.persist(vend3);
        entityManager.persist(vend4);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
