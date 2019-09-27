package br.com.fes.scoa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FES");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static EntityManager abreConexao() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		return em;
	}
	
	public static void commitEFechaConexao(EntityManager em) {
		em.getTransaction().commit();
		em.close();
	}

}
