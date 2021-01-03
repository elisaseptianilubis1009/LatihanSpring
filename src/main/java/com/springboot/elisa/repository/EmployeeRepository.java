package com.springboot.elisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.elisa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
