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
@Table(name = "RLC_MATERIALS")
public class Materials implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5139499763563948497L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String sheetThickness;
	private String sheetType;
	private String tubeDimensions;
	private String tubeQuantity;
	private String tubeType;
	private String orderNumber;
	private String orderBy;
	private String supplier;
	private String arrivalDate;
	
	
	
	
	
	public String getSheetType() {
		return sheetType;
	}

	public void setSheetType(String sheetType) {
		this.sheetType = sheetType;
	}

	public String getTubeType() {
		return tubeType;
	}

	public void setTubeType(String tubeType) {
		this.tubeType = tubeType;
	}

	public Materials() {
		super();
	}

	public Materials(String type, String sheetThickness, String tubeDimensions, String tubeQuantity, String orderNumber,
			String orderBy, String supplier, String arrivalDate) {
		super();
		this.type = type;
		this.sheetThickness = sheetThickness;
		this.tubeDimensions = tubeDimensions;
		this.tubeQuantity = tubeQuantity;
		this.orderNumber = orderNumber;
		this.orderBy = orderBy;
		this.supplier = supplier;
		this.arrivalDate = arrivalDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSheetThickness() {
		return sheetThickness;
	}

	public void setSheetThickness(String sheetThickness) {
		this.sheetThickness = sheetThickness;
	}

	public String getTubeDimensions() {
		return tubeDimensions;
	}

	public void setTubeDimensions(String tubeDimensions) {
		this.tubeDimensions = tubeDimensions;
	}

	public String getTubeQuantity() {
		return tubeQuantity;
	}

	public void setTubeQuantity(String tubeQuantity) {
		this.tubeQuantity = tubeQuantity;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "Materilas [id=" + id + ", type=" + type + ", sheetThickness=" + sheetThickness + ", tubeDimensions="
				+ tubeDimensions + ", tubeQuantity=" + tubeQuantity + ", orderNumber=" + orderNumber + ", orderBy="
				+ orderBy + ", supplier=" + supplier + ", arrivalDate=" + arrivalDate + "]";
	}
	
	
	
	
}
