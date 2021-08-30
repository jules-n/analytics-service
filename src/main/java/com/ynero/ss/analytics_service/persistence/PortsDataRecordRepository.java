package com.ynero.ss.analytics_service.persistence;

import com.ynero.ss.analytics_service.domain.PortsDataRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PortsDataRecordRepository extends MongoRepository<PortsDataRecord, UUID> {
}
