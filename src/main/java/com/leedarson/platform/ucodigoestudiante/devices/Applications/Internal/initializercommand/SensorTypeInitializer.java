package com.leedarson.platform.ucodigoestudiante.devices.Applications.Internal.initializercommand;

import com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Events.SensorTypesPopulatedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;

@Component
public class SensorTypeInitializer{

    private final ApplicationContext applicationContext;

    public SensorTypeInitializer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Method that is executed when the application is ready.
     * Fires the event to populate the sensor types.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        applicationContext.publishEvent(new SensorTypesPopulatedEvent(this));
    }
}