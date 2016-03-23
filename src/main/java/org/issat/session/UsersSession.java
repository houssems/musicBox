package org.issat.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.issat.model.Userprofile;
import org.issat.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class UsersSession {
	final Logger logger = LoggerFactory.getLogger(UsersSession.class);
    @PersistenceContext
    private EntityManager em;
    
    public void create(Userprofile personne) {
		em.persist(personne);
		
	}

	public void edit(Userprofile personne) {
		em.merge(personne);
		
	}


	public void remove(Userprofile personne) {
		em.remove(personne);
		
	}

	public Userprofile find(Object id) {
		return  em.find(Userprofile.class, id);
	}

	public Userprofile findSocial(String id,String social) {
		Query q=em.createQuery("select u from Userprofile u where u.idSocial='"+id+"' and u.Socialtype='"+social+"'");
		Userprofile u= null;
		if(q.getResultList().size()>0)
			u =(Userprofile) q.getSingleResult();
		
		return u;
		
	}

	
	public List<Userprofile> findAll() {
		return em.createQuery("select u from Userprofile u").getResultList();
	}
	
	public void delete(long id) {

        Query q = em.createQuery(
                "delete from Userprofile u where u.id = :id")
                .setParameter("id", id);
        q.executeUpdate();

    }
}
