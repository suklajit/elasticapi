package co.nz.csoft.elasticsearch.thm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlotTimingDto {
    private Long id;
    private String startTime;
    private String finishTime;
    private Long duration;
    private SlotAvailabilityDto slotAvailabilityDto;
    private Date date;
    private String notes;

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

    private SlotPricingDto slotPricingDto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



}
