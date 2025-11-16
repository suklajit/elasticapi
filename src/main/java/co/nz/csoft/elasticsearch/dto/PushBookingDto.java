package co.nz.csoft.elasticsearch.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class PushBookingDto {
	 @JsonProperty("dates")
	    private Dates dates;

	    @JsonProperty("propertyId")
	    private String propertyId;

	    @JsonProperty("leadGuest")
	    private LeadGuest leadGuest;

	    @JsonProperty("reference")
	    private Reference reference;

	    @JsonProperty("paymentDetails")
	    private PaymentDetails paymentDetails;

	    @JsonProperty("rooms")
	    private List<Room> rooms;

	    @JsonProperty("meta")
	    private List<Meta> meta;

	    @JsonProperty("isTest")
	    private boolean isTest;

	    @JsonProperty("groupBooking")
	    private boolean groupBooking;



	    public Dates getDates() {
			return dates;
		}

		public void setDates(Dates dates) {
			this.dates = dates;
		}



		public String getPropertyId() {
			return propertyId;
		}

		public void setPropertyId(String propertyId) {
			this.propertyId = propertyId;
		}

		public LeadGuest getLeadGuest() {
			return leadGuest;
		}

		public void setLeadGuest(LeadGuest leadGuest) {
			this.leadGuest = leadGuest;
		}

		public Reference getReference() {
			return reference;
		}

		public void setReference(Reference reference) {
			this.reference = reference;
		}

		public PaymentDetails getPaymentDetails() {
			return paymentDetails;
		}

		public void setPaymentDetails(PaymentDetails paymentDetails) {
			this.paymentDetails = paymentDetails;
		}

		public List<Room> getRooms() {
			return rooms;
		}

		public void setRooms(List<Room> rooms) {
			this.rooms = rooms;
		}

		public List<Meta> getMeta() {
			return meta;
		}

		public void setMeta(List<Meta> meta) {
			this.meta = meta;
		}

		public boolean isTest() {
			return isTest;
		}

		public void setTest(boolean isTest) {
			this.isTest = isTest;
		}

		public boolean isGroupBooking() {
			return groupBooking;
		}

		public void setGroupBooking(boolean groupBooking) {
			this.groupBooking = groupBooking;
		}

		public static class Dates {
	        @JsonProperty("from")
	        private String from;

	        @JsonProperty("to")
	        private String to;

			public String getFrom() {
				return from;
			}

			public void setFrom(String from) {
				this.from = from;
			}

			public String getTo() {
				return to;
			}

			public void setTo(String to) {
				this.to = to;
			}
	        
	        
	    }

	    public static class LeadGuest {
	        @JsonProperty("title")
	        private String title;

	        @JsonProperty("birthDate")
	        private String birthDate;

	        @JsonProperty("name")
	        private Name name;

	        @JsonProperty("contact")
	        private Contact contact;

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getBirthDate() {
				return birthDate;
			}

			public void setBirthDate(String birthDate) {
				this.birthDate = birthDate;
			}

			public Name getName() {
				return name;
			}

			public void setName(Name name) {
				this.name = name;
			}

			public Contact getContact() {
				return contact;
			}

			public void setContact(Contact contact) {
				this.contact = contact;
			}
	        
	    }

	    public static class Name {
	        @JsonProperty("first")
	        private String first;

	        @JsonProperty("last")
	        private String last;


			public String getFirst() {
				return first;
			}

			public void setFirst(String first) {
				this.first = first;
			}

			public String getLast() {
				return last;
			}

			public void setLast(String last) {
				this.last = last;
			}
	    }

	    public static class Contact {
	        @JsonProperty("address")
	        private String address;

	        @JsonProperty("city")
	        private String city;

	        @JsonProperty("state")
	        private String state;

	        @JsonProperty("country")
	        private String country;

	        @JsonProperty("zip")
	        private String zip;

	        @JsonProperty("phone")
	        private String phone;

	        @JsonProperty("email")
	        private String email;

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getState() {
				return state;
			}

			public void setState(String state) {
				this.state = state;
			}

			public String getCountry() {
				return country;
			}

			public void setCountry(String country) {
				this.country = country;
			}

			public String getZip() {
				return zip;
			}

			public void setZip(String zip) {
				this.zip = zip;
			}

			public String getPhone() {
				return phone;
			}

			public void setPhone(String phone) {
				this.phone = phone;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}
	        
	    }

	    public static class Reference {
	        @JsonProperty("agency")
	        private String agency;

			public String getAgency() {
				return agency;
			}

			public void setAgency(String agency) {
				this.agency = agency;
			}
	        
	    }

	    public static class PaymentDetails {
	        @JsonProperty("type")
	        private String type;

	        @JsonProperty("details")
	        private CardDetails details;

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public CardDetails getDetails() {
				return details;
			}

			public void setDetails(CardDetails details) {
				this.details = details;
			}
	        
	    }

	    public static class CardDetails {
	        @JsonProperty("number")
	        private String number;

	        @JsonProperty("cvv")
	        private String cvv;

	        @JsonProperty("expiry")
	        private Expiry expiry;

	        @JsonProperty("name")
	        private Name name;

			public String getNumber() {
				return number;
			}

			public void setNumber(String number) {
				this.number = number;
			}

			public String getCvv() {
				return cvv;
			}

			public void setCvv(String cvv) {
				this.cvv = cvv;
			}

			public Expiry getExpiry() {
				return expiry;
			}

			public void setExpiry(Expiry expiry) {
				this.expiry = expiry;
			}

			public Name getName() {
				return name;
			}

			public void setName(Name name) {
				this.name = name;
			}
	        
	    }

	    public static class Expiry {
	        @JsonProperty("month")
	        private String month;

	        @JsonProperty("year")
	        private String year;

			public String getMonth() {
				return month;
			}

			public void setMonth(String month) {
				this.month = month;
			}

			public String getYear() {
				return year;
			}

			public void setYear(String year) {
				this.year = year;
			}
	        
	    }

	    public static class Room {
	        @JsonProperty("roomCode")
	        private String roomCode;

	        @JsonProperty("rateCode")
	        private String rateCode;

	        @JsonProperty("expectedPrice")
	        private ExpectedPrice expectedPrice;

	        @JsonProperty("guests")
	        private List<Guest> guests;

	        @JsonProperty("specialRequests")
	        private List<String> specialRequests;

			public String getRoomCode() {
				return roomCode;
			}

			public void setRoomCode(String roomCode) {
				this.roomCode = roomCode;
			}

			public String getRateCode() {
				return rateCode;
			}

			public void setRateCode(String rateCode) {
				this.rateCode = rateCode;
			}

			public ExpectedPrice getExpectedPrice() {
				return expectedPrice;
			}

			public void setExpectedPrice(ExpectedPrice expectedPrice) {
				this.expectedPrice = expectedPrice;
			}

			public List<Guest> getGuests() {
				return guests;
			}

			public void setGuests(List<Guest> guests) {
				this.guests = guests;
			}

			public List<String> getSpecialRequests() {
				return specialRequests;
			}

			public void setSpecialRequests(List<String> specialRequests) {
				this.specialRequests = specialRequests;
			}
	        
	        
	        
	    }

	    public static class ExpectedPrice {
	        @JsonProperty("amount")
	        private Double amount;

	        @JsonProperty("currency")
	        private String currency;

			public Double getAmount() {
				return amount;
			}

			public void setAmount(Double amount) {
				this.amount = amount;
			}

			public String getCurrency() {
				return currency;
			}

			public void setCurrency(String currency) {
				this.currency = currency;
			}
	        
	    }

	    public static class Guest {
	        @JsonProperty("title")
	        private String title;

	        @JsonProperty("birthDate")
	        private String birthDate;

	        @JsonProperty("name")
	        private Name name;

	        @JsonProperty("contact")
	        private Contact contact; // optional in some guests

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getBirthDate() {
				return birthDate;
			}

			public void setBirthDate(String birthDate) {
				this.birthDate = birthDate;
			}

			public Name getName() {
				return name;
			}

			public void setName(Name name) {
				this.name = name;
			}

			public Contact getContact() {
				return contact;
			}

			public void setContact(Contact contact) {
				this.contact = contact;
			}
	        
	    }

	    public static class Meta {
	        @JsonProperty("key")
	        private String key;

	        @JsonProperty("value")
	        private String value;

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}
	        
	    }


}

