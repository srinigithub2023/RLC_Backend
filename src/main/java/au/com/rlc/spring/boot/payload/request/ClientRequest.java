package au.com.rlc.spring.boot.payload.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientRequest {

	private String clientname;
	private String clientabn;
	private String telphone;
	private String email;
	private String billingaddress;
	private String shippingaddress;
	private  String createddate;
	private  String createdUser;
	
	List<Person> persons = new ArrayList<Person>(); 
	
	public String getClientabn() {
		return clientabn;
	}
	public void setClientabn(String clientabn) {
		this.clientabn = clientabn;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	
	

	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	@Override
	public String toString() {
		return "ClientRequest [clientname=" + clientname + ", clientabn=" + clientabn + ", telphone=" + telphone
				+ ", email=" + email + ", billingaddress=" + billingaddress + ", shippingaddress=" + shippingaddress
				+ ", createddate=" + createddate + ", createdUser=" + createdUser + ", persons=" + persons + "]";
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(String billingaddress) {
		this.billingaddress = billingaddress;
	}
	public String getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	

	
	/*
	 * clientname=aasfaaaas, cleintabn=adasda, telphone=1231324356,
	 * email=asdasd@scadas.com, billingaddress=zcacz, shippingaddress=asasd,
	 * persons=[{contactPersonName=Person1, contactPersonMobile=3123125534}]}
	 */


}
