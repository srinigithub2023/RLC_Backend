package au.com.rlc.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import au.com.rlc.spring.boot.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
