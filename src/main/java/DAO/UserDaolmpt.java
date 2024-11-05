package DAO;

import java.util.List;

import entitys.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.XJpa;

public class UserDaolmpt implements interfaceDAO {
	
	EntityManager em = XJpa.getEntityManager();
	protected void finalize() throws Throwable {
		em.close();
	}
	@Override
	public List<User> findAll() {
		String jpql = "Select o from o";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		return query.getResultList() ;
	}

	@Override
	public User findById(String id) {
		return em.find(User.class, id);
	}

	@Override
	public void create(User item) {
		try {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		}catch (Exception e) {
		em.getTransaction().rollback();
		}
	}

	@Override
	public void update(User item) {
		try {
			em.getTransaction().begin();
			em.merge(item);
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void deleteById(String id) {
		User item = em.find(User.class, id);
		try {
			em.getTransaction().begin();
			em.remove(item);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			}
	}
	
}
