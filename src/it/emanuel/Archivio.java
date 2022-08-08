package it.emanuel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class Archivio {
	
	public Archivio() {
		
	}
	
    public void insertEntity(Book libro) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(libro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void insertEntity(Magazine magazine) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(magazine);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void insertEntity(Prestito prestito) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(prestito);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
	
    public void removeEntity(String isbn) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
        	
        	Query query = entityManager.createNamedQuery("elementoPerISBN");
        	
        	query.setParameter( "isbn", isbn);
        	
        	List<ElementoCatalogo> resultList = query.getResultList();
        	
	        entityManager.getTransaction().begin();
	        ElementoCatalogo elemento = entityManager.find(ElementoCatalogo.class, resultList.get(0).getId());
	        entityManager.remove(elemento);
	        entityManager.getTransaction().commit();
        } catch(Exception e) {
        	System.out.println("errore");
        } finally {
        	entityManager.close();
        }
    }
    
    public List<ElementoCatalogo> search(String isbn){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<ElementoCatalogo> resultList = new ArrayList<ElementoCatalogo>();
        try {
        	
        	Query query = entityManager.createNamedQuery("elementoPerISBN");
        	
        	query.setParameter( "isbn", isbn);
        	
        	resultList = query.getResultList();
        	
	        entityManager.getTransaction().begin();
        } catch(Exception e) {
        	System.out.println("errore");
        } finally {
        	entityManager.close();
        }
        return resultList;
    }
    
    public List<ElementoCatalogo> searchByYear(String annoDiPubblicazione){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<ElementoCatalogo> resultList = new ArrayList<ElementoCatalogo>();
        try {
        	
        	Query query = entityManager.createNamedQuery("elementoPerPubblicazione");
        	
        	query.setParameter( "data", annoDiPubblicazione);
        	
        	resultList = query.getResultList();
        	
	        entityManager.getTransaction().begin();
        } catch(Exception e) {
        	System.out.println("errore");
        } finally {
        	entityManager.close();
        }
        return resultList;
    }
    
    public List<ElementoCatalogo> searchByAuthor(String autore){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<ElementoCatalogo> resultList = new ArrayList<ElementoCatalogo>();
        try {
        	
        	Query query = entityManager.createNamedQuery("elementoPerAutore");
        	
        	query.setParameter( "autore", autore);
        	
        	resultList = query.getResultList();
        	
	        entityManager.getTransaction().begin();
        } catch(Exception e) {
        	System.out.println("errore");
        } finally {
        	entityManager.close();
        }
        return resultList;
    }
    
    public List<ElementoCatalogo> searchByTitle(String titolo){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<ElementoCatalogo> resultList = new ArrayList<ElementoCatalogo>();
        try {
        	
        	Query query = entityManager.createNamedQuery("elementoPerTitolo");
        	
        	query.setParameter( "titolo", titolo);
        	
        	resultList = query.getResultList();
        	
	        entityManager.getTransaction().begin();
        } catch(Exception e) {
        	System.out.println("errore");
        } finally {
        	entityManager.close();
        }
        return resultList;
    }
    
    public List<ElementoCatalogo> searchByTessera(String numeroTessera){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<ElementoCatalogo> resultList = new ArrayList<ElementoCatalogo>();
        try {
        	
        	Query query = entityManager.createNamedQuery("elementoPerTesseraUtente");
        	
        	query.setParameter( "numeroTessera", numeroTessera);
        	
        	resultList = query.getResultList();
        	
	        entityManager.getTransaction().begin();
        } catch(Exception e) {
        	System.out.println("errore");
        } finally {
        	entityManager.close();
        }
        return resultList;
    }
    
}
