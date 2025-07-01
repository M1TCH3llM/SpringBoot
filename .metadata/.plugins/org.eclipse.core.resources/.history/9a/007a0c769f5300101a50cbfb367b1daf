// src/main/java/com/synergisticit/service/EmployeeServiceImpl.java
package com.synergisticit.service;

import com.synergisticit.domain.Employee;
import com.synergisticit.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service        // <— marks this as a Spring bean
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override 
    public Employee save(Employee e) { 
    	return repo.save(e); 
    	}
    
    @Override 
    public List<Employee> findAll() { 
    	return repo.findAll(); 
    	}
    
    @Override 
    public Optional<Employee> findById(Integer id) { 
    	return repo.findById(id); 
    	}
    
    @Override 
    public void deleteById(Integer id) { 
    	repo.deleteById(id); 
    	}
    
    @Override
    public void deleteAll() {
        repo.deleteAll();
    }
}

