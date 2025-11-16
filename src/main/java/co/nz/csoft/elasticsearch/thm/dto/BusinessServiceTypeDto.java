package co.nz.csoft.elasticsearch.thm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessServiceTypeDto {
    private Long id;
    private String name;
    private String description;
    private int capacityPerSlot;
    private Date startDate;
    private Date endDate;
    private String serviceTags;
    private List<String> serviceTagList;
    private String businessTermLocation;
    private String businessTermResource;
    private String businessLocationName;
    private String customerLocationName;
    private Boolean canChangeBusinessAddress;
    private String bookingButtonLabelText;


    private SlotAvailabilityDto slotAvailabilityDto;
    private SlotPricingDto slotPricingDto;
    private Long durationInMinutes;
    private Long businessServiceId;

    private Boolean isBookable;

    public List<SlotDto> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotDto> slots) {
        this.slots = slots;
    }

    private List<SlotDto> slots;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacityPerSlot() {
        return capacityPerSlot;
    }

    public void setCapacityPerSlot(int capacityPerSlot) {
        this.capacityPerSlot = capacityPerSlot;
    }

    public String getServiceTags() {
        return serviceTags;
    }

    public void setServiceTags(String serviceTags) {
        this.serviceTags = serviceTags;
    }
    public String getBusinessTermLocation() {
        return businessTermLocation;
    }

    public void setBusinessTermLocation(String businessTermLocation) {
        this.businessTermLocation = businessTermLocation;
    }

    public String getBusinessTermResource() {
        return businessTermResource;
    }

    public void setBusinessTermResource(String businessTermResource) {
        this.businessTermResource = businessTermResource;
    }
    public List<String> getServiceTagList() {
        return serviceTagList;
    }

    public void setServiceTagList(List<String> serviceTagList) {
        this.serviceTagList = serviceTagList;
    }
    public SlotAvailabilityDto getSlotAvailabilityDto() {
        return slotAvailabilityDto;
    }

    public void setSlotAvailabilityDto(SlotAvailabilityDto slotAvailabilityDto) {
        this.slotAvailabilityDto = slotAvailabilityDto;
    }

    public SlotPricingDto getSlotPricingDto() {
        return slotPricingDto;
    }

    public void setSlotPricingDto(SlotPricingDto slotPricingDto) {
        this.slotPricingDto = slotPricingDto;
    }
    public Long getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Long durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
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
    public Long getBusinessServiceId() {
        return businessServiceId;
    }

    public void setBusinessServiceId(Long businessServiceId) {
        this.businessServiceId = businessServiceId;
    }
    public String getBusinessLocationName() {
        return businessLocationName;
    }

    public void setBusinessLocationName(String businessLocationName) {
        this.businessLocationName = businessLocationName;
    }

    public String getCustomerLocationName() {
        return customerLocationName;
    }

    public void setCustomerLocationName(String customerLocationName) {
        this.customerLocationName = customerLocationName;
    }

    public Boolean getCanChangeBusinessAddress() {
        return canChangeBusinessAddress;
    }

    public void setCanChangeBusinessAddress(Boolean canChangeBusinessAddress) {
        this.canChangeBusinessAddress = canChangeBusinessAddress;
    }
    public Boolean getBookable() {
        return isBookable;
    }

    public void setBookable(Boolean bookable) {
        isBookable = bookable;
    }
    public String getBookingButtonLabelText() {
        return bookingButtonLabelText;
    }

    public void setBookingButtonLabelText(String bookingButtonLabelText) {
        this.bookingButtonLabelText = bookingButtonLabelText;
    }

    @Override
    public String toString() {
        return "BusinessServiceTypeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacityPerSlot=" + capacityPerSlot +
                '}';
    }


}
