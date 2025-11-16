package co.nz.csoft.elasticsearch.thm.dto;



import javax.persistence.Embedded;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SlotDate {

    Long id;
    Date date;
    private Location location;
    private Resource resource;
    private Date startDate;
    private Date finishDate;
    private String frequency;

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



    public List<SlotTimingDto> getSlotTimingDtos() {
        return slotTimingDtos;
    }

    public void setSlotTimingDtos(List<SlotTimingDto> slotTimingDtos) {
        this.slotTimingDtos = slotTimingDtos;
    }

    private List<SlotTimingDto> slotTimingDtos=new ArrayList<SlotTimingDto>();
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
    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

}
