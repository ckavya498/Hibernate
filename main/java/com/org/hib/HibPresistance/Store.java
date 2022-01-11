package com.org.hib.HibPresistance;

import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;    
    
public class Store {    
public static void main(String[] args) {    
      
	 System.out.println( "Hello World!" );
     Configuration  cfg= new Configuration();
     cfg.configure("hibernate.cfg.xml");
     SessionFactory fact = cfg.buildSessionFactory();
     Session sess= fact.openSession();
     sess.beginTransaction();
      
     // one-to-one mapping in hibernate
    Employee e1=new Employee();    
    e1.setName("kavya");    
    e1.setEmail("kavya@gmail.com");    
        
    Address address1=new Address();    
    address1.setAddressLine1("Chintamani");    
    address1.setCity("Chikkabalapur");    
    address1.setState("Karnataka");    
    address1.setCountry("India");    
    address1.setPincode(563125);    
        
    e1.setAddress(address1);    
    address1.setEmployee(e1);    
        
    sess.save(e1);
    sess.save(address1);
    sess.getTransaction().commit();
    System.out.println("success");    
}    
}    
