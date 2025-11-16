package co.nz.csoft.elasticsearch.thm.dto;
import java.io.Serializable;
import java.math.BigDecimal;

public class ServiceCharge implements Serializable{
    private String code;
    private String name;
    private Double percentage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }








}
