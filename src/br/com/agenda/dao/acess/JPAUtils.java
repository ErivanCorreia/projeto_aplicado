/**
 * 
 */
package br.com.agenda.dao.acess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class JPAUtils {

	private static EntityManagerFactory emf;
	 
    public static EntityManager getEntityManager() {
         if (emf == null) {
            emf = Persistence.createEntityManagerFactory("agenda");
         }
         return emf.createEntityManager();
    }
}
