package au.com.rlc.spring.boot.payload.request;

public class OutSourceDetails {
	String type;
	String company;
	
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
		return "OutSourceDetails [type=" + type + ", company=" + company + "]";
	}
	
	
}
