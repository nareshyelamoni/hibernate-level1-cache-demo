package com.nareshTechs.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import com.nareshTechs.model.Employee;

import jakarta.persistence.EntityExistsException;

public class SelectOperation {

	public static void main(String[] args) {
		Configuration config=null;
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			config=new Configuration();
			config.configure();
			config.addAnnotatedClass(Employee.class);
			sessionFactory=config.buildSessionFactory();
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			Employee employee=new Employee();
			employee.setEid(2);
			employee.setEname("JaiSrikrishna");
			employee.setEage(27);
			employee.setEcity("Hyd");
			session.persist(employee);
			transaction.commit();
			System.out.println("Transcation commited successfully");
			flag=true;
		}catch (EntityExistsException e) {
			System.out.println("Entity already exists: "+e.getMessage());
		}catch (ConstraintViolationException e) {
			System.out.println("Constrain Violation "+e.getMessage());
		}catch (HibernateException e) {
			System.out.println("Hibernate Exception: "+e.getMessage());
		}catch (Exception e) {
			System.out.println("Unexpected Exception: "+e.getMessage());
		}finally {
			if(!flag) {
				if(transaction!=null) {
					transaction.rollback();
					System.out.println("transaction rollback");
				}
			}
			if(session!=null) {
				session.close();
			}
			if(sessionFactory!=null) {
				sessionFactory.close();
			}
		}

	}

}
