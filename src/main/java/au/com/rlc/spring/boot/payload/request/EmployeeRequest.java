package au.com.rlc.spring.boot.payload.request;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeeRequest {


	private String title;
	
	private String firstName;
	
	private String lastName;
	
	private String dateofBirth;
	
	private String gender;
	
	private String phoneNumber;
	
	private String email;
	
	private String address;
	
	private String employmentStartDate;
	
	private String superAnufundcompany;
	
	private String superAnuMemeberNumber;
	
	private String taxFileNumber;
	
	private String accountBSB;
	
	private String accountNumber;

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
