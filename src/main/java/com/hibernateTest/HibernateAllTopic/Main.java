package com.hibernateTest.HibernateAllTopic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static Session session = sessionFactory.openSession();

	public static void main(String[] args) {
	    insertData();

		 //getData();
	}

	private static void getData() {
		QuesCategory quesCategory = session.get(QuesCategory.class, 1);
		System.out.println(quesCategory);
	}

	private static void insertData() {
		QuesCategory quesCategory = new QuesCategory();
		quesCategory.setCategoryName("Java");
		
		  
		  Question question1 = new Question();
		  question1.setQuestionName("what is java programming ?"); List<String> options
		  = new ArrayList<String>(); options.add("high level");
		  options.add("low level"); options.add("mid level");
		  question1.setOptions(options); question1.setCorrectAnswer("high level");
		  question1.setQuestions(quesCategory);
		  
		  Question question2 = new Question();
		  question2.setQuestionName("how many type of variable?"); List<String>
		  options1 = new ArrayList<String>(); options1.add("one"); options1.add("two");
		  options1.add("four"); question2.setOptions(options1);
		  question2.setCorrectAnswer("four"); question2.setQuestions(quesCategory);
		 

		Question question3 = new Question();
		question3.setQuestionName("how many data type in java?");
		List<String> options3 = new ArrayList<String>();
		options3.add("1");
		options3.add("2");
		options3.add("3");
		question3.setOptions(options3);
		question3.setCorrectAnswer("2");
		question3.setQuestions(quesCategory);

		session.beginTransaction();
		session.save(question2);
		session.save(question1);
		session.save(question3);
		session.getTransaction().commit();
	}

}
