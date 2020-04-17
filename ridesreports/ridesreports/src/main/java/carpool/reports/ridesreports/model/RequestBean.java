/**
 * 
 */
package carpool.reports.ridesreports.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wizar
 *
 */
public class RequestBean {
	
	@JsonProperty("rideCode")
	private String rideCode;
	@JsonProperty("initialDate")
	private String initialDate;
	@JsonProperty("endDate")
	private String endDate;

	public String getRideCode() {
		return rideCode;
	}

	public void setRideCode(String rideCode) {
		this.rideCode = rideCode;
	}

	public String getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	

}
