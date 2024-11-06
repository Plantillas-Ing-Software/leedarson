package com.leedarson.platform.ucodigoestudiante.devices.Applications.Internal.commandservices;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Exceptions.SensorAlreadyExistsException;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Aggregate.Sensor;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Command.CreateSensorCommand;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Services.SensorCommandService;
import com.leedarson.platform.ucodigoestudiante.devices.Infrastructure.persistence.jpa.repositories.SensorRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SensorCommandServiceImpl implements SensorCommandService {
    private final SensorRepository sensorRepository;

    public SensorCommandServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    /**
     * Handles the creation of a new sensor based on the provided {@code CreateSensorCommand}.
     * Validates that a sensor with the same combination of name, sensorTypeId, and manufacturer
     * does not already exist before proceeding with the sensor creation.
     *
     * @param command the command containing the sensor's details needed for creation.
     * @return an {@code Optional<Sensor>} containing the created sensor if successful, or an empty optional if not.
     * @throws IllegalArgumentException if a sensor with the specified combination already exists.
     */
    @Override
    public Optional<Sensor> handle(CreateSensorCommand command) {
        sensorRepository.findByNameAndSensorTypeIdAndManufacturer(
                        command.name(), command.sensorType().getId(), command.manufacturer())
                .ifPresent(sensor -> {
                    throw new SensorAlreadyExistsException("Sensor with the same name, sensor type, and manufacturer already exists.");
                });
        Sensor sensor = new Sensor(command);
        sensorRepository.save(sensor);

        return Optional.of(sensor);
    }
}
