package com.shdinesh.springcrud.repo;

import com.shdinesh.springcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
