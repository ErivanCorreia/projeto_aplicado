package br.com.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.agenda.dao.acess.JPAUtils;
import br.com.agenda.model.Contato;

public class ContatoDao {

	private static JPAUtils instance;
	
	protected EntityManager entityManager;

	public static JPAUtils getInstance() {
		if (instance == null) {
			instance = new JPAUtils();
		}

		return instance;
	}

	public ContatoDao() {
		entityManager = JPAUtils.getEntityManager();
	}
	
	public Contato getbyId(Long id) {
		return  this.entityManager.find(Contato.class,id);
	}
	
	public List<Contato> list(){
		return this.entityManager.createNamedQuery("FROM " + Contato.class.getName()).getResultList();
	}
	
	public void add(Contato contato) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(contato);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	
	public void update(Contato contato) {
		try {
			
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(contato);
			this.entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void remover(Long idContato) {
		
		try {
			
			Contato contato = getbyId(idContato);
			this.entityManager.remove(contato);
			
		} catch (Exception e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
		}
		
	}
}
