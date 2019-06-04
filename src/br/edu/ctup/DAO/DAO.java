package br.edu.ctup.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
	private EntityManagerFactory emf;
	
	public DAO() {
		emf = Persistence.createEntityManagerFactory("ProjetoBimestre");
	}
			
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}