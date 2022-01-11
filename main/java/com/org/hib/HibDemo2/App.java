package com.org.hib.HibDemo2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.org.hib.HibPresistance.Address;
import com.org.hib.HibPresistance.Employee;

/**
 * Hello world!
 *
 */
//hibernate using annonations 
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Hello World!" );
        Configuration  cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory fact = cfg.buildSessionFactory();
        Session sess= fact.openSession();
        sess.beginTransaction();
        
        Book book=new Book();
        book.setBno(401);
        book.setBname("Java Complete Reference");
        book.setPrice(550);


        sess.save(book);
        sess.getTransaction().commit();
        System.out.println("saved successfully ");
        sess.close();
    }
}
