package co.nz.csoft.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import co.nz.csoft.elasticsearch.model.CityProperty;

import java.util.List;

public interface CityPropertyRepository extends ElasticsearchRepository<CityProperty, String> {

    List<CityProperty> findByCity(String city);
}

