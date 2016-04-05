package com.cit360.mpfinder.controller;

import java.util.Collections;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.cit360.mpfinder.MissingPersonFinderServer;
import com.cit360.mpfinder.model.Person;

public class PersonDAO{
	
	//creating a new record using a transaction...
	public void createPerson(Person person)  throws Exception{ 
	    //creating session object  
	    Session session = MissingPersonFinderServer.getHibernateUtil().openSession();
	      
	    //creating transaction object  
	    Transaction t = session.beginTransaction();  
	    
	    session.persist(person);//persisting the object  
	    
	    t.commit();//transaction is committed  
	    
	    if(session != null && session.isOpen())
			session.close();
	}
	
	//updating a record in 
	public void updatePerson(Person person)  throws Exception{
		//creating session object  
	    Session session = MissingPersonFinderServer.getHibernateUtil().openSession();

	    session.saveOrUpdate(person);//persisting the object  
	    
	    session.flush();
	    
	    if(session != null && session.isOpen())
			session.close();
	}

	//deleting a person record
	public void deletePerson(int personId)  throws Exception{
		//creating session object  
	    Session session = MissingPersonFinderServer.getHibernateUtil().openSession();
	      
	    Person person = new Person();
	    person.setPersonRecordId(personId);
	    session.delete(person);//persisting the object  
	    
	    session.flush();
	    
	    if(session != null && session.isOpen())
			session.close(); 
	}
	
	public Person getPerson(int personRecordId)  throws Exception{
		//creating session object  
	    Session session = MissingPersonFinderServer.getHibernateUtil().openSession();
		
		Person person = null;
		person = session.load(Person.class, personRecordId);
		Hibernate.initialize(person);
		
		if(session != null && session.isOpen())
			session.close();
		
		return person;
	}
	
	public List<Person> getPersons()  throws Exception{
		Session session = MissingPersonFinderServer.getHibernateUtil().openSession();
		
		//Collections.checkedList ensures that only objects of type Person.class are added to the generic List.
		@SuppressWarnings("unchecked")
		List<Person> persons = Collections.checkedList(session.createCriteria(Person.class).addOrder(Order.asc("PersonRecordId")).list(), Person.class);

		return persons;
	}
}
