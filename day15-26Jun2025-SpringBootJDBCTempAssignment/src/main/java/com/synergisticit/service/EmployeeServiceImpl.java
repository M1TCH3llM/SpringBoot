package com.synergisticit.service;

import com.synergisticit.domain.Employee;
import com.synergisticit.repository.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao dao;

    public EmployeeServiceImpl(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public Employee save(Employee e) {
        return dao.save(e);
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}
