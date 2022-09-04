//package br.gov.ac.sefaz.vendas.util;
//
//import br.gov.ac.sefaz.vendas.dao.ConnectionFactory;
//import br.gov.ac.sefaz.vendas.dao.DAO;
//import br.gov.ac.sefaz.vendas.model.Departamento;
//import br.gov.ac.sefaz.vendas.model.Produto;
//import br.gov.ac.sefaz.vendas.model.Vendedor;
//
//import javax.persistence.EntityManager;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Program {
//    public static void main(String[] args) {
//
//        Produto p1 = new Produto();
//        p1.setName("Celular");
//
//        Produto p2 = new Produto();
//        p2.setName("Caixa de som");
//
//        Departamento dep1 = new Departamento();
//        Departamento dep2 = new Departamento();
//        Departamento dep3 = new Departamento();
//        dep1.setName("Contabilidade");
//        dep2.setName("TI");
//        dep3.setName("Administração");
//
//
//        Vendedor vend1 = new Vendedor(null, "Matheus", "magalha95@gmail.com", LocalDate.now(),
//                40000.30, dep2);
//
//        Vendedor vend2 = new Vendedor(null, "Gilberto", "Gilberto@gmail.com", LocalDate.now(),
//                4000.30, dep2);
//
//        Vendedor vend3 = new Vendedor(null, "Rodrigo", "Rodrigo@gmail.com", LocalDate.now(),
//                3000.30, dep1);
//
//        Vendedor vend4 = new Vendedor(null, "Roberto", "Roberto@gmail.com", LocalDate.now(),
//                20000.30, dep3);
//
//        EntityManager entityManager = ConnectionFactory.getEntityManager();
//
//        // persistindo
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(p1);
//        entityManager.persist(p2);
//
//        entityManager.persist(dep1);
//        entityManager.persist(dep2);
//        entityManager.persist(dep3);
//
//        entityManager.persist(vend1);
//        entityManager.persist(vend2);
//        entityManager.persist(vend3);
//        entityManager.persist(vend4);
//
//        entityManager.getTransaction().commit();
//
//        System.out.println("------------ INICIANDO TESTE ---------------");
//
//        System.out.println("\n\n");
//
//        DAO<Produto> produtoDAO = new DAO<>();
//        DAO<Vendedor> vendedorDAO = new DAO<>();
//        DAO<Departamento> departamentoDAO = new DAO<>();
//
//        Produto produtop1 = produtoDAO.findById(Produto.class, 1L);
//
//        Vendedor vendedor1 = vendedorDAO.findById(Vendedor.class, 1L);
//
//        Departamento departamento1 = departamentoDAO.findById(Departamento.class, 1L);
//        Departamento departamento2 = departamentoDAO.findById(Departamento.class, 2L);
//
//        System.out.println(produtop1.getName());
//
//        System.out.println(vendedor1.getName());
//        System.out.println(vendedor1.getDepartamento().getVendedores());
//        System.out.println("Departamento do vendedor " + vendedor1.getName() + " é " + vendedor1.getDepartamento().getName());
//
//        System.out.println("departamento");
//        System.out.println(departamento1.getVendedores());
//
//        System.out.println(departamento2.getVendedores());
//
////        System.out.println("BUSCANDO TODOS OS PRODUTOS");
////        List<Produto> produtos = produtoDAO.findAll(Produto.class.getName()); // passa a String da classe
////        System.out.println(produtos);
//
////        System.out.println("BUSCANDO TODOS OS DEPARTAMENTOS");
////        List<Departamento> departamentos = departamentoDAO.findAll(Departamento.class.getName());
////        System.out.println(departamentos);
//
//        System.out.println("BUSCANDO TODOS OS VENDEDORES");
//        List<Vendedor> vendedores = vendedorDAO.findAll(Vendedor.class.getName());
//        System.out.println(vendedores);
//
//        System.out.println(vendedores.get(1).getDepartamento().getName());
//
//
//        entityManager.close();
//        produtoDAO.close();
//        vendedorDAO.close();
//    }
//}
