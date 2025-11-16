package co.nz.csoft.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import co.nz.csoft.elasticsearch.model.HotelLocation;

public interface HotelLocationRepository extends ElasticsearchRepository<HotelLocation,String>{

}
