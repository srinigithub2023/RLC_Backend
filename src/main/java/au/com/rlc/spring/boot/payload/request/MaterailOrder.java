package au.com.rlc.spring.boot.payload.request;

public class MaterailOrder {

	String oderNumber;
	String orderBy;
	String supplier;
	String arriveddate;
	public String getOderNumber() {
		return oderNumber;
	}
	public void setOderNumber(String oderNumber) {
		this.oderNumber = oderNumber;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getArriveddate() {
		return arriveddate;
	}
	public void setArriveddate(String arriveddate) {
		this.arriveddate = arriveddate;
	}
	
	@Override
	public String toString() {
		return "MaterailOrder [oderNumber=" + oderNumber + ", orderBy=" + orderBy + ", supplier=" + supplier
				+ ", arriveddate=" + arriveddate + "]";
	}
	
	
	
}
