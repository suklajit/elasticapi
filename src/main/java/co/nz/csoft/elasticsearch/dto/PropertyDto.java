package co.nz.csoft.elasticsearch.dto;



import java.math.BigDecimal;
import java.util.List;

import co.nz.csoft.elasticsearch.thm.dto.RoomDto;



public class PropertyDto {
    private Long id;
    private Long bookonePropertyId;
    private String name;
    private String email;
    private String onlineTravelAgencyPropertyId;
    private Long organisationId;
    //private List<OnlineTravelAgency> onlineTravelAgencies;
    private List<PropertiesOnlineTravelAgenciesDto> propertiesOnlineTravelAgencies;
    private List<RoomDto> roomDtos;
    private BigDecimal bookingCommissionFee;
    private String bookingCommissionFeeType;
    private BigDecimal convenienceFee;
    private String convenienceFeeType;
    private String onlineTravelAgencyLogoUrl;
    private String onlineTravelAgencyLoginUrl;
    private String otaLoginId;
    private String otaPassword;
    //TDS and TCS information
    private String tdsType;
    private String tcsType;
    private BigDecimal tdsFee;
    private BigDecimal tcsFee;

    public Long getBookonePropertyId() {
        return bookonePropertyId;
    }

    public void setBookonePropertyId(Long bookonePropertyId) {
        this.bookonePropertyId = bookonePropertyId;
    }

//    public List<OnlineTravelAgency> getOnlineTravelAgencies() {
//        return onlineTravelAgencies;
//    }
//
//    public void setOnlineTravelAgencies(List<OnlineTravelAgency> onlineTravelAgencies) {
//        this.onlineTravelAgencies = onlineTravelAgencies;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getOnlineTravelAgencyPropertyId() {
        return onlineTravelAgencyPropertyId;
    }

    public void setOnlineTravelAgencyPropertyId(String onlineTravelAgencyPropertyId) {
        this.onlineTravelAgencyPropertyId = onlineTravelAgencyPropertyId;
    }
    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }
    public List<RoomDto> getRoomDtos() {
        return roomDtos;
    }

    public void setRoomDtos(List<RoomDto> roomDtos) {
        this.roomDtos = roomDtos;
    }
   

    public BigDecimal getBookingCommissionFee() {
		return bookingCommissionFee;
	}

	public String getBookingCommissionFeeType() {
        return bookingCommissionFeeType;
    }

    public void setBookingCommissionFeeType(String bookingCommissionFeeType) {
        this.bookingCommissionFeeType = bookingCommissionFeeType;
    }
    

    public BigDecimal getConvenienceFee() {
		return convenienceFee;
	}

	public String getConvenienceFeeType() {
        return convenienceFeeType;
    }

    public void setConvenienceFeeType(String convenienceFeeType) {
        this.convenienceFeeType = convenienceFeeType;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public List<PropertiesOnlineTravelAgenciesDto> getPropertiesOnlineTravelAgencies() {
        return propertiesOnlineTravelAgencies;
    }

    public void setPropertiesOnlineTravelAgencies(List<PropertiesOnlineTravelAgenciesDto> propertiesOnlineTravelAgencies) {
        this.propertiesOnlineTravelAgencies = propertiesOnlineTravelAgencies;
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

	public BigDecimal getTdsFee() {
		return tdsFee;
	}

	public void setTdsFee(BigDecimal tdsFee) {
		this.tdsFee = tdsFee;
	}

	public BigDecimal getTcsFee() {
		return tcsFee;
	}

	public void setTcsFee(BigDecimal tcsFee) {
		this.tcsFee = tcsFee;
	}

	public void setBookingCommissionFee(BigDecimal bookingCommissionFee) {
		this.bookingCommissionFee = bookingCommissionFee;
	}

	public void setConvenienceFee(BigDecimal convenienceFee) {
		this.convenienceFee = convenienceFee;
	}


	



}
