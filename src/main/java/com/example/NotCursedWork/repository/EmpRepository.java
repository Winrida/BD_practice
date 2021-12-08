package com.example.NotCursedWork.repository;

import com.example.NotCursedWork.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee, Long> {
    @Query("from Employee where id.id=:id")
    List<Employee> findAllbyidId(@Param("id") Long id);
}
