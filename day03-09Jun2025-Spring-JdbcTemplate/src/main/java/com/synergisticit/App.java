package com.synergisticit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
    	
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
     /*
    	GenericApplicationContext context = new GenericApplicationContext();
    	new XmlBeanDefinitionReader(context).loadBeanDefinitions("beans.xml");
    	*/
    	
    	
    	//context.refresh();
    	System.out.println("\nfetching bean named \"e1\" in singleton scope:");
    	System.out.println(context.getBean("e1"));
    	
    	
    	
    	System.out.println("\nNow fetching bean named \"e2\" in protype scope:");
    	System.out.println(context.getBean("e2"));
    	
    	
    	System.out.println("\nNo of Beans Avaialble: "+context.getBeanDefinitionCount());
    	String[] beans = context.getBeanDefinitionNames();
    	for(String bean : beans) {
    		System.out.println(bean);
    	}
    	
    	//context.close();
    }
}

/*
create table springdbJun2025.Employee(
	empId int not null,
	name varchar(100) not null,
	designation varchar(100) not null,
	salary int not null,
	primary key(empId)		
);
*/