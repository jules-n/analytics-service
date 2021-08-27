package com.ynero.ss.analytics_service.service.device;

import dtos.PortValueDTO;
import json_converters.DTOToMessageJSONConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class DeviceKafkaConsumer {

    private final DTOToMessageJSONConverter<PortValueDTO> converter;

    public DeviceKafkaConsumer(DTOToMessageJSONConverter<PortValueDTO> converter) {
        this.converter = converter;
    }


    @KafkaListener(topics = "device-data-for-save", groupId = "device-data-for-save_group_id")
    public void consume(String message) {
        PortValueDTO portValue= (PortValueDTO) converter.deserialize(message, PortValueDTO.class);
        log.info("new log: {}", portValue);
    }
}
