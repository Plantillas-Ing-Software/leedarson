package com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.transform;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Command.CreateSensorCommand;
import com.leedarson.platform.ucodigoestudiante.devices.Interfaces.rest.resources.CreateSensorResource;

/**
 * Assembler class for converting a {@link CreateSensorResource} to a {@link CreateSensorCommand}.
 * <p>
 *     This class is responsible for transforming the incoming resource (usually a DTO)
 *     into a command that can be processed by the domain service.</p>
 */
public class CreateSensorCommandFromResourceAssembler {

    /**
     * Converts a {@link CreateSensorResource} to a {@link CreateSensorCommand}.
     * <p>
     *     This method takes the data encapsulated in a {@link CreateSensorResource}
     *     and creates a {@link CreateSensorCommand} object that contains the necessary information
     *     for creating a new sensor in the system.
     * </p>
     *
     * @param resource the {@link CreateSensorResource} containing the sensor data
     * @return a {@link CreateSensorCommand} representing the same data in a form
     * suitable for processing by the command service.
     */
    public static CreateSensorCommand toCommandFromResource(CreateSensorResource resource) {
        return new CreateSensorCommand(
                resource.name(),
                resource.sensorType(),
                resource.description(),
                resource.manufacturer(),
                resource.referenceImageUrl()
        );
    }
}
