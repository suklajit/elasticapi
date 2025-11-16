package co.nz.csoft.elasticsearch.thm.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

//@Entity
public class PropertyServices implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROPERTY_SERVICES_SEQ")
//    @SequenceGenerator(name = "PROPERTY_SERVICES_SEQ", sequenceName = "SEQUENCE_PROPERTY_SERVICES" ,initialValue = 1000, allocationSize = 1)
    private Long id;
    private Long organisationId;
    private String name;
    private String description ;
    private String logoUrl ;
    private String imageUrl ;
    private String businessType ;
    private String serviceType ;
    private BigDecimal afterTaxAmount;
    private BigDecimal beforeTaxAmount;
    private BigDecimal taxAmount;
    private Double taxPercentage;
    private BigDecimal servicePrice;
    private boolean applicableToChild;
    private boolean applicableToAdult;
    
    
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    public BigDecimal getAfterTaxAmount() {
        return afterTaxAmount;
    }

    public void setAfterTaxAmount(BigDecimal afterTaxAmount) {
        this.afterTaxAmount = afterTaxAmount;
    }

    public BigDecimal getBeforeTaxAmount() {
        return beforeTaxAmount;
    }

    public void setBeforeTaxAmount(BigDecimal beforeTaxAmount) {
        this.beforeTaxAmount = beforeTaxAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }
    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }
    public boolean isApplicableToChild() {
        return applicableToChild;
    }

    public void setApplicableToChild(boolean applicableToChild) {
        this.applicableToChild = applicableToChild;
    }

    public boolean getApplicableToAdult() {
        return applicableToAdult;
    }

    public void setApplicableToAdult(boolean applicableToAdult) {
        this.applicableToAdult = applicableToAdult;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyServices)) return false;
        PropertyServices that = (PropertyServices) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(organisationId, that.organisationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organisationId);
    }

}
