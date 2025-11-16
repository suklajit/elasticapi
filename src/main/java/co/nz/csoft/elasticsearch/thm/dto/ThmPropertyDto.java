package co.nz.csoft.elasticsearch.thm.dto;





import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import co.nz.csoft.elasticsearch.dto.Address;
import co.nz.csoft.elasticsearch.dto.BankAccount;
import co.nz.csoft.elasticsearch.dto.MobileWallet;
import co.nz.csoft.elasticsearch.dto.RulesDto;
import co.nz.csoft.elasticsearch.enums.PropertyStatus;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThmPropertyDto {

    private long id;
    private String name;
    private String shortName;
    private String email;
    private String slogan;
    private String landphone;
    private String mobile;
    private String whatsApp;
    private String managerFirstName;
    private String managerLastName;
    private String managerContactNo;
    private String managerEmailAddress;
    private Address address;
    private PropertyStatus propertyStatus;
    private String gstNumber;
    private String vatNumber;
    private String udyamRegistrationNumber;
    private BigDecimal pricePerNight;
    private BigDecimal pricePerWeek;
    private BigDecimal priceFortNight;
    private BigDecimal priceMonthly;
    private int minimumOccupancy;
    private int maximumOccupancy;
    private String logoUrl;
    private String imageUrl;
    private String localCurrency;
    private String placeId;
    private Integer noOfFloor;
    private Integer noOfRoomType;
    private Integer numberOfRooms;
    private String website;
    private String paymentGateway;
    private String paymentGatewayApiKey;
    private String paymentGatewayApiToken;
    private String paymentGatewayPublicKey;
    private String paymentGatewayCallbackUrl;
    private Long organisationId;
    private String longitude;
    private String latitude;
    private String businessType;
    private String businessDescription;
    private String plan;
    private String businessShortDescription;
    private String facebook;
    private String twitter;
    private String instagram;
    private String videoLink;
    private String youtube;
    private Long count;
    private boolean isFeaturedBusiness;
    private BankAccount bankAccount;
    private MobileWallet mobileWallet;
    private List<BusinessServiceDto> businessServiceDtoList;
    private List<SubscriptionDto> subscriptionList;
    private boolean verified;
    private String seoFriendlyName;
    private BigDecimal transactionFee;
    private Double bookingCommissionPercentage;
    private List<Image> imageList = new ArrayList<>();
    private List<TaxDetails> taxDetails = new ArrayList<>();
    private String source;
    private DetailedView detailedView;
    private int noOfBookOneReview;
    private Double bookOneRating;
    List<RoomDto> roomList;
    private String sacCode;
    private String fssaiRegNumber;
    private BigDecimal minimumRoooPrice;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<SocialMediaLink> socialMediaLinks = new ArrayList<SocialMediaLink>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<PointOfSale> pointOfSaleList = new ArrayList<PointOfSale>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private String businessSubtype;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<PropertyServices> propertyServicesList = new ArrayList<PropertyServices>();
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<NearbyAttraction> nearbyAttractions = new ArrayList<NearbyAttraction>();

    boolean propertyInvoicePrintHeader;
    private String highlights;
    private String primaryColor;
    private String secondaryColor;
    private String tertiaryColor;
    private RulesDto policies;

    
    
    
    public RulesDto getPolicies() {
        return policies;
    }

    public void setPolicies(RulesDto policies) {
        this.policies = policies;
    }
    
    
    public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getTertiaryColor() {
        return tertiaryColor;
    }

    public void setTertiaryColor(String tertiaryColor) {
        this.tertiaryColor = tertiaryColor;
    }

    public String getBusinessSubtype() {
        return businessSubtype;
    }

    public void setBusinessSubtype(String businessSubtype) {
        this.businessSubtype = businessSubtype;
    }


    public List<PointOfSale> getPointOfSaleList() {
        return pointOfSaleList;
    }

    public void setPointOfSaleList(List<PointOfSale> pointOfSaleList) {
        this.pointOfSaleList = pointOfSaleList;
    }


    public List<RatesAndAvailabilityDto> getRatesAndAvailabilityDtos() {
        return ratesAndAvailabilityDtos;
    }

    public void setRatesAndAvailabilityDtos(List<RatesAndAvailabilityDto> ratesAndAvailabilityDtos) {
        this.ratesAndAvailabilityDtos = ratesAndAvailabilityDtos;
    }

    private List<RatesAndAvailabilityDto> ratesAndAvailabilityDtos;

    public Double getBookOneRating() {
        return bookOneRating;
    }

    public void setBookOneRating(Double bookOneRating) {
        this.bookOneRating = bookOneRating;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public byte[] getPropertyBarCode() {
        return propertyBarCode;
    }

    public void setPropertyBarCode(byte[] propertyBarCode) {
        this.propertyBarCode = propertyBarCode;
    }
    private byte[] propertyBarCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerContactNo() {
        return managerContactNo;
    }

    public void setManagerContactNo(String managerContactNo) {
        this.managerContactNo = managerContactNo;
    }

    public String getManagerEmailAddress() {
        return managerEmailAddress;
    }

    public void setManagerEmailAddress(String managerEmailAddress) {
        this.managerEmailAddress = managerEmailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(PropertyStatus propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String GSTNumber) {
        this.gstNumber = GSTNumber;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getLandphone() {
        return landphone;
    }

    public void setLandphone(String landphone) {
        this.landphone = landphone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public BigDecimal getPricePerWeek() {
        return pricePerWeek;
    }

    public void setPricePerWeek(BigDecimal pricePerWeek) {
        this.pricePerWeek = pricePerWeek;
    }

    public BigDecimal getPriceFortNight() {
        return priceFortNight;
    }

    public void setPriceFortNight(BigDecimal priceFortNight) {
        this.priceFortNight = priceFortNight;
    }

    public BigDecimal getPriceMonthly() {
        return priceMonthly;
    }

    public void setPriceMonthly(BigDecimal priceMonthly) {
        this.priceMonthly = priceMonthly;
    }

    public int getMinimumOccupancy() {
        return minimumOccupancy;
    }

    public void setMinimumOccupancy(int minimumOccupancy) {
        this.minimumOccupancy = minimumOccupancy;
    }

    public int getMaximumOccupancy() {
        return maximumOccupancy;
    }

    public void setMaximumOccupancy(int maximumOccupancy) {
        this.maximumOccupancy = maximumOccupancy;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocalCurrency() {
        return localCurrency;
    }

    public void setLocalCurrency(String localCurrency) {
        this.localCurrency = localCurrency;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Integer getNoOfFloor() {
        return noOfFloor;
    }

    public void setNoOfFloor(Integer noOfFloor) {
        this.noOfFloor = noOfFloor;
    }

    public Integer getNoOfRoomType() {
        return noOfRoomType;
    }

    public void setNoOfRoomType(Integer noOfRoomType) {
        this.noOfRoomType = noOfRoomType;
    }

    public String getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(String paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String getPaymentGatewayApiKey() {
        return paymentGatewayApiKey;
    }

    public void setPaymentGatewayApiKey(String paymentGatewayApiKey) {
        this.paymentGatewayApiKey = paymentGatewayApiKey;
    }

    public String getPaymentGatewayApiToken() {
		return paymentGatewayApiToken;
	}

	public void setPaymentGatewayApiToken(String paymentGatewayApiToken) {
		this.paymentGatewayApiToken = paymentGatewayApiToken;
	}

	public String getPaymentGatewayPublicKey() {
        return paymentGatewayPublicKey;
    }

    public void setPaymentGatewayPublicKey(String paymentGatewayPublicKey) {
        this.paymentGatewayPublicKey = paymentGatewayPublicKey;
    }

    public List<TaxDetails> getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(List<TaxDetails> taxDetails) {
        this.taxDetails = taxDetails;
    }

    public List<SubscriptionDto> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<SubscriptionDto> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /* public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
     */
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getBusinessShortDescription() {
        return businessShortDescription;
    }

    public void setBusinessShortDescription(String businessShortDescription) {
        this.businessShortDescription = businessShortDescription;
    }

    public List<BusinessServiceDto> getBusinessServiceDtoList() {
        return businessServiceDtoList;
    }

    public void setBusinessServiceDtoList(List<BusinessServiceDto> businessServiceDtoList) {
        this.businessServiceDtoList = businessServiceDtoList;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getSeoFriendlyName() {
        return seoFriendlyName;
    }

    public void setSeoFriendlyName(String seoFriendlyName) {
        this.seoFriendlyName = seoFriendlyName;
    }

    public Double getBookingCommissionPercentage() {
        return bookingCommissionPercentage;
    }

    public void setBookingCommissionPercentage(Double bookingCommissionPercentage) {
        this.bookingCommissionPercentage = bookingCommissionPercentage;
    }

    public Double getCardProcessingFeePercentage() {
        return cardProcessingFeePercentage;
    }

    public void setCardProcessingFeePercentage(Double cardProcessingFeePercentage) {
        this.cardProcessingFeePercentage = cardProcessingFeePercentage;
    }

    private Double cardProcessingFeePercentage;

    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    

    public List<SocialMediaLink> getSocialMediaLinks() {
		return socialMediaLinks;
	}

	public void setSocialMediaLinks(List<SocialMediaLink> socialMediaLinks) {
		this.socialMediaLinks = socialMediaLinks;
	}

	public boolean isFeaturedBusiness() {
        return isFeaturedBusiness;
    }

    public void setFeaturedBusiness(boolean featuredBusiness) {
        isFeaturedBusiness = featuredBusiness;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    public int getNoOfBookOneReview() {
        return noOfBookOneReview;
    }

    public void setNoOfBookOneReview(int noOfBookOneReview) {
        this.noOfBookOneReview = noOfBookOneReview;
    }
    public DetailedView getDetailedView() {
        return detailedView;
    }

    public void setDetailedView(DetailedView detailedView) {
        this.detailedView = detailedView;
    }
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public MobileWallet getMobileWallet() {
        return mobileWallet;
    }

    public void setMobileWallet(MobileWallet mobileWallet) {
        this.mobileWallet = mobileWallet;
    }
    public List<RoomDto> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<RoomDto> roomList) {
        this.roomList = roomList;
    }
    public BigDecimal getMinimumRoooPrice() {
        return minimumRoooPrice;
    }

    public void setMinimumRoooPrice(BigDecimal minimumRoooPrice) {
        this.minimumRoooPrice = minimumRoooPrice;
    }
    public String getSacCode() {
        return sacCode;
    }

    public void setSacCode(String sacCode) {
        this.sacCode = sacCode;
    }
    public List<PropertyServices> getPropertyServicesList() {
        return propertyServicesList;
    }

    public void setPropertyServicesList(List<PropertyServices> propertyServicesList) {
        this.propertyServicesList = propertyServicesList;
    }
    public String getUdyamRegistrationNumber() {
        return udyamRegistrationNumber;
    }

    public void setUdyamRegistrationNumber(String udyamRegistrationNumber) {
        this.udyamRegistrationNumber = udyamRegistrationNumber;
    }
    public String getFssaiRegNumber() {
        return fssaiRegNumber;
    }

    public void setFssaiRegNumber(String fssaiRegNumber) {
        this.fssaiRegNumber = fssaiRegNumber;
    }
    public boolean isPropertyInvoicePrintHeader() {
        return propertyInvoicePrintHeader;
    }

    public void setPropertyInvoicePrintHeader(boolean propertyInvoicePrintHeader) {
        this.propertyInvoicePrintHeader = propertyInvoicePrintHeader;
    }
    public List<NearbyAttraction> getNearbyAttractions() {
        return nearbyAttractions;
    }

    public void setNearbyAttractions(List<NearbyAttraction> highLights) {
        this.nearbyAttractions = nearbyAttractions;
    }
    public String getHighlights() {
        return highlights;
    }

    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }
    public String getPaymentGatewayCallbackUrl() {
        return paymentGatewayCallbackUrl;
    }

    public void setPaymentGatewayCallbackUrl(String paymentGatewayCallbackUrl) {
        this.paymentGatewayCallbackUrl = paymentGatewayCallbackUrl;
    }
    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

	@Override
    public String toString() {
        return "PropertyDto{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", shortName='" + shortName + '\''
                + ", email='" + email + '\''
                + ", slogan='" + slogan + '\''
                + ", landphone='" + landphone + '\''
                + ", plan='" + plan + '\''
                + ", mobile='" + mobile + '\''
                + ", managerFirstName='" + managerFirstName + '\''
                + ", managerLastName='" + managerLastName + '\''
                + ", managerContactNo='" + managerContactNo + '\''
                + ", managerEmailAddress='" + managerEmailAddress + '\''
                + ", address=" + address
                + ", propertyStatus=" + propertyStatus
                + ", gstNumber='" + gstNumber + '\''
                + ", pricePerNight=" + pricePerNight
                + ", pricePerWeek=" + pricePerWeek
                + ", priceFortNight=" + priceFortNight
                + ", priceMonthly=" + priceMonthly
                + ", minimumOccupancy=" + minimumOccupancy
                + ", maximumOccupancy=" + maximumOccupancy
                + ", logoUrl='" + logoUrl + '\''
                + ", imageUrl='" + imageUrl + '\''
                + ", localCurrency='" + localCurrency + '\''
                + ", placeId='" + placeId + '\''
                + ", noOfFloor=" + noOfFloor
                + ", noOfRoomType=" + noOfRoomType
                + ", website='" + website + '\''
                + ", paymentGateway='" + paymentGateway + '\''
                + ", paymentGatewayApiKey='" + paymentGatewayApiKey + '\''
                + ", paymentGatewayApiToken='" + paymentGatewayApiToken + '\''
                + ", paymentGatewayPublicKey='" + paymentGatewayPublicKey + '\''
                + ", organisationId=" + organisationId
                + ", longitude='" + longitude + '\''
                + ", latitude='" + latitude + '\''
                + ", seoFriendlyName='" + seoFriendlyName + '\''
                + ", subscriptionList=" + subscriptionList
                + ", taxDetails=" + taxDetails
                + ", propertyBarCode=" + Arrays.toString(propertyBarCode)
                + '}';
    }

}

