package com.nareshTechs.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.nareshTechs.model.Employee;

public class SelectOperation2 {

	public static void main(String[] args) {
		Configuration config=null;
		SessionFactory sessionFactory=null;
		Session session=null;
		try {
			config=new Configuration();
			config.configure();
			config.addAnnotatedClass(Employee.class);
			sessionFactory=config.buildSessionFactory();
			session=sessionFactory.openSession();
			//Employee employee=session.getReference(Employee.class,3);
			//Employee employee=session.load(Employee.class,3);
			Employee employee=session.get(Employee.class,3);

			if (employee != null) {
			    System.out.println("ID: " + employee.getEid());
			    System.in.read();
			    System.out.println("Name: " + employee.getEname());
			    System.out.println("AGE: " + employee.getEage());
			} else {
			    System.out.println("Employee not found for ID 3");
			}
			
		}catch (HibernateException e) {
			System.out.println("Hibernate Exception: "+e.getMessage());
		}catch (Exception e) {
			System.out.println("Unexpected Exception: "+e.getMessage());
		}finally {
			if(session!=null) {
				session.close();
			}
			if(sessionFactory!=null) {
				sessionFactory.close();
			}
		}

	}

}
