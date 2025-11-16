package co.nz.csoft.elasticsearch.dto;


public class PropertiesOnlineTravelAgenciesDto {
    private Long id;
    private Long bookonePropertyId;
    private Long onlineTravelAgencyId;
    private String onlineTravelAgencyPropertyId;
    private Long organisationId;
    private Double bookingCommissionFee;
    private String bookingCommissionFeeType;
    private Double convenienceFee;
    private String convenienceFeeType;
    private String onlineTravelAgencyName;
    private String onlineTravelAgencyLogoUrl;
    private String onlineTravelAgencyLoginUrl;
    private String otaLoginId;
    private String otaPassword;
    //TDS and TCS information
    private String tdsType;
    private String tcsType;
    private Double tdsFee;
    private Double tcsFee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookonePropertyId() {
        return bookonePropertyId;
    }

    public void setBookonePropertyId(Long bookonePropertyId) {
        this.bookonePropertyId = bookonePropertyId;
    }
    public String getOnlineTravelAgencyPropertyId() {
        return onlineTravelAgencyPropertyId;
    }

    public void setOnlineTravelAgencyPropertyId(String onlineTravelAgencyPropertyId) {
        this.onlineTravelAgencyPropertyId = onlineTravelAgencyPropertyId;
    }

    public Long getOnlineTravelAgencyId() {
        return onlineTravelAgencyId;
    }

    public void setOnlineTravelAgencyId(Long onlineTravelAgencyId) {
        this.onlineTravelAgencyId = onlineTravelAgencyId;
    }


    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public Double getBookingCommissionFee() {
        return bookingCommissionFee;
    }

    public void setBookingCommissionFee(Double bookingCommissionFee) {
        this.bookingCommissionFee = bookingCommissionFee;
    }

    public String getBookingCommissionFeeType() {
        return bookingCommissionFeeType;
    }

    public void setBookingCommissionFeeType(String bookingCommissionFeeType) {
        this.bookingCommissionFeeType = bookingCommissionFeeType;
    }

    public Double getConvenienceFee() {
        return convenienceFee;
    }

    public void setConvenienceFee(Double convenienceFee) {
        this.convenienceFee = convenienceFee;
    }

    public String getConvenienceFeeType() {
        return convenienceFeeType;
    }

    public void setConvenienceFeeType(String convenienceFeeType) {
        this.convenienceFeeType = convenienceFeeType;
    }

    public String getOnlineTravelAgencyName() {
        return onlineTravelAgencyName;
    }

    public void setOnlineTravelAgencyName(String onlineTravelAgencyName) {
        this.onlineTravelAgencyName = onlineTravelAgencyName;
    }
    public String getOnlineTravelAgencyLogoUrl() {
        return onlineTravelAgencyLogoUrl;
    }

    public void setOnlineTravelAgencyLogoUrl(String onlineTravelAgencyLogoUrl) {
        this.onlineTravelAgencyLogoUrl = onlineTravelAgencyLogoUrl;
    }

    public String getOnlineTravelAgencyLoginUrl() {
        return onlineTravelAgencyLoginUrl;
    }

    public void setOnlineTravelAgencyLoginUrl(String onlineTravelAgencyLoginUrl) {
        this.onlineTravelAgencyLoginUrl = onlineTravelAgencyLoginUrl;
    }

    public String getOtaLoginId() {
        return otaLoginId;
    }

    public void setOtaLoginId(String otaLoginId) {
        this.otaLoginId = otaLoginId;
    }

    public String getOtaPassword() {
        return otaPassword;
    }

    public void setOtaPassword(String otaPassword) {
        this.otaPassword = otaPassword;
    }

	public String getTdsType() {
		return tdsType;
	}

	public void setTdsType(String tdsType) {
		this.tdsType = tdsType;
	}

	public String getTcsType() {
		return tcsType;
	}

	public void setTcsType(String tcsType) {
		this.tcsType = tcsType;
	}

	public Double getTdsFee() {
		return tdsFee;
	}

	public void setTdsFee(Double tdsFee) {
		this.tdsFee = tdsFee;
	}

	public Double getTcsFee() {
		return tcsFee;
	}

	public void setTcsFee(Double tcsFee) {
		this.tcsFee = tcsFee;
	}



}
