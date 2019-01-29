package com.example.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.back.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
