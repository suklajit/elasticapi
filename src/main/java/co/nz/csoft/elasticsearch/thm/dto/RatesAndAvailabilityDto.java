package co.nz.csoft.elasticsearch.thm.dto;



import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import co.nz.csoft.elasticsearch.enums.ChannelManagerUpdateType;



public class RatesAndAvailabilityDto {
    private Long id;
    private BigDecimal price;
    private Integer totalNoRooms;
    private Integer noOfBooked;
    private Integer noOfAvailable;
    private Integer noOfOnHold;
    private Date date;
    private String roomName;
    private String propertyName;
    private Date fromDate;
    private Date toDate;
    private Long roomId;
    private Long propertyId;
    private int updateCount;
    /* Update type indicates whether update type is RateUpdate or PlanUpdate */
    private String updateType;
    private String ratePlanCode;
    /* restriction and status  */
    private String status;
    private String restriction;
    private ChannelManagerUpdateType channelManagerUpdateType;
    private List<RoomRatePlan> roomRatePlans=new ArrayList<RoomRatePlan>();
    private Boolean stopSellOBE;
	private Boolean stopSellOTA;
	
	private List<OtaAvailability> otaAvailabilityList=new ArrayList<OtaAvailability>();

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private List<Image> imageList=new ArrayList<Image>();
    private String description ;
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        return "{" +
                "\"id\":\"" + id +
                "\", \"price\":\"" + price +
                "\", \"totalNoRooms\":\"" + totalNoRooms +
                "\", \"noOfBooked\":\"" + noOfBooked +
                "\", \"noOfAvailable\":\"" + noOfAvailable +
                "\", \"noOfOnHold\":\"" + noOfOnHold +
                "\", \"date\":\"" + date +
                "\", \"roomName\":\"" + roomName +
                "\", \"fromDate\":\""+ fromDate +
                "\", \"toDate\":\"" + toDate +
                "\", \"roomId\":\"" + roomId +
                "\", \"propertyId\":\"" + propertyId +
                "\", \"updateType\":\"" + updateType +
                "\", \"ratePlanCode\":\"" + ratePlanCode +
                "\", \"status\":\"" + status +
                "\", \"restriction\":\"" + restriction +
                "\", \"channelManagerUpdateType\":\"" + channelManagerUpdateType +

                //"\", \"roomDetails\":\"" + roomDetails +
                "\"}";
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }


    private List<RoomDetails> roomDetails=new ArrayList<RoomDetails>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTotalNoRooms() {
		return totalNoRooms;
	}

	public void setTotalNoRooms(Integer totalNoRooms) {
		this.totalNoRooms = totalNoRooms;
	}

	public Integer getNoOfBooked() {
		return noOfBooked;
	}

	public void setNoOfBooked(Integer noOfBooked) {
		this.noOfBooked = noOfBooked;
	}

	public Integer getNoOfAvailable() {
		return noOfAvailable;
	}

	public void setNoOfAvailable(Integer noOfAvailable) {
		this.noOfAvailable = noOfAvailable;
	}

	public Integer getNoOfOnHold() {
		return noOfOnHold;
	}

	public void setNoOfOnHold(Integer noOfOnHold) {
		this.noOfOnHold = noOfOnHold;
	}

	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<RoomDetails> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<RoomDetails> roomDetails) {
        this.roomDetails = roomDetails;
    }
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }
    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
    }

    private String ratePlanName;


    public Long getRoomId() {
        return roomId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }
    public List<RoomRatePlan> getRoomRatePlans() {
        return roomRatePlans;
    }

    public void setRoomRatePlans(List<RoomRatePlan> roomRatePlans) {
        this.roomRatePlans = roomRatePlans;
    }
    public ChannelManagerUpdateType getChannelManagerUpdateType() {
        return channelManagerUpdateType;
    }

    public void setChannelManagerUpdateType(ChannelManagerUpdateType channelManagerUpdateType) {
        this.channelManagerUpdateType = channelManagerUpdateType;
    }

	public Boolean getStopSellOBE() {
		return stopSellOBE;
	}

	public void setStopSellOBE(Boolean stopSellOBE) {
		this.stopSellOBE = stopSellOBE;
	}

	public Boolean getStopSellOTA() {
		return stopSellOTA;
	}

	public void setStopSellOTA(Boolean stopSellOTA) {
		this.stopSellOTA = stopSellOTA;
	}

	public List<OtaAvailability> getOtaAvailabilityList() {
		return otaAvailabilityList;
	}

	public void setOtaAvailabilityList(List<OtaAvailability> otaAvailabilityList) {
		this.otaAvailabilityList = otaAvailabilityList;
	}
	

}
