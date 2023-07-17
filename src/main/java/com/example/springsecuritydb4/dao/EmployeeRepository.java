package com.example.springsecuritydb4.dao;
import com.example.springsecuritydb4.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


        // add a method to sort by last name
        public List<Employee> findAllByOrderByLastNameAsc();

        //search by name
        public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
    }