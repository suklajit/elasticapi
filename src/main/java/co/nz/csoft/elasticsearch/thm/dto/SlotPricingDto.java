package co.nz.csoft.elasticsearch.thm.dto;

import java.math.BigDecimal;

public class SlotPricingDto {
    Long id;
    private BigDecimal afterTaxAmount;
    private BigDecimal beforeTaxAmount;
    private BigDecimal taxAmount;
    private String currency;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





}
