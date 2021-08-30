package com.ynero.ss.analytics_service.service.device;

import com.ynero.ss.analytics_service.domain.PortsDataRecord;
import com.ynero.ss.analytics_service.persistence.PortsDataRecordRepository;
import dtos.PortValueDTO;
import json_converters.DTOToMessageJSONConverter;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DeviceKafkaConsumer {

    private final DTOToMessageJSONConverter<PortValueDTO> converter;
    private final ModelMapper modelMapper;
    private final PortsDataRecordRepository repository;

    public DeviceKafkaConsumer(DTOToMessageJSONConverter<PortValueDTO> converter, ModelMapper modelMapper, PortsDataRecordRepository repository) {
        this.converter = converter;
        this.modelMapper = modelMapper;
        this.repository = repository;
    }


    @KafkaListener(topics = "device-data-for-save", groupId = "device-data-for-save_group_id")
    public void consume(String message) {
        PortValueDTO portValue = (PortValueDTO) converter.deserialize(message, PortValueDTO.class);
        var portsDataRecord = modelMapper.map(portValue, PortsDataRecord.class);
        portsDataRecord = repository.save(portsDataRecord);
        log.info("new log: {}", portsDataRecord);
    }
}
