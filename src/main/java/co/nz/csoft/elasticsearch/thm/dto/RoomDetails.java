package co.nz.csoft.elasticsearch.thm.dto;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

import co.nz.csoft.elasticsearch.enums.BookingStatus;
import co.nz.csoft.elasticsearch.enums.RoomStatus;



public class RoomDetails implements Serializable{
	 private Long roomId;
	    private Long roomSequenceNumber;
	    private String roomNumber;
	    private boolean available;
	    private String guestName;
	    private Long bookingId;
	    private Long checkoutBookingId;
	    private String description;
	    private RoomStatus roomStatus;
	    private String floorNumber;
	    private String floorName;
	    private Integer noOfBed;
	    private String bedType;
	    private java.util.Date checkinTime;
	    private java.util.Date checkoutTime;
	    private BigDecimal totalAmount;
	    private BigDecimal totalServiceAmount;
	    private BigDecimal totalExpenseAmount ;
	    private BigDecimal totalPaymentAmount;
	    private BigDecimal discountAmount ;
	    private BigDecimal outstandingAmount ;
	    private Long customerId;
	    private java.sql.Date date;
	    private String arrivingFrom;
	    private String departingTo;
	    private String purposeOfVisit;
	    private BookingStatus bookingStatus;
	    private String checkInGuest;
	    private String checkOutGuest;
	    private String notes;
	    private String staffName;
	    private String  bedDescription;
	    private Integer noOfPersons;
	   	private Integer noOfChildren;
	  

	    public String getBedDescription() {
	        return bedDescription;
	    }

	    public void setBedDescription(String bedDescription) {
	        this.bedDescription = bedDescription;
	    }


	    public String getRoomNumber() {
	        return roomNumber;
	    }
	    public void setRoomNumber(String roomNumber) {
	        this.roomNumber = roomNumber;
	    }
	    public boolean isAvailable() {
	        return available;
	    }
	    public void setAvailable(boolean available) {
	        this.available = available;
	    }
	    public Long getRoomId() {
	        return roomId;
	    }
	    public void setRoomId(Long roomId) {
	        this.roomId = roomId;
	    }
	    public String getGuestName() {
	        return guestName;
	    }

	    public void setGuestName(String guestName) {
	        this.guestName = guestName;
	    }

	    public Long getBookingId() {
	        return bookingId;
	    }

	    public void setBookingId(Long bookingId) {
	        this.bookingId = bookingId;
	    }
	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }
	    public RoomStatus getRoomStatus() {
	        return roomStatus;
	    }

	    public void setRoomStatus(RoomStatus roomStatus) {
	        this.roomStatus = roomStatus;
	    }

	    public String getFloorNumber() {
	        return floorNumber;
	    }

	    public void setFloorNumber(String floorNumber) {
	        this.floorNumber = floorNumber;
	    }

	    public Integer getNoOfBed() {
	        return noOfBed;
	    }

	    public void setNoOfBed(Integer noOfBed) {
	        this.noOfBed = noOfBed;
	    }

	    public String getBedType() {
	        return bedType;
	    }

	    public void setBedType(String bedType) {
	        this.bedType = bedType;
	    }


	    public String getFloorName() {
	        return floorName;
	    }

	    public void setFloorName(String floorName) {
	        this.floorName = floorName;
	    }
	    public Date getCheckinTime() {
	        return checkinTime;
	    }

	    public void setCheckinTime(Date checkinTime) {
	        this.checkinTime = checkinTime;
	    }

	    public Date getCheckoutTime() {
	        return checkoutTime;
	    }

	    public void setCheckoutTime(Date checkoutTime) {
	        this.checkoutTime = checkoutTime;
	    }

	    public BigDecimal getTotalServiceAmount() {
	        return totalServiceAmount;
	    }

	    public void setTotalServiceAmount(BigDecimal totalServiceAmount) {
	        this.totalServiceAmount = totalServiceAmount;
	    }

	    public BigDecimal getTotalExpenseAmount() {
	        return totalExpenseAmount;
	    }

	    public void setTotalExpenseAmount(BigDecimal totalExpenseAmount) {
	        this.totalExpenseAmount = totalExpenseAmount;
	    }

	    public BigDecimal getTotalPaymentAmount() {
	        return totalPaymentAmount;
	    }

	    public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
	        this.totalPaymentAmount = totalPaymentAmount;
	    }

	    public BigDecimal getDiscountAmount() {
	        return discountAmount;
	    }

	    public void setDiscountAmount(BigDecimal discountAmount) {
	        this.discountAmount = discountAmount;
	    }

	    public BigDecimal getOutstandingAmount() {
	        return outstandingAmount;
	    }

	    public void setOutstandingAmount(BigDecimal outstandingAmount) {
	        this.outstandingAmount = outstandingAmount;
	    }
	    public Long getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(Long customerId) {
	        this.customerId = customerId;
	    }
	    public java.sql.Date getDate() {
	        return date;
	    }

	    public void setDate(java.sql.Date date) {
	        this.date = date;
	    }


	    public BigDecimal getTotalAmount() {
	        return totalAmount;
	    }

	    public void setTotalAmount(BigDecimal totalAmount) {
	        this.totalAmount = totalAmount;
	    }

	    public BookingStatus getBookingStatus() {
	        return bookingStatus;
	    }

	    public void setBookingStatus(BookingStatus bookingStatus) {
	        this.bookingStatus = bookingStatus;
	    }
	    public String getArrivingFrom() {
	        return arrivingFrom;
	    }

	    public void setArrivingFrom(String arrivingFrom) {
	        this.arrivingFrom = arrivingFrom;
	    }

	    public String getDepartingTo() {
	        return departingTo;
	    }

	    public void setDepartingTo(String departingTo) {
	        this.departingTo = departingTo;
	    }

	    public String getPurposeOfVisit() {
	        return purposeOfVisit;
	    }

	    public void setPurposeOfVisit(String purposeOfVisit) {
	        this.purposeOfVisit = purposeOfVisit;
	    }

	    public String getCheckInGuest() {
	        return checkInGuest;
	    }

	    public void setCheckInGuest(String checkInGuest) {
	        this.checkInGuest = checkInGuest;
	    }

	    public String getCheckOutGuest() {
	        return checkOutGuest;
	    }

	    public void setCheckOutGuest(String checkOutGuest) {
	        this.checkOutGuest = checkOutGuest;
	    }
	    public Long getRoomSequenceNumber() {
	        return roomSequenceNumber;
	    }

	    public void setRoomSequenceNumber(Long roomSequenceNumber) {
	        this.roomSequenceNumber = roomSequenceNumber;
	    }
	    public String getNotes() {
	        return notes;
	    }

	    public void setNotes(String notes) {
	        this.notes = notes;
	    }
	    public Long getCheckoutBookingId() {
	        return checkoutBookingId;
	    }

	    public void setCheckoutBookingId(Long checkoutBookingId) {
	        this.checkoutBookingId = checkoutBookingId;
	    }
	    public String getStaffName() {
			return staffName;
		}

		public void setStaffName(String staffName) {
			this.staffName = staffName;
		}
		public Integer getNoOfPersons() {
			return noOfPersons;
		}

		public void setNoOfPersons(Integer noOfPersons) {
			this.noOfPersons = noOfPersons;
		}

		public Integer getNoOfChildren() {
			return noOfChildren;
		}

		public void setNoOfChildren(Integer noOfChildren) {
			this.noOfChildren = noOfChildren;
		}

		@Override
	    public String toString() {
	        return "{" +
	                "\"roomId\":\"" + roomId +
	                "\", \"roomNumber\":\"" + roomNumber +
	                "\", \"available\":" + available +
	                "}";
	    }


	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        RoomDetails that = (RoomDetails) o;
	        return roomNumber == that.roomNumber &&
	                Objects.equals(roomId, that.roomId);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(roomId, roomNumber);
	    }


}

