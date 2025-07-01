package com.synergisticit.domain;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    private String name;
    private String designation;
    private Double salary;

    // --- constructors ---
    public Employee() {}
    public Employee(String name, String designation, Double salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    // --- getters & setters ---
    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Employee{" +
               "empId=" + empId +
               ", name='" + name + '\'' +
               ", designation='" + designation + '\'' +
               ", salary=" + salary +
               '}';
    }
}
