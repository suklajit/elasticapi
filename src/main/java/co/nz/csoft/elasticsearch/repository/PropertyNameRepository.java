package co.nz.csoft.elasticsearch.repository;


import co.nz.csoft.elasticsearch.model.PropertyName;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyNameRepository extends ElasticsearchRepository<PropertyName, String> {
	Optional<PropertyName> findByName(String name);
}
