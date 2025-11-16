package co.nz.csoft.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import co.nz.csoft.elasticsearch.model.MmtRateUpdateLogDocument;


@Repository
public interface MmtRateUpdateLogRepository extends ElasticsearchRepository<MmtRateUpdateLogDocument, String> {
}
