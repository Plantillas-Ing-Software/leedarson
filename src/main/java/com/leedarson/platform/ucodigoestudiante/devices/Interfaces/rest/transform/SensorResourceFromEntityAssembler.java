package com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.transform;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Aggregate.Sensor;
import com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.resources.SensorResource;

/**
 * Assembler class for converting a {@link Sensor} entity to a {@link SensorResource}.
 * <p>
 *     This class is responsible for transforming the {@link Sensor} domain entity
 *     into a resource (DTO) that can be returned in API responses.
 * </p>
 */
public class SensorResourceFromEntityAssembler {

    /**
     * Converts a {@link Sensor} entity to a {@link SensorResource}.
     * <p>
     *     This method extracts the data from the {@link Sensor} entity and creates a
     *     {@link SensorResource} object, which is a representation of the sensor that is
     *     suitable for use in API responses.
     * </p>
     *
     * @param entity the {@link Sensor} entity that contains the sensor data
     * @return a {@link SensorResource} containing the same data in a form suitable for API responses
     */
    public static SensorResource toResourceFromEntity(Sensor entity) {
        return new SensorResource(
                entity.getId(),
                entity.getName(),
                entity.getSensorType(),
                entity.getDescription(),
                entity.getManufacturer(),
                entity.getReferenceImageUrl()
        );
    }
}