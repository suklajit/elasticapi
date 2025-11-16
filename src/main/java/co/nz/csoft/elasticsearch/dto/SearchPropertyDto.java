package co.nz.csoft.elasticsearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SearchPropertyDto {

	@JsonProperty("results")
	private List<Result> results;
	
	

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public static class Result {

		@JsonProperty("propertyId")
		private Long propertyId;

		@JsonProperty("propertyInfo")
		private PropertyInfo propertyInfo;

		@JsonProperty("remarks")
		private List<String> remarks;

		@JsonProperty("rooms")
		private List<Room> rooms;

		public Long getPropertyId() {
			return propertyId;
		}

		public void setPropertyId(Long propertyId) {
			this.propertyId = propertyId;
		}

		public PropertyInfo getPropertyInfo() {
			return propertyInfo;
		}

		public void setPropertyInfo(PropertyInfo propertyInfo) {
			this.propertyInfo = propertyInfo;
		}

		public List<String> getRemarks() {
			return remarks;
		}

		public void setRemarks(List<String> remarks) {
			this.remarks = remarks;
		}

		public List<Room> getRooms() {
			return rooms;
		}

		public void setRooms(List<Room> rooms) {
			this.rooms = rooms;
		}
		
		
	}

	public static class PropertyInfo {

		@JsonProperty("name")
		private String name;

		@JsonProperty("starRating")
		private int starRating;

		@JsonProperty("cityName")
		private String cityName;

		@JsonProperty("cityId")
		private Long cityId;

		@JsonProperty("countryName")
		private String countryName;

		@JsonProperty("countryCode")
		private String countryCode;

		@JsonProperty("regionName")
		private String regionName;

		@JsonProperty("regionCode")
		private String regionCode;

		@JsonProperty("longitude")
		private double longitude;

		@JsonProperty("latitude")
		private double latitude;

		@JsonProperty("propertyType")
		private int propertyType;

		@JsonProperty("propertyTypeName")
		private String propertyTypeName;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getStarRating() {
			return starRating;
		}

		public void setStarRating(int starRating) {
			this.starRating = starRating;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public Long getCityId() {
			return cityId;
		}

		public void setCityId(Long cityId) {
			this.cityId = cityId;
		}

		public String getCountryName() {
			return countryName;
		}

		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}

		public String getCountryCode() {
			return countryCode;
		}

		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}

		public String getRegionName() {
			return regionName;
		}

		public void setRegionName(String regionName) {
			this.regionName = regionName;
		}

		public String getRegionCode() {
			return regionCode;
		}

		public void setRegionCode(String regionCode) {
			this.regionCode = regionCode;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public int getPropertyType() {
			return propertyType;
		}

		public void setPropertyType(int propertyType) {
			this.propertyType = propertyType;
		}

		public String getPropertyTypeName() {
			return propertyTypeName;
		}

		public void setPropertyTypeName(String propertyTypeName) {
			this.propertyTypeName = propertyTypeName;
		}
		
	}

	public static class Room {

		@JsonProperty("searchedPax")
		private Pax searchedPax;

		@JsonProperty("roomId")
		private Long roomId;

		@JsonProperty("roomTypeCode")
		private String roomTypeCode;

		@JsonProperty("roomName")
		private String roomName;

		@JsonProperty("numberOfAvailableRooms")
		private int numberOfAvailableRooms;

		@JsonProperty("settings")
		private RoomSettings settings;

		@JsonProperty("ratePlans")
		private List<RatePlan> ratePlans;

		public Pax getSearchedPax() {
			return searchedPax;
		}

		public void setSearchedPax(Pax searchedPax) {
			this.searchedPax = searchedPax;
		}

		public Long getRoomId() {
			return roomId;
		}

		public void setRoomId(Long roomId) {
			this.roomId = roomId;
		}

		public String getRoomTypeCode() {
			return roomTypeCode;
		}

		public void setRoomTypeCode(String roomTypeCode) {
			this.roomTypeCode = roomTypeCode;
		}

		public String getRoomName() {
			return roomName;
		}

		public void setRoomName(String roomName) {
			this.roomName = roomName;
		}

		public int getNumberOfAvailableRooms() {
			return numberOfAvailableRooms;
		}

		public void setNumberOfAvailableRooms(int numberOfAvailableRooms) {
			this.numberOfAvailableRooms = numberOfAvailableRooms;
		}

		public RoomSettings getSettings() {
			return settings;
		}

		public void setSettings(RoomSettings settings) {
			this.settings = settings;
		}

		public List<RatePlan> getRatePlans() {
			return ratePlans;
		}

		public void setRatePlans(List<RatePlan> ratePlans) {
			this.ratePlans = ratePlans;
		}
		
		
	}

	public static class Pax {

		@JsonProperty("adults")
		private int adults;

		@JsonProperty("children")
		private List<Object> children;

		public int getAdults() {
			return adults;
		}

		public void setAdults(int adults) {
			this.adults = adults;
		}

		public List<Object> getChildren() {
			return children;
		}

		public void setChildren(List<Object> children) {
			this.children = children;
		}
		
		
	}

	public static class RoomSettings {

		@JsonProperty("numberOfBedrooms")
		private int numberOfBedrooms;

		@JsonProperty("roomSize")
		private int roomSize;

		@JsonProperty("maxAdultsNumber")
		private int maxAdultsNumber;

		@JsonProperty("maxChildrenNumber")
		private int maxChildrenNumber;

		@JsonProperty("maxInfantsNumber")
		private int maxInfantsNumber;

		@JsonProperty("maxOccupancy")
		private int maxOccupancy;

		@JsonProperty("numberOfBeds")
		private int numberOfBeds;

		@JsonProperty("beddingConfigurations")
		private List<BeddingConfiguration> beddingConfigurations;

		public int getNumberOfBedrooms() {
			return numberOfBedrooms;
		}

		public void setNumberOfBedrooms(int numberOfBedrooms) {
			this.numberOfBedrooms = numberOfBedrooms;
		}

		public int getRoomSize() {
			return roomSize;
		}

		public void setRoomSize(int roomSize) {
			this.roomSize = roomSize;
		}

		public int getMaxAdultsNumber() {
			return maxAdultsNumber;
		}

		public void setMaxAdultsNumber(int maxAdultsNumber) {
			this.maxAdultsNumber = maxAdultsNumber;
		}

		public int getMaxChildrenNumber() {
			return maxChildrenNumber;
		}

		public void setMaxChildrenNumber(int maxChildrenNumber) {
			this.maxChildrenNumber = maxChildrenNumber;
		}

		public int getMaxInfantsNumber() {
			return maxInfantsNumber;
		}

		public void setMaxInfantsNumber(int maxInfantsNumber) {
			this.maxInfantsNumber = maxInfantsNumber;
		}

		public int getMaxOccupancy() {
			return maxOccupancy;
		}

		public void setMaxOccupancy(int maxOccupancy) {
			this.maxOccupancy = maxOccupancy;
		}

		public int getNumberOfBeds() {
			return numberOfBeds;
		}

		public void setNumberOfBeds(int numberOfBeds) {
			this.numberOfBeds = numberOfBeds;
		}

		public List<BeddingConfiguration> getBeddingConfigurations() {
			return beddingConfigurations;
		}

		public void setBeddingConfigurations(List<BeddingConfiguration> beddingConfigurations) {
			this.beddingConfigurations = beddingConfigurations;
		}
		
		
	}

	public static class BeddingConfiguration {

		@JsonProperty("type")
		private String type;

		@JsonProperty("size")
		private String size;

		@JsonProperty("quantity")
		private int quantity;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		
	}

	public static class RatePlan {

		@JsonProperty("ratePlanCode")
		private String ratePlanCode;

		@JsonProperty("ratePlanId")
		private Long ratePlanId;

		@JsonProperty("ratePlanName")
		private String ratePlanName;

		@JsonProperty("ratePlanInfo")
		private RatePlanInfo ratePlanInfo;

		@JsonProperty("board")
		private String board;

		@JsonProperty("remarks")
		private List<String> remarks;

		@JsonProperty("cancellationPolicies")
		private List<CancellationPolicy> cancellationPolicies;

		@JsonProperty("payment")
		private Payment payment;

		@JsonProperty("prices")
		private Prices prices;

		@JsonProperty("nightlyBreakdown")
		private List<NightlyBreakdown> nightlyBreakdown;

		@JsonProperty("isImmediate")
		private boolean isImmediate;

		public String getRatePlanCode() {
			return ratePlanCode;
		}

		public void setRatePlanCode(String ratePlanCode) {
			this.ratePlanCode = ratePlanCode;
		}

		public Long getRatePlanId() {
			return ratePlanId;
		}

		public void setRatePlanId(Long ratePlanId) {
			this.ratePlanId = ratePlanId;
		}

		public String getRatePlanName() {
			return ratePlanName;
		}

		public void setRatePlanName(String ratePlanName) {
			this.ratePlanName = ratePlanName;
		}

		public RatePlanInfo getRatePlanInfo() {
			return ratePlanInfo;
		}

		public void setRatePlanInfo(RatePlanInfo ratePlanInfo) {
			this.ratePlanInfo = ratePlanInfo;
		}

		public String getBoard() {
			return board;
		}

		public void setBoard(String board) {
			this.board = board;
		}

		public List<String> getRemarks() {
			return remarks;
		}

		public void setRemarks(List<String> remarks) {
			this.remarks = remarks;
		}

		public List<CancellationPolicy> getCancellationPolicies() {
			return cancellationPolicies;
		}

		public void setCancellationPolicies(List<CancellationPolicy> cancellationPolicies) {
			this.cancellationPolicies = cancellationPolicies;
		}

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public Prices getPrices() {
			return prices;
		}

		public void setPrices(Prices prices) {
			this.prices = prices;
		}

		public List<NightlyBreakdown> getNightlyBreakdown() {
			return nightlyBreakdown;
		}

		public void setNightlyBreakdown(List<NightlyBreakdown> nightlyBreakdown) {
			this.nightlyBreakdown = nightlyBreakdown;
		}

		public boolean isImmediate() {
			return isImmediate;
		}

		public void setImmediate(boolean isImmediate) {
			this.isImmediate = isImmediate;
		}
		
		
	}

	public static class RatePlanInfo {

		@JsonProperty("virtual")
		private boolean virtual;

		@JsonProperty("contracts")
		private List<Contract> contracts;

		@JsonProperty("originalRatePlanCode")
		private String originalRatePlanCode;

		@JsonProperty("isPromotion")
		private boolean isPromotion;

		@JsonProperty("isPackageRate")
		private boolean isPackageRate;

		@JsonProperty("isPrivate")
		private boolean isPrivate;

		public boolean isVirtual() {
			return virtual;
		}

		public void setVirtual(boolean virtual) {
			this.virtual = virtual;
		}

		public List<Contract> getContracts() {
			return contracts;
		}

		public void setContracts(List<Contract> contracts) {
			this.contracts = contracts;
		}

		public String getOriginalRatePlanCode() {
			return originalRatePlanCode;
		}

		public void setOriginalRatePlanCode(String originalRatePlanCode) {
			this.originalRatePlanCode = originalRatePlanCode;
		}

		public boolean isPromotion() {
			return isPromotion;
		}

		public void setPromotion(boolean isPromotion) {
			this.isPromotion = isPromotion;
		}

		public boolean isPackageRate() {
			return isPackageRate;
		}

		public void setPackageRate(boolean isPackageRate) {
			this.isPackageRate = isPackageRate;
		}

		public boolean isPrivate() {
			return isPrivate;
		}

		public void setPrivate(boolean isPrivate) {
			this.isPrivate = isPrivate;
		}
		
		
	}

	public static class Contract {

		@JsonProperty("contractId")
		private Long contractId;

		@JsonProperty("terms")
		private List<Term> terms;
	}

	public static class Term {

		@JsonProperty("id")
		private Long id;

		@JsonProperty("name")
		private String name;

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
		
		
	}

	public static class CancellationPolicy {

		@JsonProperty("daysBefore")
		private int daysBefore;

		@JsonProperty("penaltyType")
		private String penaltyType;

		@JsonProperty("amount")
		private int amount;

		@JsonProperty("timeSetting")
		private TimeSetting timeSetting;

		@JsonProperty("cancellationDeadlineHour")
		private String cancellationDeadlineHour;

		public int getDaysBefore() {
			return daysBefore;
		}

		public void setDaysBefore(int daysBefore) {
			this.daysBefore = daysBefore;
		}

		public String getPenaltyType() {
			return penaltyType;
		}

		public void setPenaltyType(String penaltyType) {
			this.penaltyType = penaltyType;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public TimeSetting getTimeSetting() {
			return timeSetting;
		}

		public void setTimeSetting(TimeSetting timeSetting) {
			this.timeSetting = timeSetting;
		}

		public String getCancellationDeadlineHour() {
			return cancellationDeadlineHour;
		}

		public void setCancellationDeadlineHour(String cancellationDeadlineHour) {
			this.cancellationDeadlineHour = cancellationDeadlineHour;
		}
		
		
	}

	public static class TimeSetting {

		@JsonProperty("timeFromCheckIn")
		private int timeFromCheckIn;

		@JsonProperty("timeFromCheckInType")
		private String timeFromCheckInType;

		public int getTimeFromCheckIn() {
			return timeFromCheckIn;
		}

		public void setTimeFromCheckIn(int timeFromCheckIn) {
			this.timeFromCheckIn = timeFromCheckIn;
		}

		public String getTimeFromCheckInType() {
			return timeFromCheckInType;
		}

		public void setTimeFromCheckInType(String timeFromCheckInType) {
			this.timeFromCheckInType = timeFromCheckInType;
		}
		
		
	}

	public static class Payment {

		@JsonProperty("charge")
		private String charge;

		@JsonProperty("chargeType")
		private String chargeType;

		@JsonProperty("chargeAmount")
		private ChargeAmount chargeAmount;

		public String getCharge() {
			return charge;
		}

		public void setCharge(String charge) {
			this.charge = charge;
		}

		public String getChargeType() {
			return chargeType;
		}

		public void setChargeType(String chargeType) {
			this.chargeType = chargeType;
		}

		public ChargeAmount getChargeAmount() {
			return chargeAmount;
		}

		public void setChargeAmount(ChargeAmount chargeAmount) {
			this.chargeAmount = chargeAmount;
		}
		
		
	}

	public static class ChargeAmount {

		@JsonProperty("price")
		private double price;

		@JsonProperty("currency")
		private String currency;

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}
		
		
	}

	public static class Prices {

		@JsonProperty("net")
		private PriceDetail net;

		@JsonProperty("sell")
		private PriceDetail sell;

		@JsonProperty("commission")
		private CurrencyValue commission;

		@JsonProperty("bar")
		private CurrencyValue bar;

		@JsonProperty("fees")
		private List<TaxOrFee> fees;

		public PriceDetail getNet() {
			return net;
		}

		public void setNet(PriceDetail net) {
			this.net = net;
		}

		public PriceDetail getSell() {
			return sell;
		}

		public void setSell(PriceDetail sell) {
			this.sell = sell;
		}

		public CurrencyValue getCommission() {
			return commission;
		}

		public void setCommission(CurrencyValue commission) {
			this.commission = commission;
		}

		public CurrencyValue getBar() {
			return bar;
		}

		public void setBar(CurrencyValue bar) {
			this.bar = bar;
		}

		public List<TaxOrFee> getFees() {
			return fees;
		}

		public void setFees(List<TaxOrFee> fees) {
			this.fees = fees;
		}
		
		
	}

	public static class PriceDetail {

		@JsonProperty("price")
		private double price;

		@JsonProperty("currency")
		private String currency;

		@JsonProperty("taxes")
		private List<TaxOrFee> taxes;

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public List<TaxOrFee> getTaxes() {
			return taxes;
		}

		public void setTaxes(List<TaxOrFee> taxes) {
			this.taxes = taxes;
		}
		
		
	}

	public static class CurrencyValue {

		@JsonProperty("price")
		private double price;

		@JsonProperty("currency")
		private String currency;

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}
		
		
	}

	public static class TaxOrFee {

		@JsonProperty("description")
		private String description;

		@JsonProperty("amount")
		private double amount;

		@JsonProperty("currency")
		private String currency;

		@JsonProperty("relation")
		private String relation;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getRelation() {
			return relation;
		}

		public void setRelation(String relation) {
			this.relation = relation;
		}
		
		
	}

	public static class NightlyBreakdown {

		@JsonProperty("date")
		private String date;

		@JsonProperty("prices")
		private Prices prices;

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Prices getPrices() {
			return prices;
		}

		public void setPrices(Prices prices) {
			this.prices = prices;
		}
		
		
	}
}
