package au.com.rlc.spring.boot.payload.response;

import java.util.Date;
import java.util.List;

public class JobsdetailsResponse {
	
	private String companyName;
	private String companyABN;
	private String purchaseOrder;
	private String approvedMethod;
	private String approvedBy;
	private String createDate;
	private String comment;
	private String created;
	private String jobExists;
	private Long quoteId;
	private List<au.com.rlc.spring.boot.payload.request.Person> contact_Persons;
	
	
	public String getJobExists() {
		return jobExists;
	}
	public void setJobExists(String jobExists) {
		this.jobExists = jobExists;
	}
	
	
 	
	public List<au.com.rlc.spring.boot.payload.request.Person> getContact_Persons() {
		return contact_Persons;
	}
	public void setContact_Persons(List<au.com.rlc.spring.boot.payload.request.Person> contact_Persons) {
		this.contact_Persons = contact_Persons;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public String getApprovedMethod() {
		return approvedMethod;
	}
	public void setApprovedMethod(String approvedMethod) {
		this.approvedMethod = approvedMethod;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public Long getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(Long quoteId) {
		this.quoteId = quoteId;
	}
	public String getCompanyABN() {
		return companyABN;
	}
	public void setCompanyABN(String companyABN) {
		this.companyABN = companyABN;
	}
	
	
}
