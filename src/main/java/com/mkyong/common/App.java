package com.mkyong.common;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.mkyong.persistence.HibernateUtil;

public class App {
    public static void main( String[] args ) {
    	
    	long startTime = System.currentTimeMillis();

    	
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        // Count how many records we have
        SQLQuery countSQL = session.createSQLQuery("select count(employeeid) from Employee");
        // delete all records before start filling db
        SQLQuery deleteSQL = session.createSQLQuery("delete from employee where 1=1");
        
        deleteSQL.executeUpdate();
        System.out.println("START * * * deleting table");
        
        
        List li = countSQL.list();
        System.out.println("      * * * total records" + li);

        
        for (int i = 0; i < 1000; i++) {
        	
        	WorkUnit.perform(session);
            
		}
		
        li = countSQL.list();
        System.out.println("START * * * total records" + li);
        

        System.out.print("Execution time is " + getTotalTime(startTime) + " seconds");
        
    }
    
    
    
    private static String getTotalTime(long startTime) {
        long endTime  = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        return formatter.format(totalTime / 1000d);
	}


}
