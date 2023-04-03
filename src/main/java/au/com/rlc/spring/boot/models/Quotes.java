package au.com.rlc.spring.boot.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import au.com.rlc.spring.boot.payload.request.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Quotes")
public class Quotes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1346172764310557644L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Double quoteNum;
	
	private Double quoteprice;
	
	private String comment;
	@Column(name="personid")
	private Long contactperson;
	@Column(name="client_id")
	private Long clientid;
	
	private Date createdDate;
	private String createdUser;
	private Date lastupdatedDate;
	private String updatedUser;
	
	private String active;

	
	
	/*
	 * @OneToMany(targetEntity = Contact_Persons.class,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumns({@JoinColumn(name ="client_id",referencedColumnName =
	 * "client_id")}) private List<Contact_Persons> contact_Persons;
	 */
   
  
    
	
	public Quotes() {
		super();
		
	}

	public Quotes(Double quoteNum, Double quoteprice, String comment, Long contactperson, Long clientid,
			Date createdDate, String createdUser, Date lastupdatedDate, String updatedUser, String active,
			List<Contact_Persons> contact_Persons) {
		super();
		this.quoteNum = quoteNum;
		this.quoteprice = quoteprice;
		this.comment = comment;
		this.contactperson = contactperson;
		this.clientid = clientid;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.lastupdatedDate = lastupdatedDate;
		this.updatedUser = updatedUser;
		this.active = active;
		//this.contact_Persons = contact_Persons;
	}

	/*
	 * public List<Contact_Persons> getContact_Persons() { return contact_Persons; }
	 * 
	 * public void setContact_Persons(List<Contact_Persons> contact_Persons) {
	 * this.contact_Persons = contact_Persons; }
	 */

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getLastupdatedDate() {
		return lastupdatedDate;
	}

	public void setLastupdatedDate(Date lastupdatedDate) {
		this.lastupdatedDate = lastupdatedDate;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	@Override
	public String toString() {
		return "Quotes [quoteNum=" + quoteNum + ", quoteprice=" + quoteprice + ", comment=" + comment
				+ ", contactperson=" + contactperson + ", clientid=" + clientid + ", createdDate=" + createdDate
				+ ", createdUser=" + createdUser + ", lastupdatedDate=" + lastupdatedDate + ", updatedUser="
				+ updatedUser + ", active=" + active +  "]";
	}

	public Double getQuoteNum() {
		return quoteNum;
	}

	public Long getContactperson() {
		return contactperson;
	}

	public void setContactperson(Long contactperson) {
		this.contactperson = contactperson;
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

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
	

}
