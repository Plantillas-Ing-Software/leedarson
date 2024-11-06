package com.leedarson.platform.ucodigoestudiante.devices.Domain.Model.Events;

import org.springframework.context.ApplicationEvent;

/**
 * SensorTypesPopulatedEvent
 * Event that represents the action of populating the sensor types in the database.
 */
public class SensorTypesPopulatedEvent extends ApplicationEvent {

    /**
     * Event Constructor
     * @param source The origin of the event
     */
    public SensorTypesPopulatedEvent(Object source) {
        super(source);
    }
}
