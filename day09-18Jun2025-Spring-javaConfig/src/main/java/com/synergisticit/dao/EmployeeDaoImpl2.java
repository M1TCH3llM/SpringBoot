package com.synergisticit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.synergisticit.domain.Employee;

@Component(value="employeeDao2")

public class EmployeeDaoImpl2 implements EmployeeDao {
	
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Employee save(Employee e) {
		System.out.println("sessionFactory: "+sessionFactory);
		try(Session session = sessionFactory.openSession();){
			session.beginTransaction();
			session.save(e);
			session.getTransaction().commit();
			System.out.println("Saved employee using EmployeeDaoImpl2.");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return e;
	}

	@Override
	public Employee findById(int empId) {
		Employee e = null;
		
		try(Session session = sessionFactory.openSession();){
			session.beginTransaction();
			e = session.get(Employee.class, empId);
			System.out.println("EmployeeDaoImpl2.findById()...");
			System.out.println(e);
			session.getTransaction().commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = null;
		try(Session session = sessionFactory.openSession();){
			session.beginTransaction();
			employees = session.createQuery("from Employee").list();
			employees.forEach(e -> System.out.println(e) );
			session.getTransaction().commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee update(Employee e) {
		Employee updatedEmployee = null;
		try(Session session = sessionFactory.openSession();){
			session.beginTransaction();
			updatedEmployee = session.merge(e);
			session.getTransaction().commit();
			System.out.println("updatedEmployee: "+updatedEmployee);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return updatedEmployee;
	}

	@Override
	public void deleteById(int empId) {
		try(Session session = sessionFactory.openSession();){
			session.beginTransaction();
			Employee retrievedEmployee = session.get(Employee.class, empId);
			
			if(retrievedEmployee != null) {
				session.remove(retrievedEmployee);
				System.out.println("Employee record deleted..");
			}else {
				System.out.println("No employee record with empId="+empId);
			}
			session.getTransaction().commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		

	}

}
