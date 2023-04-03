package au.com.rlc.spring.boot.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Contact_Persons")
public class Contact_Persons implements Serializable {

	
	  @Override
	public String toString() {
		return "Contact_Persons [contactpersonname=" + contactpersonname + ", contactpersonmobile="
				+ contactpersonmobile + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6732571525455048481L;

	@Id
	  
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	 
	@Column(name="Contact_Person_Name")
	private String contactpersonname;
	
	@Column(name="Contact_Person_Mobile")
	private String contactpersonmobile;
	
	@Column(name="quote_id")
	private Long quoteid;
	
	@Column(name="client_id")
	private Long clientid;
	

	
	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	public Long getQuoteid() {
		return quoteid;
	}

	public void setQuoteid(Long quoteid) {
		this.quoteid = quoteid;
	}

	public Contact_Persons() {
		super();
		
	}

	public Contact_Persons(String contactpersonname, String contactpersonmobile) {
		super();
		this.contactpersonname = contactpersonname;
		this.contactpersonmobile = contactpersonmobile;
	}

	public String getContactpersonname() {
		return contactpersonname;
	}

	public void setContactpersonname(String contactpersonname) {
		this.contactpersonname = contactpersonname;
	}

	public String getContactpersonmobile() {
		return contactpersonmobile;
	}

	public void setContactpersonmobile(String contactpersonmobile) {
		this.contactpersonmobile = contactpersonmobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
