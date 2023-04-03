package au.com.rlc.spring.boot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import au.com.rlc.spring.boot.util.CustomSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "RLC_EMPLOYEE", uniqueConstraints = { @UniqueConstraint(columnNames = "Id") })
public class Employee {

	/*
	 * @javax.persistence.Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "employee_generator")
	 */
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@GenericGenerator(name="employee_generator", strategy = "au.com.rlc.spring.boot.util.CustomSequenceIdGenerator",
	parameters = {
			@Parameter(name =CustomSequenceIdGenerator.INCREMENT_PARAM, value="1"),
			@Parameter(name = CustomSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value="RLCE"),
			@Parameter(name = CustomSequenceIdGenerator.NUMBER_PREFIX_PARAMETER, value="%03d"),
	})
	private String Id;
	@Column(name="Title")
	private String title;
	@Column(name="FirstName")
	private String firstName;
	@Column(name="LastName")
	private String lastName;
	@Column(name="DOB")
	private String dateofBirth;
	@Column(name="Gender")
	private String gender;
	@Column(name="PhoneNumber")
	private String phoneNumber;
	@Column(name="Email")
	private String email;
	@Column(name="Address")
	private String address;
	@Column(name="EmployementStartDate")
	private String employmentStartDate;
	@Column(name="SuperAnuFundCompany")
	private String superAnufundcompany;
	@Column(name="SpuerAnuMemberNumber")
	private String superAnuMemeberNumber;
	@Column(name="TFN")
	private String taxFileNumber;
	@Column(name="AccountBSB")
	private String accountBSB;
	@Column(name="AccountNumber")
	private String accountNumber;
	
	@Column(name="EmployeeHourlyRate")
	private String employeeHourlyRate;
	
	public String getEmployeeHourlyRate() {
		return employeeHourlyRate;
	}
	public void setEmployeeHourlyRate(String employeeHourlyRate) {
		this.employeeHourlyRate = employeeHourlyRate;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmploymentStartDate() {
		return employmentStartDate;
	}
	public void setEmploymentStartDate(String employmentStartDate) {
		this.employmentStartDate = employmentStartDate;
	}

	public String getSuperAnufundcompany() {
		return superAnufundcompany;
	}
	public void setSuperAnufundcompany(String superAnufundcompany) {
		this.superAnufundcompany = superAnufundcompany;
	}
	public String getSuperAnuMemeberNumber() {
		return superAnuMemeberNumber;
	}
	public void setSuperAnuMemeberNumber(String superAnuMemeberNumber) {
		this.superAnuMemeberNumber = superAnuMemeberNumber;
	}
	public String getTaxFileNumber() {
		return taxFileNumber;
	}
	public void setTaxFileNumber(String taxFileNumber) {
		this.taxFileNumber = taxFileNumber;
	}
	public String getAccountBSB() {
		return accountBSB;
	}
	public void setAccountBSB(String accountBSB) {
		this.accountBSB = accountBSB;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
