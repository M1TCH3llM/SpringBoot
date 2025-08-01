package com.synergisticit.util;

import com.synergisticit.domain.Employee;
import com.synergisticit.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ComandLineRunner implements CommandLineRunner {

    private final EmployeeService employeeService;

    public ComandLineRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
        
    
    @Override
    public void run(String... args) {
    	
    	// CREATE
    	if (employeeService.findAll().isEmpty()) {  // seed only if DB is empty
            employeeService.save(new Employee("Afroz", "Programmer", 15556.0));
            employeeService.save(new Employee("Himvan", "Sr. Programmer", 17556.0));
            employeeService.save(new Employee("Oscar", "HR", 17556.0));
            employeeService.save(new Employee("Mike Zeber", "Tester", 15000.0));
            employeeService.save(new Employee("Pooja", "Sr. Programmer", 20000.0));
            employeeService.save(new Employee("Kalani", "CEO", 25000.0));
            employeeService.save(new Employee("Mitch", "Programmer", 15000.0));
            employeeService.save(new Employee("John", "UX", 17550.0));
            employeeService.save(new Employee("Alex", "Programmer", 16500.0));
         
            
            System.out.println("Sample employees created.");
        }
    	
    	//READ
        System.out.println("All Employees:");
        employeeService.findAll().forEach(System.out::println);
        
        //DELETE
        int deleteId = 2;
        
        System.out.println("\nDeleting employee record with id =" + deleteId);
        employeeService.deleteById(deleteId);          

        // Show remaining employees
        //READ
        employeeService.findAll().forEach(System.out::println);
        
        // UPDATE
        int updateId = 3;
        
        System.out.println("\n Updating Employee by Employee Id " + updateId);
        Employee emp = employeeService.findById(updateId)
        		.orElseThrow(() -> new RuntimeException("No employee with ID " + updateId));

        emp.setDesignation("Senior Developer");
        emp.setSalary(30000.0);
        employeeService.save(emp);

        System.out.println(" Updated: " + emp);
        employeeService.findAll().forEach(System.out::println);


//        
//        // DELETE
//        System.out.println("Deleting all employee records...");
//        employeeService.deleteAll();
//        // READ
//        System.out.println("After delete:");
//        employeeService.findAll().forEach(System.out::println);
    }
}

