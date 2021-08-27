package com.ynero.ss.analytics_service.domain;

import dtos.PortValueDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
public class PortValue extends PortValueDTO {
}
