package com.dh.fullstack.users.service.model.repositories;

import com.dh.fullstack.users.service.model.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Santiago Mamani
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
