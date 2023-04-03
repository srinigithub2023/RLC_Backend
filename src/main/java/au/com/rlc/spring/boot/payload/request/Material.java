package au.com.rlc.spring.boot.payload.request;

import java.util.List;

public class Material {
	
	Boolean sheet;
	Boolean tube;
	Boolean freeIssue;
	List<MaterailOrder> materailOrderArray;
	List<SheetDetail> sheetDetailsArray;
	List<TubeDetail> tubeDetailsArray;
	
	
	public Boolean getSheet() {
		return sheet;
	}
	public void setSheet(Boolean sheet) {
		this.sheet = sheet;
	}
	
	
	public Boolean getTube() {
		return tube;
	}
	public void setTube(Boolean tube) {
		this.tube = tube;
	}
	public Boolean getFreeIssue() {
		return freeIssue;
	}
	public void setFreeIssue(Boolean freeIssue) {
		this.freeIssue = freeIssue;
	}
	public List<MaterailOrder> getMaterailOrderArray() {
		return materailOrderArray;
	}
	public void setMaterailOrderArray(List<MaterailOrder> materailOrderArray) {
		this.materailOrderArray = materailOrderArray;
	}
	public List<SheetDetail> getSheetDetailsArray() {
		return sheetDetailsArray;
	}
	public void setSheetDetailsArray(List<SheetDetail> sheetDetailsArray) {
		this.sheetDetailsArray = sheetDetailsArray;
	}
	public List<TubeDetail> getTubeDetailsArray() {
		return tubeDetailsArray;
	}
	public void setTubeDetailsArray(List<TubeDetail> tubeDetailsArray) {
		this.tubeDetailsArray = tubeDetailsArray;
	}
	@Override
	public String toString() {
		return "Material [sheet=" + sheet + ", tube=" + tube + ", freeIssue=" + freeIssue + ", materailOrderArray="
				+ materailOrderArray + ", sheetDetailsArray=" + sheetDetailsArray + ", tubeDetailsArray="
				+ tubeDetailsArray + "]";
	}
	
	
	
}
