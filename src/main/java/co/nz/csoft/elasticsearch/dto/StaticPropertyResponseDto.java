package co.nz.csoft.elasticsearch.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StaticPropertyResponseDto {

    private List<Attribute> attributes;
    private Commission commission;
    private Contact contact;
    private Coordinates coordinates;
    private String created;
    private List<Description> descriptions;
    private List<Facility> facilities;
    private String group;
    private int id;
    private List<Image> images;
    private int isTest;
    private Location location;
    private String logo;
    private String name;
    private List<Policy> policies;
    private List<RatePlan> ratePlans;
    private int rating;
    private List<Room> rooms;
    private BaseSettings baseSettings; 
    private String status;
    private List<String> tags;
    private String taxId;
    private List<TaxesFee> taxesFees;
    private String updated;
    

    public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public Commission getCommission() {
		return commission;
	}

	public void setCommission(Commission commission) {
		this.commission = commission;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public List<Description> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	public List<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public int getIsTest() {
		return isTest;
	}

	public void setIsTest(int isTest) {
		this.isTest = isTest;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public List<RatePlan> getRatePlans() {
		return ratePlans;
	}

	public void setRatePlans(List<RatePlan> ratePlans) {
		this.ratePlans = ratePlans;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public BaseSettings getBaseSettings() {
		return baseSettings;
	}

	public void setBaseSettings(BaseSettings baseSettings) {
		this.baseSettings = baseSettings;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public List<TaxesFee> getTaxesFees() {
		return taxesFees;
	}

	public void setTaxesFees(List<TaxesFee> taxesFees) {
		this.taxesFees = taxesFees;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Attribute {
        private String group;
        private List<Object> values;
		public String getGroup() {
			return group;
		}
		public void setGroup(String group) {
			this.group = group;
		}
		public List<Object> getValues() {
			return values;
		}
		public void setValues(List<Object> values) {
			this.values = values;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Commission {
        private String calculation;
        private String chargeType;
        private int value;
		public String getCalculation() {
			return calculation;
		}
		public void setCalculation(String calculation) {
			this.calculation = calculation;
		}
		public String getChargeType() {
			return chargeType;
		}
		public void setChargeType(String chargeType) {
			this.chargeType = chargeType;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Contact {
        private String email;
        private String phone;
        private String website;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getWebsite() {
			return website;
		}
		public void setWebsite(String website) {
			this.website = website;
		}
        
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coordinates {
        private double latitude;
        private double longitude;
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Description {
        private String description;
        private String language;
        private String type;
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
        
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Facility {
        private String category;
        private String categorySlug;
        private String classification;
        private int id;
        private String name;
        private String nameSlug;
        private int popular;
        private String type;
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getCategorySlug() {
			return categorySlug;
		}
		public void setCategorySlug(String categorySlug) {
			this.categorySlug = categorySlug;
		}
		public String getClassification() {
			return classification;
		}
		public void setClassification(String classification) {
			this.classification = classification;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNameSlug() {
			return nameSlug;
		}
		public void setNameSlug(String nameSlug) {
			this.nameSlug = nameSlug;
		}
		public int getPopular() {
			return popular;
		}
		public void setPopular(int popular) {
			this.popular = popular;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Image {
        private String created;
        private String description;
        private int id;
        private int priority;
        private Size size;
        private List<Object> tags;
        private String type;
        private String updated;
        private String uri;
		public String getCreated() {
			return created;
		}
		public void setCreated(String created) {
			this.created = created;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		public Size getSize() {
			return size;
		}
		public void setSize(Size size) {
			this.size = size;
		}
		public List<Object> getTags() {
			return tags;
		}
		public void setTags(List<Object> tags) {
			this.tags = tags;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUpdated() {
			return updated;
		}
		public void setUpdated(String updated) {
			this.updated = updated;
		}
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
        
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Size {
        private int height;
        private int width;
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        private String address;
        private City city;
        private String countryCode;
        private String postcode;
        private String region;
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public City getCity() {
			return city;
		}
		public void setCity(City city) {
			this.city = city;
		}
		public String getCountryCode() {
			return countryCode;
		}
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class City {
        private String hereMapsId;
        private int id;
        private String name;
		public String getHereMapsId() {
			return hereMapsId;
		}
		public void setHereMapsId(String hereMapsId) {
			this.hereMapsId = hereMapsId;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Policy {
        private Condition condition;
        private Dates dates;
        private Object extraData;
        private int id;
        private String name;
        private Object result;
        private String type;
        private Object conflict;

        public Object getConflict() {
            return conflict;
        }

        public void setConflict(Object conflict) {
            this.conflict = conflict;
        }
		public Condition getCondition() {
			return condition;
		}
		public void setCondition(Condition condition) {
			this.condition = condition;
		}
		public Dates getDates() {
			return dates;
		}
		public void setDates(Dates dates) {
			this.dates = dates;
		}
		public Object getExtraData() {
			return extraData;
		}
		public void setExtraData(Object extraData) {
			this.extraData = extraData;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Object getResult() {
			return result;
		}
		public void setResult(Object result) {
			this.result = result;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Condition {
        private List<String> nationalities;

		public List<String> getNationalities() {
			return nationalities;
		}

		public void setNationalities(List<String> nationalities) {
			this.nationalities = nationalities;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Dates {
        private Object end;
        private Object start;
		public Object getEnd() {
			return end;
		}
		public void setEnd(Object end) {
			this.end = end;
		}
		public Object getStart() {
			return start;
		}
		public void setStart(Object start) {
			this.start = start;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class RatePlan {
        private String baseRatePlanPmsCode;
        private Integer baseRateplanId;
        private String description;
        private int id;
        private boolean isBar;
        private boolean isPrivate;
        private String name;
        private String pmsCode;
        private List<Policy> policies;
        private RatePlanSettings settings;
        private List<Object> tags;
		public String getBaseRatePlanPmsCode() {
			return baseRatePlanPmsCode;
		}
		public void setBaseRatePlanPmsCode(String baseRatePlanPmsCode) {
			this.baseRatePlanPmsCode = baseRatePlanPmsCode;
		}
		public Integer getBaseRateplanId() {
			return baseRateplanId;
		}
		public void setBaseRateplanId(Integer baseRateplanId) {
			this.baseRateplanId = baseRateplanId;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isBar() {
			return isBar;
		}
		public void setBar(boolean isBar) {
			this.isBar = isBar;
		}
		public boolean isPrivate() {
			return isPrivate;
		}
		public void setPrivate(boolean isPrivate) {
			this.isPrivate = isPrivate;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPmsCode() {
			return pmsCode;
		}
		public void setPmsCode(String pmsCode) {
			this.pmsCode = pmsCode;
		}
		public List<Policy> getPolicies() {
			return policies;
		}
		public void setPolicies(List<Policy> policies) {
			this.policies = policies;
		}
		public RatePlanSettings getSettings() {
			return settings;
		}
		public void setSettings(RatePlanSettings settings) {
			this.settings = settings;
		}
		public List<Object> getTags() {
			return tags;
		}
		public void setTags(List<Object> tags) {
			this.tags = tags;
		}
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class RatePlanSettings {
        private Board board;
        private String charge;
        private String priceType;
        private Object status;
		public Board getBoard() {
			return board;
		}
		public void setBoard(Board board) {
			this.board = board;
		}
		public String getCharge() {
			return charge;
		}
		public void setCharge(String charge) {
			this.charge = charge;
		}
		public String getPriceType() {
			return priceType;
		}
		public void setPriceType(String priceType) {
			this.priceType = priceType;
		}
		public Object getStatus() {
			return status;
		}
		public void setStatus(Object status) {
			this.status = status;
		}
        
        
    }
	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Board {
        private String code;
        private String description;
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Room {
        private List<Bed> beds;
        private List<Description> descriptions;
        private List<Facility> facilities;
        private int hotelId;
        private int id;
        private List<Image> images;
        private String name;
        private String pmsCode;
        private List<RatePlan> ratePlans;
        private RoomSettings settings; 
        private String status;
        private String type;
		public List<Bed> getBeds() {
			return beds;
		}
		public void setBeds(List<Bed> beds) {
			this.beds = beds;
		}
		public List<Description> getDescriptions() {
			return descriptions;
		}
		public void setDescriptions(List<Description> descriptions) {
			this.descriptions = descriptions;
		}
		public List<Facility> getFacilities() {
			return facilities;
		}
		public void setFacilities(List<Facility> facilities) {
			this.facilities = facilities;
		}
		public int getHotelId() {
			return hotelId;
		}
		public void setHotelId(int hotelId) {
			this.hotelId = hotelId;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public List<Image> getImages() {
			return images;
		}
		public void setImages(List<Image> images) {
			this.images = images;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPmsCode() {
			return pmsCode;
		}
		public void setPmsCode(String pmsCode) {
			this.pmsCode = pmsCode;
		}
		public List<RatePlan> getRatePlans() {
			return ratePlans;
		}
		public void setRatePlans(List<RatePlan> ratePlans) {
			this.ratePlans = ratePlans;
		}
		public RoomSettings getSettings() {
			return settings;
		}
		public void setSettings(RoomSettings settings) {
			this.settings = settings;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RoomSettings {
        private Integer numberOfBedrooms;
        private Integer numberOfBeds;
        private Object roomSize;
        private SizeDetail size;
        private Integer adultsNumber;
        private Integer childrenNumber;
        private Integer infantsNumber;
        private Integer maxOccupancy;
        private Integer baseAdults;
        private Integer baseChildren;
        private Integer baseInfants;
		public Integer getNumberOfBedrooms() {
			return numberOfBedrooms;
		}
		public void setNumberOfBedrooms(Integer numberOfBedrooms) {
			this.numberOfBedrooms = numberOfBedrooms;
		}
		public Integer getNumberOfBeds() {
			return numberOfBeds;
		}
		public void setNumberOfBeds(Integer numberOfBeds) {
			this.numberOfBeds = numberOfBeds;
		}
		public Object getRoomSize() {
			return roomSize;
		}
		public void setRoomSize(Object roomSize) {
			this.roomSize = roomSize;
		}
		public SizeDetail getSize() {
			return size;
		}
		public void setSize(SizeDetail size) {
			this.size = size;
		}
		public Integer getAdultsNumber() {
			return adultsNumber;
		}
		public void setAdultsNumber(Integer adultsNumber) {
			this.adultsNumber = adultsNumber;
		}
		public Integer getChildrenNumber() {
			return childrenNumber;
		}
		public void setChildrenNumber(Integer childrenNumber) {
			this.childrenNumber = childrenNumber;
		}
		public Integer getInfantsNumber() {
			return infantsNumber;
		}
		public void setInfantsNumber(Integer infantsNumber) {
			this.infantsNumber = infantsNumber;
		}
		public Integer getMaxOccupancy() {
			return maxOccupancy;
		}
		public void setMaxOccupancy(Integer maxOccupancy) {
			this.maxOccupancy = maxOccupancy;
		}
		public Integer getBaseAdults() {
			return baseAdults;
		}
		public void setBaseAdults(Integer baseAdults) {
			this.baseAdults = baseAdults;
		}
		public Integer getBaseChildren() {
			return baseChildren;
		}
		public void setBaseChildren(Integer baseChildren) {
			this.baseChildren = baseChildren;
		}
		public Integer getBaseInfants() {
			return baseInfants;
		}
		public void setBaseInfants(Integer baseInfants) {
			this.baseInfants = baseInfants;
		}
        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SizeDetail {
        private Object squareMeters;
        private Integer squareFeet;
		public Object getSquareMeters() {
			return squareMeters;
		}
		public void setSquareMeters(Object squareMeters) {
			this.squareMeters = squareMeters;
		}
		public Integer getSquareFeet() {
			return squareFeet;
		}
		public void setSquareFeet(Integer squareFeet) {
			this.squareFeet = squareFeet;
		}
        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Bed {
        private String quantity;
        private Object size;
        private String type;
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public Object getSize() {
			return size;
		}
		public void setSize(Object size) {
			this.size = size;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BaseSettings { 
        private Integer numberOfFloors;
        private Integer numberOfRooms;
        private HotelType hotelType;
        private String timezone;
        private Integer utcOffset;
        private Integer maxInfantAge;
        private Integer maxChildAge;
        private String currency;
        private String checkIn;
        private String checkOut;
        private String cutOff;
		public Integer getNumberOfFloors() {
			return numberOfFloors;
		}
		public void setNumberOfFloors(Integer numberOfFloors) {
			this.numberOfFloors = numberOfFloors;
		}
		public Integer getNumberOfRooms() {
			return numberOfRooms;
		}
		public void setNumberOfRooms(Integer numberOfRooms) {
			this.numberOfRooms = numberOfRooms;
		}
		public HotelType getHotelType() {
			return hotelType;
		}
		public void setHotelType(HotelType hotelType) {
			this.hotelType = hotelType;
		}
		public String getTimezone() {
			return timezone;
		}
		public void setTimezone(String timezone) {
			this.timezone = timezone;
		}
		public Integer getUtcOffset() {
			return utcOffset;
		}
		public void setUtcOffset(Integer utcOffset) {
			this.utcOffset = utcOffset;
		}
		public Integer getMaxInfantAge() {
			return maxInfantAge;
		}
		public void setMaxInfantAge(Integer maxInfantAge) {
			this.maxInfantAge = maxInfantAge;
		}
		public Integer getMaxChildAge() {
			return maxChildAge;
		}
		public void setMaxChildAge(Integer maxChildAge) {
			this.maxChildAge = maxChildAge;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getCheckIn() {
			return checkIn;
		}
		public void setCheckIn(String checkIn) {
			this.checkIn = checkIn;
		}
		public String getCheckOut() {
			return checkOut;
		}
		public void setCheckOut(String checkOut) {
			this.checkOut = checkOut;
		}
		public String getCutOff() {
			return cutOff;
		}
		public void setCutOff(String cutOff) {
			this.cutOff = cutOff;
		}
        
        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class HotelType {
        private int id;
        private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TaxesFee {
        private String category;
        @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        private List<Charge> charge;
        private Dates dates;
        private String frequency;
        private Object group;
        private int id;
        private List<RatePlanRelation> ratePlans;
        private Object restriction;
        private String scope;
        private String title;
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}

		public List<Charge> getCharge() {
			return charge;
		}
		public void setCharge(List<Charge> charge) {
			this.charge = charge;
		}
		public Dates getDates() {
			return dates;
		}
		public void setDates(Dates dates) {
			this.dates = dates;
		}
		public String getFrequency() {
			return frequency;
		}
		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}
		public Object getGroup() {
			return group;
		}
		public void setGroup(Object group) {
			this.group = group;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public List<RatePlanRelation> getRatePlans() {
			return ratePlans;
		}
		public void setRatePlans(List<RatePlanRelation> ratePlans) {
			this.ratePlans = ratePlans;
		}
		public Object getRestriction() {
			return restriction;
		}
		public void setRestriction(Object restriction) {
			this.restriction = restriction;
		}
		public String getScope() {
			return scope;
		}
		public void setScope(String scope) {
			this.scope = scope;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Charge {
        private String rate;
        private String type;
        private int value;
		public String getRate() {
			return rate;
		}
		public void setRate(String rate) {
			this.rate = rate;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}

        
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RatePlanRelation {
        private int id;
        private String pmsCode;
        private String relation;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPmsCode() {
			return pmsCode;
		}
		public void setPmsCode(String pmsCode) {
			this.pmsCode = pmsCode;
		}
		public String getRelation() {
			return relation;
		}
		public void setRelation(String relation) {
			this.relation = relation;
		}
        
    }
}