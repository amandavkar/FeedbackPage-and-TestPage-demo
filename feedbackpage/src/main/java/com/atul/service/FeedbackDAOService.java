package com.atul.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atul.entity.Feedback;


@Component
public class FeedbackDAOService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional 
	public void addFeedback(Feedback fd) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(fd);
		System.out.println("Writing to DB");
		System.out.println(fd);
	}
	
	@Transactional
	public List<Feedback> getFeedback() {
		System.out.println("reading from DB");
		Session currentSession = sessionFactory.getCurrentSession();
		Query q = currentSession.createQuery("from Feedback");
		List<Feedback> l = q.list();
		return l;
	}
}

