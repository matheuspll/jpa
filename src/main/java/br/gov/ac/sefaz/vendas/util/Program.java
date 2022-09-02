package br.gov.ac.sefaz.vendas.util;

import br.gov.ac.sefaz.vendas.dao.ConnectionFactory;
import br.gov.ac.sefaz.vendas.dao.DAO;
import br.gov.ac.sefaz.vendas.model.Departamento;
import br.gov.ac.sefaz.vendas.model.Produto;
import br.gov.ac.sefaz.vendas.model.Vendedor;

import javax.persistence.EntityManager;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {

        Produto p1 = new Produto(null, "Celular");
        Produto p2 = new Produto(null, "Caixa de som");

        Departamento dep1 = new Departamento(null, "Contabilidade");
        Departamento dep2 = new Departamento(null, "TI");
        Departamento dep3 = new Departamento(null, "Fiscal");


        Vendedor vend1 = new Vendedor(null, "Matheus", "magalha95@gmail.com", LocalDate.now(),
                40000.30, dep2);

        Vendedor vend2 = new Vendedor(null, "Gilberto", "Gilberto@gmail.com", LocalDate.now(),
                4000.30, dep2);

        Vendedor vend3 = new Vendedor(null, "Rodrigo", "Rodrigo@gmail.com", LocalDate.now(),
                3000.30, dep1);

        Vendedor vend4 = new Vendedor(null, "Roberto", "Roberto@gmail.com", LocalDate.now(),
                20000.30, dep3);

        EntityManager entityManager = ConnectionFactory.getEntityManager();

        // persistindo
        entityManager.getTransaction().begin();

        entityManager.persist(p1);
        entityManager.persist(p2);

        entityManager.persist(dep1);
        entityManager.persist(dep2);
        entityManager.persist(dep3);

        entityManager.persist(vend1);
        entityManager.persist(vend2);
        entityManager.persist(vend3);
        entityManager.persist(vend4);

        entityManager.getTransaction().commit();

        System.out.println("------------ INICIANDO TESTE ---------------");

        System.out.println("\n\n");

        DAO<Produto> produtoDAO = new DAO<>();
        DAO<Vendedor> vendedorDAO = new DAO<>();
        DAO<Departamento> departamentoDAO = new DAO<>();

        Produto produtop1 = produtoDAO.findById(Produto.class, 1L);

        Vendedor vendedor1 = vendedorDAO.findById(Vendedor.class, 1L);

        Departamento departamento1 = departamentoDAO.findById(Departamento.class, 1L);

        System.out.println(produtop1.getName());

        System.out.println(vendedor1.getName());
        System.out.println(vendedor1.getDepartamento().getVendedores());
        System.out.println("Departamento do vendedor " + vendedor1.getName() + " é " + vendedor1.getDepartamento().getName());

        System.out.println("departamento");
        System.out.println(departamento1.getVendedores());

        entityManager.close();
        produtoDAO.close();
        vendedorDAO.close();
    }
}
