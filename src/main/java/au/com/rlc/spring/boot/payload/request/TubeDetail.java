package au.com.rlc.spring.boot.payload.request;

public class TubeDetail {

	String tubeMaterial;
	String tubeDimension;
	String tubeQuatity;
	
	public String getTubeMaterial() {
		return tubeMaterial;
	}
	public void setTubeMaterial(String tubeMaterial) {
		this.tubeMaterial = tubeMaterial;
	}
	public String getTubeDimension() {
		return tubeDimension;
	}
	public void setTubeDimension(String tubeDimension) {
		this.tubeDimension = tubeDimension;
	}
	public String getTubeQuatity() {
		return tubeQuatity;
	}
	public void setTubeQuatity(String tubeQuatity) {
		this.tubeQuatity = tubeQuatity;
	}
	@Override
	public String toString() {
		return "TubeDetail [tubeMaterial=" + tubeMaterial + ", tubeDimension=" + tubeDimension + ", tubeQuatity="
				+ tubeQuatity + "]";
	}
	
	
	
}
