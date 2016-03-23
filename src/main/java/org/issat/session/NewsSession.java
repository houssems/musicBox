package org.issat.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.issat.model.News;
import org.issat.model.Userprofile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class NewsSession {
	final Logger logger = LoggerFactory.getLogger(NewsSession.class);
	@PersistenceContext
    private EntityManager em;
	
	 public void create(News news) {
			em.persist(news);
			
		}

		public void edit(News news) {
			em.merge(news);
			
		}


		public void remove(News news) {
			em.remove(news);
			
		}

		public News find(Object id) {
			return  em.find(News.class, id);
		}
		public News findbyUrl(String url) {
			Query q=em.createQuery("select u from News u where u.url='"+url+"'");
			News u= null;
			if(q.getResultList().size()>0)
				u =(News) q.getSingleResult();
			
			return  u;
		}
		
		public List<News> findAll() {
			return em.createQuery("select u from News u order by u.id desc").getResultList();
		}
}
