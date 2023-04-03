package au.com.rlc.spring.boot.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "RLC_JOBS")
public class Jobs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6911879828921107507L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long clientId;
	private Long quoteId;
	private String purchaseOrder;
	private String prefferedPrice;
	private String approvedMethod;
	private String approvedBy;
	private String drawingDate;
	private String duedate;
	private String comment;
	private Date created;
	private String createdBy;
	
	private String createdDate;
	private String createdUser;
	private String lastupdatedDate;
	private String updatedUser;
	
	private String active;
	
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
	@OneToMany(targetEntity = Materials.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="job_id",referencedColumnName = "id")
	private List<Materials> materialsLst;
	
	@OneToMany(targetEntity = Outsource.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="job_id",referencedColumnName = "id")
	private List<Outsource> outSourceLst;
	
	public List<Outsource> getOutSourceLst() {
		return outSourceLst;
	}
	public void setOutSourceLst(List<Outsource> outSourceLst) {
		this.outSourceLst = outSourceLst;
	}
	
	
	public Jobs() {}
	public Jobs(Long clientId, Long quoteId, String purchaseOrder, String prefferedPrice, String approvedMethod,
			String approvedBy, String drawingDate, String duedate, String comment, Date created, String createdBy) {
		super();
		this.clientId = clientId;
		this.quoteId = quoteId;
		this.purchaseOrder = purchaseOrder;
		this.prefferedPrice = prefferedPrice;
		this.approvedMethod = approvedMethod;
		this.approvedBy = approvedBy;
		this.drawingDate = drawingDate;
		this.duedate = duedate;
		this.comment = comment;
		this.created = created;
		this.createdBy = createdBy;
	}
	
	
	
	
	public List<Materials> getMaterialsLst() {
		return materialsLst;
	}
	public void setMaterialsLst(List<Materials> materialsLst) {
		this.materialsLst = materialsLst;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Override
	public String toString() {
		return "Jobs [clientId=" + clientId + ", quoteId=" + quoteId + ", purchaseOrder=" + purchaseOrder
				+ ", prefferedPrice=" + prefferedPrice + ", approvedMethod=" + approvedMethod + ", approvedBy="
				+ approvedBy + ", drawingDate=" + drawingDate + ", duedate=" + duedate + ", comment=" + comment
				+ ", created=" + created + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", createdUser=" + createdUser + ", lastupdatedDate=" + lastupdatedDate + ", updatedUser="
				+ updatedUser + ", active=" + active + ", materialsLst=" + materialsLst + ", outSourceLst="
				+ outSourceLst + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(Long quoteId) {
		this.quoteId = quoteId;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public String getPrefferedPrice() {
		return prefferedPrice;
	}
	public void setPrefferedPrice(String prefferedPrice) {
		this.prefferedPrice = prefferedPrice;
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
	public String getDrawingDate() {
		return drawingDate;
	}
	public void setDrawingDate(String drawingDate) {
		this.drawingDate = drawingDate;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
}
