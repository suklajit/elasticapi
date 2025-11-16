package co.nz.csoft.elasticsearch.thm.dto;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RoomDto {
    
	private long id;
    private String name;
    private String description ;
    private boolean isShared;

    private long propertyId;
    //private List<OccupancyToPriceDto> occupancyToPriceList = new ArrayList<OccupancyToPriceDto>();
   // private List<Bed> beds = new ArrayList<Bed>();
    //private List<Amenity> amenities= new ArrayList<Amenity>();
    //private List<Service> services= new ArrayList<Service>();
    private BigDecimal roomOnlyPrice;
    private BigDecimal totalPriceServices;
    private BigDecimal totalPriceAmenities;
    private BigDecimal totalPriceRoom;
    private BigDecimal pricePerNight;
    private BigDecimal pricePerWeek;
    private BigDecimal priceFortNight;
    private BigDecimal priceMonthly;
    private int minimumOccupancy;
    private int maximumOccupancy;
    private BigDecimal extraChargePerPerson;
    private int noOfRooms;
    private List<RoomDetails> roomDetails=new ArrayList<RoomDetails>();
    private List<Image> imageList = new ArrayList<Image>();
    private int minimumLengthOfStay;
    private int maximumLengthOfStay;
    private Double size;
    private Boolean smoking;
    private String hsnCode;
    private int ranking;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<RoomFacilitiesDto> roomFacilities=new ArrayList<RoomFacilitiesDto>();



    private boolean dayTrip;
    private int noOfChild;
    
    public int getNoOfChild() {
		return noOfChild;
	}

	public void setNoOfChild(int noOfChild) {
		this.noOfChild = noOfChild;
	}

	public List<RatesAndAvailabilityDto> getRatesAndAvailabilityDtos() {
        return ratesAndAvailabilityDtos;
    }

    public void setRatesAndAvailabilityDtos(List<RatesAndAvailabilityDto> ratesAndAvailabilityDtos) {
        this.ratesAndAvailabilityDtos = ratesAndAvailabilityDtos;
    }

    private List<RatesAndAvailabilityDto> ratesAndAvailabilityDtos;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }
/*
    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    */

    public BigDecimal getRoomOnlyPrice() {
        return roomOnlyPrice;
    }

    public void setRoomOnlyPrice(BigDecimal roomOnlyPrice) {
        this.roomOnlyPrice = roomOnlyPrice;
    }

    public BigDecimal getTotalPriceServices() {
        return totalPriceServices;
    }

    public void setTotalPriceServices(BigDecimal totalPriceServices) {
        this.totalPriceServices = totalPriceServices;
    }

    public BigDecimal getTotalPriceAmenities() {
        return totalPriceAmenities;
    }

    public void setTotalPriceAmenities(BigDecimal totalPriceAmenities) {
        this.totalPriceAmenities = totalPriceAmenities;
    }

    public BigDecimal getTotalPriceRoom() {
        return totalPriceRoom;
    }

    public void setTotalPriceRoom(BigDecimal totalPriceRoom) {
        this.totalPriceRoom = totalPriceRoom;
    }
    public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
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

	public BigDecimal getExtraChargePerPerson() {
		return extraChargePerPerson;
	}

	public void setExtraChargePerPerson(BigDecimal extraChargePerPerson) {
		this.extraChargePerPerson = extraChargePerPerson;
	}
    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }
    public List<RoomDetails> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<RoomDetails> roomDetails) {
        this.roomDetails = roomDetails;
    }
    public List<Image> getImageList() {
        if(imageList == null)
            imageList = new ArrayList<Image>();
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public int getMinimumLengthOfStay() {
        return minimumLengthOfStay;
    }

    public void setMinimumLengthOfStay(int minimumLengthOfStay) {
        this.minimumLengthOfStay = minimumLengthOfStay;
    }

    public int getMaximumLengthOfStay() {
        return maximumLengthOfStay;
    }

    public void setMaximumLengthOfStay(int maximumLengthOfStay) {
        this.maximumLengthOfStay = maximumLengthOfStay;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }
    public List<RoomFacilitiesDto> getRoomFacilities() {
        return roomFacilities;
    }
    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public void setRoomFacilities(List<RoomFacilitiesDto> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }
    public boolean isDayTrip() {
        return dayTrip;
    }

    public void setDayTrip(boolean dayTrip) {
        this.dayTrip = dayTrip;
    }
   

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "RoomDto [id=" + id + ", name=" + name + ", description=" + description + ", isShared=" + isShared
			//	+ ", beds=" + beds + ", amenities=" + amenities + ", services=" + services + ", roomOnlyPrice="
				+ roomOnlyPrice + ", pricePerNight=" + pricePerNight + ", pricePerWeek=" + pricePerWeek
				+ ", priceFortNight=" + priceFortNight + ", priceMonthly=" + priceMonthly + ", minimumOccupancy="
				+ minimumOccupancy + ", maximumOccupancy=" + maximumOccupancy + ", extraChargePerPerson="
				+ extraChargePerPerson + ", noOfRooms=" + noOfRooms + "]";
	}


}
