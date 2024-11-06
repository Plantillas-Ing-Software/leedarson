package com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.resources;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Aggregate.Sensor;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Entities.SensorType;

/**
 * Represents the data required to create a new {@link Sensor} in the system.
 * This record serves as a data transfer object (DTO) that encapsulates all the necessary
 * fields for creating a sensor, including its name, type, description, manufacturer,
 * and reference image URL.
 *
 * <p>
 *     Used primarily to receive sensor creation data in HTTP requests.
 * </p>
 */
public record CreateSensorResource(
        String name,
        SensorType sensorType,
        String description,
        String manufacturer,
        String referenceImageUrl
) {}
