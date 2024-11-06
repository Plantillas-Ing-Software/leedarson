package com.leedarson.platform.ucodigoestudiante.devices.Domain.Exceptions;

/**
 * Exception thrown when attempting to create a Sensor that already exists.
 * <p>
 * This exception is used to signal that a sensor with the same combination of
 * name, sensorTypeId, and manufacturer already exists in the system.
 * </p>
 */
public class SensorAlreadyExistsException extends RuntimeException{
    public SensorAlreadyExistsException(String message) {
        super(message);
    }
}
