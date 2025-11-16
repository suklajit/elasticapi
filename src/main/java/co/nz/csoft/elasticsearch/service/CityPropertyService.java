package co.nz.csoft.elasticsearch.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.elasticsearch.action.search.ClearScrollRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.nz.csoft.elasticsearch.model.CityProperty;
import co.nz.csoft.elasticsearch.repository.CityPropertyRepository;

@Service
public class CityPropertyService {

    private static final String SOURCE_INDEX = "propertysearchdocument";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private CityPropertyRepository cityPropertyRepository;

    public void createCityPropertyIndex() throws Exception {
        final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(5L));
        SearchRequest searchRequest = new SearchRequest(SOURCE_INDEX);
        searchRequest.scroll(scroll);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.size(1000); // batch size
        sourceBuilder.fetchSource(new String[]{"name", "address"}, null);
        searchRequest.source(sourceBuilder);

        Set<String> savedProperties = new HashSet<>();
        int totalProcessed = 0;

        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        String scrollId = searchResponse.getScrollId();
        SearchHit[] searchHits = searchResponse.getHits().getHits();

        while (searchHits != null && searchHits.length > 0) {

            List<CityProperty> batchToSave = new ArrayList<>();

            for (SearchHit hit : searchHits) {
                @SuppressWarnings("unchecked")
                Map<String, Object> sourceMap = hit.getSourceAsMap();
                String name = (String) sourceMap.get("name");
                Map<String, Object> address = (Map<String, Object>) sourceMap.get("address");
                String city = (address != null) ? (String) address.get("city") : null;

                if (name != null && city != null) {
                    String uniqueKey = city + "|" + name;
                    if (savedProperties.add(uniqueKey)) {
                        CityProperty cp = new CityProperty();
                        cp.setId(String.valueOf(hit.getId()));
                        cp.setCity(city);
                        cp.setPropertyName(name); // use the correct setter
                        batchToSave.add(cp);
                    }
                }

            }

            if (!batchToSave.isEmpty()) {
                cityPropertyRepository.saveAll(batchToSave);
                System.out.println("Saved batch of " + batchToSave.size() + " properties");
            }

            totalProcessed += searchHits.length;
            System.out.println("Total processed so far: " + totalProcessed);

            // Continue scrolling
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

        System.out.println("City-Property indexing completed successfully. Total properties processed: " + totalProcessed);
    }

    public List<CityProperty> getPropertiesByCity(String city) {
        return cityPropertyRepository.findByCity(city);
    }
}
