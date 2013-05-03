package com.ben.cd;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ben.cd.exception.TechnicalException;
import com.ben.cd.tool.EntityManagerTool;


public class CDService<T extends CDObject> {

    protected final EntityManager getEntityManager() {
        return EntityManagerTool.getEntityManager();
    }

    protected final T getById(Class<T> c, Object id) {
        if (id == null || c == null) {
            throw new TechnicalException("Paramètre d'appel à la méthode manquant ou null : c ou id");
        }
        return getEntityManager().find(c, id);
    }

    @SuppressWarnings("unchecked")
    protected final T getByUniqueKey(Class<T> c, String attribut, Object valeur) {
        if (valeur == null) {
            throw new TechnicalException("Paramètre d'appel à la méthode manquant ou null : valeur");
        }
        EntityManager em = getEntityManager();
        Query q = em.createQuery("SELECT o FROM " + c.getSimpleName() + " o WHERE " + attribut + " = :attribut");
        q.setParameter("attribut", valeur);
        return (T) q.getSingleResult();
    }

    protected T insertOrUpdate(T t) {
        if (t == null) {
            throw new TechnicalException("Paramètre d'appel à la méthode manquant ou null : t");
        } else if (t.getId() != null && t.getId() > 0) {
            update(t);
        } else {
            insert(t);
        }
        return t;
    }

    private void insert(T t) {
        EntityManager em = getEntityManager();
        em.persist(t);
        EntityManagerTool.closeEntityManager();
    }

    protected void delete(T t) {
        if (t == null) {
            throw new TechnicalException("Paramètre d'appel à la méthode manquant ou null : t");
        }
        getEntityManager().remove(t);
    }

    protected void deleteById(Class<T> c, Object id) {
        if (id == null || c == null) {
            throw new TechnicalException("Paramètre d'appel à la méthode manquant ou null : c ou id");
        }
        EntityManager em = getEntityManager();
        Query q = em.createQuery("DELETE FROM Album WHERE id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
    }

    private void update(T t) {
        getEntityManager().merge(t);
    }

    @SuppressWarnings("unchecked")
    protected final List<T> list(String query, Map<String, Object> parameters, Integer first, Integer limit) {
        EntityManager em = getEntityManager();
        Query select = em.createQuery(query);
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                select.setParameter(key, parameters.get(key));
            }
        }
        if (limit != null) {
            select.setMaxResults(limit);
        }
        if (first != null) {
            select.setFirstResult(first);
        }
        return (List<T>) select.getResultList();
    }

    @SuppressWarnings("unchecked")
    protected final <R> List<R> list(Class<R> c, String query, Map<String, Object> parameters) {
        EntityManager em = getEntityManager();
        Query select = em.createQuery(query);
        setParameterMap(select, parameters);
        return (List<R>) select.getResultList();
    }
    
    protected final void setParameterMap(Query q, Map<String, Object> parameters) {
        for (String key : parameters.keySet()) {
            q.setParameter(key, parameters.get(key));
        }
    }

    protected final void executeUpdate(String requete) {
        if (requete == null) {
            throw new TechnicalException("Paramètre d'appel à la méthode manquant ou null : requete");
        }
        getEntityManager().createQuery(requete).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    protected final List<T> list(Class<T> c) {
        EntityManager em = getEntityManager();
        Query q = em.createQuery("Select o from " + c.getSimpleName() + " o");
        return (List<T>) q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    protected final List<T> listOrdered(Class<T> c, List<String> columns) {
        if (columns == null) {
            throw new TechnicalException("Paramètre d'appel à la méthode manquant ou null : columns");
        }
        EntityManager em = getEntityManager();
        String concatColumns = "";
        for(String s : columns) {
        	concatColumns += s + ", ";
        }
        concatColumns = concatColumns.substring(0, concatColumns.lastIndexOf(','));
        Query q = em.createQuery("Select o from " + c.getSimpleName() + " o ORDER BY " + concatColumns);
        return (List<T>) q.getResultList();
    }
}