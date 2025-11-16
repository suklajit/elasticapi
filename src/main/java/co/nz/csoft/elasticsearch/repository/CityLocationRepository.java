package co.nz.csoft.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import co.nz.csoft.elasticsearch.model.CityLocation;

@Repository
public interface CityLocationRepository extends ElasticsearchRepository<CityLocation, String> {
}
