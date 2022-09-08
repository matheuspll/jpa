package br.gov.ac.sefaz.vendas.dao;

import br.gov.ac.sefaz.vendas.model.Base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class DAO<T extends Base> implements Serializable {
    private static final long serialVersionUID = 1L;

    private EntityManager em = null;
    private final EntityManagerFactory emf;

    public DAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(T entity) {
        em = emf.createEntityManager();
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
        } finally {
            em.close();
        }
    }

    public void update(T entity) {
        em = emf.createEntityManager();
        try {
            if (!em.contains(entity)) { // se não tiver no contexto EM
                System.out.println("Não esta no contexto de persistencia");
                if (em.find(entity.getClass(), entity.getId()) == null) {
                    throw new Exception("Erro ao atualizar");
                }
            }
            em.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public T findById(Class<T> entityClass, Long id) {
        em = emf.createEntityManager();
        T t;
        try {
            t = em.find(entityClass, id);
        } finally {
            em.close();
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(String className) {
        em = emf.createEntityManager();
        try {
            // Query query = em.createQuery(String.format("SELECT t from %s t"));
            Query query = em.createQuery("FROM " + className);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void remove(Class<T> entityClass, Long id) {
        em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T t = findById(entityClass, id);
            em.remove(t);
            em.getTransaction().commit(); // confirma e finaliza a transação
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public EntityManager getEntityManager() {
        return em = emf.createEntityManager();
    }
}
