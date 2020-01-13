
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;
/**
 *
 * @author Ricardo
 */
public class Conexao {
    
    private final EntityManagerFactory emf; 


	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public Conexao() {
		emf = Persistence.createEntityManagerFactory("sistema");
	}
        
        public Session getSession(){
	    Session session = null;
	    
	    if (getEntityManager().getDelegate() instanceof EntityManagerImpl) {
	        EntityManagerImpl entityManagerImpl = (EntityManagerImpl) getEntityManager().getDelegate();
	       return entityManagerImpl.getSession();
	    } else {
	    	return (Session) getEntityManager().getDelegate();
	    }
	}
}
