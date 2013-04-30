package com.ben.cd.tool;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import com.ben.cd.tool.EntityManagerTool;

public class EntityManagerTool {

	   private static final Logger LOG = Logger.getLogger(EntityManagerTool.class.getSimpleName());

	    private static final EntityManagerFactory ENTITY_MANAGER =
	            Persistence.createEntityManagerFactory("cd");

	    private static final ThreadLocal<EntityManager> THREAD_LOCAL = new ThreadLocal<EntityManager>();

	    private EntityManagerTool(){
	    }
	    
	    /**
	     * Récupération d'un {@link EntityManager} avec gestion des transaction abstraite.
	     * 
	     * A n'utiliser qu'en contexte Web
	     * Ne pas utiliser depuis les classes de test.
	     * @return
	     */
	    public static EntityManager getEntityManager() {
	        EntityManager em = THREAD_LOCAL.get();
	        if (em == null) {
	            em = ENTITY_MANAGER.createEntityManager();
	            em.getTransaction().begin();
	            THREAD_LOCAL.set(em);
	        }
	        return em;
	    }

	    public static void closeEntityManager() {
	        EntityManager em = THREAD_LOCAL.get();
	        if (em != null && em.isOpen()) {
	            try {
	                if (em.getTransaction().isActive()) {
	                    em.getTransaction().commit();
	                }
	            } catch (RollbackException e) {
	                LOG.log(Level.SEVERE, "Problème lors de la fermeture de l'EntityManager", e);
	                em.getTransaction().rollback();
	            } finally {
	                em.close();
	            }
	        }
	        THREAD_LOCAL.set(null);
	    }

}
