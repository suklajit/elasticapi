package co.nz.csoft.elasticsearch.thm.dto;


import org.hibernate.annotations.Type;



import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class BusinessServiceDto {
    private Long id;
    private List<ServiceClose> closedDays;
    private List<ServiceOpen> openDays;
    private String name;
    private String brandName;
    private String brandSlogan;
    private Long businessTypeId;
    private String description;
    private Long propertyId;
    private Long minLeadTime;
    private Long maxLeadTime;
    private Long stdPrepTime;
    private List<BusinessServiceTypeDto> businessServiceTypes;
    private String businessLocationName;
    private String customerLocationName;
    private Boolean canChangeBusinessAddress;
    private String businessTermLocation;
    private String businessTermResource;
    private String businessProductName;
    private String businessServiceName;
    private Boolean provideBusinessAndCustomerAddress;
    private String bookingButtonLabelText;
    private List<ServiceOpen> serviceOpenList=new ArrayList<ServiceOpen>();
    private List<ServiceClose> serviceCloseList=new ArrayList<ServiceClose>();
    private List<DeliveryOption> deliveryOptionList = new ArrayList<DeliveryOption>();
    private List<PointOfSale> pointOfSaleList = new ArrayList<PointOfSale>();
    private String policy;
    private List<TaxDetails> taxDetails = new ArrayList<>();
    private Double serviceChargePercentage;
    private boolean isActive;
    private boolean sendInstantConfirmation;
    private boolean isPriceInclusiveOfTax;
    private boolean isServiceReservation;
    private  String checkInTime;
    private  String checkOutTime;
    private boolean twentyFourHoursCheckOut;
    private boolean instantBooking;
    private String gstNumber;
	private String logoUrl;
	private String phoneNumber;
	private boolean includeService;
	private Long advanceAmountPercentage;
	private String imageUrl;
	private boolean websiteinstantBooking;
	private String paymentScannerUrl;
	private boolean smartRecommendation;
	private boolean cmIntegration;
	private boolean payLater;
	
	
	
	
	
	
	

	public boolean isPayLater() {
		return payLater;
	}

	public void setPayLater(boolean payLater) {
		this.payLater = payLater;
	}

	public String getPaymentScannerUrl() {
		return paymentScannerUrl;
	}

	public void setPaymentScannerUrl(String paymentScannerUrl) {
		this.paymentScannerUrl = paymentScannerUrl;
	}

	public boolean isSmartRecommendation() {
		return smartRecommendation;
	}

	public void setSmartRecommendation(boolean smartRecommendation) {
		this.smartRecommendation = smartRecommendation;
	}

	public boolean isCmIntegration() {
		return cmIntegration;
	}

	public void setCmIntegration(boolean cmIntegration) {
		this.cmIntegration = cmIntegration;
	}

	public boolean isWebsiteinstantBooking() {
		return websiteinstantBooking;
	}

	public void setWebsiteinstantBooking(boolean websiteinstantBooking) {
		this.websiteinstantBooking = websiteinstantBooking;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getAdvanceAmountPercentage() {
		return advanceAmountPercentage;
	}

	public void setAdvanceAmountPercentage(Long advanceAmountPercentage) {
		this.advanceAmountPercentage = advanceAmountPercentage;
	}

	public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

	private List<ServiceCharge> serviceChargeList = new ArrayList<ServiceCharge>();
    public Double getServiceChargePercentage() {
        return serviceChargePercentage;
    }

    public void setServiceChargePercentage(Double serviceChargePercentage) {
        this.serviceChargePercentage = serviceChargePercentage;
    }


    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public List<ServiceClose> getClosedDays() {
        return closedDays;
    }

    public void setClosedDays(List<ServiceClose> closedDays) {
        this.closedDays = closedDays;
    }

    public List<ServiceOpen> getOpenDays() {
        return openDays;
    }

    public void setOpenDays(List<ServiceOpen> openDays) {
        this.openDays = openDays;
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

    public List<BusinessServiceTypeDto> getBusinessServiceTypes() {
        return businessServiceTypes;
    }

    public void setBusinessServiceTypes(List<BusinessServiceTypeDto> businessServiceTypes) {
        this.businessServiceTypes = businessServiceTypes;
    }
    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
    public List<ServiceOpen> getServiceOpenList() {
        return serviceOpenList;
    }

    public void setServiceOpenList(List<ServiceOpen> serviceOpenList) {
        this.serviceOpenList = serviceOpenList;
    }

    public List<ServiceClose> getServiceCloseList() {
        return serviceCloseList;
    }

    public void setServiceCloseList(List<ServiceClose> serviceCloseList) {
        this.serviceCloseList = serviceCloseList;
    }
    public Long getMinLeadTime() {
        return minLeadTime;
    }

    public void setMinLeadTime(Long minLeadTime) {
        this.minLeadTime = minLeadTime;
    }

    public Long getMaxLeadTime() {
        return maxLeadTime;
    }

    public void setMaxLeadTime(Long maxLeadTime) {
        this.maxLeadTime = maxLeadTime;
    }

    public Long getStdPrepTime() {
        return stdPrepTime;
    }

    public void setStdPrepTime(Long stdPrepTime) {
        this.stdPrepTime = stdPrepTime;
    }
    public Long getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Long businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getBusinessLocationName() {
        return businessLocationName;
    }

    public void setBusinessLocationName(String businessLocationName) {
        this.businessLocationName = businessLocationName;
    }

    public String getCustomerLocationName() {
        return customerLocationName;
    }

    public void setCustomerLocationName(String customerLocationName) {
        this.customerLocationName = customerLocationName;
    }

    public Boolean getCanChangeBusinessAddress() {
        return canChangeBusinessAddress;
    }

    public void setCanChangeBusinessAddress(Boolean canChangeBusinessAddress) {
        this.canChangeBusinessAddress = canChangeBusinessAddress;
    }

    public String getBusinessTermLocation() {
        return businessTermLocation;
    }

    public void setBusinessTermLocation(String businessTermLocation) {
        this.businessTermLocation = businessTermLocation;
    }

    public String getBusinessTermResource() {
        return businessTermResource;
    }

    public void setBusinessTermResource(String businessTermResource) {
        this.businessTermResource = businessTermResource;
    }

    public String getBusinessProductName() {
        return businessProductName;
    }

    public void setBusinessProductName(String businessProductName) {
        this.businessProductName = businessProductName;
    }

    public String getBusinessServiceName() {
        return businessServiceName;
    }

    public void setBusinessServiceName(String businessServiceName) {
        this.businessServiceName = businessServiceName;
    }

    public Boolean getProvideBusinessAndCustomerAddress() {
        return provideBusinessAndCustomerAddress;
    }

    public void setProvideBusinessAndCustomerAddress(Boolean provideBusinessAndCustomerAddress) {
        this.provideBusinessAndCustomerAddress = provideBusinessAndCustomerAddress;
    }
    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }
    public String getBookingButtonLabelText() {
        return bookingButtonLabelText;
    }

    public void setBookingButtonLabelText(String bookingButtonLabelText) {
        this.bookingButtonLabelText = bookingButtonLabelText;
    }
    public List<DeliveryOption> getDeliveryOptionList() {
        return deliveryOptionList;
    }

    public void setDeliveryOptionList(List<DeliveryOption> deliveryOptionList) {
        this.deliveryOptionList = deliveryOptionList;
    }
    public List<TaxDetails> getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(List<TaxDetails> taxDetails) {
        this.taxDetails = taxDetails;
    }
    public List<PointOfSale> getPointOfSaleList() {
        return pointOfSaleList;
    }

    public void setPointOfSaleList(List<PointOfSale> pointOfSaleList) {
        this.pointOfSaleList = pointOfSaleList;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    public boolean isSendInstantConfirmation() {
        return sendInstantConfirmation;
    }

    public void setSendInstantConfirmation(boolean sendInstantConfirmation) {
        this.sendInstantConfirmation = sendInstantConfirmation;
    }

    public boolean isPriceInclusiveOfTax() {
        return isPriceInclusiveOfTax;
    }

    public void setPriceInclusiveOfTax(boolean priceInclusiveOfTax) {
        isPriceInclusiveOfTax = priceInclusiveOfTax;
    }
    public boolean isServiceReservation() {
        return isServiceReservation;
    }

    public void setServiceReservation(boolean serviceReservation) {
        isServiceReservation = serviceReservation;
    }

    public List<ServiceCharge> getServiceChargeList() {
        return serviceChargeList;
    }

    public void setServiceChargeList(List<ServiceCharge> serviceChargeList) {
        this.serviceChargeList = serviceChargeList;
    }
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandSlogan() {
        return brandSlogan;
    }

    public void setBrandSlogan(String brandSlogan) {
        this.brandSlogan = brandSlogan;
    }
    public boolean isInstantBooking() {
		return instantBooking;
	}

	public void setInstantBooking(boolean instantBooking) {
		this.instantBooking = instantBooking;
	}

	public boolean isTwentyFourHoursCheckOut() {
		return twentyFourHoursCheckOut;
	}

	public void setTwentyFourHoursCheckOut(boolean twentyFourHoursCheckOut) {
		this.twentyFourHoursCheckOut = twentyFourHoursCheckOut;
	}
	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isIncludeService() {
		return includeService;
	}

	public void setIncludeService(boolean includeService) {
		this.includeService = includeService;
	}
	
}
