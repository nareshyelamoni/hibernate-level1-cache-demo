package com.nareshTechs.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.nareshTechs.model.Employee;

public class Level1Caching {

	public static void main(String[] args) {
		Configuration config=null;
		SessionFactory sessionFactory=null;
		Session session1=null;
		Session session2=null;
		try {
			config=new Configuration();
			config.configure();
			config.addAnnotatedClass(Employee.class);
			sessionFactory=config.buildSessionFactory();
			session1=sessionFactory.openSession();
			session2=sessionFactory.openSession();
			//Employee employee=session.getReference(Employee.class,3);
			//Employee employee=session.load(Employee.class,3);
			Employee employee1=session1.get(Employee.class,2);
			System.out.println(employee1);
			Employee employee2=session1.get(Employee.class,2);
			System.out.println(employee2);
			System.out.println("****************************************");
			Employee employee3=session2.get(Employee.class,2);
			System.out.println(employee3);
			Employee employee4=session2.get(Employee.class,2);
			System.out.println(employee4);
			
		}catch (HibernateException e) {
			System.out.println("Hibernate Exception: "+e.getMessage());
		}catch (Exception e) {
			System.out.println("Unexpected Exception: "+e.getMessage());
		}finally {
			if(session1 != null) {
			    session1.close();
			}

			if(session2 != null) {
			    session2.close();
			}
			if(sessionFactory!=null) {
				sessionFactory.close();
			}
		}

	}

}
