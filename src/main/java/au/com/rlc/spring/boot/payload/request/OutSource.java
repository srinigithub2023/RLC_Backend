package au.com.rlc.spring.boot.payload.request;

import java.util.List;

public class OutSource {
	Boolean outsourcing;
	List<OutSourceDetails> outSourcingArray;
	
	public Boolean getOutsourcing() {
		return outsourcing;
	}
	public void setOutsourcing(Boolean outsourcing) {
		this.outsourcing = outsourcing;
	}
	public List<OutSourceDetails> getOutSourcingArray() {
		return outSourcingArray;
	}
	public void setOutSourcingArray(List<OutSourceDetails> outSourcingArray) {
		this.outSourcingArray = outSourcingArray;
	}
	
	@Override
	public String toString() {
		return "OutSource [outsourcing=" + outsourcing + ", outSourcingArray=" + outSourcingArray + "]";
	}
	
	
	
}
