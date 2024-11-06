package com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Command;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Aggregate.Sensor;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Entities.SensorType;

/**
 * Command to create a new Sensor.
 * <p>
 *     This record represents the data needed to create a new {@link Sensor} entity.
 *     It contains the sensor's name, type, description, manufacturer, and reference image URL.
 * </p>
 */
public record CreateSensorCommand(
        String name,
        SensorType sensorType,
        String description,
        String manufacturer,
        String referenceImageUrl
) {}
