package au.com.rlc.spring.boot.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.rlc.spring.boot.models.EmployeeTimeSheet;

public interface EmployeeTimeSheetRepository extends JpaRepository<EmployeeTimeSheet, Long>{
	
	List<EmployeeTimeSheet> findByEmployeeIdAndDate(String EmployeeId,String ShiftDate); 

}
