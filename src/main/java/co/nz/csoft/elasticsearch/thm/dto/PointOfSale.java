package co.nz.csoft.elasticsearch.thm.dto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class PointOfSale implements Serializable{
    private String counterNumber;
    private String counterName;
    private String description;
    private List<String> operatorName;
    private Long propertyId;
    public String getCounterNumber() {
        return counterNumber;
    }

    public void setCounterNumber(String counterNumber) {
        this.counterNumber = counterNumber;
    }

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(List<String> operatorName) {
        this.operatorName = operatorName;
    }
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }


}
