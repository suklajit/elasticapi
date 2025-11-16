package co.nz.csoft.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import co.nz.csoft.elasticsearch.model.HotelSearchDocument;



public interface HotelSearchRepository extends ElasticsearchRepository<HotelSearchDocument,Long>{

}
