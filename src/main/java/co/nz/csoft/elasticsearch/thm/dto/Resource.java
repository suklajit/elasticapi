package co.nz.csoft.elasticsearch.thm.dto;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Embeddable
public class Resource implements Serializable {

    private Long resourceBusinessServiceTypeId;
    private String resourceName;
    private String resourceDesc;
    private String resourceImageUrl;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<WorkingHours> workingHours=new ArrayList<WorkingHours>();

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }
    public Long getResourceBusinessServiceTypeId() {
        return resourceBusinessServiceTypeId;
    }

    public void setResourceBusinessServiceTypeId(Long resourceBusinessServiceTypeId) {
        this.resourceBusinessServiceTypeId = resourceBusinessServiceTypeId;
    }
    public List<WorkingHours> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<WorkingHours> workingHours) {
        this.workingHours = workingHours;
    }
    public String getResourceImageUrl() {
        return resourceImageUrl;
    }

    public void setResourceImageUrl(String resourceImageUrl) {
        this.resourceImageUrl = resourceImageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(resourceName, resource.resourceName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceName);
    }




}
