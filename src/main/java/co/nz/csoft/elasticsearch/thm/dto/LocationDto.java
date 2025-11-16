package co.nz.csoft.elasticsearch.thm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDto {
    private String name;
    private String desc;
    private String imageUrl;
    List<SlotTimingDto> bookedTimings;
    List<SlotTimingDto> availableTimings;

    List<ResourceDto> resources;

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

    public List<SlotTimingDto> getBookedTimings() {
        return bookedTimings;
    }

    public void setBookedTimings(List<SlotTimingDto> bookedTimings) {
        this.bookedTimings = bookedTimings;
    }

    public List<SlotTimingDto> getAvailableTimings() {
        return availableTimings;
    }

    public void setAvailableTimings(List<SlotTimingDto> availableTimings) {
        this.availableTimings = availableTimings;
    }
    public List<ResourceDto> getResources() {
        return resources;
    }

    public void setResources(List<ResourceDto> resources) {
        this.resources = resources;
    }

}
