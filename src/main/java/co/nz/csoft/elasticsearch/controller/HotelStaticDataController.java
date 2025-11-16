package co.nz.csoft.elasticsearch.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.elasticsearch.index.query.QueryBuilders;
import co.nz.csoft.elasticsearch.dto.HotelStaticDataDto;
import co.nz.csoft.elasticsearch.dto.PaginatedResponse;
import co.nz.csoft.elasticsearch.model.CityLocation;
import co.nz.csoft.elasticsearch.model.HotelLocation;
import co.nz.csoft.elasticsearch.model.HotelSearchDocument;
import co.nz.csoft.elasticsearch.model.HotelStaticData;
import co.nz.csoft.elasticsearch.model.PropertyName;
import co.nz.csoft.elasticsearch.model.PropertySearchDocument;
import co.nz.csoft.elasticsearch.repository.HotelSearchRepository;
import co.nz.csoft.elasticsearch.repository.HotelStaticDataRepo;
import co.nz.csoft.elasticsearch.service.HotelStaticDataService;
import co.nz.csoft.elasticsearch.thm.dto.ThmPropertyDto;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.apache.http.util.EntityUtils;
import org.apache.lucene.search.spell.LevenshteinDistance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;


@RestController
@RequestMapping(value="/api")
public class HotelStaticDataController {
    @Autowired
	private HotelStaticDataService hotelStaticDataService;
    @Autowired
    private HotelSearchRepository hotelSearchRepository;
    
    @Autowired
    private HotelStaticDataRepo hotelStaticDataRepo;
    

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;
    
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Scheduled(cron = "${scheduler.statichotel.cron}", zone = "Asia/Kolkata")
    public void scheduledFetchAndStoreHotelData() {
        hotelStaticDataService.fetchHotelStaticData();
        System.out.println("Scheduled job: Hotel static data fetched and saved at 17:23 IST");
    }
    
    @PostMapping("/hotelStaticData/crete")
    public ResponseEntity<HotelStaticDataDto> createHotelStaticData(@RequestBody HotelStaticDataDto hotelStaticDataDto){
    	hotelStaticDataDto=this.hotelStaticDataService.createHotelStaticData(hotelStaticDataDto);
    	return new ResponseEntity<HotelStaticDataDto>(hotelStaticDataDto,HttpStatus.CREATED);
    }
    
    
    @PostMapping("/ListOfhotelStaticData/create")
    public ResponseEntity<List<HotelStaticDataDto>> createListOfHotelStaticData(@RequestBody List<HotelStaticDataDto> hotelStaticDataDtos) {
        List<HotelStaticDataDto> savedHotelStaticDataDtos = hotelStaticDataService.createListOfHotelStaticData(hotelStaticDataDtos);
        return new ResponseEntity<>(savedHotelStaticDataDtos, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/findByHotelId/{hotelId}", method = RequestMethod.GET)
	  public ResponseEntity<List<HotelStaticDataDto>> findHotelByHotelId(@PathVariable Long hotelId){
		  List<HotelStaticDataDto> hotelStaticDataDtoList = hotelStaticDataService.getAllByHotelId(hotelId);		  
		  return new ResponseEntity<>(hotelStaticDataDtoList, HttpStatus.OK);
	  }
    
    @RequestMapping(value = "/findBycity/{city}", method = RequestMethod.GET)
	public ResponseEntity<List<HotelStaticDataDto>> findByStatus(@PathVariable String city) {
		List<HotelStaticDataDto> hotelStaticDataDtoList = hotelStaticDataService.findByCity(city);
		return new ResponseEntity<>(hotelStaticDataDtoList, HttpStatus.OK);
	}
    
    @GetMapping("/findBycountry/{country}")
    public ResponseEntity<List<HotelStaticDataDto>> findByCountry(
            @PathVariable String country,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        List<HotelStaticDataDto> hotelStaticDataDto = hotelStaticDataService.findByCountry(country, page, size);
        return new ResponseEntity<>(hotelStaticDataDto, HttpStatus.OK);
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<HotelStaticData>> getAllHotelStaticData() {
        List<HotelStaticData> allData = hotelStaticDataRepo.findAll();
        return ResponseEntity.ok(allData);
    }
/*
    @GetMapping("/hyperguest/properties")
    public ResponseEntity<List<ThmPropertyDto>> getPropertiesFromHyperGuest(
            @RequestParam String checkIn,
            @RequestParam int nights,
            @RequestParam int guests,
            @RequestParam(required = false) String hotelIds,
            @RequestParam(required = false) String customerNationality,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

    	List<ThmPropertyDto> searchData =hotelStaticDataService.fetchPropertyFromHyperguest(checkIn, nights, guests, hotelIds, customerNationality, page, size);

        return ResponseEntity.ok(searchData); 
    }*/

    @GetMapping("/searchStaticHotels")
    public List<HotelSearchDocument> searchHotels(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long cityId,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) Long hotelId,
            @RequestParam(required = false) Long lastUpdated,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        if (city != null) {
            boolQuery.must(QueryBuilders.termQuery("city.keyword", city));
        }
        if (name != null) {
            boolQuery.must(QueryBuilders.termQuery("name.keyword", name));
        }
        if (cityId != null) {
            boolQuery.must(QueryBuilders.termQuery("cityId", cityId));
        }
        if (country != null) {
            boolQuery.must(QueryBuilders.termQuery("country.keyword", country));
        }
        if (region != null) {
            boolQuery.must(QueryBuilders.termQuery("region.keyword", region));
        }
        if (hotelId != null) {
            boolQuery.must(QueryBuilders.termQuery("hotelId", hotelId));
        }
        if (lastUpdated != null) {
            boolQuery.must(QueryBuilders.termQuery("lastUpdated", lastUpdated));
        }


        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQuery).withPageable(PageRequest.of(page, size))
                .build();

        SearchHits<HotelSearchDocument> hits = elasticsearchOperations.search(searchQuery, HotelSearchDocument.class);

        return hits.getSearchHits().stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }
    

//search thm and hyperguest static property from elastic search by city and propertyId
    @GetMapping("/searchStaticProperties")
    public PaginatedResponse searchPropertiesRaw(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Long propertyId,
            @RequestParam(required = false) String source,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String businessSubtype,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws IOException {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        if (city != null) {
            boolQuery.must(QueryBuilders.matchQuery("address.city", city));
        }
        if (propertyId != null) {
            boolQuery.must(QueryBuilders.termQuery("id", propertyId));
        }
        if (source != null) {
            boolQuery.must(QueryBuilders.termQuery("source", source));
        }
        if(name != null) {
            boolQuery.must(QueryBuilders.termQuery("name.keyword", name)); // exact match
        }
        if (businessSubtype != null && !businessSubtype.isEmpty()) {
            
            boolQuery.must(QueryBuilders.termQuery("businessSubtype.keyword", businessSubtype));
        }
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder()
                .query(boolQuery)
                .from(page * size)
                .size(size);

        SearchRequest searchRequest = new SearchRequest("propertysearchdocument");
        searchRequest.source(sourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<Map<String, Object>> results = new ArrayList<>();
        for (org.elasticsearch.search.SearchHit hit : response.getHits().getHits()) {
            results.add(hit.getSourceAsMap());
        }

        long totalElements = response.getHits().getTotalHits().value;
        long totalPages = (long) Math.ceil((double) totalElements / size);

        return new PaginatedResponse(results, totalElements, page, size, totalPages);
    }
    /*
    @GetMapping("/searchStaticProperties")
    public PaginatedResponse searchPropertiesRaw(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Long propertyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws IOException {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        if (city != null) {
            boolQuery.must(QueryBuilders.matchQuery("address.city", city));
        }
        if (propertyId != null) {
            boolQuery.must(QueryBuilders.termQuery("id", propertyId));
        }

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder()
                .query(boolQuery)
                .from(page * size)
                .size(size);

        SearchRequest searchRequest = new SearchRequest("propertysearchdocument");
        searchRequest.source(sourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<Map<String, Object>> results = new ArrayList<>();
        for (org.elasticsearch.search.SearchHit hit : response.getHits().getHits()) {
            results.add(hit.getSourceAsMap());
        }

        long totalElements = response.getHits().getTotalHits().value;
        long totalPages = (long) Math.ceil((double) totalElements / size);

        return new PaginatedResponse(results, totalElements, page, size, totalPages);
    }

*/

    @GetMapping("/searchBySeoName")
    public List<Map<String, Object>> searchBySeoFriendlyName(
            @RequestParam String seoFriendlyName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws IOException {

        // Use .keyword for exact match if the field is text with keyword subfield
        QueryBuilder query = QueryBuilders.termQuery("seoFriendlyName.keyword", seoFriendlyName);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder()
                .query(query)
                .from(page * size)
                .size(size);

        SearchRequest searchRequest = new SearchRequest("propertysearchdocument");
        searchRequest.source(sourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<Map<String, Object>> results = new ArrayList<>();
        for (org.elasticsearch.search.SearchHit hit : response.getHits().getHits()) {  
            results.add(hit.getSourceAsMap());
        }
        if (results.isEmpty()) {
            Map<String, Object> message = new HashMap<>();
            message.put("message", "seoFriendlyName not matching");
            results.add(message);
        }
        return results;
    }



    //save thm and hyperguest property to elasticsearch as thmpropertydto
    @Scheduled(cron = "${scheduler.property.cron}", zone = "Asia/Kolkata")
    public void syncHotelDataJob() {
        try {
            List<ThmPropertyDto> hotelDataList = hotelStaticDataService.fetchAndMapAllHotelData();
            if (hotelDataList.isEmpty()) {
                System.out.println("No hotel data found during scheduled sync.");
            } else {
                System.out.println("Hotel data sync complete. Records: " + hotelDataList.size());
            }
        } catch (Exception e) {
            System.err.println("Scheduled sync failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //check realtime availability for thm and hyperguest property
    @GetMapping("/allPropertyCheckAvailability")
    public ResponseEntity<?> checkAvailability(
            @RequestParam String source,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate,
            @RequestParam Integer noOfRooms,
            @RequestParam Integer noOfPersons,
            @RequestParam(required = false) Integer noOfChildren,
            @RequestParam Long hotelIds) {

        try {
            // ✅ Normalize today's date (strip time part)
            LocalDate today = LocalDate.now();
            LocalDate checkInDate = fromDate.toInstant()
                                            .atZone(ZoneId.systemDefault())
                                            .toLocalDate();

            if (checkInDate.isBefore(today)) {
                return ResponseEntity.badRequest().body("Check-in date cannot be before today");
            }

            ThmPropertyDto property = hotelStaticDataService.checkAvailability(
                    source, fromDate, toDate, noOfRooms, noOfPersons, noOfChildren, hotelIds);

            return property != null ? ResponseEntity.ok(property) : ResponseEntity.notFound().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid request: " + e.getMessage());
        }
    }

    
    @GetMapping("/indices")
    public ResponseEntity<String> getAllIndices() throws IOException {
        Request request = new Request("GET", "/_cat/indices?v");
        Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
        String responseBody = EntityUtils.toString(response.getEntity());
        return ResponseEntity.ok(responseBody);
    }
    @GetMapping("/property-documents")
    public ResponseEntity<String> getPropertyDocuments(@RequestParam(defaultValue = "100") int size) throws IOException {
        String endpoint = String.format("/propertysearchdocument/_search?pretty&size=%d", size);
        Request request = new Request("GET", endpoint);
        Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
        String responseBody = EntityUtils.toString(response.getEntity());
        return ResponseEntity.ok(responseBody);
    }
    
    /*
    @GetMapping("/staticProperty")
    public ResponseEntity<List<ThmPropertyDto>> syncHotelData() {
        List<ThmPropertyDto> hotelDataList = hotelStaticDataService.fetchAndMapAllHotelData();
        if (hotelDataList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(hotelDataList);
    }
    
    
    @PostMapping("/fetch")
    public ResponseEntity<String> fetchAndStoreHotelData() {
        hotelStaticDataService.fetchHotelStaticData();
        return ResponseEntity.ok("Hotel static data fetched and saved successfully.");
    }
   */
    //save all city of thm and hyperguest property
    @Scheduled(cron = "0 38 19 * * ?", zone = "Asia/Kolkata")
    public void fetchAndSaveCitiesScheduled() {
        try {
            hotelStaticDataService.fetchAllCitiesAndSaveToElasticsearch();
            System.out.println("Scheduled: Successfully fetched and saved cities to Elasticsearch.");
        } catch (Exception e) {
            System.err.println("Scheduled: Failed to fetch and save cities: " + e.getMessage());
        }
    }
    //search cities
    @GetMapping("/getAllcities")
    public List<String> getCities() {

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
            .withSourceFilter(new FetchSourceFilter(new String[]{"city"}, null))
            .build();

        SearchHits<HotelLocation> hits = elasticsearchOperations.search(searchQuery, HotelLocation.class);

        // extract city from each hit's source
        return hits.getSearchHits().stream()
                .map(hit -> hit.getContent().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping("/searchPropertiesByAverage")
    public PaginatedResponse searchPropertiesByAverage(
            @RequestParam(required = false) String source,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) throws IOException {

        // 1️⃣ Build query (only filter by source if provided)
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (source != null) {
            boolQuery.must(QueryBuilders.termQuery("source", source));
        }

        // 2️⃣ Fetch all properties so we can compute averages
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder()
                .query(boolQuery)
                .from(0)       // fetch all for sorting
                .size(5000);   // adjust if you expect more properties

        SearchRequest searchRequest = new SearchRequest("propertysearchdocument");
        searchRequest.source(sourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<Map<String, Object>> results = new ArrayList<>();

        // 3️⃣ Compute average roomOnlyPrice for each property
        for (org.elasticsearch.search.SearchHit hit : response.getHits().getHits()) {
            Map<String, Object> prop = hit.getSourceAsMap();
            List<Map<String, Object>> roomList =
                    (List<Map<String, Object>>) prop.get("roomList");

            double total = 0.0;
            int count = 0;
            if (roomList != null) {
                for (Map<String, Object> room : roomList) {
                    Object priceObj = room.get("roomOnlyPrice");
                    if (priceObj != null) {
                        try {
                            total += Double.parseDouble(priceObj.toString());
                            count++;
                        } catch (NumberFormatException ignored) {}
                    }
                }
            }

            double average = (count > 0) ? total / count : 0.0;
            prop.put("calculatedAveragePrice", Double.valueOf(average));
            results.add(prop);
        }

        // 4️⃣ Sort by average price DESC (highest → lowest)
        results.sort(Comparator.comparingDouble((Map<String, Object> p) -> {
            Object val = p.get("calculatedAveragePrice");
            if (val instanceof Number) return ((Number) val).doubleValue();
            if (val != null) {
                try { return Double.parseDouble(val.toString()); }
                catch (NumberFormatException ignored) {}
            }
            return 0.0;
        }).reversed());

        // 5️⃣ Paginate the sorted results
        int start = Math.min(page * size, results.size());
        int end   = Math.min(start + size, results.size());
        List<Map<String, Object>> paginated = results.subList(start, end);

        long totalElements = results.size();
        long totalPages    = (long) Math.ceil((double) totalElements / size);

        return new PaginatedResponse(paginated, totalElements, page, size, totalPages);
    }

    @Scheduled(cron = "0 39 21 * * ?", zone = "Asia/Kolkata")
    public ResponseEntity<String> saveCitiesToNewIndex() {
        try {
        	hotelStaticDataService.saveCitiesToNewIndex();
            return ResponseEntity.ok("Successfully saved cities to new index (city-location).");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save cities: " + e.getMessage());
        }
    }
    
    @GetMapping("/getplace")
    public List<String> getAllCities() {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withSourceFilter(new FetchSourceFilter(new String[]{"city"}, null))
                .build();

        SearchHits<CityLocation> hits = elasticsearchOperations.search(searchQuery, CityLocation.class);

        // Map to keep track of city names (case-insensitive) and original full entries
        Map<String, String> cityMap = new LinkedHashMap<>();

        for (SearchHit<CityLocation> hit : hits.getSearchHits()) {
            String cityStr = hit.getContent().getCity();
            if (cityStr == null || cityStr.trim().isEmpty()) continue;

            String[] parts = cityStr.split(",");

            // Remove duplicates inside the city string
            LinkedHashSet<String> cleanedParts = new LinkedHashSet<>();
            for (String part : parts) {
                String trimmed = part.trim();
                if (!trimmed.equalsIgnoreCase("null") && !trimmed.isEmpty()) {
                    cleanedParts.add(trimmed);
                }
            }

            if (cleanedParts.isEmpty()) continue;

            // Take first part as key for uniqueness (case-insensitive)
            String mainCity = cleanedParts.iterator().next().toLowerCase();
            cityMap.putIfAbsent(mainCity, String.join(",", cleanedParts));
        }

        return new ArrayList<>(cityMap.values());
    }
    
    @PostMapping("/save-property-names")
    public ResponseEntity<String> savePropertyNamesScroll() {
        try {
        	hotelStaticDataService.savePropertyNamesToNewIndex();
            return ResponseEntity.ok("Property names saved successfully via Scroll API!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed: " + e.getMessage());
        }
    }
    
    @GetMapping("/getAllPropertyNames")
    public List<String> getAllPropertyNames() {

        List<String> allNames = new ArrayList<>();
        Set<String> nameSet = new HashSet<>(); // avoid duplicates

        final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));

        SearchRequest searchRequest = new SearchRequest("property-names");
        searchRequest.scroll(scroll);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.size(1000); // batch size
        sourceBuilder.fetchSource(new String[]{"name"}, null); // only "name"
        searchRequest.source(sourceBuilder);

        try {
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            String scrollId = searchResponse.getScrollId();
            org.elasticsearch.search.SearchHit[] searchHits = searchResponse.getHits().getHits();

            while (searchHits != null && searchHits.length > 0) {
                for (org.elasticsearch.search.SearchHit hit : searchHits) {
                    String name = (String) hit.getSourceAsMap().get("name");
                    if (name != null && !nameSet.contains(name)) {
                        allNames.add(name);
                        nameSet.add(name);
                    }
                }

                // scroll to next batch
                SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
                scrollRequest.scroll(scroll);
                searchResponse = restHighLevelClient.scroll(scrollRequest, RequestOptions.DEFAULT);
                scrollId = searchResponse.getScrollId();
                searchHits = searchResponse.getHits().getHits();
            }

            // clear scroll
            ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
            clearScrollRequest.addScrollId(scrollId);
            restHighLevelClient.clearScroll(clearScrollRequest, RequestOptions.DEFAULT);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return allNames;
    }

  }
