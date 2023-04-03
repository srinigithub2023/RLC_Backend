package au.com.rlc.spring.boot.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import au.com.rlc.spring.boot.exception.ResourceNotFoundException;
import au.com.rlc.spring.boot.models.Clients;
import au.com.rlc.spring.boot.models.Employee;
import au.com.rlc.spring.boot.models.EmployeeTimeSheet;
import au.com.rlc.spring.boot.payload.request.ClientRequest;
import au.com.rlc.spring.boot.repository.EmployeeRepository;
import au.com.rlc.spring.boot.repository.EmployeeTimeSheetRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository employeRepo;
	
	@Autowired
	EmployeeTimeSheetRepository employeeTimeSheetRepo;
	
	@PostMapping("/create")
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee  request) throws JsonProcessingException {
		logger.info(" Create Employee ", request.toString());
		
		Employee employee= employeRepo.save(request);
		
		logger.info("Employee Created Successfully ", employee.toString());
		return ResponseEntity.ok(employee);
		
	}
	
	@GetMapping("/emplyeList/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
		logger.info(" Searching  Employee with employid ", id);
		Employee employee = employeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		List<EmployeeTimeSheet> timesheetLst = employeeTimeSheetRepo.findByEmployeeIdAndDate(id, "2022-11-04");
		
		System.out.println("client ::==> in get :: ==>> :: " + timesheetLst.get(0).getTotalShiftTime());
		logger.info("Get Employee successfully");
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/updateEmplyee/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable String id, @RequestBody Employee request) {
		logger.info(" in  updateEmployeeById() ");
		request.setId(id);
		Employee employee= employeRepo.save(request);
		logger.info(" end  updateEmployeeById() ", employee);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/All")
	public ResponseEntity<List<Employee>> getEmployees() {
		logger.info(" in  getEmployees() ");
		List<Employee> employeeList = employeRepo.findAll();
		logger.info("Numnber of employee",employeeList.size());
		/*//Double hourlyrate= Double.valueOf(employeeList.get(0).getEmployeeHourlyRate());
		//Double minlyrate = hourlyrate/ 60;
		//logger.info("employee hourly rate :: ==>> :: " + hourlyrate);
		List<EmployeeTimeSheet> timesheetLst = employeeTimeSheetRepo.findByEmployeeIdAndDate("RLCE003", "2022-11-04");
		String strtotalShittime =timesheetLst.get(0).getTotalShiftTime();
		logger.info("strtotalShittime :: ==>> :: " + strtotalShittime);
		String str[]=strtotalShittime.split(":");
		String houres = str[0];
		String mins = str[1];
		Double toaltTimeinMins = (Double.valueOf(houres) * 60) + Double.valueOf(mins); */
		//Double toatlPay = minlyrate * toaltTimeinMins;
		//logger.info("toatlPay ==>> :: " + toatlPay);
		return ResponseEntity.ok(employeeList);
	}
	@PostMapping("/timesheet")
	public ResponseEntity<?> submitTimeSheet(@Valid @RequestBody EmployeeTimeSheet  request) throws JsonProcessingException {
		logger.info("in submitTimeSheet");
		List<EmployeeTimeSheet> timesheetLst= employeeTimeSheetRepo.findByEmployeeIdAndDate( request.getEmployeeId(), request.getDate());
		EmployeeTimeSheet employeeTimeSheet1= null;
		if(!timesheetLst.isEmpty() && timesheetLst.size()>0) {
			EmployeeTimeSheet employeeTimeSheet = timesheetLst.get(0);
			employeeTimeSheet.setStartTime(request.getStartTime());
			employeeTimeSheet.setEndTime(request.getEndTime());
			employeeTimeSheet.setBreak1startTime(request.getBreak1startTime());
			employeeTimeSheet.setBreak1endTime(request.getBreak1endTime());
			employeeTimeSheet.setBreak2startTime(request.getBreak2startTime());
			employeeTimeSheet.setBreak2endTime(request.getBreak2endTime());
			employeeTimeSheet.setTotalBreakTime(request.getTotalBreakTime());
			employeeTimeSheet.setTotalShiftTime(request.getTotalShiftTime());
			employeeTimeSheet.setDate(request.getDate());
			employeeTimeSheet.setShiftendDate(request.getShiftendDate());
			employeeTimeSheet1 = employeeTimeSheetRepo.save(employeeTimeSheet);
		}else {
			employeeTimeSheet1 = employeeTimeSheetRepo.save(request);
		}
		return ResponseEntity.ok(employeeTimeSheet1);
		
	}

	@GetMapping("/timesheet/{employeId}")
	public ResponseEntity<?>  getTimeSheetByEmployeeId(@PathVariable String employeId){
		logger.info("in getTimeSheetByEmployeeId");
		LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        EmployeeTimeSheet employeeTimeSheet1= null;
		List<EmployeeTimeSheet> timesheetLst= employeeTimeSheetRepo.findByEmployeeIdAndDate( employeId, date);
		if(!timesheetLst.isEmpty() && timesheetLst.size()>0) {
			employeeTimeSheet1 = timesheetLst.get(0);
		}else {
			employeeTimeSheet1 = new EmployeeTimeSheet();
		}
		
		return ResponseEntity.ok(employeeTimeSheet1);
		
	}
	

	@GetMapping("/timesheet/All")
	public ResponseEntity<List<EmployeeTimeSheet>> getEmployeeTimeSheets() {
		List<EmployeeTimeSheet> employeeTimeSheets = employeeTimeSheetRepo.findAll();
		logger.info("client ::==> in get :: ==>> :: " , employeeTimeSheets.size());
		return ResponseEntity.ok(employeeTimeSheets);
	}
	@PutMapping("/timesheet/{id}")
	public ResponseEntity<EmployeeTimeSheet> updateEmployeeTimeSheet(@PathVariable String id, @RequestBody EmployeeTimeSheet request) {
		logger.info("in updateEmployeeTimeSheet");
		List<EmployeeTimeSheet> timesheetLst= employeeTimeSheetRepo.findByEmployeeIdAndDate( request.getEmployeeId(), request.getDate());
		EmployeeTimeSheet employeeTimeSheet1= null;
		if(!timesheetLst.isEmpty() && timesheetLst.size()>0) {
			EmployeeTimeSheet employeeTimeSheet = timesheetLst.get(0);
			employeeTimeSheet.setStartTime(request.getStartTime());
			employeeTimeSheet.setEndTime(request.getEndTime());
			employeeTimeSheet.setBreak1startTime(request.getBreak1startTime());
			employeeTimeSheet.setBreak1endTime(request.getBreak1endTime());
			employeeTimeSheet.setBreak2startTime(request.getBreak2startTime());
			employeeTimeSheet.setBreak2endTime(request.getBreak2endTime());
			employeeTimeSheet.setTotalBreakTime(request.getTotalBreakTime());
			employeeTimeSheet.setTotalShiftTime(request.getTotalShiftTime());
			employeeTimeSheet.setDate(request.getDate());
			employeeTimeSheet.setShiftendDate(request.getShiftendDate());
			employeeTimeSheet1 = employeeTimeSheetRepo.save(employeeTimeSheet);
		}
		logger.info("end updateEmployeeTimeSheet");
		return ResponseEntity.ok(employeeTimeSheet1);
	}
	
	
}
