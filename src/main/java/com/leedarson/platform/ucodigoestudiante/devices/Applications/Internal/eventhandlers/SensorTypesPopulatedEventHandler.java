package com.leedarson.platform.ucodigoestudiante.devices.Applications.Internal.eventhandlers;


import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Entities.SensorType;
import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Events.SensorTypesPopulatedEvent;
import com.leedarson.platform.ucodigoestudiante.devices.Infrastructure.persistence.jpa.repositories.SensorTypeRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * SensorTypesPopulatedEventHandler
 * <p>
 * This event handler is responsible for handling the SensorTypesPopulatedEvent event.
 * Listen for the event and perform checks to populate the sensor_types table if necessary.
 * </p>
 */
@Service
public class SensorTypesPopulatedEventHandler {

    private final SensorTypeRepository sensorTypeRepository;

    public SensorTypesPopulatedEventHandler(SensorTypeRepository sensorTypeRepository) {
        this.sensorTypeRepository = sensorTypeRepository;
    }

    /**
     * Method that is executed when the SensorTypesPopulatedEvent event is received.
     * It checks if the sensor_types table is empty and, if so, populates it with the default values.
     *
     * @param event The event that indicates that sensor types should be populated.
     */
    @EventListener(SensorTypesPopulatedEvent.class)
    public void on(SensorTypesPopulatedEvent event) {
        if (sensorTypeRepository.count() == 0) {
            sensorTypeRepository.save(new SensorType(1L, "Temperature"));
            sensorTypeRepository.save(new SensorType(2L, "Motion"));
            sensorTypeRepository.save(new SensorType(3L, "Humidity"));
            System.out.println("The sensor_types table has been populated.");
        }
    }
}
