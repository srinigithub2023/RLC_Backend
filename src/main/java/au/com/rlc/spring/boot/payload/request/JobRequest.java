package au.com.rlc.spring.boot.payload.request;

import java.io.Serializable;

public class JobRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4965801828079458172L;
	
	private JobDetails jobDetails;
	private Material material;
	private OutSource outSource;
	
	
	public JobDetails getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public OutSource getOutSource() {
		return outSource;
	}
	public void setOutSource(OutSource outSource) {
		this.outSource = outSource;
	}
	@Override
	public String toString() {
		return "JobRequest [jobDetails=" + jobDetails + ", material=" + material + ", outSource=" + outSource + "]";
	}
	
	

}
