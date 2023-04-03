package au.com.rlc.spring.boot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "RLC_EMPLOYEE_TIMESHEET", uniqueConstraints = { @UniqueConstraint(columnNames = "Id")})

public class EmployeeTimeSheet {

	@javax.persistence.Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emptimesheet_generator")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name="EmployeeID")
	private String employeeId;
	@Column(name="ShiftStartTime")
	private String startTime;
	@Column(name="ShiftEndTime")
	private String endTime;
	@Column(name="ShiftTotalTime")
	private String totalShiftTime;
	@Column(name="ShiftStartDate")
	private String date;
	@Column(name="ShiftEndDate")
	private String shiftendDate;
	@Column(name="Break1StartTime")
	private String break1startTime;
	@Column(name="Break1EndTime")
	private String break1endTime;
	@Column(name="Break2StartTime")
	private String break2startTime;
	@Column(name="Break2EndTime")
	private String break2endTime;
	@Column(name="TotalBreakTime")
	private String totalBreakTime;
	
	
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalShiftTime() {
		return totalShiftTime;
	}
	public void setTotalShiftTime(String totalShiftTime) {
		this.totalShiftTime = totalShiftTime;
	}
	public String getShiftendDate() {
		return shiftendDate;
	}
	public void setShiftendDate(String shiftendDate) {
		this.shiftendDate = shiftendDate;
	}
	public String getBreak1startTime() {
		return break1startTime;
	}
	public void setBreak1startTime(String break1startTime) {
		this.break1startTime = break1startTime;
	}
	public String getBreak1endTime() {
		return break1endTime;
	}
	public void setBreak1endTime(String break1endTime) {
		this.break1endTime = break1endTime;
	}
	public String getBreak2startTime() {
		return break2startTime;
	}
	public void setBreak2startTime(String break2startTime) {
		this.break2startTime = break2startTime;
	}
	public String getBreak2endTime() {
		return break2endTime;
	}
	public void setBreak2endTime(String break2endTime) {
		this.break2endTime = break2endTime;
	}
	public String getTotalBreakTime() {
		return totalBreakTime;
	}
	public void setTotalBreakTime(String totalBreakTime) {
		this.totalBreakTime = totalBreakTime;
	}
	@Override
	public String toString() {
		return "EmployeeTimeSheet [Id=" + Id + ", employeeId=" + employeeId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", totalShiftTime=" + totalShiftTime + ", date=" + date + ", shiftendDate=" + shiftendDate
				+ ", break1startTime=" + break1startTime + ", break1endTime=" + break1endTime + ", break2startTime="
				+ break2startTime + ", break2endTime=" + break2endTime + ", totalBreakTime=" + totalBreakTime + "]";
	}
	
	
	
	
}
