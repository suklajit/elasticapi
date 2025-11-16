package co.nz.csoft.elasticsearch.thm.dto;


import com.fasterxml.jackson.annotation.JsonInclude;



import javax.persistence.Column;
import javax.persistence.Embedded;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Currency;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlotDto {
    private Long id;
    private Date date;
    private Long businessServiceId;
    private Long businessServiceTypeId;
    private String buinessServiceTypeName;
    private Long duration;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String finishTime;
    private boolean available;
    private Location location;
    private Resource resource;
    private Integer noOfBooked;
    private Integer noToBeBooked;
    private String modeOfPayment;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String companyName;
    private String dietaryRequirements;
    private Integer noOfAvailable;
    private BigDecimal beforeTax;
    private BigDecimal tax;
    private BigDecimal price;
    private String currency;
    private Long propertyId;
    private String propertyReservationNumber;
    private int count;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    private String day;

    public List<ResourceDto> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<ResourceDto> resourceList) {
        this.resourceList = resourceList;
    }

    private List<ResourceDto> resourceList;
    private List<SlotDate> slotDateList;

    public List<SlotDate> getSlotDateList() {
        return slotDateList;
    }

    public void setSlotDateList(List<SlotDate> slotDateList) {
        this.slotDateList = slotDateList;
    }




    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    private String frequency;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }






    public void setNoOfAvailable(Integer noOfAvailable) {
        this.noOfAvailable = noOfAvailable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getBusinessServiceId() {
        return businessServiceId;
    }

    public void setBusinessServiceId(Long businessServiceId) {
        this.businessServiceId = businessServiceId;
    }

    public Long getBusinessServiceTypeId() {
        return businessServiceTypeId;
    }

    public void setBusinessServiceTypeId(Long businessServiceTypeId) {
        this.businessServiceTypeId = businessServiceTypeId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
    public Integer getNoOfBooked() {
        return noOfBooked;
    }

    public void setNoOfBooked(Integer noOfBooked) {
        this.noOfBooked = noOfBooked;
    }

    public Integer getNoOfAvailable() {
        return noOfAvailable;
    }
    public Integer getNoToBeBooked() {
        return noToBeBooked;
    }

    public void setNoToBeBooked(Integer noToBeBooked) {
        this.noToBeBooked = noToBeBooked;
    }
    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDietaryRequirements() {
        return dietaryRequirements;
    }

    public void setDietaryRequirements(String dietaryRequirements) {
        this.dietaryRequirements = dietaryRequirements;
    }
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
    public String getPropertyReservationNumber() {
        return propertyReservationNumber;
    }

    public void setPropertyReservationNumber(String propertyReservationNumber) {
        this.propertyReservationNumber = propertyReservationNumber;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public BigDecimal getBeforeTax() {
        return beforeTax;
    }

    public void setBeforeTax(BigDecimal beforeTax) {
        this.beforeTax = beforeTax;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
    public String getBuinessServiceTypeName() {
        return buinessServiceTypeName;
    }

    public void setBuinessServiceTypeName(String buinessServiceTypeName) {
        this.buinessServiceTypeName = buinessServiceTypeName;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SlotDto{" +
                "id=" + id +
                ", date=" + date +
                ", businessServiceId=" + businessServiceId +
                ", businessServiceTypeId=" + businessServiceTypeId +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", available=" + available +
                ", location=" + location +
                ", resource=" + resource +
                ", noOfBooked=" + noOfBooked +
                ", noToBeBooked=" + noToBeBooked +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", companyName='" + companyName + '\'' +
                ", dietaryRequirements='" + dietaryRequirements + '\'' +
                ", noOfAvailable=" + noOfAvailable +
                ", beforeTax=" + beforeTax +
                ", tax=" + tax +
                ", price=" + price +
                ", propertyId=" + propertyId +
                ", propertyReservationNumber='" + propertyReservationNumber + '\'' +
                '}';
    }



}
