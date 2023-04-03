package au.com.rlc.spring.boot.payload.request;

public class JobDetails {

	String purchaseorder;
	String fixedprice;
	String approvedmethod;
	String approvedby;
	String drawingdatetime;
	String duedatetime;
	String comment;
	
	public String getPurchaseorder() {
		return purchaseorder;
	}
	public void setPurchaseorder(String purchaseorder) {
		this.purchaseorder = purchaseorder;
	}
	public String getFixedprice() {
		return fixedprice;
	}
	public void setFixedprice(String fixedprice) {
		this.fixedprice = fixedprice;
	}
	public String getApprovedmethod() {
		return approvedmethod;
	}
	public void setApprovedmethod(String approvedmethod) {
		this.approvedmethod = approvedmethod;
	}
	public String getApprovedby() {
		return approvedby;
	}
	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}
	public String getDrawingdatetime() {
		return drawingdatetime;
	}
	public void setDrawingdatetime(String drawingdatetime) {
		this.drawingdatetime = drawingdatetime;
	}
	public String getDuedatetime() {
		return duedatetime;
	}
	public void setDuedatetime(String duedatetime) {
		this.duedatetime = duedatetime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "JobDetails [purchaseorder=" + purchaseorder + ", fixedprice=" + fixedprice + ", approvedmethod="
				+ approvedmethod + ", approvedby=" + approvedby + ", drawingdatetime=" + drawingdatetime
				+ ", duedatetime=" + duedatetime + ", comment=" + comment + "]";
	}
	
	
}
