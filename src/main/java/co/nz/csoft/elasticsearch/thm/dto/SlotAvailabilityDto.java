package co.nz.csoft.elasticsearch.thm.dto;

import javax.persistence.Column;

public class SlotAvailabilityDto {
    private Long id;
    private Integer noOfBooked;
    private Integer noOfAvailable;
    private Integer noOfCancellation;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setNoOfAvailable(Integer noOfAvailable) {
        this.noOfAvailable = noOfAvailable;
    }

    public Integer getNoOfCancellation() {
        return noOfCancellation;
    }

    public void setNoOfCancellation(Integer noOfCancellation) {
        this.noOfCancellation = noOfCancellation;
    }





}
