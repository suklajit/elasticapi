package co.nz.csoft.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import co.nz.csoft.elasticsearch.model.PropertySearchDocument;
import co.nz.csoft.elasticsearch.thm.dto.ThmPropertyDto;

public interface PropertySearchDocumentRepository extends ElasticsearchRepository<PropertySearchDocument, Long>{

	void save(ThmPropertyDto thmPropertyDto);

}
