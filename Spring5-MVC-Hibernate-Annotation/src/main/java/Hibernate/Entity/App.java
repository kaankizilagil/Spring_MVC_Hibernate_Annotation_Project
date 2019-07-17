package Hibernate.Entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.Util.HibernateUtil;

public class App 
{
	public static void main( String[] args )
    {
        
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        // Start a Transaction
        transaction = session.beginTransaction();

        transaction.commit();
       
        session = HibernateUtil.getSessionFactory().openSession();
    }
}