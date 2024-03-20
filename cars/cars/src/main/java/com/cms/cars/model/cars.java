package com.cms.cars.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public record cars(
        @Id
        String id,
        String type,
        String manufactureDate,
        String company,
        String Model,
        double cost,
        String carName,
        boolean insurance
) {}
