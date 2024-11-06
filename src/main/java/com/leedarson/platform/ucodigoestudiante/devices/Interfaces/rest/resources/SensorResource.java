package com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.resources;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Entities.SensorType;

/**
 * Represents a sensor resource in the system.
 * <p>
 *     This record serves as a data transfer object (DTO) that encapsulates the
 *     information of a sensor, including its unique identifier, name, type, description,
 *     manufacturer, and reference image URL.
 * </p>
 * <p>
 *     Used primarily for returning sensor details in API responses.
 * </p>
 */
public record SensorResource(
        Long id,
        String name,
        SensorType sensorType,
        String description,
        String manufacturer,
        String referenceImageUrl
) {}
