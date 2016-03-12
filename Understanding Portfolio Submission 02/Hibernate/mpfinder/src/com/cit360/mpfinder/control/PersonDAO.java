package com.cit360.mpfinder.control;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cit360.mpfinder.MissingPersonFinder;
import com.cit360.mpfinder.model.Person;

public class PersonDAO{
	
	//creating a new record using a transaction...
	public void createPerson(Person person)  throws Exception{ 
	    //creating session object  
	    Session session = MissingPersonFinder.getHibernateUtil().openSession();
	      
	    //creating transaction object  
	    Transaction t = session.beginTransaction();  
	    
	    session.persist(person);//persisting the object  
	    
	    t.commit();//transaction is committed  
	    session.close();  
	}
	
	//updating a record in 
	public void updatePerson(Person person)  throws Exception{
		//creating session object  
	    Session session = MissingPersonFinder.getHibernateUtil().openSession();

	    session.saveOrUpdate(person);//persisting the object  
	    
	    session.flush();
	    session.close(); 
	}

	//deleting a person record
	public void deletePerson(int personId)  throws Exception{
		//creating session object  
	    Session session = MissingPersonFinder.getHibernateUtil().openSession();
	      
	    Person person = new Person();
	    person.setPersonRecordId(personId);
	    session.delete(person);//persisting the object  
	    
	    session.flush();
	    session.close(); 
	}
	
	public Person getPerson(int personRecordId)  throws HibernateException{
		return null;
	}
	
	public List<Person> getPersons(String searchString)  throws HibernateException{
		return null;
	}
}
