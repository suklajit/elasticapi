package co.nz.csoft.elasticsearch.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.nz.csoft.elasticsearch.dto.Address;
import co.nz.csoft.elasticsearch.dto.ExternalReservationDto;
import co.nz.csoft.elasticsearch.dto.PropertiesOnlineTravelAgenciesDto;
import co.nz.csoft.elasticsearch.dto.PropertyDto;
import co.nz.csoft.elasticsearch.dto.PushBookingDto;
import co.nz.csoft.elasticsearch.dto.RoomDetails;
import co.nz.csoft.elasticsearch.service.BookingService;


@Service
public class BookingServiceImpl implements BookingService{
	@Value("${cleartrip.bookone.channel.id}")
	private String channelId;
	private String channelIntegrationUrl;
	RestTemplate restTemplate = new RestTemplate();
	ObjectMapper objMapper = new ObjectMapper();

	@Override
	public void createReservationThmToHyp(ExternalReservationDto externalReservationDto) {
		
		PushBookingDto bookingDto = new PushBookingDto();
		String dateString = externalReservationDto.getCreatedTimestamp().toString();
		String inputPattern = "EEE MMM dd HH:mm:ss zzz yyyy";
		String desiredPattern = "yyyy-MM-dd HH:mm:ss";
		// Step 1: Parse input string into Date object
		SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputPattern, Locale.ENGLISH);
		java.util.Date date = null;

		PropertyDto propertyDtoData = null;
		String hyperguestPropertyId = null;
		/*
		try {
			date = inputDateFormat.parse(dateString);
			ResponseEntity<PropertyDto> propertyDto = restTemplate.getForEntity(
					channelIntegrationUrl + "/api/channelManager/property/" + externalReservationDto.getPropertyId(),
					PropertyDto.class);
			propertyDtoData = propertyDto.getBody();
			for (PropertiesOnlineTravelAgenciesDto propertiesOnlineTravelAgenciesDto : propertyDtoData
					.getPropertiesOnlineTravelAgencies()) {
				if (propertiesOnlineTravelAgenciesDto.getOnlineTravelAgencyId() == Long.valueOf(channelId)) {
					hyperguestPropertyId = propertiesOnlineTravelAgenciesDto.getOnlineTravelAgencyPropertyId();
				}
			}

		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		*/
		PushBookingDto.Dates dates = new PushBookingDto.Dates();
		for (RoomDetails roomDetails : externalReservationDto.getRoomDetails()) {
	    dates.setFrom(externalReservationDto.getCheckinDate()); // format: yyyy-MM-dd
	    dates.setTo(externalReservationDto.getCheckoutDate());
	    bookingDto.setDates(dates);
	    
	    bookingDto.setPropertyId(externalReservationDto.getPropertyId());
	    
	    PushBookingDto.LeadGuest leadGuest = new PushBookingDto.LeadGuest();
	    leadGuest.setTitle("MR");
	    leadGuest.setBirthDate("1997-08-03");
	    PushBookingDto.Name leadName = new PushBookingDto.Name();
	    leadName.setFirst(externalReservationDto.getFirstName());
	    leadName.setLast(externalReservationDto.getLastName());
	    leadGuest.setName(leadName);
	    Address address = externalReservationDto.getAddress();
	    PushBookingDto.Contact leadContact = new PushBookingDto.Contact();
	    leadContact.setAddress(address.getLocality());
	    leadContact.setCity(address.getCity());
	    leadContact.setState(address.getState());
	    leadContact.setCountry(address.getCountry());
	    leadContact.setZip(address.getPostcode());
	    leadContact.setPhone(externalReservationDto.getContactNumber());
	    leadContact.setEmail(externalReservationDto.getEmail());
	    leadGuest.setContact(leadContact);

	    bookingDto.setLeadGuest(leadGuest);


	    PushBookingDto.Reference reference = new PushBookingDto.Reference();
	    reference.setAgency(externalReservationDto.getExternalTransactionId());
	    bookingDto.setReference(reference);


	    // 5. Payment Details (dummy or actual)
	    PushBookingDto.PaymentDetails paymentDetails = new PushBookingDto.PaymentDetails();
	    paymentDetails.setType(externalReservationDto.getModeOfPayment()); 

	

	    PushBookingDto.CardDetails cardDetails = new PushBookingDto.CardDetails();
	    cardDetails.setNumber("4111111111111111"); 
	    cardDetails.setCvv("123");
	    
	    PushBookingDto.Expiry expiry = new PushBookingDto.Expiry();
	    expiry.setMonth("12");
	    expiry.setYear("2028");
	    cardDetails.setExpiry(expiry);

	    cardDetails.setName(leadName); 
	    paymentDetails.setDetails(cardDetails);

	    bookingDto.setPaymentDetails(paymentDetails);

	    // 6. Rooms
	    PushBookingDto.Room room = new PushBookingDto.Room();
	    room.setRoomCode(roomDetails.getRoomTypeId());
	    room.setRateCode(roomDetails.getPlan());
	    
	    PushBookingDto.ExpectedPrice expectedPrice = new PushBookingDto.ExpectedPrice();
	    expectedPrice.setAmount(externalReservationDto.getTotalAmount().doubleValue());
	    System.out.println("externalReservationDto.getCurrency() :"+ externalReservationDto.getCurrency());
	    expectedPrice.setCurrency(externalReservationDto.getCurrency());
	    room.setExpectedPrice(expectedPrice);

	    // Guests in room
	    PushBookingDto.Guest guest = new PushBookingDto.Guest();
	    guest.setTitle("MR");
	    guest.setBirthDate("1990-01-01");
	    guest.setName(leadName);
	    guest.setContact(leadContact);

	    List<PushBookingDto.Guest> guestList = new ArrayList<>();
	    guestList.add(guest);
	    room.setGuests(guestList);
	    
	    List<String> specialRequests = new ArrayList<>();
	    specialRequests.add(externalReservationDto.getNotes());
//	    specialRequests.add("Non-smoking");
	    room.setSpecialRequests(specialRequests);

	    List<PushBookingDto.Room> roomsList = new ArrayList<>();
	    roomsList.add(room);
	    bookingDto.setRooms(roomsList);

	    // 7. Meta (optional)
	    PushBookingDto.Meta meta = new PushBookingDto.Meta();
	    meta.setKey("source");
	    meta.setValue("HyperGuest");

	    List<PushBookingDto.Meta> metaList = new ArrayList<>();
	    metaList.add(meta);
	    bookingDto.setMeta(metaList);

	    // 8. Flags
	    //bookingDto.setTest(false);
	    bookingDto.setGroupBooking(false);
		
	}
		 String pushbookingurl = "https://book-api.hyperguest.com/2.0/booking/create";
		    
		    try {
		    	ObjectMapper objectMapper = new ObjectMapper();
		        String jsonRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDto);
		        System.out.println("REQUEST JSON:\n" + jsonRequest);
		        RestTemplate restTemplate = new RestTemplate();
		        HttpHeaders headers = new HttpHeaders();
		        headers.setContentType(MediaType.APPLICATION_JSON);
		       // headers.set("Accept-Encoding", "gzip, deflate");
		        headers.set("Authorization", "Bearer 5fa9f6b4ef284c49935baf3e3dd0b11a");
		        HttpEntity<PushBookingDto> request = new HttpEntity<>(bookingDto, headers);

		        ResponseEntity<String> response = restTemplate.postForEntity(pushbookingurl, request, String.class);
		        System.out.println("Booking created. Status: " + response.getStatusCode());
		        System.out.println("Response: " + response.getBody());
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}


}
