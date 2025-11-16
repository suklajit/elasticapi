package co.nz.csoft.elasticsearch.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.nz.csoft.elasticsearch.model.MmtRateUpdateLogDocument;
import co.nz.csoft.elasticsearch.repository.MmtRateUpdateLogRepository;

import java.util.Optional;

@Service
public class MmtRateUpdateLogService {
   @Autowired
   MmtRateUpdateLogRepository repository;

    public MmtRateUpdateLogDocument save(MmtRateUpdateLogDocument log) {
        return repository.save(log);
    }

    public Optional<MmtRateUpdateLogDocument> findById(String uuid) {
        return repository.findById(uuid);
    }

    public Iterable<MmtRateUpdateLogDocument> findAll() {
        return repository.findAll();
    }

    public MmtRateUpdateLogDocument update(String uuid, MmtRateUpdateLogDocument updated) {
        if (!repository.existsById(uuid)) {
            throw new RuntimeException("Log not found: " + uuid);
        }
        updated.setUuid(uuid);
        return repository.save(updated);
    }

    public void delete(String uuid) {
        repository.deleteById(uuid);
    }
}