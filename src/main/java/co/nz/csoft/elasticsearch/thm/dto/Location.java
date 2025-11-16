package co.nz.csoft.elasticsearch.thm.dto;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Location implements Serializable {

    private Long locationBusinessServiceTypeId;
    private String locationName;
    private String locationDesc;
    private String locationImageUrl;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }
    public Long getLocationBusinessServiceTypeId() {
        return locationBusinessServiceTypeId;
    }

    public void setLocationBusinessServiceTypeId(Long locationBusinessServiceTypeId) {
        this.locationBusinessServiceTypeId = locationBusinessServiceTypeId;
    }
    public String getLocationImageUrl() {
        return locationImageUrl;
    }

    public void setLocationImageUrl(String locationImageUrl) {
        this.locationImageUrl = locationImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(locationName, location.locationName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationName);
    }




}
