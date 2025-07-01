package com.synergisticit.day01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.synergisticit.domain.Address;
import com.synergisticit.domain.Employee;

public class App {
    public static void main(String[] args) {
    	/*
    	spring-core: spring-core-6.2.7 .jar, sping-jcl-6.2.7.jar
    	 spring-beans: spring-core-6.2.7 .jar, sping-jcl-6.2.7.jar
    	 spring- context: spring-core-6.2.7 .jar, sping-jcl-6.2.7.jar
    	 spring- context: spring-aop-6.2.7 .jar, expression-jcl-6.2.7.jar, micrometer-observation
    	 micrometer- commons -1.12.7.jar
    	*/
    	
    	
    	// Legacy way of creating objects
    	Employee e = new Employee(1, "Oscar", "Programer", 15000);
    	
    	Address addr = new Address();
    	addr.setAddressLine1("al1");
    	addr.setAddressLine2("al2");
    	addr.setCity("city1");
    	addr.setState("state1");
    	addr.setCountry("country1");
    	
    	e.setAddress(addr);
    	System.out.println(e);
    	
    	
    	// ASK Spring framewaork to create objects 
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); 
    	context.getBean("e1");
    }
}
