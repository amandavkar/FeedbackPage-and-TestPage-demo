package com.atul.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atul.entity.Queans;
import com.atul.entity.Question;

@Component
public class QuestionDAOService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveQuestion(Question que) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(que);
	}
	
	@Transactional
	public String getQuestions() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query q = currentSession.createQuery("from Question");
		List<Question> l = q.list();
		return l.toString();
	}
	
	@Transactional
	public List<Question> getTestQuestions() {
		Session currentSession = sessionFactory.getCurrentSession();
		NativeQuery<Question> q = currentSession.createNativeQuery("SELECT * FROM question order by rand() limit 5", Question.class);
		List<Question> questions = q.list();
		return questions;
	}

	@Transactional
	public int verifyAnswers(Queans queans) {
		
		int que[] = {queans.getQid1(), queans.getQid2(), queans.getQid3(), queans.getQid4(), queans.getQid5()};
		int ans[] = {queans.getAns1(), queans.getAns2(), queans.getAns3(), queans.getAns4(), queans.getAns5()};
		
		for (int j=0;j<5;j++) {
			System.out.println(que[j]+" : "+ans[j]);
		}
		
		int score = 0;
		for(int i=0; i<5; i++) {
			Session currentSession = sessionFactory.getCurrentSession();
			NativeQuery<Question> sql = (NativeQuery<Question>) currentSession.createNativeQuery("select * from question where qid="+que[i]+" and answer = "+ans[i], Question.class);
			if (sql.uniqueResult() != null) {
				score = score + 1;
			}
		}
		return score;
	}
}
