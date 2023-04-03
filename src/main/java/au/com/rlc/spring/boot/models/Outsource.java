package au.com.rlc.spring.boot.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "RLC_OUTSOURCE")
public class Outsource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7681748254250497852L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String sourceType;
	private String company;
	
	
	
	public String getSourceType() {
		return sourceType;
	}


	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}


	public Outsource() {
		super();
	}


	public Outsource(String type, String company) {
		super();
		this.type = type;
		this.company = company;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Outsource [id=" + id + ", type=" + type + ", company=" + company  + "]";
	}

}
