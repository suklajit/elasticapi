package co.nz.csoft.elasticsearch.thm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceDto {

    private String name;
    private String desc;
    private String imageUrl;
    List<SlotTimingDto> bookedTimings;
    List<SlotTimingDto> availableTimings;

    public List<LocationDto> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<LocationDto> locationList) {
        this.locationList = locationList;
    }

    List<LocationDto> locationList;

    public List<SlotTimingDto> getAvailableTimings() {
        return availableTimings;
    }

    public void setAvailableTimings(List<SlotTimingDto> availableTimings) {
        this.availableTimings = availableTimings;
    }



    public List<SlotTimingDto> getBookedTimings() {
        return bookedTimings;
    }

    public void setBookedTimings(List<SlotTimingDto> bookedTimings) {
        this.bookedTimings = bookedTimings;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }





}
