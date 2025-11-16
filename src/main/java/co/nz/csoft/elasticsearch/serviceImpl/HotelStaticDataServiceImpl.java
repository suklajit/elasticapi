package co.nz.csoft.elasticsearch.serviceImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;

import co.nz.csoft.elasticsearch.dto.Address;
import co.nz.csoft.elasticsearch.dto.BankAccount;
import co.nz.csoft.elasticsearch.dto.HotelStaticDataDto;
import co.nz.csoft.elasticsearch.dto.RulesDto;
import co.nz.csoft.elasticsearch.dto.RulesDto.Policy;
import co.nz.csoft.elasticsearch.dto.SearchPropertyDto;
import co.nz.csoft.elasticsearch.dto.SearchPropertyDto.PropertyInfo;
import co.nz.csoft.elasticsearch.dto.SearchPropertyDto.RatePlan;
import co.nz.csoft.elasticsearch.dto.SearchPropertyDto.Result;
import co.nz.csoft.elasticsearch.dto.SearchPropertyDto.Room;
import co.nz.csoft.elasticsearch.dto.StaticPropertyResponseDto;
import co.nz.csoft.elasticsearch.dto.StaticPropertyResponseDto.TaxesFee;
import co.nz.csoft.elasticsearch.enums.DayOfTheWeek;
import co.nz.csoft.elasticsearch.model.CityLocation;
import co.nz.csoft.elasticsearch.model.HotelLocation;
import co.nz.csoft.elasticsearch.model.HotelSearchDocument;
import co.nz.csoft.elasticsearch.model.HotelStaticData;
import co.nz.csoft.elasticsearch.model.PropertyName;
import co.nz.csoft.elasticsearch.model.PropertySearchDocument;
import co.nz.csoft.elasticsearch.repository.CityLocationRepository;
import co.nz.csoft.elasticsearch.repository.HotelLocationRepository;
import co.nz.csoft.elasticsearch.repository.HotelSearchRepository;
import co.nz.csoft.elasticsearch.repository.HotelStaticDataRepo;
import co.nz.csoft.elasticsearch.repository.PropertyNameRepository;
import co.nz.csoft.elasticsearch.service.HotelStaticDataService;
import co.nz.csoft.elasticsearch.thm.dto.Image;
import co.nz.csoft.elasticsearch.thm.dto.PropertyServices;
import co.nz.csoft.elasticsearch.thm.dto.RatesAndAvailabilityDto;
import co.nz.csoft.elasticsearch.thm.dto.RoomDto;
import co.nz.csoft.elasticsearch.thm.dto.RoomRatePlan;
import co.nz.csoft.elasticsearch.thm.dto.TaxDetails;
import co.nz.csoft.elasticsearch.thm.dto.TaxSlabs;
import co.nz.csoft.elasticsearch.thm.dto.ThmPropertyDto;

@Service
public class HotelStaticDataServiceImpl implements HotelStaticDataService {
	@Value("${static.hotel.url}")
	private String staticHotelUrl;

	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private HotelStaticDataRepo hotelStaticDataRepo;
	@Autowired
	private HotelSearchRepository hotelSearchRepository;
	@Autowired
	private ElasticsearchRestTemplate elasticsearchRestTemplate;
	@Autowired
	private HotelStaticDataService hotelStaticDataService;
	 @Autowired
	private CityLocationRepository cityLocationRepository;
	@Autowired
	private co.nz.csoft.elasticsearch.repository.PropertySearchDocumentRepository PropertySearchDocumentRepository;

	@Autowired
	private HotelLocationRepository hotelLocationRepository;
	
	  @Autowired
	  private PropertyNameRepository propertyNameRepository;
	  
	  @Autowired
	  private RestHighLevelClient restHighLevelClient;

	private static final Logger log = LoggerFactory.getLogger(HotelStaticDataServiceImpl.class);
	// RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private RestTemplate restTemplate;
	ObjectMapper objMapper = new ObjectMapper();

	private final String hotelDetailUrl = "https://hg-static.hyperguest.com/{hotelId}/property-static.json";
	
	@Override
	public void fetchHotelStaticData() {
		log.info("Fetching hotel static data from API...");

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		//headers.set("Authorization", "Bearer 85c3605ea65048e984e04db75ab5ce81");
		headers.set("Authorization", "Bearer 5fa9f6b4ef284c49935baf3e3dd0b11a");		
		HttpEntity<String> entity = new HttpEntity<>(headers);

		// Fetch data
		ResponseEntity<HotelStaticDataDto[]> response = restTemplate.exchange(staticHotelUrl, HttpMethod.GET, entity,
				HotelStaticDataDto[].class);

		HotelStaticDataDto[] hotelStaticDataDtos = response.getBody();

		if (hotelStaticDataDtos == null || hotelStaticDataDtos.length == 0) {
			log.warn("No hotel data received from API.");
			return;
		}

		log.info("Processing {} hotels...", hotelStaticDataDtos.length);

		// Fetch all existing hotels once
		Map<Long, HotelStaticData> existingHotelMap = hotelStaticDataRepo.findAll().stream()
				.collect(Collectors.toMap(HotelStaticData::getHotelId, h -> h));

		List<HotelStaticData> staticDataToSave = new ArrayList<>();
		List<HotelSearchDocument> elasticDocs = new ArrayList<>();

		int count = 0;
		for (HotelStaticDataDto dto : hotelStaticDataDtos) {
			HotelStaticData hotel = existingHotelMap.getOrDefault(dto.getHotelId(), new HotelStaticData());
			hotel.setHotelId(dto.getHotelId());
			hotel.setLastUpdated(dto.getLastUpdated());
			hotel.setCity(dto.getCity());
			hotel.setCityId(dto.getCityId());
			hotel.setCountry(dto.getCountry());
			hotel.setName(dto.getName());
			hotel.setRegion(dto.getRegion());
			staticDataToSave.add(hotel);

			HotelSearchDocument doc = new HotelSearchDocument();
			doc.setHotelId(dto.getHotelId());
			doc.setLastUpdated(dto.getLastUpdated());
			doc.setCity(dto.getCity());
			doc.setCityId(dto.getCityId());
			doc.setCountry(dto.getCountry());
			doc.setName(dto.getName());
			doc.setRegion(dto.getRegion());
			elasticDocs.add(doc);

			count++;
			if (count % 1000 == 0) {
				log.info("Prepared {} hotels...", count);
			}
		}

		log.info("Saving {} hotel records to database...", staticDataToSave.size());
		hotelStaticDataRepo.saveAll(staticDataToSave);

		log.info("Saving {} hotel documents to Elasticsearch...", elasticDocs.size());
		saveToElasticsearchInBatches(elasticDocs, 500); // increase batch size if needed

		log.info("Hotel static data fetch and save completed.");
	}

	private void saveToElasticsearchInBatches(List<HotelSearchDocument> documents, int batchSize) {
		int totalIndexed = 0;
		for (int i = 0; i < documents.size(); i += batchSize) {
			int end = Math.min(i + batchSize, documents.size());
			List<HotelSearchDocument> batch = documents.subList(i, end);

			List<IndexQuery> queries = batch.stream().map(doc -> {
				IndexQuery query = new IndexQuery();
				query.setId(doc.getHotelId().toString());
				query.setObject(doc);
				return query;
			}).collect(Collectors.toList());

			try {
				log.info("Indexing batch {} - {} ({} docs)", i, end, queries.size());
				elasticsearchRestTemplate.bulkIndex(queries, IndexCoordinates.of("hotelsearchdocument"));
				totalIndexed += queries.size();
			} catch (Exception e) {
				log.error("Failed to index batch {} - {}: {}", i, end, e.getMessage(), e);
			}
		}
		log.info("Elasticsearch indexing completed. Total documents indexed: {}", totalIndexed);
	}

	@Override
	public HotelStaticDataDto createHotelStaticData(HotelStaticDataDto hotelStaticDataDto) {
		HotelStaticData hotelStaticData = modelMapper.map(hotelStaticDataDto, HotelStaticData.class);
		hotelStaticData = hotelStaticDataRepo.save(hotelStaticData);
		hotelStaticDataDto = modelMapper.map(hotelStaticData, HotelStaticDataDto.class);
		return hotelStaticDataDto;
	}

	@Override
	public List<HotelStaticDataDto> createListOfHotelStaticData(List<HotelStaticDataDto> hotelStaticDataDtos) {
		List<HotelStaticData> hotelStaticDataList = new ArrayList<>();
		for (HotelStaticDataDto hotelStaticDataDto : hotelStaticDataDtos) {
			HotelStaticData hotelStaticData = modelMapper.map(hotelStaticDataDto, HotelStaticData.class);
			hotelStaticDataList.add(hotelStaticData);
		}

		hotelStaticDataList = hotelStaticDataRepo.saveAll(hotelStaticDataList);

		List<HotelStaticDataDto> savedhotelStaticDataDtos = new ArrayList<>();
		for (HotelStaticData hotelStaticData : hotelStaticDataList) {
			savedhotelStaticDataDtos.add(modelMapper.map(hotelStaticData, HotelStaticDataDto.class));
		}
		return savedhotelStaticDataDtos;
	}

	@Override
	public List<HotelStaticDataDto> getAllByHotelId(Long hotelId) {
		List<HotelStaticData> hotelStaticDataList = hotelStaticDataRepo.findByHotelId(hotelId);
		List<HotelStaticDataDto> hotelStaticDataDtoList = new ArrayList<HotelStaticDataDto>();
		for (HotelStaticData hotelStaticData : hotelStaticDataList) {
			HotelStaticDataDto hotelStaticDataDto = modelMapper.map(hotelStaticData, HotelStaticDataDto.class);
			hotelStaticDataDtoList.add(hotelStaticDataDto);
		}
		return hotelStaticDataDtoList;
	}

	@Override
	public List<HotelStaticDataDto> findByCity(String city) {
		List<HotelStaticData> hotelStaticDataList = new ArrayList<HotelStaticData>();
		hotelStaticDataList = this.hotelStaticDataRepo.findByCity(city);
		List<HotelStaticDataDto> hotelStaticDataDtoList = new ArrayList<HotelStaticDataDto>();
		for (HotelStaticData hotelStaticData : hotelStaticDataList) {
			HotelStaticDataDto hotelStaticDataDto = modelMapper.map(hotelStaticData, HotelStaticDataDto.class);
			hotelStaticDataDtoList.add(hotelStaticDataDto);
		}
		return hotelStaticDataDtoList;
	}

	public List<HotelStaticDataDto> findByCountry(String country, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<HotelStaticData> hotelStaticDataPage = hotelStaticDataRepo.findByCountry(country, pageable);

		List<HotelStaticDataDto> hotelStaticDataDtoList = new ArrayList<>();
		for (HotelStaticData hotelStaticData : hotelStaticDataPage.getContent()) {
			hotelStaticDataDtoList.add(modelMapper.map(hotelStaticData, HotelStaticDataDto.class));
		}

		return hotelStaticDataDtoList;
	}

	@Override
	public ThmPropertyDto checkAvailability(String source, Date fromDate, Date toDate, Integer noOfRooms,
			Integer noOfPersons, Integer noOfChildren, Long hotelIds) {
		if ("hyperguest".equalsIgnoreCase(source)) {
			return fetchPropertyFromHyperguest(fromDate, toDate, noOfRooms, noOfPersons, noOfChildren, hotelIds);
		} else if ("thehotelmate".equalsIgnoreCase(source)) {
			return fetchPropertyFromHotelMate(fromDate, toDate, noOfRooms, noOfPersons, noOfChildren, hotelIds);
		} else {
			throw new IllegalArgumentException("Unsupported source: " + source);
		}
	}

	public ThmPropertyDto fetchPropertyFromHotelMate(Date fromDate, Date toDate, Integer noOfRooms, Integer noOfPersons,
			Integer noOfChildren, Long hotelIds) {
		if (hotelIds == null) {
			throw new IllegalArgumentException("Hotel ID is required");
		}

		// Format Date to yyyy-MM-dd
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateStr = sdf.format(fromDate);
		String toDateStr = sdf.format(toDate);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<>(headers);

		String url = "https://api.thehotelmate.co/api/thm/checkAvailability/" + hotelIds + "?fromDate=" + fromDateStr
				+ "&toDate=" + toDateStr + "&noOfRooms=" + noOfRooms + "&noOfPersons=" + noOfPersons;
		System.out.println("hotelmateUrl :" + url);

		ResponseEntity<ThmPropertyDto> response = restTemplate.exchange(url, HttpMethod.GET, entity,
				ThmPropertyDto.class);

		return response.getBody(); 
	}

	public ThmPropertyDto fetchPropertyFromHyperguest(Date fromDate, Date toDate, Integer noOfRooms,
			Integer noOfPersons, Integer noOfChildren, Long hotelIds) {
		if (hotelIds == null) {
			return null; // Or throw new IllegalArgumentException("Hotel ID is required");
		}

		// Calculate nights from fromDate and toDate
		long nights = ChronoUnit.DAYS.between(fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

		if (nights <= 0) {
			throw new IllegalArgumentException("ToDate must be after FromDate");
		}

		// Format check-in date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String checkIn = sdf.format(fromDate);

		String guestsParam = buildGuestsParam(noOfRooms, noOfPersons, noOfChildren);

		// Build URL
		String url = "https://search-api.hyperguest.io/2.0/?" + "checkIn=" + checkIn + "&nights=" + nights + "&guests="
				+ guestsParam + "&hotelIds=" + hotelIds;

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer 5fa9f6b4ef284c49935baf3e3dd0b11a");

		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<SearchPropertyDto> response = restTemplate.exchange(url, HttpMethod.GET, entity,
				SearchPropertyDto.class);

		System.out.println("Hyperguest URL: " + url);

		SearchPropertyDto searchPropertyDto = response.getBody();

		if (searchPropertyDto != null && searchPropertyDto.getResults() != null
				&& !searchPropertyDto.getResults().isEmpty()) {
			Result result = searchPropertyDto.getResults().get(0); // Only take the first result

			PropertyInfo propertyInfo = result.getPropertyInfo();
			ThmPropertyDto thmPropertyDto = new ThmPropertyDto();
			thmPropertyDto.setId(result.getPropertyId());
			thmPropertyDto.setName(propertyInfo.getName());
			thmPropertyDto.setBusinessSubtype(propertyInfo.getPropertyTypeName());
			thmPropertyDto.setLongitude(String.valueOf(propertyInfo.getLongitude()));
			thmPropertyDto.setLatitude(String.valueOf(propertyInfo.getLatitude()));

			Address address = new Address();
			address.setCity(propertyInfo.getCityName());
			address.setCountry(propertyInfo.getCountryCode());
			thmPropertyDto.setAddress(address);

			List<RoomDto> roomList = new ArrayList<>();
			for (Room room : result.getRooms()) {
				RoomDto roomDto = new RoomDto();

				roomDto.setId(room.getRoomId());
				roomDto.setName(room.getRoomName());
				roomDto.setNoOfRooms(room.getNumberOfAvailableRooms());
				roomDto.setPropertyId(result.getPropertyId());
				roomDto.setMaximumOccupancy(room.getSettings().getMaxOccupancy());
				roomDto.setMinimumOccupancy(room.getSearchedPax().getAdults());

				RatesAndAvailabilityDto ratesAndAvailabilityDto = new RatesAndAvailabilityDto();
				ratesAndAvailabilityDto.setRoomName(room.getRoomTypeCode());
				ratesAndAvailabilityDto.setPropertyName(propertyInfo.getName());
				ratesAndAvailabilityDto.setRoomId(room.getRoomId());
				ratesAndAvailabilityDto.setPropertyId(result.getPropertyId());
				ratesAndAvailabilityDto.setNoOfAvailable(room.getSettings().getRoomSize());
				ratesAndAvailabilityDto.setNoOfBooked(0);
				ratesAndAvailabilityDto.setNoOfOnHold(0);
				

				List<RoomRatePlan> roomRatePlans = new ArrayList<>();
				for (RatePlan ratePlan : room.getRatePlans()) {
					RoomRatePlan roomRatePlan = new RoomRatePlan();
					roomRatePlan.setCode(ratePlan.getRatePlanCode());
					roomRatePlan.setName(ratePlan.getRatePlanName());
					roomRatePlan.setAmount(BigDecimal.valueOf(ratePlan.getPrices().getSell().getPrice()));
					roomRatePlan.setCurrencyCode(ratePlan.getPrices().getSell().getCurrency());
					roomRatePlan.setRoomId(room.getRoomId());
					roomRatePlan.setActive(true);
					roomRatePlan.setNoOfChildren(room.getSettings().getMaxChildrenNumber());
					roomRatePlan.setMaximumOccupancy(room.getSettings().getMaxOccupancy());
					roomRatePlan.setMinimumOccupancy(room.getSearchedPax().getAdults());
					roomRatePlan.setDayOfTheWeekList(Arrays.asList(DayOfTheWeek.values()));
					roomRatePlan.setMinimumLengthOfStay(1);
					roomRatePlan.setMaximumLengthOfStay(999);
					ratesAndAvailabilityDto.setId(ratePlan.getRatePlanId());
					roomRatePlans.add(roomRatePlan);
				}

				ratesAndAvailabilityDto.setRoomRatePlans(roomRatePlans);
				roomDto.setRatesAndAvailabilityDtos(Collections.singletonList(ratesAndAvailabilityDto));

				roomList.add(roomDto);
			}

			thmPropertyDto.setRoomList(roomList);
			return thmPropertyDto;
		}

		return null;
	}

	private String buildGuestsParam(int noOfRooms, int noOfPersons, Integer noOfChildren) {
		if (noOfRooms <= 0 || noOfPersons <= 0) {
			return ""; // Handle invalid input
		}

		int actualNoOfChildren = (noOfChildren != null) ? noOfChildren : 0;
		int noOfAdults = noOfPersons - actualNoOfChildren;
		StringBuilder guestsParam = new StringBuilder();
		int[] guestsPerRoom = new int[noOfRooms];
		int distributedAdults = 0;

		// Distribute adults with priority to the first rooms to match desired pattern
		for (int i = 0; i < noOfAdults; i++) {
			guestsPerRoom[i % noOfRooms]++;
		}

		for (int i = 0; i < noOfRooms; i++) {
			guestsParam.append(guestsPerRoom[i]);
			if (actualNoOfChildren > 0) {
				guestsParam.append("-").append(actualNoOfChildren);
			}
			if (i < noOfRooms - 1) {
				guestsParam.append(".");
			}
		}

		return guestsParam.toString();
	}

	/*
	 * @Override public List<ThmPropertyDto> fetchPropertyFromHyperguest(String
	 * checkIn, int nights, int guests, String hotelIds, String customerNationality,
	 * int page, int size) {
	 * 
	 * List<String> hotelIdList = new ArrayList<>();
	 * 
	 * if (hotelIds != null && !hotelIds.trim().isEmpty()) { hotelIdList =
	 * Arrays.asList(hotelIds.split(",")); } else { // If hotelIds not provided,
	 * return empty list or throw exception return Collections.emptyList(); // or
	 * throw new IllegalArgumentException("Hotel IDs are required"); }
	 * 
	 * String filterHotelId = String.join(",", hotelIdList);
	 * 
	 * HttpHeaders headers = new HttpHeaders(); headers.set("Content-Type",
	 * "application/json"); headers.set("Authorization",
	 * "Bearer 85c3605ea65048e984e04db75ab5ce81");
	 * 
	 * HttpEntity<String> entity = new HttpEntity<>(headers); String url =
	 * "https://search-api.hyperguest.io/2.0/?" + "checkIn=" + checkIn + "&nights="
	 * + nights + "&guests=" + guests + "&hotelIds=" + filterHotelId; if
	 * (customerNationality != null && !customerNationality.isEmpty()) { url +=
	 * "&customerNationality=" + customerNationality; }
	 * 
	 * ResponseEntity<SearchPropertyDto> searchPropertyDtoList =
	 * restTemplate.exchange(url, HttpMethod.GET, entity, SearchPropertyDto.class);
	 * System.out.println("url :" + url); SearchPropertyDto searchPropertyDto =
	 * searchPropertyDtoList.getBody();
	 * 
	 * List<ThmPropertyDto> propertyList = new ArrayList<>();
	 * 
	 * if (searchPropertyDto != null && searchPropertyDto.getResults() != null &&
	 * !searchPropertyDto.getResults().isEmpty()) { for (Result result :
	 * searchPropertyDto.getResults()) {
	 * 
	 * PropertyInfo propertyInfo = result.getPropertyInfo(); ThmPropertyDto
	 * thmPropertyDto = new ThmPropertyDto();
	 * thmPropertyDto.setId(result.getPropertyId());
	 * thmPropertyDto.setName(propertyInfo.getName());
	 * thmPropertyDto.setBusinessSubtype(propertyInfo.getPropertyTypeName());
	 * thmPropertyDto.setLongitude(String.valueOf(propertyInfo.getLongitude()));
	 * thmPropertyDto.setLatitude(String.valueOf(propertyInfo.getLatitude()));
	 * 
	 * Address address = new Address(); address.setCity(propertyInfo.getCityName());
	 * address.setCountry(propertyInfo.getCountryName());
	 * thmPropertyDto.setAddress(address);
	 * 
	 * List<RoomDto> roomList = new ArrayList<>(); for (Room room :
	 * result.getRooms()) { RoomDto roomDto = new RoomDto();
	 * 
	 * roomDto.setId(room.getRoomId()); roomDto.setName(room.getRoomName());
	 * roomDto.setNoOfRooms(room.getNumberOfAvailableRooms());
	 * roomDto.setPropertyId(result.getPropertyId());
	 * roomDto.setMaximumOccupancy(room.getSettings().getMaxOccupancy());
	 * roomDto.setMinimumOccupancy(room.getSettings().getMaxAdultsNumber());
	 * 
	 * // ✅ Create only one RatesAndAvailabilityDto per room RatesAndAvailabilityDto
	 * ratesAndAvailabilityDto = new RatesAndAvailabilityDto();
	 * ratesAndAvailabilityDto.setRoomName(room.getRoomName());
	 * ratesAndAvailabilityDto.setPropertyName(propertyInfo.getName());
	 * ratesAndAvailabilityDto.setRoomId(room.getRoomId());
	 * ratesAndAvailabilityDto.setPropertyId(result.getPropertyId());
	 * 
	 * // ✅ Add all rate plans to one list List<RoomRatePlan> roomRatePlans = new
	 * ArrayList<>(); for (RatePlan ratePlan : room.getRatePlans()) { RoomRatePlan
	 * roomRatePlan = new RoomRatePlan();
	 * roomRatePlan.setCode(ratePlan.getRatePlanCode());
	 * roomRatePlan.setName(ratePlan.getRatePlanName());
	 * roomRatePlan.setAmount(BigDecimal.valueOf(ratePlan.getPrices().getSell().
	 * getPrice()));
	 * roomRatePlan.setCurrencyCode(ratePlan.getPrices().getSell().getCurrency());
	 * roomRatePlan.setRoomId(room.getRoomId()); roomRatePlans.add(roomRatePlan); }
	 * 
	 * ratesAndAvailabilityDto.setRoomRatePlans(roomRatePlans);
	 * 
	 * roomDto.setRatesAndAvailabilityDtos(Collections.singletonList(
	 * ratesAndAvailabilityDto)); roomList.add(roomDto); }
	 * 
	 * thmPropertyDto.setRoomList(roomList); propertyList.add(thmPropertyDto); } }
	 * 
	 * return propertyList; }
	 */
/*
	@Override
	public List<ThmPropertyDto> fetchAndMapAllHotelData() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Bearer 5fa9f6b4ef284c49935baf3e3dd0b11a");
		HttpEntity<String> entity = new HttpEntity<>(headers);

		List<HotelStaticDataDto> limitedHotelList = hotelStaticDataRepo.findAll().stream()
				.map(hotel -> modelMapper.map(hotel, HotelStaticDataDto.class)).collect(Collectors.toList());

		if (limitedHotelList.isEmpty()) {
			log.warn("No hotel data found in database.");
			return new ArrayList<>();
		}

		ExecutorService fetchExecutor = Executors.newFixedThreadPool(10);
		ObjectMapper objectMapper = new ObjectMapper();
		RateLimiter rateLimiter = RateLimiter.create(1.0);

		for (HotelStaticDataDto hotelStaticDataDto : limitedHotelList) {
			fetchExecutor.submit(() -> {
				rateLimiter.acquire();
				try {
					Long hotelId = hotelStaticDataDto.getHotelId();
					String detailUrl = hotelDetailUrl.replace("{hotelId}", String.valueOf(hotelId));
					log.info("Fetching HyperGuest hotel detail URL: {}", detailUrl);

					ResponseEntity<String> detailResponse = restTemplate.exchange(detailUrl, HttpMethod.GET, entity,
							String.class);

					if (detailResponse.getStatusCode() == HttpStatus.OK) {
						StaticPropertyResponseDto staticPropertyResponseDto = objectMapper
								.readValue(detailResponse.getBody(), StaticPropertyResponseDto.class);

						ThmPropertyDto thmPropertyDto = mapStaticPropertyResponseDtoToThmPropertyDto(
								staticPropertyResponseDto);

						if (thmPropertyDto != null) {
							thmPropertyDto.setSource("hyperguest");
							log.info("Processed hotelId: {}, hotelName: {}", hotelId, thmPropertyDto.getName());

							savePropertyToElastic(thmPropertyDto);
						}
					} else {
						log.warn("Failed to fetch details for hotel {}: {}", hotelId, detailResponse.getStatusCode());
					}

				} catch (Exception e) {
					log.error("Error processing hotel {}: {}", hotelStaticDataDto.getHotelId(), e.getMessage(), e);
				}
			});

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		fetchExecutor.shutdown();
		try {
			fetchExecutor.awaitTermination(20, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			log.error("Interrupted while waiting for hotel detail fetch threads", e);
		}

		// Fetch and immediately index HotelMate properties
		fetchAndIndexHotelMateProperties();

		log.info("Successfully processed and indexed HotelMate and HyperGuest properties to Elasticsearch.");
		return new ArrayList<>();
	}*/
	

	@Override
	public List<ThmPropertyDto> fetchAndMapAllHotelData() {
	    try {
	      
	        // ✅ NEW LOGIC: Only fetch and store HotelMate properties
	        fetchAndIndexHotelMateProperties();
	        log.info("Successfully processed and indexed only HotelMate properties to Elasticsearch.");

	    } catch (Exception e) {
	        log.error("Error while fetching and indexing HotelMate properties: {}", e.getMessage(), e);
	    }

	    return new ArrayList<>();
	}


	private void fetchAndIndexHotelMateProperties() {
		int page = 0;
		int size = 50;

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ObjectMapper mapper = new ObjectMapper();

		while (true) {
			try {
				String url = String.format("https://api.thehotelmate.co/api/thm/findAllProperty?page=%d&size=%d", page,
						size);
				log.info("Fetching HotelMate URL: {}", url);

				ParameterizedTypeReference<Map<String, Object>> typeReference = new ParameterizedTypeReference<Map<String, Object>>() {
				};
				ResponseEntity<Map<String, Object>> response = restTemplate.exchange(url, HttpMethod.GET, entity,
						typeReference);

				List<Map<String, Object>> content = (List<Map<String, Object>>) response.getBody().get("content");
				if (content == null || content.isEmpty())
					break;

				for (Map<String, Object> item : content) {
					ThmPropertyDto dto = mapper.convertValue(item, ThmPropertyDto.class);
					dto.setSource("thehotelmate");
					try {
					    // Get roomList from the raw map
					    List<Map<String, Object>> roomList = (List<Map<String, Object>>) item.get("roomList");

					    if (roomList != null && !roomList.isEmpty()) {
					        Object roomOnlyPriceObj = roomList.get(0).get("roomOnlyPrice");

					        if (roomOnlyPriceObj != null) {
					            // Safest conversion: avoid double precision issues
					            BigDecimal minPrice = new BigDecimal(roomOnlyPriceObj.toString());

					            // If you want 2-decimal formatting:
					            // minPrice = minPrice.setScale(2, RoundingMode.HALF_UP);

					            dto.setMinimumRoooPrice(minPrice);
					            log.info("✅ Set minimumRoomPrice={} for propertyId={}", minPrice, dto.getId());
					        } else {
					            // Only if price is completely missing/null
					            dto.setMinimumRoooPrice(BigDecimal.ZERO);
					            log.info("⚠️ roomOnlyPrice missing, defaulting to 0 for propertyId={}", dto.getId());
					        }
					    } else {
					        dto.setMinimumRoooPrice(BigDecimal.ZERO);
					        log.info("⚠️ roomList empty, defaulting minimumRoomPrice=0 for propertyId={}", dto.getId());
					    }
					} catch (Exception ex) {
					    dto.setMinimumRoooPrice(BigDecimal.ZERO); // safe fallback
					    log.warn("❌ Failed to extract minimumRoomPrice for propertyId={}: {}", dto.getId(), ex.getMessage());
					}


					savePropertyToElastic(dto);
				}

				  boolean last = (boolean) response.getBody().get("last");
			        if (last) break;

			        page++;

			} catch (Exception e) {
				log.error("Error fetching batch {} of HotelMate properties: {}", page, e.getMessage(), e);
				break;
			}
		}
	}

	private void savePropertyToElastic(ThmPropertyDto dto) {
		try {
			//PropertySearchDocument document = mapDtoToDocument(dto);
//			IndexQuery query = new IndexQuery();
//			query.setId(String.valueOf(document.getId()));
//			query.setObject(document);
//
//			elasticsearchRestTemplate.index(query, IndexCoordinates.of("propertysearchdocument"));
			 PropertySearchDocument document = mapDtoToDocument(dto);

		        IndexQuery query = new IndexQueryBuilder()
		                .withId(String.valueOf(document.getId())) // ensure same id → update if exists
		                .withObject(document)
		                .build();

		        // index into propertysearchdocument index
		        elasticsearchRestTemplate.index(query, IndexCoordinates.of("propertysearchdocument"));

			log.info("Indexed propertyId {} ({}) to Elasticsearch ", dto.getId(), dto.getSource());
		} catch (Exception e) {
			log.error("Failed to index propertyId {} to Elasticsearch: {}", dto.getId(), e.getMessage(), e);
		}
	}

	private PropertySearchDocument mapDtoToDocument(ThmPropertyDto dto) {
		PropertySearchDocument doc = new PropertySearchDocument();
		BeanUtils.copyProperties(dto, doc);
		return doc;
	}

	public ThmPropertyDto mapStaticPropertyResponseDtoToThmPropertyDto(StaticPropertyResponseDto responseDto) {
		if (responseDto == null) {
			return null;
		}

		ThmPropertyDto dto = new ThmPropertyDto();

		dto.setId(responseDto.getId());
		dto.setName(responseDto.getName());
		dto.setShortName(generateShortName(dto.getName()));
		if (responseDto.getContact() != null) {
			dto.setEmail(responseDto.getContact().getEmail());
			dto.setMobile(responseDto.getContact().getPhone());
			dto.setWebsite(responseDto.getContact().getWebsite());
		}
		// dto.setSlogan(responseDto.getSlogan());
		// dto.setWhatsApp(responseDto.getWhatsApp());
		// dto.setManagerFirstName(responseDto.getManagerFirstName());
		// dto.setManagerLastName(responseDto.getManagerLastName());
		dto.setManagerContactNo(responseDto.getContact().getPhone());
		dto.setManagerEmailAddress(responseDto.getContact().getEmail());
		// dto.setPropertyStatus(PropertyStatus.valueOf(responseDto.getStatus()));
		dto.setGstNumber(responseDto.getTaxId());
		// dto.setUdyamRegistrationNumber(responseDto.getUdyamRegistrationNumber());
		Integer maxOccupancy = responseDto.getRooms().get(0).getSettings().getMaxOccupancy();
		dto.setMaximumOccupancy(maxOccupancy);
		Integer minOccupancy = responseDto.getRooms().get(0).getSettings().getBaseAdults();
		dto.setMinimumOccupancy(minOccupancy);
		dto.setLogoUrl(responseDto.getLogo());
		if (responseDto.getBaseSettings() != null) {
			dto.setLocalCurrency(responseDto.getBaseSettings().getCurrency());
		}
//	        dto.setPlaceId(responseDto.getPlaceId());
//	        dto.setPaymentGateway(responseDto.getPaymentGateway());
//	        dto.setPaymentGatewayApiKey(responseDto.getPaymentGatewayApiKey());
//	        dto.setPaymentGatewayPublicKey(responseDto.getPaymentGatewayPublicKey());
//	        dto.setPaymentGatewayCallbackUrl(responseDto.getPaymentGatewayCallbackUrl());
		dto.setOrganisationId(1L);
		if (responseDto.getCoordinates() != null) {
			dto.setLongitude(String.valueOf(responseDto.getCoordinates().getLongitude()));
			dto.setLatitude(String.valueOf(responseDto.getCoordinates().getLatitude()));
		}
		// System.out.println("responseDto.getBaseSettings().getHotelType().getName()
		// :"+ responseDto.getBaseSettings().getHotelType().getName());
		dto.setBusinessType("hotel");
		if (responseDto.getDescriptions() != null && !responseDto.getDescriptions().isEmpty()) {
			dto.setBusinessDescription(responseDto.getDescriptions().get(0).getDescription());
		}
		// dto.setPlan(responseDto.getPlan());
		dto.setVerified(false); // Default value

		dto.setSeoFriendlyName(toSeoFriendlyName(responseDto.getName()));

		// Address
		if (responseDto.getLocation() != null) {
			Address address = new Address();
			address.setCountry(responseDto.getLocation().getCountryCode());
			address.setPostcode(responseDto.getLocation().getPostcode());
			address.setStreetNumber("");
			address.setStreetName(responseDto.getLocation().getAddress());
			address.setSuburb("");
			if (responseDto.getLocation().getCity() != null) {
				address.setCity(responseDto.getLocation().getCity().getName());
			}
			address.setState(responseDto.getLocation().getRegion());
			address.setLocality(responseDto.getLocation().getAddress());
			address.setAddressLine1(responseDto.getLocation().getAddress());
			address.setAddressLine2(null);
			dto.setAddress(address);
		}

		// Bank Account
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankName("");
		bankAccount.setBranchName("");
		bankAccount.setAccountName("");
		bankAccount.setAccountNumber("");
		bankAccount.setSwiftCode("");
		dto.setBankAccount(bankAccount);

		// Image List
		if (responseDto.getImages() != null) {
			List<Image> imageList = new ArrayList<>();
			for (StaticPropertyResponseDto.Image image : responseDto.getImages()) {
				Image img = new Image();
				img.setId(String.valueOf(image.getId()));
				img.setName(image.getType());
				img.setUrl(image.getUri());
				img.setDescription(image.getDescription());
				img.setMainImage(false);
				imageList.add(img);
			}
			dto.setImageList(imageList);
		}

		// Static Tax Details (Always apply GST slab for India - Odisha)
		List<TaxDetails> taxDetails = new ArrayList<>();

		TaxDetails gstDetail = new TaxDetails();
		gstDetail.setName("GST");
		gstDetail.setPercentage(12.0);
		gstDetail.setCountry("India");
		gstDetail.setState("Odisha");
		gstDetail.setTaxableAmount(BigDecimal.valueOf(2700));
		gstDetail.setTaxAmount(BigDecimal.valueOf(324));

		// Tax slabs
		List<TaxSlabs> taxSlabsList = new ArrayList<>();

		TaxSlabs slab1 = new TaxSlabs();
		slab1.setMinAmount(BigDecimal.valueOf(1));
		slab1.setMaxAmount(BigDecimal.valueOf(1000));
		slab1.setPercentage(12.0);

		TaxSlabs slab2 = new TaxSlabs();
		slab2.setMinAmount(BigDecimal.valueOf(1001));
		slab2.setMaxAmount(BigDecimal.valueOf(7500));
		slab2.setPercentage(12.0);

		TaxSlabs slab3 = new TaxSlabs();
		slab3.setMinAmount(BigDecimal.valueOf(7501));
		slab3.setMaxAmount(BigDecimal.valueOf(1000000));
		slab3.setPercentage(18.0);

		taxSlabsList.add(slab1);
		taxSlabsList.add(slab2);
		taxSlabsList.add(slab3);

		gstDetail.setTaxSlabsList(taxSlabsList);

		taxDetails.add(gstDetail);
		dto.setTaxDetails(taxDetails);
		log.info("Policies in Hyperguest response: {}", responseDto.getPolicies());
		// --- Policies mapping (HyperGuest → RulesDto) ---
		if (responseDto.getPolicies() != null && !responseDto.getPolicies().isEmpty()) {
		    RulesDto rulesDto = new RulesDto();
		    List<RulesDto.Policy> policyList = new ArrayList<>();

		    for (StaticPropertyResponseDto.Policy policy : responseDto.getPolicies()) {
		        RulesDto.Policy mappedPolicy = new RulesDto.Policy();

		        // Basic fields
		        mappedPolicy.setType(policy.getType());
		        mappedPolicy.setName(policy.getName());
		        mappedPolicy.setId((long) policy.getId());
		        // Condition (empty placeholder for now)
		     // Condition mapping
		     // Condition mapping
		        if (policy.getCondition() != null) {
		            RulesDto.Condition condition = new RulesDto.Condition();

		            if (policy.getCondition() instanceof Map) {
		                condition.setData((Map<String, Object>) policy.getCondition());
		            } else {
		                // fallback: wrap raw object
		                Map<String, Object> temp = new HashMap<>();
		                temp.put("value", policy.getCondition());
		                condition.setData(temp);
		            }

		            mappedPolicy.setCondition(condition);
		        }



		        // Dates mapping
		        if (policy.getDates() != null) {
		            RulesDto.Dates dates = new RulesDto.Dates();
		            if (policy.getDates().getStart() != null) {
		                dates.setStart(policy.getDates().getStart().toString());
		            }
		            if (policy.getDates().getEnd() != null) {
		                dates.setEnd(policy.getDates().getEnd().toString());
		            }
		            mappedPolicy.setDates(dates);
		        }

		        // ExtraData mapping
		        if (policy.getExtraData() instanceof Map) {
		            Map<String, Object> extraDataMap = (Map<String, Object>) policy.getExtraData();
		            RulesDto.ExtraData extraData = new RulesDto.ExtraData();
		            Object deadlineHour = extraDataMap.get("cancellationDeadlineHour");
		            if (deadlineHour != null) {
		                extraData.setCancellationDeadlineHour(deadlineHour.toString());
		            }
		            mappedPolicy.setExtraData(extraData);
		        }

		        // Result mapping (can be string, list, or structured object)
		        mappedPolicy.setResult(policy.getResult());

		        // Conflict mapping
		        mappedPolicy.setConflict(policy.getConflict());

		        policyList.add(mappedPolicy);
		    }

		    rulesDto.setPolicies(policyList);
		    dto.setPolicies(rulesDto);

		    // Debug logging with new toString
		    log.debug("Mapped Policies: {}", rulesDto);
		}



		// Hotel Services (Facilities)
		if (responseDto.getFacilities() != null) {
			List<PropertyServices> hotelServices = new ArrayList<>();
			for (StaticPropertyResponseDto.Facility facility : responseDto.getFacilities()) {
				PropertyServices hotelService = new PropertyServices();
				hotelService.setId((Long.valueOf(facility.getId())));
				hotelService.setOrganisationId(1L);
				hotelService.setName(facility.getName());
				hotelService.setDescription(" ");
				hotelService.setLogoUrl("");
				hotelService.setImageUrl("");
				hotelService.setBusinessType(facility.getType());
				hotelService.setServiceType(facility.getCategorySlug());
				hotelService.setAfterTaxAmount(null);
				hotelService.setBeforeTaxAmount(null);
				hotelService.setTaxAmount(null);
				hotelService.setTaxPercentage(null);
				hotelService.setServicePrice(null);
				hotelService.setApplicableToChild(false);
				hotelService.setApplicableToAdult(false);
				hotelServices.add(hotelService);
			}
			dto.setPropertyServicesList(hotelServices);
		}
		dto.setNearbyAttractions(null);
		dto.setPropertyInvoicePrintHeader(true);
		dto.setFeaturedBusiness(false);
		if (responseDto.getRooms() != null) {
			List<RoomDto> roomList = new ArrayList<>();
			for (StaticPropertyResponseDto.Room room : responseDto.getRooms()) {
				RoomDto thmRoomDto = new RoomDto();
				thmRoomDto.setId(room.getId());
				thmRoomDto.setName(room.getName());
				thmRoomDto.setDescription(room.getDescriptions() != null && !room.getDescriptions().isEmpty()
						? room.getDescriptions().get(0).getDescription()
						: null);
				thmRoomDto.setPropertyId(room.getHotelId());
				// thmRoomDto.setRoomOnlyPrice();
				// thmRoomDto.setTotalPriceServices();
				// thmRoomDto.setTotalPriceAmenities();
				// thmRoomDto.setTotalPriceRoom();
				// thmRoomDto.setPricePerNight();
				// thmRoomDto.setPricePerWeek();
				// thmRoomDto.setPriceFortNight();
				// thmRoomDto.setPriceMonthly();
				thmRoomDto.setMinimumOccupancy(room.getSettings().getBaseAdults());
				thmRoomDto.setMaximumOccupancy(room.getSettings().getMaxOccupancy());

				// thmRoomDto.setExtraChargePerPerson();
				// thmRoomDto.setNoOfRooms();
				// thmRoomDto.setRoomDetails();

				if (room.getImages() != null) {
					List<Image> roomImages = new ArrayList<>();
					for (StaticPropertyResponseDto.Image image : room.getImages()) {
						Image img = new Image();
						// img.setId(String.valueOf(image.getId()));
						img.setName(image.getType());
						img.setUrl(image.getUri());
						img.setDescription(image.getDescription());
						img.setMainImage(false);
						roomImages.add(img);
					}
					thmRoomDto.setImageList(roomImages);
				}
				thmRoomDto.setMinimumLengthOfStay(0);
				thmRoomDto.setMaximumLengthOfStay(0);
				thmRoomDto.setSize(Double.valueOf(room.getSettings().getNumberOfBedrooms()));
				// thmRoomDto.setSmoking();
				// thmRoomDto.setHsnCode();
				thmRoomDto.setRanking(0);
				// thmRoomDto.setRoomFacilities();
				thmRoomDto.setDayTrip(false); // Default value
				// thmRoomDto.setRatesAndAvailabilityDtos();
				thmRoomDto.setShared(false);
				roomList.add(thmRoomDto);
			}
			dto.setRoomList(roomList);
		}

		return dto;
	}

	public String toSeoFriendlyName(String name) {
		return name == null ? null : name.trim().replace(" ", "-");
	}

	public String generateShortName(String name) {
		String[] words = name.trim().split("\\s+");
		StringBuilder shortName = new StringBuilder();

		for (String word : words) {
			word = word.replaceAll("[^a-zA-Z]", "");
			if (!word.isEmpty()) {
				shortName.append(Character.toUpperCase(word.charAt(0)));
			}
		}

		return shortName.toString();
	}

	/*
	 * 
	 * //List<HotelStaticDataDto> hotelStaticDataList =
	 * hotelStaticDataService.findByCountry(customerNationality, page, // size); //
	 * List<HotelStaticDataDto> hotelStaticDataList=new ArrayList<>();
	 * //List<String> hotelIdList = new ArrayList<>(); /*
	 * 
	 * for (HotelStaticDataDto hotelStaticDataDto : hotelStaticDataList) {
	 * hotelIdList.add(String.valueOf(hotelStaticDataDto.getHotelId())); }
	 */
	/*
	 * if (customerNationality != null && !customerNationality.isEmpty()) {
	 * hotelStaticDataList =
	 * hotelStaticDataService.findByCountry(customerNationality, page, size); for
	 * (HotelStaticDataDto hotelStaticDataDto : hotelStaticDataList) {
	 * hotelIdList.add(String.valueOf(hotelStaticDataDto.getHotelId())); } }
	 */
	@Override
	public void fetchAllCitiesAndSaveToElasticsearch() {
	    // 1. Fetch from hotel static data (HyperGuest)
	    List<HotelStaticData> hotels = hotelStaticDataRepo.findAll();

	    for (HotelStaticData hotel : hotels) {
	        Long hotelId = hotel.getHotelId();
	        try {
	            String url = "https://hg-static.hyperguest.com/" + hotelId + "/property-static.json";

	            HttpHeaders headers = new HttpHeaders();
	            headers.set("Content-Type", "application/json");
	            headers.set("Authorization", "Bearer 5fa9f6b4ef284c49935baf3e3dd0b11a");

	            HttpEntity<String> entity = new HttpEntity<>(headers);

	            ResponseEntity<JsonNode> response = restTemplate.exchange(
	                url,
	                HttpMethod.GET,
	                entity,
	                JsonNode.class
	            );

	            if (response.getBody() != null && response.getBody().has("location")) {
	                JsonNode location = response.getBody().get("location");
	                String name = location.path("city").path("name").asText();
	                String address = location.path("address").asText();

	                String country = address.substring(address.lastIndexOf(",") + 1); // no trim()
	                String city = name + "," + country;

	                HotelLocation hotelLocation = new HotelLocation();
	                hotelLocation.setCity(city);

	                hotelLocationRepository.save(hotelLocation); // Save to Elasticsearch
	            }
	        } catch (Exception ex) {
	            System.err.println("Error for hotelId " + hotelId + ": " + ex.getMessage());
	        }
	    }

	    // 2. Fetch direct cities from THM API
	    try {
	        String thmUrl = "https://api.thehotelmate.co/api/thm/allCities?businessType=Accommodation";
	        ResponseEntity<List<String>> response = restTemplate.exchange(
	            thmUrl,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<String>>() {}
	        );

	        List<String> cities = response.getBody();

	        if (cities != null) {
	            for (String cityName : cities) {
	                HotelLocation location = new HotelLocation();
	                location.setCity(cityName); // No trimming, store as-is

	                hotelLocationRepository.save(location); // Save to Elasticsearch
	            }
	        }
	    } catch (Exception ex) {
	        System.err.println("Error fetching cities from THM API: " + ex.getMessage());
	    }
	}
	
	@Override
	public void saveCitiesToNewIndex() {
	    List<CityLocation> cityLocations = new ArrayList<>();

	    // Fetch cities from THM API
	    try {
	        String thmUrl = "https://api.thehotelmate.co/api/thm/allCities?businessType=Accommodation";
	        ResponseEntity<List<String>> response = restTemplate.exchange(
	            thmUrl,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<String>>() {}
	        );

	        List<String> cities = response.getBody();
	        if (cities != null) {
	            int counter = 0;
	            for (String cityName : cities) {
	                if (cityName != null && !cityName.trim().isEmpty()) {
	                    CityLocation location = new CityLocation();
	                    location.setCity(cityName.trim());
	                    cityLocations.add(location);
	                    counter++;
	                    
	                    // Log progress every 1000 cities
	                    if (counter % 1000 == 0) {
	                        log.info(counter + " cities fetched from THM API so far.");
	                    }
	                }
	            }
	        }
	        log.info("Total " + cityLocations.size() + " cities fetched from THM API.");
	    } catch (Exception ex) {
	        log.error("Error fetching cities from THM API: " + ex.getMessage(), ex);
	    }

	    // Save to Elasticsearch
	    if (!cityLocations.isEmpty()) {
	        cityLocationRepository.saveAll(cityLocations);
	        log.info("Saved " + cityLocations.size() + " cities to city-location index.");
	    } else {
	        log.warn("No cities to save to city-location index.");
	    }
	}

private static final String SOURCE_INDEX = "propertysearchdocument";

@Override
public void savePropertyNamesToNewIndex() throws Exception {
    final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(5L));
    SearchRequest searchRequest = new SearchRequest(SOURCE_INDEX);
    searchRequest.scroll(scroll);

    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    sourceBuilder.size(500);
    sourceBuilder.fetchSource(new String[]{"name"}, null);
    searchRequest.source(sourceBuilder);

    Set<String> savedNames = new HashSet<>();
    int totalProcessed = 0;

    SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    String scrollId = searchResponse.getScrollId();
    SearchHit[] searchHits = searchResponse.getHits().getHits();

    while (searchHits != null && searchHits.length > 0) {

        List<PropertyName> batchToSave = new ArrayList<>();

        for (SearchHit hit : searchHits) {
            String name = (String) hit.getSourceAsMap().get("name");
            if (name != null && savedNames.add(name)) { // add returns false if already exists
                PropertyName p = new PropertyName();
                p.setName(name);
                batchToSave.add(p);
            }
        }

        // save in batch
        if (!batchToSave.isEmpty()) {
            propertyNameRepository.saveAll(batchToSave);
        }

        totalProcessed += searchHits.length;
        System.out.println("Processed " + totalProcessed + " properties so far...");

        // get next scroll
        SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
        scrollRequest.scroll(scroll);
        searchResponse = restHighLevelClient.scroll(scrollRequest, RequestOptions.DEFAULT);
        scrollId = searchResponse.getScrollId();
        searchHits = searchResponse.getHits().getHits();
    }

    if (scrollId != null) {
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
        clearScrollRequest.addScrollId(scrollId);
        restHighLevelClient.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
    }

    System.out.println("All properties processed: " + totalProcessed);
}


}
