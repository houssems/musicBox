package org.issat.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.issat.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ContactSession {
	
	final Logger logger = LoggerFactory.getLogger(ContactSession.class);
    @PersistenceContext
    private EntityManager em;
    
	public void create(Contact contact) {
        em.persist(contact);
    }
  
    public void edit(Contact contact) {
        em.merge(contact);
    }
  
    public void remove(Contact contact) {
        em.remove(em.merge(contact));
    }
  
    public Contact find(Object id) {
        return em.find(Contact.class, id);
    }
  
    public List<Contact> findAll() {
    	Query q = em.createQuery("select c from Contact c");
    	List<Contact> res = q.getResultList();
    	return res;
    }
    
    
}
