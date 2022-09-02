package br.gov.ac.sefaz.vendas.dao;

import br.gov.ac.sefaz.vendas.model.Base;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class DAO <T extends Base> implements Serializable {
    private static final long serialVersionUID = 1L;

    private final EntityManager em = ConnectionFactory.getEntityManager();
//
//    @PersistenceUnit
//    private EntityManagerFactory emf;

    public void save(T entity) {
        try {
            em.getTransaction().begin();
            if (entity.getId() == null) {
                em.persist(entity);
            } else {
                update(entity);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void update(T entity) {
        try {
            if (!em.contains(entity)) {
                if (em.find(entity.getClass(), entity.getId()) == null) {
                    throw new Exception("Erro ao atualizar");
                }
            }
            em.persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T findById(Class<T> entityClass, Long id) {
        return em.find(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(String className) {
//        Query query = em.createQuery(String.format("SELECT t from %s t"));
        Query query = em.createQuery("FROM " + className);
        return query.getResultList();
    }

    public void close() {
        em.close();
    }
}
