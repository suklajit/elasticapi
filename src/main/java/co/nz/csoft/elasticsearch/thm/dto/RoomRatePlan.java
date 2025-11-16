package co.nz.csoft.elasticsearch.thm.dto;

import org.hibernate.annotations.Type;

import co.nz.csoft.elasticsearch.enums.DayOfTheWeek;
import co.nz.csoft.elasticsearch.enums.RoomTypeRestriction;
import co.nz.csoft.elasticsearch.enums.RoomTypeStatus;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class RoomRatePlan implements Serializable{
    private String code;
    private String name;
    private Date effectiveDate;
    private Date expiryDate;
    private String description;
    private Boolean active;
    private Boolean applicableToOta;
    private BigDecimal amount;
    private boolean isApplicableToOta;
    private Long roomId;
    private Integer deviationFromStandardPlan;
    private int minimumLengthOfStay;
    private int maximumLengthOfStay;
    private RoomTypeStatus status;
    private RoomTypeRestriction restriction;
    private String currencyCode;
    private int minimumOccupancy;
    private int maximumOccupancy;
    private BigDecimal extraChargePerPerson;
    private BigDecimal extraChargePerChild;
    private BigDecimal extraChargePerChild3To5yrs;
    private Integer noOfChildren;
    private List<DayOfTheWeek> dayOfTheWeekList;
    private List<PropertyServices> propertyServicesList = new ArrayList<PropertyServices>();
    private Boolean onedayPlan;
    @Type(type = "json")
	@Column(columnDefinition = "json")
    private List<OtaPlan> otaPlanList = new ArrayList<OtaPlan>();
    private Boolean nonRoomPlan;
    private Integer checkoutPeriod;
    
    public Integer getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(Integer noOfChildren) {
        this.noOfChildren = noOfChildren;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expireDate) {
        this.expiryDate = expireDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getApplicableToOta() {
        return applicableToOta;
    }

    public void setApplicableToOta(Boolean applicableToOta) {
        this.applicableToOta = applicableToOta;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public boolean isApplicableToOta() {
        return isApplicableToOta;
    }

    public void setApplicableToOta(boolean applicableToOta) {
        isApplicableToOta = applicableToOta;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    public Integer getDeviationFromStandardPlan() {
        return deviationFromStandardPlan;
    }

    public void setDeviationFromStandardPlan(Integer deviationFromStandardPlan) {
        this.deviationFromStandardPlan = deviationFromStandardPlan;
    }
    public int getMinimumLengthOfStay() {
        return minimumLengthOfStay;
    }

    public void setMinimumLengthOfStay(int minimumLengthOfStay) {
        this.minimumLengthOfStay = minimumLengthOfStay;
    }

    public int getMaximumLengthOfStay() {
        return maximumLengthOfStay;
    }

    public void setMaximumLengthOfStay(int maximumLengthOfStay) {
        this.maximumLengthOfStay = maximumLengthOfStay;
    }

    public RoomTypeStatus getStatus() {
        return status;
    }

    public void setStatus(RoomTypeStatus status) {
        this.status = status;
    }

    public RoomTypeRestriction getRestriction() {
        return restriction;
    }

    public void setRestriction(RoomTypeRestriction restriction) {
        this.restriction = restriction;
    }
    public int getMinimumOccupancy() {
        return minimumOccupancy;
    }

    public void setMinimumOccupancy(int minimumOccupancy) {
        this.minimumOccupancy = minimumOccupancy;
    }

    public int getMaximumOccupancy() {
        return maximumOccupancy;
    }

    public void setMaximumOccupancy(int maximumOccupancy) {
        this.maximumOccupancy = maximumOccupancy;
    }

    public BigDecimal getExtraChargePerPerson() {
        return extraChargePerPerson;
    }

    public void setExtraChargePerPerson(BigDecimal extraChargePerPerson) {
        this.extraChargePerPerson = extraChargePerPerson;
    }
    public BigDecimal getExtraChargePerChild() {
        return extraChargePerChild;
    }

    public void setExtraChargePerChild(BigDecimal extraChargePerChild) {
        this.extraChargePerChild = extraChargePerChild;
    }
    public List<DayOfTheWeek> getDayOfTheWeekList() {
        return dayOfTheWeekList;
    }

    public void setDayOfTheWeekList(List<DayOfTheWeek> dayOfTheWeekList) {
        this.dayOfTheWeekList = dayOfTheWeekList;
    }

    public BigDecimal getExtraChargePerChild3To5yrs() {
        return extraChargePerChild3To5yrs;
    }

    public void setExtraChargePerChild3To5yrs(BigDecimal extraChargePerChild3To5yrs) {
        this.extraChargePerChild3To5yrs = extraChargePerChild3To5yrs;
    }
    public List<PropertyServices> getPropertyServicesList() {
        return propertyServicesList;
    }

    public void setPropertyServicesList(List<PropertyServices> propertyServicesList) {
        this.propertyServicesList = propertyServicesList;
    }

    public Boolean getOnedayPlan() {
        return onedayPlan;
    }

    public void setOnedayPlan(Boolean onedayPlan) {
        this.onedayPlan = onedayPlan;
    }
    public List<OtaPlan> getOtaPlanList() {
		return otaPlanList;
	}

	public void setOtaPlanList(List<OtaPlan> otaPlanList) {
		this.otaPlanList = otaPlanList;
	}

	public Boolean getNonRoomPlan() {
		return nonRoomPlan;
	}

	public void setNonRoomPlan(Boolean nonRoomPlan) {
		this.nonRoomPlan = nonRoomPlan;
	}

	public Integer getCheckoutPeriod() {
		return checkoutPeriod;
	}

	public void setCheckoutPeriod(Integer checkoutPeriod) {
		this.checkoutPeriod = checkoutPeriod;
	}

	@Override
    public String toString() {
        return "RoomRatePlans{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", expiryDate=" + expiryDate +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", isApplicableToOta=" + isApplicableToOta +
                ", deviationFromStandardPlan=" + deviationFromStandardPlan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomRatePlan that = (RoomRatePlan) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(expiryDate, that.expiryDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, effectiveDate, expiryDate, description, active);
    }
}

