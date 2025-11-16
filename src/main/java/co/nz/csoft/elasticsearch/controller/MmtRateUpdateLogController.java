package co.nz.csoft.elasticsearch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.nz.csoft.elasticsearch.model.MmtRateUpdateLogDocument;
import co.nz.csoft.elasticsearch.service.MmtRateUpdateLogService;

@RestController
@RequestMapping("/api/rate-update-logs")
public class MmtRateUpdateLogController {
   @Autowired
   MmtRateUpdateLogService service;

    @PostMapping
    public MmtRateUpdateLogDocument create(@RequestBody MmtRateUpdateLogDocument log) {
        return service.save(log);
    }

    @GetMapping("/{uuid}")
    public MmtRateUpdateLogDocument get(@PathVariable String uuid) {
        return service.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Log not found: " + uuid));
    }

    @GetMapping
    public Iterable<MmtRateUpdateLogDocument> getAll() {
        return service.findAll();
    }

    @PutMapping("/{uuid}")
    public MmtRateUpdateLogDocument update(@PathVariable String uuid,
                                        @RequestBody MmtRateUpdateLogDocument log) {
        return service.update(uuid, log);
    }

    @DeleteMapping("/{uuid}")
    public String delete(@PathVariable String uuid) {
        service.delete(uuid);
        return "Deleted: " + uuid;
    }
}