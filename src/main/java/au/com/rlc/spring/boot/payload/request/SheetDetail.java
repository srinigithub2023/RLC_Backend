package au.com.rlc.spring.boot.payload.request;

public class SheetDetail {

	String sheetMaterial;
	String materialThinkness;
	
	public String getSheetMaterial() {
		return sheetMaterial;
	}
	public void setSheetMaterial(String sheetMaterial) {
		this.sheetMaterial = sheetMaterial;
	}
	public String getMaterialThinkness() {
		return materialThinkness;
	}
	public void setMaterialThinkness(String materialThinkness) {
		this.materialThinkness = materialThinkness;
	}
	@Override
	public String toString() {
		return "SheetDetail [sheetMaterial=" + sheetMaterial + ", materialThinkness=" + materialThinkness + "]";
	}
	
	
}
