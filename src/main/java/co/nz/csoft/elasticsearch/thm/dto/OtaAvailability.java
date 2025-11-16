package co.nz.csoft.elasticsearch.thm.dto;
import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class OtaAvailability implements Serializable{
	private String otaName;
	private int noOfAvailable;
	private Date fromDate;
	private Date toDate;
	private Long roomId;
	private Boolean lastUpdated;
	private Boolean stopSell;
	

	public Boolean getStopSell() {
		return stopSell;
	}

	public void setStopSell(Boolean stopSell) {
		this.stopSell = stopSell;
	}

	public String getOtaName() {
		return otaName;
	}

	public void setOtaName(String otaName) {
		this.otaName = otaName;
	}

	public int getNoOfAvailable() {
		return noOfAvailable;
	}

	public void setNoOfAvailable(int noOfAvailable) {
		this.noOfAvailable = noOfAvailable;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Boolean getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Boolean lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	@Override
	public String toString() {
	    return "OtaAvailability{" +
	            "otaName='" + otaName + '\'' +
	            ", noOfAvailable=" + noOfAvailable +
	            ", fromDate=" + fromDate +
	            ", toDate=" + toDate +
	            ", roomId=" + roomId +
	            ", lastUpdated=" + lastUpdated +
	            ", stopSell=" + stopSell +
	            '}';
	}

}
