package co.nz.csoft.elasticsearch.thm.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OtaPlan implements Serializable {

	private String otaPlanId;
	private String planName;
	private String bookonePlanCode;
	private String otaName;
	private BigDecimal price;

	public String getOtaPlanId() {
		return otaPlanId;
	}

	public void setOtaPlanId(String otaPlanId) {
		this.otaPlanId = otaPlanId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getBookonePlanCode() {
		return bookonePlanCode;
	}

	public void setBookonePlanCode(String bookonePlanCode) {
		this.bookonePlanCode = bookonePlanCode;
	}

	public String getOtaName() {
		return otaName;
	}

	public void setOtaName(String otaName) {
		this.otaName = otaName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
