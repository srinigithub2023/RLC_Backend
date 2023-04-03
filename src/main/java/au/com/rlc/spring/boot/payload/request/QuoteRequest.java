package au.com.rlc.spring.boot.payload.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class QuoteRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3076445588726399667L;

	private Double quoteNum;
	
	private Double quoteprice;
	
	private String comment;
	
	private Long contactperson;
	
	private Long clientid;
	
	private String createdDate;
	private String createdUser;
	private String lastupdatedDate;
	private String updatedUser;
	
	private String active;
	
	
	List<Person> persons = new ArrayList<Person>();
	
	

	public Double getQuoteNum() {
		return quoteNum;
	}

	public void setQuoteNum(Double quoteNum) {
		this.quoteNum = quoteNum;
	}

	public Double getQuoteprice() {
		return quoteprice;
	}

	public void setQuoteprice(Double quoteprice) {
		this.quoteprice = quoteprice;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getContactperson() {
		return contactperson;
	}

	public void setContactperson(Long contactperson) {
		this.contactperson = contactperson;
	}

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getLastupdatedDate() {
		return lastupdatedDate;
	}

	public void setLastupdatedDate(String lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "QuoteRequest [quoteNum=" + quoteNum + ", quoteprice=" + quoteprice + ", comment=" + comment
				+ ", contactperson=" + contactperson + ", clientid=" + clientid + ", createdDate=" + createdDate
				+ ", createdUser=" + createdUser + ", lastupdatedDate=" + lastupdatedDate + ", updatedUser="
				+ updatedUser + ", active=" + active + ", persons=" + persons + "]";
	}
	
	
	

}
