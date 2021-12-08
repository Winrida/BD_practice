package com.example.NotCursedWork.repository;

import com.example.NotCursedWork.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
