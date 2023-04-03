package au.com.rlc.spring.boot.payload.request;



public class Person {
	
	Long personid;
	
	public Long getPersonid() {
		return personid;
	}

	public void setPersonid(Long personid) {
		this.personid = personid;
	}

	String contactpersonname;
	
	
	
	String contactpersonmobile;

	
	
	@Override
	public String toString() {
		return "Person [contactpersonname=" + contactpersonname + ", contactpersonmobile=" + contactpersonmobile + "]";
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

	
	
	
}
