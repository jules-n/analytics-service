package com.ynero.ss.analytics_service.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.ynero.ss.analytics_service.domain.PortsDataRecord.COLLECTION_NAME;

@Data
@Document(collection = COLLECTION_NAME)
@RequiredArgsConstructor(onConstructor_ = {@PersistenceConstructor})
@SuperBuilder(toBuilder = true)
public class PortsDataRecord {
    public static final String COLLECTION_NAME = "port-s-data-record";
    private UUID recordId;
    private UUID deviceId;
    private String tenantId;
    private Port port;
    private LocalDateTime receivingTime;
    @CreatedDate
    private LocalDateTime creationTime;
    @Version
    private long version;
}
