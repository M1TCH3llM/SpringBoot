package com.synergisticit.day01;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.synergisticit.domain.Address;
import com.synergisticit.domain.Employee;

public class App {
    public static void main(String[] args) {
    	
    	// Legacy way of creating
    	Employee e = new Employee(1, "Oscar", "Programer", 15000);
    	
    	Address addr = new Address();
    	addr.setAddressLine1("al1");
    	addr.setAddressLine2("al2");
    	addr.setCity("city1");
    	addr.setState("state1");
    	addr.setCountry("country1");
    	
    	e.setAddress(addr);
    	System.out.println(e);
    	
    	// =================================================
    	
    	
    	
    	// ASK Spring framewaork to create objects 
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); 
    	
    	
    	GenericApplicationContext context1 = new GenericApplicationContext();
    	new XmlBeanDefinitionReader(context1).loadBeanDefinitions("beans.xml");
    	
    	
    	context1.refresh();
    	//For a bean in singleton scope spring creates only one object for all requests of the bean
    	System.out.println("\nNow fetching bean named \"e1\" in protype scope:");
    	System.out.println(context1.getBean("e1"));
//    	System.out.println(context1.getBean("e1"));    	
//    	System.out.println(context1.getBean("e1"));
    	
//    	Employee e1 = (Employee)context.getBean("e1");
//    	Employee e2 = (Employee)context.getBean("e1");
//    	Employee e3 = (Employee)context.getBean("e1");
//    	System.out.println(e1);
//    	System.out.println(e2);
//    	System.out.println(e3);
    	
    	
    	// For Bean in prototype scope spring creates a new object every time bean is requested
    	System.out.println("\nNow fetching bean named \"e2\" in protype scope:");

    	System.out.println(context1.getBean("e2"));
//    	System.out.println(context1.getBean("e2"));    	
//    	System.out.println(context1.getBean("e2"));
    	
    	
//    	Employee e4 = (Employee)context.getBean("e2");
//    	Employee e5 = (Employee)context.getBean("e2");
//    	Employee e6 = (Employee)context.getBean("e3");
//    	System.out.println(e4);
//    	System.out.println(e5);
//    	System.out.println(e6);





    	
    	
    	// Duplicate beans not allowed. beans become duplicate when they have wither the same name of same id
    	String[] beans = context1.getBeanDefinitionNames();
    	for(String bean : beans) {
    		System.out.println(bean);
    	}
    	
    	context1.close();
    	
    }
}
