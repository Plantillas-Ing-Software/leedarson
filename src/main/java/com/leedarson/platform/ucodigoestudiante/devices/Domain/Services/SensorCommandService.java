package com.leedarson.platform.ucodigoestudiante.devices.Domain.Services;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Aggregate.Sensor;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Command.CreateSensorCommand;

import java.util.Optional;

/**
 * Service interface for handling sensor-related commands.
 * <p>
 *     This interface defines the contract for services that handle the creation of new sensors
 *     by processing commands. It provides a method to handle the creation of a new sensor based on
 *     the provided {@link CreateSensorCommand}.
 * </p>
 */
public interface SensorCommandService {

    /**
     * Handles the creation of a new sensor.
     * <p>
     *     This method processes the {@link CreateSensorCommand} to create a new sensor in the system.
     *     It returns an {@link Optional} containing the created {@link Sensor} if successful, or an empty
     *     {@link Optional} if the creation fails (e.g., due to existing sensor constraints).
     * </p>
     *
     * @param command the command containing the data required to create a new sensor
     * @return an {@link Optional} containing the created {@link Sensor} if successful, or an empty {@link Optional}
     * if the creation fails.
     */
    Optional<Sensor> handle(CreateSensorCommand command);
}
