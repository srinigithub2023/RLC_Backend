/**
 * 
 */
package au.com.rlc.spring.boot.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import au.com.rlc.spring.boot.payload.request.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author srini
 *
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "RLC_CLIENTS", uniqueConstraints = { @UniqueConstraint(columnNames = "clientabn"),
		@UniqueConstraint(columnNames = "clientname") })
public class Clients implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1254538862110202326L;

	/**
	 * 
	 */
	public Clients() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String clientabn;
	@Column(name="clientname")
	private String clientname;
	private String telphonenum;
	private String emial;
	private String billingaddress;
	private String shippingaddress;
	
	private String active; 
	
	private String createdDate;
	private String createdUser;
	private String lastupdatedDate;
	private String updatedUser;
	
	
	
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
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

	@OneToMany(targetEntity = Contact_Persons.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="client_id",referencedColumnName = "id")
    private List<Contact_Persons> contact_Persons;
   

	public Clients(String clientabn, String clientname, String telphonenum, String emial, String billingaddress,
			String shippingaddress,List<Contact_Persons> contact_Persons ) {
		super();
		this.clientabn = clientabn;
		this.clientname = clientname;
		this.telphonenum = telphonenum;
		this.emial = emial;
		this.billingaddress = billingaddress;
		this.shippingaddress = shippingaddress;
		this.contact_Persons= contact_Persons;
	}

	public List<Contact_Persons> getContact_Persons() {
		return contact_Persons;
	}

	public void setContact_Persons(List<Contact_Persons> contact_Persons) {
		this.contact_Persons = contact_Persons;
	}

	@Override
	public String toString() {
		return "Clients [id=" + id + ", clientabn=" + clientabn + ", clientname=" + clientname + ", telphonenum="
				+ telphonenum + ", emial=" + emial + ", billingaddress=" + billingaddress + ", shippingaddress="
				+ shippingaddress + ", active=" + active + ", createdDate=" + createdDate + ", createdUser="
				+ createdUser + ", lastupdatedDate=" + lastupdatedDate + ", updatedUser=" + updatedUser
				+ ", contact_Persons=" + contact_Persons + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getTelphonenum() {
		return telphonenum;
	}

	public void setTelphonenum(String telphonenum) {
		this.telphonenum = telphonenum;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
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

	

}


